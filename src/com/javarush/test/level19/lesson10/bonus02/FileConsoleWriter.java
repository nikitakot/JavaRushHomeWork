package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter  extends FileWriter{

    public static void main(String[] args) throws IOException
    {
        FileConsoleWriter fileConsoleWriter = new FileConsoleWriter("C:\\Users\\Nikita\\Desktop\\javatests\\1.txt");
        fileConsoleWriter.write("123456789".toCharArray(), 2, 5);
        fileConsoleWriter.write("123456789");
        fileConsoleWriter.write(9999);
        fileConsoleWriter.write("qwertyu", 2, 5);
        fileConsoleWriter.write("dfghj".toCharArray());
        fileConsoleWriter.flush();
        fileConsoleWriter.close();
    }

    public FileConsoleWriter(String fileName) throws IOException
    {
        super(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException
    {
        super(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException
    {
        super(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException
    {
        super(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd)
    {
        super(fd);
    }


    @Override
    public void write(int c) throws IOException
    {
        System.out.print((char) c);
        super.write(c);
    }

    /*@Override
    public void write(char[] cbuf) throws IOException
    {
        super.write(cbuf);
    }*/

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException
    {
        System.out.print(new String(cbuf).substring(off, off+len));
        super.write(cbuf, off, len);
    }

    /*@Override
    public void write(String str) throws IOException
    {
        super.write(str);
    }*/

    @Override
    public void write(String str, int off, int len) throws IOException
    {
        System.out.print(str.substring(off,off+len));
        super.write(str, off, len);
    }
}
