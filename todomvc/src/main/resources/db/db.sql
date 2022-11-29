create TABLE todos (
id INTEGER auto_increment PRIMARY KEY,
todo VARCHAR(255),
done boolean
);


INSERT INTO todos(todo,done) VALUES ( '봄봄이랑 놀아주기', false);
INSERT INTO todos (todo,done)VALUES ( 'Spring Cloud 공부하기', false);
INSERT INTO todos (todo,done)VALUES ('블로그 글쓰기', false);