public class MnistMatrix {

    private Matrix data;

    private int nRows;
    private int nCols;

    private Matrix label;

    public MnistMatrix(int nRows, int nCols) {
        this.nRows = nRows;
        this.nCols = nCols;

        data = new Matrix(nRows,nCols);
        label = new Matrix(1,1);
    }

    public float getValue(int r, int c) {
        return data.matrix[r][c];
    }

    public void setValue(int row, int col, float value) {
        data.matrix[row][col] = value;
    }

    public Matrix getLabel() {
        return label;
    }

    public void setLabel(Matrix label) {
        this.label = label;
    }

    public int getNumberOfRows() {
        return nRows;
    }

    public int getNumberOfColumns() {
        return nCols;
    }
    public Matrix getData(){
        return data;
    }

}