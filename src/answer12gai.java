import java.util.Arrays;

public class answer12gai {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int result;
        long[][] saves = new long[nums.length+1][m+1];
        for (long[] save : saves) Arrays.fill(save, -1);
        result = (int) getmin(n,m,nums, saves);
        return  result;
    }

    public long getmin(int n,int m,int[]nums, long[][] saves){
        if (saves[n][m] != -1) return saves[n][m];
        if (m == 1) return sum(nums,0,n-1);

        long min = sum(nums,0,n-1);
        for (int i = m-1; i < n; i++)//假设前i个数组成新的数组，他们组成m-1个子集
            min = Math.min(min, Math.max(getmin(i,m-1,nums, saves),sum(nums,i,n-1)));
        saves[n][m] = min;
        return min;
    }

    public long sum(int[]nums,int i,int n){
        long sum = 0;
        for (int j = i; j <= n ; j++) {
            sum  = sum + nums[j];
        }
        return sum;
    }
}
