package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String tmp = reader.readLine();
        String link = tmp.substring(tmp.indexOf("?")+1);
        String[] arr = link.split("&");
        for (int i = 0; i<arr.length;i++){
            if (arr[i].contains("="))
            {
                System.out.print(arr[i].substring(0,arr[i].indexOf("=")));
                System.out.print(" ");

            }
            else if (!arr[i].contains("="))
            {
                System.out.print(arr[i]);
                System.out.print(" ");
            }
        }
        System.out.println();
        for (int i = 0; i<arr.length;i++){
            if (arr[i].contains("=")){
                try{
                    if ((arr[i].substring(0,arr[i].indexOf("=")).equals("obj")))
                    {
                        alert(Double.parseDouble(arr[i].substring(arr[i].indexOf("obj=")+4)));
                    }
                }catch (Exception e)
                {
                    alert(arr[i].substring(arr[i].indexOf("obj=")+4));
                }
            }
        }



    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
