import java.lang.*;
import java.util.*;

class Test1
{
    public static String decoding(String msgs, String keys)
    {
        String[] msg = msgs.split(" ");
        String[] key = keys.split(" ");

        if(msg.length != key.length)
        {
            return "Invalid Input";
        }
        String ans = "";
        int nl = msg.length;
        for(int i=0; i<msg.length; i++)
        {
            int n = key[nl-i-1].length();
            // System.out.println(n + " " + msg[i] + " " + key[nl-i-1] + " ");
            if(n%2 != 0)
            {
                String str = msg[i];
                String res = "";
                for(int j=0; j<str.length(); j++)
                {
                    char ch = str.charAt(j);
                    if(ch<'a' || ch>'z')
                    {
                        return "Invalid Input";
                    }
                    res += (char)('a' + (ch -'a' + n)%26);
                }
                ans += res;
                // System.out.print(res + " " + ans);
            }
            else
            {
                String str = msg[i];
                String res = "";
                for(int j=0; j<str.length(); j++)
                {
                    char ch = str.charAt(j);
                    if(ch<'a' || ch>'z')
                    {
                        return "Invalid Input";
                    }
                    res += (char)('a' + (ch -'a' + 26 - n)%26);
                }
                ans += res;
            }

            if(i != msg.length-1)
            {
                ans += " ";
            }
        }

        return ans;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String msgs = sc.nextLine();
        String keys = sc.nextLine();
        String res = decoding(msgs, keys);
        System.out.println(res);
    }
}
