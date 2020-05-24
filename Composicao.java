import java.util.ArrayList;

public class Composicao {
    private int id;
    private boolean isEditada;
    private ArrayList<CarroFerroviario> carrosFerroviarios = new ArrayList<CarroFerroviario>();

    Composicao(int id, Locomotiva locomotiva) {
        if(locomotiva == null) {
            throw new IllegalArgumentException("A locomotiva não pode ser nula");
        }
        this.id = id; 
        this.isEditada = false;
        this.carrosFerroviarios.add(locomotiva);
    }

    public int getId() {
        return id;
    }

    public ArrayList<CarroFerroviario> getCarrosFerroviarios() {
        return carrosFerroviarios;
    }

    public void addCarroFerroviario(CarroFerroviario carroFerroviario) {
        carrosFerroviarios.add(carroFerroviario);
    }

    public boolean isEditada() {
        return isEditada;
    }

    public void setEditada(boolean isEditada) {
        this.isEditada = isEditada;
    }

    public int getVagoesMaximo() {
        int vagoesMaximo = carrosFerroviarios.stream().reduce(0, (acc, carro) -> {
            if(carro.getTipo() == TipoCarro.Locomotiva) {
                return (int)Math.floor(acc + ((Locomotiva)carro).getVagoesMaximo() * 0.9);
            }
            return acc;
        }, Integer::sum);
        // for(CarroFerroviario carroFerroviario: carrosFerroviarios) {
        //     if(carroFerroviario.getTipo() == TipoCarro.Locomotiva) {
        //         // TODO verificar conta de vagões
        //         vagoesMaximo += ((Locomotiva)carroFerroviario).getVagoesMaximo();
        //     }
        // }
        return vagoesMaximo;
    }

    public double getCapacidadeDeCargaMaxima() {
        double capacidadeDeCarga = 0;
        for(CarroFerroviario carroFerroviario: carrosFerroviarios) {
            if(carroFerroviario.getTipo() == TipoCarro.Locomotiva) {
                capacidadeDeCarga += ((Locomotiva)carroFerroviario).getPesoMaximo();
            }
        }
        return capacidadeDeCarga;
    }

    public double getCargaAtual() {
        double cargaAtual = 0;
        for(CarroFerroviario carroFerroviario: carrosFerroviarios) {
            if(carroFerroviario.getTipo() == TipoCarro.Vagao) {
                cargaAtual += ((Vagao)carroFerroviario).getCapacidadeMaxima();
            }
        }
        return cargaAtual;
    }

    @Override
    public String toString() {
        String aux = "Id: " + this.id + "\n"; 
        for(CarroFerroviario carroFerroviario: carrosFerroviarios) {
            aux += carroFerroviario.toString() + "\n";
        }

        return aux;
    }
}