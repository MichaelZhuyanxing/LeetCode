public class answer8 {
    public int[] twoSum(int[] numbers, int target) {
        int[] index = new int[2];
        int result = 0;
        int n = numbers.length;
        for(int i = 0;i<n-1;i++){//选择的第一位数
            for (int j = i+1; j <n ; j++) {//开始遍历选择第二位数
                result = numbers[i]+numbers[j];//求和
                if(result == target){//如果结果正确，则直接输出
                  index[0] = i + 1;
                  index[1] = j + 1;
                  return index;
                }
            }

        }
        return null;
    }
}
