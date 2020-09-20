
package com.questionsanswers.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.questionsanswers.model.CampoFormulario;
import com.questionsanswers.model.Formulario;
import com.questionsanswers.model.TipoCampo;
import com.questionsanswers.service.FormularioService;
import com.questionsanswers.widget.FormularioAdapter;

import java.util.ArrayList;

public class ListaFormularioActivity extends BaseActionBarActivity {

    private Toolbar toolbarGeneric;
    private ListView formularioListView;
    private FormularioService formularioService = new FormularioService();

    protected int getLayoutResourceId() {
        return R.layout.activity_lista_formulario;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(this.getLayoutResourceId());

        // Attaching the layout to the toolbar object
        toolbarGeneric = (Toolbar) findViewById(R.id.toolbar_generic);
        if (toolbarGeneric != null) {
            toolbarGeneric.setTitle("Questions & Answers");
            toolbarGeneric.setSubtitle("Formularios");
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

        formularioListView = (ListView) findViewById(R.id.lv);
        formularioListView.setAdapter(new FormularioAdapter(this,formularioService.getAllFormularios()));
        formularioListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Formulario formulario = (Formulario) formularioListView.getAdapter().getItem(position);

                Intent intent = new Intent(getBaseContext(), DetalheFormularioActivity.class);
                intent.putExtra("idFormulario", formulario.getId());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_lista_formulario, menu);

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






























