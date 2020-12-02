package testes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;


public class TesteDoGeradorDeAlternativas {
	//variavel "global"
	static Scanner entrada = new Scanner(System.in);
	
	static long milisPorChar = 20; //valor padrao é 65;
	
	
	
	public static void main(String[] args) throws Exception {
		
		//codigo abaixo testa a saída do metodo embaralhaEEscolheQuatroAlternativas
		  if(embaralhaEEscolheQuatroAlternativas(new String[] { "Joao", "Maria","Jose", "Diego" }, 1)) { 
			  System.out.println("parabens"); 
		  }else {
			  System.out.println("errou"); 
		  }
		 
		
		
	}
	
	
	
	
	
	//metodo "embaralhaEEscolheQuatroAlternativas" possui "digita" como dependencia
	public static void digita(String mensagem, long milisPorChar) throws InterruptedException {
		for (int i = 0; i < mensagem.length(); i++) {
			System.out.print(mensagem.charAt(i));

			Thread.sleep(milisPorChar);
		}
	}

	
	
	public static boolean embaralhaEEscolheQuatroAlternativas(String[] alternativas, int indiceCorreto) throws Exception {
		//parte que embaralha
		String escolhaCorreta = "";
		boolean sai = false;
		ArrayList<String> listaEmbaralhada = new ArrayList<String>();
		for (String string : alternativas) {
			listaEmbaralhada.add(string);
		}
		Collections.shuffle(listaEmbaralhada);
		
		//imprime alternativas na tela
		for (int i = 0; i < listaEmbaralhada.size(); i++) {
			System.out.println((i + 1) + ". " + listaEmbaralhada.get(i));
		}

		
		// parte que escolhe
		digita("Escolha a alternativa correta", milisPorChar);
		int escolha = entrada.nextInt();
		do {
		switch (escolha) {
		case 1:
			escolhaCorreta = listaEmbaralhada.get(0);
			sai = true;
			break;
		case 2:
			escolhaCorreta = listaEmbaralhada.get(1);
			sai = true;
			break;

		case 3:
			escolhaCorreta = listaEmbaralhada.get(2);
			sai = true;
			break;

		case 4:
			escolhaCorreta = listaEmbaralhada.get(3);
			sai = true;
			break;


		default:
			digita("Alternativa não existe!", milisPorChar);;
			break;
		}
		}while(!sai);
		
		if(escolhaCorreta == alternativas[indiceCorreto]) {
			return true;
		}else {
			return false;
		}

	}

	
	
	
}
