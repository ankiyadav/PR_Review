
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentnumbers {

    static class Pair{
        int first;
        int second;

        Pair(){}

        Pair(int first, int second){
            this.first = first;
            this.second  =second;
        }
    }

    public static int[] topKElements(int[] arr,int k){
        Pair[] pairs = new Pair[5];
//        ArrayList<Pair> pairs = new ArrayList<>();
//        pairs.sort((a, b)-> b.second - a.second);

        if(k<=0){
            return null;
        }
        if(arr.length ==1 && k>=1){
            return arr;
        }
        //create a frequescy hasmap
        HashMap<Integer, Integer> frequencyMap= new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(frequencyMap.get(arr[i])!=null){
                frequencyMap.put(arr[i], frequencyMap.get(arr[i])+1);
            }else{
                frequencyMap.put(arr[i], 1);
            }
        }
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b)->(b.second - a.second));
        frequencyMap.forEach((key, val)->{
            minHeap.add(new Pair(val, key));
            if(minHeap.size()>k){
                minHeap.poll();
            }
        });
        int[] res =new int[minHeap.size()];
        int i=0;
        while(minHeap.size()>0){
            res[i] = minHeap.peek().second;
            minHeap.poll();
            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr ={1,1,1,3,2,2,4};
        int k = 2;

        int[] result=  topKElements(arr, k);

        for (int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}
