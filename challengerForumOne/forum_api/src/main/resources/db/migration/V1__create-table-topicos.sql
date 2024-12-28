CREATE TABLE topicos (

	id BIGINT NOT NULL AUTO_INCREMENT,
	titulo VARCHAR(255) NOT NULL,
    mensagem TEXT NOT NULL,
    autor VARCHAR(255) NOT NULL,
    nomeCurso VARCHAR(255) NOT NULL,
    categoria VARCHAR(20) NOT NULL,
    status VARCHAR(20) NOT NULL,
    data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    respostas TEXT,

    primary key(id)
);