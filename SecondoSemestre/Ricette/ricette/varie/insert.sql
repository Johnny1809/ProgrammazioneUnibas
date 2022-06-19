insert into paziente (id, codiceFiscale, cognome, dataDiNascita, nome, residenza) values (1, 'AB1', 'Bonelli', '2000-03-08', 'Alfredo', 'Potenza');
insert into paziente (id, codiceFiscale, cognome, dataDiNascita, nome, residenza) values (2, 'CD2', 'Donati', '2000-10-03', 'Carlo', 'Potenza');
insert into paziente (id, codiceFiscale, cognome, dataDiNascita, nome, residenza) values (3, 'EF3', 'Franchi', '1990-08-03', 'Ernesto', 'Roma');

insert into prestazione (id, codice, nome, tipologia) values (1, 'A1A1', 'Aprestazione1', 'tipologia1');
insert into prestazione (id, codice, nome, tipologia) values (2, 'B2B2', 'Bprestazione2', 'tipologia1');
insert into prestazione (id, codice, nome, tipologia) values (3, 'C3C3', 'Dprestazione3', 'tipologia2');

insert into ricetta (id, codice, dataCreazione, motivazione, mutuabile, paziente_id) values (1, 'A1A1', '2022-06-03', 'motivazione1', true, 1);
insert into ricetta (id, codice, dataCreazione, motivazione, mutuabile, paziente_id) values (2, 'B2B2', '2022-05-27', 'motivazione2', true, 1);
insert into ricetta (id, codice, dataCreazione, motivazione, mutuabile, paziente_id) values (3, 'C3C3', '2022-06-01', 'motivazione3', true, 2);

insert into prestazione_ricetta (prestazioni_id, ricette_id) values (1,1);
insert into prestazione_ricetta (prestazioni_id, ricette_id) values (2,1);
insert into prestazione_ricetta (prestazioni_id, ricette_id) values (3,2);

insert into hibernate_sequences (sequence_name, sequence_next_hi_value) values ('Paziente', 1);
insert into hibernate_sequences (sequence_name, sequence_next_hi_value) values ('Prestazione', 1);
insert into hibernate_sequences (sequence_name, sequence_next_hi_value) values ('Ricetta', 1);