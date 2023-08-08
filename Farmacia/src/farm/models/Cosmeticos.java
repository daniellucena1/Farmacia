package farm.models;

public class Cosmeticos extends Produto{
    private static double descontoMax = 0.2;
    public Cosmeticos(double preco, String descricao, int estoque, String validade, Fornecedor fornecedor){
        super( preco,descricao, estoque, validade, descontoMax, fornecedor);
    }
}
