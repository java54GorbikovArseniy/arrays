package telran.util.test;

import java.util.Comparator;

public class EvenOddComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer a, Integer b) {
        int res = 1;
        if (a % 2 == 0 && b % 2 == 0) res = a - b;
        else if (a % 2 != 0 && b % 2 != 0) res = b - a;
        else if (a % 2 == 0) res = -1;
        return res;
    }
}