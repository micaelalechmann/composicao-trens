public class Locomotiva extends CarroFerroviario {
    private double pesoMaximo;
    private int vagoesMaximo;

    public Locomotiva(int id, TipoCarro tipo, double pesoMaximo, int vagoesMaximo) {
        super(id, tipo);
        this.pesoMaximo = pesoMaximo;
        this.vagoesMaximo = vagoesMaximo;
    }

    public double getPesoMaximo() {
        return pesoMaximo;
    }

    public int getVagoesMaximo() {
        return vagoesMaximo;
    }


}