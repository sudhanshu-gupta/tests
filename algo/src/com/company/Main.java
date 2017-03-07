package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        combination("abc");
    }

    static void combination(String str) {
        Map<Integer, List<String>> map = new HashMap<>();
        char [] array = str.toCharArray();
        Arrays.sort(array);
        for(int i=1;i<=array.length;i++) {
            map.put(i, new ArrayList<>());
        }
        combine(new String(array), new StringBuilder(), 0);
        for(int i=1;i<=array.length;i++) {
            for(String s: map.get(i))
                System.out.println(s);
        }
    }

    void printCombination(String str) {
        int n = str.length();
        for(int L=1;L<=n;L++) {
            for(int i=0;i<n-L+1;i++) {
                int j=i+L-1;
                System.out.println("i "+i+" j "+j);
                String tmpstr = "";
                for(int k=i;k<=j;k++)
                    tmpstr += str.charAt(k);
                System.out.println(tmpstr);
            }
        }

    }

    static void combine(String instr, StringBuilder outstr, int index) {
        for (int i = index; i < instr.length(); i++)
        {
            outstr.append(instr.charAt(i));
            System.out.println(outstr.toString());
            combine(instr, outstr, i + 1);
            outstr.deleteCharAt(outstr.length() - 1);
        }
    }

    static void print(String instr, StringBuilder outstr, int index) {
        for (int i = index; i < instr.length(); i++)
        {
            outstr.append(instr.charAt(i));
            System.out.println(outstr);
            outstr.deleteCharAt(outstr.length() - 1);
        }
    }


}
