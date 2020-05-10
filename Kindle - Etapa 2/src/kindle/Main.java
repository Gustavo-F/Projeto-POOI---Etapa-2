package kindle;

import java.util.ArrayList;
import java.util.Scanner;

import kindle.entidades.Administrador;
import kindle.entidades.Biblioteca;
import kindle.entidades.Cliente;
import kindle.entidades.Editora;
import kindle.entidades.Escritor;
import kindle.entidades.Genero;
import kindle.entidades.Livro;

@SuppressWarnings("unused")
public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner leString = new Scanner(System.in);
		Scanner leInt = new Scanner(System.in);

		ArrayList<Genero> generos = new ArrayList<Genero>();
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		ArrayList<Administrador> adms = new ArrayList<Administrador>();
		ArrayList<Livro> livros = new ArrayList<Livro>();
		ArrayList<Escritor> escritores = new ArrayList<Escritor>();
		ArrayList<Editora> editoras = new ArrayList<Editora>();

		Biblioteca bibliotecaCliente = null;

		int paginas, continua = 1, menuInicial, i, j, verificaUsuario;
		String login, nome, email, senha, titulo, genero, cnpj;

		do {

//			clearBuffer(leString);

			System.out.println("------Menu------");
			System.out.println("1 - Fazer login como administrador");
			System.out.println("2 - Criar login administrativo");
			System.out.println("3 - Fazer login como cliente");
			System.out.println("4 - Criar login de cliente");

			System.out.println("\nInforme a opção escolhida:");
			menuInicial = leInt.nextInt();

			switch(menuInicial) {

			case 1:;

			int menuAdministrativo, continuaADM = 1, menuLivros, menuEscritores, menuEditoras, menuGeneros, teste = 1;
			while(continuaADM == 1) {

				while(teste == 1) {

					System.out.println("Login:");
					login = leString.next();

					System.out.println("Senha:");
					senha = leString.next();

					for(int indice = 0; indice < adms.size(); indice++) {
						if(adms.get(indice).verificaUsuario(login, senha)) {
							//								System.out.println(adms.get(indice).verificaUsuario(login, senha));
							System.out.println("Login realizado com sucesso!");
							teste = 0;
							break;
						}
					}

					if(teste != 0)
						System.out.println("Login ou senha incorretos, tente novamente!\n");

				}

				do {

					int loopEditoras = 1, loopLivros = 1, loopEscritores = 1, loopGeneros = 1;

					System.out.println("\nMenu Administrativo\n");
					System.out.println("1 - Sessão dos livros");
					System.out.println("2 - Sessão dos escritores");
					System.out.println("3 - Sessão das editoras");
					System.out.println("4 - Sessão dos generos");
					System.out.println("5 - Logout");

					System.out.println("Informe a opção escolhida:");
					menuAdministrativo = leInt.nextInt();

					switch(menuAdministrativo) {

					case 1:

						do {

							int loopAddEscritores = 1, loopAddGeneros = 1;
//							clearBuffer(leString);

							System.out.println("1 - Cadastrar livro");
							System.out.println("2 - Buscar livro");
							System.out.println("3 - Listar todos os livros");
							System.out.println("4 - Deletar livro");
							System.out.println("5 - Atualizar livro");
							System.out.println("6 - Voltar ao menu administrativo");

							System.out.println("Informe a opção escolhida:");
							menuLivros = leInt.nextInt();

							int teste2 = 1, verificaEditora = 1;

							switch(menuLivros) {

							case 1:

								Livro novoLivro = new Livro(null, null);

								System.out.println("Titulo:");
								titulo = leString.next();
								novoLivro.setTitulo(titulo);

								System.out.println("Editora:");
								String nomeEditora = leString.next();

								for(i = 0; i < editoras.size(); i++) {
									if(editoras.get(i).getNome().equalsIgnoreCase(nomeEditora)) {
										novoLivro.setEditora(editoras.get(i));
										verificaEditora = 0;
										break;
									}
								}

								if(verificaEditora == 1) {
									System.out.println("Editora iformada não está cadastrada, tente novamente!");
									break;
								}

								adicionarEscritorLivro(novoLivro, escritores);

								System.out.println("Definir generos? (S/N)");
								String defineGeneros = leString.next();

								if(defineGeneros.equalsIgnoreCase("s")) {

									adicionaGeneroLivro(generos, novoLivro);

								}

								System.out.println("Definir número de páginas? (S/N)");
								String definePaginas = leString.next();
								if(definePaginas.equalsIgnoreCase("S")) {
									novoLivro.setPaginas(leInt.nextInt());
								}else {
									novoLivro.setPaginas(0);
								}

								livros.add(novoLivro);

								break;

							case 2:

								System.out.println("Titulo do livro:");
								titulo = leString.next();

								buscarLivro(livros, titulo);

								break;

							case 3:

								listarLivros(livros);

								break;

							case 4:

								System.out.println("Titulo do livro:");
								titulo = leString.next();

								deletarLivro(livros, titulo);

								break;

							case 5:

								Livro enderecoLivro = null;

								System.out.println("Titulo do livro:");
								titulo = leString.next();

								for(i = 0; i < livros.size(); i++) {
									if(livros.get(i).getTitulo().equalsIgnoreCase(titulo)) {
										enderecoLivro = livros.get(i);
										break;
									}
								}

								atualizarLivro(enderecoLivro, editoras, generos, escritores);

								break;

							case 6:

								System.out.println("Deseja realmente voltar ao menu administrativo? (S/N)");
								String logoutLivros = leString.next();

								if(logoutLivros.equalsIgnoreCase("s"))
									loopLivros = 0;

								break;

							default:
								break;

							}

						}while(loopLivros == 1);

						break; 

					case 2:

						do {

							System.out.println("1 - Cadastrar escritor");
							System.out.println("2 - Buscar escritor");
							System.out.println("3 - Listar escritores cadastrados");
							System.out.println("4 - Deletar escritor");
							System.out.println("5 - Atualizar escritor");
							System.out.println("6 - Voltar ao menu administrativo");

							System.out.println("Informe a opção escolhida:");
							menuEscritores = leInt.nextInt();

							switch(menuEscritores) {

							case 1:

								System.out.println("Nome do escritor:");
								nome = leString.next();

								System.out.println("Email:");
								email = leString.next();

								Escritor novoEscritor = new Escritor(nome, email);
								escritores.add(novoEscritor);

								break;

							case 2:

								if(escritores.size() == 0) {
									System.out.println("Nenhum escritor cadastrado!");
									break;
								}

								System.out.println("Nome do escritor:");
								nome = leString.next();

								buscarEscritor(escritores, nome);

								break;

							case 3:

								listarEscritores(escritores);

								break;

							case 4:

								System.out.println("Nome do escritor:");
								nome = leString.next();

								deletarEscritor(escritores, nome);

								break;

							case 5:

								System.out.println("Nome do escritor:");
								nome = leString.next();

								for(i = 0; i < escritores.size(); i++) {
									if(escritores.get(i).getNome().equalsIgnoreCase(nome)) {
										if(atualizarEscritor(escritores, i) == 1) 
											System.out.println("Escritor atualizado com sucesso!");

										break;
									}
								}

								break;

							case 6:

								System.out.println("Deseja realmente voltar ao menu administrativo? (S/N)");
								String logoutEscritores = leString.next();

								if(logoutEscritores.equalsIgnoreCase("S"))
									loopEscritores = 0;

								break;

							default:
								break;

							}

						}while(loopEscritores == 1);

						break;

					case 3:

						do {
							
							Scanner editora = new Scanner(System.in);

							System.out.println("1 - Cadastrar editora");
							System.out.println("2 - Buscar editora");
							System.out.println("3 - Listar editoras cadastradas");
							System.out.println("4 - Deletar editora");
							System.out.println("5 - Atualizar editora");
							System.out.println("6 - Voltar ao menu administrativo");

							System.out.println("Informe a opção escolhida:");
							menuEditoras = leInt.nextInt();

							switch(menuEditoras) {

							case 1:

								System.out.println("Nome da editora:");
								nome = editora.next();

								System.out.println("Email de contato: ");
								email = leString.next();

								System.out.println("CNPJ:");
								cnpj = leString.next();

								Editora novaEditora = new Editora(nome, email, cnpj);
								editoras.add(novaEditora);

								break;

							case 2:

								if(editoras.size() == 0) {
									System.out.println("Nenhuma editora cadastrada!");
									break;
								}

								System.out.println("Nome da editora:");
								nome = leString.next();

								for(i = 0; i < editoras.size(); i++) {
									if(editoras.get(i).getNome().equalsIgnoreCase(nome)) {
										System.out.println("Nome: " + editoras.get(i).getNome() + "\tEmail: " + editoras.get(i).getEmail()
												+ "\tCNPJ: " + editoras.get(i).getCnpj());
									}
								}

								break;

							case 3:

								if(editoras.size() == 0) {
									System.out.println("Nenhuma editora cadastrada!");
									break;
								}

								listarEditoras(editoras);

								break;

							case 4:

								System.out.println("Nome da editora:");
								nome = leString.next();

								deletaEditora(editoras, nome);

								break;

							case 5:

								System.out.println("Nome da editora:");
								nome = leString.next();

								for(i = 0; i < editoras.size(); i++) {
									if(editoras.get(i).getNome().equalsIgnoreCase(nome)) {
										if(atualizarEditora(editoras, i) == 1) 
											System.out.println("Editora atualizada com sucesso!");

										break;
									}
								}

								break;

							case 6:

								System.out.println("Deseja realmente voltar ao menu administrativo? (S/N)");
								String logoutEditoras = leString.next();

								if(logoutEditoras.equalsIgnoreCase("S"))
									loopEditoras = 0;

								break;

							default:
								break;

							}

						}while(loopEditoras == 1);

						break; 

					case 4:

						do {

							System.out.println("\n1 - Cadastrar genero");
							System.out.println("2 - Buscar genero");
							System.out.println("3 - Listar generos cadastrados");
							System.out.println("4 - Remover genero cadastrado");
							System.out.println("5 - Voltar ao menu administrativo");

							System.out.println("Informe a opção escolhida:");
							menuGeneros = leInt.nextInt();

							switch(menuGeneros) {

							case 1:

								System.out.println("Genero:");
								genero = leString.next();

								Genero novoGenero = new Genero(genero);
								generos.add(novoGenero);

								break;

							case 2:

								System.out.println("Genero: ");
								genero = leString.next();

								buscarGenero(generos, genero);

								break;

							case 3:

								listarGeneros(generos);

								break;

							case 4:
								
								System.out.println("Genero a ser removido:");
								genero = leString.next();
								deletarGenero(generos, genero);
								
								break;
								
							case 5:

								System.out.println("Deseja realmente voltar ao menu administrativo? (S/N)");
								String logoutGeneros = leString.next();

								if(logoutGeneros.equalsIgnoreCase("S"))
									loopGeneros = 0;

								break;

							}

						}while(loopGeneros == 1);

						break;

					case 5:

						System.out.println("Deseja realmente sair? (S/N)");
						String logoutADM = leString.next();

						if(logoutADM.equalsIgnoreCase("S"))
							continuaADM = 0;

						break;
					}

				}while(continuaADM == 1); 
				if(continuaADM == 0)
					continuaADM = 0;
			}

			break;

			case 2:
				
				Scanner leADM = new Scanner(System.in);

				System.out.println("Nome:");
				nome = leADM.next();

				System.out.println("Email:");
				email = leString.next();

				verificaUsuario = 1;

				do {

					System.out.println("Login:");
					login = leString.next();

					if(verificaAdministrador(adms, login) == 0) {
						verificaUsuario = 0;
					}else {
						System.out.println("Este login já está em uso!");
					}

				}while(verificaUsuario == 1);

				System.out.println("Senha:");
				senha = leString.next();

				while(senha.length() < 6) {
					System.out.println("A senha deve no minímo 6 caracteres. Digite novamente:");
					senha = leString.next();
				}

				Administrador novoAdm = new Administrador(nome, email, login, senha);

				adms.add(novoAdm);

				break;

			case 3:

				int menuCliente, menuBiblioteca,continuaCliente = 1, continuaBiblioteca = 1, loginCliente = 1; 

				while(loginCliente == 1) {
					System.out.println("Login:");
					login = leString.next();

					System.out.println("Senha:");
					senha = leString.next();

					for(i = 0; i < clientes.size(); i++) {
						if(clientes.get(i).verificaUsuario(login, senha)) {
							System.out.println("Login realizado com sucesso!");
							bibliotecaCliente = clientes.get(i).getBiblioteca();
							loginCliente = 0;
							break;
						}
					}

					if(loginCliente != 0) 
						System.out.println("Login ou senha incorretos, tente novamente!");
				}

				do {

					System.out.println("\nMenu do Cliente\n");
					System.out.println("1 - Acessar Biblioteca");
					System.out.println("2 - Buscar livro");
					System.out.println("3 - Logout");

					System.out.println("Informe a opção escolhida:");
					menuCliente = leInt.nextInt();

					switch(menuCliente) {

					case 1:

						do {

//							clearBuffer(leString);

							System.out.println("1 - Adicionar livro na biblioteca");
							System.out.println("2 - Buscar livro já adicionado");
							System.out.println("3 - Listar todos os livros da biblioteca");
							System.out.println("4 - Remover livro");
							System.out.println("5 - Voltar ao menu do cliente");

							System.out.println("Informe a opção escolhida:");
							menuBiblioteca = leInt.nextInt();

							switch(menuBiblioteca) {

							case 1:

								System.out.println("Titulo do livro:");
								titulo = leString.next();

								adicionarLivroBiblioteca(bibliotecaCliente, livros, titulo);

								break;

							case 2:

								System.out.println("Titulo do livro:");
								titulo = leString.next();

								buscaLivroBiblioteca(bibliotecaCliente, titulo);

								break;

							case 3:

								listarLivrosBiblioteca(bibliotecaCliente);

								break;

							case 4:

								System.out.println("Titulo do livro:");
								titulo = leString.next();

								removerLivroBiblioteca(bibliotecaCliente, titulo);

								break;

							case 5:

								System.out.println("Deseja realmente voltar ao menu do cliente? (S/N)");
								String logoutBiblioteca = leString.next();

								if(logoutBiblioteca.equalsIgnoreCase("s"))
									continuaBiblioteca = 0;

								break;

							}

						}while(continuaBiblioteca == 1);

						break;

					case 2:

						System.out.println("Titulo do livro");
						titulo = leString.next();

						buscarLivro(livros, titulo);

						break;

					case 3:

						System.out.println("Deseja realmente sair? (S/N)");
						String logoutCliente = leString.next();

						if(logoutCliente.equalsIgnoreCase("S"))
							continuaCliente = 0;

						break;

					default:
						System.out.println("Opção indisponível, tente novamente!");
						break;

					}

				}while(continuaCliente == 1);

				break;

			case 4:

				verificaUsuario = 1;
				
				Scanner leNome = new Scanner(System.in);

				System.out.println("Nome:");
				nome = leNome.next();

				System.out.println("Email:");
				email = leString.next();

				do {

					System.out.println("Login:");
					login = leString.next();

					if(verificaClientes(clientes, login) == 0) {
						verificaUsuario = 0;
					}else {
						System.out.println("Este login já está em uso!");
					}

				}while(verificaUsuario == 1);

				System.out.println("Senha:");
				senha = leString.next();
				
				while(senha.length() < 6) {
					System.out.println("A senha deve no minímo 6 caracteres. Digite novamente:");
					senha = leString.next();
				}

				Cliente novoClinente = new Cliente(nome, email, login, senha, new Biblioteca());

				clientes.add(novoClinente);

				break;

			default:

				System.out.println("Opção indisponível. Tente novamente.");
				break;
			}

		}while(continua == 1);

	}

	private static void clearBuffer(Scanner scanner) {
		if (scanner.hasNextLine()) {
			scanner.nextLine();
		}
	}

	// Editoras
	private static void listarEditoras(ArrayList<Editora> editoras) {
		if(editoras.size() == 0) {
			System.out.println("Nenhuma editora cadastrada!");
			return;
		}

		for(int indice = 0; indice < editoras.size(); indice++) {
			System.out.println("\nNome:" + editoras.get(indice).getNome() + "\tEmail: " + editoras.get(indice).getEmail() 
					+ "\tCNPJ: " + editoras.get(indice).getCnpj());
		}	
	}

	private static void buscarEditora(ArrayList<Editora> editoras, String nomeEditora) {
		if(editoras.size() == 0) {
			System.out.println("Nenhuma editora cadastrada!");
			return;
		}

		for(int indice = 0; indice < editoras.size(); indice++) {
			if(editoras.get(indice).getNome().equalsIgnoreCase(nomeEditora)) {
				System.out.println("\nNome:" + editoras.get(indice).getNome() + "Email: " + editoras.get(indice).getEmail() 
						+ "CNPJ: " + editoras.get(indice).getCnpj());
				break;
			}
		}
	}

	private static void deletaEditora(ArrayList<Editora> editoras, String nomeEditora) {
		if(editoras.size() == 0) {
			System.out.println("Nenhuma editora cadastrada!");
			return;
		}
		for(int indice = 0; indice < editoras.size(); indice++) {
			if(editoras.get(indice).getNome().equalsIgnoreCase(nomeEditora)) {
				editoras.remove(indice);
				System.out.println("Editora deletada com sucesso!");
				break;
			}
		}

	}

	@SuppressWarnings("resource")
	private static int atualizarEditora(ArrayList<Editora> editoras, int indice) {

		if(editoras.size() == 0) {
			System.out.println("Nenhuma editora cadastrada!");
			return 0;
		}

		String nome, email, cnpj, escolha;
		Scanner leString = new Scanner(System.in);
		Scanner reader = new Scanner(System.in);

		System.out.println("Atualizar nome? (S/N)");
		escolha = leString.next();
		if(escolha.equalsIgnoreCase("S")) {
			System.out.println("Novo nome:");
			nome = reader.next();
			editoras.get(indice).setNome(nome);
		}
		System.out.println("Atualizar email? (S/N)");
		escolha = leString.next();
		if(escolha.equalsIgnoreCase("S")) {
			System.out.println("Novo email:");
			email = leString.next();
			editoras.get(indice).setEmail(email);		
		}

		System.out.println("Atualizar CNPJ? (S/N)");
		escolha = leString.next();
		if(escolha.equalsIgnoreCase("S")) {
			System.out.println("Novo CNPJ:");
			cnpj = leString.next();
			editoras.get(indice).setCnpj(cnpj);
		}

		return 1;
	}

	// Escritores
	private static void listarEscritores(ArrayList<Escritor> escritores) {
		if(escritores.size() == 0) {
			System.out.println("Nenhum escritor cadastrado!");
			return;
		}

		for(int indice = 0; indice < escritores.size(); indice++) {
			System.out.println("Nome: " + escritores.get(indice).getNome() + "\tEmail: " + escritores.get(indice).getEmail());
		}
	}

	private static void buscarEscritor(ArrayList<Escritor> escritores, String nome) {
		if(escritores.size() == 0) {
			System.out.println("Nenhum escritor cadastrado!");
			return;
		}

		for(int indice = 0; indice < escritores.size(); indice++) {
			if(escritores.get(indice).getNome().equalsIgnoreCase(nome)) {
				System.out.println("\nNome: " + escritores.get(indice).getNome() + "\tEmail: " + escritores.get(indice).getEmail());
				break;
			}
		}
	}

	private static void deletarEscritor(ArrayList<Escritor> escritores, String nome) {
		if(escritores.size() == 0) {
			System.out.println("Nenhum escritor cadastrado!");
			return;
		}

		for(int indice = 0; indice < escritores.size(); indice++) {
			if(escritores.get(indice).getNome().equalsIgnoreCase(nome)) {
				escritores.remove(indice);
				System.out.println("Escritor removido com sucesso!");
				break;
			}
		}
	}

	@SuppressWarnings("resource")
	private static int atualizarEscritor(ArrayList<Escritor> escritores, int indice) {
		if(escritores.size() == 0) {
			System.out.println("Nenhum escritor cadastrado!");
			return 0;
		}

		String nome, email, escolha;
		Scanner leString = new Scanner(System.in);

		System.out.println("Atualizar nome? (S/N)");
		escolha = leString.next();
		if(escolha.equalsIgnoreCase("s")) {
			System.out.println("Novo nome:");
			nome = leString.next();
			escritores.get(indice).setNome(nome);
		}

		System.out.println("Atualizar email? (S/N)");
		escolha = leString.next();
		if(escolha.equalsIgnoreCase("S")) {
			System.out.println("Novo email:");
			email = leString.next();
			escritores.get(indice).setEmail(email);
		}

		return 1;

	}
	// Generos
	private static void listarGeneros(ArrayList<Genero> generos) {
		if(generos.size() == 0) {
			System.out.println("Nenhum genero cadastrado!");
			return;
		}

		System.out.println("\nGeneros:");
		for(int indice = 0; indice < generos.size(); indice++) {
			System.out.println(generos.get(indice).getGenero());
		}
	}

	private static void buscarGenero(ArrayList<Genero> generos, String genero) {
		if(generos.size() == 0) {
			System.out.println("Nenhum genero cadastrado!");
			return;
		}

		for(int indice = 0; indice < generos.size(); indice++) {
			if(generos.get(indice).getGenero().equalsIgnoreCase(genero)) {
				System.out.println("\nGenero: " + generos.get(indice).getGenero());
				break;
			}
		}
	}

	private static void deletarGenero(ArrayList<Genero> generos, String genero) {
		if(generos.size() == 0) {
			System.out.println("Nenhum genero cadastrado!");
			return;
		}

		for(int indice = 0; indice < generos.size(); indice++) {
			if(generos.get(indice).getGenero().equalsIgnoreCase(genero)) {
				generos.remove(indice);
				System.out.println("Genero removido com sucesso!");
				break;
			}
		}
	}

	// Livros
	private static void listarLivros(ArrayList<Livro> livros) {
		if(livros.size() == 0) {
			System.out.println("Nenhum livro cadastrado!");
			return;
		}

		int indice, indiceY, indiceX;

		for(indice = 0; indice < livros.size(); indice++) {
			System.out.println("\nTitulo: " + livros.get(indice).getTitulo() + "\nEscritor(es):");

			for(indiceY = 0; indiceY < livros.get(indice).getEscritores().size(); indiceY++) {
				System.out.println(livros.get(indice).getEscritores().get(indiceY).getNome());
			}

			System.out.println("Generos:");
			for(indiceX = 0; indiceX < livros.get(indice).getGeneros().size(); indiceX++) {
				System.out.println(livros.get(indice).getGeneros().get(indiceX).getGenero());
			}

			System.out.println("Editora: " + livros.get(indice).getEditora().getNome() + "\tPáginas: " + livros.get(indice).getPaginas());
		}
	}

	private static void buscarLivro(ArrayList<Livro> livros, String titulo) {
		if(livros.size() == 0) {
			System.out.println("Nenhum livro cadastrado!");
			return;
		}

		int indice, indiceY, indiceX;

		System.out.println("\n");
		for(indice = 0; indice < livros.size(); indice++) {
			if(livros.get(indice).getTitulo().equalsIgnoreCase(titulo)) {
				System.out.println("Titulo: " + livros.get(indice).getTitulo() + "\nEscritor(es):");

				for(indiceY = 0; indiceY < livros.get(indice).getEscritores().size(); indiceY++) {
					System.out.println(livros.get(indice).getEscritores().get(indiceY).getNome());
				}

				System.out.println("Generos:");
				for(indiceX = 0; indiceX < livros.get(indice).getGeneros().size(); indiceX++) {
					System.out.println(livros.get(indice).getGeneros().get(indiceX).getGenero());
				}

				System.out.println("Editora: " + livros.get(indice).getEditora().getNome() + "\tPáginas: " + livros.get(indice).getPaginas());
			}
		}
	}

	private static void deletarLivro(ArrayList<Livro> livros, String titulo) {
		if(livros.size() == 0) {
			System.out.println("Nenhum livro cadastrado!");
			return;
		}

		for(int indice = 0; indice < livros.size(); indice++) {
			if(livros.get(indice).getTitulo().equalsIgnoreCase(titulo)) {
				livros.remove(indice);
				System.out.println("Livro removido com sucesso!");
				break;
			}
		}
	}

	private static void adicionarEscritorLivro(Livro livro, ArrayList<Escritor> escritores) {

		@SuppressWarnings("resource")
		Scanner leString = new Scanner(System.in);
		String nome, escolha;
		int loopAddEscritor = 1, obs;

		do {

			obs = 0;

			System.out.println("Nome do escritor:");
			nome = leString.next();

			for(int indice = 0; indice < escritores.size(); indice++) {
				if(escritores.get(indice).getNome().equalsIgnoreCase(nome)) {
					livro.adicionaEscritor(escritores.get(indice));
					obs = 1;
					break;
				}
			}

			if(obs == 0) {
				System.out.println("Escritor não cadastrado. Tentar novamente? (S/N)");
				escolha = leString.next();
			}else {
				System.out.println("Escritor adicionado com sucesso!" + "\nDeseja adicionar outro escritor? (S/N)");
				escolha = leString.next();
			}

			if(!escolha.equalsIgnoreCase("S"))
				loopAddEscritor = 0;

		}while(loopAddEscritor == 1);

	}

	@SuppressWarnings("resource")
	private static void adicionaGeneroLivro(ArrayList<Genero> generos, Livro livro) {

		if(generos.size() == 0) {
			System.out.println("Nenhum genero cadastrado!");
			return;
		}

		Scanner leString = new Scanner(System.in);
		String genero, escolha;
		int indice, loopAddGenero = 1, aux;

		do {

			aux = 0;

			System.out.println("Genero: ");
			genero = leString.next();

			for(indice = 0; indice < generos.size(); indice++) {
				if(generos.get(indice).getGenero().equalsIgnoreCase(genero)) {
					livro.adicionaGenero(generos.get(indice));
					aux = 1;
					break;
				}
			}

			if(aux == 1) {
				System.out.println("Genero adicionado com sucesso!" + "\nAdicionar outro genero?(S/N)");
			}else {
				System.out.println("Genero não cadastrado!" + "\nTentar novamente? (S/N)");
			}
			escolha = leString.next();
			if(!escolha.equalsIgnoreCase("S"))
				loopAddGenero = 0;

		}while(loopAddGenero == 1);
	}

	@SuppressWarnings("resource")
	private static void atualizarLivro(Livro livro, ArrayList<Editora> editoras, ArrayList<Genero> generos, ArrayList<Escritor> escritores) {

		Scanner leString = new Scanner(System.in);
		Scanner leInt = new Scanner(System.in);
		int escolha, loopEditora = 1;

		System.out.println("1 - Atualizar titulo");
		System.out.println("2 - Atualizar editora");
		System.out.println("3 - Atualiar número de páginas");
		System.out.println("4 - Adicionar genero");
		System.out.println("5 - Remover genero");
		System.out.println("6 - Adicionar escritor");
		System.out.println("7 - Remover escritor");

		System.out.println("Informe a opção escolhida:");
		escolha = leInt.nextInt();

		switch(escolha) {

		case 1:
			System.out.println("Novo titulo:");
			livro.setTitulo(leString.next());
			break;

		case 2:

			do {

				System.out.println("Editora");
				String editora = leString.next();

				for(int i = 0; i < editoras.size(); i++) {
					if(editoras.get(i).getNome().equalsIgnoreCase(editora)) {
						livro.setEditora(editoras.get(i));
						System.out.println("Alteração realizada com sucesso!");
						loopEditora = 0;
						break;
					}
				}

				if(loopEditora == 1) {
					System.out.println("Editora não encontrada, tentar novamente? (S/N)");
					String aux = leString.next();

					if(!aux.equalsIgnoreCase("s"))
						loopEditora = 0;
				}

			}while(loopEditora == 1);			
			break;

		case 3:
			System.out.println("Número de páginas:");
			livro.setPaginas(leInt.nextInt());
			break;

		case 4:
			adicionaGeneroLivro(generos, livro);
			break;

		case 5:
			System.out.println("Genero:");
			String genero = leString.next();
			removerGeneroLivro(livro, genero);
			break;

		case 6:
			adicionarEscritorLivro(livro, escritores);
			break;

		case 7:
			System.out.println("Nome do escritor");
			String nomeEscritor = leString.next();
			removerEscritorLivro(livro, nomeEscritor);
			break;
		}
	}

	private static void removerGeneroLivro(Livro livro, String genero) {
		for(int indice = 0; indice < livro.getGeneros().size(); indice++) {
			if(livro.getGeneros().get(indice).getGenero().equalsIgnoreCase(genero)) {
				livro.getGeneros().remove(indice);
				System.out.println("Genero removido com sucesso!");
				return;
			}
		}
	}

	private static void removerEscritorLivro(Livro livro, String nomeEscritor) {
		for(int indice = 0; indice < livro.getEscritores().size(); indice++) {
			if(livro.getEscritores().get(indice).getNome().equalsIgnoreCase(nomeEscritor)) {
				livro.getEscritores().remove(indice);
				System.out.println("Escritor removido com sucesso!");
				return;
			} 
		}
	}

	// Biblioteca
	private static void adicionarLivroBiblioteca(Biblioteca biblioteca, ArrayList<Livro> livros, String titulo) {
		if(livros.size() == 0) {
			System.out.println("Nenhum livro cadastrado!");
			return;
		}

		for(int indice = 0; indice < livros.size(); indice++) {
			if(livros.get(indice).getTitulo().equalsIgnoreCase(titulo)) {
				biblioteca.adicionarLivro(livros.get(indice));
			}
		}
	}

	private static void listarLivrosBiblioteca(Biblioteca biblioteca) {
		if(biblioteca.getLivro().size() == 0) {
			System.out.println("Nenhum livro atribuido a sua biblioteca!");
			return;
		}

		for(int indice = 0; indice < biblioteca.getLivro().size(); indice++) {
			
			System.out.println("Titulo: " + biblioteca.getLivro().get(indice).getTitulo() 
					+ "\tEditora: " + biblioteca.getLivro().get(indice).getEditora().getNome());
			
			System.out.println("Escritores:");
			for(int indiceX = 0; indiceX < biblioteca.getLivro().get(indice).getEscritores().size(); indiceX++) {
				System.out.println("Nome: " + biblioteca.getLivro().get(indice).getEscritores().get(indiceX).getNome());
			}
			
			System.out.println("Generos:");
			for(int indiceY = 0; indiceY < biblioteca.getLivro().get(indice).getGeneros().size(); indiceY++) {
				System.out.println("Genero: " + biblioteca.getLivro().get(indice).getGeneros().get(indiceY).getGenero());
			}
			
			System.out.println("Páginas: " + biblioteca.getLivro().get(indice).getPaginas());
		}
	}

	private static void removerLivroBiblioteca(Biblioteca biblioteca, String titulo) {
		if(biblioteca.getLivro().size() == 0) {
			System.out.println("Nenhum livro atribuido a sua biblioteca!");
			return;
		}

		for(int indice = 0; indice < biblioteca.getLivro().size(); indice++) {
			if(biblioteca.getLivro().get(indice).getTitulo().equalsIgnoreCase(titulo)) {
				biblioteca.getLivro().remove(indice);
				System.out.println("Livro removido da biblioteca com sucesso!");
				break;
			}
		}

		System.out.println("Livro não encontrado!");
	}

	private static void buscaLivroBiblioteca(Biblioteca biblioteca, String titulo) {
		if(biblioteca.getLivro().size() == 0) {
			System.out.println("Nenhum livro atribuido a sua biblioteca!");
			return;
		}

		for(int indice = 0; indice < biblioteca.getLivro().size(); indice++) {
			if(biblioteca.getLivro().get(indice).getTitulo().equalsIgnoreCase(titulo)) {
				System.out.println("Titulo: " + biblioteca.getLivro().get(indice).getTitulo() 
						+ "\tEditora: " + biblioteca.getLivro().get(indice).getEditora().getNome());
				
				System.out.println("Escritores:");
				for(int indiceX = 0; indiceX < biblioteca.getLivro().get(indice).getEscritores().size(); indiceX++) {
					System.out.println("Nome: " + biblioteca.getLivro().get(indice).getEscritores().get(indiceX).getNome());
				}
				
				System.out.println("Generos:");
				for(int indiceY = 0; indiceY < biblioteca.getLivro().get(indice).getGeneros().size(); indiceY++) {
					System.out.println("Genero: " + biblioteca.getLivro().get(indice).getGeneros().get(indiceY).getGenero());
				}
				
				System.out.println("Páginas: " + biblioteca.getLivro().get(indice).getPaginas());
				return;
			}
		}
	}

	//Usuários
	private static int verificaClientes(ArrayList<Cliente> clientes, String login) {

		for(int indice = 0; indice < clientes.size(); indice++) {
			if(clientes.get(indice).getLogin().equals(login)) 
				return 1;
		}
		return 0;
	}

	private static int verificaAdministrador(ArrayList<Administrador> adms, String login) {
		for(int indice = 0; indice < adms.size(); indice++) {
			if(adms.get(indice).getLogin().equals(login))
				return 1;
		}
		return 0;
	}
}