class Solution(object):
    def divide(self, dividend, divisor):
        if dividend == -2**31 and divisor == -1:
            return 2**31 - 1
        return int(float(dividend)/ divisor)
# in older version of python we donot get the float value so we must use float on the dividend
# to get that point value..