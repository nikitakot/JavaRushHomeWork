package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Exchanger;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            while(true){
            String fileName = reader.readLine();
            if (!fileName.equals("exit")){
                ReadThread readThread = new ReadThread(fileName);
                readThread.start();
                readThread.join();

            }
                else{
                System.out.println(resultMap);
                break;}

            }
            reader.close();

        }
        catch (Exception e){

        }

    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }
        public void run(){
            try
            {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                Map<Integer,Integer> list = new HashMap<Integer,Integer>();

                while (fileInputStream.available()>0){
                    int kay = fileInputStream.read();
                    if(list.containsKey(kay)){
                        int value = list.get(kay);
                        list.put(kay, ++value);
                    }
                    else list.put(kay, 1);
                }

                int tempValue=1;
                for(Map.Entry<Integer, Integer> l:list.entrySet()){
                    if(tempValue<l.getValue())
                        tempValue = l.getValue();
                }

                for(Map.Entry<Integer, Integer> l:list.entrySet()){
                    if(l.getValue()==tempValue){
                        resultMap.put(fileName, l.getKey());}
                }
                fileInputStream.close();

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
