package com.questionsanswers.service;

import com.questionsanswers.model.Cadastro;
import com.questionsanswers.model.CampoFormulario;
import com.questionsanswers.model.Formulario;
import com.questionsanswers.model.TipoCampo;

import java.util.ArrayList;
import java.util.List;

public class FormularioService implements IFormularioBusiness {

    @Override
    public ArrayList<Formulario> getAllFormularios() {
        // ########################################################################## //
        // ######################### //
        // TIPO:  CRIAR FORMULARIOS
        // ######################### //
        ArrayList<Formulario> formularios = new ArrayList<>();
        for (int i = 666; i < 699; i++)
        {
            ArrayList<CampoFormulario> campos = new ArrayList<>();

            // ########################################################################## //
            // ######################### //
            // TIPO:  TEXT
            // ######################### //
            TipoCampo tipoTexto = new TipoCampo();
            tipoTexto.setId(1);
            tipoTexto.setTipo(TipoCampo.TEXT);
            tipoTexto.setDescricao("");

            // ######################### //
            // TIPO:  NUMBER
            // ######################### //
            TipoCampo tipoNumerico = new TipoCampo();
            tipoNumerico.setId(2);
            tipoNumerico.setTipo(TipoCampo.NUMBER);
            tipoNumerico.setDescricao("");

            // ######################### //
            // TIPO:  REAL
            // ######################### //
            TipoCampo tipoDecimal = new TipoCampo();
            tipoDecimal.setId(3);
            tipoDecimal.setTipo(TipoCampo.REAL);
            tipoDecimal.setDescricao("");

            // ######################### //
            // TIPO:  GROUP_SELECT
            // ######################### //
            TipoCampo tipoGroupSelect = new TipoCampo();
            tipoGroupSelect.setId(4);
            tipoGroupSelect.setTipo(TipoCampo.GROUP_SELECT);
            tipoGroupSelect.setDescricao("");

            // ######################### //
            // TIPO:  GROUP_RADIOBOX
            // ######################### //
            TipoCampo tipoGroupRadiobox = new TipoCampo();
            tipoGroupRadiobox.setId(5);
            tipoGroupRadiobox.setTipo(TipoCampo.GROUP_RADIOBOX);
            tipoGroupRadiobox.setDescricao("");

            // ######################### //
            // TIPO:  GROUP_CHECKBOX
            // ######################### //
            TipoCampo tipoGroupCheckbox = new TipoCampo();
            tipoGroupCheckbox.setId(6);
            tipoGroupCheckbox.setTipo(TipoCampo.GROUP_CHECKBOX);
            tipoGroupCheckbox.setDescricao("");

            // ######################### //
            // TIPO:  OPTION
            // ######################### //
            TipoCampo tipoOption = new TipoCampo();
            tipoOption.setId(7);
            tipoOption.setTipo(TipoCampo.OPTION);
            tipoOption.setDescricao("");

            // ######################### //
            // TIPO:  RADIOBOX
            // ######################### //
            TipoCampo tipoRadio = new TipoCampo();
            tipoRadio.setId(8);
            tipoRadio.setTipo(TipoCampo.RADIOBOX);
            tipoRadio.setDescricao("");

            // ######################### //
            // TIPO:  CHECKBOX
            // ######################### //
            TipoCampo tipoCheckbox = new TipoCampo();
            tipoCheckbox.setId(9);
            tipoCheckbox.setTipo(TipoCampo.CHECKBOX);
            tipoCheckbox.setDescricao("");

            // ######################### //
            // TIPO:  BOOLEAN
            // ######################### //
            TipoCampo tipoBoolean = new TipoCampo();
            tipoBoolean.setId(10);
            tipoBoolean.setTipo(TipoCampo.BOOLEAN);
            tipoBoolean.setDescricao("");

            // ######################### //
            // TIPO:  DATE
            // ######################### //
            TipoCampo tipoData = new TipoCampo();
            tipoData.setId(11);
            tipoData.setTipo(TipoCampo.DATE);
            tipoData.setDescricao("");

            // ######################### //
            // TIPO:  LATITUDE
            // ######################### //
            TipoCampo tipoLatitude = new TipoCampo();
            tipoLatitude.setId(12);
            tipoLatitude.setTipo(TipoCampo.LATITUDE);
            tipoLatitude.setDescricao("");

            // ######################### //
            // TIPO:  LONGITUDE
            // ######################### //
            TipoCampo tipoLongitude = new TipoCampo();
            tipoLongitude.setId(13);
            tipoLongitude.setTipo(TipoCampo.LONGITUDE);
            tipoLongitude.setDescricao("");


            // ########################################################################## //
            // ######################### //
            // CAMPO:  TEXT
            // ######################### //
            CampoFormulario campoTexto = new CampoFormulario();
            campoTexto.setId(1);
            campoTexto.setTitulo("Campo Texto");
            campoTexto.setDescricao("");
            campoTexto.setRequerido(true);
            campoTexto.setCampoFormularioSuperior(null);
            campoTexto.setIdFormulario(i);
            campoTexto.setTipoCampo(tipoTexto);
            campos.add(campoTexto);

            // ######################### //
            // CAMPO:  NUMBER
            // ######################### //
            CampoFormulario campoNumerico = new CampoFormulario();
            campoNumerico.setId(2);
            campoNumerico.setTitulo("Campo Numerico");
            campoNumerico.setDescricao("");
            campoNumerico.setRequerido(false);
            campoNumerico.setCampoFormularioSuperior(null);
            campoNumerico.setIdFormulario(i);
            campoNumerico.setTipoCampo(tipoNumerico);
            campos.add(campoNumerico);

            // ######################### //
            // CAMPO:  REAL
            // ######################### //
            CampoFormulario campoDecimal = new CampoFormulario();
            campoDecimal.setId(3);
            campoDecimal.setTitulo("Campo Decimal");
            campoDecimal.setDescricao("");
            campoDecimal.setRequerido(true);
            campoDecimal.setCampoFormularioSuperior(null);
            campoDecimal.setIdFormulario(i);
            campoDecimal.setTipoCampo(tipoDecimal);
            campos.add(campoDecimal);

            // ######################### //
            // CAMPO:  GROUP_SELECT
            // ######################### //
            CampoFormulario campoGroupSelect = new CampoFormulario();
            campoGroupSelect.setId(4);
            campoGroupSelect.setTitulo("Selecione 'Select Option':");
            campoGroupSelect.setDescricao("");
            campoGroupSelect.setRequerido(true);
            campoGroupSelect.setCampoFormularioSuperior(null);
            campoGroupSelect.setIdFormulario(i);
            campoGroupSelect.setTipoCampo(tipoGroupSelect);
            campos.add(campoGroupSelect);

            CampoFormulario campoOptionItem01 = new CampoFormulario();
            campoOptionItem01.setId(5);
            campoOptionItem01.setTitulo("Aracaju");
            campoOptionItem01.setCampoFormularioSuperior(campoGroupSelect);
            campoOptionItem01.setIdFormulario(i);
            campoOptionItem01.setTipoCampo(tipoOption);
            campos.add(campoOptionItem01);

            CampoFormulario campoOptionItem02 = new CampoFormulario();
            campoOptionItem02.setId(6);
            campoOptionItem02.setTitulo("Alagoas");
            campoOptionItem02.setCampoFormularioSuperior(campoGroupSelect);
            campoOptionItem02.setIdFormulario(i);
            campoOptionItem02.setTipoCampo(tipoOption);
            campos.add(campoOptionItem02);

            // ######################### //
            // CAMPO:  RADIO
            // ######################### //
            CampoFormulario campoGroupRadiobox = new CampoFormulario();
            campoGroupRadiobox.setId(7);
            campoGroupRadiobox.setTitulo("Selecione sexo");
            campoGroupRadiobox.setDescricao("");
            campoGroupRadiobox.setRequerido(true);
            campoGroupRadiobox.setCampoFormularioSuperior(null);
            campoGroupRadiobox.setIdFormulario(i);
            campoGroupRadiobox.setTipoCampo(tipoGroupRadiobox);
            campos.add(campoGroupRadiobox);

            CampoFormulario campoRadioboxItem01 = new CampoFormulario();
            campoRadioboxItem01.setId(8);
            campoRadioboxItem01.setTitulo("Feminino");
            campoRadioboxItem01.setCampoFormularioSuperior(campoGroupRadiobox);
            campoRadioboxItem01.setIdFormulario(i);
            campoRadioboxItem01.setTipoCampo(tipoRadio);
            campos.add(campoRadioboxItem01);

            CampoFormulario campoRadioboxItem02 = new CampoFormulario();
            campoRadioboxItem02.setId(9);
            campoRadioboxItem02.setTitulo("Marculino");
            campoRadioboxItem02.setCampoFormularioSuperior(campoGroupRadiobox);
            campoRadioboxItem02.setIdFormulario(i);
            campoRadioboxItem02.setTipoCampo(tipoRadio);
            campos.add(campoRadioboxItem02);

            // ######################### //
            // CAMPO:  CHECK
            // ######################### //
            CampoFormulario campoCheckbox = new CampoFormulario();
            campoCheckbox.setId(10);
            campoCheckbox.setTitulo("Selecione checkbox");
            campoCheckbox.setDescricao("");
            campoCheckbox.setRequerido(true);
            campoCheckbox.setCampoFormularioSuperior(null);
            campoCheckbox.setIdFormulario(i);
            campoCheckbox.setTipoCampo(tipoGroupCheckbox);
            campos.add(campoCheckbox);

            CampoFormulario campoCheckboxItem01 = new CampoFormulario();
            campoCheckboxItem01.setId(11);
            campoCheckboxItem01.setTitulo("Mangaba");
            campoCheckboxItem01.setCampoFormularioSuperior(campoCheckbox);
            campoCheckboxItem01.setIdFormulario(i);
            campoCheckboxItem01.setTipoCampo(tipoCheckbox);
            campos.add(campoCheckboxItem01);

            CampoFormulario campoCheckboxItem02 = new CampoFormulario();
            campoCheckboxItem02.setId(12);
            campoCheckboxItem02.setTitulo("Goiaba");
            campoCheckboxItem02.setCampoFormularioSuperior(campoCheckbox);
            campoCheckboxItem02.setIdFormulario(i);
            campoCheckboxItem02.setTipoCampo(tipoCheckbox);
            campos.add(campoCheckboxItem02);

            // ######################### //
            // TIPO:  BOOLEAN
            // ######################### //
            CampoFormulario campoToggle = new CampoFormulario();
            campoToggle.setId(13);
            campoToggle.setTitulo("Alternar?");
            campoToggle.setDescricao("");
            campoToggle.setRequerido(false);
            campoToggle.setCampoFormularioSuperior(null);
            campoToggle.setIdFormulario(i);
            campoToggle.setTipoCampo(tipoBoolean);
            campos.add(campoToggle);

            // ######################### //
            // TIPO:  DATE
            // ######################### //
            CampoFormulario campoData = new CampoFormulario();
            campoData.setId(14);
            campoData.setTitulo("Data");
            campoData.setDescricao("");
            campoData.setRequerido(true);
            campoData.setCampoFormularioSuperior(null);
            campoData.setIdFormulario(i);
            campoData.setTipoCampo(tipoData);
            campos.add(campoData);

            // ######################### //
            // TIPO:  LATITUDE
            // ######################### //
            CampoFormulario campoLatitude = new CampoFormulario();
            campoLatitude.setId(15);
            campoLatitude.setTitulo("Setar sua Latitude");
            campoLatitude.setDescricao("");
            campoLatitude.setRequerido(true);
            campoLatitude.setCampoFormularioSuperior(null);
            campoLatitude.setIdFormulario(i);
            campoLatitude.setTipoCampo(tipoLatitude);
            campos.add(campoLatitude);

            // ######################### //
            // TIPO:  LONGITUDE
            // ######################### //
            CampoFormulario campoLongitude = new CampoFormulario();
            campoLongitude.setId(16);
            campoLongitude.setTitulo("Setar sua Longitude");
            campoLongitude.setDescricao("");
            campoLongitude.setRequerido(true);
            campoLongitude.setCampoFormularioSuperior(null);
            campoLongitude.setIdFormulario(i);
            campoLongitude.setTipoCampo(tipoLongitude);
            campos.add(campoLongitude);

            Formulario form = new Formulario();
            form.setId(i);
            form.setNome("Formulario Teste de Tipos de Valores");
            form.setDescricao("Cadastro de Todos os Tipos de Valores Variados");
            form.setListaCampos(campos);
            formularios.add(form);
        }
        return formularios;
    }

    @Override
    public Formulario getFormularioPorID(long idFormulario) {
        for(Formulario formulario : this.getAllFormularios()){
            if(formulario.getId() == idFormulario) {
                return formulario;
            }
        }
        return null;
    }

    @Override
    public ArrayList<CampoFormulario> getCamposFormularioPorID(long idFormulario) {
        for(Formulario formulario : this.getAllFormularios()){
            if(formulario.getId() == idFormulario) {
                return formulario.getListaCampos();
            }
        }
        return null;
    }

    @Override
    public void cadastrarFormulario(Cadastro cadastro) {

    }

    @Override
    public boolean sincronizarFormularioPorID(long idFormulario) {
        return false;
    }

}
