package com.raghvendra;

/**
 * Solution 1 : Using Recursion
 */
public class DecodeWays {
/*    public int numDecodings(String s) {
        int k = s.length();
        int result = 0;
        result = helper(s, k, result);
        return result;
    }

    private int helper(String s, int k, int result){
        if( k == 0) return 1;

        int firstLoc = s.length() - k;
        if(s.charAt(firstLoc) == '0'){
            return 0;
        }
        result = helper(s, k - 1, result);

        //check the case where two letter digit should be less than 26, then there we need to add them as apart of combinations
        if(k >= 2 && Integer.parseInt(s.substring(firstLoc, firstLoc + 2)) <= 26)
        result += helper(s, k - 2, result);
        return result;
    }*/

    /**
     * Solution 2: Using Dynamic Programming
     */
/*    public int numDecodings(String s) {
        int  k =  s.length();
        int result = 0;
        int[] memo  =  new int[k + 1];
        for(int i = 0; i < memo.length; ++i){
            memo[i] = -1;
        }
        result = helper(s, k, result, memo);
        return result;
    }

    private int helper(String s, int k, int result, int[] memo){

        //Base case, there is a one way if the string is empty to encode it
        if(k == 0) return 1;

        int firstLoc = s.length() - k;
        //Handling the case when first digit in the string could be a zero, in that case there is no encoded string for that, so return zero
        if(s.charAt(firstLoc) == '0'){
            return 0;
        }

        //check if the result is stored in the memo array
        if(memo[k] != -1){
            return memo[k];
        }

        //calculate the result
        result = helper(s, k - 1, result, memo);

        //check the case where two letter digit should be less than 26, then there we need to add them as apart of combinations
        if(k >= 2 && Integer.parseInt(s.substring(firstLoc, firstLoc + 2)) <= 26)
        result += helper(s, k - 2, result, memo);

        //store the value of result in memo
        memo[k] = result;

        return result;
    }*/

    /**
     * Approach 3:  Bottom - up Approach
     */
    public int numDecodings(String s) {
        int dp[] = new int[s.length() + 1];
        //Ways to decode an empty string , it's 1
        dp[0] = 1;
        //Check the first character if it's 0 then 0 ways else there will be one, because mapping starts from 1->26
        dp[1] = (s.charAt(0) == '0') ? 0 : 1;
        for(int i = 2; i < s.length(); ++i){
            int oneDigit = Integer.valueOf(s.substring(i - 1, i));
            int twoDigit = Integer.valueOf(s.substring(i - 2, i));
            if(oneDigit >= 1){
                dp[i] += dp[i - 1];
            }
            if(twoDigit >= 10 && twoDigit <= 26){
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
