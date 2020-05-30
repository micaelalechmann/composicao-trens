import java.util.ArrayList;

public class Composicao {
    private int id;
    private boolean isEditada;
    private ArrayList<CarroFerroviario> carrosFerroviarios = new ArrayList<CarroFerroviario>();

    Composicao(int id, Locomotiva locomotiva) {
        if (locomotiva == null) {
            throw new IllegalArgumentException("A locomotiva não pode ser nula");
        }
        this.id = id;
        this.isEditada = false;
        this.insereLocomotiva(locomotiva);
        locomotiva.setComposicao(this);
    }

    public int getId() {
        return id;
    }

    public ArrayList<CarroFerroviario> getCarrosFerroviarios() {
        return carrosFerroviarios;
    }

    public boolean isEditada() {
        return isEditada;
    }

    public void setEditada(boolean isEditada) {
        this.isEditada = isEditada;
    }

    public int getVagoesMaximo() {
        int vagoesMaximo = 0;
        for (CarroFerroviario carroFerroviario : carrosFerroviarios) {
            if (carroFerroviario instanceof Locomotiva) {
                vagoesMaximo += ((Locomotiva) carroFerroviario).getVagoesMaximo();
            }
        }
        return (int) Math.floor(vagoesMaximo * 0.9);
    }

    public double getCapacidadeDeCargaMaxima() {
        double capacidadeDeCarga = 0;
        for (CarroFerroviario carroFerroviario : carrosFerroviarios) {
            if (carroFerroviario instanceof Locomotiva) {
                capacidadeDeCarga += ((Locomotiva) carroFerroviario).getPesoMaximo();
            }
        }
        return capacidadeDeCarga;
    }

    public double getCargaAtual() {
        double cargaAtual = 0;
        for (CarroFerroviario carroFerroviario : carrosFerroviarios) {
            if (carroFerroviario instanceof Vagao) {
                cargaAtual += ((Vagao) carroFerroviario).getCapacidadeMaxima();
            }
        }
        return cargaAtual;
    }

    public void insereLocomotiva(Locomotiva locomotiva) {
        int quantCarrosFerroviarios = carrosFerroviarios.size();

        if (quantCarrosFerroviarios > 0 && carrosFerroviarios.get(quantCarrosFerroviarios - 1) instanceof Vagao) {
            throw new Error("Não possível engatar uma locomotiva após um vagão.");
        }

        if (locomotiva == null) {
            throw new IllegalArgumentException("Locomotiva não existe");
        }

        if (locomotiva.getComposicao() != null) {
            throw new IllegalArgumentException("Locomotiva já está sendo utilizada");
        }

        carrosFerroviarios.add(locomotiva);
        locomotiva.setComposicao(this);
    }

    public void insereVagao(Vagao vagao) {
        if (vagao == null) {
            throw new IllegalArgumentException("Vagão não existe");
        }

        if (vagao.getComposicao() != null) {
            throw new IllegalArgumentException("Vagão já está sendo utilizado");
        }

        int quantVagoes = 0;
        for (CarroFerroviario carroFerroviario : carrosFerroviarios) {
            if (carroFerroviario instanceof Vagao) {
                quantVagoes++;
            }
        }

        if ((quantVagoes + 1) > getVagoesMaximo() && carrosFerroviarios.size() > 1
                && carrosFerroviarios.get(1) instanceof Locomotiva) {
            System.out.println("Número de vagões máximo: " + getVagoesMaximo());
            throw new Error("Não é possível adicionar mais vagões.");
        }

        if ((getCargaAtual() + vagao.getCapacidadeMaxima()) > getCapacidadeDeCargaMaxima()) {
            System.out.println("Capacidade máxima de carga: " + getCapacidadeDeCargaMaxima());
            throw new Error("Não é possível adicionar mais carga.");
        }

        carrosFerroviarios.add(vagao);
        vagao.setComposicao(this);
    }

    public CarroFerroviario removerUltimoCarro() {
        CarroFerroviario carroFerroviario = carrosFerroviarios.remove(carrosFerroviarios.size() - 1);
        carroFerroviario.setComposicao(null);
        return carroFerroviario;
    }

    public void desmontarComposição(Patio p) {
        for (CarroFerroviario carroFerroviario : carrosFerroviarios) {
            carroFerroviario.setComposicao(null);
        }

        p.getComposicoes().removeIf((c -> c.getId() == id));
    }

    @Override
    public String toString() {
        String aux = "Id: " + this.id + "\n";
        for (CarroFerroviario carroFerroviario : carrosFerroviarios) {
            aux += carroFerroviario.toString() + "\n";
        }

        return aux;
    }
}