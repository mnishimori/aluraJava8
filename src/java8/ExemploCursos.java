package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExemploCursos {

	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
		System.out.println(cursos);
		
		cursos.stream()
			.filter(c -> c.getAlunos() > 50)
			.sorted(Comparator.comparing(Curso::getAlunos).reversed())
			.map(Curso::getNome)
			.forEach(System.out::println);
		
		Map<String, Integer> cursosMap = cursos.stream()
			.collect(Collectors.toMap(Curso::getNome, Curso::getAlunos));
		
		cursosMap.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos matriculados"));
	}

}

class Curso {
    private String nome;
    private int alunos;

	public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }
    
    @Override
	public String toString() {
		return "Curso [nome=" + nome + ", alunos=" + alunos + "]";
	}
}