package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] big = new int[20];
        for (int i = 0; i<big.length; i++)
        {
            big[i]=Integer.parseInt(reader.readLine());
        }
        int[] small_1 = new int[10];
        int[] small_2 = new int[10];
        for (int i=0; i<small_1.length;i++)
        {
            small_1[i]=big[i];
        }
        for (int i=0;i<small_2.length;i++)
        {
            small_2[i]=big[big.length-small_1.length+i];
        }
        for (int i=0;i<small_2.length;i++)
        System.out.println(small_2[i]);

    }
}
