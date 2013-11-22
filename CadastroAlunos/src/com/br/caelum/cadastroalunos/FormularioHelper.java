package com.br.caelum.cadastroalunos;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import br.com.caelum.modelo.Aluno;

public class FormularioHelper {
	private Aluno aluno;
	private EditText nome;
	private EditText telefone;
	private EditText endereco;
	private EditText site;
	private ImageView foto;
	private SeekBar nota;

	public FormularioHelper(FormularioActivity activity) {
		aluno = new Aluno();
		
		nome = (EditText) activity.findViewById(R.id.nome);
		telefone = (EditText) activity.findViewById(R.id.telefone);
		endereco = (EditText) activity.findViewById(R.id.endereco);
		site = (EditText) activity.findViewById(R.id.site);
		foto = (ImageView) activity.findViewById(R.id.foto);
		nota = (SeekBar) activity.findViewById(R.id.nota);
		
	}
	
	public Aluno pegaAlunoDoFormulario(){
		
		aluno.setNome(nome.getEditableText().toString());
		aluno.setTelefone(telefone.getEditableText().toString());
		aluno.setEndereco(endereco.getEditableText().toString());
		aluno.setSite(site.getEditableText().toString());
		aluno.setFoto(foto.toString());
		aluno.setNota(Double.valueOf(nota.getProgress()));
		
		return aluno;
	}

}
