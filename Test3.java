import java.lang.*;
import java.util.*;


public class Test3 {

    public static void helper(String str)
    {
        String[] arr = str.split(":");
        String hour = arr[0];
        String min = arr[1];
        String sec = arr[2];
        String minim = "";
        String maxim = "";
        //hour
        if(hour.charAt(0) == '@')
        {
            minim = minim + "0";
            maxim = maxim + "2";
        }
        else
        {
            minim = minim + hour.charAt(0);
            maxim = maxim + hour.charAt(0);
        }
        if(hour.charAt(1) == '@')
        {
            minim = minim + "0" + ":";
            maxim = maxim + "4" + ":";
        }
        else
        {
            minim = minim + hour.charAt(1) + ":";
            maxim = maxim + hour.charAt(1) + ":";
        }
        //minutes
        if(min.charAt(0) == '@')
        {
            minim = minim + "0";
            maxim = maxim + "5";
        }
        else
        {
            minim = minim + min.charAt(0);
            maxim = maxim + min.charAt(0);
        }
        if(min.charAt(1) == '@')
        {
            minim = minim + "0" + ":";
            maxim = maxim + "9" + ":";
        }
        else
        {
            minim = minim + min.charAt(1) + ":";
            maxim = maxim + min.charAt(1) + ":";
        }
        //seconds
        if(sec.charAt(0) == '@')
        {
            minim = minim + "0";
            maxim = maxim + "5";
        }
        else
        {
            minim = minim + sec.charAt(0);
            maxim = maxim + sec.charAt(0);
        }
        if(sec.charAt(1) == '@')
        {
            minim = minim + "0";
            maxim = maxim + "9";
        }
        else
        {
            minim = minim + sec.charAt(1);
            maxim = maxim + sec.charAt(1);
        }

        System.out.println(minim);
        System.out.println(maxim);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        helper(str);

    }
}
