/*
package com.study.util;

import java.io.*;

public class IOUnit {

    */
/**
     * �ļ��������ֽ�������ȡ
     * @param srcFile
     * @param destFile
     * @throws IOException
     *//*

    public static void copyFile(File srcFile,File destFile)throws IOException{
        if(!srcFile.exists()){
            throw new IllegalArgumentException("�ļ�:"+srcFile+"������");
        }
        if(!srcFile.isFile()){
            throw new IllegalArgumentException(srcFile+"�����ļ�");
        }
        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(destFile);
        byte[] buf = new byte[8*1024];
        int b ;
        while((b = in.read(buf,0,buf.length))!=-1){
            out.write(buf,0,b);
            out.flush();//��ü���
        }
        in.close();
        out.close();

    }
    */
/**
     * �����ȡ�ֽ�
     * @param srcFile
     * @param destFile
     * @throws IOException
     *//*

    public static void copyByBuffer(File srcFile,File destFile) throws IOException {
        if (!srcFile.exists()){
            throw new IllegalArgumentException("�ļ�:"+srcFile+"������");
        }
        if (!srcFile.isFile()){
            throw new IllegalArgumentException(srcFile+"�����ļ�");
        }
        BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(destFile));

        int c;
        while ((c=bufferedInputStream.read())!=-1){
            bufferedOutputStream.write(c);
            bufferedOutputStream.flush();
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
    */
/**
     * ���ֽڣ�������������ļ�����
     * @param srcFile
     * @param destFile
     * @throws IOException
     *//*

    public static void copyFileByByte(File srcFile,File destFile)throws IOException{
        if(!srcFile.exists()){
            throw new IllegalArgumentException("�ļ�:"+srcFile+"������");
        }
        if(!srcFile.isFile()){
            throw new IllegalArgumentException(srcFile+"�����ļ�");
        }
        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(destFile);
        int c ;
        while((c = in.read())!=-1){
            out.write(c);
            out.flush();
        }
        in.close();
        out.close();
    }
}
*/
