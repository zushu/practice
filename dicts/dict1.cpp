#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

// Complete the checkMagazine function below.
void checkMagazine(vector<string> magazine, vector<string> note) 
{
    unordered_map <string, int> magazine_map;
    unordered_map <string, int> note_map;

    int m = magazine.size(), n = note.size();
    for (int i = 0; i < m; i++)
    {
        magazine_map[magazine[i]]++;
    }

    for (int i = 0; i < n; i++)
    {
        note_map[note[i]]++;
    }

    for (int i = 0; i < n; i++)
    {
        if (magazine_map[note[i]])
        {
            --magazine_map[note[i]];
            continue;
        }
        if (magazine_map[note[i]] == 0)
        {
            std::cout << "No\n";
            return;
        }

    }
    std::cout << "Yes\n";
}    

int main()
{

    int m, n;
    std::cin >> m >> n;
    vector<string> magazine(m);

    for (int i = 0; i < m; i++) {
        string magazine_item;

        std::cin >> magazine_item;
        magazine[i] = magazine_item;
    }

    vector<string> note(n);

    for (int i = 0; i < n; i++) {
        string note_item;

        std::cin >> note_item;
        note[i] = note_item;
    }

    checkMagazine(magazine, note);

    return 0;
}

