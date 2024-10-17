package br.com.truedev.ecommerce.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.truedev.ecommerce.model.Categoria;
import br.com.truedev.ecommerce.service.categoria.ICategoriaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class CategoriaController {

    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> getAll() {

        return ResponseEntity.ok(categoriaService.recuperarTodasCategorias());

    }

    @GetMapping("/categorias/{id}")
    public ResponseEntity<Categoria> getById(@PathVariable Integer id) {

        Categoria result = categoriaService.buscarCategoriaPeloId(id);

        if (result != null) {
            return ResponseEntity.ok(result);
        }

        return ResponseEntity.notFound().build();

    }

    @GetMapping("/categorias/busca")
    public ResponseEntity<Categoria> seachByNome(@RequestParam(name = "nome") String nome) {

        Categoria result = categoriaService.buscarCategoriaPeloNome(nome);

        if (result != null) {

            return ResponseEntity.ok(result);

        }

        return ResponseEntity.notFound().build();

    }

    @PostMapping("/categorias")
    public ResponseEntity<Categoria> insertNew(@RequestBody Categoria categoria) {

        try {

            Categoria result = categoriaService.cadastrarCategoria(categoria);
            if (result != null) {
                return ResponseEntity.status(201).body(result);
            }

        } catch (Exception ex) {
            System.out.println("Log: Erro ao cadastrar categoria. " + ex.getMessage());
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("categorias/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Integer id, @RequestBody Categoria categoria) {

        categoria.setId(id);

        try {

            Categoria result = categoriaService.alterarCategoria(categoria);
            if (result != null) {

                return ResponseEntity.ok(result);

            }

        } catch (Exception ex) {
            System.out.println("Log: Erro ao alterar categoria. " + ex.getMessage());
        }

        return ResponseEntity.badRequest().build();

    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<Categoria> delete(@PathVariable Integer id) {

        Categoria result = categoriaService.buscarCategoriaPeloId(id);

        if (result != null) {
            categoriaService.deletarCategoria(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();

    }

}
