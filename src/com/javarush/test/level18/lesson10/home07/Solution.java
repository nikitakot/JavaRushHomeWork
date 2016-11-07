package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String fileName = reader.readLine();
            BufferedReader lineReader = new BufferedReader(new FileReader(fileName));
            String line;
            line = lineReader.readLine();

            while (line!=null){
                String[] sepLine = line.split(" ");
                if(sepLine[0].equals(args[0]))
                {
                    for (String i : sepLine)
                    System.out.print(i+" ");
                }
                line = lineReader.readLine();
            }
            reader.close();
            lineReader.close();

        }
        catch (Exception e){

        }

    }
}
