package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(fileName);
        String buff="";
        while (fileReader.ready())
        {
            buff+=String.valueOf((char)fileReader.read());
        }
        fileReader.close();

        buff = buff.replaceAll("\\p{Punct}", " ");
        buff = buff.replaceAll("\\s+", " ");
        String[] arr = buff.split(" ");
        int count = 0;
        for (String i : arr)
        {
            if (i.equals("world"))
            {
                count++;
            }
        }

        System.out.println(count);

    }
}
