class Solution(object):
    def asteroidsDestroyed(self, mass, ast):
        ast.sort()
        for a in ast:
            if mass < a:
                return False
            mass += a

        return True