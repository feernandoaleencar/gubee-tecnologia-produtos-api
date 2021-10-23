create table produto (
	id bigint not null primary key auto_increment,
	nome VARCHAR(60) NOT NULL,
    descricao VARCHAR(60) NOT NULL,
    id_mercado_alvo bigint not null,
    id_tecnologia bigint not null
  	
);

alter table produto add constraint fk_produto_mercado_alvo
foreign key (id_mercado_alvo) references mercado_alvo (id);

alter table produto add constraint fk_produto_tecnologia
foreign key (id_tecnologia) references tecnologia (id);