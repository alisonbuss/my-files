package com.questionsanswers.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.questionsanswers.model.Formulario;
import com.questionsanswers.service.FormularioService;

public class DetalheFormularioActivity extends BaseActionBarActivity {

    private Toolbar toolbarGeneric;
    private Toolbar toolbarBottom;
    private Formulario formulario = null;

    private FormularioService formularioService = new FormularioService();

    protected int getLayoutResourceId() {
        return R.layout.activity_detalhe_formulario;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(this.getLayoutResourceId());

        // Attaching the layout to the toolbar object
        toolbarGeneric = (Toolbar) findViewById(R.id.toolbar_generic);
        if (toolbarGeneric != null) {
            toolbarGeneric.setTitle("Questions & Answers");
            toolbarGeneric.setSubtitle("Detalhe do Formulario");
            // Voltar
            toolbarGeneric.setNavigationIcon(R.mipmap.ic_arrow_left_bold_hexagon_outline_white_36dp);
            toolbarGeneric.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
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

                    TextView textView1 = (TextView) findViewById(R.id.textView1);
                    textView1.setText("Formulario ID: " + formulario.getId());

                    TextView textView2 = (TextView) findViewById(R.id.textView2);
                    textView2.setText(formulario.getNome());

                    TextView textView3 = (TextView) findViewById(R.id.textView3);
                    textView3.setText(formulario.getDescricao());

                    TextView textView4 = (TextView) findViewById(R.id.textView4);
                    textView4.setText("Quantidades de campos do formulario: " + formulario.getListaCampos().size());

                } else {
                    Toast.makeText(this, "Formulario Perdido! ID:" + idFormulario, Toast.LENGTH_LONG).show();
                }

            }
        }

    }

    public void submeterTelaCadastro(View view){
        final FrameLayout loadingFL = (FrameLayout) findViewById(R.id.loadingFL);
        loadingFL.setVisibility(View.VISIBLE);

        final Intent intent = new Intent(getBaseContext(), CadastrarFormularioActivity.class);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingFL.setVisibility(View.GONE);
                intent.putExtra("idFormulario", formulario.getId());
                startActivity(intent);
            }
        }, 900);
    }

    public void submeterTelaExibirCadastro(View view){
        final FrameLayout loadingFL = (FrameLayout) findViewById(R.id.loadingFL);
        loadingFL.setVisibility(View.VISIBLE);

        final Intent intent = new Intent(getBaseContext(), ExibirDadosCadastrados.class);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingFL.setVisibility(View.GONE);
                intent.putExtra("idFormulario", formulario.getId());
                startActivity(intent);
            }
        }, 900);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_detalhe_formulario, menu);

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
