package neat;

public class gene {

    private int in, out, innovation_number;
    private float node_weight;
    private boolean enable_bit;

    public gene(int in, int out, int innovation_number, float node_weight, boolean enable_bit){
        super();
        this.in = in;
        this.out = out;
        this.innovation_number = innovation_number;
        this.node_weight = node_weight;
        this.enable_bit = enable_bit;
    }
}
