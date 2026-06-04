class Solution(object):
    def totalWaviness(self, num1, num2):
        total=0
        for  i in range (num1,num2+1):
            s=str(i)
            
            for j in range (1,len(s)-1):
                prev=s[j-1]
                current=s[j]
                step1=s[j+1]
                if current>prev and current > step1 :
                    total= total+1
                elif current < prev and current <step1 :
                    total=total +1
        return total
        
        