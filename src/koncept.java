import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class koncept
{
    public static void main(String[] args)  {
        Book a = new Book();
        a.n=1;
        Book b = a;
        b.n=2;
        System.out.println(a.n+" "+b.n);

    }
    public static String returnString(String line)
    {
        String[] arr = line.split(" ");
        String newString="";
        for (int i = 0;i<arr.length;i++)
        {
            if (arr[i].length()>6)
            {
                newString+=arr[i]+" ";
            }
        }
        newString = newString.trim();
        return newString.replace(" ", ",");
    }
    public static class Book
    {
         int n;

    }


}