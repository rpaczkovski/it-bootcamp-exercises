CREATE DATABASE pratica_empresa;

USE pratica_empresa;  

CREATE TABLE departamentos (
	depto_nro VARCHAR(100) NOT NULL UNIQUE,
    nome_depto VARCHAR(45) NOT NULL,
    localizacao VARCHAR(45) NOT NULL
);

CREATE TABLE funcionarios (
	cod_func VARCHAR(100) NOT NULL UNIQUE,
    nome VARCHAR(45) NOT NULL,
    sobrenome VARCHAR(45) NOT NULL,
    cargo VARCHAR(45) NOT NULL,
    data_alta DATE NOT NULL,
    salario INTEGER NOT NULL,
    comissao INTEGER DEFAULT 0,
    depto_nro VARCHAR(45) NOT NULL
);

INSERT INTO departamentos VALUES
    ('d-000-1', 'Software', 'Los Tigres'),
    ('d-000-2', 'Sistemas', 'Guadalupe'),
    ('d-000-3', 'Contabilidade', 'La Roca'),
    ('d-000-4', 'Vendas', 'Plata');
INSERT INTO funcionarios VALUES
    ('e-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'd-000-4'),
    ('e-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'd-000-2'),
    ('e-0003', 'Mariela', 'Barrios', 'Diretor', '2014-06-05', 185000, 0, 'd-000-3'),
    ('e-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'd-000-4'),
    ('e-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'd-000-4'),
    ('e-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'd-000-3'),
    ('e-0007', 'Emilio', 'Galarza', 'Desenvolvedor', '2014-08-02', 60000, 0, 'd-000-1');

---- 

-- Selecione o nome, cargo e localização dos departamentos onde os vendedores
-- trabalham.
SELECT nome, cargo, d.localizacao FROM funcionarios f
INNER JOIN departamentos d ON d.depto_nro = f.depto_nro;

-- 2. Visualize departamentos com mais de cinco funcionários.
SELECT d.nome_depto FROM funcionarios f
INNER JOIN departamentos d ON d.depto_nro = f.depto_nro
GROUP BY f.depto_nro 
HAVING COUNT(f.depto_nro) >= 3;

-- 3. Exiba o nome, salário e nome do departamento dos funcionários que têm o mesmo
-- cargo que 'Mito Barchuk'.
SELECT f.nome,f.sobrenome, f.salario, d.nome_depto FROM funcionarios f
INNER JOIN departamentos d ON d.depto_nro = f.depto_nro 
WHERE f.cargo in (SELECT cargo FROM funcionarios WHERE nome = 'Jonathan');

-- 4. Mostre os dados dos funcionários que trabalham no departamento de contabilidade,
-- ordenados por nome.
SELECT f.nome FROM funcionarios f
INNER JOIN departamentos d ON d.depto_nro = f.depto_nro
WHERE d.nome_depto = 'Contabilidade'
ORDER BY f.nome ASC;

-- 5. Mostre o nome do funcionário que tem o menor salário.
SELECT f.nome, f.salario FROM funcionarios f
ORDER BY salario ASC
LIMIT 1;

-- 6. Mostre os dados do funcionário que tem o maior salário no departamento 'Vendas'.
SELECT f.nome, f.salario FROM funcionarios f
INNER JOIN departamentos d ON d.depto_nro = f.depto_nro
WHERE d.nome_depto = 'Vendas'
ORDER BY salario DESC
LIMIT 1;

    
    