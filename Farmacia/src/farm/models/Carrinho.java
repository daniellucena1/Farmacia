package farm.models;

import java.util.List;
import java.util.ArrayList;

public class Carrinho {

    private List<Produto> carrinho = new ArrayList<Produto>();

    public void addCarrinho(Produto produto) {
        carrinho.add(produto);
    }

    public void removeCarrinho(Produto produto) {
        for (int i = 0; i < carrinho.size(); i++) {
            if (carrinho.get(i) == produto) {
                carrinho.remove(i);
            }
        }
    }

    public void desconto() {
        for(int i = 0; i < carrinho.size(); i++){
            if (carrinho.size() >= 5) {
                double precoComDesconto = carrinho.get(i).getPreco()
                        - (carrinho.get(i).getDescontoMax() * carrinho.get(i).getPreco());
                carrinho.get(i).setPreco(precoComDesconto);
            }
        }
    }

    public void mostrarCarrinho() {
        if (carrinho.size() == 0) {
            System.out.println(">> Carrinho está vazio!");
            return;
        }
        System.out.printf("%-25s%-15s%-10s\n", "Produto", "Preço", "Fornecedor");
        for (int i = 0; i < carrinho.size(); i++) {
            System.out.printf("%-25s%-15.2f%-10s\n", carrinho.get(i).getDescricao(), carrinho.get(i).getPreco(), carrinho.get(i).getFornecedor().getNome());
        }
    }

    public void concluirCompra(Cliente cliente) {
        if (carrinho.size() == 0) {
            System.out.println(">> carrinho vazio!");
        } else {
            System.out.println(">> Cpf do cliente: " + cliente.getCpf());
            if(carrinho.size() >= 5){
                System.out.println(">> Você ganhou um desconto!");
                desconto();
            }
            mostrarCarrinho();
            double total = 0;
            for (int i = 0; i < carrinho.size(); i++) {
                total += carrinho.get(i).getPreco();
            }
            System.out.printf(">> Total a pagar: R$ %.2f\n", total);
            System.out.println(">> Compra efetuada com sucesso");
            limparCarrinho();
        }
    }

    public void limparCarrinho() {
        carrinho.clear();
    }
}
