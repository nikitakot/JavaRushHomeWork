package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String n1string = reader.readLine();
        String n2string = reader.readLine();
        int n1int = Integer.parseInt(n1string);
        int n2int = Integer.parseInt(n2string);
        if (n1int<n2int)
            System.out.println(n1int);
        else
            System.out.println(n2int);
    }
}