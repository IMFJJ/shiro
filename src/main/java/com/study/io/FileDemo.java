package com.study.io;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/*
java.io.用于表示文件（目录）
File类只用于表示文件（目录）的信息（大小，名称等），不能用于文件内容的访问
 */
public class FileDemo {
    public static void main(String args[])  {
        //了解构造函数的情况   查帮助D:\360安全浏览器下载\s
        File file1 = new File("");
        //File.separator设置分隔符
//        File file = new File("e:"+File.separator);
//        System.out.println(f.exists());//判断文件（目录是否存在）
        //判断文件（目录是否存在），不存在则直接创建
        if (!file1.exists())
            //创建目录
            file1.mkdir();
//        //创建多级目录
//            file1.mkdirs();
        else
            file1.delete();
        //判断是否是一个文件
        System.out.println(file1.isFile());
        //判断是否是一个目录
        System.out.println(file1.isDirectory());
//        File file2 = new File("D:\\360安全浏览器下载\\日记1.txt");
        File file2 = new File("D:\\360安全浏览器下载","日记1.txt");
        ByteBuffer buffer = ByteBuffer.allocate(48);
        if(!file2.exists()){
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else
            file2.delete();

        //file常用的API
        System.out.println(file2);//输出file2.toString的内容
        System.out.println(file2.getAbsolutePath());//输出路径D:\360安全浏览器下载\日记1.txt
        System.out.println(file2.getName());//日记1.txt
        System.out.println(file2.getParent());//输出父路径D:\360安全浏览器下载
        System.out.println(file2.getParentFile().getAbsolutePath());//输出父路径D:\360安全浏览器下载


    }
}