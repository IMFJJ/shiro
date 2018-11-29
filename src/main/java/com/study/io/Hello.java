package com.study.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Hello {
    public static void main(String[] args) throws IOException {
        //最简单
//        String fileName="D:"+File.separator+"hello.txt";
//        File f=new File(fileName);
//        InputStream in=new FileInputStream(f);
//        byte[] b=new byte[1024];
//        in.read(b);
//        in.close();
//        System.out.println(new String(b)+1);
        //改善了byte[] b=new byte[(int) f.length()];申请空间
//        String fileName="D:"+File.separator+"hello.txt";
//        File f=new File(fileName);
//        InputStream in=new FileInputStream(f);
//        byte[] b=new byte[(int) f.length()];
//        int len=in.read(b);
//        in.close();
//        System.out.println("读入长度为："+len);
//        System.out.println(new String(b,0,len));

        String fileName="D:"+File.separator+"hello.txt";
        File f=new File(fileName);
        InputStream in=new FileInputStream(f);
        byte[] b=new byte[(int)f.length()];
        in.read(b);
        System.out.println("文件长度为："+f.length());
        in.close();
        System.out.println(new String(b));
    }
}
