package br.gov.sp.cps.fatecipiranga.models;

import lombok.Data;

// Exemplo de registro:
// identificacao: 1 | jogo: 4 | personagem: 'policial-Eric' | arma: 'fuzil' | vezes: 3 | mapa: 'Roma'
// (ID: 1) Policial-Eric atacou com fuzil 3 vezes no jogo 4 em Roma
@Data
public class Ataque {
    private int identificacao;
    private int jogo;

    private String personagem; // policial-[nome] ou terrorista-[nome]
    private String arma; // fuzil, pistola

    private int vezes;
    private String mapa; // Fatec Ipiranga | Roma

    public Ataque(int jogo, String personagem, String arma, int vezes, String mapa) {
        this(0, jogo, personagem, arma, vezes, mapa);
    }
    public Ataque(int identificacao, int jogo, String personagem, String arma, int vezes, String mapa) {
        setIdentificacao(identificacao);
        setJogo(jogo);
        setPersonagem(personagem);
        setArma(arma);
        setVezes(vezes);
        setMapa(mapa);
    }
}