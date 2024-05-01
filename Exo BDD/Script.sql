drop table if exists films;



create table if not exists films 
(
	ID
		serial,
	titre 
		varchar 
		not null 
		default 'titre à mettre plus tard',
	categorie 
		varchar 
		default 'type de film à préciser', 
	auteur 
		varchar 
		default 'a renseigner si possible',
	date_de_sortie
		date,
	duree
		varchar,
	acteurs
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
comment on column films.categorie is 'est quoi comme film ? SF ? Polar ? Romance ...';
comment on column films.date_de_sortie is 'il a été réalisé quand ?';
comment on column films.duree is 'il dure combien de temps heures/minutes ?';
comment on column films.acteurs is 'les acteurs principaux du films';
comment on column films.nb_entrees is 'combien de fois il a été vu au cinéma';
comment on column films.limite_age is 'le film cible quelle limite d''age ?';
comment on column films.actuellement_en_salle is 'si on peut encore le voir au ciné ou non';
comment on column films.commentaires_personnels is 'si on aime ou non, pourquoi ...';
	

insert into films
(
	titre,
	categorie,
	auteur
)
values
( 'Avatar', 'SF', 'James Cameron' ),
( 'Star Wars', 'SF', 'George Lucas' );



update films
set 
	titre = 'Star Wars IV - La guerre des étoiles'
where
	ID = 2;


select 
	*
from
	films;


delete 
from 
	films
where 
	ID = 1;



alter table films add column tags varchar;
comment on column films.tags is 'les tags twitter (X)';


create table categorie
(
	ID
		serial,
	type
		varchar,
);





