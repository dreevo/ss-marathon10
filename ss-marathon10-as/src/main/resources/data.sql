drop table authorities;
drop table users;

create table users
(
    username varchar(45) null,
    password varchar(200) null,
    id       int,
    enabled  boolean null
);

create unique index users_id_uindex
    on users (id);

alter table users
    add constraint users_pk
        primary key (id);

alter table users modify id int auto_increment;

create table authorities
(
    username  varchar(45) null,
    authority varchar(45) null,
    id        int
);

create unique index authorities_id_uindex
    on authorities (id);

alter table authorities
    add constraint authorities_pk
        primary key (id);

alter table authorities modify id int auto_increment;

drop table oauth_client_details;
create table oauth_client_details
(
    client_id               varchar(256) primary key,
    resource_ids            varchar(256),
    client_secret           varchar(256),
    scope                   varchar(256),
    authorized_grant_types  varchar(256),
    web_server_redirect_uri varchar(256),
    authorities             varchar(256),
    access_token_validity   integer,
    refresh_token_validity  integer,
    additional_information  varchar(4096),
    autoapprove             varchar(256)
);

drop table oauth_access_token;
create table oauth_access_token
(
    token_id          VARCHAR(256),
    token             BLOB,
    authentication_id VARCHAR(256) PRIMARY KEY,
    user_name         VARCHAR(256),
    client_id         VARCHAR(256),
    authentication    BLOB,
    refresh_token     VARCHAR(256)
);

drop table oauth_refresh_token;
create table oauth_refresh_token
(
    token_id       VARCHAR(256),
    token          BLOB,
    authentication BLOB
);


