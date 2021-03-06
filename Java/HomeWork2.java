/**
* Java 1. Homework 2
*
* @author Ruslan Zhamabayev
* @version 16/01/2022 - 23/01/2022(mistakes fixed)
*/
public class HomeWork2 {
    public static void main(String[] args) {
        System.out.println("Exersice #1");
        System.out.println(within10and20(7, 8));
        System.out.println("Exersice #2");
        isTheNumberPositive(0);
        System.out.println("Exersice #3");
        System.out.println(isTheNumberPositiveBoolean(-8));
        System.out.println("Exersice #4");
        printText("Here should be text", 5);
}
    static boolean within10and20(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }
    static void isTheNumberPositive(int c) {
        System.out.println((c >= 0)? "Positive": "Negative");
    }
    static boolean isTheNumberPositiveBoolean(int c){
        return c < 0;
    }
    static void printText(String text, int d) {
        for (int i = 0; i < d; i++) {
            System.out.println (text);
        }
    }
}