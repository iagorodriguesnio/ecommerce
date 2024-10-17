package br.com.truedev.ecommerce.service.categoria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.truedev.ecommerce.dao.CategoriaDAO;
import br.com.truedev.ecommerce.model.Categoria;

@Component
public class CategoriaServiceImpl implements ICategoriaService {

    @Autowired
    private CategoriaDAO categoriaDAO;

    @Override
    public Categoria cadastrarCategoria(Categoria categoria) {

        return categoriaDAO.save(categoria);
    }

    @Override
    public Categoria alterarCategoria(Categoria categoria) {

        return categoriaDAO.save(categoria);
    }

    @Override
    public Categoria buscarCategoriaPeloId(Integer id) {

        return categoriaDAO.findById(id).orElse(null);
    }

    @Override
    public Categoria buscarCategoriaPeloNome(String nome) {

        return categoriaDAO.findByNome(nome);
    }

    @Override
    public List<Categoria> recuperarTodasCategorias() {

        return (List<Categoria>) categoriaDAO.findAll();
    }

    @Override
    public void deletarCategoria(Integer id) {
        categoriaDAO.deleteById(id);
    }

}
