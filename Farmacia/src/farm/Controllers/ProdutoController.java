package farm.Controllers;

import farm.repositories.ProdutoRepository;
import farm.models.*;

public class ProdutoController {
    private ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    public void addProduto(Produto produto) {
        this.repository.addProduto(produto);
    }

    public void removerProduto(Produto produto) {
        this.repository.removerProduto(produto);
    }

    public void mostrarProdutosDisponiveis(){
        this.repository.mostrarProdutosDisponiveis();
    }

    public Produto buscarProdutoPorDescricao(String descricao) {
        return this.repository.buscarProdutoPorDescricao(descricao);
    }
}
