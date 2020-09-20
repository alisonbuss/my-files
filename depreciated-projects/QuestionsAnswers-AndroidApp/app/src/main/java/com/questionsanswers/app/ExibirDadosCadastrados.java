package com.questionsanswers.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.questionsanswers.dao.CadastroBD;
import com.questionsanswers.dao.ValorCadastradoBD;
import com.questionsanswers.model.Cadastro;
import com.questionsanswers.model.Formulario;
import com.questionsanswers.model.ValorCadastrado;
import com.questionsanswers.service.FormularioService;

import java.util.ArrayList;

public class ExibirDadosCadastrados extends BaseActionBarActivity {

    private Toolbar toolbarGeneric;
    private Formulario formulario = null;
    private FormularioService formularioService = new FormularioService();

    protected int getLayoutResourceId() {
        return R.layout.activity_exibir_dados_cadastrados;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(this.getLayoutResourceId());

        // Attaching the layout to the toolbar object
        toolbarGeneric = (Toolbar) findViewById(R.id.toolbar_generic);
        if (toolbarGeneric != null) {
            toolbarGeneric.setTitle("Questions & Answers");
            toolbarGeneric.setSubtitle("Exibir Dados");
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
                long idFormulario = params.getInt("idFormulario");
                this.formulario = formularioService.getFormularioPorID(idFormulario);
                if(formulario != null) {
                    CadastroBD cadastroBD = new CadastroBD(getBaseContext());
                    ArrayList<Cadastro> cadastrosList = cadastroBD.getAllCadastrosPorFormulario(formulario.getId());

                    ValorCadastradoBD valorCadastradoBD = new ValorCadastradoBD(getBaseContext());

                    LinearLayout layoutFormulario = (LinearLayout) findViewById(R.id.contentLinearLayout);

                    TextView textForm = new TextView(this);
                    textForm.setPadding(10, 10, 0, 5);
                    textForm.setText("Formulario: " + formulario.getNome() + " ID: " + formulario.getId());
                    layoutFormulario.addView(textForm);

                    if(cadastrosList != null) {
                        for(Cadastro cadastro : cadastrosList) {

                            TextView textId = new TextView(this);
                            textId.setPadding(10, 10, 0, 5);
                            textId.setText("ID: " + cadastro.getId());
                            layoutFormulario.addView(textId);

                            TextView textImei = new TextView(this);
                            textImei.setPadding(10, 10, 0, 5);
                            textImei.setText("IMEI: " + cadastro.getImei());
                            layoutFormulario.addView(textImei);

                            TextView textData = new TextView(this);
                            textData.setPadding(10, 10, 0, 5);
                            textData.setText("Data e Hora: " + cadastro.getDataHora());
                            layoutFormulario.addView(textData);

                            /*
                            TextView textValoTx = new TextView(this);
                            textValoTx.setPadding(50, 10, 0, 5);
                            textValoTx.setText("Valores: ");
                            layoutFormulario.addView(textValoTx);

                            long idCadastro = cadastro.getId();

                            cadastro.setListaValorCadastrado(
                                valorCadastradoBD.getAllValorCadastradosPorCadastro(idCadastro)
                            );

                            for(ValorCadastrado valor : cadastro.getListaValorCadastrado()) {
                                TextView textIdValor = new TextView(this);
                                textIdValor.setPadding(10, 10, 0, 5);
                                textIdValor.setText("ID Valor: " + valor.getId());
                                layoutFormulario.addView(textIdValor);

                                TextView textValor = new TextView(this);
                                textValor.setPadding(10, 10, 0, 5);
                                textValor.setText("Valor Cadastrado: " + valor.getValorCadastrado());
                                layoutFormulario.addView(textValor);
                            }
                            */
                        }
                    } else {
                        Toast.makeText(this, "Não a Cadastro", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(this, "Formulario Perdido! ID:" + idFormulario, Toast.LENGTH_LONG).show();
                }

            }
        }

    }

    private void voltar() {
        Intent intent = new Intent(ExibirDadosCadastrados.this, DetalheFormularioActivity.class);
        intent.putExtra("idFormulario", this.formulario.getId());
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_exibir_dados_cadastrados, menu);

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
