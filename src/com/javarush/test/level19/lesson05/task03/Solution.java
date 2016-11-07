package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1= reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        BufferedReader lineReader = new BufferedReader(new FileReader(fileName1));
        String line;
        ArrayList<String> arrayList = new ArrayList<>();
        line = lineReader.readLine();
        while (line!=null)
        {
            arrayList.add(line);
            line = lineReader.readLine();
        }
        lineReader.close();
        FileWriter fileWriter = new FileWriter(fileName2);
        for(String s:arrayList)
        {
            String[] arr = s.split(" ");
            for (String digi:arr)
            {
                if(isInt(digi))
                {
                    fileWriter.write(digi+" ");
                }
            }

        }
        fileWriter.close();
    }

    public static boolean isInt (String s)
    {
        try
        {
            Integer.parseInt(s);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
