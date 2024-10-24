package br.com.truedev.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.truedev.ecommerce.model.Produto;
import br.com.truedev.ecommerce.model.Variante;
import br.com.truedev.ecommerce.service.variante.IVarianteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@RestController
@RequestMapping(path = "/variantes")
public class VarianteController {

    @Autowired
    private IVarianteService varianteService;

    @PostMapping()
    public ResponseEntity<Variante> insertNew(@RequestBody Variante variante) {

        try {
            Variante result = varianteService.criarVariante(variante);

            if (result != null) {
                return ResponseEntity.status(201).body(result);
            }
        } catch (Exception e) {
            System.out.println("LOG: Erro ao cadastrar variante: " + e.getMessage());
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Variante> update(@RequestBody Variante variante, @PathVariable Integer id) {

        variante.setId(id);

        try {

            Variante result = varianteService.alterarVariante(variante);

            if (result != null) {
                return ResponseEntity.ok().body(result);
            }

        } catch (Exception e) {
            System.out.println("LOG: Erro ao alterar variante: " + e.getMessage());
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Variante> getById(@PathVariable Integer id) {

        Variante result = varianteService.buscarPorId(id);
        if (result != null) {

            return ResponseEntity.ok().body(result);
        }

        return ResponseEntity.notFound().build();

    }

    @GetMapping()
    public ResponseEntity<List<Variante>> getByProduto(@RequestParam(name = "produto") Integer idProduto) {

        Produto produto = new Produto();
        produto.setId(idProduto);

        return ResponseEntity.ok().body(varianteService.buscarPorProduto(produto));

    }

}
