class Solution(object):
    def asteroidsDestroyed(self, mass, ast):
        ast.sort()
        summ= mass
        if mass<ast[0]:
            return False
        for i in range(len(ast)-1):
            if summ+ast[i]<ast[i+1]:
                return False
            summ+=ast[i]
        return True