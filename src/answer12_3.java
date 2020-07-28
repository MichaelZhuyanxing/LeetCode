public class answer12_3 {
    public int splitArray(int[] nums, int m){
        int n = nums.length;
        long max = sum(nums,0,nums.length-1);
        long min = 0;
        long mid = (max+min)/2;
        //System.out.println(max);
        while (min<max){
            mid = (max+min)/2;
            if (check(nums,mid,m)){
                max = mid; //mid有可能是正确答案
            }
            else {
                min = mid+1;//mid不可能是正确答案，进行排除
            }
        }
        return (int)min;

    }

    public boolean check(int[] nums,long mid,long m){//能全装进去返回true，说明mid可能大了（能全装进去有两种情况，一是恰好装满，二是有盈余）
                                                     //返回true 可能是正确答案，返回false一定不是正确答案
        int n = nums.length;
        long sum = 0;
        int i;
        for ( i = 0; i < n && m>0; i++) {
            sum += nums[i];
            if (sum>mid){
                i--;//保证不溢出
                m--;//如果装满，容器数量减1
                sum = 0;//准备重新装填
            }
        }
        return (i==n);//i==n说明全装进去了，没有留下任何数

    }


    public long sum(int[]nums,int i,int n){
        long sum = 0;
        for (int j = i; j <= n ; j++) {
            sum  = sum + nums[j];
        }
        return sum;
    }
}
