package Arrays;
import java.util.Scanner;  // Import the Scanner class

public class App {
    public static void main(String[] args) {
        String[] nums = new String[5];
        for(int i=0; i<nums.length; i++) {
            nums[i]=i+"Strtest";
        }
        Scanner scanObj = new Scanner(System.in);
        System.out.println("Enter a string to check if it is present in array or not");
        String scanStr = scanObj.nextLine();

        boolean isPresent = false;
        for(int i=0;i<nums.length;i++) {
            if(nums[i].equals(scanStr))
                isPresent = true;
        }
        if(isPresent) {
            System.out.println("String found in the array");
        } else {
            System.out.println("String not found in the array");
        }
    }
}
