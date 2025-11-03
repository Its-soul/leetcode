class Solution(object):
    def minCost(self, colors, neededTime):
        n = len(colors)
        total = 0
        i = 0
        while i < n:
            j = i
            max_ = 0
            sum_time = 0
            while j < n and colors[j] == colors[i]:
                sum_time += neededTime[j]
                max_ = max(max_, neededTime[j])
                j += 1
            total += sum_time - max_
            i = j
        return total
