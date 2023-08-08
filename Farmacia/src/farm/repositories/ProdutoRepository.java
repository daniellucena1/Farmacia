package farm.repositories;

import java.util.ArrayList;
import java.util.List;

import farm.models.Produto;

public class ProdutoRepository {
    private List<Produto> produtos = new ArrayList<Produto>();

    public int getPosicaoProduto(String descricao) {
        for(int i = 0; i < produtos.size(); i++) {
            if(produtos.get(i).getDescricao().equals(descricao)){
                return i;
            }
        }
        return -1;
    }

    public void addProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i) == produto) {
                produtos.remove(i);
            }
        }
    }

    public void mostrarProdutosDisponiveis() {
        if (produtos.size() == 0) {
            System.out.println(">> Nenhum produto cadastrado");
        } else {
            System.out.printf("%-26s%-16s%-11s\n", "Produto", "Preço", "Fornecedor");
            for (int i = 0; i < produtos.size(); i++) {
                System.out.printf(i + " - %-26s%-16.2f%-11s\n", produtos.get(i).getDescricao(), produtos.get(i).getPreco(), produtos.get(i).getFornecedor().getNome());
            }
        }
    }

    public Produto buscarProdutoPorDescricao(String descricao) {
        int posicao = getPosicaoProduto(descricao);
        if(posicao != -1){
            return produtos.get(posicao);
        }
        return null;
    }
}
