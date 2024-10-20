package br.com.truedev.ecommerce.service.produto;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.truedev.ecommerce.dao.ProdutoDAO;
import br.com.truedev.ecommerce.model.Categoria;
import br.com.truedev.ecommerce.model.Produto;

@Component
public class ProdutoServiceImpl implements IProdutoService {

    final ProdutoDAO produtoDAO;

    public ProdutoServiceImpl(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    @Override
    public Produto cadastraProduto(Produto produto) {
        return produtoDAO.save(produto);
    }

    @Override
    public Produto alterarProduto(Produto produto) {
        return produtoDAO.save(produto);
    }

    @Override
    public List<Produto> listaProdutos() {
        return produtoDAO.findByOrderByNomeAsc();
    }

    @Override
    public List<Produto> buscarProdutoPorPalavraChave(String palavraChave) {
        return produtoDAO.findByNomeContaining(palavraChave);
    }

    @Override
    public Produto buscarProduto(Integer id) {
        return produtoDAO.findById(id).orElse(null);
    }

    @Override
    public void deletarProduto(Integer id) {
        produtoDAO.deleteById(id);
    }

    @Override
    public List<Produto> buscarPorCategoria(Categoria categoria) {

        return produtoDAO.findByCategoriasContaining(categoria);
    }

}
