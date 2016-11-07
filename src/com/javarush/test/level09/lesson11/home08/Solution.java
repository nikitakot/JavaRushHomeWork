package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        ArrayList<int[]> list = new ArrayList<int[]>();
        int[] i5 = new int[5];
        for (int i=0;i<i5.length;i++)
            i5[i] = (int) ( Math.random()*100);
        int[] i2 = new int[2];
        for (int i=0;i<i2.length;i++)
            i2[i] = (int) ( Math.random()*100);
        int[] i4 = new int[4];
        for (int i=0;i<i4.length;i++)
            i4[i] = (int) ( Math.random()*100);
        int[] i7 = new int[7];
        for (int i=0;i<i7.length;i++)
            i7[i] = (int) ( Math.random()*100);
        int[] i0 = new int[0];
        for (int i=0;i<i0.length;i++)
            i0[i] = (int) ( Math.random()*100);
        list.add(i5);
        list.add(i2);
        list.add(i4);
        list.add(i7);
        list.add(i0);
        return list;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
