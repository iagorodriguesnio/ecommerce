package br.com.truedev.ecommerce.service.categoria;

import java.util.List;

import br.com.truedev.ecommerce.model.Categoria;

public interface ICategoriaService {

    public Categoria cadastrarCategoria(Categoria categoria);

    public Categoria alterarCategoria(Categoria categoria);

    public void deletarCategoria(Integer id);

    public Categoria buscarCategoriaPeloId(Integer id);

    public Categoria buscarCategoriaPeloNome(String nome);

    public List<Categoria> recuperarTodasCategorias();

}
