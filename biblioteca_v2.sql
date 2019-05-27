/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Gustavo.Steinhoefel
 * Created: 19/03/2019
 */

/*CREATE database biblioteca;*/

create table cidade(
id serial primary key,
nome text,
uf varchar(2));

create table editora(
id serial primary key,
descricao text);

create table autor(
id serial primary key,
nome text);

create table assunto(
id serial primary key,
descricao text);

create table colecao(
id serial primary key,
descricao text);

create table class_literaria(
id serial primary key,
descricao text);

create table login(
id serial primary key,
nome text,
login varchar(45),
password varchar(45),
status varchar(1),
del varchar(1));

/*
usuario demo senha demo
*/
INSERT INTO login VALUES (DEFAULT, 'DEMO','demo','fe01ce2a7fbac8fafaed7c982a04e229','0','0');


/*
*
* Demais colunas da demo2
* Edited: 20/05/2019
*
*
*/


create table leitor(
id serial primary key,
nome text not null,
num_cgc varchar(14) not null,
endereco varchar(150),
cidade_id integer not null,
tipo integer not null,
dt_nascimento Date,
matricula varchar(45),
turma varchar(45),
turno varchar(45),
limite_livros varchar(10),
status varchar(1),
del varchar(1),
FOREIGN KEY (cidade_id) REFERENCES cidade (id));


CREATE TABLE livro (
    id serial primary key,
    codbarras character varying(13),
    titulo text,
    subtitulo text,
    isbn text,
    volume integer,
    anoedicao integer,
    edicao integer,
    tombo text,
    cdu text,
    cdd text,
    cutter text,
    id_editora integer,
    id_class_literaria integer,
    id_colecao integer,
    data_aquisicao date,
    status varchar(1),
    del varchar(1),
    FOREIGN KEY (id_editora) REFERENCES editora (id),
    FOREIGN KEY (id_class_literaria) REFERENCES class_literaria (id),
    FOREIGN KEY (id_colecao) REFERENCES colecao (id)
);

CREATE TABLE emprestimo (
    id serial primary key,
    id_livro integer not null,
    dataemprestimo date NOT NULL,
    datavencimento date NOT NULL,
    datachegada date,
    id_leitor integer,
    FOREIGN KEY (id_livro)  REFERENCES livro  (id),
    FOREIGN KEY (id_leitor) REFERENCES leitor (id)
);


CREATE TABLE livro_autor(
    id serial primary key,
    id_livro integer,
    id_autor integer,
    FOREIGN KEY (id_livro) REFERENCES livro (id),
    FOREIGN KEY (id_autor) REFERENCES autor (id));

CREATE TABLE livro_assunto(
    id serial primary key,
    id_livro integer,
    id_assunto integer,
    FOREIGN KEY (id_livro) REFERENCES livro (id),
    FOREIGN KEY (id_assunto) REFERENCES assunto (id));


CREATE OR REPLACE FUNCTION public.fupcodbarraslivro()
    RETURNS trigger
    LANGUAGE 'plpgsql'
    VOLATILE
    COST 100
AS $BODY$BEGIN
UPDATE livro 
SET codBarras=(SELECT lpad(cast(id as varchar),13,'0')  as cod 
	       FROM livro 
               WHERE id=new.id) 
WHERE id=new.id;
RETURN NULL;
END;
$BODY$;

CREATE TRIGGER tupdate_livro
    AFTER INSERT
    ON livro
    FOR EACH ROW
    EXECUTE PROCEDURE public.fupcodbarraslivro();

/*
INSERT INTO livro (titulo, subtitulo, isbn, volume, anoedicao, edicao, tombo, cdu, cdd, cutter, id_editora, id_class_literaria, id_colecao, data_aquisicao, status, del, codbarras) 
	VALUES ('java5 ', 'java5', '12345678', 1, 2019, 1, '', NULL, NULL, NULL, 1, 1, 1, CURRENT_DATE, false, '0', NULL);
INSERT INTO livro (titulo, subtitulo, isbn, volume, anoedicao, edicao, tombo, cdu, cdd, cutter, id_editora, id_class_literaria, id_colecao, data_aquisicao, status, del, codbarras) 
	VALUES ('java6 ', 'java4', '12345678', 1, 2018, 1, '', NULL, NULL, NULL, 1, 1, 1, CURRENT_DATE, false, '0', NULL);
INSERT INTO livro (titulo, subtitulo, isbn, volume, anoedicao, edicao, tombo, cdu, cdd, cutter, id_editora, id_class_literaria, id_colecao, data_aquisicao, status, del, codbarras) 
	VALUES ('java7 ', 'java3', '12345678', 1, 2016, 1, '', NULL, NULL, NULL, 1, 1, 1, CURRENT_DATE, false, '0', NULL);
INSERT INTO livro (titulo, subtitulo, isbn, volume, anoedicao, edicao, tombo, cdu, cdd, cutter, id_editora, id_class_literaria, id_colecao, data_aquisicao, status, del, codbarras) 
	VALUES ('java9 ', 'java2', '12345678', 1, 2014, 1, '', NULL, NULL, NULL, 1, 1, 1, CURRENT_DATE, false, '0', NULL);
INSERT INTO livro (titulo, subtitulo, isbn, volume, anoedicao, edicao, tombo, cdu, cdd, cutter, id_editora, id_class_literaria, id_colecao, data_aquisicao, status, del, codbarras) 
	VALUES ('java10 ', 'java1', '12345678', 1, 2013, 1, '', NULL, NULL, NULL, 1, 1, 1, CURRENT_DATE, false, '0', NULL);


*/