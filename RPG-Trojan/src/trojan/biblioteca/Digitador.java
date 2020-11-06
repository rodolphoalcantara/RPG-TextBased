package trojan.biblioteca;

public class Digitador {
	public static void main(String[] args) throws Exception {
		long milisPorChar = 45;
		digita("Oi, agora funcionou nossa digita��o aos poucos ein!\n", milisPorChar);
		System.out.println("Selecione o menu:");
		System.out.println("1- Jogar; 2- Cr�ditos");
	}
	
	/**
	 * M�todo que imprime na tela aos poucos. Funciona como uma m�quina de escrever.
	 * 
	 * @param mensagem Uma string que deseja imprimir na tela
	 * @param velocidadeDaMensagem Velocidade que os caracteres ser�o impressos na tela ("Velocidade da digita��o")
	 * @throws InterruptedException
	 */
	public static void digita(String mensagem, long velocidadeDaMensagem) throws InterruptedException {
		for (int i = 0; i < mensagem.length(); i++) {
			System.out.print(mensagem.charAt(i));
			
			Thread.sleep(velocidadeDaMensagem);
		}
	}
	
}
