import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Patio p = new Patio();

        int i = 0;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Criar nova composição");
            System.out.println("2. Editar composição");
            System.out.println("3. Listar composições editadas");
            System.out.println("4. Desfazer composição");
            System.out.println("5. Fim");
            System.out.println("Entre a opção desejada: ");
            int opcao  = in.nextInt();

            switch (opcao) {
                case 1: {
                    try {
                        System.out.println("\nEntre o id da composição:");
                        int idComposicao = in.nextInt();
                        if (p.getComposicaoPorId(idComposicao) != null) {
                            System.out.println("Esta locomotiva já existe \n");
                            break;
                        }
                        ;
                        System.out.println("\nEntre o id da locomotiva inicial:");
                        int idLocomotiva = in.nextInt();

                        p.adicionaComposicao(new Composicao(idComposicao, p.getLocomotivaPorId(idLocomotiva)));

                        System.out.println("Composição " + idComposicao + " adicionada.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }
                case 2: {
                    System.out.println("\nEntre o id da composição:");
                    int idComposicao = in.nextInt();
                    Composicao c = p.getComposicaoPorId(idComposicao);
                    if (c == null) {
                        System.out.println("Não existe uma composição com este id \n");
                        break;
                    }
                    c.setEditada(true);

                    int j = 0;
                    do {
                        System.out.println("\n1. Inserir uma locomotiva");
                        System.out.println("2. Inserir um vagão");
                        System.out.println("3. Remover o último carro");
                        System.out.println("4. Listar locomotivas livres");
                        System.out.println("5. Listar vagões livres");
                        System.out.println("6. Encerrar a edição");
                        System.out.println("Entre a opção desejada: ");
                        int opcaoEdicao = in.nextInt();
                        if (opcaoEdicao == 1) {
                            try {
                                System.out.println("\nEntre o id da locomotiva:");
                                int idLocomotiva = in.nextInt();
                                Locomotiva l = p.getLocomotivaPorId(idLocomotiva);
                                c.insereLocomotiva(l);
                                System.out.println("Locomotiva inserida: " + l);
                            } catch (IllegalArgumentException | Error e) {
                                System.out.println(e.getMessage());
                            }
                        } else if (opcaoEdicao == 2) {
                            try {
                                System.out.println("\nEntre o id do vagão:");
                                int idVagao = in.nextInt();
                                Vagao v  = p.getVagaoPorId(idVagao);
                                c.insereVagao(v);
                                System.out.println("Vagão inserido: " + v.toString());
                            } catch (IllegalArgumentException | Error e) {
                                System.out.println(e.getMessage());
                            }
                        } else if (opcaoEdicao == 3) {
                            CarroFerroviario carro = c.removerUltimoCarro();
                            System.out.println("Carro removido: " + carro.toString());
                        } else if (opcaoEdicao == 4) {
                            for (Locomotiva locomotiva : p.getLocomotivasLivres()) {
                                System.out.println(locomotiva.toString());
                            }
                        } else if (opcaoEdicao == 5) {
                            for (Vagao vagao : p.getVagoesLivres()) {
                                System.out.println(vagao.toString());
                            }
                        } else if (opcaoEdicao == 6) {
                            System.out.println("Edição encerrada");
                            j++;
                        }
                        System.out.println("Opção inválida");
                    } while (j == 0);
                    break;
                }
                case 3: {
                    System.out.println("\n");
                    for (Composicao composicao : p.getComposicoes()) {
                        if(composicao.isEditada()) {
                            System.out.println(composicao.toString());
                        }
                    }
                    break;
                }
                case 4: {
                    System.out.println("\nEntre o id da composição:");
                    int idComposicao = in.nextInt();
                    Composicao c = p.getComposicaoPorId(idComposicao);
                    c.desmontarComposição(p);
                    System.out.println("Composição " + idComposicao + " desmontada");
                    break;
                }
                case 5: {
                    p.gravaComposicoes();
                    System.out.println("\nFim de programa");
                    i++;
                }
                default: {
                    System.out.println("Opção inválida");
                }
            }
        } while (i == 0);
        in.close();
    }
}