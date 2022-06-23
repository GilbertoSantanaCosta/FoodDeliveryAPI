insert into cozinha (id, nome) values (1 ,'tailandesa');
insert into cozinha (id, nome) values (2 , 'chinesa');

insert into restaurante (nome, taxa_frete, cozinha_id ) values ('SushiBrasileiro' , 10.00 , 1);
insert into restaurante (nome, taxa_frete, cozinha_id ) values ('FeijoadaJaponesa', 15.00 , 2);
insert into restaurante (nome, taxa_frete, cozinha_id ) values ('Japonesa', 15.00 , 2);

insert into forma_de_pagamento (descricao) values('dinheiro');

insert into permissao (nome , descricao) values('compra', 'compra permitida');

insert into estado (nome) values ('são paulo');
insert into estado (nome) values ('rio de janeiro');

insert into cidade (nome, estado_id) values ('carapicuiba' , 1);
insert into cidade (nome, estado_id) values ('osasco' , 1);
insert into cidade (nome, estado_id) values ('itapevi', 1);
insert into cidade (nome, estado_id) values ('ipanema', 2);