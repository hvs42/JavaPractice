import java.util.*;

public class StockBuySell {

    public static ArrayList<Integer> getNetProfit(String[] str)
    {
        ArrayList<Integer> ans = new ArrayList<>();

        HashMap<String, Integer> portfolio = new HashMap<>();
        HashMap<String, Integer> marketChange = new HashMap<>();

        for(String s : str)
        {
            String[] tmp = s.split(" ");
            if(tmp[0].equals("BUY")) //BUY
            {
                if(portfolio.containsKey(tmp[1]))
                {
                    int val = portfolio.get(tmp[1]);
                    val = val + Integer.parseInt(tmp[2]);
                    portfolio.put(tmp[1], val);
                }
                else
                {
                    portfolio.put(tmp[1], Integer.parseInt(tmp[2]));
                    marketChange.put(tmp[1], 0);
                }
                
            }
            else if(tmp[0].equals("SELL"))
            {
                if(portfolio.containsKey(tmp[1]))
                {
                    int val = portfolio.get(tmp[1]);
                    val = val - Integer.parseInt(tmp[2]);
                    portfolio.put(tmp[1], val);
                    // System.out.println("Here");
                }
                // else
                // {
                //     portfolio.put(tmp[1], Integer.parseInt(tmp[2]));
                //     marketChange.put(tmp[1], 0);
                // }
            }
            else if(tmp[0].equals("CHANGE"))
            {
                if(marketChange.containsKey(tmp[1]))
                {
                    int val = marketChange.get(tmp[1]);
                    val = val + Integer.parseInt(tmp[2]);
                    marketChange.put(tmp[1], val);

                    // System.out.println(s + "===" +tmp[1] + " : " + val + " : " + marketChange.get(tmp[1]));
                }
                else
                {
                    // System.out.println(s);
                    // int val = marketChange.get(tmp[1]);
                    // System.out.println(tmp[1]);
                    // portfolio.put(tmp[1], 0);
                    // marketChange.put(tmp[1], Integer.parseInt(tmp[2]));
                }
            }
            else if(tmp[0].equals("QUERY"))
            {
                int res = 0;
                for(String key : portfolio.keySet())
                {
                    int amt = marketChange.get(key);
                    // System.out.println(key + " : " + amt + " " + portfolio.get(key));
                    // System.out.println(key);
                    res += portfolio.get(key)*amt;
                }
                // System.out.println("-----------");
                ans.add(res);
            }
        }
        if(ans.isEmpty())
        {
            ans.add(0);
        }
        return ans;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        String[] str = new String[num];

        for(int i=0; i<num; i++)
        {
            str[i] = sc.nextLine();
        }
        
        ArrayList<Integer> ans = getNetProfit(str);
        for(Integer res : ans)
        {
            System.out.println(res);
        }
    }
}

