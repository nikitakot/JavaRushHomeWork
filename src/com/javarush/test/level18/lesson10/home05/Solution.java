package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String name1 = reader.readLine();
            String name2 = reader.readLine();
            FileInputStream inputStream = new FileInputStream(name1);

            byte[] buffer = new byte[inputStream.available()];

            if(inputStream.available()>0){
                inputStream.read(buffer);
            }
            String string = "";

            for(int i = 0; i<buffer.length;i++){
                string+=((char) buffer[i]);
            }


            String[] doubles = string.split(" ");

            String[] doublesRounded = new String[doubles.length];
                for(int i = 0;i<doubles.length;i++)
                {
                    doublesRounded[i] = Integer.toString( (int)Math.round(Double.parseDouble(doubles[i])));
                }
            FileOutputStream outputStream = new FileOutputStream(name2);
            for(int i = 0; i<doublesRounded.length;i++){
                outputStream.write(doublesRounded[i].getBytes());
                outputStream.write(" ".getBytes());
            }

            reader.close();
            inputStream.close();
            outputStream.close();
        }
        catch (Exception e){

        }
    }
}
