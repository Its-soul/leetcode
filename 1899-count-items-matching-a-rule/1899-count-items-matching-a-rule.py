class Solution(object):
    def countMatches(self, items, ruleKey, ruleValue):
        attr = {"type": 0, "color": 1, "name": 2}
        target = attr[ruleKey]

        count = 0
        for item in items:
            if item[target] == ruleValue:
                count += 1

        return count
