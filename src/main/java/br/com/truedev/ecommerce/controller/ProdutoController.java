package br.com.truedev.ecommerce.controller;

import java.util.List;

import org.apache.tomcat.jni.Library;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.truedev.ecommerce.model.Categoria;
import br.com.truedev.ecommerce.model.Produto;
import br.com.truedev.ecommerce.service.produto.IProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    final IProdutoService produtoService;

    public ProdutoController(IProdutoService produtoService) {

        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {

        return ResponseEntity.ok(produtoService.listaProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable Integer id) {

        Produto result = produtoService.buscarProduto(id);
        if (result != null) {

            return ResponseEntity.ok(result);

        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Produto>> searchByKey(@RequestParam(name = "key") String palavra) {

        List<Produto> produtos = produtoService.buscarProdutoPorPalavraChave(palavra);

        if (produtos.size() > 0) {

            return ResponseEntity.ok(produtos);
        }

        return ResponseEntity.notFound().build();

    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<Produto>> seachByCategoria(@PathVariable Integer id) {

        Categoria categoria = new Categoria();
        categoria.setId(id);

        return ResponseEntity.ok(produtoService.buscarPorCategoria(categoria));

    }

    @PostMapping
    public ResponseEntity<Produto> newInsert(@RequestBody Produto produto) {

        try {
            Produto result = produtoService.cadastraProduto(produto);
            if (result != null) {
                return ResponseEntity.status(201).body(produto);
            }
        } catch (Exception ex) {
            System.out.println("LOG: Erro ao cadastrar produto. " + ex.getMessage());
        }

        return ResponseEntity.badRequest().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@RequestBody Produto produto, @PathVariable Integer id) {

        produto.setId(id);
        Produto result = produtoService.buscarProduto(id);

        if (result != null) {

            produtoService.alterarProduto(produto);
            return ResponseEntity.ok(produto);
        }

        return ResponseEntity.badRequest().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> delete(@PathVariable Integer id) {

        Produto result = produtoService.buscarProduto(id);

        if (result != null) {
            produtoService.deletarProduto(id);

            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();

    }

}
