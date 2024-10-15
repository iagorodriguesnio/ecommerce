package br.com.truedev.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.truedev.ecommerce.model.Cliente;
import br.com.truedev.ecommerce.service.cliente.IClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getAll() {
        return ResponseEntity.ok(clienteService.recuperarTodosClientes());
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Integer id) {
        Cliente result = clienteService.recuperarClientePeloId(id);

        if (result != null) {

            return ResponseEntity.ok(result);

        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/clientes/busca")
    public ResponseEntity<Cliente> seachByTel(@RequestParam(name = "telefone") String telefone) {

        Cliente result = clienteService.recuperarClientePeloTelefone(telefone);

        if (result != null) {

            return ResponseEntity.ok(result);

        }

        return ResponseEntity.notFound().build();

    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> insertNew(@RequestBody Cliente cliente) {

        try {
            Cliente result = clienteService.cadastrarCliente(cliente);
            if (result != null) {

                return ResponseEntity.status(201).body(result);

            }

        } catch (Exception ex) {
            System.out.println("Log: Erro ao cadastrar cliente. " + ex.getMessage());
        }
        return ResponseEntity.badRequest().build();

    }

    @PutMapping("clientes/{id}")
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente, @PathVariable Integer id) {

        cliente.setId(id);

        try {
            Cliente result = clienteService.alterarCliente(cliente);
            if (result != null) {
                return ResponseEntity.ok(result);
            }
        } catch (Exception e) {
            System.out.println("Log: Erro no alteração do cliente. " + e.getMessage());
        }

        return ResponseEntity.badRequest().build();
    }

}
