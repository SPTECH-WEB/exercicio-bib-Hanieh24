package com.school.sptech;

public class Biblioteca {
    private  String nome;
    private Double multaDiaria;
    private Integer qtdLivros;
    private Boolean ativa;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getMultaDiaria() {
        return multaDiaria;
    }

    public Integer getQtdLivros(){
        return qtdLivros;
    }

    public Boolean getAtiva(){
        return ativa;
    }

    public Biblioteca(String nome, Double multaDiaria){
        this.nome =nome;
        this.multaDiaria=multaDiaria;
        this.qtdLivros=0;
        this.ativa=true;
    }

    public void registrarLivro(Integer quantidade){
        if (quantidade != null && quantidade > 0 && ativa == true){
            qtdLivros +=quantidade;
        }
    }

    public  Integer emprestar(Integer quantidade){
        if(ativa == true && quantidade != null && quantidade > 0 && quantidade <= qtdLivros){
            qtdLivros -= quantidade;
            return quantidade;
        }else {
            return null;
        }
    }

    public Integer devolver(Integer quantidade){
        if (quantidade != null && quantidade > 0 && ativa == true){
            qtdLivros +=quantidade;
            return quantidade;
        }else {
            return null;
        }
    }

    public  Integer desativar(){
        if (ativa==false){
            return null;
        }else {
            Integer anterior = qtdLivros;
            ativa=false;
            qtdLivros =0;
            return anterior;
        }
    }
    public void transferir(Biblioteca destino, Integer quantidade){
        if(ativa == true && destino.ativa == true && quantidade != null && quantidade > 0 && quantidade <= qtdLivros){
            qtdLivros-= quantidade;
            destino.qtdLivros += quantidade;
        }
    }

    public boolean reajustarMulta(Double percentual){
        if ( percentual!= null &&percentual > 0 ){
            multaDiaria+=multaDiaria*percentual;
            return true;
        }else {
            return false;
        }


    }
}
