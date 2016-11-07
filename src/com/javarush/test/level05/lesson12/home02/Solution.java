package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        Man man = new Man(17, "Vasya", "hui");
        Woman woman = new Woman(18, "Huiovaja", "piter");

        System.out.println(man);
        System.out.println(woman);
    }

    public static class Man
    {
        String name, address;
        int age;

        public Man (int age, String name, String address)
        {
            this.age = age;
            this.name=name;
            this.address = address;

        }
        public String toString() {
            return name + " " + age + " " + address;
        }
    }
    public static class Woman
    {
        String name, address;
        int age;
        public Woman (int age, String name, String address)
        {
            this.age = age;
            this.name=name;
            this.address = address;
        }
        public String toString() {
            return name + " " + age + " " + address;
        }
    }
}
