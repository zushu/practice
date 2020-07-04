import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.HashMap;
import java.util.Arrays;

public class AnagramPairs
{

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) 
    {

        int pairCount = 0;
        // hashmap that maps sorted substrings to the number of occurences
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++)
        {
            for (int j = i; j < s.length(); j++)
            {
                // get the substring
                char[] subCharArray = s.substring(i, j+1).toCharArray();
                // sort the substring since order of chars does not matter for anagrams
                Arrays.sort(subCharArray);
                String subStr = new String(subCharArray);
                if (! map.containsKey(subStr))
                {
                    map.put(subStr, 1);
                }
                else
                {
                    map.put(subStr, map.get(subStr)+1);
                }
            }
        }

        for (String key : map.keySet())
        {
            int n = map.get(key);
            // combination of n by 2 = n! / (2! * (n-2)!) = (n * (n-1))/2
            pairCount += (n*(n-1))/2;
        }

        return pairCount;
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

