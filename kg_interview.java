package com.company;

import java.util.*;


public class kg_interview {

  public static void testCase() {
    String s1 = "bar", s2 = "foo";
    System.out.println("test case with: \n" + s1 + "\n" + s2 + "\n" + checkMapOneToOne(s2, s1));
    s1 = "abc";
    s2 = "bcd";
    System.out.println("test case with: \n" + s1 + "\n" + s2 + "\n" + checkMapOneToOne(s2, s1));
    s1 = "foo";
    s2 = "bar";
    System.out.println("test case with: \n" + s1 + "\n" + s2 + "\n" + checkMapOneToOne(s2, s1));
  }

  public static boolean checkMapOneToOne(String s1, String s2) {
        /* the idea is calculating the occurrence of the characters from both strings
         And then check the occurrence of characters from both strings to evaluate the ability of mapping
         Complexity O(n)
         */
    // if s1.length is larger than s2.length.
    // then we cannot checkMapOneToOne very character from s1 to s2 while still remain one-to-one
    if (s1.length() > s2.length()) {
      return false;
    }
    int SIZE_OF_ASCII = 128;
    // we make an assumption that the characters are in the standard ASCII code
    // 128 characters in ASCII code
    int[] countDub1 = new int[SIZE_OF_ASCII];
    int[] countDub2 = new int[SIZE_OF_ASCII];
    // set 0 means the character hasn't appeared yet
    Arrays.fill(countDub1, 0);
    Arrays.fill(countDub2, 0);
    // count the number of the characters appear in a string
    for (int i = 0; i < s2.length(); i++) {
      countDub2[s2.charAt(i)]++;
        if (i < s1.length()) {
            countDub1[s1.charAt(i)]++;
        }
    }
    Arrays.sort(countDub1);
    Arrays.sort(countDub2);
    int temp = countDub1[SIZE_OF_ASCII - 1];
    while (temp > 0) {
        if (countDub1[SIZE_OF_ASCII - 1] > countDub2[SIZE_OF_ASCII - 1]) {
            return false;
        } else {
            countDub2[SIZE_OF_ASCII - 1] -= countDub1[SIZE_OF_ASCII - 1];
            countDub1[SIZE_OF_ASCII - 1] = 0;
            inserstionSort(countDub1);
            inserstionSort(countDub2);
            temp = countDub1[SIZE_OF_ASCII - 1];
        }
    }
    return true;
  }

  public static void inserstionSort(int[] arr) {
    int key = arr[arr.length - 1];
    int j = 126;
    while (j >= 0 && arr[j] > key) {
      arr[j + 1] = arr[j];
      j = j - 1;
    }
    arr[j + 1] = key;
  }

  public static void main(String[] args) {
    System.out.println(checkMapOneToOne(args[0], args[1]));
  }
}


