package farm.models;

public class Produto {
    private double preco;
    private String descricao;
    private int estoque;
    private String validade;
    private double descontoMax;
    private Fornecedor fornecedor;

    public Produto( double preco, String descricao, int estoque, String validade, double descontoMax, Fornecedor fornecedor){
        this.preco = preco;
        this.descricao = descricao;
        this.estoque = estoque;
        this.validade = validade;
        this.descontoMax = descontoMax;
        this.fornecedor = fornecedor;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public double getPreco(){
        return this.preco;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public void setEstoque(int estoque){
        this.estoque = estoque;
    }

    public int getEstoque(){
        return this.estoque;
    }

    public void setValidade(String validade){
        validade.trim();
        validade.replace("/", "");
        this.validade = validade;
    }

    public String getValidade(){
       return this.validade;
    }

    public void setDescontoMax(double descontoMax){
        this.descontoMax = descontoMax;
    }

    public double getDescontoMax(){
        return this.descontoMax;
    }

    public Fornecedor getFornecedor() {
        return this.fornecedor; 
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
