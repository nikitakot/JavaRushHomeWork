package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args)
    {
        try
        {
            FileInputStream inputStream = new FileInputStream(args[0]);
            int count = 0;
            char tmp;
            while (inputStream.available() > 0)
            {
                tmp = (char) inputStream.read();
                if ((tmp >= 'a' && tmp <= 'z') || (tmp >= 'A' && tmp <= 'Z'))
                    count++;
            }
            System.out.println(count);
            inputStream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
