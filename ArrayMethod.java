public class ArrayMethod<T> {

    public T[] changeArrayIndex (T[] array, int getIndexA, int getIndexB) {
        T objects = array[getIndexA];
        array[getIndexA] = array[getIndexB];
        array[getIndexB] = objects;
            return array;
    }
}
