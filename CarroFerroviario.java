public abstract class CarroFerroviario {
    private int id;
    private Composicao composicao;
    private TipoCarro tipo;

    public CarroFerroviario(int id, TipoCarro tipo) {
        this.id = id;
        this.tipo = tipo;
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

    public TipoCarro getTipo() {
        return tipo;
    }
}