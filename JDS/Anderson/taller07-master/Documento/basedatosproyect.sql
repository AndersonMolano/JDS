create database usuario;
use usuario;
 -- drop database usuario;



CREATE TABLE usuarios (
  id_Usuario int PRIMARY KEY auto_increment,
  tipo_usuario ENUM('Cliente', 'Administrador') NOT NULL,
  nombre_Usuario varchar(30),
  apellido_Usuario varchar(50),
  correo_usuario varchar(80) not null,
  contraseña_Usuario varchar(30) not null,
  es_administrador BOOLEAN NOT NULL DEFAULT 0
);

CREATE TABLE servicios (
  id_servicio INT PRIMARY KEY AUTO_INCREMENT,
  nombre_servicio VARCHAR(100) NOT NULL,
  descripcion_servicio VARCHAR(255),
  precio_servicio DECIMAL(8, 2) NOT NULL,
  estado_servicio enum ("Disponible", 'No disponible'),
  id_usuario int not null,
  foreign key (id_usuario) references usuarios(id_Usuario)
);

create table equipos(
 id_equipo int primary key auto_increment,
 nombre_equipo varchar (50) not null,
 marca_equipo varchar (30) not null,
 estado_equipo varchar (40) not null
 );

Create table mantenimiento_equip(
	id_mante int primary key auto_increment,
    fecha_mante date not null,
    id_equipos int not null,
    id_usuarios int not null,
    foreign key (id_equipos) references equipos (id_equipo),
    foreign key (id_usuarios) references usuarios (id_Usuario)
);

create table citas(
	id_cita int primary key auto_increment,
    fecha_cita date not null,
    hora_cita time not null,
    estado_cita enum('Agendado', 'Cancelado', 'Reprogramado'),
    id_usuario int not null,
	id_servicio int not null,
    foreign key (id_usuario) references usuarios(id_Usuario),
    foreign key (id_servicio) references servicios(id_servicio)
);



