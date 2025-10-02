import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {

        Random random = new Random();
        // "No arquivo principal, instancie um terrorista e um policial utilizando um
        // construtor que já recebe os valores a serem atribuídos como parâmetro.
        // Escolha cada valor como desejar."

        Policial policial = new Policial("Eric", "fuzil", 2, 3);
        Terrorista terrorista = new Terrorista("Rossi", "pistola", 3, 3);

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
                        terrorista.plantarBomba();
                        bombaFoiPlantada = true;
                        break;
                    case 1:
                        terrorista.lancarGranada();
                        break;
                    case 2:
                        int danoTerrorista = terrorista.atacar(terrorista.getArmamento());
                        policial.receberDano(danoTerrorista);
                        break;
                    case 3:
                        terrorista.passarVez();
                        int ganhoEnergia = random.nextInt(2) + 1;
                        policial.setEnergia(policial.getEnergia() + ganhoEnergia);
                        break;
                }
                if (policial.getEnergia() <= 0) {
                    System.out.println(terrorista.getNomeTerrorista() + " venceu!");
                    break;
                }
                int acaoPolicial = random.nextInt(4);
                switch (acaoPolicial) {
                    case 0:
                        policial.desarmarBomba();
                        bombaFoiDesarmada = true;
                        break;
                    case 1:
                        policial.lancarGranada();
                        break;
                    case 2:
                        int danoPolicial = policial.atacar(policial.getArmamento());
                        terrorista.receberDano(danoPolicial);
                        break;
                    case 3:
                        policial.passarVez();
                        int ganhoEnergia2 = random.nextInt(2) + 1;
                        terrorista.setEnergia(terrorista.getEnergia() + ganhoEnergia2);
                        break;
                }
                if (terrorista.getEnergia() <= 0) {
                    System.out.println(policial.getNomePolicial() + " venceu!");
                    break;
                }
            } else {
                int acaoPolicial = random.nextInt(4);
                switch (acaoPolicial) {
                    case 0:
                        policial.desarmarBomba();
                        bombaFoiDesarmada = true;
                        break;
                    case 1:
                        policial.lancarGranada();
                        break;
                    case 2:
                        int danoPolicial = policial.atacar(policial.getArmamento());
                        terrorista.receberDano(danoPolicial);
                        break;
                    case 3:
                        policial.passarVez();
                        int ganhoEnergia3 = random.nextInt(2) + 1;
                        terrorista.setEnergia(terrorista.getEnergia() + ganhoEnergia3);
                        break;
                }
                if (terrorista.getEnergia() <= 0) {
                    System.out.println(policial.getNomePolicial() + " venceu!");
                    break;
                }
                int acaoTerrorista = random.nextInt(4);
                switch (acaoTerrorista) {
                    case 0:
                        terrorista.plantarBomba();
                        bombaFoiPlantada = true;
                        break;
                    case 1:
                        terrorista.lancarGranada();
                        break;
                    case 2:
                        int danoTerrorista = terrorista.atacar(terrorista.getArmamento());
                        policial.receberDano(danoTerrorista);
                        break;
                    case 3:
                        terrorista.passarVez();
                        int ganhoEnergia4 = random.nextInt(2) + 1;
                        policial.setEnergia(policial.getEnergia() + ganhoEnergia4);
                        break;
                }
                if (policial.getEnergia() <= 0) {
                    System.out.println(terrorista.getNomeTerrorista() + " venceu!");
                    break;
                }
            }

            if (bombaFoiPlantada == true) {
                if (bombaFoiDesarmada == false) {
                    System.out.println("Bomba explodiu! " + terrorista.getNomeTerrorista() + " venceu! \\o/"
                            + " [TERRORISTS WIN]");
                    break;
                }
                if (bombaFoiDesarmada == true) {
                    System.out.println("Bomba foi desarmada! (ufa!) " + policial.getNomePolicial() + " venceu! \\o/"
                            + " [COUNTER TERRORISTS WIN]");
                    break;
                }
            }

            System.out.println("\n" + terrorista);
            System.out.println(policial);
            System.out.println("+++++++++++++++++++++++++++++++++++++++\n");
        }
    }
}