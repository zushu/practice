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

public class freqQueries {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) 
    {
        List<Integer> outputList = new ArrayList<Integer>();
//        List<Integer> resultList = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        
        int n = queries.size();

        for (int i = 0; i < n; i++)
        {
            int op = queries.get(i).get(0);
            int val = queries.get(i).get(1);
            if (op == 1) // insert
            {
                if (map.containsKey(val))
                {
                    map.put(val, map.get(val)+1);
                }
                else
                {
                    map.put(val, 1);
                }
            }
            else if (op == 2) // delete
            {
                if (map.containsKey(val))
                {
                    map.put(val, map.get(val)-1);
                }
                /*else
                {
                    map.put(val, 0);
                }*/
            }
            else if (op == 3) // check frequency
            {
                if (val == 0)
                {
                    outputList.add(1);
                    continue;
                }
                
                if (map.values().contains(val))
                {
                    outputList.add(1);
                }
                else
                {
                    outputList.add(0);
                }

            }
        }

    
        return outputList;
        


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        file.createNewFile();
  //      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
            ans.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

