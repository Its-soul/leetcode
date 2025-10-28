class Solution(object):
    def checkIfPangram(self, sen):
        return True if len(set(sen))>=26 else False