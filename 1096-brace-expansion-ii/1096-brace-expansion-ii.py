class Solution:
    def braceExpansionII(self, expression: str) -> List[str]:
        def solve(s):
            parts = []
            cur = ""
            level = 0

            for ch in s:
                if ch == '{':
                    level += 1
                elif ch == '}':
                    level -= 1

                if ch == ',' and level == 0:
                    parts.append(cur)
                    cur = ""
                else:
                    cur += ch

            parts.append(cur)

            if len(parts) > 1:
                ans = set()

                for part in parts:
                    ans.update(solve(part))

                return ans

            ans = {""}
            i = 0

            while i < len(s):
                if s[i].isalpha():
                    cur = {s[i]}
                    i += 1

                else:
                    j = i + 1
                    level = 1

                    while level:
                        if s[j] == '{':
                            level += 1
                        elif s[j] == '}':
                            level -= 1

                        j += 1

                    cur = solve(s[i + 1:j - 1])
                    i = j

                temp = set()

                for a in ans:
                    for b in cur:
                        temp.add(a + b)

                ans = temp

            return ans

        return sorted(solve(expression))