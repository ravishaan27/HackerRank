import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class NumericString {

    static int getMagicNumber(String s, int k, int b, int m){
        int len = s.length();
        String[] sk = new String[len - k + 1];
		int[] skbase10 = new int[sk.length];
		int modulo = 0;
		String tmp;
        
        for(int i = 0; i < sk.length; i++){
			skbase10[i] = 0;
            if(i < sk.length){
				tmp = "";
				for(int l=0;l<k;l++)
					tmp += s.charAt(i+l);
				sk[i] = tmp;
            }

			for(int j = 0; j < sk[i].length();j++){
				String t = sk[i].charAt(j) + "";
				skbase10[i] += Integer.parseInt(t.trim()) * Math.pow(b,(sk[i].length() - j - 1));
			}
			
			
			modulo += skbase10[i] % m;
			
        }
        return modulo;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int k = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int result = getMagicNumber(s, k, b, m);
        System.out.println(result);
    }
}
