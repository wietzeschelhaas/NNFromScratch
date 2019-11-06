public class NNTest {
    public static void main(String[] args){
        NN neuralNet = new NN(2,2,1);

        Matrix input1 = new Matrix(2,1);
        Matrix input2 = new Matrix(2,1);
        Matrix input3 = new Matrix(2,1);
        Matrix input4 = new Matrix(2,1);

        Matrix target1 = new Matrix(1,1);
        Matrix target2 = new Matrix(1,1);
        Matrix target3 = new Matrix(1,1);
        Matrix target4 = new Matrix(1,1);


        //TODO FIGURE OUT SOMETHING BETTER TO STORE DATA
        target1.matrix[0][0] = 1;
        target2.matrix[0][0] = 1;
        target3.matrix[0][0] = 0;
        target4.matrix[0][0] = 0;

        input1.matrix[0][0] = 0;
        input1.matrix[1][0] = 1;

        input2.matrix[0][0] = 1;
        input2.matrix[1][0] = 0;

        input3.matrix[0][0] = 0;
        input3.matrix[1][0] = 0;

        input4.matrix[0][0] = 1;
        input4.matrix[1][0] = 1;

        //training, should probably randomize order
        for (int i = 0; i < 100000; i++) {
            double r = Math.random();
            if(r<0.25) {
                neuralNet.train(input1, target1);
                continue;
            }
            if(r<0.5) {
                neuralNet.train(input2, target2);
                continue;
            }
            if(r<0.75) {
                neuralNet.train(input3, target3);
                continue;
            }
            if(r<1) {
                neuralNet.train(input4, target4);
                continue;
            }
        }

        //to test, this shouldnt be part of training data
        System.out.println(neuralNet.feedForward(input1));
        System.out.println(neuralNet.feedForward(input2));
        System.out.println(neuralNet.feedForward(input3));
        System.out.println(neuralNet.feedForward(input4));



    }
}
