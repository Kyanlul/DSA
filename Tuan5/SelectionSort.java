package Tuan5;

import edu.princeton.cs.algs4.In;

public class SelectionSort {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        In input = new In("C:\\MY PRJ\\Ky 1 Nam 2\\CTDLGT\\dsa-main\\Tuan5\\1Mints.txt");
        int[] a = input.readAllInts();
        for(int i = 0; i < a.length; i++) {
            int min = i;
            for(int j = i + 1; j < a.length; j++) {
                if(a[j] < a[min]) {
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }
}