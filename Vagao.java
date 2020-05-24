public class Vagao extends CarroFerroviario {
    
    private double capacidadeMaxima;

    public Vagao(int id, TipoCarro tipo, double capacidadeMaxima) {
        super(id, tipo);
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public double getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(double capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    
    
}