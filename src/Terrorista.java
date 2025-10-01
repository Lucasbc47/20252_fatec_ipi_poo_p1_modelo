public class Terrorista {
    // Prova Fatec Bossini

    // Pedido do cliente que todas as propriedades fossem privadas
    private String nomeTerrorista;
    private String armamento;
    private int qtdGranadas;
    private int vida = 10;
    private boolean vivo = true;

    // Setters
    public void setNomeTerrorista(String nomeTerrorista) {
        this.nomeTerrorista = nomeTerrorista;
    }

    public void setArmamento(String armamento) {
        switch (armamento) {
            case "faca":
            case "pistola":
            case "fuzil":
                this.armamento = armamento;
                break;
            default:
                System.out.println("Armamentos disponiveis: faca, pistola e fuzil!");
        }
    }

    public void setQtdGranadas(int qtdGranadas) {
        this.qtdGranadas = qtdGranadas;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setVivo(boolean vivo){
        this.vivo = true;
    }

    // Getters
    public String getNomeTerrorista() {
        return this.nomeTerrorista;
    }

    public String getArmamento() {
        return this.armamento;
    }

    public int getQtdGranadas() {
        return this.qtdGranadas;
    }

    public int getVida() {
        return this.vida;
    }

    public boolean getVivo(){
        return this.vivo;
    }

    public void receberDano(int dano) {
        if (this.vida <= 0)
            return;

        this.vida -= dano;

        if (this.vida <= 0) {
            this.vida = 0;
            System.out.println(nomeTerrorista + " faleceu");
        }
    }

    // Método atacar
    // public void atacar(Personagem policial, String armamento) {
    public void atacar(String armamento) {
        int dano = 0;

        if(vivo){
            switch (armamento) {
            case "faca":
                dano = 1;
                break;
            case "pistola":
                dano = 2;
                break;
            case "fuzil":
                dano = 3;
                break;
            }
            
            // policial.receberDano(dano);
            System.out.println(this.nomeTerrorista + " atacou com " + this.armamento);
            // System.out.println(policial.getNomePolicial() + " ficou com vida = " +
            // policial.getVidaPolicial());
        }
        else{
            System.out.println(nomeTerrorista + " está morto e não consegue atacar!");
        }
    }

    // Método plantar bomba
    public void plantarBomba() {
        if(vivo){
            System.out.println("A bomba foi plantada por " + nomeTerrorista);
        }
        else{
            System.out.println(nomeTerrorista + " está morto e não consegue Plantar a bomba");
        }
    }

    // Método lançar granada
    // public void lancarGranada(Personagem policial) {
    public void lancarGranada() {
        if(vivo){
            if (this.qtdGranadas <= 0) {
            System.out.println("Sem granadas restantes");
            return;
        }

        this.qtdGranadas--;
        System.out.println("Granada lançada por " + this.nomeTerrorista);
        System.out.println("Granadas restantes: " + this.qtdGranadas);
        }
        else{
            System.out.println(nomeTerrorista + " está morto e não consegue Lancar Granadas");
        }
    }

    // Método passar a vez
    public void passarVez() {
        System.out.println(this.nomeTerrorista + " passou a vez");
    }
}