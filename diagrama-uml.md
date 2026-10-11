classDiagram
    class Cliente {
        -Long id
        -String nome
        -LocalDate clienteDesde
    }

    class Produto {
        -Long id
        -String nome
        -BigDecimal preco
        -Boolean estoque
    }

    class Pedido {
        -Long id
        -Long clienteId
        -Long produtoId
        -Integer quantidade
    }

    class ClienteRepository {
        <<interface>>
        +findAll()
        +findById(id)
        +save(cliente)
        +deleteById(id)
    }

    class ProdutoRepository {
        <<interface>>
        +findAll()
        +findById(id)
        +save(produto)
        +deleteById(id)
    }

    class PedidoRepository {
        <<interface>>
        +findAll()
        +findById(id)
        +save(pedido)
        +deleteById(id)
    }

    class ClienteController {
        +criar()
        +listar()
        +buscar(id)
        +atualizar(id)
        +excluir(id)
    }

    class ProdutoController {
        +criar()
        +listar()
        +buscar(id)
        +atualizar(id)
        +excluir(id)
    }

    class PedidoController {
        +criar()
        +listar()
        +buscar(id)
        +excluir(id)
    }

    ClienteController --> ClienteRepository
    ProdutoController --> ProdutoRepository
    PedidoController --> PedidoRepository

    ClienteRepository ..> Cliente
    ProdutoRepository ..> Produto
    PedidoRepository ..> Pedido