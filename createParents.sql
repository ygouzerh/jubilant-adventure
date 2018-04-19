/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  ayoubmrini424
 * Created: Apr 15, 2018
 */

drop table parents cascade constraints;
drop table childrens cascade constraints;

drop sequence id_parents_seq;
drop sequence id_childrens_seq;

create sequence id_parents_seq  start with 1 increment by 1;
create sequence id_childrens_seq start with 1 increment by 1;

create table parents (
    id number default id_parents_seq.nextval primary key,
    nom varchar(30) not null,
    prenom varchar(30) not null,
    sexe char(1) not null,
    datenaissance date not null,
    adresse varchar(100) not null,
    email varchar(50) not null,
    telephone char(10) not null,
    password char(64) not null,
    salt char(64) not null
);

create table childrens (
    id number default id_childrens_seq.nextval primary key,
    idparent number not null references parent(id),
    nom varchar(30) not null,
    prenom varchar(30) not null,
    sexe char(1) not null,
    datenaissance date not null,
    adresse varchar(100) not null,
    email varchar(50)
);

-- The parents must be insert before the childrens

insert into parents (nom, prenom, sexe, datenaissance, adresse, email, telephone, password, salt) values ('toto','titi','f',to_date('10/12/2001', 'dd/MM/yyyy'),'roro','toto@gmail.com','076545433','toto','rrr');
insert into parents (nom, prenom, sexe, datenaissance, adresse, email, telephone, password, salt) values ('gogo','gigi','m',to_date('11/12/2001', 'dd/MM/yyyy'),'koko','gogo@gmail.com','073333333','gogo','rrr');
insert into parents (nom, prenom, sexe, datenaissance, adresse, email, telephone, password, salt) values ('fa3','gigi','m',to_date('12/12/2001', 'dd/MM/yyyy'),'koko','fofo@gmail.com','073333333','fofo','rrr');

insert into childrens (idparent, nom, prenom, sexe, datenaissance, adresse, email) values (1, 'gogo','gugu','m',to_date('10/12/2006', 'dd/MM/yyyy'),'roro','toto@gmail.com');
insert into childrens (idparent, nom, prenom, sexe, datenaissance, adresse, email) values (2, 'gogo','gygy','f',to_date('11/12/2006', 'dd/MM/yyyy'),'roro','fofo@gmail.com');

select * from parents;
