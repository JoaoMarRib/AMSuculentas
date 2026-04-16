CREATE DATABASE IF NOT EXISTS amsuculentas;
USE amsuculentas;
-- Nova tabela de  admistrador
CREATE TABLE admin (
id INT NOT NULL AUTO_INCREMENT,
nome VARCHAR(50) NOT NULL,
email VARCHAR(100) NOT NULL UNIQUE,
senha VARCHAR(255) NOT NULL,
PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Criação da tabela de Clientes
CREATE TABLE cliente (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    ativo BOOLEAN DEFAULT TRUE,
    PRIMARY KEY (id),
    UNIQUE KEY (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Nova tabela de Telefones
CREATE TABLE telefone (
    id INT NOT NULL AUTO_INCREMENT,
    numero VARCHAR(20) NOT NULL,
    tipo ENUM('Celular', 'Residencial', 'Comercial', 'WhatsApp') DEFAULT 'Celular',
    cliente_id INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_telefone_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id) 
        ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabela de Categorias
CREATE TABLE categoria (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL UNIQUE,
    descricao TEXT,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabela de Produtos
CREATE TABLE produto (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10,2) NOT NULL,
    estoque INT DEFAULT 0 CHECK (estoque >= 0),
    promocao DECIMAL(5,2) COMMENT 'Percentual de desconto' DEFAULT 0,
    ativo BOOLEAN DEFAULT TRUE,
    imagem VARCHAR(255),
    categoria_id INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_categoria_produto FOREIGN KEY (categoria_id) REFERENCES categoria(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabela de Pedidos
CREATE TABLE pedido (
    id INT NOT NULL AUTO_INCREMENT,
    cliente_id INT,
    data_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    valor_total DECIMAL(10,2) NOT NULL,
    respondido BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (id),
    FOREIGN KEY (cliente_id) REFERENCES cliente(id) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabela  de Itens Pedidos
CREATE TABLE itens_pedido (
    id INT NOT NULL AUTO_INCREMENT,
    pedido_id INT NOT NULL,
    produto_id INT NOT NULL,
    quantidade INT NOT NULL,
    preco_unitario DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (pedido_id) REFERENCES pedido(id) ON DELETE CASCADE, 
    FOREIGN KEY (produto_id) REFERENCES produto(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabela de Avalição
CREATE TABLE avaliacao (
     id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50),
    nota INT NOT NULL CHECK (nota BETWEEN 1 AND 5),
    comentario TEXT,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    aprovado BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (id),
	cliente_id INT UNIQUE,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Inserção de dados de exemplo nas Categorias
INSERT INTO categoria (nome, descricao) VALUES
('Suculentas', 'Plantas da especie suculentas');

-- Inserção de dados de exemplo nos Produtos
INSERT INTO produto (nome, descricao, preco, estoque, promocao, ativo, imagem, categoria_id) VALUES
('Suculenta 1', 'Suculenta da especie Z', 25.00, 5, 0, 1, '/assets/produtosImg/produto-1.jpg',1),
('Suculenta 2', 'Suculenta da especie Y', 20.00, 10, 20, 1, '/assets/produtosImg/produto-2.jpg',1),
('Suculenta 3', 'Suculenta da especie X', 15.00, 15, 15, 1, '/assets/produtosImg/produto-3.jpg',1),
('Suculenta 4', 'Suculenta da especie W', 10.00, 20, 10, 1, '/assets/produtosImg/produto-4.png',1),
('Suculenta 5', 'Suculenta da especie V', 5.00, 25, 5, 1, '/assets/produtosImg/produto-5.png',1);
