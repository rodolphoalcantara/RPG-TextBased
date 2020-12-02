package testes;

import java.util.Random;

public class TestaDados {
	
	public static void main(String[] args) {
		Random random = new Random();
		
		// ideia abaixo foi retirada do jogo final...
		
		int totalTiradoNosDados = 0;
		int nDeJogadasDoDado = 3;
		// jogar os dados
		for(int i = 0;i<nDeJogadasDoDado;i++){
			totalTiradoNosDados += random.nextInt(6) + 1;
			System.out.println(totalTiradoNosDados);
		}
		
		System.out.println("Total: "+totalTiradoNosDados);
	}
}
