import java.lang.*;
// import java.lang.reflect.Array;
import java.util.*;

public class Lift {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String dir = sc.nextLine();
        int curr_floor = sc.nextInt();
        int n = sc.nextInt();

        ArrayList<Integer> seq = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            seq.add(sc.nextInt());
        }

        helper(dir, curr_floor, n, seq);
    }

    private static void helper(String dir, int curr_floor, int n, ArrayList<Integer> seq) {
        if((dir.charAt(0)>='a' && dir.charAt(0)<='z') || (dir.charAt(1)>='a' && dir.charAt(1)<='z'))
        {
            System.out.println("Invalid Input");
            return;
        }
        ArrayList<Integer> updir = new ArrayList<>();
        ArrayList<Integer> dndir = new ArrayList<>();

        for(Integer f : seq)
        {
            if(f<0 || f>15)
            {
                System.out.println("Invalid Input");
                return;
            }
            else if(f >= curr_floor)
            {
                updir.add(f);
            }
            else
            {
                dndir.add(f);
            }
        }

        Collections.sort(updir);
        Collections.sort(dndir, Collections.reverseOrder());

        if(dir.equals("UP"))
        {
            for(Integer num : updir)
            {
                System.out.println(num);
            }
            for(Integer num : dndir)
            {
                System.out.println(num);
            }
        }
        else
        {
            for(Integer num : dndir)
            {
                System.out.println(num);
            }
            for(Integer num : updir)
            {
                System.out.println(num);
            }
        }
        

    }
}
