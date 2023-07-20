//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] mat = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.countSquares(N, M, mat);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int countSquares(int N, int M, int mat[][]) {
        // Code here
        int[][] t =new int[N][M];
        
        for(int i=0;i<N;i++)
        t[i][0]=mat[i][0];
        
        for(int j=0;j<M;j++)
        t[0][j]=mat[0][j];
        
        for(int i=1;i<N;i++){
            for(int j=1;j<M;j++){
                if(mat[i][j]==0)
                t[i][j]=0;
                else
                t[i][j]=1+Math.min(t[i-1][j-1], Math.min(t[i-1][j], t[i][j-1]));
            }
        }
        int ans =0;
        for(int i=0;i<N;i++)
        for(int j=0;j<M;j++)
        ans+=t[i][j];
        
        return ans;
    }
}