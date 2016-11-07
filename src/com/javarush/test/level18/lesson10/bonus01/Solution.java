package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Solution {
    public static void main(String[] args) throws Exception
    {

        String[] parameters = args;
        String fileName = parameters[1];
        String fileOutputName = parameters[2];
        if (parameters[0].equals("-e"))
        {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            byte[] buffer = new byte[fileInputStream.available()];
            if (fileInputStream.available()>0){
                fileInputStream.read(buffer);
            }
            fileInputStream.close();
            for(int i = 0; i<buffer.length;i++)
            {
                buffer[i]++;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(fileOutputName);
            fileOutputStream.write(buffer);
            fileOutputStream.close();
        }

        if (parameters[0].equals("-d"))
        {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            byte[] buffer = new byte[fileInputStream.available()];
            if (fileInputStream.available()>0){
                fileInputStream.read(buffer);
            }
            fileInputStream.close();
            for(int i = 0; i<buffer.length;i++)
            {
                buffer[i]--;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(fileOutputName);
            fileOutputStream.write(buffer);
            fileOutputStream.close();
        }

    }

}
