package br.com.truedev.ecommerce.service.produto;

import java.util.List;

import br.com.truedev.ecommerce.model.Categoria;
import br.com.truedev.ecommerce.model.Produto;

public interface IProdutoService {

    public Produto cadastraProduto(Produto produto);

    public Produto alterarProduto(Produto produto);

    public List<Produto> listaProdutos();

    public List<Produto> buscarProdutoPorPalavraChave(String palavraChave);

    public Produto buscarProduto(Integer id);

    public void deletarProduto(Integer id);

    public List<Produto> buscarPorCategoria(Categoria categoria);

}
