#include <iostream>
#include <vector>
#include <string>

using namespace std;

struct empty_space
{
    short row_num;
    short col_num;
    short len;
    char dir;
    bool is_used;
};

vector<string> split(string words);
// Complete the crosswordPuzzle function below.
vector<string> crosswordPuzzle(vector<string> crossword, string words) 
{
    vector<string> words_list = split(words);

    int index_of_common_letter = -1;

    for (int i = 0; i < 10; i++)
    {
        for (int j = 0; j < 10; j++)
        {
            int rightcounter = 0;
            if (crossword[i][j] == '-')
            {
                if (crossword[i][j+1] == '-') // to the right
                {
                    rightcounter++;
                }

                if (crossword[i+1][j] == '-') // downward 
                {
                    index_of_common_letter = rightcounter - 1;
                }

                if (crossword[i][j+1] == '+')
                {
                    // done
                    // check for word of len == rightcounter
                    // and letter at index_of_common_letter matches the index of letter at another word

                }
            }
        }
    }
     


}

find_spaces

vector<string> split(string words)
{
    vector<string> result;
    int len = words.length();
    string item;
    for (int i = 0; i <= len; i++)
    {
        if (words[i] == ';' || i == len)
        {
            result.push_back(item);
            item.clear();
            continue;
        }
        item.push_back(words[i]);
    }
    return result;
}

int main()
{
//    ofstream fout(getenv("OUTPUT_PATH"));

    vector<string> crossword(10);

    for (int i = 0; i < 10; i++) {
        string crossword_item;
        std::cin >> crossword_item;
//        getline(cin, crossword_item);

        crossword[i] = crossword_item;
    }

    string words;
    std::cin >> words;
 //   getline(cin, words);

    vector<string> result = crosswordPuzzle(crossword, words);

    for (int i = 0; i < result.size(); i++) {
        cout << result[i];

        if (i != result.size() - 1) {
            cout << "\n";
        }
    }

    cout << "\n";

    //fout.close();

/*    vector<string> words_list = split(words);
    for (int i = 0; i < words_list.size(); i++)
    {
        std::cout << words_list[i] << std::endl;
    }
*/
    return 0;
}

