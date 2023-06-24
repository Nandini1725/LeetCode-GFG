//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<String> result = ob.NBitBinary(n);
            for(String value  : result){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    ArrayList<String> NBitBinary(int N) {
        // code here
        int one = 0;
        int zero = 0;
        String op = "";
        ArrayList<String> ans = new ArrayList<>();
        solve(op,one,zero,N,ans);
        return ans;
    }
    
    public void solve(String op,int one, int zero, int N, ArrayList<String> ans){
        if(N==0){
            ans.add(op);
            return;
        }
        String op1 = op;
        op1+="1";
        solve(op1,one+1,zero,N-1,ans);
        
        if(one>zero){
            String op2 = op;
            op2+="0";
            solve(op2,one,zero+1,N-1,ans);
        }
        return;
    }
}