import java.util.ArrayList;
import java.util.Random;

public class PerceptronTest {
    public static void main(String[] args){
        Perceptron brain = new Perceptron();
        Random r = new Random();
        ArrayList<Vector> points = new ArrayList<Vector>();

        // some random points which will act as training data
        for (int i = 0; i < 1000; i++) {
            float x = r.nextFloat()*400;
            float y = r.nextFloat()*400;

            float[] inputs =  {x,y};

            int label;
            //This is for the line y=x
            if (x>y){
                label = 1;
            }else {
                label = -1;
            }
            points.add(new Vector(inputs,label));

        }
        //trianing
        for (Vector p :
                points) {
            brain.train(p.inputs,p.label);
        }

        // now fill the point list with testing data
        //TODO ugly duplicate code...
        points.clear();
        for (int i = 0; i < 10; i++) {
            float x = r.nextFloat()*400;
            float y = r.nextFloat()*400;

            float[] inputs =  {x,y};

            int label;
            if (x>y){
                label = 1;
            }else {
                label = -1;
            }
            points.add(new Vector(inputs,label));
        }
        for (Vector p :
                points) {
            System.out.println("Perceptron geussed : " + brain.guess(p.inputs) + " Actual value = " + p.label);
        }
    }
}
