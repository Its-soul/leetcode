class Solution {
    public char[][] rotateTheBox(char[][] matrix) {
        int n= matrix.length;
        int m= matrix[0].length;
        char[][] rot= new char[m][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                rot[j][n-1-i]= matrix[i][j];
            }
        }

        for(int i=0; i<n; i++) {
            int emptyRow= m-1;
            for(int j=m-1; j>=0; j--) {
                if(rot[j][i]=='*') {
                    emptyRow= j-1;
                }
                else if(rot[j][i]=='#') {
                    rot[j][i]= '.';
                    rot[emptyRow][i]= '#';
                    emptyRow--;
                }
            }
        }
        return rot;
    }
}