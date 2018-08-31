package cz.sample.kotlin.companion_

// 类中放置比较器
data class Person(val name: String) {

    // 直接放入类中
    object NameComparator : Comparator<Person> {
        override fun compare(o1: Person, o2: Person): Int {
            return o1.name.compareTo(o2.name)
        }
    }
}

fun main(args: Array<String>) {
    val persons = listOf(Person("Better"), Person("Chelsea"), Person("Alice"))
    println(persons.sortedWith(Person.NameComparator))
}