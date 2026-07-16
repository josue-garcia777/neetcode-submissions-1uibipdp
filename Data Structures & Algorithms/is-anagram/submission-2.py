class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        
        freqs = Counter(s)
        freqt = Counter(t)

        for c, freq in freqs.items():
            if freqt[c] != freq:
                return False
        
        return True