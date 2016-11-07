package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String fileName = reader.readLine();
            FileInputStream fileInputStream = new FileInputStream(fileName);
            int count = 0;
            while (fileInputStream.available()>0){
                if (fileInputStream.read()==44){
                    count++;
                }
            }
        System.out.print(count);
            reader.close();
            fileInputStream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}
