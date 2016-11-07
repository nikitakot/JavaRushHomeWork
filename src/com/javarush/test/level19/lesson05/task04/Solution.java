package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();
        BufferedReader lineReader = new BufferedReader(new FileReader(fileName1));
        String line = lineReader.readLine();
        ArrayList<String> lineList = new ArrayList<String>();
        while (line!=null)
        {
            lineList.add(line);
            line = lineReader.readLine();
        }
        lineReader.close();
        for (int i = 0; i<lineList.size();i++)
        {
            lineList.set(i, lineList.get(i).replace( ".", "!"));
        }
        PrintWriter printWriter = new PrintWriter(fileName2);
        for(String i : lineList)
        {
            printWriter.println(i);
        }
        printWriter.close();
    }
}
