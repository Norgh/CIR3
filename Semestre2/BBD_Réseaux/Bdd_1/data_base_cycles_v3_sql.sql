create  database cycle_v3 ;

use cycle_v3 ;

-- ============================================================
--   Table : FOURNISSEUR                                       
-- ============================================================
create table FOURNISSEUR
(
    RAISON_SOCIALE      VARCHAR(32)           not null ,
    NOM_DIRECTEUR  VARCHAR(32)                    ,
    primary key (RAISON_SOCIALE)
);


-- ============================================================
--   Table : TYPE_PIECE                                        
-- ============================================================
create table TYPE_PIECE
(
    REFERENCE_TYPE_PIECE  VARCHAR(10)           not null ,
    LIBELLE_TYPE_PIECE  VARCHAR(32)                    ,
    primary key (REFERENCE_TYPE_PIECE)
);


-- ============================================================
--   Table : COMMANDE                                          
-- ============================================================
create table COMMANDE
(
    REFERENCE_COMMANDE  INTEGER               not null ,
    RAISON_SOCIALE      VARCHAR(32)           not null ,
    DATE_COMMANDE       DATE                           ,
    DATE_LIVRAISON_SOUHAITEE  DATE                           ,
    primary key (REFERENCE_COMMANDE)
);

alter table COMMANDE add constraint CRS foreign key (RAISON_SOCIALE) references FOURNISSEUR (RAISON_SOCIALE) on delete restrict;

create index DESTINER_IDX on COMMANDE (RAISON_SOCIALE);


-- ============================================================
--   Table : LIGNE_COMMANDE                                    
-- ============================================================
create table LIGNE_COMMANDE
(
    REFERENCE_COMMANDE  INTEGER               not null ,
    NUMERO_LIGNE_COMMANDE  INTEGER               not null ,
    REFERENCE_TYPE_PIECE  VARCHAR(10)           not null ,
    QUANTITE_PIECES_COMMANDEES  INTEGER                        ,
    PRIX_PIECE          DECIMAL(7,2)                   ,
    primary key (REFERENCE_COMMANDE, NUMERO_LIGNE_COMMANDE)
);
alter table LIGNE_COMMANDE add constraint LCRTP foreign key (REFERENCE_TYPE_PIECE) references TYPE_PIECE (REFERENCE_TYPE_PIECE) on delete restrict;

alter table LIGNE_COMMANDE add constraint LCRC foreign key (REFERENCE_COMMANDE) references COMMANDE (REFERENCE_COMMANDE) on delete restrict;

create index COMMANDER_IDX on LIGNE_COMMANDE (REFERENCE_TYPE_PIECE);

create index DETAILLER_IDX on LIGNE_COMMANDE (REFERENCE_COMMANDE);


-- ============================================================
--   Table : PIECE                                             
-- ============================================================
create table PIECE
(
    REFERENCE_PIECE     INTEGER               not null ,
    REFERENCE_COMMANDE  INTEGER               not null ,
    NUMERO_LIGNE_COMMANDE  INTEGER               not null ,
    REFERENCE_TYPE_PIECE  VARCHAR(10)           not null ,
    primary key (REFERENCE_PIECE)
);

alter table PIECE add constraint PRC foreign key (REFERENCE_COMMANDE, NUMERO_LIGNE_COMMANDE) references LIGNE_COMMANDE (REFERENCE_COMMANDE, NUMERO_LIGNE_COMMANDE) on delete restrict;

alter table PIECE add constraint PRT foreign key (REFERENCE_TYPE_PIECE) references TYPE_PIECE (REFERENCE_TYPE_PIECE) on delete restrict;

create index APPARTENIR_IDX on PIECE (REFERENCE_COMMANDE, NUMERO_LIGNE_COMMANDE);

create index CARACTERISER_IDX on PIECE (REFERENCE_TYPE_PIECE);


-- ============================================================
--   Table : COMMERCIALISER                                    
-- ============================================================
create table COMMERCIALISER
(
    RAISON_SOCIALE      VARCHAR(32)           not null ,
    REFERENCE_TYPE_PIECE  VARCHAR(10)           not null ,
    primary key (RAISON_SOCIALE, REFERENCE_TYPE_PIECE)
);

alter table COMMERCIALISER add constraint CRC foreign key (RAISON_SOCIALE) references FOURNISSEUR (RAISON_SOCIALE) on delete restrict;

