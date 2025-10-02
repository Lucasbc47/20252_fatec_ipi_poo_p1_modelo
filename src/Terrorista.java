public class Terrorista {

    private String nomeTerrorista;
    private String armamento;
    private int quantidadeGranadas;
    private int energia;

    // Construtor
    public Terrorista(String nomeTerrorista, String armamento, int quantidadeGranadas, int energia) {
        setNomeTerrorista(nomeTerrorista);
        setArmamento(armamento);
        setQuantidadeGranadas(quantidadeGranadas);
        setEnergia(energia);
    }

    // Setters
    public void setNomeTerrorista(String nomeTerrorista) {
        if (nomeTerrorista.length() >= 4) {
            this.nomeTerrorista = nomeTerrorista;
        } else {
            System.out.println("Nome deve ter pelo menos 4 caracteres!");
        }
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

    public void setQuantidadeGranadas(int quantidadeGranadas) {
        if (quantidadeGranadas < 0) {
            this.quantidadeGranadas = 0;
        } else if (quantidadeGranadas > 5) {
            this.quantidadeGranadas = 5;
        } else {
            this.quantidadeGranadas = quantidadeGranadas;
        }
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

    // Getters
    public String getNomeTerrorista() {
        return this.nomeTerrorista;
    }

    public String getArmamento() {
        return this.armamento;
    }

    public int getQuantidadeGranadas() {
        return this.quantidadeGranadas;
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
            System.out.println(nomeTerrorista + " faleceu");
        }
    }

    // Método atacar
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

            System.out.println(this.nomeTerrorista + " atacou com " + this.armamento);
        } else {
            System.out.println(nomeTerrorista + " está morto e não consegue atacar!");
        }
    }

    // Método plantar bomba
    public void plantarBomba() {
        if (this.energia > 0) {
            System.out.println("A bomba foi plantada por " + nomeTerrorista);
        } else {
            System.out.println(nomeTerrorista + " está morto e não consegue Plantar a bomba");
        }
    }

    // Método lançar granada
    public void lancarGranada() {
        if (this.energia > 0) {
            if (this.quantidadeGranadas <= 0) {
                System.out.println("Sem granadas restantes");
                return;
            }

            this.quantidadeGranadas--;
            System.out.println("Granada lançada por " + this.nomeTerrorista);
            System.out.println("Granadas restantes: " + this.quantidadeGranadas);
        } else {
            System.out.println(nomeTerrorista + " está morto e não consegue Lancar Granadas");
        }
    }

    // Método passar a vez
    public void passarVez() {
        if (this.energia > 0) {
            System.out.println(nomeTerrorista + " Passou a vez");
            return;
        } else {
            System.out.println(nomeTerrorista + " está morto e não consegue Passar a vez");
        }
    }
}