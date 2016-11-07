package com.javarush.test.level04.lesson16.home04;

import java.io.*;

/* Меня зовут 'Вася'...
Ввести с клавиатуры строку name.
Ввести с клавиатуры дату рождения (три числа): y, m, d.
Вывести на экран текст:
«Меня зовут name
Я родился d.m.y»
Пример:
Меня зовут Вася
Я родился 15.2.1988
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String n1string = reader.readLine();
        String n2string = reader.readLine();
        String n3string = reader.readLine();
        int y = Integer.parseInt(n1string);
        int m = Integer.parseInt(n2string);
        int d = Integer.parseInt(n3string);
        System.out.println("Меня зовут "+name);
        System.out.print("Я родился "+d+"."+m+"."+y);
    }
}
