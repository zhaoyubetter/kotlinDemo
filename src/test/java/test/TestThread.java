package test;


import org.junit.Test;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用多线程遍历目录，并找到对应的文件
 */
public class TestThread {

    final String path = "D:\\";
    final String toFindFileName = "jdme_activity_address_search.xml";

    // 10个线程
    final ExecutorService executor = Executors.newFixedThreadPool(10);

    public final static Object obj = new Object();
    boolean isFinish = false;


    @Test
    public void test1() throws Exception {
        go(path, toFindFileName);
    }

    void go(String path, String toFindFileName) throws Exception {
        File file = new File(path);
        if (file.exists()) {
            File[] curFiles = file.listFiles();
            if (curFiles != null && curFiles.length > 0) {
                for (int i = 0; i < curFiles.length; i++) {
                    executor.execute(new FileTask(curFiles[i].getAbsolutePath(), toFindFileName, i == curFiles.length - 1));
                }
            }
        }
        synchronized (obj) {
            while (!isFinish) {
                obj.wait();
            }
            executor.shutdownNow();
        }
    }

    class FileTask implements Runnable {
        String filePath;
        String toFindFilename;
        boolean isLastDir;

        public FileTask(String filepath, String toFindFilename, boolean isLastDir) {
            this.filePath = filepath;
            this.toFindFilename = toFindFilename;
            this.isLastDir = isLastDir;
        }

        @Override
        public void run() {
            each(new File(filePath), filePath);
        }

        private void each(File file, final String filePath) {
            if (file.exists()) {
                System.out.println(Thread.currentThread().getName() + " 正在处理");
                if (file.isDirectory()) {
                    System.out.println("-----> " + file.getName() + " 是一个文件夹");
                    File[] curFiles = file.listFiles();
                    if (curFiles != null && curFiles.length > 0) {
                        for (File f : curFiles) {
                            each(f, filePath);
                        }
                    }
                } else {
                    System.out.println("-----> " + file.getName() + " 是一个文件");
                    if (file.getName().equals(toFindFilename)) {
                        System.out.println("==》找到了，路径为：" + file.getAbsolutePath());
                        // 递归结束，找到了，直接结束
                        synchronized (obj) {
                            isFinish = true;
                            obj.notify();
                        }
                    }
                }
            }

            // 递归结束，并且是最后一个文件时，即没有找到时
            if (file.getAbsolutePath().equals(filePath) && isLastDir) {
                synchronized (obj) {
                    isFinish = true;
                    obj.notify();
                }
            }
        }
    }
}
