package co.edu.uniquindio.recursion;

public class MatrixPrinter {
    public static void main(String[] args){
        printMatrix(new int[][]{{1,2,3},
                                {8,1,0},
                                {0,1,7, 10,9}});
    }

    public static void printMatrix(int[][] matrix){
        printMatrix(matrix, 0);
    }

    private static void printMatrix(int[][] matrix, int lineIndex){
        if (matrix.length == lineIndex){
            return;
        }
        printLine(matrix[lineIndex], 0);
        System.out.println();
        printMatrix(matrix, lineIndex + 1);
    }

    private static void printLine(int[] line, int elementIndex){
        if(line.length == elementIndex){
            return;
        }
        System.out.print(line[elementIndex] + " ");
        printLine(line, elementIndex + 1);
    }
}
