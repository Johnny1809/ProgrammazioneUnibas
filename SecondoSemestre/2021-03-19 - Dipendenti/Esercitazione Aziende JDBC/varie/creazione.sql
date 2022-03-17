begin transaction;

create table azienda (
    partita_iva varchar not null primary key,
    denominazione varchar not null,
    sede varchar not null
);

create table dipendente (
    codice_fiscale varchar not null primary key,
    nome varchar not null,
    cognome varchar not null,
    anno_assunzione int,
    azienda varchar references azienda(partita_iva)
);

commit;

insert into azienda (partita_iva,  denominazione, sede) values ('0001', 'Google', 'San Francisco');
insert into azienda (partita_iva,  denominazione, sede) values ('0002', 'Apple', 'San Francisco');

insert into dipendente ( codice_fiscale, nome, cognome, anno_assunzione, azienda) values ('123', 'John', 'Smith', '1990', '0001');
insert into dipendente ( codice_fiscale, nome, cognome, anno_assunzione, azienda) values ('456' 'Jon', 'Snow', 2010, '0001');
