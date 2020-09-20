package com.questionsanswers.model;

import java.util.ArrayList;
import java.util.List;

public class Formulario {

    private int id;
    private String nome;
    private String descricao;
    private ArrayList<CampoFormulario> listaCampos;
    private ArrayList<Cadastro> listaCadastros;

    public Formulario(){
        this.id = 0;
        this.nome = "";
        this.descricao = "";
        this.listaCampos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ArrayList<CampoFormulario> getListaCampos() {
        return listaCampos;
    }

    public void setListaCampos(ArrayList<CampoFormulario> listaCampos) {
        this.listaCampos = listaCampos;
    }

    public ArrayList<Cadastro> getListaCadastros() {
        return listaCadastros;
    }

    public void setListaCadastros(ArrayList<Cadastro> listaCadastros) {
        this.listaCadastros = listaCadastros;
    }
}
