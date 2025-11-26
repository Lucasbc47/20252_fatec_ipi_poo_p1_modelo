-- Tabela para armazenar histórico de ataques por rodada;
--   id:         1,
--   jogo:       1,
--   rodada:     1,
--   personagem: policial-[nome],
--   arma:       fuzil,
--   mapa:       "FATEC Ipiranga"
CREATE TABLE registros_de_ataques (
    identificacao SERIAL PRIMARY KEY,
    jogo INTEGER NOT NULL,
    personagem VARCHAR(100) NOT NULL,
    arma VARCHAR(100) NOT NULL,
    vezes INTEGER NOT NULL,
    mapa VARCHAR(100) NOT NULL
); 

CREATE TABLE resultado_rodada (
    id SERIAL PRIMARY KEY,
    data_hora TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    personagem VARCHAR(100) NOT NULL,
    resultado TEXT NOT NULL,
    rodada INTEGER NOT NULL
);
INSERT INTO resultado_rodada (personagem, resultado, rodada)
VALUES ('policial-Lucas', 'Venceu', 1);


SELECT *
FROM registros_de_ataques
LIMIT 100
SELECT *
FROM registros_de_ataques
WHERE
    jogo = 1;
-- Apagar jogo do ID 1
DELETE FROM "registros_de_ataques" WHERE "jogo" = 1

UPDATE registros_de_ataques
SET
    mapa = 'Chernobyl'
WHERE
    identificacao = 0