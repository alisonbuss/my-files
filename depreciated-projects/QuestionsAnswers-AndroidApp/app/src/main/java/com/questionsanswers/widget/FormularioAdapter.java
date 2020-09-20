package com.questionsanswers.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.questionsanswers.app.R;
import com.questionsanswers.model.Formulario;

import java.util.ArrayList;

public class FormularioAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<Formulario> lista;

	public FormularioAdapter(Context context, ArrayList<Formulario> lista){
		this.context = context;
		this.lista = lista;
	}
	
	@Override
	public int getCount() {
		return lista.size();
	}

	@Override
	public Object getItem(int position) {
		return lista.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

        Formulario formulario = lista.get(position);
		View layout;
		
		if(convertView == null){
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			layout = inflater.inflate(R.layout.listview_item_formulario, null);
		}
		else{
			layout = convertView;
		}

        ImageView iv = (ImageView) layout.findViewById(R.id.iv);
        iv.setImageResource(R.mipmap.ic_content_paste_grey600_36dp);

        ImageView next = (ImageView) layout.findViewById(R.id.next);
        next.setImageResource(R.mipmap.ic_chevron_double_right_grey600_36dp);

		TextView nomeFormulario = (TextView) layout.findViewById(R.id.t1);
        nomeFormulario.setText(formulario.getNome());
		
		TextView descricaoFormulario = (TextView) layout.findViewById(R.id.t2);
        descricaoFormulario.setText(formulario.getDescricao());

        /*
		if(position % 2 == 0){
			layout.setBackgroundColor(Color.YELLOW);
		}
		*/
		
		return layout;
	}

}
