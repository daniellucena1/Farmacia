package farm.models;

public class Fornecedor {
    private String nome;

    public Fornecedor(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
}