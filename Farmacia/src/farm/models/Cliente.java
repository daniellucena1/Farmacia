package farm.models;

// import farm.models.Carrinho;

// import java.util.ArrayList;
// import java.util.List;

public class Cliente {
    private String cpf;
    private Carrinho carrinho;

    public Cliente(String cpf, Carrinho carrinho) {
        this.cpf = cpf;
        this.carrinho = carrinho;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Carrinho getCarrinho(){
        return this.carrinho;
    }

}
