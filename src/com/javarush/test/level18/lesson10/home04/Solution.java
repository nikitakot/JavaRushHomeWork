package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/


import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String fileNameOne = reader.readLine();
            String fileNameTwo = reader.readLine();
            FileInputStream fileInputStreamOne = new FileInputStream(fileNameOne);
            FileInputStream fileInputStreamTwo = new FileInputStream(fileNameTwo);

            byte[] bufferOne = new byte[fileInputStreamOne.available()];
            int count1 = 0;
            while (fileInputStreamOne.available()>0){
                count1 = fileInputStreamOne.read(bufferOne);
            }
            FileOutputStream fileOutputStreamOne = new FileOutputStream(fileNameOne, false);
            byte[] bufferTwo = new byte[fileInputStreamTwo.available()];
            int count2 = 0;
            while (fileInputStreamTwo.available()>0){
                 count2 = fileInputStreamTwo.read(bufferTwo);
            }
            fileOutputStreamOne.write(bufferTwo, 0, count2);
            fileOutputStreamOne.write(bufferOne, 0, count1);

            fileInputStreamOne.close();
            fileInputStreamTwo.close();
            fileOutputStreamOne.close();
            reader.close();


        }
        catch (Exception e){

        }
    }
}
