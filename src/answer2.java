public class answer2 {
    public int numTrees(int n){
        int[] result = new int[n+1];
        int i = 0;
        int j = 0;
        result[0] = 1;//初始边界条件
        result[1] = 1;
        for(i = 2;i<=n;i++){
            for(j = 1;j<=i; j++){
                result[i] = result[i] + (result[j - 1])*(result[i - j]);
                //从头开始，反复迭代计算结果，要想计算出 i = n 时的值，必须先将之前的所有值算出
            }
        }
        return result[n];
    }
}
