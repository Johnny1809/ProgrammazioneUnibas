
    create table Paziente (
        id int8 not null,
        codiceFiscale varchar(255) unique,
        cognome varchar(255),
        dataDiNascita date,
        nome varchar(255),
        residenza varchar(255),
        primary key (id)
    );

    create table Prestazione (
        id int8 not null,
        codice varchar(255) unique,
        nome varchar(255),
        tipologia varchar(255),
        primary key (id)
    );

    create table Prestazione_Ricetta (
        prestazioni_id int8 not null,
        ricette_id int8 not null
    );

    create table Ricetta (
        id int8 not null,
        codice varchar(255) unique,
        dataCreazione date,
        motivazione varchar(255),
        mutuabile boolean not null,
        paziente_id int8,
        primary key (id)
    );

    alter table Prestazione_Ricetta 
        add constraint FK515A1D435EE907AB 
        foreign key (prestazioni_id) 
        references Prestazione;

    alter table Prestazione_Ricetta 
        add constraint FK515A1D43A433876B 
        foreign key (ricette_id) 
        references Ricetta;

    alter table Ricetta 
        add constraint FKAA8E9648956B48E5 
        foreign key (paziente_id) 
        references Paziente;

    create table hibernate_sequences (
         sequence_name varchar(255),
         sequence_next_hi_value int4 
    ) ;
