public class PolicialTeste {
    public static void main(String[] args){
        Policial pessanha = new Policial("Peçanha", "fuzil", 3, 10);
        System.out.println(pessanha.getNomePolicial());
        System.out.println(pessanha.getArmamento());
        System.out.println(pessanha.getQuantidadeGranadas());
        System.out.println(pessanha.getEnergia());

        
        pessanha.atacar("fuzil");
        pessanha.lancarGranada();
        pessanha.desarmarBomba();

       
        System.out.println(pessanha.getEnergia());
        pessanha.receberDano(1);
        System.out.println(pessanha.getEnergia());
        pessanha.receberDano(2);
        System.out.println(pessanha.getEnergia());
        pessanha.receberDano(3);
        System.out.println(pessanha.getEnergia());

    }
}

