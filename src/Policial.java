public class Policial{
   private String nomePolicial;
    private String armamento;
    private int quantidadeGranadas;
    private int energia; 

    // construtor
    public Policial(String nomePolicial, String armamento, int quantidadeGranadas, int energia) {
        this.nomePolicial = nomePolicial;
        this.armamento = armamento;
        setQuantidadeGranadas(quantidadeGranadas);
        setEnergia(energia);
    }

    // getters e setters
    public String getNomePolicial() {
        return nomePolicial;
    }

    public void setNomePolicial(String nomePolicial) {
        this.nomePolicial = nomePolicial;
    }

    public String getArmamento() {
        return armamento;
    }

    public void setArmamento(String armamento) {
        this.armamento = armamento;
    }

    public int getQuantidadeGranadas() {
        return quantidadeGranadas;
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

    public int getEnergia() {
        return energia;
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

}