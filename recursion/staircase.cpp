//#include <bits/stdc++.h>
#include <iostream>
#include <vector>
//#include <utility> // for pair<>

using namespace std;

std::vector<int> helper(int n);
// Complete the stepPerms function below.
int stepPerms(int n) 
{
    /*
    if (n == 1) { return 1; }
    if (n == 2) { return 2; }
    if (n == 3) { return 4; } // 3, 2 1, 1 2, 1 1 1
    
    return (stepPerms(n-1) + stepPerms(n-2) + stepPerms(n-3)) % 10000000007;
*/
    vector<int> res = helper(n);
    return res[2];

}

std::vector<int> helper(int n)

{
    vector<int> interm_result;
    vector<int> result;
    if (n == 1) 
    { 
        int temp[] = {0, 0, 1};
        result.assign(temp, temp + 3);
        return result; 
    }
    if (n == 2)
    {
        int temp[] = {0, 1, 2};
        result.assign(temp, temp+3);
        return result;
    }
    if (n == 3)
    {
        int temp[] = {1, 2, 4};
        result.assign(temp, temp+3);
        return result;
    }

    interm_result = helper(n-1);
    result.push_back(interm_result[1]);
    result.push_back(interm_result[2]);
    result.push_back(interm_result[0] + interm_result[1] + interm_result[2]);
    
    return result;


        
}

int main()
{
//    ofstream fout(getenv("OUTPUT_PATH"));

    int s;
    cin >> s;
  //  cin.ignore(numeric_limits<streamsize>::max(), '\n');

    for (int s_itr = 0; s_itr < s; s_itr++) {
        int n;
        cin >> n;
    //    cin.ignore(numeric_limits<streamsize>::max(), '\n');

        int res = stepPerms(n);

        cout << res << "\n";
    }

    //fout.close();

    return 0;
}

