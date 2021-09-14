create table album (id bigint generated by default as identity, album_title varchar(255) not null, locales varchar(255) not null, primary key (id))
create table song (id bigint generated by default as identity, length integer not null, title varchar(255) not null, track integer not null, album_id bigint, primary key (id))
