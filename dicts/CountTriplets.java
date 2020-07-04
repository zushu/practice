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
        HashMap<Integer, List<Integer>> mapDoubles = new HashMap<>();

        for (Integer i = 0; i < arr.size(); i++)
        {
            for (Integer j = 0; j < arr.size(); j++)
            {
                if (arr.get(j) == arr.get(i) * r)
                {
                    if (! mapDoubles.containsKey(i))
                    {
                        mapDoubles.put(i, Arrays.asList(j));
                    }
                    else
                    {
                        ArrayList<Integer> secList = new ArrayList<Integer>(mapDoubles.get(i)); 
                        secList.add(j);
                        mapDoubles.put(i, secList);
                    }

                }
            }
        }

        for (Integer key : mapDoubles.keySet())
        {
            ArrayList<Integer> secondElems = new ArrayList<Integer>(mapDoubles.get(key));
            for (Integer secElem : secondElems)
            {
                for (Integer k = secElem; k < arr.size(); k++)
                {
                    if (arr.get(k) == arr.get(secElem) * r)
                    {
                        numTriplets++;
                    }
                }
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

