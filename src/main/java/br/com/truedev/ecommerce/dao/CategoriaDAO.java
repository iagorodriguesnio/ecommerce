package br.com.truedev.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.truedev.ecommerce.model.Categoria;

public interface CategoriaDAO extends CrudRepository<Categoria, Integer> {

    public Categoria findByNome(String nome);
}
