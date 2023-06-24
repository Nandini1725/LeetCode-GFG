//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine().trim();
            Solution ob = new Solution();
            ArrayList<String> ans = new ArrayList<String>();
            ans = ob.permutation(S);
            
            for(int i=0;i<ans.size();i++){
                System.out.print("("+ans.get(i)+")");
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java



class Solution{
    
    ArrayList<String> permutation(String S){
        // Code Here
        ArrayList<String> ans = new ArrayList<>();
        String op = "";
        String ip = S;
        op+=ip.charAt(0);
        ip=ip.substring(1);
        solve(ip,op,ans);
        return ans;
    }
    
    public void solve(String ip, String op, ArrayList<String> ans){
        if(ip.length()==0){
            ans.add(op);
            return;
        }
        
        solve(ip.substring(1),op+" "+ip.charAt(0),ans);
        solve(ip.substring(1),op+ip.charAt(0),ans);
        
        return;
        
    }
    
}