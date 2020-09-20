package com.questionsanswers.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ValorCadastradoCoreBD extends SQLiteOpenHelper {

	private static final String NOME_BD = "questionsanswers";
	private static final int VERSAO_BD = 33;

	public ValorCadastradoCoreBD(Context ctx){
		super(ctx, NOME_BD, null, VERSAO_BD);
	}

    @Override
    public void onCreate(SQLiteDatabase bd) {
        StringBuffer sql = new StringBuffer();
        sql.append("CREATE TABLE valor_cadastrado( ");
        sql.append("  id INTEGER PRIMARY KEY AUTOINCREMENT,");
        sql.append("  id_cadastro INTEGER NOT NULL,");
        sql.append("  id_campo_formulario INTEGER NOT NULL,");
        sql.append("  valor TEXT NOT NULL,");
        sql.append("  FOREIGN KEY(id_cadastro) REFERENCES cadastro(id)");
        sql.append(" );");

        bd.execSQL(sql.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int arg1, int arg2) {
        bd.execSQL("DRO drop table valor_cadastrado;");
        onCreate(bd);
    }

}
