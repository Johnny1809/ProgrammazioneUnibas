
    create table Azienda (
        id int8 not null,
        partitaIva varchar(255) unique,
        ragioneSociale varchar(255),
        primary key (id)
    );

    create table Risposta (
        id int8 not null,
        data date,
        azienda_id int8,
        sondaggio_id int8,
        primary key (id)
    );

    create table Sede (
        id int8 not null,
        città varchar(255),
        provincia varchar(255),
        via varchar(255),
        azienda_id int8,
        primary key (id)
    );

    create table Sondaggio (
        id int8 not null,
        codice varchar(255) unique,
        dataScadenza date,
        descrizione varchar(255),
        tematica varchar(255),
        primary key (id)
    );

    alter table Risposta 
        add constraint FKC32A78451BCC3ACB 
        foreign key (azienda_id) 
        references Azienda;

    alter table Risposta 
        add constraint FKC32A7845EC50A2B 
        foreign key (sondaggio_id) 
        references Sondaggio;

    alter table Sede 
        add constraint FK2742731BCC3ACB 
        foreign key (azienda_id) 
        references Azienda;

    create table hibernate_sequences (
         sequence_name varchar(255),
         sequence_next_hi_value int4 
    ) ;
