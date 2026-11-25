from collections import Counter

class Solution:
    def smallestUniqueSubarray(self,nums):
        n=len(nums)
        mod1,mod2=10**9+7,10**9+9
        base1,base2=100003,100019

        def check(size):
            pow1,pow2=pow(base1,size,mod1),pow(base2,size,mod2)
            hash1=hash2=0

            for i in range(size):
                hash1=(hash1*base1+nums[i])%mod1
                hash2=(hash2*base2+nums[i])%mod2

            hashes=[(hash1,hash2)]

            for i in range(size,n):
                hash1=(hash1*base1+nums[i]-nums[i-size]*pow1)%mod1
                hash2=(hash2*base2+nums[i]-nums[i-size]*pow2)%mod2
                hashes.append((hash1,hash2))

            return 1 in Counter(hashes).values()

        left,right,ans=1,n,n

        while left<=right:
            mid=(left+right)//2
            if check(mid):
                ans=mid
                right=mid-1
            else:
                left=mid+1

        return ans