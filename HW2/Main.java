public class Main {
    public static void main(String[] args) {
        //массив 4х4
        String arr1[][] = new String[][]{{"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}};
        //массив 4х5
        String arr2[][] = new String[][]{{"1", "2", "3", "4", "111"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}};
        //массив 4х4 со стрингом
        String arr3[][] = new String[][]{{"1", "2", "3", "4"},
                {"5", "uuups", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}};

        //вывод информации о 1ом массиве
        System.out.println("Просуммируем первый массив, результат : ");
        try {
            MethodForException.checkArray(arr1);
            int sumArray = MethodForException.sumArray(arr1);
            System.out.println("Сумма массива равна " + sumArray);
        } catch (MyArraySizeException e) {
            System.out.println("Массив - " + e.getRow() + " х " + e.getColumn() + " должен быть размеромм 4х4");
        } catch (MyArrayDataException e) {
            System.out.println("Элемент с индексом - " + e.getRow() + " , " + e.getColumn() + " не возможно преобразовать в int");
        }

        //вывод информации о 2ом массиве
        System.out.println("Просуммируем второй массив, результат : ");
        try {
            MethodForException.checkArray(arr2);
            int sumArray = MethodForException.sumArray(arr2);
            System.out.println("Сумма массива равна " + sumArray);
        } catch (MyArraySizeException e) {
            System.out.println("Массив " + e.getColumn() + " x " + e.getRow() + " должен быть размером 4х4");
        } catch (MyArrayDataException e) {
            System.out.println("Элемент с индексом " + e.getColumn() + " , " + e.getRow() + " не возможно преобразовать в int");
        }

        //вывод информации о 3ом массиве
        System.out.println("Просуммируем третий массив, результат : ");
        try {
            MethodForException.checkArray(arr3);
            int sumArray = MethodForException.sumArray(arr3);
            System.out.println("Сумма массива равна " + sumArray);
        } catch (MyArraySizeException e) {
            System.out.println("Массив " + e.getColumn() + " x " + e.getRow() + " должен быть размером 4х4");
        } catch (MyArrayDataException e) {
            System.out.println("Элемент с индексом " + e.getColumn() + " , " + e.getRow() + " не возможно преобразовать в int");
        }
    }
}