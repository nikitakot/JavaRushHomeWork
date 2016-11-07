package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            String fileName3 = reader.readLine();
            FileInputStream fileInputStream = new FileInputStream(fileName1);
            FileOutputStream fileOutputStream2 = new FileOutputStream(fileName2);
            FileOutputStream fileOutputStream3 = new FileOutputStream(fileName3);
            if(fileInputStream.available()>0){
            byte[] buffer = new byte[fileInputStream.available()];
            int count = fileInputStream.read(buffer);

                fileOutputStream2.write(Arrays.copyOfRange(buffer, 0, buffer.length/2));
                fileOutputStream3.write(Arrays.copyOfRange(buffer, buffer.length/2, buffer.length));
            }
            reader.close();
            fileInputStream.close();
            fileOutputStream2.close();
            fileOutputStream3.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
