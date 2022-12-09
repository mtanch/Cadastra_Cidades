package Cidade;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	private static void menu() {
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("-------------------------------------------------------");
		System.out.println("------------------------ [MENU] -----------------------");
		System.out.println("-------------------------------------------------------");
		System.out.println("----------------- INFORME O QUE DESEJA ----------------");
		System.out.println("-------------------------------------------------------");
		System.out.println("--- [1] - Cadastrar cidade ----------------------------");
		System.out.println("--- [2] - Remover cidade ------------------------------");
		System.out.println("--- [3] - Listar todas as cidades ---------------------");
		System.out.println("--- [4] - Buscar cidade pelo DDD ----------------------");
		System.out.println("--- [5] - Buscar cidade pelo Nome ---------------------");
		System.out.println("--- [0] - Finalizar programa --------------------------");
		System.out.println("-------------------------------------------------------");
		System.out.print("	=> ");
		
		int escolha = entrada.nextInt();
		
		switch (escolha) {
		case 0:
			System.out.println("-------------------------------------------------------");
			System.out.println("--------------------- VOLTE SEMPRE --------------------");
			System.out.println("-------------------------------------------------------");
			break;
		case 1:
			insereCidade();
			break;
		case 2:
			removeCidade();
			break;
		case 3:
			listarTodasAsCidades();
			break;
		case 4:
			buscarPorDdd();
			break;
		case 5:
			buscarPorNome();
			break;
		}
	}

	private static void removeCidade() {
		System.out.println("-------------------------------------------------------");
		System.out.println("------------------- [REMOVER CIDADE] ------------------");
		System.out.println("-------------------------------------------------------");
		System.out.println("------------------------ INSIRA -----------------------");
		System.out.println("-------------------------------------------------------");
		System.out.println("--------- O [DDD] DA CIDADE PARA SER REMOVIDA ---------");
		System.out.println("-------------------------------------------------------");
		System.out.print("	=> ");
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		
		int ddd = entrada.nextInt();
		
		CidadeDAO cidadeDao = new CidadeDAO();
		cidadeDao.removeCidade(ddd);
		menu();
	}

	private static void insereCidade() {
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);

		System.out.println("-------------------------------------------------------");
		System.out.println("----------------- [CADASTRO DE CIDADE] ----------------");
		System.out.println("-------------------------------------------------------");
		System.out.println("----------------------- INSIRA: -----------------------");
		System.out.println("-------------------------------------------------------");
		System.out.println("------------------ O [DDD] DA CIDADE ------------------");
		System.out.println("-------------------------------------------------------");
		System.out.print("	=> ");
		int ddd = entrada.nextInt(); entrada.nextLine();	// buffering
		System.out.println("-------------------------------------------------------");
		System.out.println("------------------ O [NOME] DA CIDADE -----------------");
		System.out.println("-------------------------------------------------------");
		System.out.print("	=>");
		String nomeCidade = entrada.nextLine();
		System.out.println("-------------------------------------------------------");
		System.out.println("---------- O [NÚMERO DE HABITANTES] DA CIDADE ---------");
		System.out.println("-------------------------------------------------------");
		System.out.print("	=> ");
		int nroHabitantes = entrada.nextInt();
		System.out.println("-------------------------------------------------------");
		System.out.println("------------ A [RENDA PER CAPITA] DA CIDADE -----------");
		System.out.println("-------------------------------------------------------");
		System.out.print("	=> ");
		float rendaPerCapita = entrada.nextFloat(); entrada.nextLine();	// buffering
		System.out.println("-------------------------------------------------------");
		System.out.println("-------------- A CIDADE É UMA [CAPITAL]? --------------");
		System.out.println("-------------------------------------------------------");
		System.out.println("--------- ==========> [S] <|> [N] <========== ---------");
		System.out.println("-------------------------------------------------------");
		System.out.print("	=> ");
		String yesNo = entrada.nextLine();	
		
		boolean capital = yesNo.equals("S") || yesNo.equals("s");
		
		CidadePOJO cidade = new CidadePOJO(ddd, nomeCidade, nroHabitantes, rendaPerCapita, capital);
		CidadeDAO cidadeDao = new CidadeDAO();
		cidadeDao.insereCidade(cidade);
		menu();
	}
	
	public static void listarTodasAsCidades() {
		CidadeDAO cidade = new CidadeDAO();
		System.out.println(cidade.listarTodasAsCidades());
		menu();
	}
	
	public static void buscarPorDdd() {
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		
		CidadeDAO cidade = new CidadeDAO();
		
		System.out.println("-------------------------------------------------------");
		System.out.println("----------------------- INSIRA: -----------------------");
		System.out.println("-------------------------------------------------------");
		System.out.println("------------------ O [DDD] DA CIDADE ------------------");
		System.out.println("-------------------------------------------------------");
		System.out.print("	=> ");
		
		int ddd = entrada.nextInt();
		
		System.out.println(cidade.buscarPorDdd(ddd));
		
		menu();
	}
	
	
	public static void buscarPorNome() 
	{@SuppressWarnings("resource")
	Scanner entrada = new Scanner(System.in);
	
	CidadeDAO cidade = new CidadeDAO();
	
	System.out.println("-------------------------------------------------------");
	System.out.println("----------------------- INSIRA: -----------------------");
	System.out.println("-------------------------------------------------------");
	System.out.println("------ O [NOME] DA CIDADE OU O [INÍCIO DO NOME] -------");
	System.out.println("-------------------------------------------------------");
	System.out.print("	=> ");
	
	String nome = entrada.nextLine();
	
	System.out.println(cidade.buscarPorNome(nome));
	
	menu();
	}
	
	public static void main(String[] args) throws SQLException {
		menu();
	}
}
