
    create table Annata (
        id int8 not null,
        anno int4 not null,
        mese int4 not null,
        qualita int4 not null,
        vino_id int8,
        primary key (id)
    );

    create table Vino (
        id int8 not null,
        classificazione varchar(255),
        nome varchar(255),
        tipo varchar(255),
        primary key (id)
    );

    create table Vitigno (
        id int8 not null,
        aromatico boolean not null,
        nomeUva varchar(255),
        percentualeUtilizzata float4 not null,
        annata_id int8,
        primary key (id)
    );

    alter table Annata 
        add constraint FK752C952D1FFFD1D5 
        foreign key (vino_id) 
        references Vino;

    alter table Vitigno 
        add constraint FK7F18B2E0C2CC6C75 
        foreign key (annata_id) 
        references Annata;

    create table hibernate_sequences (
         sequence_name varchar(255),
         sequence_next_hi_value int4 
    ) ;
