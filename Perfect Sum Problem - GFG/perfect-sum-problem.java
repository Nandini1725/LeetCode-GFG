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
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	   // double mod=1e9+7;

    //     double[][] t = new double[n+1][sum+1];
        
        
    //     for(int i=0;i<n+1;i++){
    //         for(int j=0;j<sum+1;j++){
    //             if(i==0)
    //             t[i][j]=0;
    //             if(j==0)
    //             t[i][j]=1;
    //         }
    //     }
    //     for(int i=1;i<n+1;i++){
    //         for(int j=1;j<sum+1;j++){
    //             if(arr[i-1]<=j)
    //             t[i][j]=(t[i-1][j-arr[i-1]]+ t[i-1][j])%mod ;

    //             else if(arr[i-1]>j)
    //             t[i][j]=t[i-1][j]%mod;
    //         }
    //     }
    //     return (int)(t[n][sum]%mod);
    double mod = 1e9+7;
        double[][] t = new double[n+1][sum+1];
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0) {
                    t[i][j] = 0;
                }
                if (j == 0) {
                    t[i][j] = 1;
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (arr[i-1] <= j) {
                    t[i][j] = (t[i-1][j-arr[i-1]] + t[i-1][j]) % mod;
                }
                else {
                    t[i][j] = t[i-1][j] % mod;
                }
            }
        }
        
        return (int)(t[n][sum] % mod);
	} 
}