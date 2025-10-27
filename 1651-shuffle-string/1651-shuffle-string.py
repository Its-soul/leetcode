class Solution(object):
    def restoreString(self, s, indices):
        mapping = dict(zip(indices, s))
        res = ''
        for i in sorted(mapping.keys()):
            res += mapping[i]
        return res
