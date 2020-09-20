package com.questionsanswers.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CadastroCoreBD extends SQLiteOpenHelper {

	private static final String NOME_BD = "questionsanswers";
	private static final int VERSAO_BD = 33;

	public CadastroCoreBD(Context ctx){
		super(ctx, NOME_BD, null, VERSAO_BD);
	}

    @Override
    public void onCreate(SQLiteDatabase bd) {
        StringBuffer sql = new StringBuffer();
        sql.append("CREATE TABLE cadastro( ");
        sql.append("  id INTEGER PRIMARY KEY AUTOINCREMENT,");
        sql.append("  id_formulario INTEGER NOT NULL,");
        sql.append("  imei TEXT NOT NULL,");
        sql.append("  data_hora TEXT NOT NULL,");
        sql.append("  latitude TEXT,");
        sql.append("  longitude TEXT");
        sql.append(" );");

        bd.execSQL(sql.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int arg1, int arg2) {
        bd.execSQL("DRO drop table cadastro;");
        onCreate(bd);
    }

}
