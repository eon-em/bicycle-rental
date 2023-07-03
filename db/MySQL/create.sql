drop database if exists jegBicicletasBD;

create database jegBicicletasBD;

use jegBicicletasBD;

create table Usuario(
	id bigint not null auto_increment,
	email varchar(50) not null unique, 
	senha varchar(50) not null, 
	papel varchar(20),
	primary key (id)
);

create table Cliente(
	id bigint not null auto_increment,
	cpf varchar(14) not null unique,
	nome varchar(50) not null, 
	telefone varchar(11) not null, 
	sexo char, 
	dataDeNascimento date not null, 
	primary key (id),
	foreign key (id) references Usuario(id)
);

create table Locadora(
	id bigint not null auto_increment,
	nome varchar(50) not null,
	descricao varchar(120) not null,
	cnpj varchar(24) not null unique,
	cidade varchar(30) not null, 
	primary key(id),
	foreign key (id) references Usuario(id)
);

create table Bicicleta(
	id int not null auto_increment,
	clienteId bigint not null,
	locadoraId bigint not null,
	dataLocacao date not null,
	primary key(id),
  	foreign key(clienteId) references Cliente(id),
	foreign key(locadoraId) references Locadora(id)
);

create table Proposta(
	id int not null auto_increment,
	cliente_id bigint not null,
	bicicleta_id int not null,
	valor decimal not null,
	condPagamento varchar(50) not null,
	dataAtual date not null,
	statusCompra varchar(50) not null,
	foreign key (cliente_id) references Cliente(id),
	foreign key (bicicleta_id) references Bicicleta(id),
	primary key(id)
);

insert into Usuario(email, senha, papel) values ('admin', 'admin', 'ADMIN');

