public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
   }
    public static void checkSumSign() {
         int a = 0;
         int b = -7;
         int sum = a + b;
             System.out.println((sum >= 0)? "Число положительное" : "Число отрицательное");
    }
    public static void printColor() {
        int value = 101;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value >0 && value <= 100) {
            System.out.println("Желтый");
        } else if (value > 100) {
            System.out.println("Зеленый");
        }
    }
    public static void compareNumbers() {
        int a = 20;
        int b = 15;
        System.out.println ((a>=b)? "a >= b" : "a < b");
    }
}
