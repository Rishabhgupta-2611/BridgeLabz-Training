import java.util.Scanner;
import java.util.Stack;

public class NearestSmallestIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int arr[] = new int[k];

        for (int i = 0; i < k; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        Stack<Integer> st = new Stack<>();
        int ans[] = new int[k];

        for (int i = 0; i < arr.length; i++) {
           
            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                ans[i] = st.peek(); 
            } else {
                ans[i] = -1; 
            }

            st.push(arr[i]);
        }

        
        for (int i = 0; i < k; i++) {
            System.out.print(ans[i]+',');
        }
    }
}
