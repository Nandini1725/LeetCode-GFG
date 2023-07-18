//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean isPalindrome(String str,int i, int j){
        // if(i==j)
        // return true;
        
        // if(i>j)
        // return true;
        
        while(i<j){
            if(str.charAt(i)!=str.charAt(j))
            return false;
            
            i++;
            j--;
        }
        return true;
    }
    
    static int solve(String str, int i, int j, int[][] t){
        if(i>=j)
        return 0;
        
        if(isPalindrome(str,i,j)==true)
        return 0;
        
        if(t[i][j]!=-1)
        return t[i][j];
        
        
        int ans = Integer.MAX_VALUE;
        
        for(int k=i;k<=j-1;k++){
            
            int temp= 1+solve(str,i,k,t)+solve(str,k+1,j,t);
            ans = Math.min(ans,temp);
        }
        t[i][j]=ans;
        return t[i][j];
    }
    static int palindromicPartition(String str)
    {
        // code here
    
        int n = str.length();
        int[][] t= new int[n+1][n+1];
        for(int i=0;i<n+1;i++)
        Arrays.fill(t[i],-1);
        
        return solve(str,0,str.length()-1,t);
    }
}