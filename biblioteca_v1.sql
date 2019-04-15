/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Gustavo.Steinhoefel
 * Created: 19/03/2019
 */

CREATE database biblioteca;

use biblioteca;

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

INSERT INTO login VALUES (DEFAULT, 'DEMO','demo','1066726e7160bd9c987c9968e0cc275a','0','0')