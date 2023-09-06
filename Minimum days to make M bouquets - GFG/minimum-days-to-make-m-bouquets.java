//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
       
        int t = sc.nextInt();
        while(t-- > 0){
            
            
           int M = sc.nextInt();
           int K = sc.nextInt();
            
            
            //int n = sc.nextInt();
            sc.nextLine();
            String s[]=sc.nextLine().split(" ");
            int n=s.length;
            int[] bloomDay = new int[n];
            for(int i=0;i<n;i++) bloomDay[i]=Integer.parseInt(s[i]);
            
            Solution obj = new Solution();
            int res = obj.solve(M, K, bloomDay);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int solve(int M, int K, int[] bloomDay) {
       
       int n = bloomDay.length;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            low = Math.min(low,bloomDay[i]);
            high = Math.max(high,bloomDay[i]);
        }

        while(low<=high){
            int temp=0;
            int count=0;
            int mid = low + ((high-low)/2);
            for(int i=0;i<n;i++){
                if(mid>=bloomDay[i]){
                    count+=1;
                }
                else{
                    temp += count/K;
                    count=0;
                }
            }
            temp += count/K;

            if(temp>=M){
                ans = Math.min(ans,mid);
                high = mid-1;
            }
            else{
                low= mid+1;
            }
            
        }
        if(ans==Integer.MAX_VALUE)
        return -1;
        return ans;
    }
}