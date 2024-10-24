package br.com.truedev.ecommerce.service.variante;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.truedev.ecommerce.dao.VarianteDAO;
import br.com.truedev.ecommerce.model.Produto;
import br.com.truedev.ecommerce.model.Variante;

@Component
public class VarianteServiceImpl implements IVarianteService {

    @Autowired
    private VarianteDAO varianteDAO;

    @Override
    public Variante criarVariante(Variante variante) {
        return varianteDAO.save(variante);
    }

    @Override
    public Variante alterarVariante(Variante variante) {
        return varianteDAO.save(variante);
    }

    @Override
    public List<Variante> buscarPorProduto(Produto produto) {
        return varianteDAO.findByProduto(produto);
    }

    @Override
    public Variante buscarPorId(Integer id) {
        return varianteDAO.findById(id).orElse(null);
    }

}
