package com.javarush.test.level16.lesson13.home09;

/* Только по-очереди!
1. В классе Solution создать нить public static Read3Strings унаследовавшись от Thread.
2. В методе run реализовать чтение с консоли трех строк.
3. Три подряд введенных строки должны считываться в одной нити и объединяться в одну строку через пробел.
4. В методе main вывести результат для каждой нити.
5. Используйте join

Пример:
Входные данные
a
b
c
d
e
f
Выходные данные:
a b c
d e f
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        System.out.println(/*print t1 result here*/);
        System.out.println(/*print t2 result here*/);
    }
    public static class Read3Strings extends Thread{
        public void run(){
            String string1 = null;
            String string2 = null;
            String string3 = null;
            try
            {
                string1 = reader.readLine();
                string2 = reader.readLine();
                string3 = reader.readLine();
            }catch (Exception e){

            }
            System.out.println(string1+" "+string2+" "+string3);
        }
    }
}
