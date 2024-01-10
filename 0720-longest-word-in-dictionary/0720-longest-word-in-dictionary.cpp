struct Node {
    Node *links[26];
    int countEndsWith = 0;
    int countPrefix = 0;
    
    bool containsKey(char ch) {
        return (links[ch - 'a'] != nullptr);
    }

    Node* get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, Node *node) {
        links[ch - 'a'] = node;
    }

    void increaseEnd() {
        countEndsWith++;
    }

    void increasePrefix() {
        countPrefix++;
    }

    void reduceEnd() {
        countEndsWith--;
    }

    void reducePrefix() {
        countPrefix--;
    }

    int getEndsWith() {
        return countEndsWith;
    }

    int getPrefix() {
        return countPrefix;
    }
};

class Trie {
private:
    Node *root;

public:
    Trie() {
        root = new Node ();
    }

    void insert(string word) {
        Node * node = root;
        for (int i = 0; i < word.size(); i++) {
            if (!node->containsKey(word[i])) {
                node->put(word[i], new Node());
            }
            node = node->get(word[i]);
            node->increasePrefix();
        }
        node->increaseEnd();
    }

    int countWordsEqualTo(string &word) {
        Node *node = root;
        for (int i = 0; i < word.size(); i++) {
            if (node->containsKey(word[i])) {
                node = node->get(word[i]);
            } else {
                return 0;
            }
        }
        return node->getEndsWith();
    }

    int countWordsStartingWith(string &word) {
        Node *node = root;
        for (int i = 0; i < word.size(); i++) {
            if (node->containsKey(word[i])){
                node = node->get(word[i]);
            } else {
                return 0;
            }
        }
        return node->getPrefix();
    }

    void erase(string &word) {
        Node *node = root;
        for (int i = 0; i < word.size(); i++) {
            if (node->containsKey(word[i])) {
                node = node->get(word[i]);
                node->reducePrefix();
            } else {
                return;
            }
        }
        node->reduceEnd();
    }

};

class Solution {
public:
    string longestWord(vector<string>& words) {
        Trie trie;

        for (string word : words) {
            trie.insert(word);
        }

        string res = "";
        for (string word : words) {
            string temp = "";
            bool contains = true;
            for (int i = 0; i < word.size(); i++) {
                temp = temp + word[i];
                if (trie.countWordsEqualTo(temp) <= 0) {
                    contains = false;
                    break;
                }
            }

            if (contains) {
                if (word.size() > res.size()) {
                    res = word;
                } else if (word.size() == res.size()) {
                    if (word < res) {
                        res = word;
                    }
                }
            }
        }

        return res;
    }
};