CREATE TABLE categoria (
  id INT NOT NULL,
  descricao VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE curso (
  id INT NOT NULL AUTO_INCREMENT,
  descricao varchar(255) NOT NULL,
  inicio DATE NOT NULL,
  termino DATE NOT NULL,
  alunos INT,
  categoria_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);
