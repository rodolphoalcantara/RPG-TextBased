package rpg;

import java.awt.Desktop;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class TrojanRPG {
	// variaveis "globais"
	static int vida = 5;
	static long milisPorChar = 0;// 65
	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		// menu();
		// capituloQuatro();
		//prologo();
		capituloUm();
	}

	// m�todos do jogo

	public static void menu() throws Exception {
		boolean repetir = false;
		do {
			digita("1 Jogar\n", milisPorChar);
			digita("2 Op��es\n", milisPorChar);
			digita("3 Creditos\n", milisPorChar);
			digita("4 Sair\n", milisPorChar);
			int n1 = entrada.nextInt();

			switch (n1) {

			case 1:
				// Iniciar o jogo//
				break;

			case 2:
				opcao();
				break;

			case 3:
				digita("Esse jogo foi desenvolvido por:\n Rodolpho Alcantara \n Felipe Fabrini \n Gessione Freitas\n\n",
						60);
				menu();
				break;

			case 4:
				digita("Saindo do jogo...", milisPorChar);
				System.exit(1);
				break;

			default:
				System.out.print("\n N�o tem essa op��o !!!\n");
				System.out.print(" Tente novamente\n\n");
				repetir = true;
				break;

			}

		} while (repetir);

	}

	// op��es: usu�rio escolhe a velocidade do texto
	public static void opcao() throws Exception {
		boolean sair = false, aceitou = false;
		do {
			digita("Escolha a velocidade de digita��o.\n", milisPorChar);
			digita("1 R�pido\n", milisPorChar);
			digita("2 Normal\n", milisPorChar);
			digita("3 Devagar\n", milisPorChar);
			digita("4 Sair\n", milisPorChar);
			int option = entrada.nextInt();
			switch (option) {
			case 1:
				milisPorChar = 35;
				digita("Alterado para r�pido!\n", milisPorChar);
				break;
			case 2:
				milisPorChar = 65;
				digita("Alterado para normal!\n", milisPorChar);
				break;
			case 3:
				milisPorChar = 100;
				digita("Alterado para devagar!\n", milisPorChar);
				break;
			case 4:
				digita("Saindo das op��es...\n", milisPorChar);
				menu();
				break;

			default:
				digita("Valor incorreto ser� utilizado o valor padr�o! \n", milisPorChar);
				milisPorChar = 85;
				break;
			}

			digita("Teste: ", milisPorChar);
			digita("Este � um jogo que faz parte de um projeto da Faculdade Senac, desenvolvido pelos alunos \n"
					+ "Felipe Fabrini, Gessione Freitas e Rodolpho Alc�ntara. No jogo, voc� interpreta o papel de um jovem estudioso \n"
					+ "que ao instalar um v�rus, entra no computador e precisa desintalar esse software malicioso para sair da maquina.\n",
					milisPorChar);
			do {
				digita("Esta velocidade est� boa? \n", milisPorChar);
				digita("1 SIM\n", milisPorChar);
				digita("2 N�O\n", milisPorChar);
				int aceita = entrada.nextInt();
				switch (aceita) {
				case 1:
					digita("Vamos voltar para o menu!\n", milisPorChar);
					aceitou = true;
					sair = true;
					break;
				case 2:
					digita("Vamos tentar selecionar a velocidade de novo...\n", milisPorChar);
					aceitou = true;
					break;

				default:
					digita("N�o entendi! Tente novamente...\n", milisPorChar);
					break;
				}

			} while (!aceitou);

		} while (!sair);
		menu();
	}

	public static void capituloQuatro() throws Exception {
		digita("Enquanto est�vamos nos esgueirando por entre os pr�dios e casas, fiquei pensando como seria se n�o tivesse \n"
				+ "baixado aquele v�rus. Talvez estaria tranquilo em casa comendo salgadinho e tomando refrigerante enquanto \n"
				+ "assistia algum v�deo no Youtube.\n\n", milisPorChar);
		digita("Alberto viu que meu pensamento estava longe e logo me repreendeu. Disse-me pra focar no nosso objetivo. \n"
				+ "T�nhamos que planejar a invas�o na prefeitura.\n\n", milisPorChar);
		digita("Quando chegamos no pr�dio da prefeitura, vimos algo que me desanimou. Estava cheio de capangas. \n"
				+ "Devia ter uns oito v�rus de baixo escal�o fazendo ronda.\n\n", milisPorChar);
		visualizaImagem("Q1Cap4.jpg");

		if (embaralhaEEscolheQuatroAlternativas(new String[] { "Joao", "Maria", "Jose", "Diego" }, 1)) {
			System.out.println("parabens");
		} else {
			System.out.println("errou");
		}

	}

	// m�todos de funcionalidades do game

	/**
	 * M�todo que retira quantidade de vidas do total do jogador.
	 * 
	 * @param hit Recebe um Int equivalente a quantidade de hits que ir� tirar da
	 *            vida total
	 */
	public static void perdeVida(int hit) {
		if (hit >= vida) {
			System.out.println("GameOver");
			// FIM DO JOGO//
		} else {
			vida = vida - hit;
		}
	}

	/**
	 * M�todo que adiciona um bonus de vida ao valor atual do player
	 *
	 * @param extra Recebe um Int equivalente a quantidade de vidas que o player ir�
	 *              receber
	 */
	public static void bonusDeVida(int extra) {
		if (extra > 0) {
			vida = vida + extra;
		}

	}

	/**
	 * M�todo que imprime na tela aos poucos. Funciona como uma m�quina de escrever.
	 * 
	 * @param mensagem     Uma string que deseja imprimir na tela
	 * @param milisPorChar Velocidade que os caracteres ser�o impressos na tela
	 *                     ("Velocidade da digita��o")
	 * @throws InterruptedException
	 */
	public static void digita(String mensagem, long milisPorChar) throws InterruptedException {
		for (int i = 0; i < mensagem.length(); i++) {
			System.out.print(mensagem.charAt(i));

			Thread.sleep(milisPorChar);
		}
	}

	/**
	 * M�todo que abre o arquivo de imagem localizado na raiz do projeto, na pasta
	 * img.
	 * 
	 * @param imagem String com o nome da imagem e sua exten��o Ex: test.jpg
	 * @throws Exception
	 */
	public static void visualizaImagem(String imagem) throws Exception {

		File f = new File("img/" + imagem);
		Desktop d = Desktop.getDesktop();
		d.open(f);

	}

	/**
	 * 
	 * @param alternativas  array contendo as alternativas
	 * @param indiceCorreto indice do array de alternativas que � a correta (OBS:
	 *                      indice come�a no 0)
	 * @return Booleano
	 * @throws Exception
	 */
	public static boolean embaralhaEEscolheQuatroAlternativas(String[] alternativas, int indiceCorreto)
			throws Exception {
		// parte que embaralha
		String escolhaCorreta = "";
		boolean sai = false;
		ArrayList<String> listaEmbaralhada = new ArrayList<String>();
		for (String string : alternativas) {
			listaEmbaralhada.add(string);
		}
		Collections.shuffle(listaEmbaralhada);

		// imprime alternativas na tela
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
				digita("Alternativa n�o existe!", milisPorChar);
				;
				break;
			}
		} while (!sai);

		if (escolhaCorreta == alternativas[indiceCorreto]) {
			return true;
		} else {
			return false;
		}

	}

	public static void prologo() throws Exception {
		digita("23 de Mar�o de 2020. Um dia que eu achava ser mais um dia comum, ficar� pra sempre em minhas lembran�as.\n"
				+ "Mas, para contar o que houve, preciso primeiro me apresentar.\n", milisPorChar);
		digita("Meu nome � Lucas, um adolescente de 14 anos que sempre foi muito interessado em tecnologia\n"
				+ "Nunca fui bem nas mat�rias escolares, por�m, o que eu mais gostava de fazer depois das aulas era descobrir coisas novas na internet,\n"
				+ "e talvez tenha sido essa minha curiosidade que me levou a tudo isso\n", milisPorChar);
		digita("J� havia passado, mais ou menos, duas semanas desde a suspen��o das aulas por conta da quarentena de Covid19\n"
				+ "Estava eu, como de costume, com vinte abas abertas no meu navegador, aprendendo coisas novas\n"
				+ "A quarentena me deixou com muito tempo livre, e eu estava usando este tempo para aprender mais coisas sobre programa��o e computa��o.\n",
				milisPorChar);
		digita("Uma dessas abas era sobre uma mat�ria, em um site comum de not�cias Tech, que falava sobre a DeepWeb.\n"
				+ "Fiquei fascinado por aquilo e resolvi investigar.\n", milisPorChar);
		digita("Ap�s seguir todos os preparativos, resolvi entrar em um f�rum qualquer e me deparei com um usu�rio,\n"
				+ "chamado Jon Art, que prometia um Aplicativo capaz de resolver todos meus problemas.\n"
				+ "Ele iria ser uma ferramenta que me possibilitaria elevar meu conhecimento\n", milisPorChar);
		digita("Achei aquilo muito estranho, parecia que tinha sido feito pra mim,\n"
				+ "por�m pensei comigo mesmo: - Que mal tem?!\n", milisPorChar);
		digita("E n�o percebi que s� tinha mal nisso.\n\n"
				+ "Minha inoc�ncia me fez baixar o arquivo e instalar em meu computador\n"
				+ "Quando o loading da instala��o teve fim, o computador come�ou a se comportar de um jeito estranho.\n\n",
				milisPorChar);
		digita("A tela ficou toda preta, como de um terminal em tela inteira. E algo come�ou a ser escrito:\n\n",
				milisPorChar);

		digita("######################################################\r\n"
				+ "##                                                  ##\r\n"
				+ "##        Bem-vindo ao aplicativo Soul Eater        ##\r\n"
				+ "##                       by                         ##\r\n"
				+ "##                    JON  ART                      ##\r\n"
				+ "##                                                  ##\r\n"
				+ "######################################################\n\n", 10);

		digita("De repente, aconteceu uma interfer�ncia e o nome do criador come�ou a mudar, e se mostrou algo totalmente diferente:\n\n",
				milisPorChar);

		digita("######################################################\r\n"
				+ "##                                                  ##\r\n"
				+ "##        Bem-vindo ao aplicativo Soul Eater        ##\r\n"
				+ "##                       by                         ##\r\n"
				+ "##                     TROJAN                       ##\r\n"
				+ "##                                                  ##\r\n"
				+ "######################################################\n\n", 10);

		digita("\r\n"
				+ "Percebi que talvez deveria ter lido os termos de uso, e quando menos esperava meu computador\ncome�ou a eletrizar e como um passe de m�gica tudo ficou escuro.\n",
				milisPorChar);
/// Fim do prologo
	}

	public static void capituloUm() throws Exception{
		
		digita("Cap�tulo Um - Querida Encolhi as Crian�as!\n\n", milisPorChar);
		
		digita("Quando abri meus olhos me vi em algum lugar que lembrava uma cidade, por�m, de um jeito diferente\n"
				+ "Era tudo preto, como uma tela de um terminal, e as linhas brancas formavam pr�dios e avenidas\n"
				+ "linda cidade um dia, contudo, com a instala��o do SoulEater,\n"
				+ "em menos de segundos a cidade tinha se transformado em ru�nas\n"
				+ "um cen�rio p�s-apocal�ptico.\n",milisPorChar);
		
		digita("Descobri que estava em meu computador, nos altos dos pr�dios destru�dos\n"
				+ "algo como outdoors mostravam memes que tinha salvo h� alguns dias.\n"
				+ "E em minha vis�o aparecia algo como um contador de vidas, como em um jogo de v�deo game.\n", milisPorChar);
		
		digita("Fiquei olhando para aqueles v�deos e n�o percebi que um grupo de malwares estavam vindo em minha dire��o.\nEram capangas do TROJAN"
				+ "e estavam tentando me levar a for�a para seu chefe.", milisPorChar);
		
	}
}