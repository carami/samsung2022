drop table todos if exists;


create TABLE todos (
    id INTEGER auto_increment PRIMARY KEY,
    todo VARCHAR(255),
    done boolean
);

 

insert into todos (id, todo, done) values(11, 'hello', true);
insert into todos (id, todo, done) values(21, 'hi', true);
insert into todos (id, todo, done) values(31, 'smile', true);