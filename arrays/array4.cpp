#include <iostream>
#include <algorithm>
#include <vector>

// Complete the minimumSwaps function below.
int minimumSwaps(std::vector<int> arr) 
{
    int n = arr.size();
    int num_swaps = 0;
    for (int i = 0; i < n; i++)
    {
        if (arr[i] != i+1)
        {
            std::swap(arr[i], arr[arr[i] - 1]);
            num_swaps++;
            if (arr[i] != i+1) { i--; }
        }
    }
    return num_swaps;
    
}

int main()
{
    int n;
    std::cin >> n;

    std::vector<int> arr(n);
    for (int i = 0; i < n; i++)
    {
        int temp;
        std::cin >> temp;
        arr[i] = temp;
    }

    int res = minimumSwaps(arr);
    std::cout << res << std::endl;

    return 0;
}
