class Solution(object):
    def countTriples(self, n):
        sq = set()
        i = 1
        while i <= n:
            sq.add(i*i)
            i += 1

        end = 0
        curr = 1

        while curr <= n:
            temp = curr*curr
            nxt = curr + 1

            while nxt <= n:
                s = temp + nxt*nxt
                if s in sq:
                    end += 2
                nxt += 1

            curr += 1

        return end
