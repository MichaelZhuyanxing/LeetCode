import java.util.Arrays;

public class answer12 {//410
    public int splitArray(int[] nums, int m) {
        long[][] f = new long[nums.length+1][m+1];
        for (int i = 0; i < nums.length+1; i++) {
            Arrays.fill(f[i],-1); //初始化记忆优化用的数组，方便判断有没有算出的结果
        }
        int n = nums.length;
        long result;

        result = getmin(n,m,nums,f);   //前n个数分成m段最大值中的最小值（自己定义的方法）
        return  (int)result;
    }

    public long getmin(int n,int m,int[]nums,long[][]f){//注意n==m的情况
        if (f[n][m]!=-1) return f[n][m]; //记忆优化，若有计算结果，直接返回
        if (n==1) {
            f[n][m] = nums[0];  //其实这个分支可以和下面的 m == 1 合并，n = 1的时候，m 一定是1，因为我保证了数组范围一定有意义，合法
            return nums[0];
        }
        if (m == 1){//前n个数分成1组，就是简单地求和
            /*int total = 0;
            for (int i = 0; i <= n-1 ; i++) {
                total = total+nums[i];
            }
            return total;*/
            f[n][m] = sum(nums,0,n-1);
            return sum(nums,0,n-1);
        }
           long min = sum(nums,0,n-1);//初始化min
        // long min = 0;
        for (int i = 1; i <= n-m+1; i++) {//最后还剩i个数

             min = Math.min(min,Math.max((getmin(n-i,m-1,nums,f)),sum(nums,n-i,n-1)));
             //这里一行就能解决，简化了一下代码
             //long chos = Math.max(getmin(n-i,m-1,nums,f),sum(nums,n-i,n-1));
             //if (i==1)min = chos;
             //if (chos <min) min = chos;

        }
        f[n][m] = min;//将算出来的值存起来
        return min;
    }

    public long sum(int[]nums,int i,int n){
        long sum = 0;                      //之前写的是最后一组有i个数，后i个数求和，现在是从索引i加到索引n
                                           //之前问题出在后i个数求和时，我没有注意n的范围，它应该是数组的一部分，不是整个数组
        for (int j = i; j <= n ; j++) {
            sum  = sum + nums[j];
        }
        return sum;
    }
}

//动态规划：求解最优解，原问题可以分解成若干个子问题，子问题与原问题有相同的格式。