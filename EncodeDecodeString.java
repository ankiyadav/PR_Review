import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeString {

    public List<String> decode(String str) {
        // write your code here
        List<String> ans = new ArrayList<>();
        int i=0;
        int j;
        while(i < str.length()){
            j =i ;
            while(str.charAt(j) != '#'){
                j+=1;
            }
            int length = Integer.parseInt(str.substring(i, j));
            String res = str.substring(j+1, j+1+length);
            System.out.println("the res is " + res);
            ans.add(res);
            i = j + 1 + length;
        }

        return ans;
    }

    public String encode(List<String> strs) {
        // write your code here
        StringBuilder s = new StringBuilder();
        for(String str: strs){
            int len = str.length();
            s.append(len + "#");
            s.append(str);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        List<String> strs=  new ArrayList<>();
        strs.add("lint");
        strs.add("code");
        strs.add("love");
        strs.add("you");
        EncodeDecodeString dEcodeString = new EncodeDecodeString();
        String encodedString = dEcodeString.encode(strs);
        System.out.println(encodedString);
        List<String> decodedString = dEcodeString.decode(encodedString);
        System.out.println(decodedString);
    }
}
