package algorithms;

import java.util.ArrayList;

public abstract class Connection {
    ArrayList<Connection> inputs;
    ArrayList<Connection> outputs;
    boolean backprop;

    public Connection(){
        inputs = new ArrayList<>();
        outputs = new ArrayList<>();
        backprop = false;
    }

    public void addInput(Connection in){
        if(!inputs.contains(in)) {
            inputs.add(in);
            in.addOutput(this);
        }
    }

    public void addOutput(Connection out){
        if(!outputs.contains(out)) {
            outputs.add(out);
            out.addInput(this);
        }
    }

    public abstract double[] propagation();
    public abstract double[] backpropagation();
}
