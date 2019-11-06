public class MatrixTest {
    public static void main(String[] args){
        Matrix test = new Matrix(2,3);
        Matrix test2 = new Matrix(2,3);
        test.matrix[0][0] = 2;
        test.matrix[0][1] = 1;
        test.matrix[0][2] = 4;

        test.matrix[1][0] = 0;
        test.matrix[1][1] = 1;
        test.matrix[1][2] = 1;

        test2.matrix[0][0] = 6;
        test2.matrix[0][1] = 3;
        test2.matrix[0][2] = -1;

        test2.matrix[1][0] = 1;
        test2.matrix[1][1] = 1;
        test2.matrix[1][2] = 0;

        System.out.println(test);
        System.out.println("-");
        System.out.println(test2);
        Matrix m = Matrix.sub(test,test2);
        System.out.println(m);

    }
}
