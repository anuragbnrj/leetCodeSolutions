class RandomizedSet {
private:
    unordered_set<int> stt;
public:
    RandomizedSet() {
        ios_base::sync_with_stdio(false); 
    }
    
    bool insert(int val) {
        if (!stt.count(val)) {
            stt.insert(val);
            return true;
        } else {
            return false;
        }
    }
    
    bool remove(int val) {
        auto it = stt.find(val);
        if (it != stt.end()) {
            stt.erase(it);
            return true;
        } else {
            return false;
        }
    }
    
    int getRandom() {
        int randomIndex = rand() % stt.size();

        // Use an iterator to select the element at the random index
        auto it = next(stt.begin(), randomIndex);

        // Access the randomly chosen element
        int randomElement = *it;

        return randomElement;
    }
};

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet* obj = new RandomizedSet();
 * bool param_1 = obj->insert(val);
 * bool param_2 = obj->remove(val);
 * int param_3 = obj->getRandom();
 */