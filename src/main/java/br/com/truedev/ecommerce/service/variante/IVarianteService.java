package br.com.truedev.ecommerce.service.variante;

import java.util.List;

import br.com.truedev.ecommerce.model.Produto;
import br.com.truedev.ecommerce.model.Variante;

public interface IVarianteService {

    public Variante criarVariante(Variante variante);

    public Variante alterarVariante(Variante variante);

    public List<Variante> buscarPorProduto(Produto produto);

    public Variante buscarPorId(Integer id);

}
