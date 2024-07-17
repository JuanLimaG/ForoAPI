create database foroaluradb;

use foroaluradb;
drop table topicos;
SET FOREIGN_KEY_CHECKS = 0;

create table topicos (
    id int auto_increment,
    titulo varchar(255) not null unique,
    mensaje varchar(255) not null unique,
    fechacreacion DATE NOT NULL,
    estado varchar(255) not null , 
    autorid int not null,
    cursoid int not null,
    primary key (id),
    foreign key (autorid) references usuarios(idusuario)
);

insert into topicos (id,titulo,mensaje,fechaCreacion,estado,autorId,cursoId) values
('1','Buen curso','Hola me encanto el curso de Alura','1998-09-16','activo', '100','10');

create table usuarios (
    idusuario int auto_increment,
    nombre varchar(255) not null,
    email varchar(255) not null unique,
    contrasena varchar(255) NOT NULL,
    tipo varchar(255) not null , 
    primary key (idusuario)
);

ALTER TABLE usuarios CHANGE idUsuarios idUsuario int auto_increment;


insert into usuarios (idUsuario,nombre,email,contrasena,tipo) values
('100','Juan Lima','juanlimag@hotmail.com','$2a$12$Lp/XvrT/zN9Xsqlt/Zk/l./3C9YkHbEbcT8XZxeig6tDRFxlf322e','estudiante');

insert into usuarios (idUsuario,nombre,email,contrasena,tipo) values
('101','Juan Lima','juanlimag@gmail.com','$2a$12$LdZzAY8N6azj8/hk3BL5/uciaMxWju7xcXNsM5PsuCEDVR5nC7CmO','estudiante');

insert into usuarios (idUsuario,nombre,email,contrasena,tipo) values
('102','Juan Lima','juangar@gmail.com','$2a$12$XapcFIyZODa9qT7xsu3B1.d6leKCZEkIizYB2yDIPEczb8LO90ema','estudiante');

select * FROM topicos;

select * FROM usuarios;