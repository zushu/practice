import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) 
    {
        long numTriplets = 0;
        long n = arr.size();

        HashMap<Long, Long> leftElems = new HashMap<>();
        HashMap<Long, Long> rightElems = new HashMap<>();

        for (int i = 0; i < n; i++)
        {
            long elem = arr.get(i);
            if (rightElems.containsKey(elem))
            {
                rightElems.put(elem, rightElems.get(elem)+1l);
            }
            else
            {
                rightElems.put(elem, 1l);
            }
        }

        for (int i = 0; i < n; i++)
        {
            long leftCount = 0;
            long rightCount = 0;

            long elem = arr.get(i);

            if (elem % r == 0)
            {
                if (leftElems.containsKey(elem/r))
                {
                    leftCount = leftElems.get(elem/r);
                }
            }

            // in the subsequent iterations, even if there is an element a[i]*r to the left of a[i], do not take it into account
            rightElems.put(elem, rightElems.get(elem)-1);

            if (rightElems.containsKey(elem*r))
            {
                rightCount = rightElems.get(elem*r);
            }

            numTriplets += leftCount * rightCount;

            // put a[i] to leftElems, it can be left element of another triplet with a middle element of value a[i]*r at a bigger index
            if (leftElems.containsKey(elem))
            {
                leftElems.put(elem, leftElems.get(elem)+1l);
            }
            else
            {
                leftElems.put(elem, 1l);
            }
        }
        
        return numTriplets;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

