package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String as = reader.readLine();
        String bs = reader.readLine();
        String cs = reader.readLine();
        String ds = reader.readLine();
        int a = Integer.parseInt(as);
        int b = Integer.parseInt(bs);
        int c = Integer.parseInt(cs);
        int d = Integer.parseInt(ds);

        if (a>b && a>c && a>d)
            System.out.println(a);
        else if (b>a && b>c && b>d)
                System.out.println(b);
        else if (c>a && c>d && c>b)
            System.out.println(c);
        else if (d>a && d>b && d>c)
            System.out.println(d);

    }
}
