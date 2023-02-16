package br.inatel.cdg.nasa.MODEL;

public class Passageiro
{
    protected int idPassageiro;
    protected String nome;
    protected  int idade;
    protected String sexo;
    protected int passageiro_has_nave; //chave estrangeira

    // Getters e Setters
    public int getIdPassageiro() {return idPassageiro;}
    public void setIdPassageiro(int idPassageiro) {this.idPassageiro = idPassageiro;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public int getIdade() {return idade;}
    public void setIdade(int idade) {this.idade = idade;}
    public String getSexo() {return sexo;}
    public void setSexo(String sexo) {this.sexo = sexo;}
    public int getPassageiro_has_nave() {return passageiro_has_nave;}
    public void setPassageiro_has_nave(int passageiro_has_nave) {this.passageiro_has_nave = passageiro_has_nave;}
}
