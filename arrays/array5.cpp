#include <iostream>
#include <vector>
#include <algorithm>
#include <limits>

// Complete the arrayManipulation function below.
long arrayManipulation(int n, std::vector< std::vector<int> > queries) {
    int m = queries.size();
    std::vector<int> arr(n, 0);
    long max_val = 0;
    int a = 0, b = 1, k = 2;

    // turn arr into a prefix sum array
    for (auto op : queries)
    {
         arr[op[a] - 1] += op[k];
         if (op[b] != n)
         {
             arr[op[b]] -= op[k];
         }
    }

    long temp = 0;
    // find max sum in the array
    for (auto val : arr)
    {
        temp += val;
        if (temp > max_val)
            max_val = temp;
    }
    return max_val;
}

int main()
{
    int n, m;
    std::cin >> n >> m;

    std::vector< std::vector<int> > queries(m);

    for (int i = 0; i < m; i++)
    {
        queries[i].resize(3);
        for (int j = 0; j < 3; j++)
        {
            std::cin >> queries[i][j];
        } 
        std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
    }

    long result = arrayManipulation(n, queries);

    std::cout << result << std::endl;

    return 0;
}

