package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
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
        int a = Integer.parseInt(as);
        int b = Integer.parseInt(bs);
        int c = Integer.parseInt(cs);

        int tmp;
        if (a < b)
        {
            tmp = a;//tmp присваевается значение а(1)
            a = b;//а присваевается б(2)
            b = tmp;//б присваевается тмп(1)
        }
        if (a < c)
        {
            tmp = a;//тмп присваевается а(2)
            a = c;//а присваевается значение с(3)
            c = tmp;//с присваевается значение тмп(2)
        }
        if (b < c)
        {
            tmp = b;//тмп присваевается б(1)
            b = c;//б присваевается с(2)
            c = tmp;//с присваевается (1)
        }
        System.out.println(a +" "+b+" "+c);


    }
}
