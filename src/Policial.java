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

    // Método receber dano
    public void receberDano(int dano) {
        if (this.energia <= 0)
            return;

        this.energia -= dano;

        if (this.energia <= 0) {
            this.energia = 0;
            System.out.println(this.nomePolicial + " faleceu (x_x;)");
        }
    }

    // Método atacar
    public int atacar(String armamento, String mapa) {
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

            System.out.println(this.nomePolicial + " atacando com " + this.armamento + " ~~ " + mapa);
        } else {
            System.out.println(this.nomePolicial + " está morto e não consegue atacar!");
        }
        return dano;
    }

    // Método desarmar bomba
    public void desarmarBomba(String mapa) {
        if (this.energia > 0) {
            System.out.println(this.nomePolicial + " desarmando bomba ~~ " + mapa);
        } else {
            System.out.println(this.nomePolicial + " está morto e não consegue desarmar a bomba");
        }
    }

    // Método lançar granada
    public void lancarGranada(String mapa) {
        if (this.energia > 0) {
            if (this.quantidadeGranadas <= 0) {
                System.out.println("Sem granadas restantes");
                return;
            }

            this.quantidadeGranadas--;
            System.out.println(
                    this.nomePolicial + " lancando granada ~~ " + mapa + " - restam: " + this.quantidadeGranadas);
        } else {
            System.out.println(this.nomePolicial + " está morto e não consegue Lancar Granadas");
        }
    }

    // Método passar a vez
    public void passarVez(String mapa) {
        if (this.energia > 0) {
            System.out.println(this.nomePolicial + " passando a vez  ~~ " + "[" + mapa + "]");
            return;
        } else {
            System.out.println(this.nomePolicial + " está morto e não consegue Passar a vez");
        }
    }

    // toString: para visualização agradavel da classe de Policial
    public String toString() {
        return "<Policial nome=" + this.nomePolicial + " armamento=" + this.armamento +
                " granadas=" + this.quantidadeGranadas + " energia=" + this.energia + ">";
    }
}