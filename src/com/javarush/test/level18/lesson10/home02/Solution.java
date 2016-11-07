package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class Solution {
    public static void main(String[] args) {
        try
        {

            FileInputStream fileInputStream = new FileInputStream(args[0]);
            int p1 = 0;
            int p2 = 0;
            while (fileInputStream.available()>0){
              if(Character.toString((char)fileInputStream.read()).equals(" ")){
                  p2++;
                  p1++;
              }
                else
              {
                  p1++;
              }
            }
            System.out.println(new BigDecimal((double)p2/p1*100).setScale(2, RoundingMode.UP).doubleValue());
            fileInputStream.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
