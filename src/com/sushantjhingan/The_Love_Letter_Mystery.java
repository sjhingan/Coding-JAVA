import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the theLoveLetterMystery function below.
    static int theLoveLetterMystery(String s) {
        
        int length = s.length();
        int forward = 0;
        int backward = length - 1;
        int operations = 0;
        while (backward > forward) {
            char forwardChar = s.charAt(forward++);
            char backwardChar = s.charAt(backward--);
            while (forwardChar != backwardChar){
                int backwardIntVal = (int) backwardChar;
                int fwdIntVal = (int) forwardChar;
                if(fwdIntVal > backwardIntVal){
                    forwardChar = (char)(fwdIntVal -1);
                    operations++;
                }else{
                    backwardChar = (char)(backwardIntVal -1);
                    operations++;
                }
                
                
            }
        }
        return operations;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = theLoveLetterMystery(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
