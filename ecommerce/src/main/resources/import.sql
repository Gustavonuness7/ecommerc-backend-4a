CATEGORIAS
INSERT INTO categoria (nome) VALUES ('Eletrônicos');
INSERT INTO categoria (nome) VALUES ('Informática');
INSERT INTO categoria (nome) VALUES ('Livros');
INSERT INTO categoria (nome) VALUES ('Móveis');
INSERT INTO categoria (nome) VALUES ('Vestuário');

PRODUTOS
INSERT INTO produto (nome, preco, categoria_id) VALUES ('Smartphone', 2500.00, 1);
INSERT INTO produto (nome, preco, categoria_id) VALUES ('Notebook', 4500.00, 2);
INSERT INTO produto (nome, preco, categoria_id) VALUES ('Livro de Java', 120.00, 3);
INSERT INTO produto (nome, preco, categoria_id) VALUES ('Cadeira Gamer', 1100.00, 4);
INSERT INTO produto (nome, preco, categoria_id) VALUES ('Camiseta Tech', 80.00, 5);

CLIENTES
INSERT INTO cliente (nome, email, telefone) VALUES ('Ana Silva', 'ana.silva@email.com', '14999990001');
INSERT INTO cliente (nome, email, telefone) VALUES ('Bruno Santos', 'bruno.santos@email.com', '14999990002');
INSERT INTO cliente (nome, email, telefone) VALUES ('Carla Oliveira', 'carla.oliveira@email.com', '14999990003');
INSERT INTO cliente (nome, email, telefone) VALUES ('Diego Souza', 'diego.souza@email.com', '14999990004');
INSERT INTO cliente (nome, email, telefone) VALUES ('Eduarda Lima', 'eduarda.lima@email.com', '14999990005');

PEDIDOS
INSERT INTO pedido (data, status, valor_total, cliente_id) VALUES ('2026-09-20 10:00:00', 'PENDENTE', 2500.00, 1);
INSERT INTO pedido (data, status, valor_total, cliente_id) VALUES ('2026-09-21 11:30:00', 'PAGO', 4500.00, 2);
INSERT INTO pedido (data, status, valor_total, cliente_id) VALUES ('2026-09-22 14:15:00', 'PAGO', 240.00, 3);
INSERT INTO pedido (data, status, valor_total, cliente_id) VALUES ('2026-09-23 16:45:00', 'CANCELADO', 1100.00, 4);
INSERT INTO pedido (data, status, valor_total, cliente_id) VALUES ('2026-09-24 09:20:00', 'PAGO', 160.00, 5);

ITEM PEDIDO
INSERT INTO item_pedido (quantidade, valor_unitario, pedido_id, produto_id) VALUES (1, 2500.00, 1, 1);
INSERT INTO item_pedido (quantidade, valor_unitario, pedido_id, produto_id) VALUES (1, 4500.00, 2, 2);
INSERT INTO item_pedido (quantidade, valor_unitario, pedido_id, produto_id) VALUES (2, 120.00, 3, 3);
INSERT INTO item_pedido (quantidade, valor_unitario, pedido_id, produto_id) VALUES (1, 1100.00, 4, 4);
INSERT INTO item_pedido (quantidade, valor_unitario, pedido_id, produto_id) VALUES (2, 80.00, 5, 5);

PAGAMENTO
INSERT INTO pagamento (valor, data, status, tipo, pedido_id) VALUES (2500.00, '2026-09-20 10:05:00', 'AGUARDANDO', 'PIX', 1);
INSERT INTO pagamento (valor, data, status, tipo, pedido_id) VALUES (4500.00, '2026-09-21 11:35:00', 'APROVADO', 'CARTAO_CREDITO', 2);
INSERT INTO pagamento (valor, data, status, tipo, pedido_id) VALUES (240.00, '2026-09-22 14:20:00', 'APROVADO', 'PIX', 3);
INSERT INTO pagamento (valor, data, status, tipo, pedido_id) VALUES (1100.00, '2026-09-23 16:50:00', 'RECUSADO', 'BOLETO', 4);
INSERT INTO pagamento (valor, data, status, tipo, pedido_id) VALUES (160.00, '2026-09-24 09:25:00', 'APROVADO', 'PIX', 5);