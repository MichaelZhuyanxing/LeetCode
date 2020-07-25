public class answer11 {// m * n 矩形最短路径
    public int minPathSum(int[][] grid) {
        int a = grid.length;
        int b = grid[0].length;
        int[][] min = new int[a+1][b+1];//因为索引要取到a和b，因此这里声明a+1以及b+1
        min[1][1] = grid[0][0];//设置边界条件，隐形边界条件为 min[0][j]以及min[i][0]都为0，它们没有实际意义
        for (int i = 1; i <a+1 ; i++) {//迭代计算min数组的值
            for (int j = 1; j < b+1; j++) {
                if (i == 1){
                    min[1][j] = min[1][j-1] + grid[0][j-1];
                }
                else if (j == 1){
                    min[i][1] = min[i-1][1] + grid[i-1][0];
                }
                else{
                    min[i][j] = Math.min(min[i][j-1],min[i-1][j]) + grid[i-1][j-1];
                }
            }
        }
        return  min[a][b];//运算完成后输出最终结果
    }
}
