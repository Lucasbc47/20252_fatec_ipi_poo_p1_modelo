public class TerroristaTeste {
    public static void main(String[] args) {

        Terrorista terror = new Terrorista("mohammed", "fuzil", 3, 10);

        // testando getters...
        System.out.println(terror.getNomeTerrorista());
        System.out.println(terror.getArmamento());
        System.out.println(terror.getQuantidadeGranadas());
        System.out.println(terror.getEnergia());

        // metodos do terrorista
        terror.atacar("fuzil");
        terror.lancarGranada();
        terror.plantarBomba();
        terror.passarVez();

        // dano & energia
        System.out.println(terror.getEnergia());
        terror.receberDano(1);
        terror.receberDano(2);
        terror.receberDano(3);
        terror.receberDano(50);
        System.out.println(terror.getEnergia());

    }
}