import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeInteger {

    public static long[] printFirstNegativeInteger(long arr[], int N, int k)
    {
        List<Long> ans = new ArrayList<>();
        Queue<Long> q = new LinkedList<>();
        int windowStart = 0;
        int j=0;
        while(j < arr.length){
            if(arr[j] < 0){
                q.offer(arr[j]);
            }
            if(j-windowStart+1 < k){
                j+= 1;
            }else if(j-windowStart+1== k){

                if(q.size()>0){
                    ans.add(q.peek());
                }else{
                    ans.add(0l);
                }

                if(q.size()>0 && arr[windowStart] == q.peek()){
                    q.poll();
                }

                windowStart++;
                j++;
            }
        }
//    for gettwindowStartng the size of aray if it is required then n-k+1 is the size of the ans array can be remembered
        return ans.stream().mapToLong(e -> e).toArray();
    }

    public static void main(String[] args) {
        long arr[] = new long[]{-8, 2, 3, -6, 10};
        int n = 5;
        int k = 2;
        long[] ans = printFirstNegativeInteger(arr, n, k);
//        System.out.println(ans);
        for (long i : ans){
            System.out.println(i);
        }
    }
}
