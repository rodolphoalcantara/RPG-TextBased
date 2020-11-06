package trojan.biblioteca;

public class Digitador {
	public static void main(String[] args) throws Exception {
		long milisPorChar = 45;
		digita("Oi, agora funcionou nossa digitação aos poucos ein!\n", milisPorChar);
		System.out.println("Selecione o menu:");
		System.out.println("1- Jogar; 2- Créditos");
	}
	
	/**
	 * Método que imprime na tela aos poucos. Funciona como uma máquina de escrever.
	 * 
	 * @param mensagem Uma string que deseja imprimir na tela
	 * @param velocidadeDaMensagem Velocidade que os caracteres serão impressos na tela ("Velocidade da digitação")
	 * @throws InterruptedException
	 */
	public static void digita(String mensagem, long velocidadeDaMensagem) throws InterruptedException {
		for (int i = 0; i < mensagem.length(); i++) {
			System.out.print(mensagem.charAt(i));
			
			Thread.sleep(velocidadeDaMensagem);
		}
	}
	
}
