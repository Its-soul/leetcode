class Solution(object):
    def totalMoney(self, n):
        total = 0
        monday = 1
        
        for day in range(1, n + 1):
            total += monday + (day - 1) % 7
            if day % 7 == 0:
                monday += 1
        
        return total