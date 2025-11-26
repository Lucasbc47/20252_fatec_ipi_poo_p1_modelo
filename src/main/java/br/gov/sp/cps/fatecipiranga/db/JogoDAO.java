package br.gov.sp.cps.fatecipiranga.db;

public class JogoDAO {
    public int getUltimoJogo() throws Exception {
        var sql = "SELECT jogo FROM registros_de_ataques ORDER BY jogo DESC LIMIT 1";
        try (
                var conexao = ConnectionFactory.getConnection();
                var ps = conexao.prepareStatement(sql);
                var rs = ps.executeQuery();) {
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        }
    }
}
