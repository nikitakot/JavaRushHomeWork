package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    static TreeMap<Integer, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws Exception {
        gg(args[0],getString());
    }

    public static void gg(String tag, String s)
    {
        String openedTag = "<" + tag;
        String closedTag = "</" + tag;
        int tagLength = tag.length();
        int openTag = 0;
        while (openTag!=-1)
        {
            openTag = s.indexOf(openedTag, openTag);
            int closeTag = s.indexOf(closedTag, openTag+tagLength);
            int insideTag = openTag + tagLength;
            if(closeTag!=-1)
            {
                while (s.substring(insideTag,closeTag).contains(openedTag))
                {
                    insideTag = closeTag + tagLength;
                    closeTag = s.indexOf(closedTag, insideTag);
                }
            }
            if(openTag !=-1 && closeTag != -1)
            {
                map.put(openTag,closeTag);
                openTag+=tagLength;
            }
        }
        for(Map.Entry<Integer, Integer> pair : map.entrySet())
        {
            System.out.println(s.substring(pair.getKey(), pair.getValue())+"</"+tag+">");
        }
    }

    public static String getString() throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(fileName);
        String buff="";
        while (fileReader.ready())
        {
            buff+=String.valueOf((char)fileReader.read());
        }
        fileReader.close();
        buff = buff.replaceAll("\n|\r\n", "");
        return buff;
    }
}
