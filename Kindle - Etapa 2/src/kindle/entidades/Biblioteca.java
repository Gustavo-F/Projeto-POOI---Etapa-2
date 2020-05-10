package kindle.entidades;

import java.util.ArrayList;

public class Biblioteca {

	private ArrayList<Livro> livros;

	public Biblioteca() {
		this.livros = new ArrayList<Livro>();
	}

	public void adicionarLivro(Livro livro) {
		for(int indice = 0; indice < livros.size(); indice++) {
			if(livros.get(indice).getTitulo().contentEquals(livro.getTitulo()))
				return;
		}
		livros.add(livro);
	}

	public void removeLivro(Livro livro) {
		for(int indice = 0; indice < livros.size(); indice++) {
			if(livros.get(indice).getTitulo().contentEquals(livro.getTitulo())) {
				livros.remove(indice);
				return;
			}
		}
	}

	public ArrayList<Livro> getLivro() {
		return livros;
	}

}
