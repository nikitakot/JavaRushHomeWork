package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String n1string = reader.readLine();
        String n2string = reader.readLine();
        String n3string = reader.readLine();
        int a = Integer.parseInt(n1string);
        int b = Integer.parseInt(n2string);
        int c = Integer.parseInt(n3string);

        if(a<b && b<c && a<c)
            System.out.println(b);
        if(b<c && c<a && b<c)
            System.out.println(c);
        if(c<a && a<b && c<b)
            System.out.println(a);
    }
}
