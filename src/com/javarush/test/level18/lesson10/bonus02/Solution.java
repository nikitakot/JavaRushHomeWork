package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/



import java.io.*;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        if(args[0].equals("-c")){
            FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
            int id = maxId(fileName) + 1;
            String productName = args[1];
            double price = Double.parseDouble(args[2]);
            int quantity = Integer.parseInt(args[3]);
            String newLine =  String.format("%-8d%-30s%-8.2f%-4d%n", id, productName, price, quantity);
            fileOutputStream.write(newLine.getBytes());
            fileOutputStream.close();
        }
    }

    public static int maxId (String fileName) throws Exception
    {
        TreeSet<Integer> setOfId = new TreeSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        line = reader.readLine();
        if (line!=null){
        while (line!=null){
            char[] temp = line.substring(0, 8).toCharArray();
            String numId="";
            for(int i = 0; i<temp.length;i++)
            {
                if(!String.valueOf(temp[i]).equals(" ")){
                    numId+=temp[i];
                }
                else
                    break;
            }
            setOfId.add(Integer.parseInt(numId));
            line = reader.readLine();
        }
        reader.close();

        return setOfId.last();}
        else
            return 0;
    }
}
