package com.sushantjhingan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/**
 * Run-length encoding (RLE) is a very simple form of data compression in which runs of data 
 * (that is, sequences in which the same data value occurs in many consecutive data elements) 
 * are stored as a single data value and count, rather than as the original run. (Wikipedia)
 * 
 * @author Sushant Jhingan
 *   Complexity O(n)
 */
public class RunLengthEncoding {
	 
    private static String method1(String input) {
	    StringBuilder output = new StringBuilder();

	    for (int i = 0, count = 1; i < input.length(); i++) {
	        if (i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1))
	            count++;
	        else {
	            output = output.append(Integer.toString(count))
	                    .append(Character.toString(input.charAt(i)));
	            count = 1;
	        }
	    }
	    return output.toString();
	}
	
	
    private static String method2(String source) {
        StringBuffer dest = new StringBuffer();
        for (int i = 0; i < source.length(); i++) {
            int runLength = 1;
            while(i+1 < source.length() && source.charAt(i) == (source.charAt(i+1))) 
            {
                runLength++;
                i++;
            }
            
            dest.append(source.charAt(i));
            dest.append(runLength);
        }
        return dest.toString();
    }
    private static String method3(String input) {
        
        if(input.equals("") || input.trim().equals("")){
            return "";
        }
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        List<Character> list = new ArrayList<Character>();
        for(int i=0;i<input.length();i++){
            if(map.get(input.charAt(i)) != null){
            	int count = map.get(input.charAt(i)) + 1;
            	
            	map.put(input.charAt(i), count);
                
            }else{
            	map.put(input.charAt(i), 1);
            	list.add(input.charAt(i));
            }
        }
        StringBuilder builder = new StringBuilder();
        for(Character s: list){
        	builder.append(map.get(s));
        	builder.append(s);
        }

        return builder.toString();
    }
    
 
    public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println(method1(s));
     
    }
}
