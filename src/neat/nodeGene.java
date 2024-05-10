package neat;

public class nodeGene {
    private TYPE type;
    private int ID;
    enum TYPE {
        input,
        hidden,
        output,
        ;
    }

    public nodeGene(TYPE type, int ID){
        super();
        this.type = type;
        this.ID = ID;
    }
}
