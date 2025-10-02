public class PolicialTeste {
    public static void main(String[] args) {

        // viabilizando testes com mapa
        String mapa = "Fatec Ipiranga";
        Policial pessanha = new Policial("Peçanha", "fuzil", 3, 10);
        System.out.println(pessanha.getNomePolicial());
        System.out.println(pessanha.getArmamento());
        System.out.println(pessanha.getQuantidadeGranadas());
        System.out.println(pessanha.getEnergia());

        pessanha.atacar("fuzil", mapa);
        pessanha.lancarGranada(mapa);
        pessanha.desarmarBomba(mapa);

        System.out.println(pessanha.getEnergia());
        pessanha.receberDano(1);
        System.out.println(pessanha.getEnergia());
        pessanha.receberDano(2);
        System.out.println(pessanha.getEnergia());
        pessanha.receberDano(3);
        System.out.println(pessanha.getEnergia());

    }
}
