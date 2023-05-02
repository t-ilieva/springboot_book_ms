# project_test

create table deactivation_reason(
	id int primary key,
	name varchar(25) not null
)

create table author(
	id int primary key,
	first_name varchar(25) not null,
	last_name varchar(25) not null
)

create table genre(
	id int primary key,
	name varchar(25)
)

create table book(
	id int primary key,
	amount int not null,
	title varchar(25) not null,
	isbn varchar(15) not null,
	year smallint not null,
	publisher varchar(25) not null,
	status bit not null,
	date_added date not null,
	deactivation_date date,
	deactivation_description varchar(100),
	language varchar(25) not null,
	deactivation_reason_id int,
	foreign key (deactivation_reason_id) references deactivation_reason(id)
)

create table book_genre(
	book_id int not null,
	foreign key (book_id) references book(id) on delete cascade,
	genre_id int not null,
	foreign key (genre_id) references genre(id) on delete cascade,
	primary key(book_id, genre_id)
)

create table book_author(
	book_id int not null,
	foreign key (book_id) references book(id) on delete cascade,
	author_id int not null,
	foreign key(author_id) references author(id) on delete cascade,
	primary key(book_id, author_id)
)

select * from book_author
