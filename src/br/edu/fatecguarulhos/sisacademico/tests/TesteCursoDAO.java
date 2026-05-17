package br.edu.fatecguarulhos.sisacademico.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.edu.fatecguarulhos.sisacademico.daos.AlunoDAO;
import br.edu.fatecguarulhos.sisacademico.daos.CursoDAO;
import br.edu.fatecguarulhos.sisacademico.models.Aluno;
import br.edu.fatecguarulhos.sisacademico.models.Curso;

class TesteCursoDAO {

	private CursoDAO dao;
	TesteCursoDAO(){
		dao = new CursoDAO();
	}
	@Test
	void testBuscarAluno() {
		assertDoesNotThrow(()->{
			Curso c = dao.buscarCurso(1);
			System.out.println(c.getNome());
			System.out.println(c.getCampus());
		});
	}
	@Test
	void buscarAlunoNaoCadastrado() {
		assertThrows(Exception.class, ()->{
			dao.buscarCurso(0);
		});
	}

	@Test
	void testInserirAluno() {
		assertDoesNotThrow(()->{
				Curso curso = new Curso(1, "ADS", "Guarulhos", "Tarde");
				dao.inserirCurso(curso);
				assertNotNull(dao.buscarCurso(1));
			
		});
		
		
	}

}
