package com.questionsanswers.model;

public class ValorCadastrado {

    private int id;
    private int idCadastro;
    private int idCampoFormulario;
    private String valorCadastrado;

    private Cadastro cadastro;
    private CampoFormulario campoFormulario;

    public ValorCadastrado() {
        this.setId(0);
        this.setIdCadastro(0);
        this.setIdCampoFormulario(0);
        this.setValorCadastrado("");

        this.setCadastro(null);
        this.setCampoFormulario(null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCadastro() {
        return idCadastro;
    }

    public void setIdCadastro(int idCadastro) {
        this.idCadastro = idCadastro;
    }

    public int getIdCampoFormulario() {
        return idCampoFormulario;
    }

    public void setIdCampoFormulario(int idCampoFormulario) {
        this.idCampoFormulario = idCampoFormulario;
    }

    public String getValorCadastrado() {
        return valorCadastrado;
    }

    public void setValorCadastrado(String valorCadastrado) {
        this.valorCadastrado = valorCadastrado;
    }

    public Cadastro getCadastro() {
        return cadastro;
    }

    public void setCadastro(Cadastro cadastro) {
        this.cadastro = cadastro;
    }

    public CampoFormulario getCampoFormulario() {
        return campoFormulario;
    }

    public void setCampoFormulario(CampoFormulario campoFormulario) {
        this.campoFormulario = campoFormulario;
    }
}
