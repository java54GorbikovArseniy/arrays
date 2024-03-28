package telran.util;

import java.util.Comparator;

public class Arrays {
    public static <T> int indexOf(T[] array, T element) {
        int index = 0;
        while (index < array.length && !equals(array[index], element)) {
            index++;
        }

        return index == array.length ? -1 : index;
    }

    private static <T> boolean equals(T elem1, T elem2) {
        return elem1 == null ? elem1 == elem2 : elem1.equals(elem2);
    }

    public static <T> T min(T[] array, Comparator<T> comparator) {
        T res = null;
        if (array != null && array.length > 0) {
            res = array[0];
            for (int i = 1; i < array.length; i++) {
                if (comparator.compare(res, array[i]) > 0) {
                    res = array[i];
                }
            }
        }
        return res;
    }

    public static <T> void bubbleSort(T[] array, Comparator<T> comparator) {
        int n = array.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (comparator.compare(array[i - 1], array[i]) > 0) {
                    T temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    public static<T> int binarySearch(T[] array, T key, Comparator<T> comparator){
        //TODO
        //left index = 0;
        //right index = array.length - 1
        //middle (right + left) / 2
        //left part - left index, right index = middle -1
        //right part - left index = middle + 1, right index
        //while left <= right
        //returns exactly what the standard binarySearch does
        //if there are several equaled elements no guarantee that being index is one of the first
        return 0;
    }
}
