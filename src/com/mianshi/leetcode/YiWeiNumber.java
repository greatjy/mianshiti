package com.mianshi.leetcode;

import java.awt.Image;

public class YiWeiNumber
{
    public static void main(String[] args)
	{
	     String string = "mkgfzkkuxownxvfvxasy";
	     int[] shifts = {505870226,437526072,266740649,224336793,532917782,311122363,567754492,595798950,81520022,684110326,137742843,275267355,856903962,148291585,919054234,467541837,622939912,116899933,983296461,536563513};
	     
	     System.out.println(shiftLetter(string, shifts));
	}
    
    public static String shiftLetter(String s,int[] shifts)
    {
    	if(shifts.length == 0)
    		return s;
    	char[] charArray = s.toCharArray();
    	int[] newShifts = new int[shifts.length];
    	int len = shifts.length;
    	newShifts[len-1] = shifts[len-1];
    	if(len>=2)
    	{
	    	for(int i=shifts.length-2;i>=0;i--)
	    	{
	    	   newShifts[i] = (newShifts[i+1] + shifts[i])%26;
	    	   System.out.println(newShifts[i]);
	    	}
    	}
    	for(int i=0;i<shifts.length;i++)
    	{
    			//shift(s.charAt(j),shifts[i]);
    			int number = charArray[i]-'a';
    	        int nx = (number+newShifts[i])%26;
    	        charArray[i] =  (char)(nx+'a');
    	        //System.out.println(i+" "+j+" "+new String(charArray));    		
    	}
    	return new String(charArray);
    }
}
