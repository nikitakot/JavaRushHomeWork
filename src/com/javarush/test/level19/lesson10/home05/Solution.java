package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName1 = args[0];
        String fileName2 = args[1];
        BufferedReader lineReader = new BufferedReader(new FileReader(fileName1));
        ArrayList<String> list = new ArrayList<>();
        String line = lineReader.readLine();
        while (line!=null)
        {
            list.add(returnString(line));
            line=lineReader.readLine();
        }
        lineReader.close();
        PrintWriter lineWriter = new PrintWriter(new FileWriter(fileName2));
        for (String i : list)
        {
            lineWriter.println(i);
        }
        lineWriter.close();
    }

    public static String returnString(String line)
    {
        String[] arr = line.split(" ");
        String newString="";
        for (int i = 0;i<arr.length;i++)
        {
            if (!arr[i].replaceAll("\\D","").equals(""))
            {
                newString+=arr[i]+" ";
            }
        }
        return newString.trim();
    }
}
