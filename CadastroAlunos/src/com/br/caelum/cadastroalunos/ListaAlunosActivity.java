package com.br.caelum.cadastroalunos;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.com.caelum.modelo.Aluno;

import com.br.caelum.cadastro.dao.AlunoDAO;

public class ListaAlunosActivity extends Activity {
	
	private ListView listaAlunos;
	private Aluno alunoSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listagem_alunos);                
        
        listaAlunos = (ListView) findViewById(R.id.lista_alunos);                     
        
        listaAlunos.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> adapter, View view,
					int position, long id) {
				alunoSelecionado = (Aluno) adapter.getItemAtPosition(position);
				return false;
			}
		});
        
        listaAlunos.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int position,
					long id) {
				
				Intent edicao = new Intent(ListaAlunosActivity.this,FormularioActivity.class);
				
				alunoSelecionado = (Aluno) adapter.getItemAtPosition(position); 
				
				edicao.putExtra("aluno", alunoSelecionado);
				
				startActivity(edicao);
			}
		});
        
        registerForContextMenu(listaAlunos);
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
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
    		ContextMenuInfo menuInfo) {
    	
    	MenuItem del = menu.add("Deletar");
    	del.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				AlunoDAO dao = new AlunoDAO(ListaAlunosActivity.this);
				dao.deletar(alunoSelecionado);
				dao.close();
				
				carregaLista();
				return false;
			}
		});
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
