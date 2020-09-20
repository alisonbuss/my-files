package com.questionsanswers.app;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

public class HomeActivity extends BaseActionBarActivity {

    private Toolbar toolbarHome;

    protected int getLayoutResourceId() {
        return R.layout.activity_home;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(this.getLayoutResourceId());

        // Attaching the layout to the toolbar object
        toolbarHome = (Toolbar) findViewById(R.id.toolbar_home);
        if (toolbarHome != null) {
            toolbarHome.setTitle("Questions & Answers");
            toolbarHome.setSubtitle("Home");
            toolbarHome.setLogo(R.drawable.logo_36dp);
            // Setting toolbar as the ActionBar with setSupportActionBar() call
            setSupportActionBar(toolbarHome);
        }
    }

    public void submeterTelaFormularios(View view){
        final FrameLayout loadingFL = (FrameLayout) findViewById(R.id.loadingFL);
        loadingFL.setVisibility(View.VISIBLE);

        final Intent intent = new Intent(this, ListaFormularioActivity.class);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
            loadingFL.setVisibility(View.GONE);
            startActivity(intent);
            }
        }, 900);
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
