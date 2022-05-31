/**
* Java 1. Homework 3
*
* @author Ruslan Zhamabayev
* @version 22/01/2022
*/
import java.util.Arrays;

class HomeWork3 {
    public static void main(String[] args) {

        int[] arr = {0, 1, 1, 1, 0, 0, 0};
        System.out.println(Arrays.toString(arr));
        for (int i=0; i < arr.length; i++) {
            arr[i] = 1 - arr[i];
        }
        System.out.println(Arrays.toString(arr));
        
//Exercise 2. Fill the array whith values from 1 to 100
        System.out.println();
        int[] arrTwo = new int[101];
        System.out.println(Arrays.toString(arrTwo));
        System.out.println();
        for (int i = 0; i < arrTwo.length; i++) {
            arrTwo[i] = i;
            }
        System.out.println(Arrays.toString(arrTwo));
        
//Exercise 3. Multiply all values less than 6 by 2.
        int[] arrThree = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1} ;
        System.out.println();
        System.out.println(Arrays.toString(arrThree));
        for (int i = 0; i < arrThree.length; i++) {
            if (arrThree[i] < 6){
            arrThree[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arrThree));
        
//Exercise 4. Fill in the diagonals of the matrix.
        System.out.println();
        int [] [] table = new int[10] [10];
        for (int i = 0; i < table.length; i++) {
            table[i][i] = 1;
            table [i] [table.length - i - 1] = 1;
            System.out.println(Arrays.toString(table[i]));
        }
        System.out.println();

//Exercise 5. Create and get an int. massive
        int[] arrFive = createNumbers (10,5);
        System.out.println(Arrays.toString(arrFive));
    }
        static int[] createNumbers(int len, int initialValue) {
            int arr[] = new int[len];
            Arrays.fill(arr, initialValue);
            return arr;
            }
}