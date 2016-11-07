package com.javarush.test.level18.lesson10.home10;
/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/
import java.io.*;
import java.util.Map;
import java.util.TreeMap;
public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, byte[]> treeMap = new TreeMap();
        String fileName = "";
        while (true){
            String  tempFileName = reader.readLine();
            if(!tempFileName.equals("end")){
                fileName = tempFileName;
                String fileNumber = fileName.substring(fileName.lastIndexOf("part")+4,
                        (fileName.indexOf(".", fileName.lastIndexOf("part"))==-1 ? fileName.length() : fileName.indexOf(".", fileName.lastIndexOf("part"))));
                FileInputStream fileInputStream = new FileInputStream(fileName);
                byte[] buffer = new byte[fileInputStream.available()];
                if(fileInputStream.available()>0){
                    fileInputStream.read(buffer);
                }
                treeMap.put(Integer.parseInt(fileNumber), buffer);
                fileInputStream.close();
            }
            else{
                break;}
        }
        FileOutputStream fileOutputStream = new FileOutputStream
                (fileName.substring(0, fileName.lastIndexOf("part")-1)+
                        (fileName.substring(fileName.indexOf(".", fileName.lastIndexOf("part"))==-1?fileName.length():fileName.indexOf(".", fileName.lastIndexOf("part")))));
        for(Map.Entry<Integer, byte[]> pair : treeMap.entrySet())
        {
            fileOutputStream.write(pair.getValue());
        }
        fileOutputStream.close();
        reader.close();
    }
}