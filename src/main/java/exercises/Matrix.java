package exercises;

public class Matrix {

    public void matrixTraversal(){
        int[][] matrix = new int[4][4];
        initialize(matrix);
        displayMatrix(matrix);
        System.out.println("Traverse");
        traverse(matrix);
        System.out.println("\nZig Zag");
        zigZagTraverse(matrix);


    }

    private void traverse(int[][] matrix) {
        int index = 0;
        int rc = 1;
        for(int a=0; a<8;++a) {
            for (int i = 0; i < rc; ++i) {
                for (int j = 0; j < rc; ++j) {
                    if (i + j == index) {
                        System.out.print(" " + matrix[i][j]);
                    }
                }
            }
            if(rc < 4){
                rc++;
            }
            index++;
        }
    }

    private void zigZagTraverse(int[][] matrix) {
        int index = 0;
        int rc = 1;
        boolean flag = true;
        for(int a=0; a<8;++a) {
            for (int i = 0; i < rc; ++i) {
                for (int j = 0; j < rc; ++j) {
                    if (i + j == index) {
                        if(flag) {
                            System.out.print(" " + matrix[j][i]);
                        } else {
                            System.out.print(" " + matrix[i][j]);
                        }
                    }
                }
            }
            if(rc < 4){
                rc++;
            }
            index++;
            if(flag){
                flag = false;
            } else {
                flag = true;
            }
        }
    }


    private void initialize(int[][] matrix) {
        int count = 1;
        for(int i=0; i<4; ++i) {
            for(int j=0; j<4; ++j) {
                matrix[i][j] = count++ ;
            }
        }
    }

    private void displayMatrix(int[][] matrix) {
        for(int i=0; i<4; ++i) {
            for(int j=0; j<4; ++j) {
                System.out.print("  " + matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Matrix m = new Matrix();
        m.matrixTraversal();

    }
}
