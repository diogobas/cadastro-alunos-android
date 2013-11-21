package com.br.caelum.cadastroalunos;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListaAlunosActivity extends Activity {
	
	private ListView listaAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listagem_alunos);
        
        String[] alunos = {"Fulano","Ciclano","Beltrano"};
        
        listaAlunos = (ListView) findViewById(R.id.lista_alunos);
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,alunos);
        
        listaAlunos.setAdapter(adapter);
        
        listaAlunos.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int posicao,
					long id) {
				Toast.makeText(ListaAlunosActivity.this, "Posição selecionada:" + posicao, Toast.LENGTH_SHORT).show();
				
			}
		});
        
        listaAlunos.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> adapter, View view,
					int posicao, long id) {
				
				Toast.makeText(ListaAlunosActivity.this, "Posição LONGO selecionada:" + posicao, Toast.LENGTH_LONG).show();
				
				return false;
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	if(item.getItemId() == R.id.menu_novo){
    		Toast.makeText(ListaAlunosActivity.this, "novo", Toast.LENGTH_LONG).show();
    	}
    	return super.onOptionsItemSelected(item);
    }
    
}
