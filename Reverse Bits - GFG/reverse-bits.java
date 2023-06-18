//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG
{
	static int n;
	static int k;
	
	// Driver Code
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine()); //Inputting the testcases
		
		while(t>0) //While testcases exist
		{
			
			n = Integer.parseInt(br.readLine()); //Input N
			
			Solution obj = new Solution();
			
			System.out.println(obj.reverseBits(n));
            
            t--;
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int reverseBits(int n)
    {
        //code here
        boolean flag = false;
        int rev =0;
        int j=0;
        
        for(int i=31;i>=0;i--){
            int mask = 1<<i;
            if(flag){
                if((mask &n)!=0){
                    int rmask = 1<<j;
                    rev |= rmask;
                }
                j++;
            }
            else{
                if((mask & n)!=0){
                    flag = true;
                    int rmask = 1<<j;
                    rev |= rmask;
                    j++;
                }
            }
        }
        return rev;
    }
}