alter table COMMERCIALISER add constraint CRTP foreign key (REFERENCE_TYPE_PIECE) references TYPE_PIECE (REFERENCE_TYPE_PIECE) on delete restrict;

create index LIEN_12_IDX on COMMERCIALISER (RAISON_SOCIALE);

create index LIEN_13_IDX on COMMERCIALISER (REFERENCE_TYPE_PIECE);


insert into FOURNISSEUR values('BERTOULD','DUPONT');
insert into FOURNISSEUR values('PEUGEOT','DUPUIS');
insert into FOURNISSEUR values('MBK','MERLIN');
insert into FOURNISSEUR values('MOTOBECANE','LEBLANC');
insert into FOURNISSEUR values('GITANE','MARTIN');
insert into FOURNISSEUR values('RALEIGH','DUMONT');

insert into TYPE_PIECE values('AR232','guidon');
insert into TYPE_PIECE values('HD934','jante');
insert into TYPE_PIECE values('LP412','cadre');
insert into TYPE_PIECE values('TL683','pneu');
insert into TYPE_PIECE values('GR674','plateau');
insert into TYPE_PIECE values('DE524','pignon');

insert into COMMANDE values(1,'BERTOULD','2006-04-12','2006-04-18');
insert into COMMANDE values(2,'BERTOULD','2006-04-17','2006-04-21');
insert into COMMANDE values(3,'PEUGEOT','2006-04-19','2006-04-23');
insert into COMMANDE values(4,'PEUGEOT','2006-04-29','2006-05-03');
insert into COMMANDE values(5,'MOTOBECANE','2006-05-02','2006-05-08');
insert into COMMANDE values(6,'MOTOBECANE','2006-06-03','2006-06-08');

insert into LIGNE_COMMANDE values(1,1,'TL683',1,54.20);
insert into LIGNE_COMMANDE values(1,2,'LP412',5,23.43);
insert into LIGNE_COMMANDE values(1,3,'AR232',3,64.34);
insert into LIGNE_COMMANDE values(1,4,'HD934',2,13.65);
insert into LIGNE_COMMANDE values(1,5,'AR232',1,77.54);
insert into LIGNE_COMMANDE values(2,1,'TL683',6,53.20);
insert into LIGNE_COMMANDE values(2,2,'LP412',5,24.43);
insert into LIGNE_COMMANDE values(2,3,'AR232',3,61.34);
insert into LIGNE_COMMANDE values(2,4,'HD934',1,15.65);
insert into LIGNE_COMMANDE values(2,5,'AR232',1,74.54);
insert into LIGNE_COMMANDE values(3,1,'TL683',2,56.20);
insert into LIGNE_COMMANDE values(3,2,'LP412',1,22.43);
insert into LIGNE_COMMANDE values(3,3,'AR232',3,66.34);
insert into LIGNE_COMMANDE values(3,4,'HD934',1,17.65);
insert into LIGNE_COMMANDE values(3,5,'AR232',1,72.54);
insert into LIGNE_COMMANDE values(4,1,'TL683',1,57.20);
insert into LIGNE_COMMANDE values(4,2,'LP412',5,21.43);
insert into LIGNE_COMMANDE values(4,3,'AR232',3,67.34);
insert into LIGNE_COMMANDE values(4,4,'HD934',1,16.65);
insert into LIGNE_COMMANDE values(4,5,'AR232',2,74.54);
insert into LIGNE_COMMANDE values(5,1,'TL683',1,57.20);
insert into LIGNE_COMMANDE values(5,2,'LP412',5,27.43);
insert into LIGNE_COMMANDE values(5,3,'AR232',3,68.34);
insert into LIGNE_COMMANDE values(5,4,'HD934',1,15.65);
insert into LIGNE_COMMANDE values(5,5,'AR232',1,74.54);
insert into LIGNE_COMMANDE values(4,6,'LP412',1,21.43);


