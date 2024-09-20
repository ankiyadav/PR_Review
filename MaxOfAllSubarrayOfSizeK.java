import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class MaxOfAllSubarrayOfSizeK {

    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        // Your code here
        Deque<Integer> q = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while (j < arr.length) {
            if (q.size() == 0) {
                q.offerFirst(arr[j]);
            } else {
                if (q.peekLast() < arr[j]) {
                    while (q.size() > 0 && q.peekLast() < arr[j]) {
                        q.pollLast();
                    }
                    if (q.size() == 0) {
                        q.offerFirst(arr[j]);
                    } else {
                        q.offerLast(arr[j]);
                    }
                    // q.offerFir(arr[j]);
                } else {
                    q.offerLast(arr[j]);
                }
            }
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                int first = q.peekFirst();
                ans.add(first);
                if (arr[i] == first) {
                    q.pollFirst();
                }

                i++;
                j++;

            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6};
        int n = 9;
        int k = 3;

        ArrayList<Integer> ans = max_of_subarrays(arr, n, k);
        System.out.println("ans is "+  ans);
    }
    }
