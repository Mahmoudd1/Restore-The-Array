import java.util.Arrays;

public class Solution {
    int mod = 1_000_000_007;
    public int numberOfArrays(String s, int k) {
        int[]dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return dfs(0,dp,s,k);
        //return dp[s.length()-1];
    }
    int dfs(int start,int[] dp,String s,int k)
    {
        // if the start is equal to the string length this means we have one accepted value.
        if (start==s.length())
            return 1;
        if (dp[start]!=-1)
            return dp[start];
        if (s.charAt(start)=='0')
            return 0;
        int count=0;
        for (int i=start;i<s.length();i++)
        {
            String temp=s.substring(start,i+1);
            if (Long.parseLong(temp)>k)
                break;
            count=(count+dfs(i+1,dp,s,k))%mod;
        }
        dp[start]=count;
        return count;

    }
}
