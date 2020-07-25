public class answer5 {
    public boolean isInterleave(String s1, String s2, String s3){
        int a = s1.length();
        int b = s2.length();
        int c = s3.length();

        //f二维数组[]中的数表示前多少个字母
        //s1，s2最多分别为前a和前b个字母，因此f定义的大小分别为a+1和b+1
        boolean[][] f = new boolean[a+1][b+1];
        f[0][0] = true;//边界条件

        if(a+b != c) return  false;

        //开始迭代计算每种f的情况
        for (int i = 0;i<=a;i++){
            for(int j = 0;j<=b;j++){
                int p = i+j-1;//p代指s3中目前考虑到的最后一个字符所在位置
                if(i>0) f[i][j] = f[i-1][j] && (s1.charAt(i-1)==s3.charAt(p));
                if(j>0) f[i][j] = f[i][j] || (f[i][j-1] && (s2.charAt(j-1)==s3.charAt(p)));
                //j这行多一个判决条件f[i][j]是因为要考虑到上一行 i 中判决的结果
            }
        }
        return f[a][b];

    }
}
