class Solution(object):
    def stableMountains(self, height, threshold):
        res=[]
        for i in range (1, len(height)):
            if height[i-1]>threshold:
                res.append(i)
        return res