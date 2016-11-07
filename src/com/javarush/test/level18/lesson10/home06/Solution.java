package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (fileInputStream.available()>0){
            int kay = fileInputStream.read();
            if(map.containsKey(kay)){
                int value = map.get(kay);
                map.put(kay, ++value);
            }
            else map.put(kay, 1);
        }
        for(Map.Entry<Integer, Integer> pair : map.entrySet()){
            int m = pair.getKey();
            char l = (char) m;
            System.out.println(l+" "+pair.getValue());
        }
        fileInputStream.close();
    }
}
