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
INSERT INTO login VALUES (DEFAULT, 'DEMO','demo','1066726e7160bd9c987c9968e0cc275a','0','0')


/*
*
* Demais colunas da demo2
*
*/

create table leitor(
id serial primary key,
nome text not null,
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