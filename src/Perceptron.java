import java.util.Random;

public class Perceptron {
    float[] weights;
    float bias = 1;
    float learningRate = 0.1f;

    Random random;
    public Perceptron(){
        weights = new float[2];
        random = new Random();

        // fill the weights with random values between -1 and 1
        for (int i = 0; i < weights.length; i++) {
            if (random.nextBoolean())
                weights[i] = random.nextFloat();
            else
                weights[i] = -1*random.nextFloat();
        }

    }

    float weightedSum(float[] inputs){
        float sum = 0;

        for (int i = 0; i < inputs.length; i++) {
            sum+=inputs[i] * weights[i];
        }
        sum += bias;
        return sum;
    }


    // this is a simple activation function.
    int sign(float n){
        if (n<0)
            return -1;
        else
            return 1;
    }


    int guess(float[] inputs){
        return sign(weightedSum(inputs));
    }

    // this function takes the input point and "guesses" its label, then adjusts the weight values using the error.
    void train(float[] inputs, int  target){
        int g = guess(inputs);

        int error = target - g;

        for (int i = 0; i < weights.length; i++) {
            weights[i] += error * inputs[i] * learningRate;
        }
    }

}
