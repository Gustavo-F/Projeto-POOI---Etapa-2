package kindle.entidades;

import java.util.ArrayList;

public class Livro {
	
	private String titulo;
	private ArrayList<Escritor> escritores;
	private Editora editora;
	private ArrayList<Genero> generos;
	private int paginas;
	
	public Livro(String titulo,  Editora editora) {
		this.titulo = titulo;
		this.escritores = new ArrayList<Escritor>();
		this.editora = editora;
		this.generos = new ArrayList<Genero>();
		this.paginas = 0;
	}

	public Livro(String titulo, Escritor escritor, Editora editora, Genero genero, int paginas) {
		this.setTitulo(titulo);
		this.escritores = new ArrayList<Escritor>();
		this.editora = editora;
		this.generos = new ArrayList<Genero>();
		this.paginas = paginas;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void adicionaEscritor(Escritor escritor) {
		for(int indice = 0; indice < escritores.size(); indice++) {
			if(escritores.get(indice).getNome().contentEquals(escritor.getNome()))
				return;		
		}
		escritores.add(escritor);
	}
	
	public ArrayList<Escritor> getEscritores() {
		return escritores;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Editora getEditora() {
		return editora;
	}
	
	public void adicionaGenero(Genero genero) {
		for(int indice = 0; indice < generos.size(); indice++) {
			if(generos.get(indice).getGenero().contentEquals(genero.getGenero()))
				return;
		}
		generos.add(genero);
	}
	
	public void removeGenero(Genero genero) {
		for(int indice = 0; indice < generos.size(); indice++) {
			if(generos.get(indice).getGenero().contentEquals(genero.getGenero())) {
				generos.remove(indice);
				return;
			}
		}
	}
	
	public ArrayList<Genero> getGeneros() {
		return generos;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	
	public int getPaginas() {
		return paginas;
	}
	
}
