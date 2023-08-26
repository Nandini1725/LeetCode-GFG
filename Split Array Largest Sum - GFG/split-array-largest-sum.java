//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int splitArray(int[] arr , int N, int K) {
        // code here
        int low =Integer.MIN_VALUE;
        int high =0;
        for(int i=0;i<N;i++){
            low = Math.max(low,arr[i]);
            high += arr[i];
        }

        while(low<=high){
            int mid = low + ((high-low)/2);
            int nstud = solve(arr,mid,K);

            if(nstud>K)
            low = mid+1;
            else 
            high = mid-1;
        }
        return low;
    }
    
    static int solve(int[] arr, int mid, int K){
        int sum=0;
        int stud =1;
        for(int i=0;i<arr.length;i++){
            if((sum+arr[i])<=mid)
            sum+=arr[i];
            else{
                stud++;
                sum=arr[i];
            }
        }
        return stud;
    }
};