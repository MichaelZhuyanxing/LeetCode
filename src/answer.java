import java.util.List;

public class answer {//三角形最短路径和
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        int i = 0;//行数
        int j = 0;//列数
        int min = 999999;//初始化最小值
        f[0][0] = triangle.get(0).get(0);
        if(n==1) min = f[0][0];//如果三角形只有1行，最小路径值就是顶部取值
        else{
            for(i = 1;i<n;i++){
                f[i][0] = f[i-1][0]+triangle.get(i).get(0);//计算特殊情况中，即最左侧的最短路径值
                if(i==n-1) min = f[i][0];//当最后一行最左侧的值计算完毕后，更新最小值的赋值
                for(j = 1;j<=i;j++){
                    f[i][j] = Math.min(f[i-1][j],f[i-1][j-1]) + triangle.get(i).get(j);//普通情况下，f[i][j]的计算表达式
                    if(i==j){
                        f[i][i] = f[i-1][i-1] +triangle.get(i).get(i);
                        //计算特殊情况下，即最右侧的最短路径值（这里相当于如果i==j，进行了一次取值覆盖）
                    }
                    if(i==n-1){
                        //如果现在已经算到了最后一行，开始找出此行的最小值
                        if(f[i][j]<min) min = f[i][j];
                        System.out.println("right now, the min is: "+min);
                    }
                }
            }
        }
        return min;//输出结果
    }
}
