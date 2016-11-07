package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i<10;i++)
        map.put("Hui"+i, "Govno"+i);
        return (HashMap)map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {

        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String key = pair.getValue();
            if (key.equals(name))
                ++count;
        }
        return count;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String key = pair.getKey();
            if (key.equals(lastName))
                ++count;
        }
        return count;

    }
}
