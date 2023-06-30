-- Insert 3 clients

-- Client 1 (fernandasabrinagoncalves, j7TS9xtx8c)
INSERT INTO Usuario (email, senha, papel)
VALUES ('fernandasabrinagoncalves@vmetaiscba.com.br', 'j7TS9xtx8c', 'CLIENTE');

SET @id_usuario = LAST_INSERT_ID();

INSERT INTO Cliente (id, cpf, nome, telefone, sexo, dataDeNascimento)
VALUES (@id_usuario, '563.077.751-30', 'Fernanda', '985256837', 'F', '1975-06-10');

-- Client 2 (lucasrafaelramos, aAsCFk0QHG)
INSERT INTO Usuario (email, senha, papel)
VALUES ('lucasrafaelramos@hotmail.con', 'aAsCFk0QHG', 'CLIENTE');

SET @id_usuario = LAST_INSERT_ID();

INSERT INTO Cliente (id, cpf, nome, telefone, sexo, dataDeNascimento)
VALUES (@id_usuario, '640.637.629-39', 'Lucas', '998811022', 'M', '1976-06-11');

-- Client 3 (gabrielly_daconceicao, 0kuQ8HHDsH)
INSERT INTO Usuario (email, senha, papel)
VALUES ('gabrielly_daconceicao@netwis.com.br', '0kuQ8HHDsH', 'CLIENTE');

SET @id_usuario = LAST_INSERT_ID();

INSERT INTO Cliente (id, cpf, nome, telefone, sexo, dataDeNascimento)
VALUES (@id_usuario, '640.709.912-98', 'Gabrielly', '985188637', 'F', '1946-05-12');
