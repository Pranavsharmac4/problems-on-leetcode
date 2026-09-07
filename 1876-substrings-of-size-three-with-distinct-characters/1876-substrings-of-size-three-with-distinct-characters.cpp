class Solution {
public:
    int countGoodSubstrings(string s) {
        if(s.length()<3) return 0;
        unordered_map<int,int>mp;
        int i=0;
        int j=0;
        int count=0;
        while(j<3)
        {
            mp[s[j]]++;
            j++;
        }
        if(mp.size()==3)count++;
        while(j<s.length())
        {
            mp[s[i]]--;
            if(mp[s[i]]==0) mp.erase(s[i]);
            i++;
            mp[s[j]]++;
            if(mp.size()==3)count++;
            j++;
        }
        return count;
    }
};