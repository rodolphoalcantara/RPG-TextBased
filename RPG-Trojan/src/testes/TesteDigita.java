package testes;

public class TesteDigita {

	public static void main(String[] args) throws Exception {
		
		long milisPorChar = 120;
		//teste digita usando uma variavel milisPorChar = 120 
		digita("Testando digita() com a velocidade 120 milis por char\n\n", milisPorChar);
		
		
		milisPorChar = 40;
		//teste digita usando uma variavel milisPorChar = 40
		digita("Testando digita() com a velocidade 40 milis por char\n\n", milisPorChar);
		
		//teste digita passando um valor hardcoded como parametro.
		digita("Testando digita() com uma valor definido no metodo, 1000 milisegundos\n\n", 1000);
		

		digita("Testando digita() com uma valor definido no metodo, instantaneo = 0 milisegundos\n\n", 0);
		
	
		
		
	}
	
	public static void digita(String mensagem, long milisPorChar) throws InterruptedException {
		for (int i = 0; i < mensagem.length(); i++) {
			System.out.print(mensagem.charAt(i));

			Thread.sleep(milisPorChar);
		}
	}

}
