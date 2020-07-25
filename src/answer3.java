import java.util.Arrays;

public class answer3 {
    int uncolored = 0;
    int red = 1;
    int green = 2;
    //给各种属性设定一个值
    int[] color;//表示每一个点的颜色属性
    boolean result = true;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color  = new int[n];
        Arrays.fill(color,uncolored);//初始状态，所有点均为未上色
        for(int i=0;(i<n)&&result;i++){//依序判断每一个点的颜色状态
            if(color[i] == uncolored){
                result = dfs(i,red,graph);
            }
        }
        return  result;//最终结果
    }

    public boolean dfs(int t, int c, int[][]graph){
        color[t] = c;
        int nc = (c== red? green:red);//判断相邻点应该染成的颜色
        for (int conn : graph[t]){
            if(color[conn] == uncolored){
                dfs(conn,nc,graph);
                if (!result){
                    return false;//发现之前颜色已经错误，直接返回，不继续判断
                }
            }
            else if (color[conn] != nc){//判断颜色是否发生了错误
                return false;
            }
        }
        return true;//一切正常，返回true
    }
}
