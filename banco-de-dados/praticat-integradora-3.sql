create database pratice_libary;
use pratice_libary;

create table author(
	id integer primary key not null auto_increment,
    name varchar(40) not null,
    nationality varchar(40) not null
);

create table book(
	id integer primary key not null auto_increment,
    title varchar(40) not null,
    publishing_company varchar(40),
    area varchar(40)
);


create table book_author(
	book_id integer not null,
    author_id integer not null,
    constraint fk_book_author_book foreign key(book_id) references book(id),
    constraint fk_book_author_author foreign key(author_id) references author(id) 
);

create table student(
	id integer primary key not null auto_increment,
    first_name varchar(40) not null,
    last_name varchar(40) not null,
    address varchar(40),
    career varchar(40),
    age integer not null
);

create table loan(
	student_id integer not null,
    book_id integer not null,
    date_loan date not null,
    date_devolution date,
    returned boolean,
    constraint fk_loan_student foreign key(student_id) references student(id),
    constraint fk_loan_book foreign key(book_id) references book(id)
);

--- 

INSERT INTO `author` VALUES 
(1,'Autor1', 'Brasileiro'),(2,'Autor2', 'Argentina'),(3,'J.K. Rowling', 'Francesa'),(4,'Autor4', 'Italiana'),(5,'J.K. Rowling', 'Francesa');

INSERT INTO `student` values (1, 'Aluno1','Goncalves', 'Endereco1', 'informatica', 20),(2, 'Aluno2','Garcia', 'Endereco2', 'Carreira 2', 30),
(3, 'Filippo','Galli', 'Endereco3', 'Carreira 3', 40),(4, 'Aluno4','Sobrenome4', 'Endereco4', 'Carreira 4', 50),
(5, 'Aluno5','Sobrenome5', 'Endereco5', 'informatica', 25);

   
INSERT INTO `book` VALUES (1,'O Universo: Guia de Viagem','Editora1', 'internet'), (2,'Livro2','Editora1', 'Banco de Dado'), (3,'Livro3','salamandra', 'Area1'), 
(4,'Livro4','Editora2', 'internet'), (5,'Livro5','Editora3', 'Banco de Dado');

INSERT INTO `book_author` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(1,2);

INSERT INTO `loan` values (1,1, '20220331', null, false ),
(2,2, '20220331', '20220405', true ),(3,3, '20210331', '20210716', false ),(4,4, '20220331', '20220404', true ),(5,5, '20220331', null, false );


----

select * from student;
