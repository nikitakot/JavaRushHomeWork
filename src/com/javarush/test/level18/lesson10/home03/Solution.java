package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String fileNameOne = reader.readLine();
            String fileNameTwo = reader.readLine();
            String fileNameThree = reader.readLine();
            FileInputStream fileInputStreamFileTwo = new FileInputStream(fileNameTwo);
            FileInputStream fileInputStreamFileThree = new FileInputStream(fileNameThree);
            FileOutputStream fileOutputStreamFileOne = new FileOutputStream(fileNameOne);
            byte[] bufferFileTwo = new byte[fileInputStreamFileTwo.available()];
            if(fileInputStreamFileTwo.available()>0){
                int countFileTwo = fileInputStreamFileTwo.read(bufferFileTwo);
                fileOutputStreamFileOne.write(bufferFileTwo, 0, countFileTwo);
            }
            byte[] bufferFileThree = new byte[fileInputStreamFileThree.available()];
            if(fileInputStreamFileThree.available()>0){
                int countFileThree = fileInputStreamFileThree.read(bufferFileThree);
                fileOutputStreamFileOne.write(bufferFileThree, 0, countFileThree);
            }
            reader.close();
            fileInputStreamFileThree.close();
            fileInputStreamFileTwo.close();
            fileOutputStreamFileOne.close();
        }

        catch (Exception e){

        }
    }
}
