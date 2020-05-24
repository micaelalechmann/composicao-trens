public class EditorDeComposicoes {
    private Composicao composicao;

    public EditorDeComposicoes(Composicao composicao) {
        this.composicao = composicao;
        composicao.setEditada(true);
    }
    
    public void insereLocomotiva(int id) {
        Patio p = new Patio();

        int quantCarrosFerroviarios = composicao.getCarrosFerroviarios().size();

        if(composicao.getCarrosFerroviarios().get(quantCarrosFerroviarios - 1).getTipo() == TipoCarro.Vagao) {
            throw new Error("Não possível engatar uma locomotiva após um vagão.");
        }

        Locomotiva locomotiva = p.getLocomotivaPorId(id);
        if(locomotiva == null) {
            throw new IllegalArgumentException("Locomotiva não existe");
        }

        if(locomotiva.getComposicao() != null) {
            throw new Error("Locomotiva já está sendo utilizada");
        }        
        
        composicao.addCarroFerroviario(locomotiva);
        locomotiva.setComposicao(composicao);
    }

    public void insereVagao(int id) {
        Patio p = new Patio();

        Vagao vagao = p.getVagaoPorId(id);
        
        if(vagao == null) {
            throw new IllegalArgumentException("Vagão não existe");
        }

        if(vagao.getComposicao() != null) {
            throw new Error("Vagão já está sendo utilizado");
        }

        int quantVagoes = 0;
        for(CarroFerroviario carroFerroviario : composicao.getCarrosFerroviarios()) {
            if(carroFerroviario.getTipo() == TipoCarro.Vagao) {
                quantVagoes++;
            }
        }

        if((quantVagoes + 1) > composicao.getVagoesMaximo()) {
            throw new Error("Não é possível adicionar mais vagões.");
        }

        if((composicao.getCargaAtual() + vagao.getCapacidadeMaxima()) > composicao.getCapacidadeDeCargaMaxima()) {
            throw new Error("Não é possível adicionar mais carga.");
        }

        composicao.addCarroFerroviario(vagao);
        vagao.setComposicao(composicao);
    }

    public void removerUltimoCarro() {
        int quantCarrosFerroviarios = composicao.getCarrosFerroviarios().size();

        CarroFerroviario carroFerroviario = composicao.getCarrosFerroviarios().remove(quantCarrosFerroviarios - 1);      
        carroFerroviario.setComposicao(null);
    }

    public void desmontarComposição() {
        Patio p = new Patio();

        for(CarroFerroviario carroFerroviario: composicao.getCarrosFerroviarios()) {
            carroFerroviario.setComposicao(null);
        }

        p.getComposicoes().removeIf((c -> c.getId() == composicao.getId()));
    }
}