package br.gov.sp.cps.fatecipiranga;

import java.util.ArrayList;
import java.util.Random;

public class Policial {

    private String nomePolicial;
    private int quantidadeGranadas;
    private int energia;
    private ArrayList<String> atkLog;

    private Faca faca;
    private Pistola pistola;
    private Fuzil fuzil;
    private Random random;

    // construtor
    public Policial(String nomePolicial, int quantidadeGranadas, int energia) {
        setNomePolicial(nomePolicial);
        setQuantidadeGranadas(quantidadeGranadas);
        setEnergia(energia);

        this.atkLog = new ArrayList<>();
        this.faca = new Faca();
        this.pistola = new Pistola();
        this.fuzil = new Fuzil();
        this.random = new Random();

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

    public ArrayList<String> getAtkLog() {
        return this.atkLog;
    }

    // Método receber dano
    public void receberDano(int dano) {
        if (this.energia <= 0) {
            return;
        }

        this.energia -= dano;

        if (this.energia <= 0) {
            this.energia = 0;
            System.out.println(this.nomePolicial + " faleceu (x_x;)");
        }
    }

    // Método atacar
    public int atacar(String mapa) {
        int dano = 0;

        if (this.energia > 0) {
            int escolherArmamento = this.random.nextInt(3);

            String armamento = "";

            if (escolherArmamento == 0) {
                dano = this.faca.getDano();
                armamento = "faca";
            } else if (escolherArmamento == 1) {
                dano = this.pistola.getDano();
                armamento = "pistola";
            } else {
                dano = this.fuzil.getDano();
                armamento = "fuzil";
            }
            this.atkLog.add(armamento);
            System.out.println(this.nomePolicial + " atacando com " + armamento + " ~~ " + mapa);
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
        return "<Policial nome=" + this.nomePolicial
                + " granadas=" + this.quantidadeGranadas + " energia=" + this.energia + ">";
    }
}