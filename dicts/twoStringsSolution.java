import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.HashMap;

public class twoStringsSolution {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) 
    {
        HashMap<Character, Boolean> s1_hashmap = new HashMap<Character, Boolean>();
        for (int i = 0; i < s1.length(); i++)
        {
            s1_hashmap.put(s1.charAt(i), true);
        }

        for (int i = 0; i < s2.length(); i++)
        {
            Boolean temp = s1_hashmap.get(s2.charAt(i));
            if (temp != null && temp)
            {
                return "YES";
            }
        }
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

