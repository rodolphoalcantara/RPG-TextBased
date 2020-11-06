package rpg;

public class TrojanRPG {
	long milisPorChar = 85;
	/**
	 * M�todo que imprime na tela aos poucos. Funciona como uma m�quina de escrever.
	 * 
	 * @param mensagem Uma string que deseja imprimir na tela
	 * @param milisPorChar Velocidade que os caracteres ser�o impressos na tela ("Velocidade da digita��o")
	 * @throws InterruptedException
	 */
	public static void digita(String mensagem, long milisPorChar) throws InterruptedException {
		for (int i = 0; i < mensagem.length(); i++) {
			System.out.print(mensagem.charAt(i));

			Thread.sleep(milisPorChar);
		}
	}
}