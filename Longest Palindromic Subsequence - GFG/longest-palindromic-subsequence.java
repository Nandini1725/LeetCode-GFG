//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String S)
    {
        //code here
        String rev = "";
        for(int i=0;i<S.length();i++){
            char ch = S.charAt(i);
            rev = ch+rev;
        }
        
        int n = S.length();
        int[][] t = new int[n+1][n+1];
        
        for(int i=0;i<n+1;i++)
        t[i][0]=0;
        
        for(int j=0;j<n+1;j++)
        t[0][j]=0;
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(S.charAt(i-1)==rev.charAt(j-1))
                t[i][j] = 1+t[i-1][j-1];
                else
                t[i][j] = Math.max(t[i][j-1],t[i-1][j]);
            }
        }
        return t[n][n];
    }
}