class Solution(object):
    def minCost(self, colors, neededTime):
        l = res = 0
        for r in range(1, len(colors)):
            if colors[l] == colors[r]:
                if neededTime[l] < neededTime[r]:
                    res += neededTime[l]
                    l=r
                else:
                    res+= neededTime[r]
            else:
                l=r

        return res