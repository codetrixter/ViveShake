public class SecondProgram {
    public static void main(String args []) {
        //WAP which will take input n and store 1 to n*n nums in nxn matrix in zigzag manner
     
        // Ex 1:n = 2 then:
        // [[1,2]
        //  [4,3]]

        // Ex 2:n = 3 then:
        // [[1,2,3]
        //  [6,5,4]
        //  [7,8,9]]

          // Ex 3:n = 4 then:
        // [[1,2,3,4]
        //  [8,7,6,5]
        //  [9,10,11,12]
        //  [16,15,14,13]]

        int [][] mat = createMatrix(3);
        int [][] mat2 = createMatrix(4);
        printMatrix(mat);
        printMatrix(mat2);
    }

    private static int[][] createMatrix(int n) {
        int [][] matrix = new int[n][n];

        // This num is stored in matrix[i][j] = num++;  (1 <= num <= n*n)
        int num = 1;

        // Col value will change 0 to n-1 and then n-1 to 0
        // if increasing is true then: j -> 0 to n-1
        // else false then: j -> n-1 to 0
        boolean increasing = true;

        for(int i = 0; i < n; i++) { //row 
            if(increasing) {
                for(int j = 0; j < n; j++) {
                    matrix[i][j] = num++;
                }
                //next it should go in else case
                increasing = false;
            } else {
                for(int j = n-1; j >= 0; j--) {
                    matrix[i][j] = num++;
                }
                //next it should go in if case
                increasing = true;
            }
        }


        return matrix;
     }


     private static void printMatrix(int [][] matrix) {
         int n = matrix.length;//it is n*n

         for(int i = 0; i < n; i++) {
             for(int j = 0; j < n; j++) {
                 System.out.print(matrix[i][j]+" ");
             }
             System.out.println();
         }
     }
}
