package rpg;

import java.awt.Desktop;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Random;

public class TrojanRPG {
	// variaveis "globais"
	static int vida = 5;
	static boolean furioso = false;
	static long milisPorChar = 0;// 65
	static Scanner entrada = new Scanner(System.in);
	static Random random = new Random();

	public static void main(String[] args) throws Exception {
		// menu();
		//capituloQuatro();
		// prologo();
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

	// m�todos de funcionalidades do game

	/**
	 * M�todo que retira quantidade de vidas do total do jogador.
	 * 
	 * @param hit Recebe um Int equivalente a quantidade de hits que ir� tirar da
	 *            vida total
	 */
	public static void perdeVida(int hit) throws Exception {
		if (hit >= vida) {
			System.out.println("GameOver!\n\n");
			// FIM DO JOGO//
		} else {
			vida = vida - hit;
			digita("\n\n Voc� perdeu " + hit + " HP\n", 60);
			digita("\n Voc� possui " + vida + " HP\n\n", 60);
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

	// Metodos dos Capitulos

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

	public static void capituloUm() throws Exception {

		digita("Cap�tulo Um - Querida Encolhi as Crian�as!\n\n", milisPorChar);

		digita("Quando abri meus olhos me vi em algum lugar que lembrava uma cidade, por�m, de um jeito diferente\n"
				+ "Era tudo preto, como uma tela de um terminal, e as linhas brancas formavam pr�dios e avenidas\n"
				+ "linda cidade um dia, contudo, com a instala��o do SoulEater,\n"
				+ "em menos de segundos a cidade tinha se transformado em ru�nas\n" + "um cen�rio p�s-apocal�ptico.\n",
				milisPorChar);

		digita("Descobri que estava em meu computador, nos altos dos pr�dios destru�dos\n"
				+ "algo como outdoors mostravam memes que tinha salvo h� alguns dias.\n"
				+ "E em minha vis�o aparecia algo como um contador de vidas, como em um jogo de v�deo game.\n",
				milisPorChar);

		digita("Fiquei olhando para aqueles v�deos e n�o percebi que um grupo de malwares estavam vindo em minha dire��o.\nEram capangas do TROJAN"
				+ " e estavam tentando me levar a for�a para seu chefe.\n", milisPorChar);
		
		digita("\nDESAFIO: \n\n", milisPorChar);

		digita("Na Algebra Booleana And e Or s�o representados com quais sinais matematica?\n\n", milisPorChar);
		
		if (embaralhaEEscolheQuatroAlternativas(
				new String[] {"Multiplica��o e Adi��o", "Subtra��o e Divis�o", "Multiplica��o e divis�o", "Subtra��o e Adi��o"}, 0)) {
			// acertou
			digita("\nComecei a ir para tr�s e me vi encurralado em uma esp�cie de beco, olhei para o lado e tinha um grande cano feito de bytes.\n"
					+ " Usei este cano como uma lan�a e destru� os malwares, de um jeito que nem eu imaginaria conseguir.\n"
					+ " De repente das sombras saiu um vulto branco brilhante\r\n"+
					
					"\n", milisPorChar);
				}
		//errou
		else { 
			digita("\nComecei a ir para tr�s e me vi encurralado em uma esp�cie de beco,\n"
					+ " olhei para o lado e tinha apenas uma lata de lixo, como aquelas americanas que vemos em filmes, s� que feita de bytes\n"
					+ "Peguei a tampa e usei como um escudo... apanhei bastante e com isso perdi um cora��o de vida\n"
					+ "Mas para meu al�vio, vi um vulto branco que foi em dire��o ao grupo de malwares e, com a ajuda dele, os derrotamos. \n", milisPorChar);
			perdeVida(1);
		}
		
		digita("Ol� forasteiro. - O brilhoso ser falou � O que voc� quer em meu territ�rio?! Por favor identifique-se. \n", milisPorChar);
		digita("Quando ele falou aquilo seu brilho come�ou a diminuir e se mostrou um chefe de pol�cia, meio machucado e com sua barba de bytes por fazer. \n", milisPorChar);
		digita("- Irei pedir s� mais uma vez. Por favor identifique-se. - Disse agora com um tom en�rgico. \n", milisPorChar);
		
		digita("Depois de explicar quem eu era e tudo o que aconteceu, o policial estava me olhando com uma cara de espanto.\n"
				+ "Apenas pelo seu semblante pude notar um mix de emo��es\n"
				+ "Felicidade, por estar conhecendo seu criador e a pessoa em que todos os moradores do computador admiravam.\n"
				+ "E Raiva, por descobrir que seu criador havia causado toda aquela destrui��o e mortes.\n"
				+ "Por�m, mesmo sentindo tudo isso ele sabia que a �nica pessoa que podia acabar com tudo aquilo era eu.\n"
				+ "- Veja, tudo o que aconteceu. Antes, essas ruas eram cheias de bytes andando de um lado pro outro\n"
				+ "Trafegando informa��es para onde voc� solicitava.\n"
				+ "V�amos que voc� adorava passar horas no computador e isso nos alegrava.\n"
				+ "Mas, um dia voc� resolveu entrar em um f�rum e baixar aquele software malicioso \n"
				+ "� Disse o policial que agora estava sentindo tristeza lembrando de seus amigos e familiares mortos.\n"
				+ "- Bom... N�o devemos viver do passado. � disse ele � Somente VOC� pode nos salvar.\n"
				+ "S� voc� pode desinstalar esse v�rus na PORRADA.\n\n", milisPorChar);
		
		
		
	}

	public static void capituloQuatro() throws Exception {
		digita("Enquanto est�vamos nos esgueirando por entre os pr�dios e casas, fiquei pensando como seria se n�o tivesse \n"
				+ "baixado aquele v�rus. Talvez estaria tranquilo em casa comendo salgadinho e tomando refrigerante enquanto \n"
				+ "assistia algum v�deo no Youtube.\n\n", milisPorChar);
		digita("Alberto viu que meu pensamento estava longe e logo me repreendeu. Disse-me pra focar no nosso objetivo. \n"
				+ "T�nhamos que planejar a invas�o na prefeitura.\n\n", milisPorChar);
		digita("Quando chegamos no pr�dio da prefeitura, vimos algo que me desanimou. Estava cheio de capangas. \n"
				+ "Devia ter uns oito v�rus de baixo escal�o fazendo ronda.\n\n", milisPorChar);

		digita("DESAFIO: \n", milisPorChar);

		visualizaImagem("Q1Cap4.jpg");
		digita("Qual � a equa��o do circuito da imagem?\n\n", milisPorChar);

		if (embaralhaEEscolheQuatroAlternativas(
				new String[] { "(A�.B.C).(A+D)�", "(A.B.C).(A+D)", "(A.B.C)�.(A+D)�", "(A�+B+C)+(A.D)�" }, 0)) {
			// acertou
			digita("Pegamos peda�os de cano que pareciam ser de ferro e fomos de encontro aos capangas. De repente vimos policiais amigos\n"
					+ " do Alberto. Eles Vieram nos ajudar.\n\n", milisPorChar);
			digita("Est�vamos agora em seis contra oito v�rus. Mas mesmo em menor numero os policiais eram habilidosos. Eles sabiam lutar com seus cassetetes. \n"
					+ "Conseguimos entrar!\n\n", milisPorChar);

		} else {
			// errou
			digita("Pegamos peda�os de cano que pareciam ser de ferro e fomos de encontro aos capangas. De repente vimos policiais amigos\n"
					+ " do Alberto. Vieram nos ajudar. Por�m eles estavam feridos.\n\n", milisPorChar);
			digita("Est�vamos em seis contra oito v�rus. Mas mesmo os policiais sendo habilidosos, a sa�de deles n�o estava bem. Fomos derrotando\n"
					+ " um por um dos v�rus. Mas est�vamos ficando cansados e feridos. Com isso vi minha vida descendo dois pontos.\n\n",
					milisPorChar);

			perdeVida(2);

		}
		digita("Est�vamos dentro da prefeitura. Os policiais ficaram do lado de fora para nos proteger de poss�veis refor�os do inimigo. \n"
				+ "E eles tamb�m estavam esperando os refor�os da delegacia. Parecia que o plano estava dando certo.\n\n",
				milisPorChar);
		digita("No hall principal percebemos algo de errado. N�o tinha ningu�m.\n\n", milisPorChar);
		digita("Est�vamos crentes que teria v�rios capangas. Mas no final das contas n�o tinha nenhum. Abaixamos a guarda e nos separamos \n"
				+ "para procurar alguma pista. Estava eu de um lado do hall e o Alberto do outro quando de repente surgiram os capangas do\n"
				+ "trojan com c�es e porretes. O medo adentrou meu corpo.\n\n", milisPorChar);

		int nDeJogadasDoDado = 0;
		// primeiro desafio do conjunto do destino de alberto
		digita("DESAFIO: \n", milisPorChar);
		digita("Lucas est� no meio de uma enrascada, para ajuda-lo converta a palavra LUTA para bin�rio. \n"
				+ "Obs.: Tabela Ascii(L:76, U: 85, T: 84, A: 65).\n\n", milisPorChar);

		if (embaralhaEEscolheQuatroAlternativas(new String[] { "(0100 1100), (0101 0101), (0101 0100), (0100 0001)",
				"(0100 0001), (0101 0100), (0101 0101), (0100 1100)",
				"(0100 0110), (0101 0101), (0100 0111), (0100 0001)",
				"(0101 0100), (0101 0010), (0100 1111), (0100 1100), (0100 1100)" }, 0)) {
			// acertou
			digita("Um grupo de capangas veio em minha dire��o e outro na dire��o do Alberto. A inten��o deles era nos deixar separados.\n"
					+ "Eu estava com um cassetete dos policiais que vieram nos ajudar e consegui me defender. Derrubei um dos capangas e cuidei de seu cachorro.\n"
					+ "Alberto conseguiu se defender mas estava em uma enrascada\n\n", milisPorChar);
			nDeJogadasDoDado++;
		} else {
			// errou
			digita("Um grupo de capangas veio em minha dire��o e outro na dire��o do Alberto. A inten��o deles era nos deixar separados.\r\n"
					+ "Eu ainda estava com um cano na m�o, mas isso n�o era o suficiente. Derrubei um dos capangas, mas o cachorro dele veio \n"
					+ "em minha dire��o e mordeu meu bra�o.\r\n", milisPorChar);
			perdeVida(1);

		}
		// segundo desafio do conjunto do destino de alberto
		digita("DESAFIO: \n", milisPorChar);
		digita("Por algum motivo, Lucas se lembrou de estudar sobre os postulados de Boole. Mas n�o consegue lembrar quais s�o os tr�s \n"
				+ "principais tipos. Ele n�o conseguir� se concentrar na batalha enquanto n�o souber. Ajude o Lucas:\n\n",
				milisPorChar);

		if (embaralhaEEscolheQuatroAlternativas(new String[] { "Postulados: Complementa��o, Adi��o e Multiplica��o",
				"Postulados: Implementa��o, Adi��o e Multiplica��o", "Postulados: Adi��o, Subtra��o e Multiplica��o",
				"Postulados: Divis�o, Subtra��o e Complementa��o" }, 0)) {
			// acertou
			digita("Eu e o Alberto est�vamos lutando igual loucos. Alberto parecia que dan�ava com eles, nunca vi tamanha habilidade. Consegui avan�ar.\n"
					+ "Estava cada vez mais perto do Alberto.\r\n" + "O plano era nos juntarmos.\n\n", milisPorChar);
			nDeJogadasDoDado++;
		} else {
			// errou
			digita("Eu e o Alberto est�vamos lutando igual loucos. Mas parecia que eles eram melhores que n�s. Est�vamos gastando muita energia.\n"
					+ "O cansa�o estava come�ando a ser um problema.\n" + "Mesmo assim consegui avan�ar.\n"
					+ "Estava cada vez mais perto do Alberto.\n" + "O plano era nos juntarmos.\n\n", milisPorChar);
			perdeVida(1);
			digita("Alberto estava na mesma enrascada que eu.", milisPorChar);

		}
		// terceiro desafio do conjunto do destino de alberto
		digita("DESAFIO: \n", milisPorChar);
		digita("Enquanto Lucas lutava, em sua frente viu um bin�rio piscando na parede do Hall, parecia o Matrix.\n"
				+ "## 01000100 01000101 01010011 01010100 01001001 01001110 01001111 ##\n"
				+ "Ajude o Lucas a descobrir que mensagem est� aparecendo.\n\n", milisPorChar);

		if (embaralhaEEscolheQuatroAlternativas(new String[] { "DESTINO", "BINARIO", "PROJETO", "DESEJOS" }, 0)) {
			// acertou
			digita("Est�vamos juntos, e por isso ainda restavam capangas para derrotarmos. Est�vamos esperando ser f�cil, mas pensamos errado.\r\n"
					+ "Eles vieram com f�ria em nossa dire��o querendo acabar com a nossa vida. Conseguimos dar um jeito neles. Ainda consegu�amos lutar mais, \n"
					+ "mesmo que n�o quis�ssemos, nossa adrenalina estava alta.\n\n", milisPorChar);
			nDeJogadasDoDado++;
		} else {
			// errou
			digita("Est�vamos juntos, e por isso ainda restavam capangas para derrotarmos. Est�vamos esperando ser f�cil, mas pensamos errado.\r\n"
					+ "Eles vieram com f�ria em nossa dire��o querendo acabar com a nossa vida. Conseguimos dar um jeito neles, mas parecia que minha for�a estava acabando.\n\n",
					milisPorChar);
			perdeVida(2);

		}
		
		int totalTiradoNosDados = 0;
		//jogar os dados
		for (int i = 0; i < nDeJogadasDoDado; i++) {
			totalTiradoNosDados += random.nextInt(6)+1;
		}
		System.out.println(totalTiradoNosDados); // teste
		
		
		//destino de Alberto
		if(totalTiradoNosDados<=10) {
			//alberto morre
			digita("T�nhamos conseguido nos livrar dos capangas, est�vamos nos recuperando para avan�ar. Escutei duas pessoas conversando:\n" + 
					"- N�o podemos matar ele, o chefe o quer vivo! � disse um dos capangas.\n" + 
					"- Mas o outro ele n�o disse nada! � disse o outro. \n" + 
					"De repente escutei um barulho muito alto e quando olhei para o Alberto ele estava no ch�o. Com suas linhas de c�digo esparramadas pelo ch�o.\n" + 
					"Antes que pudesse gritar senti um choque percorrendo todo meu corpo e ent�o desmaiei.\n\n", milisPorChar);
			furioso = true;
			digita("## Voc� sentiu a perda de seu amigo, e acordou em estado de f�ria! ## \n"
					+ "## (O n�mero de desafios na BossFight diminuiu!) ##\n\n", milisPorChar);
			
		}else {
			//alberto vive
			digita("T�nhamos conseguido nos livrar dos capangas, est�vamos nos recuperando para avan�ar. Escutei duas pessoas conversando:\n" + 
					"- N�o podemos matar eles, o chefe os quer vivo! � disse um dos capangas.\n" + 
					"- Ah! T� bom! � disse o outro decepcionado.\n" + 
					"Antes que pudesse virar para ver quem era senti um choque percorrendo todo meu corpo e ent�o desmaiei.\n\n", milisPorChar);
			
			vida *= 2;
			digita("## Por conseguir se juntar ao seu amigo, voc� se sente mais forte! ## \n"
					+ "## (Sua vida dobrou!) ##\n\n", milisPorChar);
			
		}
		
		
		//BOSS FIGHT
		digita("Quando eu abri os olhos vi o Trojan na minha frente. Era um cara gordo, parecia o rei do crime dos quadrinhos. \n"
				+ "Estava fumando um charuto e bebendo alguma coisa em um copo chique.\n" + 
				"Estava falando comigo, mas n�o consegui entende-lo. Ainda estava meio zonzo. \n" + 
				"A �nica coisa que passava em minha mente � que precisava me soltar e tentar acabar com ele, custe o que custar.\n\n", milisPorChar);
		
		
		//primeiro desafio da bossfight
		digita("DESAFIO: \n", milisPorChar);
		
		digita("\n\n", milisPorChar);

		if (embaralhaEEscolheQuatroAlternativas(new String[] { "0", "", "", "" }, 0)) {
			// acertou
			digita("Ele veio em minha dire��o com seu charuto tentou apaga-lo minha m�o, \n"
					+ "fui mais r�pido e virei fazendo com que queimasse a corda e eu conseguisse me soltar da cadeira.\n\n", milisPorChar);
		} else {
			// errou
			digita("Ele veio em minha dire��o com seu charuto tentou apaga-lo minha m�o, n�o consegui desviar. Gritei de dor. \n"
					+ "Aquele charuto estava muito quente, minha m�o ficou em chamas. Com a dor que senti consegui me soltar da cadeira.\n\n", milisPorChar);
			perdeVida(1);

		}
		
		//segundo desafio da bossfight
		digita("DESAFIO: \n", milisPorChar);
		digita("\n\n", milisPorChar);

		if (embaralhaEEscolheQuatroAlternativas(new String[] { "0", "", "", "" }, 0)) {
			// acertou
			digita("Corri na dire��o dele com uma garrafa de bebida, que peguei de sua mesa, e bati em sua cabe�a, ele tonteou e caiu para tr�s. \n"
					+ "Aproveitei para procurar alguma coisa que eu pudesse me armar. A vis�o dele ca�do no ch�o me deu motiva��o.\n\n", milisPorChar);
			digita("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% \n" + 
					"%%                                      %%\n" + 
					"%%                  __                  %%\n" + 
					"%%                 [  ]                 %%\n" + 
					"%%                 |  |                 %%\n" + 
					"%%                 |  |                 %%\n" + 
					"%%                /    \\                %%\n" + 
					"%%               /      \\               %%\n" + 
					"%%              |        |              %%\n" + 
					"%%              |        |              %%\n" + 
					"%%              |        |              %%\n" + 
					"%%              |        |              %%\n" + 
					"%%              |        |              %%\n" + 
					"%%              |        |              %%\n" + 
					"%%              [________]              %%\n" + 
					"%%                                      %%\n" + 
					"%%                                      %%\n" + 
					"%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% \n\n", 0);
		} else {
			// errou
						
			digita("Corri na dire��o dele, ele me segurou e me jogou para tras. Ele era muito forte. Ca� por cima da mesa. Ele estava vindo em minha dire��o. \n"
					+ "Come�ou a me enforcar. Olhei para o lado e vi a garrafa de bebida que estava sobre a mesa. Segurei ela firme e bati em sua cabe�a, ele tonteou e caiu para tr�s. \n"
					+ "Aproveitei para procurar alguma coisa que eu pudesse me armar. Estava respirando forte. Mas vis�o dele ca�do no ch�o me deu motiva��o.\n", milisPorChar);
			digita("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% \n" + 
					"%%                                      %%\n" + 
					"%%                  __                  %%\n" + 
					"%%                 [  ]                 %%\n" + 
					"%%                 |  |                 %%\n" + 
					"%%                 |  |                 %%\n" + 
					"%%                /    \\                %%\n" + 
					"%%               /      \\               %%\n" + 
					"%%              |        |              %%\n" + 
					"%%              |        |              %%\n" + 
					"%%              |        |              %%\n" + 
					"%%              |        |              %%\n" + 
					"%%              |        |              %%\n" + 
					"%%              |        |              %%\n" + 
					"%%              [________]              %%\n" + 
					"%%                                      %%\n" + 
					"%%                                      %%\n" + 
					"%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% \n\n", 0);


		}
		
		//terceiro desafio da bossfight
		digita("DESAFIO: \n", milisPorChar);
		digita("\n\n", milisPorChar);

		if (embaralhaEEscolheQuatroAlternativas(new String[] { "0", "", "", "" }, 0)) {
			// acertou
			digita("Procurei na sala e vi que tinha derrubado uma faca de ca�a quando peguei a garrafa de cima da mesa, antes que ele pudesse reagir \n"
					+ "corri em sua dire��o e fiz algo que n�o achei que seria capaz. Enfiei a faca em seu peito.\n", milisPorChar);
			digita("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n" + 
					"%%                                                      ___                                %%\n" + 
					"%%                                                    |_  |                                %%\n" + 
					"%%                                                      | |                                %%\n" + 
					"%%  __                      ____                        | |                                %%\n" + 
					"%%  \\ ````''''----....____.'\\   ````''''----------------| |--.         _____      .-.      %%\n" + 
					"%%   :.                      `-._                       | |   `---''''```   ``''|`: :|     %%\n" + 
					"%%    '::.                       `'--.._________________| |                     | : :|     %%\n" + 
					"%%      '::..       ----.....___________________________| |                     | : :|     %%\n" + 
					"%%        `'-::...______________________________________| |   .--..-'`-..--..--.|   :|     %%\n" + 
					"%%             ```'''-----------------------------------| |--'                   `'-'      %%\n" + 
					"%%                                                      | |                                %%\n" + 
					"%%                                                     _| |                                %%\n" + 
					"%%                                                    |___|                                %%\n" + 
					"%%                                                                                         %%\n" + 
					"%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n" + 
					"Fonte: https://www.asciiart.eu/ \n\n", 0);
			
		} else {
			// errou
			digita("Procurei na sala e vi que tinha derrubado uma faca de ca�a quando peguei a garrafa de cima da mesa, fui em dire��o dela, mas ele me puxou pela perna. \n"
					+ "Ca� de boca no ch�o e quase perdi a consci�ncia. Ele estava me chutando no ch�o enquanto eu tentava pegar a faca. Consegui alcan�a-la e ele percebeu. \n"
					+ "Quando ele veio por cima de mim e tentou tirar a faca da minha m�o, fiz algo que n�o achei que seria capaz. Enfiei a faca em seu peito.\n", milisPorChar);
			digita("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n" + 
					"%%                                                      ___                                %%\n" + 
					"%%                                                    |_  |                                %%\n" + 
					"%%                                                      | |                                %%\n" + 
					"%%  __                      ____                        | |                                %%\n" + 
					"%%  \\ ````''''----....____.'\\   ````''''----------------| |--.         _____      .-.      %%\n" + 
					"%%   :.                      `-._                       | |   `---''''```   ``''|`: :|     %%\n" + 
					"%%    '::.                       `'--.._________________| |                     | : :|     %%\n" + 
					"%%      '::..       ----.....___________________________| |                     | : :|     %%\n" + 
					"%%        `'-::...______________________________________| |   .--..-'`-..--..--.|   :|     %%\n" + 
					"%%             ```'''-----------------------------------| |--'                   `'-'      %%\n" + 
					"%%                                                      | |                                %%\n" + 
					"%%                                                     _| |                                %%\n" + 
					"%%                                                    |___|                                %%\n" + 
					"%%                                                                                         %%\n" + 
					"%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n" + 
					"Fonte: https://www.asciiart.eu/ \n\n", 0);
			
			perdeVida(2);

		}
		
		//verifica se alberto n�o morreu
		if(!furioso == false) {
			
			digita("Alberto entrou pela porta e me viu cheio de linhas de c�digo nas m�os e o Trojan jogado no canto da sala. Ele viu que eu \n"
					+ "estava desesperado e tentou me consolar. Ele me abra�ou.\n" + 
					"Sentimos algo errado, quando olhamos para tras o Trojan estava de p�.\n\n", milisPorChar);
						
			//quarto desafio da bossfight
			digita("DESAFIO: \n", milisPorChar);
			digita("\n\n", milisPorChar);

			if (embaralhaEEscolheQuatroAlternativas(new String[] { "0", "", "", "" }, 0)) {
				// acertou
				digita("Ele veio em nossa dire��o, jogou o Alberto para um lado e eu para o outro.\n\n", milisPorChar);
				
			} else {
				// errou
				digita("Ele veio em nossa dire��o, jogou Alberto para um lado e me deu um soco que eu atravessei a sala toda.\n"
						+ "Bati minhas costelas na quina da mesa, quebrando algumas.\n\n", milisPorChar);
				
				perdeVida(2);

			}
			
			//quinto desafio da bossfight
			digita("DESAFIO: \n", milisPorChar);
			digita("\n\n", milisPorChar);

			if (embaralhaEEscolheQuatroAlternativas(new String[] { "0", "", "", "" }, 0)) {
				// acertou
				digita("Ele veio em minha dire��o, me segurou em uma m�o. Tentei me soltar, mas n�o consegui. De repente escutei um barulho alto, \n"
						+ "um barulho j� conhecido. Quando olhei para frente Trojan estava com uma cara de assustado. E ele come�ou a me soltar. \n"
						+ "Ele caiu no ch�o e vi Alberto com um revolver na m�o. Ele tinha conseguido na sala ao lado com os capangas do Trojan.\n\n", milisPorChar);
				
			} else {
				// errou
				digita("Ele veio em minha dire��o, me segurou em uma m�o e come�ou a me bater. Meu rosto estava doendo muito, achei que ia desmaiar naquela hora. \n"
						+ "Tentei me soltar, mas n�o consegui. De repente escutei um barulho alto, um barulho j� conhecido. Quando olhei para frente Trojan estava \n"
						+ "com uma cara de assustado. E ele come�ou a me soltar. Ele caiu no ch�o e vi Alberto com um revolver na m�o. Ele tinha conseguido na sala \n"
						+ "ao lado com os capangas do Trojan\n\n", milisPorChar);


			}
			
			
			finalDoJogo();	
			
		}

	}
	
	public static void finalDoJogo() throws Exception{
		if(vida>=5) {
			digita("Trojan estava no ch�o. Todas suas linhas de c�digo estavam esparramadas pela sala. Eu n�o acreditava no que estava vendo. Ele realmente estava morto. \n"
					+ "Ele come�ou a sumir. Pouco a pouco at� n�o restar nada.\n\n", milisPorChar);
			
			digita("/* Descobri tempos depois que por minha causa ele tinha sido apagado da internet de alguma forma. \n"
					+ "Era poss�vel que ele fosse uma entidade e quando o derrotei ele desapareceu.*/\n\n", milisPorChar);
			
			
			digita("N�o sei pra onde foi, e tamb�m n�o quero saber.\n" + 
					"Quando ele desapareceu completamente, foi a minha vez.\n" + 
					"Comecei a sentir um calor, n�o consegui me despedir de ningu�m.\n" + 
					"Antes que eu sumisse eu escutei uma voz ao fundo: \n\n", milisPorChar);
			
			digita("- As defini��es de v�rus foram atualizadas!\n\n", milisPorChar);
			
			digita("Eu nunca me senti t�o feliz em escutar a voz dele novamente. Aquilo foi a prova para mim de que ele estava bem...", milisPorChar);
			
			digita("FIM !", 120);
			
			agradecimentos();
		}else {
			
			digita("Trojan estava no ch�o. Todas suas linhas de c�digo estavam esparramadas pela sala. Eu n�o acreditava no que estava vendo. Ele realmente estava morto. \n"
					+ "Ele come�ou a sumir. Pouco a pouco at� n�o restar nada.\n\n", milisPorChar);
			
			digita("/* Descobri pouco tempo depois que ele n�o tinha desaparecido. Trojan era uma entidade, e parecia que ele tinha projetado apenas um clone no meu computador. \n"
					+ "Eu precisava fazer alguma coisa, mas n�o por hora. */\n\n", milisPorChar);
			
			
			digita("Quando ele desapareceu completamente, foi a minha vez.\n" + 
					"Comecei a sentir um calor, n�o consegui me despedir de ningu�m.\n" + 
					"Antes que eu sumisse eu escutei uma voz ao fundo:\n\n", milisPorChar);
			
			digita("- As defini��es de v�rus foram atualizadas!\n\n", milisPorChar);
			
			digita("Eu nunca me senti t�o feliz em escutar a voz dele novamente. Aquilo foi a prova para mim de que ele estava bem...", milisPorChar);
			
			digita("FIM !", 120);
			
			agradecimentos();
		}
	}
	
	public static void agradecimentos() throws Exception{
		
		digita("Obrigado por escutar a minha hist�ria!\n", milisPorChar);
		
		digita("At� uma pr�xima e n�o v� baixar arquivos suspeitos !!!", milisPorChar);
		
		menu();

		
	}
}
