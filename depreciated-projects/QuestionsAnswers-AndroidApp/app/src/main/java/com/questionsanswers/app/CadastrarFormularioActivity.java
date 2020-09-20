package com.questionsanswers.app;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.questionsanswers.dao.CadastroBD;
import com.questionsanswers.dao.ValorCadastradoBD;
import com.questionsanswers.model.Cadastro;
import com.questionsanswers.model.CampoFormulario;
import com.questionsanswers.model.Formulario;
import com.questionsanswers.model.TipoCampo;
import com.questionsanswers.model.ValorCadastrado;
import com.questionsanswers.service.FormularioService;

public class CadastrarFormularioActivity extends BaseActionBarActivity {

    private Toolbar toolbarGeneric;
    private Formulario formulario;

    private FormularioService formularioService = new FormularioService();

    protected int getLayoutResourceId() {
        return R.layout.activity_cadastrar_formulario;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(this.getLayoutResourceId());

        // Attaching the layout to the toolbar object
        toolbarGeneric = (Toolbar) findViewById(R.id.toolbar_generic);
        if (toolbarGeneric != null) {
            toolbarGeneric.setTitle("Questions & Answers");
            toolbarGeneric.setSubtitle("Cadastro");
            // Voltar
            toolbarGeneric.setNavigationIcon(R.mipmap.ic_arrow_left_bold_hexagon_outline_white_36dp);
            toolbarGeneric.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voltar();
                    //onBackPressed();
                }
            });
            // Setting toolbar as the ActionBar with setSupportActionBar() call
            setSupportActionBar(toolbarGeneric);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Intent it = getIntent();
        if (it != null) {
            Bundle params = it.getExtras();
            if (params != null) {
                // Pegando o ID do Formulario para a Criação
                long idFormulario = params.getInt("idFormulario");
                this.construindoFormulario(idFormulario);
            }
        }
    }

    private void voltar() {
        Intent intent = new Intent(CadastrarFormularioActivity.this, DetalheFormularioActivity.class);
        intent.putExtra("idFormulario", this.formulario.getId());
        startActivity(intent);
    }

    private void construindoFormulario(long idFormulario) {

        this.formulario = formularioService.getFormularioPorID(idFormulario);

        if(this.formulario != null) {
            // Layout do Formulario
            LinearLayout layoutFormulario = (LinearLayout) findViewById(R.id.contentFormLL);

            // Pegando os campos do Formulario
            for(CampoFormulario campoFormulario : this.formulario.getListaCampos()) {
                // Iniciando o ID
                int ID_FIELD = campoFormulario.getId();

                // Pegando o Tipo do Formulario
                final String TIPO_FORMULARIO = campoFormulario.getTipoCampo().getTipo();

                // Create and Add new field for Type
                switch (TIPO_FORMULARIO) {
                    case TipoCampo.TEXT:
                        // Create new Label
                        TextView labelEditText = new TextView(this);
                        labelEditText.setPadding(10, 10, 0, 5);
                        // Define Label
                        labelEditText.setText(campoFormulario.getTitulo());
                        // Add View
                        layoutFormulario.addView(labelEditText);

                        // Create new Field
                        EditText campoEditText = new EditText(this);
                        campoEditText.setId(ID_FIELD);
                        campoEditText.setInputType(InputType.TYPE_CLASS_TEXT);
                        // Add View
                        layoutFormulario.addView(campoEditText);
                        break;

                    case TipoCampo.NUMBER:
                        // Create new Label
                        TextView labelEditNumber = new TextView(this);
                        labelEditNumber.setPadding(10, 10, 0, 5);
                        // Define Label
                        labelEditNumber.setText(campoFormulario.getTitulo());
                        // Add View
                        layoutFormulario.addView(labelEditNumber);

                        // Create new Field
                        EditText campoEditNumber = new EditText(this);
                        campoEditNumber.setId(ID_FIELD);
                        campoEditNumber.setInputType(EditorInfo.TYPE_NUMBER_FLAG_SIGNED | EditorInfo.TYPE_CLASS_NUMBER);
                        // Add View
                        layoutFormulario.addView(campoEditNumber);
                        break;

                    case TipoCampo.REAL:
                        // Create new Label
                        TextView labelEditFloat = new TextView(this);
                        labelEditFloat.setPadding(10, 10, 0, 5);
                        // Define Label
                        labelEditFloat.setText(campoFormulario.getTitulo());
                        // Add View
                        layoutFormulario.addView(labelEditFloat);

                        // Create new Field
                        EditText campoEditFloat = new EditText(this);
                        campoEditFloat.setId(ID_FIELD);
                        campoEditFloat.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                        // Add View
                        layoutFormulario.addView(campoEditFloat);
                        break;

                    case TipoCampo.GROUP_SELECT:
                        // Create new Label
                        TextView labelSelect = new TextView(this);
                        labelSelect.setPadding(10, 10, 0, 5);
                        // Define Label
                        labelSelect.setText(campoFormulario.getTitulo());
                        // Add View
                        layoutFormulario.addView(labelSelect);

                        // Pegando os Campos Filhos
                        ArrayList<String> valores = new ArrayList<>();
                        for(CampoFormulario campoRequerido : this.formulario.getListaCampos()) {
                            if(campoRequerido.getCampoFormularioSuperior() != null) {
                                if(campoRequerido.getCampoFormularioSuperior().getId() == ID_FIELD) {
                                    valores.add(campoRequerido.getTitulo());
                                }
                            }
                        }
                        // Create new Field
                        Spinner campoSelect  = new Spinner(this);
                        campoSelect.setId(ID_FIELD);
                        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores);
                        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        campoSelect.setAdapter(dataAdapter);
                        // Add View
                        layoutFormulario.addView(campoSelect);
                        break;

                    case TipoCampo.GROUP_RADIOBOX:
                        // Create new Label
                        TextView labelRadioGroup = new TextView(this);
                        labelRadioGroup.setPadding(10, 10, 0, 5);
                        // Define Label
                        labelRadioGroup.setText(campoFormulario.getTitulo());
                        // Add View
                        layoutFormulario.addView(labelRadioGroup);

                        // Create new Field
                        RadioGroup campoRadioGroup = new RadioGroup(this);
                        campoRadioGroup.setId(ID_FIELD);

                        for(CampoFormulario campoRequerido : this.formulario.getListaCampos()) {
                            if(campoRequerido.getCampoFormularioSuperior() != null) {
                                if(campoRequerido.getCampoFormularioSuperior().getId() == ID_FIELD) {
                                    RadioButton radioBtn = new RadioButton(this);
                                    radioBtn.setId(campoRequerido.getId());
                                    radioBtn.setText(campoRequerido.getTitulo());
                                    campoRadioGroup.addView(radioBtn);
                                }
                            }
                        }
                        // Add View
                        layoutFormulario.addView(campoRadioGroup);
                        break;

                    case TipoCampo.GROUP_CHECKBOX:
                        // Create new Label
                        TextView labelCheckBox = new TextView(this);
                        labelCheckBox.setPadding(10, 10, 0, 5);
                        // Define Label
                        labelCheckBox.setText(campoFormulario.getTitulo());
                        // Add View
                        layoutFormulario.addView(labelCheckBox);

                        // Create new Field
                        for(CampoFormulario campoRequerido : this.formulario.getListaCampos()) {
                            if(campoRequerido.getCampoFormularioSuperior() != null) {
                                if(campoRequerido.getCampoFormularioSuperior().getId() == ID_FIELD) {
                                    CheckBox checkBox = new CheckBox(this);
                                    checkBox.setId(campoRequerido.getId());
                                    checkBox.setText(campoRequerido.getTitulo());
                                    // Add View
                                    layoutFormulario.addView(checkBox);
                                }
                            }
                        }
                        break;

                    case TipoCampo.BOOLEAN:
                        // Create new Label
                        TextView labelToggleButton = new TextView(this);
                        labelToggleButton.setPadding(10, 10, 0, 5);
                        // Define Label
                        labelToggleButton.setText(campoFormulario.getTitulo());
                        // Add View
                        layoutFormulario.addView(labelToggleButton);

                        // Create new Field
                        ToggleButton toggle = new ToggleButton(this);
                        toggle.setId(ID_FIELD);
                        // Add View
                        layoutFormulario.addView(toggle);
                        break;

                    case TipoCampo.DATE:
                        // Create new Label
                        TextView labelDate = new TextView(this);
                        labelDate.setPadding(10, 10, 0, 5);
                        // Define Label
                        labelDate.setText(campoFormulario.getTitulo());
                        // Add View
                        layoutFormulario.addView(labelDate);

                        // Create new Field
                        final EditText campoEditDate = new EditText(this);
                        campoEditDate.setId(ID_FIELD);
                        campoEditDate.setFocusable(false);
                        campoEditDate.setInputType(InputType.TYPE_NULL);
                        campoEditDate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Calendar newCalendar = Calendar.getInstance();
                                DatePickerDialog datePicker = new DatePickerDialog(CadastrarFormularioActivity.this, new DatePickerDialog.OnDateSetListener() {
                                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                        Calendar newDate = Calendar.getInstance();
                                        newDate.set(year, monthOfYear, dayOfMonth);
                                        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
                                        campoEditDate.setText(dateFormatter.format(newDate.getTime()));
                                    }
                                }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
                                datePicker.setTitle("Seleciona uma Data!");
                                datePicker.show();
                            }
                        });
                        // Add View
                        layoutFormulario.addView(campoEditDate);
                        break;
                }
            }

            Button cadastrarFormularioBTN = new Button(this);
            cadastrarFormularioBTN.setText("Cadastrar");
            cadastrarFormularioBTN.setTextSize(20);
            cadastrarFormularioBTN.setTextColor(Color.parseColor("#FFFFFF"));
            cadastrarFormularioBTN.setBackgroundColor(Color.parseColor("#2196F3"));
            cadastrarFormularioBTN.setHeight(60);
            cadastrarFormularioBTN.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cadastrarFormulario();
                }
            });
            layoutFormulario.addView(cadastrarFormularioBTN);

        } else {
            Toast.makeText(this, "Formulario Perdido! ID:" + idFormulario, Toast.LENGTH_LONG).show();
        }
    }

    private void cadastrarFormulario() {
        if(this.formulario != null) {

            Date data = new Date();
            SimpleDateFormat dataAtual = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

            Cadastro novoCadastro = new Cadastro();
            novoCadastro.setIdFormulario(this.formulario.getId());
            novoCadastro.setDataHora(dataAtual.format(data));
            novoCadastro.setImei(this.getIMEI());
            novoCadastro.setLatitude("");
            novoCadastro.setLongitude("");

            CadastroBD cadastroBD = new CadastroBD(getBaseContext());
            int idCadastro = (int) cadastroBD.inserir(novoCadastro);
            novoCadastro.setId(idCadastro);

            ValorCadastradoBD valorCadastradoBD = new ValorCadastradoBD(getBaseContext());

            LinearLayout layoutFormulario = (LinearLayout) findViewById(R.id.contentFormLL);
            // Pegar os dados do Formulario
            for(CampoFormulario campoFormulario : this.formulario.getListaCampos()) {

                // Iniciando o ID
                int ID_FIELD = campoFormulario.getId();

                // Pegando o Tipo do Formulario
                final String TIPO_FORMULARIO = campoFormulario.getTipoCampo().getTipo();

                // Verificar os tipos e pegar os dados
                switch (TIPO_FORMULARIO) {
                    case TipoCampo.TEXT:
                        EditText editText = (EditText) layoutFormulario.findViewById(ID_FIELD);
                        String valorText = editText.getText().toString();

                        ValorCadastrado valorEditText = new ValorCadastrado();
                        valorEditText.setIdCadastro(novoCadastro.getId());
                        valorEditText.setIdCampoFormulario(ID_FIELD);
                        valorEditText.setValorCadastrado(valorText);

                        valorCadastradoBD.inserir(valorEditText);
                        break;

                    case TipoCampo.NUMBER:
                        EditText editTextNumber = (EditText) layoutFormulario.findViewById(ID_FIELD);
                        String valorNumber = editTextNumber.getText().toString();

                        ValorCadastrado valorTextNumber = new ValorCadastrado();
                        valorTextNumber.setIdCadastro(novoCadastro.getId());
                        valorTextNumber.setIdCampoFormulario(ID_FIELD);
                        valorTextNumber.setValorCadastrado(valorNumber);

                        valorCadastradoBD.inserir(valorTextNumber);
                        break;

                    case TipoCampo.REAL:
                        EditText editTextReal = (EditText) layoutFormulario.findViewById(ID_FIELD);
                        String valorReal = editTextReal.getText().toString();

                        ValorCadastrado valorTextReal = new ValorCadastrado();
                        valorTextReal.setIdCadastro(novoCadastro.getId());
                        valorTextReal.setIdCampoFormulario(ID_FIELD);
                        valorTextReal.setValorCadastrado(valorReal);

                        valorCadastradoBD.inserir(valorTextReal);
                        break;

                    case TipoCampo.GROUP_SELECT:
                        Spinner groupSelect = (Spinner) layoutFormulario.findViewById(ID_FIELD);
                        String valorSelect = groupSelect.getSelectedItem().toString();

                        ValorCadastrado valorGroupSelect = new ValorCadastrado();
                        valorGroupSelect.setIdCadastro(novoCadastro.getId());
                        valorGroupSelect.setIdCampoFormulario(ID_FIELD);
                        valorGroupSelect.setValorCadastrado(valorSelect);

                        valorCadastradoBD.inserir(valorGroupSelect);
                        break;

                    case TipoCampo.GROUP_RADIOBOX:
                        RadioGroup groupRadio = (RadioGroup) layoutFormulario.findViewById(ID_FIELD);
                        int selected = groupRadio.getCheckedRadioButtonId();
                        RadioButton radioButton = (RadioButton) groupRadio.findViewById(selected);
                        String valorRadio = radioButton.getText().toString();

                        ValorCadastrado valorGroupRadio = new ValorCadastrado();
                        valorGroupRadio.setIdCadastro(novoCadastro.getId());
                        valorGroupRadio.setIdCampoFormulario(ID_FIELD);
                        valorGroupRadio.setValorCadastrado(valorRadio);

                        valorCadastradoBD.inserir(valorGroupRadio);
                        break;

                    case TipoCampo.GROUP_CHECKBOX:
                        for(CampoFormulario campoRequerido : this.formulario.getListaCampos()) {
                            if(campoRequerido.getCampoFormularioSuperior() != null) {
                                if(campoRequerido.getCampoFormularioSuperior().getId() == ID_FIELD) {
                                    CheckBox checkBox = (CheckBox) layoutFormulario.findViewById(campoRequerido.getId());
                                    if (checkBox.isChecked()) {
                                        String valorCheck = checkBox.getText().toString();

                                        ValorCadastrado valorCheckBox = new ValorCadastrado();
                                        valorCheckBox.setIdCadastro(novoCadastro.getId());
                                        valorCheckBox.setIdCampoFormulario(campoRequerido.getId());
                                        valorCheckBox.setValorCadastrado(valorCheck);

                                        valorCadastradoBD.inserir(valorCheckBox);
                                    }
                                }
                            }
                        }
                        break;

                    case TipoCampo.BOOLEAN:
                        ToggleButton toggleButton = (ToggleButton) layoutFormulario.findViewById(ID_FIELD);
                        if (toggleButton.isChecked() == true) {
                            String valorToggle = "Sim";

                            ValorCadastrado valorToggleButton = new ValorCadastrado();
                            valorToggleButton.setIdCadastro(novoCadastro.getId());
                            valorToggleButton.setIdCampoFormulario(ID_FIELD);
                            valorToggleButton.setValorCadastrado(valorToggle);

                            valorCadastradoBD.inserir(valorToggleButton);
                        } else {
                            String valorToggle = "Não";

                            ValorCadastrado valorToggleButton = new ValorCadastrado();
                            valorToggleButton.setIdCadastro(novoCadastro.getId());
                            valorToggleButton.setIdCampoFormulario(ID_FIELD);
                            valorToggleButton.setValorCadastrado(valorToggle);

                            valorCadastradoBD.inserir(valorToggleButton);
                        }
                        break;

                    case TipoCampo.DATE:
                        EditText editTextDate = (EditText) layoutFormulario.findViewById(ID_FIELD);
                        String valorData = editTextDate.getText().toString();

                        ValorCadastrado valorTextDate = new ValorCadastrado();
                        valorTextDate.setIdCadastro(novoCadastro.getId());
                        valorTextDate.setIdCampoFormulario(ID_FIELD);
                        valorTextDate.setValorCadastrado(valorData);

                        valorCadastradoBD.inserir(valorTextDate);
                        break;
                }
            }

            final FrameLayout loadingFL = (FrameLayout) findViewById(R.id.loadingFL);
            loadingFL.setVisibility(View.VISIBLE);

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    loadingFL.setVisibility(View.GONE);
                    Toast.makeText(CadastrarFormularioActivity.this, "Formulario Cadastrado com Sucesso!!", Toast.LENGTH_LONG).show();
                }
            }, 1000);

        } else {
            Toast.makeText(this, "Formulario Não Encontrado!!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cadastrar_formulario, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}