#include <bits/stdc++.h>

using namespace std;

// Complete the countingValleys function below.
int countingValleys(int n, string s) 
{
    int level = 0;
    int result = 0;

    int i1 = 0; // mountain or valley start index
    int i2 = i1; // string iteration index
    while(i1 != n || i2 != n)
    {
        if (s[i2] == 'U') { level++; }
        else if (s[i2] == 'D') { level--; }
        // TODO: should i check '\0' ?
        if (level == 0)
        {
            // check valley
            if (s[i1] == 'D') { result++; }
            i1 = ++i2;
            continue;
        }
        i2++;
    }

    return result;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    string s;
    getline(cin, s);

    int result = countingValleys(n, s);

    fout << result << "\n";

    fout.close();

    return 0;
}

