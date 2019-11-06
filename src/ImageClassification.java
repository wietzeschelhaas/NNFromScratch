import java.io.IOException;
import java.util.Arrays;
import java.util.Random;


public class ImageClassification {
    static int amountTrain = 1000;
    static int epochs = 1000;

    public static void main(String[] args) throws IOException {

        //load the data
        MnistMatrix[] trainingData = new MnistDataReader().readData("C:\\Users\\wietz\\Desktop\\mnist\\train-images.idx3-ubyte", "C:\\Users\\wietz\\Desktop\\mnist\\train-labels.idx1-ubyte");
        MnistMatrix[] testData = new MnistDataReader().readData("C:\\Users\\wietz\\Desktop\\mnist\\t10k-images.idx3-ubyte", "C:\\Users\\wietz\\Desktop\\mnist\\t10k-labels.idx1-ubyte");
        System.out.println("loaded data");
        NN neuralNet = new NN(784,15,10);
        System.out.println("starting training:");
        for (int i = 0; i < epochs; i++) {
            //shuffle the training dat after every epoch
            //shuffle(trainingData);
            for (int j = 0; j < amountTrain; j++) {
                neuralNet.train(trainingData[j].getData(),trainingData[j].getLabel());
                System.out.print("\r");
                System.out.print("training " + j + "/" + amountTrain + "    epoch = " + i);
            }
        }

        System.out.println(neuralNet.feedForward(trainingData[5].getData()));
        System.out.println(trainingData[5].getLabel());

    }

    static void shuffle(MnistMatrix[] data){


        Random rand = new Random();

        for (int i = 0; i < data.length; i++) {
            int randomIndexToSwap = rand.nextInt(data.length);
            MnistMatrix temp = data[randomIndexToSwap];
            data[randomIndexToSwap] = data[i];
            data[i] = temp;
        }

    }

   /* private static void printMnistMatrix(final MnistMatrix matrix) {
        System.out.println("label: " + matrix.getLabel());
        for (int r = 0; r < matrix.getNumberOfRows(); r++ ) {
            for (int c = 0; c < matrix.getNumberOfColumns(); c++) {
                System.out.print(matrix.getValue(r, c) + " ");
            }
            System.out.println();
        }*/

}