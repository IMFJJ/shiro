package com.study.io;

import java.io.FileWriter;
import java.io.IOException;

public class FireWriterDemo {
    public static void main(String[] args) throws IOException {             //需要对IO异常进行处理

        //创建一个FileWriter对象，该对象一被初始化就必须要明确被操作的文件。
        //而且该文件会被创建到指定目录下。如果该目录有同名文件，那么该文件将被覆盖。

        FileWriter fw = new FileWriter("D:\\1.doc");//目的是明确数据要存放的目的地。

        //调用write的方法将字符串写到流中
        fw.write("hello world!");

        //刷新流对象缓冲中的数据，将数据刷到目的地中
        fw.flush();

        //关闭流资源，但是关闭之前会刷新一次内部缓冲中的数据。当我们结束输入时候，必须close();
        fw.write("first_test");
        fw.close();
        //flush和close的区别：flush刷新后可以继续输入，close刷新后不能继续输入。

    }
}
