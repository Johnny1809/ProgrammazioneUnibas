begin transaction;

insert into Vino (id, classificazione, nome, tipo) values (1, 'DOCG', 'Vino1', 'Rosso');
insert into Vino (id, classificazione, nome, tipo) values (2, 'DOCG', 'Vino2', 'Rosso');
insert into Vino (id, classificazione, nome, tipo) values (3, 'DOC', 'Vino3', 'Bianco');

insert into Annata (id, anno, mese, qualita,vino_id) values (1, 2000, 0,  3, 1);
insert into Annata (id, anno, mese, qualita,vino_id) values (2, 2002, 5,  4, 1);
insert into Annata (id, anno, mese, qualita,vino_id) values (3, 2003, 10,  5, 2);

insert into Vitigno (id, aromatico, nomeUva, percentualeUtilizzata, annata_id ) values (1, true, 'Uva1', '10', 1);
insert into Vitigno (id, aromatico, nomeUva, percentualeUtilizzata, annata_id ) values (2, true, 'Uva2', '90', 1);
insert into Vitigno (id, aromatico, nomeUva, percentualeUtilizzata, annata_id ) values (3, false, 'Uva3', '100', 2);

insert into hibernate_sequences (sequence_name, sequence_next_hi_value) values ('Vino', 1);
insert into hibernate_sequences (sequence_name, sequence_next_hi_value) values ('Annata', 1);
insert into hibernate_sequences (sequence_name, sequence_next_hi_value) values ('Vitigno', 1);

commit;