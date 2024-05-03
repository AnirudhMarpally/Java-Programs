package hackerRankprograms;

import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args)  {
       
    	int l=2;
        int plus=2;
        int minus=1;
        int zero=3;
        DecimalFormat df = new DecimalFormat("0.000000");
        
        

        System.out.println(df.format((float)plus/l));
        System.out.println(df.format((float)minus/l));
        System.out.println(df.format((float)zero/l));
       

    }
}
