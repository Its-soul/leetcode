class Solution(object):
    def mapWordWeights(self, words, weights):
        alp='abcdefghijklmnopqrstuvwxyz'
        dc={}
        for i in  range(len(weights)):
            dc[alp[i]]=weights[i]
        res=''
        for word in words:
            s=0
            for i in word:
                s+=dc[i]
            p=s%26
            res+=alp[len(alp)-p-1]
        return res