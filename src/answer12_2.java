public class answer12_2 {
    public int splitArray(int[] nums, int m){
        int n = nums.length;
        int[][] f = new int[n+1][m+1];
        f[1][1] = nums[0];
        for (int i = 1; i <=n ; i++) {//从头开始计算
            //f[i][j]前i个数看成一个“新的数组”，将其分成j组，最大值中的最小值
            for (int j = 1; j <=i && j<=m ; j++) {
                int min = sum(nums,0,i-1);//当j==1时不进循环，正常求和。在这里还有初始化min值的作用，如果整个f[][]数组有初始化成最大值，能够进循环，就不需要这行了
                for (int k = j-1; k <= i-1 && k>=1; k++) {                     //如果初始化所有f[][]为一个最大值，k就可以从1开始非法取值，这里没有初始化，因此要从j-1开始取（j-1个组至少需要j-1个数）
                    //System.out.println(min);                                   //非法取值只有可能在这里发生，前面的循环是看成新数组，不会有非法取值
                    min = Math.min(min,Math.max(f[k][j-1],sum(nums,k,i-1)));//后面计算某具体f[i][j]会用到前面计算好的一部分，但不是全部，但是整个循环所有计算完毕后，会将所有情况用到
                    //System.out.println(min);                                   //比如计算f[6][5]会用到5,4|4,4|4,3|3,3|3,2|2,2|2,1|1,1 但是没有用到如4,2
                }                                                              //计算当前f[i][j]还是会用到状态转移方程
                f[i][j] = min;//算完进行记忆
            }
        }
        return f[n][m];//全部算完，结果就出来了
    }

    public int sum(int[]nums,int i,int n){
        int sum = 0;                      //之前写的是后i个数求和，现在是从索引i加到索引n
        for (int j = i; j <= n ; j++) {
            sum  = sum + nums[j];
        }
        return sum;
    }
}
