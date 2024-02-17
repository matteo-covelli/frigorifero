
-- CREAZIONE TABELLA USERS
create table users (
                       user_id varchar(50) not null primary key,
                       pw char(68) not null,
                       active int not null);



INSERT INTO users
VALUES
    ('john','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1),
    ('mary','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1),
    ('susan','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1);




-- CREAZIONE TABLELLA ROLES


create table roles (
                       user_id varchar(50) references users(user_id),
                       ruolo varchar(50) not null);

INSERT INTO roles
VALUES
    ('john','ROLE_EMPLOYEE'),
    ('mary','ROLE_EMPLOYEE'),
    ('mary','ROLE_MANAGER'),
    ('susan','ROLE_EMPLOYEE'),
    ('susan','ROLE_MANAGER'),
    ('susan','ROLE_ADMIN');


-- CREAZIONE TABELLA POSTIT


create sequence seq_postit
    increment by 1
    start with 1
    minvalue 1
    no maxvalue;

create table postit (
                        id bigint primary key default nextval ('seq_postit'),
                        body varchar,
                        title varchar,
                        "timestamp" timestamp with time zone default current_timestamp,
                        user_id varchar(50) references users(user_id));

insert into postit (body, title, user_id)
values
    ('Dare da mangiare al cane', 'Cibo al cane', 'john'),
    ('Dare da bere alle piante', 'Acqua piante', 'mary'),
    ('Prendere Marco a scuola', 'Marco scuola', 'mary');

