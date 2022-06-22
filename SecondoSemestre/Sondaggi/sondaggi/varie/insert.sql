begin transaction;

insert into Azienda (id, partitaIva, ragioneSociale) values(1, '1234', 'srl');
insert into Azienda (id, partitaIva, ragioneSociale) values(2, '5678', 'spa');
insert into Azienda (id, partitaIva, ragioneSociale) values(3, '91011', 'srl');

insert into Sede (id, città, provincia, via, azienda_id) values (1, 'Roma', 'RM', 'Via Mazzini', 1);
insert into Sede (id, città, provincia, via, azienda_id) values (2, 'Milano', 'MI', 'Via Posillipo', 2);
insert into Sede (id, città, provincia, via, azienda_id) values (3, 'Potenza', 'RM', 'Via Roma', 3);

insert into Sondaggio (id, codice, dataScadenza, descrizione, tematica) values (1, '123', '2019-03-08', 'Sondaggio di prova', 'generica');
insert into Risposta(id, data, azienda_id, sondaggio_id) values (1, '2020-04-05', 1, 1);

insert into hibernate_sequences(sequence_name, sequence_next_hi_value) values ('Azienda', 1);
insert into hibernate_sequences(sequence_name, sequence_next_hi_value) values ('Sede', 1);
insert into hibernate_sequences(sequence_name, sequence_next_hi_value) values ('Sondaggio', 1);
insert into hibernate_sequences(sequence_name, sequence_next_hi_value) values ('Risposta', 1);

commit;

