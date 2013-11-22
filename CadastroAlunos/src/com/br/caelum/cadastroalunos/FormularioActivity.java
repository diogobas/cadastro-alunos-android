package com.br.caelum.cadastroalunos;

import com.br.caelum.cadastro.dao.AlunoDAO;

import br.com.caelum.modelo.Aluno;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class FormularioActivity extends Activity {
	
	private FormularioHelper helper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.formulario);
		
		this.helper = new FormularioHelper(this);
		
		Button botao = (Button) findViewById(R.id.botao);
		
		botao.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Adicionar aluno
				Aluno aluno = helper.pegaAlunoDoFormulario();
				
				Toast.makeText(FormularioActivity.this, "Objeto aluno criado" + aluno.getNome(), Toast.LENGTH_SHORT).show();
				
				AlunoDAO dao = new AlunoDAO(FormularioActivity.this);
				dao.insere(aluno);
				dao.close();
				
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.formulario, menu);
		return true;
	}

}
