package algorithms;

public class DeepLearning implements Classifier{
    public DeepLearning(){
        Layer in = new InputLayer(1);
        Layer H1 = new Layer(2, new Activation.tanh());
        Layer H2 = new Layer(2, new Activation.tanh());
        Layer H3 = new Layer(2, new Activation.tanh());
        Layer out = new OutputLayer(1, new Activation.tanh());

        FullConnection inH1 = new FullConnection(in, H1);
        FullConnection H1H2 = new FullConnection(H1, H2);
        FullConnection H2H3 = new FullConnection(H2, H3);
        FullConnection H3out = new FullConnection(H3, out);

        in.setNeurons(new double[]{0.5});
        H1.setTheta(new double[]{0.1, -0.1});
        H2.setTheta(new double[]{0.2, 0});
        H3.setTheta(new double[]{0.1, -0.2});
        out.setTheta(new double[]{0.3});

        inH1.setWeights(new double[][]{{0.9},{0.5}});
        H1H2.setWeights(new double[][]{{0.4, 0.2},{-0.4, 0.4}});
        H2H3.setWeights(new double[][]{{1, -1},{0, 0.5}});
        H3out.setWeights(new double[][]{{0.4, 0.5}});

        out.propagation();

        H1.setNeurons(new double[]{0.5, 0.15});
        H2.setNeurons(new double[]{0.4, -0.1});
        H3.setNeurons(new double[]{0.45, -0.2});

        //out.setGradient(new double[]{1});
        out.setGradient(out.calculGradient(out.neurons, new double[] {-0.65}));
        in.backpropagation();
    }
}
