package algorithms;

public class FullConnection extends Connection {
    Layer input;
    Layer output;
    double[][] weights;

    public FullConnection(Layer in, Layer out){
        input = in;
        output = out;
        weights = new double[out.neurons.length][in.neurons.length];
        output.addInput(this);
    }

    public void update(){
        for(int i=0; i<output.neurons.length; i++){
            double sum = 0;
            for(int j=0; j<input.neurons.length; j++)
                sum += input.neurons[j]*weights[i][j];
            output.neurons[i] += sum;
        }
    }

}