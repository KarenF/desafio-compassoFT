create table cidades(
id serial,
nome_cidade varchar(50),
estado varchar(50),
primary key(id));

create table cliente(
id_cliente serial,
nome_cliente varchar(50),
genero varchar(50),
data_nascimento varchar(50),
idade varchar(50),
cidades integer,
primary key (id_cliente),
foreign key(cidades) references cidades(id));