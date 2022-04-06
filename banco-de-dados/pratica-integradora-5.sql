use movies_db;
select * from movies limit 100;

-- Adicione um filme à tabela de filmes.
insert into movies values(22, now(), now(), 'Sem limites', 4.5, 1, '2018-10-09', 120, null);

-- 2. Adicione um gênero à tabela de gêneros.
select * from genres;
insert into genres values(13, now(), null, 'Action', 13, 1);

-- 3. Associe o filme do ponto 1. com o gênero criado no ponto 2.
update movies set genre_id = (select id from genres where name = 'Action' limit 1)
where id = 22;

-- 4. Modifique a tabela de atores para que pelo menos um ator tenha o filme adicionado
-- no ponto 1 como favorito.
select * from actors;
update actors set favorite_movie_id = (select id from movies where title = 'Sem limites' limit 1)
where id = 49;

-- 5. Crie uma tabela temporária da tabela filmes.
create temporary table if not exists movies_temp as (select * from movies);
select * from movies_temp;

-- 6. Elimine dessa tabela temporária todos os filmes que ganharam menos de 5 prêmios.
delete from movies_temp where awards < 5;

-- 7. Obtenha a lista de todos os gêneros que possuem pelo menos um filme.
select name, count(g.id) from genres g
inner join movies m on m.genre_id = g.id
group by name
having (count(g.id)) >= 1;

-- 8. Obtenha a lista de atores cujo filme favorito ganhou mais de 3 prêmios.

select a.first_name, a.last_name from actors a
inner join movies m on m.id = a.favorite_movie_id
where awards > 3;

-- 9. Crie um índice no nome na tabela de filmes.
create index idx_movies_title on movies(title);
-- drop index idx_movies_name on movies;

-- 10. Verifique se o índice foi criado corretamente.
show index from movies from movies_db;

-- 11. No banco de dados movies, haveria uma melhoria notável na criação de índices?
-- Analise e justifique a resposta.


-- 12. Em que outra tabela você criaria um índice e por quê? Justifique a resposta