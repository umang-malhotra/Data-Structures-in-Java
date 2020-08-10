package Arrays;

public class ArrayPlayGround {
    public static void main(String[] args) {
        int[] array = new int[6];
        for(int i=0;i < array.length; i++) {
            array[i] = (i+4)*3;
        }
        ReverseArray.reverseArrayRecursive(array, 0, array.length-1);
        for(int s : array) {
            System.out.println(s);
        }
    }
}

class ReverseArray {
    public static int[] reverseArray(int[] nums) {
        int startIndex = 0;
        int endIndiex = nums.length-1;
        while(startIndex < endIndiex) {
            int temp = nums[endIndiex];
            nums[endIndiex] = nums[startIndex];
            nums[startIndex] = temp;
            startIndex++;
            endIndiex--;
        }
        return nums;
    }
    public static void reverseArrayRecursive(int[] nums, int startIndex, int endIndex) {
        if(startIndex>=endIndex){
            System.out.println("Inside Recursive");
            return;
        }
        int temp = nums[startIndex];
        nums[startIndex] = nums[endIndex];
        nums[endIndex]=temp;
        reverseArrayRecursive(nums, startIndex+1, endIndex-1);
    }
}
