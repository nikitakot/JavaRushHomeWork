package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        StringBuilder reverse;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        BufferedReader lineReader = new BufferedReader(new FileReader(fileName));
        String line = lineReader.readLine();
        while (line!=null)
        {
            reverse = new StringBuilder(line);
            list.add(reverse.reverse().toString());
            line=lineReader.readLine();
        }
        lineReader.close();
        /*PrintWriter printWriter = new PrintWriter(new FileWriter(fileName));*/
        for (String i : list)
        {
            /*printWriter.println(i);*/
            System.out.println(i);
        }
        /*printWriter.close();*/
    }
}
