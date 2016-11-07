package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        String fileName1 = args[0];
        String fileName2 = args[1];
        BufferedReader lineReader = new BufferedReader(new FileReader(fileName1));
        PrintWriter lineWriter = new PrintWriter(new FileWriter(fileName2));
        String line = lineReader.readLine();
        while (line!=null)
        {
            addWords(line);
            line = lineReader.readLine();
        }
        lineReader.close();
        for(int i = 0; i<list.size();i++)
        {

            lineWriter.print( i==list.size()-1 ? list.get(i) : list.get(i)+",");

            /*if(i==list.size()-1)
            {
                lineWriter.print(list.get(i));
            }
            else
            {
                lineWriter.print(list.get(i)+",");
            }*/
        }
        lineWriter.close();
    }

    public static void addWords(String line)
    {
        String[] arr = line.split(" ");
        for (int i = 0;i<arr.length;i++)
        {
            if (arr[i].length()>6)
            {
                list.add(arr[i]);
            }
        }
    }
}
