//#include <bits/stdc++.h>
#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <fstream>

using namespace std;

vector<string> split_string(string);

// Complete the minimumSwaps function below.
int minimumSwaps(vector<int> arr) 
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
    cin >> n;

    vector<int> arr(n);
    for (int i = 0; i < n; i++)
    {
        int temp;
        cin >> temp;
        arr[i] = temp;
    }

    int res = minimumSwaps(arr);
    std::cout << res << std::endl;

    return 0;
}
