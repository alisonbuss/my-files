package com.questionsanswers.model;

public class CampoFormulario {

    private int id;
    private int idFormulario;
    private TipoCampo tipoCampo;
    private CampoFormulario campoFormularioSuperior;
    private String titulo;
    private String descricao;
    private boolean requerido;

    public CampoFormulario() {
        this.id = 0;
        this.tipoCampo = null;
        this.idFormulario = 0;
        this.campoFormularioSuperior = null;
        this.titulo = "";
        this.descricao = "";
        this.requerido = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoCampo getTipoCampo() {
        return tipoCampo;
    }

    public void setTipoCampo(TipoCampo tipoCampo) {
        this.tipoCampo = tipoCampo;
    }

    public int getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(int formulario) {
        this.idFormulario = formulario;
    }

    public CampoFormulario getCampoFormularioSuperior() {
        return campoFormularioSuperior;
    }

    public void setCampoFormularioSuperior(CampoFormulario campoFormularioSuperior) {
        this.campoFormularioSuperior = campoFormularioSuperior;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isRequerido() {
        return requerido;
    }

    public void setRequerido(boolean requerido) {
        this.requerido = requerido;
    }

}
