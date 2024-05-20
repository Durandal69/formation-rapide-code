drop table if exists films cascade;



create table if not exists films 
(
	ID
		serial,
	titre 
		varchar 
		not null 
		default 'titre à mettre plus tard',
	categorie_id 
		integer, 
	auteur 
		integer,
	date_de_sortie
		date,
	duree
		varchar,
	nb_entrees
		integer,
	limite_age
		integer,
	actuellement_en_salle
		boolean,
	commentaires_personnels
		varchar,
	constraint
		PK_ID
		primary key (ID)
);	

comment on column films.ID is 'identifiant unique du film.';
comment on column films.categorie_id is 'est quoi comme film ? SF ? Polar ? Romance ...';
comment on column films.date_de_sortie is 'il a été réalisé quand ?';
comment on column films.duree is 'il dure combien de temps heures/minutes ?';
comment on column films.nb_entrees is 'combien de fois il a été vu au cinéma';
comment on column films.limite_age is 'le film cible quelle limite d''age ?';
comment on column films.actuellement_en_salle is 'si on peut encore le voir au ciné ou non';
comment on column films.commentaires_personnels is 'si on aime ou non, pourquoi ...';
	



alter table films add column tags varchar;
comment on column films.tags is 'les tags twitter (X)';


DROP TABLE IF EXISTS categorie;

create table IF NOT EXISTS categorie
(
	ID
		serial primary key,
	type
		varchar
);



alter table films add constraint FK_ID_Categorie foreign key (categorie_id) references categorie (ID);



drop table if exists auteurs;

create table if not exists auteurs
(
	ID	
		serial primary key,
	nom
		varchar,
	date_de_naissance
		date,
	date_de_deces
		date
);




alter table films add constraint FK_ID_Author foreign key (auteur) references auteurs (ID);


drop table if exists acteurs cascade;

create table if not exists acteurs
(
	ID
		serial primary key,
	nom
		varchar,
	date_de_naissance
		date,
	date_de_deces
		date,
	nb_oscar
		integer
);



drop table if exists films_acteurs;

create table if not exists films_acteurs
( 
	ID_film
		integer,
	ID_acteur
		integer,
	role_principal	
		boolean,
	constraint
		PK_ID_Film_Acteur primary key (ID_film, ID_acteur),
	constraint
		FK_ID_Film foreign key (ID_film) references films (ID),
	constraint
		FK_ID_Acteur foreign key (ID_acteur) references acteurs (ID)
);




drop table if exists limites_age;

create table if not exists limites_age
(
	ID
		serial primary key,
	code
		varchar (8),
	couleur
		varchar (6)
);




alter table films add constraint FK_ID_Limite_Age foreign key (limite_age) references limites_age (ID);


drop table if exists contenu_sensible cascade;

create table if not exists contenu_sensible
(
	ID
		serial primary key,
	description
		varchar (20)
);


drop table if exists films_contenu_sensible;

create table if not exists films_contenu_sensible
(
	ID_film
		integer,
	ID_contenu_sensible
		integer,
	constraint
		PK_ID_Films_Contenu_Sensible primary key (ID_film, ID_contenu_sensible),
	constraint
		FK_ID_Film foreign key (ID_film) references films (ID),
	constraint
		FK_ID_Contenu_Sensible foreign key (ID_contenu_sensible) references contenu_sensible (ID)
);

drop table if exists salle_de_cine cascade;

create table if not exists salle_de_cine
(
	ID
		serial primary key,
	nom
		varchar,
	nombre_place
		integer not null,
	accessibilite
		integer,
	trois_d
		boolean,
	Dolby_7_1
		boolean,	
	Buffet_bar
		boolean,
	Au_norme_de_securite
		boolean
);

drop table if exists seances cascade;

create table if not exists seances
(
	ID
		serial primary key,
	ID_salle
		integer,
	ID_film
		integer not null,
	constraint
		FK_ID_salle foreign key (ID_salle) references salle_de_cine (ID),
	constraint
		FK_ID_film foreign key (ID_film) references films (ID),
	date_seances
		date
);

drop table if exists cinema;

create table if not exists cinema
(
	ID
		serial primary key,
	nom
		varchar,
	adresse
		varchar
);

alter table salle_de_cine add column cinema integer not null;

alter table salle_de_cine add constraint FK_ID_cinema foreign key (cinema) references cinema (ID);


drop table if exists clients cascade;

create table if not exists clients
(
	ID
		serial primary key,
	nombre_place
		integer not null default 0,
	nombre_place_handicape
		integer not null default 0,
	seance
		integer not null,
	constraint
		FK_ID_seance foreign key (seance) references seances (ID)
);


--/////////////////////////////////////////////////////////////////////////////////////////

--/////////////////////////////////////////////////////////////////////////////////////////



insert into cinema
(
	nom, adresse
)
values
('nanocine', '52 allée de la boustifaille allégée'),
('durancine', '220 impasse de la Tarkovie');

insert into salle_de_cine
(
	nom, nombre_place, accessibilite, cinema
)
values
('Warframe', 1851, 177, 1),
('Binding of Isaac', 307, 275, 1),
('Borderlands', 276, 56, 1),
('Payday', 209, 355, 1);




insert into limites_age
(
	code, couleur
)
values
('PEGI 3', '99ca3b'), ('PEGI 7', '99ca3b'), ('PEGI 12', 'f9a11c'), ('PEGI 16', 'f9a11c'), ('PEGI 18', 'e1011b');



insert into acteurs
(
	nom
)
values
( 'Scarlette J' ), ( 'John C' ), ( 'Jean V.' ), ( 'Rico' );


insert into auteurs 
(
	nom
)
values
( 'George Lucas' ), ( 'James Cameron' );



update films
set 
	titre = 'Star Wars IV - La guerre des étoiles'
where
	ID = 2;


select 
	*
from
	films;

/*
delete 
from 
	films
where 
	ID = 1;
*/


INSERT INTO categorie
(
	type
)
VALUES
( 'SF' ), 
( 'Polar' ), 
( 'Romance' ), 
( 'Historique' ), 
( 'Biographique' ), 
( 'Documentaire' ), 
( 'Action' ), 
( 'Aventure' ), 
( 'Fantaisie' ), 
( 'Drame' );



insert into films
(
	titre,
	categorie_id,
	auteur
)
values
( 'Avatar', 1, 2 ),
( 'Star Wars', 1, 1 );


insert into films_acteurs
values
(1, 1, true),
(1, 2, false),
(1, 3, false),
(2, 4, true),
(2, 1, false);

update films
set
	limite_age = 3 
where
	ID = 2;

insert into contenu_sensible
(
	description
)
values
('nudité'),
('gore'),
('violence'),
('drogue'),
('sexe'),
('alcool'),
('horreur'),
('language grossier'),
('jeu de hasard'),
('discrimination'),
('placement de produit');

insert into films_contenu_sensible
values
(1, 3),
(1, 10),
(1, 1),
(2, 2),
(2, 3),
(2, 4),
(2, 9),
(2, 8),
(2, 10),
(2, 11);

insert into seances
(
	ID_salle, ID_film, date_seances
)
values
(1, 2, '2024-05-21 22:10:00'),
(1, 1, '2024-05-21 18:00:00'),
(2, 1, '2024-05-22 21:00:00'),
(2, 1, '2024-05-22 23:20:00'),
(3, 2, '2024-06-01 15:00:00');


insert into clients
(
	nombre_place_handicape, seance
)
values
(2, 5);