insert into PIECE values(111,1,1,'TL683');
insert into PIECE values(211,2,1,'TL683');
insert into PIECE values(212,2,1,'TL683');
insert into PIECE values(213,2,1,'TL683');
insert into PIECE values(214,2,1,'TL683');
insert into PIECE values(215,2,1,'TL683');
insert into PIECE values(216,2,1,'TL683');
insert into PIECE values(311,3,1,'TL683');
insert into PIECE values(312,3,1,'TL683');
insert into PIECE values(411,4,1,'TL683');
insert into PIECE values(511,5,1,'TL683');
insert into PIECE values(121,1,2,'LP412');
insert into PIECE values(122,1,2,'LP412');
insert into PIECE values(123,1,2,'LP412');
insert into PIECE values(124,1,2,'LP412');
insert into PIECE values(125,1,2,'LP412');
insert into PIECE values(221,2,2,'LP412');
insert into PIECE values(222,2,2,'LP412');
insert into PIECE values(223,2,2,'LP412');
insert into PIECE values(224,2,2,'LP412');
insert into PIECE values(225,2,2,'LP412');
insert into PIECE values(321,3,2,'LP412');
insert into PIECE values(422,4,2,'LP412');
insert into PIECE values(423,4,2,'LP412');
insert into PIECE values(424,4,2,'LP412');
insert into PIECE values(425,4,2,'LP412');
insert into PIECE values(521,5,2,'LP412');
insert into PIECE values(522,5,2,'LP412');
insert into PIECE values(523,5,2,'LP412');
insert into PIECE values(524,5,2,'LP412');
insert into PIECE values(525,5,2,'LP412');
insert into PIECE values(131,1,3,'AR232');
insert into PIECE values(132,1,3,'AR232');
insert into PIECE values(133,1,3,'AR232');
insert into PIECE values(134,1,3,'AR232');
insert into PIECE values(135,1,3,'AR232');
insert into PIECE values(231,2,3,'AR232');
insert into PIECE values(232,2,3,'AR232');
insert into PIECE values(233,2,3,'AR232');
insert into PIECE values(234,2,3,'AR232');
insert into PIECE values(235,2,3,'AR232');
insert into PIECE values(331,3,3,'AR232');
insert into PIECE values(332,3,3,'AR232');
insert into PIECE values(333,3,3,'AR232');
insert into PIECE values(334,3,3,'AR232');
insert into PIECE values(335,3,3,'AR232');
insert into PIECE values(431,4,3,'AR232');
insert into PIECE values(432,4,3,'AR232');
insert into PIECE values(433,4,3,'AR232');
insert into PIECE values(434,4,3,'AR232');
insert into PIECE values(435,4,3,'AR232');
insert into PIECE values(531,5,3,'AR232');
insert into PIECE values(532,5,3,'AR232');
insert into PIECE values(533,5,3,'AR232');
insert into PIECE values(534,5,3,'AR232');
insert into PIECE values(535,5,3,'AR232');
insert into PIECE values(141,1,4,'HD934');
insert into PIECE values(142,1,4,'HD934');
insert into PIECE values(241,2,4,'HD934');
insert into PIECE values(341,3,4,'HD934');
insert into PIECE values(441,4,4,'HD934');
insert into PIECE values(541,5,4,'HD934');
insert into PIECE values(151,1,5,'AR232');
insert into PIECE values(251,2,5,'AR232');
insert into PIECE values(351,3,5,'AR232');
insert into PIECE values(451,4,5,'AR232');
insert into PIECE values(551,5,5,'AR232');
insert into PIECE values(461,4,6,'LP412');

insert into COMMERCIALISER values('BERTOULD','AR232');
insert into COMMERCIALISER values('BERTOULD','HD934');
insert into COMMERCIALISER values('BERTOULD','LP412');
insert into COMMERCIALISER values('BERTOULD','TL683');
insert into COMMERCIALISER values('PEUGEOT','AR232');
insert into COMMERCIALISER values('PEUGEOT','HD934');
insert into COMMERCIALISER values('PEUGEOT','LP412');
insert into COMMERCIALISER values('PEUGEOT','TL683');
insert into COMMERCIALISER values('MBK','AR232');
insert into COMMERCIALISER values('MBK','HD934');
insert into COMMERCIALISER values('MBK','LP412');
insert into COMMERCIALISER values('MBK','TL683');
insert into COMMERCIALISER values('MOTOBECANE','AR232');
insert into COMMERCIALISER values('MOTOBECANE','HD934');
insert into COMMERCIALISER values('MOTOBECANE','LP412');
insert into COMMERCIALISER values('MOTOBECANE','TL683');


