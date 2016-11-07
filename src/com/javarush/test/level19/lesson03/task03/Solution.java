package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры)
Обратите внимание на формат вывода фамилии и имени человека
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }
    public static class IncomeDataAdapter implements Customer, Contact {

        private IncomeData incomeData;
        IncomeDataAdapter(IncomeData incomeData)
        {
            this.incomeData = incomeData;
        }

        @Override
        public String getName()
        {
            return incomeData.getContactLastName()+", "+incomeData.getContactFirstName();
        }

        @Override
        public String getPhoneNumber()
        {
            String wholeNumber;
            String nulls="";
            for (int i=10-String.valueOf(incomeData.getPhoneNumber()).length(); i>0; i--)
            {
                nulls+="0";
            }
            wholeNumber = "  "+nulls+incomeData.getPhoneNumber();
            return "+"+incomeData.getCountryPhoneCode()+"("+wholeNumber.substring(2,5)+")"+
                    wholeNumber.substring(5, 8)+"-"+wholeNumber.substring(8,10)+
                    "-"+wholeNumber.substring(10,12);
        }

        @Override
        public String getCompanyName()
        {
            return incomeData.getCompany();
        }

        @Override
        public String getCountryName()
        {
            String country="";
            for (Map.Entry<String, String> i : countries.entrySet())
            {
                String countryCode = i.getKey();
                if(countryCode.equals(incomeData.getCountryCode()))
                {
                    country = i.getValue();
                    break;
                }
            }
            return country;
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}