package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;


    public class Solution
    {
        public static void main(String[] args)
        {
            ArrayList<Human> child = new ArrayList<Human>();
            child.add(new Human("Max", true, 22));
            child.add(new Human("Roma", true, 7));
            child.add(new Human("Natalie", false, 20));

            ArrayList<Human> parents = new ArrayList<Human>();
            parents.add(new Human("Mom", false, 40, child));
            parents.add(new Human("Dady", true, 45, child));

            ArrayList<Human> grandParents = new ArrayList<Human>();
            grandParents.add(new Human("Bob", true, 60, parents));
            grandParents.add(new Human("Dag", true, 60, parents));
            grandParents.add(new Human("Mara", false, 59, parents));
            grandParents.add(new Human("Tara", false, 63, parents));

            for (Human aChild : child) {
                System.out.println(aChild);
            }
            for (Human parent : parents) {
                System.out.println(parent);
            }
            for (Human grandParent : grandParents) {
                System.out.println(grandParent);
            }
        }

        public static class Human
        {
            String name;
            boolean sex;
            int age;
            ArrayList<Human> children = new ArrayList<Human>();

            public Human(String name, boolean sex, int age)
            {
                this.name = name;
                this.sex = sex;
                this.age = age;
            }

            public Human(String name, boolean sex, int age, ArrayList children)
            {
                this.name = name;
                this.sex = sex;
                this.age = age;
                this.children = children;
            }

            public String toString()
            {
                String text = "";
                text += "Имя: " + this.name;
                text += ", пол: " + (this.sex ? "мужской" : "женский");
                text += ", возраст: " + this.age;

                int childCount = this.children.size();
                if (childCount > 0)
                {
                    text += ", дети: " + this.children.get(0).name;

                    for (int i = 1; i < childCount; i++)
                    {
                        Human child = this.children.get(i);
                        text += ", " + child.name;
                    }
                }

                return text;
            }
        }}


