package br.gov.sp.cps.fatecipiranga.db;

import br.gov.sp.cps.fatecipiranga.models.Ataque;

public class AtaqueDAO {
    public void cadastrar(Ataque a) throws Exception {
        var sql = "INSERT INTO registros_de_ataques(jogo, personagem, arma, vezes, mapa) VALUES(?,?,?,?,?)";

        try (
                var conexao = ConnectionFactory.getConnection();
                var ps = conexao.prepareStatement(sql);) {
            ps.setInt(1, a.getJogo());
            ps.setString(2, a.getPersonagem());
            ps.setString(3, a.getArma());
            ps.setInt(4, a.getVezes());
            ps.setString(5, a.getMapa());

            ps.execute();
        }
    }
}

// Exemplo de registro:
// identificacao: 1 | jogo: 4 | personagem: 'policial-Eric' | arma: 'fuzil' | vezes: 3 | mapa: 'Roma'
// (ID: 1) Policial-Eric atacou com fuzil 3 vezes no jogo 4 em Roma
