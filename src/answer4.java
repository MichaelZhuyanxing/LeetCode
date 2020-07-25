public class answer4 {
    public int searchInsert(int[] nums, int target) {
        int i = nums.length;
        int lb = 0;
        int rb = i-1;
        int result = i;
        //这里result必须等于i，因为如果目标值是最大值，result的赋值从始至终不会发生改变，
        //初始取其他值的话，会导致本应放置在末尾的最大值序列错误
        int mid;
        while(lb<=rb){
            mid = (lb+rb)/2;
            if(target<=nums[mid]){
                result = mid;
                rb = mid-1;
            }
            else if(target>nums[mid]){
                //此处不能有result = mid，因为如果目标值是倒数第二最小值，当上一次rb已经mid-1=0时
                //这行代码会导致result直接变为0而不是之前的状态1
                lb = mid+1;
            }

        }
        return result;
    }
}
