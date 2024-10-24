package br.com.truedev.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import br.com.truedev.ecommerce.model.Produto;
import br.com.truedev.ecommerce.model.Variante;

public interface VarianteDAO extends CrudRepository<Variante, Integer> {

    public List<Variante> findByProduto(Produto produto);

}
