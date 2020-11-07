package rpg;

import java.util.Scanner;

public class TrojanRPG {
	static int vida = 5;
	static long milisPorChar = 85;
	static Scanner entrada = new Scanner (System.in);
	
	public static void main(String[]args)throws Exception{
		Menu();
		
		}
	public static void perdeVida(int hit){
		if(hit>=vida) {			
			System.out.println("GameOver");
			//FIM DO JOGO//		
		}
		else{vida=vida-hit;}
			}
	public static void bonusDeVida(int extra) {
		if(extra>0) {
			vida=vida+extra;
		}
		
	}
	public static void Menu()throws Exception{
		boolean repitir = false;
		do {
		digita("1 Jogar\n",milisPorChar);
		digita("2 Opções\n",milisPorChar);
		digita("3 Creditos\n",milisPorChar);
		digita("4 Sair\n",milisPorChar);
		int n1 = entrada.nextInt();
		
		switch(n1) {
		
		case 1: 
		// Iniciar o jogo//
		break;
		
		case 2:
		// Abrir as opções//
		break;
		
		case 3:
		System.out.println("Esse jogo foi desenvolvido por:\n Rodolpho Alcantra \n Felipe Fabrini \n Gessione Freitas" );
		break;
			
		case 4:
			digita("Saindo...",milisPorChar);
		System.exit(1);
		break;
		
		default:
			System.out.print("\n Não tem essa opção !!!\n");
			System.out.print(" Tente novamente\n\n");
			repitir= true;
			break;
		
		}
		
		}while(repitir);
		
	}
	/**
	 * Método que imprime na tela aos poucos. Funciona como uma máquina de escrever.
	 * 
	 * @param mensagem Uma string que deseja imprimir na tela
	 * @param milisPorChar Velocidade que os caracteres serão impressos na tela ("Velocidade da digitação")
	 * @throws InterruptedException
	 */
	public static void digita(String mensagem, long milisPorChar) throws InterruptedException {
		for (int i = 0; i < mensagem.length(); i++) {
			System.out.print(mensagem.charAt(i));

			Thread.sleep(milisPorChar);
		}
	}
}