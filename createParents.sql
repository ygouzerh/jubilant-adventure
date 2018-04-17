/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  ayoubmrini424
 * Created: Apr 15, 2018
 */



create table parent (
    id int not null primary key,
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

insert into parent values (1,'toto','titi','f',to_date('2001-12-10', 'yyyy-mm-dd'),'roro','toto@gmail.com','076545433','toto','rrr');
insert into parent values (2,'gogo','gigi','m',to_date('2001-12-10', 'yyyy-mm-dd'),'koko','gogo@gmail.com','073333333','gogo','rrr');

select * from parent;

SELECT email, password FROM parent WHERE email = 'toto@gmail.com' and password = 'toto' ;

