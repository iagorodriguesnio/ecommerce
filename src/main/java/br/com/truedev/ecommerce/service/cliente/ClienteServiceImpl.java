package br.com.truedev.ecommerce.service.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.truedev.ecommerce.dao.ClienteDAO;
import br.com.truedev.ecommerce.model.Cliente;

@Component
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ClienteDAO clienteDAO;

    @Override
    public Cliente cadastrarCliente(Cliente cliente) {
        return clienteDAO.save(cliente);
    }

    @Override
    public Cliente alterarCliente(Cliente cliente) {
        return clienteDAO.save(cliente);
    }

    @Override
    public Cliente recuperarClientePeloId(Integer id) {
        return clienteDAO.findById(id).orElse(null);
    }

    @Override
    public Cliente recuperarClientePeloTelefone(String telefone) {
        return clienteDAO.findByTelefone(telefone);
    }

    @Override
    public List<Cliente> recuperarTodosClientes() {
        return (List<Cliente>) clienteDAO.findAll();
    }

}
