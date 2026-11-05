class Solution(object):
    def findTheDistanceValue(self, arr1, arr2, d):
        # ans = set(arr1)
        # for i in range(len(arr1)):
        #     for j in range (len(arr2)):
        #         if abs(arr1[i] - arr2[j]) <= d:
        #             ans.discard(arr1[i])
        # return len(ans)

        count = 0
        
        for x in arr1:
            valid = True
            for y in arr2:

                if abs(x - y) <= d:
                    valid = False
                    break

            if valid:
                count += 1

        return count