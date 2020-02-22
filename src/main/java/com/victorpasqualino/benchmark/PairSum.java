package com.victorpasqualino.benchmark;

import java.util.Arrays;
import java.util.HashSet;

/**
 * PairSum
 */
public class PairSum {

    public static boolean n2(int[] array, int sum) {
        for (int i = 0; i < array.length; i++) {
            for(int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    return true;
                }
            }            
        }
        return false;
    }

    /**
     * Complexidade de nlogn para ordenar o array 
     * mais nlogn para percorrer o array e a busca binária
     * ou seja 2(nlogn) que é O(nlogn) 
     */
    public static boolean nlogn(int[] array, int sum) {
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            int k = sum - array[i];
            int pos = Arrays.binarySearch(array, k);
            if (pos >= 0 && pos < array.length 
                && (pos != i || (pos - 1 > 0 && array[pos -1] == k) || (pos + 1 < array.length && array[pos + 1] == k) )) {
                return true;
            }
        }
        return false;
    }

    /**
     * Complexidade de n para percorrer o array
     * mais a complexidade de calcular o hash 
     * O(n x O(calculo hash))
     * A desvantagem dessa é o dobro de memória utilizada no pior caso
     */
    public static boolean n(int[] array, int sum) {
        HashSet<Integer> set = new HashSet<>(array.length);
        for (int i = 0; i < array.length; i++) {
            int k = sum - array[i];
            if (set.contains(k)) {
                return true;
            } else {
                set.add(array[i]);
            }
        }
        return false;
    }

    /**
     * Essa solução é a melhor solução pois o calculo é feito in loco
     * O(n)
     */
    public static boolean bestN(int[] array, int sum) {
        Arrays.sort(array);
        int i = 0; 
        int j = array.length - 1; 
        while (i < j) { 
            if (array[i] + array[j] == sum) 
                return true; 
            else if (array[i] + array[j] < sum) 
                i++; 
            else 
                j--; 
        } 
        return false; 
    }

    public static void main(String[] args) {
        int[] array = {1, 10, 3, 4, 2, 3, -10};
        int sum = 8;

        System.out.println(n2(array, sum));

        System.out.println(nlogn(array, sum));

        System.out.println(n(array, sum));

        System.out.println(bestN(array, sum));
    }
    
}