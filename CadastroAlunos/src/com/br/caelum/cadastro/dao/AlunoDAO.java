package com.br.caelum.cadastro.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.modelo.Aluno;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AlunoDAO extends SQLiteOpenHelper {

	public AlunoDAO(Context context) {
		super(context, "CadastroAlunos", null, 1);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "CREATE TABLE Alunos (id INTEGER PRIMARY KEY," +
				"nome TEXT UNIQUE NOT NULL, telefone TEXT," +
				"endereco TEXT, site TEXT, nota REAL, foto TEXT);";
		db.execSQL(sql);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String sql = "DROP TABLE IF EXISTS Alunos";
		db.execSQL(sql);
		onCreate(db);
		
	}
	
	public void insere(Aluno aluno){
		ContentValues cv = new ContentValues();
		
		cv.put("nome", aluno.getNome());
		cv.put("telefone", aluno.getTelefone());
		cv.put("endereco", aluno.getEndereco());
		cv.put("site", aluno.getSite());
		cv.put("nota", aluno.getNota());
		cv.put("foto", aluno.getFoto());
		
		getWritableDatabase().insert("Alunos", null, cv);
	}
	
	public List<Aluno> getLista(){
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		String sql = "SELECT * FROM Alunos";
		
		Cursor c = getReadableDatabase().rawQuery(sql, null);
		
		while (c.moveToNext()) {
			Aluno aluno = new Aluno();
			
			aluno.setId(c.getLong(0));
			aluno.setNome(c.getString(1));
			aluno.setTelefone(c.getString(2));
			aluno.setEndereco(c.getString(3));			
			aluno.setSite(c.getString(4));
			aluno.setNota(c.getDouble(5));
			aluno.setFoto(c.getString(6));
			
			alunos.add(aluno);			
		}
		
		c.close();
		
		return alunos;
	}

}
