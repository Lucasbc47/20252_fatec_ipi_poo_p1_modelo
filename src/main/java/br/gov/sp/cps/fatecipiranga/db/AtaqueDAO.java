package br.gov.sp.cps.fatecipiranga.db;

import br.gov.sp.cps.fatecipiranga.models.Ataque;

public class AtaqueDAO {
    public void cadastrar(Ataque a) throws Exception {
        var sql = "INSERT INTO registros_de_ataques(jogo, rodada, personagem, arma, vezes, mapa) VALUES(?,?,?,?,?,?)";

        try (
                var conexao = ConnectionFactory.getConnection();
                var ps = conexao.prepareStatement(sql);) {
            ps.setInt(1, a.getJogo());
            ps.setInt(2, a.getRodada());
            ps.setString(3, a.getPersonagem());
            ps.setString(4, a.getArma());
            ps.setInt(5, a.getVezes());
            ps.setString(6, a.getMapa());

            ps.execute();
        }
    }

    public void atualizar(Ataque a, int identificacao) throws Exception {
        var sql = "UPDATE registros_de_ataques SET jogo=?,rodada=?,personagem=?,arma=?,vezes=?,mapa=? WHERE identificacao=?";
        try (
                var conexao = ConnectionFactory.getConnection();
                var ps = conexao.prepareStatement(sql);) {
            ps.setInt(1, a.getJogo());
            ps.setInt(2, a.getRodada());
            ps.setString(3, a.getPersonagem());
            ps.setString(4, a.getArma());
            ps.setInt(5, a.getVezes());
            ps.setString(6, a.getMapa());
            ps.setInt(7, identificacao);

            ps.execute();
        }

    }

    public void apagar(int id) throws Exception {
        var sql = "DELETE FROM registros_de_ataques WHERE identificacao=?";
        try (
                var conexao = ConnectionFactory.getConnection();
                var ps = conexao.prepareStatement(sql);) {
            ps.setInt(1, id);
            ps.execute();
        }
    }

}

// Exemplo de registro:
// identificacao: 1 | jogo: 4 | rodada: 1 | personagem: 'policial-Eric' | arma:
// 'fuzil' | vezes: 3 | mapa: 'Roma'
// (ID: 1) Policial-Eric atacou com fuzil 3 vezes na rodada 1 do jogo 4 em Roma
