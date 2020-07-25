public class answer83 {
    public int[] twoSum(int[] numbers, int target){
        int n = numbers.length;
        int star;
        for (int i = 0;i<n;i++){
            int lb = i+1;//要通过+1来避免最后取的index值和先前重合
            int rb = n-1;
            int mid = (i+n-1)/2;
            star = target - numbers[i];//计算假定完后的第二个值的大小
            while (lb<=rb){//二分查找
                if (star<numbers[mid]){
                    rb = mid - 1;
                    mid = (rb+lb)/2;
                }
                else if(star>numbers[mid]){
                    lb = mid + 1;
                    mid = (rb+lb)/2;
                }
                else return new int[] {i+1,mid+1};//相等则直接输出
            }

        }
        return null;
    }
}
