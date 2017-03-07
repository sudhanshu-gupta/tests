package com.company;

import java.util.Arrays;

/**
 * Created by sgupta on 11/17/16.
 */
public class Lex {

    public static void main(String[] args) {
        Lex lex = new Lex();
        lex.combination("bacfge");
    }


    void combinationRec(char [] arr, char [] c, int at, int i) {
        if(at==c.length) {
            System.out.println(new String(c));
            return;
        }

        for(int j=i;j<arr.length;j++) {
            c[at] = arr[j];
            combinationRec(arr, c, at + 1, j + 1);
        }
    }

    void combination(String str) {
        char [] array = str.toCharArray();
        Arrays.sort(array);
        for(int i=1;i<=array.length;i++) {
            char [] cinit = new char[i];
            combinationRec(array, cinit, 0, 0);
        }
    }
}
