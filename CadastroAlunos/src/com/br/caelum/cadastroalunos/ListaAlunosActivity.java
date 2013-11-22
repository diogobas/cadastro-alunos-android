package com.br.caelum.cadastroalunos;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.com.caelum.modelo.Aluno;

import com.br.caelum.cadastro.dao.AlunoDAO;

public class ListaAlunosActivity extends Activity {
	
	private ListView listaAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listagem_alunos);                
        
        listaAlunos = (ListView) findViewById(R.id.lista_alunos);        
        
      //String[] alunos = {"Fulano","Ciclano","Beltrano"};
        
      //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,alunos);
                
        
//        listaAlunos.setOnItemClickListener(new OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?> adapter, View view, int posicao,
//					long id) {
//				Toast.makeText(ListaAlunosActivity.this, "Posição selecionada:" + posicao, Toast.LENGTH_SHORT).show();
//				
//			}
//		});
//        
//        listaAlunos.setOnItemLongClickListener(new OnItemLongClickListener() {
//
//			@Override
//			public boolean onItemLongClick(AdapterView<?> adapter, View view,
//					int posicao, long id) {
//				
//				Toast.makeText(ListaAlunosActivity.this, "Posição LONGO selecionada:" + posicao, Toast.LENGTH_LONG).show();
//				
//				return false;
//			}
//		});
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
    		//Toast.makeText(ListaAlunosActivity.this, "novo", Toast.LENGTH_LONG).show();
    		Intent i = new Intent(ListaAlunosActivity.this, FormularioActivity.class);
    		
    		startActivity(i);
    	}
    	return super.onOptionsItemSelected(item);
    }
    
    protected void onResume(){
    	super.onResume();
    	this.carregaLista();
    }
    
    private void carregaLista(){
    	AlunoDAO dao = new AlunoDAO(this);
        List<Aluno> alunos = dao.getLista();
               
        
        ArrayAdapter<Aluno> adapter = new ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1, alunos);
        
        listaAlunos.setAdapter(adapter);
    }
    
}
