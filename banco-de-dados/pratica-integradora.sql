-- 1. Mostrar o título e o nome do gênero de todas as séries.
SELECT m.title, g.name FROM movies m INNER JOIN genres AS g ON g.id = m.genre_id;

-- 2. Mostrar o título dos episódios, o nome e sobrenome dos atores que trabalham em
-- cada um deles.
SELECT e.title, a.first_name, a.last_name FROM episodes e 
INNER JOIN actor_episode AS ae ON ae.episode_id = e.id
INNER JOIN actors AS a ON a.id = ae.actor_id;

-- 3. Mostrar o título de todas as séries e o número total de temporadas que cada uma
-- delas possui.
SELECT s.title, COUNT(s.id) FROM series AS s
INNER JOIN seasons se ON se.serie_id = s.id
GROUP BY title;

-- 4. Mostrar o nome de todos os gêneros e o número total de filmes de cada um, desde
-- que seja maior ou igual a 3.
SELECT g.name, COUNT(m.id) FROM genres AS g
INNER JOIN movies AS m ON m.genre_id = g.id
GROUP BY genre_id;


-- 5. Mostrar apenas o nome e sobrenome dos atores que atuam em todos os filmes de
-- Star Wars e que estes não se repitam.
SELECT a.first_name, a.last_name FROM actors AS a
INNER JOIN actor_movie AS ac ON ac.actor_id = a.id
INNER JOIN movies AS m ON m.id = ac.movie_id
WHERE m.title LIKE 'La Guerra de las galaxias%'

