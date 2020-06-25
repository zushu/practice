#include <bits/stdc++.h>

using namespace std;

// Complete the repeatedString function below.
long repeatedString(string s, long n) {
    long a_count = 0;
    long s_len = s.length();
    long rep_count = n / s_len;
    long rest = n % s_len;

    for (long j = 0; j < s_len; j++)
    {
        if (s[j] == 'a') { a_count++; }
    }
    a_count *= rep_count;

    for (long j = 0; j < rest; j++)
    {
        if (s[j] == 'a') { a_count++; }
    }
    return a_count;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string s;
    getline(cin, s);

    long n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    long result = repeatedString(s, n);

    fout << result << "\n";

    fout.close();

    return 0;
}

