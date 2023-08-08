package farm.models;
public class Medicamento extends Produto{
    private static double descontoMax = 0.1;
    public Medicamento( double preco, String descricao, int estoque, String validade, Fornecedor fornecedor){
        super(preco, descricao, estoque, validade, descontoMax, fornecedor);
    }
}
