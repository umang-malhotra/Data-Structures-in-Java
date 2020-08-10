package Arrays;

import java.util.Arrays;
import java.util.Random;

public class ArrayProblems {
    public static void main(String[] args) {
        int[] numsArray = new int[10];
        Random rand = new Random();

        for(int i=0;i< numsArray.length; i++){
            numsArray[i] = rand.nextInt(10);
        }

        int[] numsArray2 = new int[10];
        for(int i=0;i< numsArray.length; i++){
            numsArray2[i] = rand.nextInt(10);
        }
        boolean isAnagram = AnagramProblem.Solver(numsArray, numsArray2);
        System.out.println(isAnagram);
    }
}

class AnagramProblem {
    public static boolean Solver(int[] array1, int[] array2) {
        if(array1.length != array2.length)
            return false;
        Arrays.sort(array1);
        Arrays.sort(array2);

        for(int i=0;i< array1.length;i++) {
            if(array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }
}
