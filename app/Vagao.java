public class Vagao extends CarroFerroviario {
    
    private double capacidadeMaxima;

    public Vagao(int id, double capacidadeMaxima) {
        super(id);
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public double getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(double capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    @Override
    public String toString() {
        String aux = "Vagão " + super.getId() + 
        "; Capacidade máxima: " + this.capacidadeMaxima;        
        return aux;
    }
    
}