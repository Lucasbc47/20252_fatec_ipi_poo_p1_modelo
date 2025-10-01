public class TerroristaTest {
    public static void main(String[] args) {

        Terrorista terror = new Terrorista();

        // testando setters...
        terror.setNomeTerrorista("mohammed");
        terror.setArmamento("fuzil");
        terror.setQtdGranadas(3);

        // testando getters...
        System.out.println(terror.getNomeTerrorista());
        System.out.println(terror.getArmamento());
        System.out.println(terror.getQtdGranadas());
        System.out.println(terror.getVida());

        // metodos do terrorista
        terror.atacar("fuzil");
        terror.lancarGranada();
        terror.plantarBomba();

        // dano & vida
        System.out.println(terror.getVida());
        terror.receberDano(1);
        terror.receberDano(2);
        terror.receberDano(3);
        System.out.println(terror.getVida());

    }
}