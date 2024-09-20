

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInString {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int i=0;
        int j=0;
        Map<Character, Integer> fMap= new HashMap<>();

        for(int k=0;k<p.length();k++){
            if(fMap.get(p.charAt(k))!=null){
                fMap.put(p.charAt(k), fMap.get(p.charAt(k)) +1);
            }else{
                fMap.put(p.charAt(k), 1);
            }
        }

        int count = fMap.size();

        while(j<s.length()){
            if(fMap.get(s.charAt(j))!=null){
                fMap.put(s.charAt(j), fMap.get(s.charAt(j)) -1);
                if(fMap.get(s.charAt(j))==0){
                    count -= 1;
                }
            }

            if(j-i+1 < p.length()){
                j+= 1;
            }else if(j-i+1 == p.length()){
                if(count==0){
                    ans.add(i);
                }
                if(fMap.get(s.charAt(i))!=null){
                    fMap.put(s.charAt(i), fMap.get(s.charAt(i)) + 1);
                    if(fMap.get(s.charAt(i))==1){
                        count += 1;
                    }
                }

                i+=1;
                j+=1;
            }
        }

        return ans;


    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> ans = findAnagrams(s, p);
        System.out.println("the index pf starting of anagrams are " + ans+ " for the string "+ s + " for the traget "+ p);
    }
}
