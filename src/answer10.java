public class answer10 {//旋转数组
    public int minArray(int[] numbers) {
        for (int i = 0; i < numbers.length-1; i++) {
            if (numbers[i]-numbers[i+1]>0){
                return numbers[i+1];//出现断层返回较小的值
            }
        }
        return numbers[0];//1.整个序列就1个数 2.序列里的数全部一样大 3.按序递增序列
                          //出现上述三种情况则返回 numbers[0]
    }
}
