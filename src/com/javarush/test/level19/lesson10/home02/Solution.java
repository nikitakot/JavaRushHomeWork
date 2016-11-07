package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = args[0];
        BufferedReader lineReader = new BufferedReader(new FileReader(fileName));
        String line = lineReader.readLine();
        TreeMap<String, Double> map = new TreeMap<>();
        while (line!=null)
        {
            String[] param = line.split(" ");
            String name = param[0];
            Double value = Double.parseDouble(param[1]);
            if(map.containsKey(name))
            {
                map.put(name, map.get(name)+value);
            }
            else
            {
                map.put(name, value);
            }
            line=lineReader.readLine();
        }
        lineReader.close();
        for(Map.Entry<String, Double> i : map.entrySet())
        {
            if(i.getValue()==findMax(map))
            {
                System.out.println(i.getKey());
            }
        }

    }

    public static double findMax(TreeMap<String, Double> map) throws Exception
    {
        double temp = map.get(map.lastKey());
        for(Map.Entry<String, Double> i : map.entrySet())
        {
            if(i.getValue()>temp)
            {
                temp=i.getValue();
            }
        }
        return temp;
    }
}
