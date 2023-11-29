import java.util.*;

public class Optimal_Strategy {
    static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    static HashMap<Integer, ArrayList<Pair>> processArrayList(ArrayList<ArrayList<Integer>> arr) {
        
        HashMap<Integer, ArrayList<Pair>> hashMap = new HashMap<>();

        for (ArrayList<Integer> row : arr) {
            int key1 = row.get(0);
            int key2 = row.get(1);
            Pair pair = new Pair(row.get(2), row.get(3));

            for(int i=key1; i<=key2; i++)
            {
                if (hashMap.containsKey(i)) {
                hashMap.get(i).add(pair);
                } else {
                    ArrayList<Pair> pairList = new ArrayList<>();
                    pairList.add(pair);
                    hashMap.put(i, pairList);
                }
            }
        }

        //sorting arraylist
        for(ArrayList<Pair> pairs : hashMap.values())
        {
            Collections.sort(pairs, Comparator.comparing(p -> p.second));
        }
        // Print the HashMap for verification
        // for (Map.Entry<Integer, ArrayList<Pair>> entry : hashMap.entrySet()) {
        //     System.out.print("Key: " + entry.getKey() + ", Pairs: ");
        //     entry.getValue().forEach((p) -> System.out.print(p.first + " " + p.second));
        //     System.out.println();
        // }
        return hashMap;
    }
    
    private static int getmaximum(int n, int k, ArrayList<ArrayList<Integer>> arr) {
        HashMap<Integer, ArrayList<Pair>> hashMap = processArrayList(arr);
        int ans = 0;
        for(int i=1; i<=n; i++)
        {
            int res = 0;

            ArrayList<Pair> temp = hashMap.get(Integer.valueOf(i));
            int cnt = k;
            for(int j=0; j<temp.size(); j++)
            {
                if(cnt <= 0)
                    break;
                int c = temp.get(j).first;
                int p = temp.get(j).second;
                int req = 0;
                if(cnt>=c)
                {
                    // System.out.print("here1 ");
                    req = c;
                    cnt = cnt - c;
                }
                else
                {
                    // System.out.print("here2 ");
                    req = cnt;
                    cnt = cnt - c;
                }
                // System.out.print(req + "*" + p + " + ");
                res += req*p;
            }
            ans += res;
            // System.out.println(" = " + ans);
        }

        return ans;
    }
    

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5;
        int k = 7;

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>(4);

        arr.add(new ArrayList<>(Arrays.asList(1, 3, 5, 3)));
        arr.add(new ArrayList<>(Arrays.asList(1, 4, 5, 2)));
        arr.add(new ArrayList<>(Arrays.asList(2, 5, 10, 1)));

        int getMax = getmaximum(n, k, arr);
        System.out.println(getMax);
        // processArrayList(arr);
    }

    
}



// import java.util.*;

// public class Optimal_Strategy {
//     static class Plan {
//         int start, end, cores, profit;

//         public Plan(int start, int end, int cores, int profit) {
//             this.start = start;
//             this.end = end;
//             this.cores = cores;
//             this.profit = profit;
//         }
//     }

//     private static int getMaximum(int n, int k, List<Plan> plans) {
//         plans.sort(Comparator.comparingInt(p -> p.end));

//         PriorityQueue<Plan> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(p -> p.cores));

//         int ans = 0;

//         for (int i = 1; i <= n; i++) {
//             while (!plans.isEmpty() && plans.get(0).end < i) {
//                 priorityQueue.offer(plans.remove(0));
//             }

//             while (!priorityQueue.isEmpty() && i >= priorityQueue.peek().start && k > 0) {
//                 Plan plan = priorityQueue.poll();
//                 int coresToUse = Math.min(k, plan.cores);
//                 ans += coresToUse * plan.profit;
//                 k -= coresToUse;
//             }
//         }

//         return ans;
//     }

//     public static void main(String[] args) {
//         int n = 5;
//         int k = 7;

//         List<Plan> plans = Arrays.asList(
//                 new Plan(1, 3, 5, 3),
//                 new Plan(1, 4, 5, 2),
//                 new Plan(2, 5, 10, 1)
//         );

//         int getMax = getMaximum(n, k, plans);
//         System.out.println(getMax);
//     }
// }
