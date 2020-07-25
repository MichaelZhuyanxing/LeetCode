import java.util.Arrays;

public class answer11_2 {
    public int minPathSum(int[][] grid){
        int[][] rem = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(rem[i],-1);
        }
        return minPathSum(grid,0,0,rem);
    }

    public int minPathSum(int[][]grid,int top,int left,int[][]rem){
        if (rem[top][left]!= -1){
            return  rem[top][left];
        }

        int result = grid[top][left];


        if (top+1<=grid.length-1 && left+1<=grid[0].length-1){
            result += Math.min(minPathSum(grid,top,left+1,rem),minPathSum(grid,top+1,left,rem));
        }
        else if (top+1<=grid.length-1 && left+1>grid[0].length-1){
            result += minPathSum(grid,top+1,left,rem);
        }
        else if (top+1>grid.length-1 && left+1<=grid[0].length-1){
            result += minPathSum(grid,top,left+1,rem);
        }
        /*else if (top == grid.length-1 && left == grid[0].length-1){
            result = grid[top][left];
        }*/


        rem[top][left] = result;
        return result;
    }
}
