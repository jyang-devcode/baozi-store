package com.baozistore.controller;

import com.baozistore.model.Pedido;
import com.baozistore.model.Produto;
import com.baozistore.repository.PedidoRepository;
import com.baozistore.repository.ClienteRepository;
import com.baozistore.repository.ProdutoRepository;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    public PedidoController(
            PedidoRepository pedidoRepository,
            ClienteRepository clienteRepository,
            ProdutoRepository produtoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public ResponseEntity<?> criar(
            @Valid @RequestBody Pedido pedido) {

        if (!clienteRepository.existsById(pedido.getClienteId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente não encontrado.");
        }

        if (!produtoRepository.existsById(pedido.getProdutoId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Produto não encontrado.");
        }

        Produto produto = produtoRepository
                .findById(pedido.getProdutoId())
                .orElseThrow();

        if (!Boolean.TRUE.equals(produto.getEstoque())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Produto sem estoque disponível.");
        }

        Pedido salvo = pedidoRepository.save(pedido);

        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscar(@PathVariable Long id) {
        return pedidoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (!pedidoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        pedidoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}