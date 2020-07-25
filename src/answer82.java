public class answer82 {
    public int[] twoSum(int[] numbers, int target){
        int i = 0;
        int j = numbers.length-1;
        while(i<j && numbers[i]+numbers[j] != target){//相加结果进行判断
            if(numbers[i]+numbers[j] < target ) i++;//比目标值小则排除最小值
            else j--;//反之排除最大值
        }
        //int[] result = {i+1,j+1}
        //int[] result = new int[]{i+1,j+1};
        return new int[]{i+1,j+1};//最终结果
    }
}
