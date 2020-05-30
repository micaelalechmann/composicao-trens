public abstract class CarroFerroviario {
    private int id;
    private Composicao composicao;

    public CarroFerroviario(int id) {
        this.id = id;
        this.composicao = null;
    }

    public Composicao getComposicao() {
        return composicao;
    }

    public void setComposicao(Composicao composicao) {
        this.composicao = composicao;
    }

    public int getId() {
        return id;
    }
    
    public abstract String toString();
}