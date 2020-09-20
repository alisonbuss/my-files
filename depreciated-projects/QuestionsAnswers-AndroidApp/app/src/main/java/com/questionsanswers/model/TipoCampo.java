package com.questionsanswers.model;

public class TipoCampo {

    public static final String TEXT           = "TEXT";
    public static final String NUMBER         = "NUMBER";
    public static final String REAL           = "REAL";
    public static final String GROUP_SELECT   = "GROUP_SELECT";
    public static final String GROUP_RADIOBOX = "GROUP_RADIOBOX";
    public static final String GROUP_CHECKBOX = "GROUP_CHECKBOX";
    public static final String OPTION         = "OPTION";
    public static final String RADIOBOX       = "RADIOBOX";
    public static final String CHECKBOX       = "CHECKBOX";
    public static final String BOOLEAN        = "BOOLEAN";
    public static final String DATE           = "DATE";
    public static final String LATITUDE       = "LATITUDE";
    public static final String LONGITUDE      = "LONGITUDE";

    private int id;
    private String tipo;
    private String descricao;

    public TipoCampo() {
        this.id = 0;
        this.tipo = "";
        this.descricao = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
