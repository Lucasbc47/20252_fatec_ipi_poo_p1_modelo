package br.gov.sp.cps.fatecipiranga.db;

import br.gov.sp.cps.fatecipiranga.models.Ataque;

public class AtaqueDAO {
    public void cadastrar(Ataque a) throws Exception {
        var sql = "INSERT INTO registros_de_ataques(jogo, personagem, arma, vezes, mapa) VALUES(?,?,?,?,?)";
        try (
                var conexao = ConnectionFactory.getConnection();
                var ps = conexao.prepareStatement(sql);)

        {
            ps.setInt(1, a.getJogo());
            ps.setString(2, a.getPersonagem());
            ps.setString(3, a.getArma());
            ps.setInt(4, a.getVezes());
            ps.setString(5, a.getMapa());

            ps.execute();
        }

    }

    // public void atualizar(Ataque a, int identificacao) throws Exception {
    //     var sql = "UPDATE registros_de_ataques SET jogo=?,personagem=?,arma=?,vezes=?,mapa=? WHERE identificacao=?";
    //     try (
    //             var conexao = ConnectionFactory.getConnection();
    //             var ps = conexao.prepareStatement(sql);) {
    //         ps.setInt(1, a.getJogo());
    //         ps.setString(2, a.getPersonagem());
    //         ps.setString(3, a.getArma());
    //         ps.setInt(4, a.getVezes());
    //         ps.setString(5, a.getMapa());
    //         ps.setInt(6, identificacao);

    //         ps.execute();
    //     }

    // }
    // public void apagar(int id) throws Exception {
    //     var sql = "DELETE FROM registros_de_ataques WHERE identificacao=?";
    //     try (
    //             var conexao = ConnectionFactory.getConnection();
    //             var ps = conexao.prepareStatement(sql);) {
    //         ps.setInt(1, id);
    //         ps.execute();
    //     }
    // }
}