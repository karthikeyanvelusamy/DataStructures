package com.decoderz.ds.linkedlist;
import java.io.*;
import java.util.*;


public class Tst {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            String[] data = br.readLine().trim().split(" ");
            long n = Long.parseLong(data[0]);
            long a = Long.parseLong(data[1]);
            long b = Long.parseLong(data[2]);
            long c = Long.parseLong(data[3]);

            long out_ = divisibilty(a, c, b, n);
            System.out.println(out_);
         }

         wr.close();
         br.close();
    }
    static long divisibilty(long a, long c, long b, long n){
        // Write your code here
        
        long gcdNum = gcd(a,gcd(b,c));
        return gcdNum;
        
    
    }
    
    static long gcd(long a,long b){
        
        if(b!=0){
            return gcd(b,a%b);
        }else {
            return a;
        }
    }
}