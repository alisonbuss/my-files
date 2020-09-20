
package com.questionsanswers.dao;

import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.questionsanswers.model.Cadastro;

public class CadastroBD {

	private SQLiteDatabase bd;
	
	public CadastroBD(Context context){
		CadastroCoreBD auxBd = new CadastroCoreBD(context);
		bd = auxBd.getWritableDatabase();
	}
	
	public long inserir(Cadastro cadastro){
		ContentValues valores = new ContentValues();
		valores.put("id_formulario", cadastro.getIdFormulario());
		valores.put("imei", cadastro.getImei());
		valores.put("data_hora", cadastro.getDataHora());
        valores.put("latitude", cadastro.getLatitude());
        valores.put("longitude", cadastro.getLongitude());
		
		return bd.insert("cadastro", null, valores);
	}
	
	public void atualizar(Cadastro cadastro){
        ContentValues valores = new ContentValues();
        valores.put("id_formulario", cadastro.getIdFormulario());
        valores.put("imei", cadastro.getImei());
        valores.put("data_hora", cadastro.getDataHora());
        valores.put("latitude", cadastro.getLatitude());
        valores.put("longitude", cadastro.getLongitude());

		bd.update("cadastro", valores, "id = ?", new String[]{ cadastro.getId()+"" });
	}

	public void deletar(Cadastro cadastro){
		bd.delete("cadastro", "id = " + cadastro.getId(), null);
	}
	
	public ArrayList<Cadastro> getAllCadastros(){
        ArrayList<Cadastro> list = new ArrayList<>();
		String[] colunas = new String[]{
            "id",
            "id_formulario",
            "imei",
            "data_hora",
            "latitude",
            "longitude"
        };
		
		Cursor cursor = bd.query("cadastro", colunas, null, null, null, null, "data_hora ASC");
		
		if(cursor.getCount() > 0){
			cursor.moveToFirst();
			do{
                Cadastro cadastro = new Cadastro();
                cadastro.setId(cursor.getInt(0));
                cadastro.setIdFormulario(cursor.getInt(1));
                cadastro.setDataHora(cursor.getString(2));
                cadastro.setImei(cursor.getString(3));
                cadastro.setLatitude(cursor.getString(4));
                cadastro.setLongitude(cursor.getString(5));
                list.add(cadastro);
			}while(cursor.moveToNext());
		}
		return(list);
	}

    public ArrayList<Cadastro> getAllCadastrosPorFormulario(long idFormulario){
        ArrayList<Cadastro> list = new ArrayList<>();
        String[] colunas = new String[]{
                "id",
                "id_formulario",
                "imei",
                "data_hora",
                "latitude",
                "longitude"
        };

        Cursor cursor = bd.query("cadastro", colunas, null, null, null, null, "data_hora ASC");

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                if(cursor.getInt(1) == idFormulario) {
                    Cadastro cadastro = new Cadastro();
                    cadastro.setId(cursor.getInt(0));
                    cadastro.setIdFormulario(cursor.getInt(1));
                    cadastro.setImei(cursor.getString(2));
                    cadastro.setDataHora(cursor.getString(3));
                    cadastro.setLatitude(cursor.getString(4));
                    cadastro.setLongitude(cursor.getString(5));
                    list.add(cadastro);
                }
            }while(cursor.moveToNext());
        }
        return(list);
    }
}
