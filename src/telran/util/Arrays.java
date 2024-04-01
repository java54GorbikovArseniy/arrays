package telran.util;

import java.util.Comparator;
import java.util.function.Predicate;

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

    public static <T> int binarySearch(T[] array, T key, Comparator<T> comp) {
        //TODO
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        int res = -1;
        boolean indexNotFound = true;
        while (leftIndex <= rightIndex && indexNotFound) {
            int middleIndex = (leftIndex + rightIndex) >>> 1;
            int comparing = comp.compare(array[middleIndex], key);
            if (comparing == 0) {
                res = middleIndex;
                indexNotFound = false;
            } else if (comparing > 0) {
                rightIndex = middleIndex - 1;
            } else {
                leftIndex = middleIndex + 1;
            }

        }
        if (indexNotFound){
            res = -(leftIndex + 1);
        }
        return res;
    }

    public static <T> T[] search(T[] array, Predicate<T> predicate) {
        //Impossible to allocate memory for generic array
        //Only Arrays.copyOf may be used
        T[] arResult = java.util.Arrays.copyOf(array, array.length);
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (predicate.test(array[i])) {
                arResult[index++] = array[i];
            }
        }
        return java.util.Arrays.copyOf(arResult, index);
    }

    public static <T> T[] removeIf(T[] array, Predicate<T> predicate) {
        /* implementation of the method, without repeating code */
        return search(array, a -> !predicate.test(a));

        /* --------- Duplicate method search() with invert condition --------- */
//        T[] arResult = java.util.Arrays.copyOf(array, array.length);
//        int index = 0;
//        for (int i = 0; i < array.length; i++) {
//            if (!predicate.test(array[i])) {
//                arResult[index++] = array[i];
//            }
//        }
//        return java.util.Arrays.copyOf(arResult, index);
    }
}
