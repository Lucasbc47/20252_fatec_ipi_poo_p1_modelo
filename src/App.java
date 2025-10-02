import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
        // Sistema de Mapas
        String mapa;

        // "No arquivo principal, instancie um terrorista e um policial utilizando um
        // construtor que já recebe os valores a serem atribuídos como parâmetro.
        // Escolha cada valor como desejar."

        System.out.println("BEM VINDO AO COUNTER FATEC OFFENSIVE - VERSION IPIRANGA!");
        System.out.println("\n [+] SELETOR DE MAPA:");
        System.out.println("1 - Roma");
        System.out.println("2 - Fatec Ipiranga\n>>:");

        int escolherMapa = scanner.nextInt();
        mapa = (escolherMapa == 1 ? "Roma" : "Fatec Ipiranga");

        int numRodadas = 0;
        System.out.println("Insira um numero [IMPAR] de rodadas (1-20):");
        numRodadas = scanner.nextInt();

        while (numRodadas < 1 || numRodadas > 20 || numRodadas % 2 == 0) {
            System.out.println("Numero invalido! Insira um numero IMPAR entre 1 e 20:");
            numRodadas = scanner.nextInt();
        }

        int vitoriasPolicial = 0;
        int vitoriasTerrorista = 0;

        Policial policial = new Policial("Eric", "fuzil", 2, 10);
        Terrorista terrorista = new Terrorista("Rossi", "pistola", 3, 10);

        // loop de rodadas
        for (int rodadaAtual = 1; rodadaAtual <= numRodadas; rodadaAtual++) {
            System.out.println("\n========== <Rodada " + rodadaAtual + "> ==========\n");

            // Resetar energia e granadas
            policial.setEnergia(10);
            policial.setQuantidadeGranadas(2);
            terrorista.setEnergia(10);
            terrorista.setQuantidadeGranadas(3);

            // loop do jogo
            while (true) {
                /*
                 * Gabriel Rossi --
                 * Mecanismo de bomba
                 * 
                 * O mecanismo de plantar bomba funciona da seguinte forma:
                 * - Se a bomba for plantada e não for desarmada: vitória do terrorista e fim de
                 * jogo
                 * - Se a bomba for plantada e for desarmada: vitória do policial e fim de jogo
                 * - Se a bomba não for plantada, nada de diferente acontece.
                 * 
                 * Para que seja considerado que a bomba foi plantada e desarmada na mesma
                 * rodada,
                 * basta que esses dois comportamentos sejam acionados, não importando a ordem.
                 * O
                 * que importa é que, no final da rodada, se eles foram acionados.
                 * Mensagem do commit: feat(p1): implementa mecanismo de bomba
                 */

                boolean bombaFoiPlantada = false;
                boolean bombaFoiDesarmada = false;
                // 0 = terrorista, 1 = policial
                int quemComeca = random.nextInt(2);

                if (quemComeca == 0) {
                    int acaoTerrorista = random.nextInt(4);
                    switch (acaoTerrorista) {
                        case 0:
                            terrorista.plantarBomba(mapa);
                            bombaFoiPlantada = true;
                            break;
                        case 1:
                            terrorista.lancarGranada(mapa);
                            break;
                        case 2:
                            int danoTerrorista = terrorista.atacar(terrorista.getArmamento(), mapa);
                            policial.receberDano(danoTerrorista);
                            break;
                        case 3:
                            terrorista.passarVez(mapa);
                            int ganhoEnergia = random.nextInt(2) + 1;
                            policial.setEnergia(policial.getEnergia() + ganhoEnergia);
                            break;
                    }
                    if (policial.getEnergia() <= 0) {
                        System.out.println(terrorista.getNomeTerrorista() + " venceu!");
                        vitoriasTerrorista++;
                        break;
                    }
                    int acaoPolicial = random.nextInt(4);
                    switch (acaoPolicial) {
                        case 0:
                            policial.desarmarBomba(mapa);
                            bombaFoiDesarmada = true;
                            break;
                        case 1:
                            policial.lancarGranada(mapa);
                            break;
                        case 2:
                            int danoPolicial = policial.atacar(policial.getArmamento(), mapa);
                            terrorista.receberDano(danoPolicial);
                            break;
                        case 3:
                            policial.passarVez(mapa);
                            int ganhoEnergia2 = random.nextInt(2) + 1;
                            terrorista.setEnergia(terrorista.getEnergia() + ganhoEnergia2);
                            break;
                    }
                    if (terrorista.getEnergia() <= 0) {
                        System.out.println(policial.getNomePolicial() + " venceu!");
                        vitoriasPolicial++;
                        break;
                    }
                } else {
                    int acaoPolicial = random.nextInt(4);
                    switch (acaoPolicial) {
                        case 0:
                            policial.desarmarBomba(mapa);
                            bombaFoiDesarmada = true;
                            break;
                        case 1:
                            policial.lancarGranada(mapa);
                            break;
                        case 2:
                            int danoPolicial = policial.atacar(policial.getArmamento(), mapa);
                            terrorista.receberDano(danoPolicial);
                            break;
                        case 3:
                            policial.passarVez(mapa);
                            int ganhoEnergia3 = random.nextInt(2) + 1;
                            terrorista.setEnergia(terrorista.getEnergia() + ganhoEnergia3);
                            break;
                    }
                    if (terrorista.getEnergia() <= 0) {
                        System.out.println(policial.getNomePolicial() + " venceu!");
                        vitoriasPolicial++;
                        break;
                    }
                    int acaoTerrorista = random.nextInt(4);
                    switch (acaoTerrorista) {
                        case 0:
                            terrorista.plantarBomba(mapa);
                            bombaFoiPlantada = true;
                            break;
                        case 1:
                            terrorista.lancarGranada(mapa);
                            break;
                        case 2:
                            int danoTerrorista = terrorista.atacar(terrorista.getArmamento(), mapa);
                            policial.receberDano(danoTerrorista);
                            break;
                        case 3:
                            terrorista.passarVez(mapa);
                            int ganhoEnergia4 = random.nextInt(2) + 1;
                            policial.setEnergia(policial.getEnergia() + ganhoEnergia4);
                            break;
                    }
                    if (policial.getEnergia() <= 0) {
                        System.out.println(terrorista.getNomeTerrorista() + " venceu!");
                        vitoriasTerrorista++;
                        break;
                    }
                }

                if (bombaFoiPlantada == true) {
                    if (bombaFoiDesarmada == false) {
                        System.out.println("Bomba explodiu!\n" + terrorista.getNomeTerrorista() + " venceu! \\o/"
                                + " [TERRORISTS WIN]");
                        vitoriasTerrorista++;
                        break;
                    }
                    if (bombaFoiDesarmada == true) {
                        System.out
                                .println("Bomba foi desarmada! (ufa!)\n " + policial.getNomePolicial() + " venceu! \\o/"
                                        + " [COUNTER TERRORISTS WIN]");
                        vitoriasPolicial++;
                        break;
                    }
                }

                System.out.println("\n" + terrorista);
                System.out.println(policial);
                System.out.println("+++++++++++++++++++++++++++++++++++++++\n");
            }
        }

        // Lucas Barboza: isso aqui seria o IDEAL, ja que nao estamos mais usando o
        // scanner, pra liberar a memoria, mas ainda não foi abordado...
        // scanner.close();
        String vencedor;
        System.out.println("\n---- <FIM DA PARTIDA> ----");
        System.out.println(policial.getNomePolicial() + ": " + vitoriasPolicial + " vitorias");
        System.out.println(terrorista.getNomeTerrorista() + ": " + vitoriasTerrorista + " vitorias");
        System.out.println("----------------------------");

        if (vitoriasPolicial > vitoriasTerrorista) {
            vencedor = policial.getNomePolicial();
        } else {
            vencedor = terrorista.getNomeTerrorista();
        }
        System.out.println("\nParabens: " + vencedor + "!\n");
    }
}