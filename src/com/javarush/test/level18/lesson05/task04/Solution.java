package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
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
            FileInputStream fileInputStream = new FileInputStream(fileNameOne);
            FileOutputStream fileOutputStream = new FileOutputStream(fileNameTwo);
            byte[] buffer = new byte[fileInputStream.available()];
            while (fileInputStream.available()>0){
                fileInputStream.read(buffer);
                for (int i = 0; i < buffer.length / 2; i++) {
                    byte temp = buffer[i];
                    buffer[i] = buffer[buffer.length - 1 - i];
                    buffer[buffer.length - 1 - i] = temp;
                }
                fileOutputStream.write(buffer);
            }
            reader.close();
            fileInputStream.close();
            fileOutputStream.close();
        }
        catch (Exception e){

        }

    }
}
