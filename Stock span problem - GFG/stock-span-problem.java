//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new Solution().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}
// } Driver Code Ends



class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    static class pair{
        int num; 
        int ind;
        pair(int num,int ind){
            this.num = num;
            this.ind = ind;
        }
        
    }
    
    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        int[] res = new int[n];
        Stack<pair> stack = new Stack<pair>();
        
        for(int i=0;i<n;i++){
            if(stack.empty())
            res[i]=-1;
            
            
            else if(!stack.empty() && stack.peek().num>price[i])
            res[i]=stack.peek().ind;
            
            else if(!stack.empty() && stack.peek().num<=price[i]){
                while(!stack.empty() && stack.peek().num<=price[i])
                stack.pop();
                
                if(stack.empty())
                res[i]=-1;
                
                else
                res[i]=stack.peek().ind;
            }
            stack.push(new pair(price[i],i));
        }
        for(int i=0;i<n;i++){
            res[i]=i-res[i];
        }
        return res;
    }
    
}