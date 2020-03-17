package com.company;
import java.util.HashSet;
import java.util.Scanner;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        String t=testcase();
        System.out.println(testcase());
    }
    public static String testcase(){
        String s1="aac",s2="bcd";

        return "test case with: \n"+s1+"\n"+s2+"\n"+map(s1,s2);
    }
    public static boolean map(String s1, String s2){
        if(s1.length()>s2.length()){
            return false;
        }
        int[]  countdub1= new int[128];
        int[]  countdub2= new int[128];
        Arrays.fill(countdub1,0);
        Arrays.fill(countdub2,0);
        for(int i=0; i<s2.length();i++){
            countdub2[s2.charAt(i)]++;
            if(i<s1.length())
                countdub1[s1.charAt(i)]++;
        }
        Arrays.sort(countdub1);
        Arrays.sort(countdub2);
        for(int i=127;i>=0;i--){
            if(countdub1[i]>countdub2[i])
                return false;
        }
        return true;
    }
}
