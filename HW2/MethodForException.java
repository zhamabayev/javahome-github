public class MethodForException {
    public static void checkArray (String [][] array) throws MyArraySizeException {
        // в первую очередь проверяем количесство строк, если строк не равно 4, то столбцы не проверяем (кидаемм ексепшн)
        if (array.length != 4) throw new MyArraySizeException(array.length, array[0].length);
        for (int i=0; i < array.length; i++) {
            if (array[i].length != 4) throw new MyArraySizeException(array.length, array[i].length);
        }
    }
    public static int sumArray (String[][] array) throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for(int j=0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (Exception e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        } return sum;
    }
}
