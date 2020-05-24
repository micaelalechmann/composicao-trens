import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Patio {
    private ArrayList<Vagao> vagoes = new ArrayList<Vagao>();
    private ArrayList<Locomotiva> locomotivas = new ArrayList<Locomotiva>();
    private ArrayList<Composicao> composicoes = new ArrayList<Composicao>();

    private static final String locomotivasFile = "locomotivas.txt";
    private static final String vagoesFile = "vagoes.txt";
    private static final String composicoesFile = "composicoes.txt";


    public ArrayList<Composicao> getComposicoes() {
        return composicoes;
    }

    public Composicao getComposicaoPorId(int id) {
        for(Composicao composicao: composicoes) {
            if(composicao.getId() == id) return composicao;
        }

        return null;
    }

    public Locomotiva getLocomotivaPorId(int id) {
        for(Locomotiva locomotiva: locomotivas) {
            if(locomotiva.getId() == id) return locomotiva;
        }

        return null;
    }

    public Vagao getVagaoPorId(int id) {
        for(Vagao vagao: vagoes) {
            if(vagao.getId() == id) return vagao;
        }

        return null;
    }

    public ArrayList<Locomotiva> getLocomotivasLivres() {
        ArrayList<Locomotiva> locomotivasLivres = new ArrayList<Locomotiva>();

        for(Locomotiva locomotiva: locomotivas) {
            if(locomotiva.getComposicao() == null) {
                locomotivasLivres.add(locomotiva);
            }
        }

        return locomotivasLivres;
    }

    public ArrayList<Vagao> getVagoesLivres() {
        ArrayList<Vagao> vagoesLivres = new ArrayList<Vagao>();

        for(Vagao vagao: vagoes) {
            if(vagao.getComposicao() == null) {
                vagoesLivres.add(vagao);
            }
        }

        return vagoesLivres;
    }

    public void carregaLocomotivas(){
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir+"/"+ locomotivasFile;
        Path path = Paths.get(nameComplete);
        
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))){
           while (sc.hasNext()){
               String linha = sc.nextLine();
               String dados[] = linha.trim().split(";");
               int id = Integer.parseInt(dados[0]);
               double pesoMaximo = Double.parseDouble(dados[2]);
               int vagoesMaximo = Integer.parseInt(dados[3]);
               Locomotiva l = new Locomotiva(id, TipoCarro.Locomotiva, pesoMaximo, vagoesMaximo);
               locomotivas.add(l);
           }
        }catch (IOException x){
            System.err.format("Erro de E/S: %s%n", x);
        }
    }

    public void carregaVagoes(){
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir+"/"+ vagoesFile;
        Path path = Paths.get(nameComplete);
        
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))){
           while (sc.hasNext()){
               String linha = sc.nextLine();
               String dados[] = linha.trim().split(";");
               int id = Integer.parseInt(dados[0]);
               double capacidadeMaxima = Double.parseDouble(dados[2]);
               Vagao v = new Vagao(id, TipoCarro.Vagao, capacidadeMaxima);
               vagoes.add(v);
           }
        }catch (IOException x){
            System.err.format("Erro de E/S: %s%n", x);
        }
    }

    public void carregaComposicoes(){
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir+"/"+ composicoesFile;
        Path path = Paths.get(nameComplete);
        
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))){
           while (sc.hasNext()){
               String linha = sc.nextLine();
               String dados[] = linha.split(";");
               int id = Integer.parseInt(dados[0]);
               
               
           }
        }catch (IOException x){
            System.err.format("Erro de E/S: %s%n", x);
        }
    }

    public void gravaProdutos(){
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir+"/"+"lala.txt";
        Path path = Paths.get(nameComplete);
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path, StandardCharsets.UTF_8))){
        //   for(int i=0; i<produtos.size(); i++){
        //         String linha = produtos.get(i).getCodigo()+";"+
        //                        produtos.get(i).getDescricao()+";"+
        //                        produtos.get(i).getPrecoUnitario();
        //         writer.println(linha);
        //     }
        }catch (IOException x){
          System.err.format("Erro de E/S: %s%n", x);
      }
    }
}