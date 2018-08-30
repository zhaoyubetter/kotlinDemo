package com.better.json.deserialize
import java.io.Reader

class Parser(reader: Reader, val rootObject: JsonObject) {
    private val lexer = Lexer(reader)

    fun parse() {
        expect(Token.LBRACE)
        parseObjectBody(rootObject)
        if (lexer.nextToken() != null) {
            throw IllegalArgumentException("Too many tokens")
        }
    }

    private fun parseObjectBody(jsonObj: JsonObject) {
        // 解析json如： { "name" : "better" }
        parseCommaSeparated(Token.RBRACE) { token ->
            // key 都是 String 类型的 token
            if (token !is Token.StringValue) {
                throw MalformedJSONException("Unexpected token $token")
            }

            val propName = token.value      // String token 值，如：{ "name" : "better" } 中的name
            expect(Token.COLON)             // : 冒号
            // 解析值
            parsePropertyValue(jsonObj, propName, nextToken())
        }
    }

    private fun parseArrayBody(currentObject: JsonObject, propName: String) {
        parseCommaSeparated(Token.RBRACKET) { token ->
            parsePropertyValue(currentObject, propName, token)
        }
    }

    /**
     * 根据逗号分隔，进行json解析
     */
    private fun parseCommaSeparated(stopToken: Token, body: (Token) -> Unit) {
        var expectComma = false  // ,
        while (true) {
            var token = nextToken()  // 获取下一个标记
            if (token == stopToken) return
            if (expectComma) {
                if (token != Token.COMMA) throw MalformedJSONException("Expected comma")
                token = nextToken()
            }

            body(token)     // 执行 lambda

            expectComma = true
        }
    }

    /**
     * 解析json值，值只有3种类型
     */
    private fun parsePropertyValue(currentObject: JsonObject, propName: String, token: Token) {
        when (token) {
            // 简单值
            is Token.ValueToken ->
                currentObject.setSimpleProperty(propName, token.value)

            // {  对象
            Token.LBRACE -> {
                val childObj = currentObject.createObject(propName)
                parseObjectBody(childObj)
            }

            // [  數組
            Token.LBRACKET -> {
                val childObj = currentObject.createArray(propName)
                parseArrayBody(childObj, propName)
            }

            else ->
                throw MalformedJSONException("Unexpected token $token")
        }
    }

    private fun expect(token: Token) {
        if (lexer.nextToken() != token) {
            throw IllegalArgumentException("$token expected")
        }
    }

    private fun nextToken(): Token = lexer.nextToken() ?: throw IllegalArgumentException("Premature end of data")
}
