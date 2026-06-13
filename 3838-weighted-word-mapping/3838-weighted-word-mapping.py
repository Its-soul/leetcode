class Solution(object):
    def mapWordWeights(self, words, weights):
        res= ""
        for i in words:
            total=0
            for ch in i:
                idx= ord(ch)- ord('a')
                total+=weights[idx]

            modval= total%26
            new_map= chr(ord('z')- modval)
            res+=new_map
        return res