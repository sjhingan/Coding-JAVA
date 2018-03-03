package com.sushantjhingan;

/**
 * QUESTION:
 * 
 * Given an array (A) of length N and a window of length K such that k<=N, 
 * find the difference between increasing contiguous subsets and decreasing contiguous subsets 
 * for each possible window in that array A.
 * 
 * @author Sushant Jhingan
 *
 */
public class SubrangeDifference {
	
	public static void main(String[] args) {

		String input = "188930 144123 201345 154243 164243";
		int K = 5;
		String[] inputArray = input.split(" ");
		int N = inputArray.length;
		
		calculateSubrangeDiff(K, inputArray, N);
	}

	private static void calculateSubrangeDiff(int K, String[] inputArray, int N) {
		
		for(int i = 0; i< N; i++ ){
			
			if(i+K <= inputArray.length){
				System.out.println(calDifference(i, K, inputArray));
				
			}else{
				break;
			}
		}
	}

	private static int calDifference(int start, int length, String[] inputArray) {
		
		int increasingCount = 0;
		int decreasingCount = 0;
		int ilen = 1;
		int dlen = 1;
		for(int i= start; i< start+length-1; i++){
			if (Integer.parseInt(inputArray[i + 1]) > Integer.parseInt(inputArray[i])){
                ilen++;
                
                decreasingCount += (((dlen - 1) * dlen) / 2);
                dlen = 1;
			}else if (Integer.parseInt(inputArray[i + 1]) < Integer.parseInt(inputArray[i]))
            {
				increasingCount += (((ilen - 1) * ilen) / 2);
                ilen = 1;
                dlen++;
            }
			
		}
		// LOGIC: a sorted subarray of length ‘len’ adds len*(len-1)/2 to result
		if (ilen > 1)
			increasingCount += (((ilen - 1) * ilen) / 2);
		if (dlen > 1)
			decreasingCount += (((dlen - 1) * dlen) / 2);
		return increasingCount - decreasingCount ;
	}
}
