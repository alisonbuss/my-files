
package com.questionsanswers.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.questionsanswers.model.Cadastro;
import com.questionsanswers.model.ValorCadastrado;

import java.util.ArrayList;

public class ValorCadastradoBD {

	private SQLiteDatabase bd;

	public ValorCadastradoBD(Context context){
        ValorCadastradoCoreBD auxBd = new ValorCadastradoCoreBD(context);
		bd = auxBd.getWritableDatabase();
	}
	
	public void inserir(ValorCadastrado valorCadastrado){
		ContentValues valores = new ContentValues();
		valores.put("id_cadastro", valorCadastrado.getIdCadastro());
		valores.put("id_campo_formulario", valorCadastrado.getIdCampoFormulario());
		valores.put("valor", valorCadastrado.getValorCadastrado());
		
		bd.insert("valor_cadastrado", null, valores);
	}
	
	public void atualizar(ValorCadastrado valorCadastrado){
        ContentValues valores = new ContentValues();
        valores.put("id_cadastro", valorCadastrado.getIdCadastro());
        valores.put("id_campo_formulario", valorCadastrado.getIdCampoFormulario());
        valores.put("valor", valorCadastrado.getValorCadastrado());

		bd.update("valor_cadastrado", valores, "id = ?", new String[]{ valorCadastrado.getId() + "" });
	}

	public void deletar(ValorCadastrado valorCadastrado){
		bd.delete("valor_cadastrado", "id = " + valorCadastrado.getId(), null);
	}
	
	public ArrayList<ValorCadastrado> getAllValorCadastrados(){
        ArrayList<ValorCadastrado> list = new ArrayList<>();
		String[] colunas = new String[]{
            "id",
            "id_cadastro",
            "id_campo_formulario",
            "valor"
        };

		Cursor cursor = bd.query("valor_cadastrado", colunas, null, null, null, null, "valor ASC");

		if(cursor.getCount() > 0){
			cursor.moveToFirst();
			do{
                ValorCadastrado valorCadastrado = new ValorCadastrado();
                valorCadastrado.setId(cursor.getInt(0));
                valorCadastrado.setIdCadastro(cursor.getInt(1));
                valorCadastrado.setIdCampoFormulario(cursor.getInt(2));
                valorCadastrado.setValorCadastrado(cursor.getString(3));
                list.add(valorCadastrado);
			}while(cursor.moveToNext());
		}
		return(list);
	}

    public ArrayList<ValorCadastrado> getAllValorCadastradosPorCadastro(long idCadastro){
        ArrayList<ValorCadastrado> list = new ArrayList<>();
        String[] colunas = new String[]{
                "id",
                "id_cadastro",
                "id_campo_formulario",
                "valor"
        };

        //Cursor cursor = bd.query("valor_cadastrado", colunas, null, null, null, null, "valor ASC");
        //String selectQuery = "SELECT id, id_cadastro, id_campo_formulario, valor FROM valor_cadastrado WHERE id_cadastro = ?;";
        //Cursor cursor = bd.rawQuery(selectQuery, new String[] { idCadastro+"" });
        String selectQuery = "SELECT id, id_cadastro, id_campo_formulario, valor FROM valor_cadastrado";
        Cursor cursor = bd.rawQuery(selectQuery, null);

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{

                    ValorCadastrado valorCadastrado = new ValorCadastrado();
                    valorCadastrado.setId(cursor.getInt(0));
                    valorCadastrado.setIdCadastro(cursor.getInt(1));
                    valorCadastrado.setIdCampoFormulario(cursor.getInt(2));
                    valorCadastrado.setValorCadastrado(cursor.getString(3));
                    list.add(valorCadastrado);

            }while(cursor.moveToNext());
        }
        return(list);
    }
}
