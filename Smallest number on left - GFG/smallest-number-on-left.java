//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String a1[] = in.readLine().trim().split("\\s+");
            int a[] = new int[n];
            for(int i = 0;i < n;i++)
                a[i] = Integer.parseInt(a1[i]);
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.leftSmaller(n, a);
            for(int i = 0;i < n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static List<Integer> leftSmaller(int n, int a[])
    {
        //code here
        List<Integer> list = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=0;i<n;i++){
            if(stack.size()==0)
            list.add(-1);
            
            else if(!stack.empty() && stack.peek()<a[i])
            list.add(stack.peek());
            
            
            else if(!stack.empty() && stack.peek()>=a[i]){
                while(!stack.empty() && stack.peek()>=a[i]){
                    stack.pop();
                }
                if(stack.size()==0)
                list.add(-1);
                
                else
                list.add(stack.peek());
            }
            stack.push(a[i]);
        }
        return list;
    }
}