package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static String fileName;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        fileName = reader.readLine();
        reader.close();
        ArrayList<String> setFromFile = hashSetFromFile();
        fileCleaner();
        if(args[0].equals("-u")){
            int id =  Integer.parseInt(args[1]);
            String productName = args[2];
            double price = Double.parseDouble(args[3]);
            int quantity = Integer.parseInt(args[4]);
            String newLine =  String.format("%-8d%-30s%-8.2f%-4d%n", id, productName, price, quantity);
            ArrayList<String> list = uParametrList(setFromFile,id,newLine);
            PrintWriter printWriter = new PrintWriter(new FileWriter(fileName));
            for (int i = 0; i<list.size();i++){
                printWriter.println(list.get(i));
            }
            printWriter.close();
        }
        else if(args[0].equals("-d")){
            int id =  Integer.parseInt(args[1]);
            ArrayList<String> list = dParametrList(setFromFile,id);
            PrintWriter printWriter = new PrintWriter(new FileWriter(fileName));
            for (int i = 0; i<list.size();i++){
                printWriter.println(list.get(i));
            }
            printWriter.close();
        }

    }

    public static ArrayList<String> hashSetFromFile() throws Exception{
        ArrayList<String> setFromFile = new ArrayList<>();
        BufferedReader lineReader = new BufferedReader(new FileReader(fileName));
        String line;
        line = lineReader.readLine();
        while (line!=null){
            setFromFile.add(line);
            line=lineReader.readLine();
        }
        lineReader.close();
        return setFromFile;
    }

    public static ArrayList<String> uParametrList(ArrayList<String> setFromFile, int parametrId, String newString) throws Exception{
        for (int i=0;i<setFromFile.size();i++){
            String line = setFromFile.get(i);
            int id = id(line);
            if(parametrId==id){
                setFromFile.remove(i);
                setFromFile.add(i, newString);
                break;
            }
        }
        return setFromFile;
    }

    public static ArrayList<String> dParametrList(ArrayList<String> setFromFile, int parametrId) throws Exception{
        for (int i=0;i<setFromFile.size();i++){
            String line = setFromFile.get(i);
            int id = id(line);
            if(parametrId==id){
                setFromFile.remove(i);
                break;
            }
        }
        return setFromFile;
    }

    public static void fileCleaner() throws Exception{
        PrintWriter writer = new PrintWriter(fileName);
        writer.print("");
        writer.close();
    }

    public static int id(String line){
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
        return Integer.parseInt(numId);
    }
}
