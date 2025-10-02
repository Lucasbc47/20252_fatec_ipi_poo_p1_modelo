public class Policial {

    private String nomePolicial;
    private String armamento;
    private int quantidadeGranadas;
    private int energia;

    // construtor
    public Policial(String nomePolicial, String armamento, int quantidadeGranadas, int energia) {
        setNomePolicial(nomePolicial);
        setArmamento(armamento);
        setQuantidadeGranadas(quantidadeGranadas);
        setEnergia(energia);
    }

    // getters e setters
    public void setNomePolicial(String nomePolicial) {
        if (nomePolicial.length() >= 4) {
            this.nomePolicial = nomePolicial;
        } else {
            System.out.println("Nome deve ter pelo menos 4 caracteres!");
        }
    }

    public String getNomePolicial() {
        return this.nomePolicial;
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

    public String getArmamento() {
        return this.armamento;
    }

    public void setQuantidadeGranadas(int quantidadeGranadas) {
        if (quantidadeGranadas < 0) {
            this.quantidadeGranadas = 0;
        } else if (quantidadeGranadas > 5) {
            this.quantidadeGranadas = 5;
        } else {
            this.quantidadeGranadas = quantidadeGranadas;
        }
    }

    public int getQuantidadeGranadas() {
        return this.quantidadeGranadas;
    }

    public void setEnergia(int energia) {
        if (energia < 0) {
            this.energia = 0;
        } else if (energia > 10) {
            this.energia = 10;
        } else {
            this.energia = energia;
        }
    }

    public int getEnergia() {
        return this.energia;
    }

    // métodos de ação
    // receber dano
     public void receberDano(int dano) {
        if (this.energia <= 0)
            return;

        this.energia -= dano;

        if (this.energia <= 0) {
            this.energia = 0;
            System.out.println(nomePolicial + " faleceu");
        }
    }

    //ação atacar
    public void atacar(String armamento) {
        int dano = 0;

        if (this.energia > 0) {
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

            System.out.println(this.nomePolicial + " atacou com " + this.armamento);
        } else {
            System.out.println(nomePolicial + " está morto e não consegue atacar!");
        }
    }

    //desarmar bomba
    public void desarmarBomba() {
        if (this.energia > 0) {
            System.out.println("A bomba foi desarmada por " + nomePolicial);
        } else {
            System.out.println(nomePolicial + " está morto e não consegue desarmar a bomba");
        }
    }

    //lançar granada
    public void lancarGranada() {
        if (this.energia > 0) {
            if (this.quantidadeGranadas <= 0) {
                System.out.println("Sem granadas restantes");
                return;
            }

            this.quantidadeGranadas--;
            System.out.println("Granada lançada por " + this.nomePolicial);
            System.out.println("Granadas restantes: " + this.quantidadeGranadas);
        } else {
            System.out.println(nomePolicial + " está morto e não consegue Lancar Granadas");
        }
    }

    //passar vez
    public void passarVez() {
        if (this.energia > 0) {
            System.out.println(nomePolicial + " Passou a vez");
            return;
        } else {
            System.out.println(nomePolicial + " está morto e não consegue Passar a vez");
        }
    }
}