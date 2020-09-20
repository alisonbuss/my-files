package com.questionsanswers.service;

import com.questionsanswers.model.Cadastro;
import com.questionsanswers.model.CampoFormulario;
import com.questionsanswers.model.Formulario;

import java.util.ArrayList;
import java.util.List;

interface IFormularioBusiness {

    ArrayList<Formulario> getAllFormularios();

    Formulario getFormularioPorID(long idFormulario);

    ArrayList<CampoFormulario> getCamposFormularioPorID(long idFormulario);

    void cadastrarFormulario(Cadastro cadastro);

    boolean sincronizarFormularioPorID(long idFormulario);

}
