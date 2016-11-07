package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<Integer,Integer> list = new HashMap<Integer,Integer>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());
            /*если байта нет добавляем в МАП если есть то к value этого байты добавляем 1*/
        while (fileInputStream.available()>0){
            int kay = fileInputStream.read();
            if(list.containsKey(kay)){
                int value = list.get(kay);
                list.put(kay, ++value);
            }
            else list.put(kay, 1);
        }

        int tempValue=0;
        for(Map.Entry<Integer, Integer> l:list.entrySet()){
            if(tempValue<l.getValue())
                tempValue = l.getValue();
        }
            /*Выводим байт с наибольшим повторением, если таких байт несколько то выводим их*/
        for(Map.Entry<Integer, Integer> l:list.entrySet()){
            if(l.getValue()==tempValue)
                System.out.print(l.getKey()+" ");
        }
        bufferedReader.close();
        fileInputStream.close();
    }
}