public class Locomotiva extends CarroFerroviario {
    private double pesoMaximo;
    private int vagoesMaximo;

    public Locomotiva(int id, double pesoMaximo, int vagoesMaximo) {
        super(id);
        this.pesoMaximo = pesoMaximo;
        this.vagoesMaximo = vagoesMaximo;
    }

    public double getPesoMaximo() {
        return pesoMaximo;
    }

    public int getVagoesMaximo() {
        return vagoesMaximo;
    }

    @Override
    public String toString() {
        String aux = "Locomotiva " + super.getId() + 
        "; Peso máximo: " + this.pesoMaximo + 
        "; Vagões máximo: " + vagoesMaximo;

        return aux;
    }

}