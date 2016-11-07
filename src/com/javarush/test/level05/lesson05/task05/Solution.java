package com.javarush.test.level05.lesson05.task05;

/* Провести три боя  попарно между котами
Создать три кота используя класс Cat.
Провести три боя попарно между котами.
Класс Cat создавать не надо. Для боя использовать метод boolean fight(Cat anotherCat).
Результат каждого боя вывести на экран.
*/

public class Solution {
    public static void main(String[] args) {
        Cat cat1 = new Cat("vaska", 1, 1, 1);
        Cat cat2 = new Cat("vlad", 1, 2, 3);
        Cat cat3 = new Cat("antoha", 1, 2, 1488);
        System.out.println(cat1.fight(cat2));
        System.out.println(cat1.fight(cat3));



        System.out.println((cat3.fight(cat2)));

    }

    public static class Cat {

        public static int count = 0;
        public static int fightCount = 0;

        protected String name;
        protected int age;
        protected int weight;
        protected int strength;

        public Cat(String name, int age, int weight, int strength) {
            count++;

            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

        public boolean fight(Cat anotherCat) {
            fightCount++;

            int agePlus = this.age > anotherCat.age ? 1 : 0;
            int weightPlus = this.weight > anotherCat.weight ? 1 : 0;
            int strengthPlus = this.strength > anotherCat.strength ? 1 : 0;

            int score = agePlus + weightPlus + strengthPlus;

            /*if (score>=2)
            {System.out.println("The winner is "+name);
            System.out.println("Thw looser is "+anotherCat.name);}
            else
            {System.out.println("The winner is "+anotherCat.name);
                System.out.println("Thw looser is "+name);}*/
           return score > 2;
            //return score > 2 ? true : false;

        }

    }
}
