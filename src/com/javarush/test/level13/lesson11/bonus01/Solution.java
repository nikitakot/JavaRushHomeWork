package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader vstupZn = new FileReader(reader.readLine());
        BufferedReader vstupRad = new BufferedReader(vstupZn);
        ArrayList<Integer> list = new ArrayList<Integer>();
        String radek;
        while((radek = vstupRad.readLine()) != null){
            if (Integer.parseInt(radek)%2==0)
            {
                list.add(Integer.parseInt(radek));
            }
        }

        Collections.sort(list);
        for (int i : list)
        {
            System.out.println(i);
        }


    }
}
