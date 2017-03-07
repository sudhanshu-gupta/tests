package com.company;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sgupta on 11/18/16.
 */
public class zalando {
    public int solution(int[] A, int[] B, int M, int X, int Y) {
        // write your code in Java SE 8

        int i=0;
        int count=0;

        while(i<A.length) {
            Set<Integer> set = new HashSet<>();
            int wt = 0;
            int pC = 0;
            while(i<A.length && pC<=X && wt<=Y) {
                set.add(B[i]);
                pC++;
                wt += A[i];
                i++;
            }
            count += set.size();
            count++;
        }
        return count;

    }
}
