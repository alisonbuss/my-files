package com.questionsanswers.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cadastro {

    private int id;
    private int idFormulario;
    private String imei;
    private String dataHora;
    private String latitude;
    private String longitude;

    private ArrayList<ValorCadastrado> listaValorCadastrado;

    public Cadastro() {
        this.id = 0;
        this.idFormulario = 0;
        this.imei = "";
        this.dataHora = "";
        this.latitude = "";
        this.longitude = "";

        this.listaValorCadastrado = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(int idFormulario) {
        this.idFormulario = idFormulario;
    }

    public ArrayList<ValorCadastrado> getListaValorCadastrado() {
        return listaValorCadastrado;
    }

    public void setListaValorCadastrado(ArrayList<ValorCadastrado> listaValorCadastrado) {
        this.listaValorCadastrado = listaValorCadastrado;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
