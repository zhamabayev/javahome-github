import java.lang.reflect.Array;
import java.util.Arrays;

public class MyArraySizeException extends Exception {
    private int row;
    private int column;

    public MyArraySizeException(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
