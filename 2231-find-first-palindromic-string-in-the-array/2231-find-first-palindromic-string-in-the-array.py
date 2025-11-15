class Solution(object):
    def firstPalindrome(self, words):
        for i in words:
            if self.palindrome(i):
                return i
        return ""
    def palindrome(self,a):
        n=len(a)
        left=0
        right=n-1
        while left<right:
            if a[left]!=a[right]:
                return False
            left+=1
            right-=1
        return True