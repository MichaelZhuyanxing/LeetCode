public class answer7 {
    public int maxCoins(int[] nums){
        int total = nums.length;
        int[][] dp = new int[total+2][total+2];
        int[] val = new int[total+2];
        val[0] = 1;
        val[total+1] = 1;
        for (int i = 1;i<=total;i++){
            val[i] = nums[i-1];
        }
        for(int i = total-1;i>=0;i--){
            for (int j = i+2;j<=total+1;j++){
                for(int k=i+1;k<j;k++){
                    int result = val[i]*val[k]*val[j]+dp[i][k]+dp[k][j];
                    dp[i][j] = Math.max(dp[i][j], result);
                }
            }
        }
        return dp[0][total+1];
    }
}
