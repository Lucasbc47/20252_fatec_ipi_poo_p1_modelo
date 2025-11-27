package br.gov.sp.cps.fatecipiranga;

import java.util.ArrayList;
import java.util.Random;

import br.gov.sp.cps.fatecipiranga.db.AtaqueDAO;
import br.gov.sp.cps.fatecipiranga.models.Ataque;

public class Terrorista {

    private String nomeTerrorista;
    private int quantidadeGranadas;
    private int energia;
    private ArrayList<String> atkLog;

    // Armas do personagem
    private Faca faca;
    private Pistola pistola;
    private Fuzil fuzil;

    private Random random;

    // Construtor
    public Terrorista(String nomeTerrorista, int quantidadeGranadas, int energia) {
        setNomeTerrorista(nomeTerrorista);
        setQuantidadeGranadas(quantidadeGranadas);
        setEnergia(energia);

        this.atkLog = new ArrayList<>();
        this.faca = new Faca();
        this.pistola = new Pistola();
        this.fuzil = new Fuzil();
        this.random = new Random();
    }

    // Setters
    public void setNomeTerrorista(String nomeTerrorista) {
        if (nomeTerrorista.length() >= 4) {
            this.nomeTerrorista = nomeTerrorista;
        } else {
            System.out.println("Nome deve ter pelo menos 4 caracteres!");
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

    public int getQuantidadeGranadas() {
        return this.quantidadeGranadas;
    }

    public int getEnergia() {
        return this.energia;
    }

    public ArrayList<String> getAtkLog() {
        return this.atkLog;
    }

    // Método receber dano
    public void receberDano(int dano) {
        if (this.energia <= 0)
            return;

        this.energia -= dano;

        if (this.energia <= 0) {
            this.energia = 0;
            System.out.println(this.nomeTerrorista + " faleceu (x_x;)");
        }
    }

    // Método atacar
    public int atacar(String mapa) {
        int dano = 0;
        
        if (this.energia > 0) {
            int escolherArmamento = this.random.nextInt(3);
            String armamento = "";

            if (escolherArmamento == 0) {
                dano = this.faca.atacar();
                armamento = "faca";
            } else if (escolherArmamento == 1) {
                dano = this.pistola.atacar();
                armamento = "pistola";
            } else {
                dano = this.fuzil.atacar();
                armamento = "fuzil";
            }
            this.atkLog.add(armamento);
            System.out.println(this.nomeTerrorista + " atacando com " + armamento + " ~~ " + mapa);
        } else {
            System.out.println(this.nomeTerrorista + " está morto e não consegue atacar!");
        }

        return dano;
    }

    // Método plantar bomba
    public void plantarBomba(String mapa) {
        if (this.energia > 0) {
            System.out.println(this.nomeTerrorista + " plantando bomba ~~ " + mapa);
        } else {
            System.out.println(this.nomeTerrorista + " está morto e não consegue plantar a bomba");
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
                    this.nomeTerrorista + " lancando granada ~~ " + mapa + " - restam: " + this.quantidadeGranadas);
        } else {
            System.out.println(this.nomeTerrorista + " está morto e não consegue Lancar Granadas");
        }
    }

    // Método passar a vez
    public void passarVez(String mapa) {
        if (this.energia > 0) {
            System.out.println(this.nomeTerrorista + " passando a vez  ~~ " + "[" + mapa + "]");
            return;
        } else {
            System.out.println(this.nomeTerrorista + " está morto e não consegue Passar a vez");
        }
    }

    // Método para salvar histórico de ataques no banco
    public void salvarAtaque(AtaqueDAO atkDao, int jogo, String mapa)
            throws Exception {
        int fuzil = 0, pistola = 0, faca = 0;
        for (String arma : this.atkLog) {
            if (arma.equals("fuzil")) {
                fuzil++;
            } else if (arma.equals("pistola")) {
                pistola++;
            } else if (arma.equals("faca")) {
                faca++;
            }
        }
        String nome = "terrorista-" + this.nomeTerrorista;
        if (fuzil > 0) {
            atkDao.cadastrar(new Ataque(jogo, nome, "fuzil", fuzil, mapa));
        }
        if (pistola > 0) {
            atkDao.cadastrar(new Ataque(jogo, nome, "pistola", pistola, mapa));
        }
        if (faca > 0) {
            atkDao.cadastrar(new Ataque(jogo, nome, "faca", faca, mapa));
        }
    }

    // toString: para visualização agradavel da classe de Terrorista
    public String toString() {
        return "<Terrorista nome=" + this.nomeTerrorista +
                " granadas=" + this.quantidadeGranadas + " energia=" + this.energia + ">";
    }
}