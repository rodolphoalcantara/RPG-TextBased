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
	static long milisPorChar = 65;// padrão = 65
	static Scanner entrada = new Scanner(System.in);
	static Random random = new Random();

	public static void main(String[] args) throws Exception {

		inicioDoJogo();

		// testes:
		//gameover();
		// menu();
		// capituloQuatro();
		// prologo();
		// capituloUm();
		// capituloTres();
		// capituloTresDelegacia();
		// capituloTresBanco();
		// capituloTresBRain();
	}

	public static void inicioDoJogo() throws Exception {
		digita("Rodolpho, Felipe e Gessione\n" + "Apresentam: \n\n", 120);

		digita("###############################################################################\n"
				+ "##                                                                           ##\n"
				+ "##  .___________..______        ______          __       ___      .__  __.   ##\n"
				+ "##  |           ||   _  \\      /  __  \\        |  |     /   \\     |  \\ |  |  ## \n"
				+ "##  `---|  |----`|  |_)  |    |  |  |  |       |  |    /  ^  \\    |   \\|  |  ##\n"
				+ "##      |  |     |      /     |  |  |  | .--.  |  |   /  /_\\  \\   |  . `  |  ##\n"
				+ "##      |  |     |  |\\  \\----.|  `--'  | |  `--'  |  /  _____  \\  |  |\\   |  ##\n"
				+ "##      |__|     | _| `._____| \\______/   \\______/  /__/     \\__\\ |__| \\__|  ##\n"
				+ "##                                                                           ##\n"
				+ "###############################################################################\n\n\n", 0);

		digita("  \n\n", 1000);
		menu();

	}

	// métodos do jogo

	public static void menu() throws Exception {
		boolean repetir = false;
		do {
			digita("1 Jogar\n", milisPorChar);
			digita("2 Opções\n", milisPorChar);
			digita("3 Creditos\n", milisPorChar);
			digita("4 Sair\n", milisPorChar);
			int n1 = entrada.nextInt();

			switch (n1) {

			case 1:
				modoDeJogo();
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
				System.out.print("\n Não tem essa opção !!!\n");
				System.out.print(" Tente novamente\n\n");
				repetir = true;
				break;

			}

		} while (repetir);

	}

	// escolhe o modo de jogo: Normal(do inicio) e capitulos(escolher um)
	public static void modoDeJogo() throws Exception {
		while (true) {
			digita("Escolha o modo de jogo: \n", milisPorChar);
			digita("1. Normal\n" + "2. Capítulos\n" + "3. Sair\n\n", milisPorChar);

			int escolha = entrada.nextInt();
			switch (escolha) {
			case 1:
				jogar();
				break;
			case 2:
				capitulos();
				break;
			case 3:
				menu();
				break;

			default:
				digita("Não entendi o que você quis dizer . . .\n\n", milisPorChar);
				break;
			}
		}

	}

	public static void jogar() throws Exception {

		while (true) {
			digita("Você gostaria que eu te contasse o começo da história ?\n", milisPorChar);
			digita("1. SIM\n" + "2. NÃO\n" + "3. Voltar ao Menu\n\n", milisPorChar);

			int escolha = entrada.nextInt();
			switch (escolha) {
			case 1:
				prologo();
				break;
			case 2:
				capituloUm();
				break;
			case 3:
				menu();
				break;

			default:
				digita("Não entendi o que você quis dizer . . .", milisPorChar);
				break;
			}
		}

	}

	public static void capitulos() throws Exception {

		while (true) {

			digita("Qual capitulo você gostaria que eu contasse?\n", milisPorChar);
			digita("1. Querida encolhi as crianças\n" + "2. Procurando Trojan\n" + "3. Selva de Bytes\n"
					+ "4. O Poderoso Chefão (Final)\n" + "5. Voltar ao Menu\n\n", milisPorChar);

			int escolha = entrada.nextInt();
			switch (escolha) {
			case 1:
				capituloUm();
				break;
			case 2:
				capituloDois();
				break;
			case 3:
				capituloTres();
				break;
			case 4:
				capituloQuatro();
				break;
			case 5:
				menu();
				break;

			default:
				digita("Não entendi o que você quis dizer . . .", milisPorChar);
				break;
			}
		}

	}

	// opções: usuário escolhe a velocidade do texto
	public static void opcao() throws Exception {
		boolean sair = false, aceitou = false;
		do {
			digita("Escolha a velocidade de digitação.\n", milisPorChar);
			digita("1 EXTREMAMENTE Rápido\n", milisPorChar);
			digita("2 Rápido\n", milisPorChar);
			digita("3 Normal\n", milisPorChar);
			digita("4 Devagar\n", milisPorChar);
			digita("5 Sair\n", milisPorChar);
			int option = entrada.nextInt();
			switch (option) {
			case 1:
				milisPorChar = 5;
				digita("Alterado para extremamente rápido!\n", milisPorChar);
				break;
			case 2:
				milisPorChar = 35;
				digita("Alterado para rápido!\n", milisPorChar);
				break;
			case 3:
				milisPorChar = 65;
				digita("Alterado para normal!\n", milisPorChar);
				break;
			case 4:
				milisPorChar = 100;
				digita("Alterado para devagar!\n", milisPorChar);
				break;
			case 5:
				digita("\n\n", milisPorChar);
				menu();
				break;

			default:
				digita("Valor incorreto será utilizado o valor padrão! \n", milisPorChar);
				milisPorChar = 65;
				break;
			}

			digita("Teste: ", milisPorChar);
			digita("Este é um jogo que faz parte de um projeto da Faculdade Senac, desenvolvido pelos alunos \n"
					+ "Felipe Fabrini, Gessione Freitas e Rodolpho Alcântara. No jogo, você interpreta o papel de um jovem estudioso \n"
					+ "que ao instalar um vírus, entra no computador e precisa desintalar esse software malicioso para sair da maquina.\n",
					milisPorChar);
			do {
				digita("Esta velocidade está boa? \n", milisPorChar);
				digita("1 SIM\n", milisPorChar);
				digita("2 NÃO\n", milisPorChar);
				int aceita = entrada.nextInt();
				switch (aceita) {
				case 1:
					digita("Vamos voltar para o menu!\n\n\n", milisPorChar);
					aceitou = true;
					sair = true;
					break;
				case 2:
					digita("Vamos tentar selecionar a velocidade de novo...\n", milisPorChar);
					aceitou = true;
					break;

				default:
					digita("Não entendi! Tente novamente...\n", milisPorChar);
					break;
				}

			} while (!aceitou);

		} while (!sair);
		menu();
	}

	// métodos de funcionalidades do game

	/**
	 * Método que retira quantidade de vidas do total do jogador.
	 * 
	 * @param hit Recebe um Int equivalente a quantidade de hits que irá tirar da
	 *            vida total
	 */
	public static void perdeVida(int hit) throws Exception {
		if (hit >= vida) {
			System.out.println("GameOver!\n\n");
			gameover();
			// FIM DO JOGO//
		} else {
			vida = vida - hit;
			digita("\n\n Você perdeu " + hit + " HP\n", 60);
			digita("\n Você possui " + vida + " HP\n\n", 60);
		}
	}

	/**
	 * Método que adiciona um bonus de vida ao valor atual do player
	 *
	 * @param extra Recebe um Int equivalente a quantidade de vidas que o player irá
	 *              receber
	 */
	public static void bonusDeVida(int extra) {
		if (extra > 0) {
			vida = vida + extra;
		}

	}

	/**
	 * Método que imprime na tela aos poucos. Funciona como uma máquina de escrever.
	 * 
	 * @param mensagem     Uma string que deseja imprimir na tela
	 * @param milisPorChar Velocidade que os caracteres serão impressos na tela
	 *                     ("Velocidade da digitação")
	 * @throws InterruptedException
	 */
	public static void digita(String mensagem, long milisPorChar) throws InterruptedException {
		for (int i = 0; i < mensagem.length(); i++) {
			System.out.print(mensagem.charAt(i));

			Thread.sleep(milisPorChar);
		}
	}

	/**
	 * Método que abre o arquivo de imagem localizado na raiz do projeto, na pasta
	 * img.
	 * 
	 * @param imagem String com o nome da imagem e sua extenção Ex: test.jpg
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
	 * @param indiceCorreto indice do array de alternativas que é a correta (OBS:
	 *                      indice começa no 0)
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
				digita("Alternativa não existe!", milisPorChar);
				break;
			}
		} while (!sai);
		
		//parte que verifica
		if (escolhaCorreta == alternativas[indiceCorreto]) {
			return true;
		} else {
			return false;
		}

	}

	// Metodos dos Capitulos

	public static void prologo() throws Exception {

		digita("\nPROLOGO\n\n", milisPorChar);

		digita("23 de Março de 2020. Um dia que eu achava ser mais um dia comum, ficará pra sempre em minhas lembranças.\n"
				+ "Mas, para contar o que houve, preciso primeiro me apresentar.\n\n", milisPorChar);
		digita("Meu nome é Lucas, um adolescente de 14 anos que sempre foi muito interessado em tecnologi.a\n"
				+ "Nunca fui bem nas matérias escolares, porém, o que eu mais gostava de fazer depois das aulas era descobrir coisas novas na internet,\n"
				+ "e talvez tenha sido essa minha curiosidade que me levou a tudo isso\n\n", milisPorChar);
		digita("Já havia passado, mais ou menos, duas semanas desde a suspenção das aulas por conta da quarentena de Covid19\n"
				+ "Estava eu, como de costume, com vinte abas abertas no meu navegador, aprendendo coisas novas.\n"
				+ "A quarentena me deixou com muito tempo livre, e eu estava usando este tempo para aprender mais coisas sobre programação e computação.\n\n",
				milisPorChar);
		digita("Uma dessas abas era sobre uma matéria, em um site comum de notícias Tech, que falava sobre a DeepWeb.\n"
				+ "Fiquei fascinado por aquilo e resolvi investigar.\n\n", milisPorChar);
		digita("Após seguir todos os preparativos, resolvi entrar em um fórum qualquer e me deparei com um usuário,\n"
				+ "chamado Jon Art, que prometia um Aplicativo capaz de resolver todos meus problemas.\n"
				+ "Ele iria ser uma ferramenta que me possibilitaria elevar meu conhecimento\n\n", milisPorChar);
		digita("Achei aquilo muito estranho, parecia que tinha sido feito pra mim,\n"
				+ "porém pensei comigo mesmo: - Que mal tem?!\n\n", milisPorChar);
		digita("E não percebi que só tinha mal nisso.\n\n"
				+ "Minha inocência me fez baixar o arquivo e instalar em meu computador\n"
				+ "Quando o loading da instalação teve fim, o computador começou a se comportar de um jeito estranho.\n\n",
				milisPorChar);
		digita("A tela ficou toda preta, como de um terminal em tela inteira. E algo começou a ser escrito:\n\n",
				milisPorChar);

		digita("######################################################\r\n"
				+ "##                                                  ##\r\n"
				+ "##        Bem-vindo ao aplicativo Soul Eater        ##\r\n"
				+ "##                       by                         ##\r\n"
				+ "##                    JON  ART                      ##\r\n"
				+ "##                                                  ##\r\n"
				+ "######################################################\n\n", 5);

		digita("De repente, aconteceu uma interferência e o nome do criador começou a mudar, e se mostrou algo totalmente diferente:\n\n",
				milisPorChar);

		digita("######################################################\r\n"
				+ "##                                                  ##\r\n"
				+ "##        Bem-vindo ao aplicativo Soul Eater        ##\r\n"
				+ "##                       by                         ##\r\n"
				+ "##                     TROJAN                       ##\r\n"
				+ "##                                                  ##\r\n"
				+ "######################################################\n\n", 5);

		digita("\r\n"
				+ "Percebi que talvez deveria ter lido os termos de uso, e quando menos esperava meu computador\ncomeçou a eletrizar e como um passe de mágica tudo ficou escuro.\n\n\n",
				milisPorChar);

		capituloUm();

	}

	public static void capituloUm() throws Exception {

		digita("Capítulo Um - Querida Encolhi as Crianças!\n\n", milisPorChar);

		digita("Quando abri meus olhos me vi em algum lugar que lembrava uma cidade, porém, de um jeito diferente\n"
				+ "Era tudo preto, como uma tela de um terminal, e as linhas brancas formavam prédios e avenidas\n"
				+ "Deveria ter sido uma linda cidade um dia, contudo, com a instalação do SoulEater,\n"
				+ "em menos de segundos a cidade tinha se transformado em ruínas\n" + "um cenário pós-apocalíptico.\n\n",
				milisPorChar);

		digita("Descobri que estava em meu computador, nos altos dos prédios destruídos\n"
				+ "algo como outdoors mostravam memes que tinha salvo há alguns dias.\n"
				+ "E em minha visão aparecia algo como um contador de vidas, como em um jogo de vídeo game.\n\n",
				milisPorChar);

		digita("Fiquei olhando para aqueles vídeos e não percebi que um grupo de malwares estavam vindo em minha direção.\nEram capangas do TROJAN"
				+ " e estavam tentando me levar a força para seu chefe.\n\n", milisPorChar);

		digita("\nDESAFIO: \n\n", milisPorChar);

		digita("Na Algebra Booleana AND e OR são representados com quais sinais matemática?\n\n", milisPorChar);

		if (embaralhaEEscolheQuatroAlternativas(new String[] { "Multiplicação e Adição", "Subtração e Divisão",
				"Multiplicação e divisão", "Subtração e Adição" }, 0)) {
			// acertou
			digita("\nComecei a ir para trás e me vi encurralado em uma espécie de beco, olhei para o lado e tinha um grande cano feito de bytes.\n"
					+ " Usei este cano como uma lança e destruí os malwares, de um jeito que nem eu imaginaria conseguir.\n"
					+ " De repente das sombras saiu um vulto branco brilhante\r\n" +

					"\n", milisPorChar);
		}
		// errou
		else {
			digita("\nComecei a ir para trás e me vi encurralado em uma espécie de beco,\n"
					+ " olhei para o lado e tinha apenas uma lata de lixo, como aquelas americanas que vemos em filmes, só que feita de bytes\n"
					+ "Peguei a tampa e usei como um escudo... apanhei bastante e com isso perdi um coração de vida\n"
					+ "Mas para meu alívio, vi um vulto branco que foi em direção ao grupo de malwares e, com a ajuda dele, os derrotamos. \n",
					milisPorChar);
			perdeVida(1);
		}

		digita("Olá forasteiro. - O brilhoso ser falou – O que você quer em meu território?! Por favor identifique-se. \n",
				milisPorChar);
		digita("Quando ele falou aquilo seu brilho começou a diminuir e se mostrou um chefe de polícia, meio machucado e com sua barba de bytes por fazer. \n",
				milisPorChar);
		digita("- Irei pedir só mais uma vez. Por favor identifique-se. - Disse agora com um tom enérgico. \n",
				milisPorChar);

		digita("Depois de explicar quem eu era e tudo o que aconteceu, o policial estava me olhando com uma cara de espanto.\n"
				+ "Apenas pelo seu semblante pude notar um mix de emoções\n"
				+ "Felicidade, por estar conhecendo seu criador e a pessoa em que todos os moradores do computador admiravam.\n"
				+ "E Raiva, por descobrir que seu criador havia causado toda aquela destruição e mortes.\n"
				+ "Porém, mesmo sentindo tudo isso ele sabia que a única pessoa que podia acabar com tudo aquilo era eu.\n\n"
				+ "- Veja, tudo o que aconteceu. Antes, essas ruas eram cheias de bytes andando de um lado pro outro\n"
				+ "Trafegando informações para onde você solicitava.\n\n"
				+ "Víamos que você adorava passar horas no computador e isso nos alegrava.\n"
				+ "Mas, um dia você resolveu entrar em um fórum e baixar aquele software malicioso \n\n"
				+ "– Disse o policial que agora estava sentindo tristeza lembrando de seus amigos e familiares mortos.\n"
				+ "- Bom... Não devemos viver do passado. – disse ele – Somente VOCÊ pode nos salvar.\n"
				+ "Só você pode desinstalar esse vírus na PORRADA.\n\n", milisPorChar);

		capituloDois();

	}

	public static void capituloTres() throws Exception {

		digita("Capítulo Três - Selva de Bytes\n\n", milisPorChar);

		digita("Depois de nos informar onde seu chefe estava e sobre essa tal chave de acesso,\n"
				+ "o Spyware estava preparando para falar como a gente poderia conseguir a chave.\n"
				+ "Quando a gente menos esperava, o capanga ficou mudo. De repente escutamos uma voz:\n\n"
				+ "- Auto-destruição programada. Acontecerá em 5 segundos.\n\n"
				+ "Eu e o meu parceiro nos olhamos com cara de assustados, de primeira não acreditamos.\n"
				+ "Porém, quando a contagem regressiva começou, saímos correndo.\n\n", milisPorChar);

		digita("Contagem regressivan\n", milisPorChar);

		digita("5\n", 1000);
		digita("4\n", 1000);
		digita("3\n", 1000);
		digita("2\n", 1000);
		digita("\nFechei meus olhos e esperei a explosão...\n", milisPorChar);
		digita("1", 1000);
		//
		digita(" \n... \n... \n...\n", milisPorChar);

		digita("\n - Ué – pensei comigo – não explodiu?! \n", milisPorChar);
		digita("O que aconteceu foi apenas um delete normal.\n"
				+ "Todas as linhas de código do vírus foram deletadas…\n", milisPorChar);
		digita("Por um momento me senti aliviado e parece que isso me rendeu um coração a mais.\n\n", milisPorChar);
		bonusDeVida(1);
		
		digita("## Você recebeu 1HP ##\n\n", milisPorChar);
		
		digita("Paramos e pegamos o mapa da cidade.\n" + "- Onde nós deveríamos procurar? – perguntou Alberto.\n\n"
				+ "", milisPorChar);

		boolean repetir = false;
		do {
			digita("Podemos ir para o Banco ou a delegacia, qual você gostaria de ir:\n", milisPorChar);
			digita("1. Banco\n", milisPorChar);
			digita("2. Delegacia\n", milisPorChar);
			int n1 = entrada.nextInt();

			switch (n1) {
			case 1:
				capituloTresBanco();

			case 2:
				capituloTresDelegacia();

			default:
				System.out.print("\n Não tem essa opção !!!\n");
				System.out.print(" Tente novamente\n\n");
				repetir = true;
				break;
			}
		} while (repetir);
	}

	public static void capituloDois() throws Exception {

		digita("Capitulo Dois - Procurando Trojan\n\n", milisPorChar);
		
		digita("Depois de conversarmos, o Delegado Alberto Vast - foi assim que ele se identificou - me contou sobre tudo que aconteceu.\n"
				+ "Ao que me parece nos poucos segundos que demorou para instalar e eu aparecer neste mundo, se passou anos de dor e sofrimento.\n\n"
				+ "Cada palavra que eu ouvia ia me deixando com mais raiva e minha vontade de exterminar o TROJAN só ia aumentando.\n\n"
				+ "Foi aí que o Alberto me contou seu plano, fazer com que os capangas abrissem o bico.\n\n"
				+ "Decidimos ir a uma casa noturna onde um grupo de capangas se encontrava para beber e jogar papo fora.\n"
				+ "Porém, quando chegamos na fachada do estabelecimento vimos que não podíamos somente entrar.\n\n"
				+ "Identifiquei algo que parecia ser um circuito e que a saída deveria ser a resposta para destrancar a porta e poder prosseguir.\n"
				+ " Procurei em minhas lembranças as aulas de circuitos lógicos que eu vi no Youtube.\n\n"
				+ "Algo veio em minha mente e então fui em direção da 'fechadura'.\n\n", milisPorChar);

		digita("\nDESAFIO: \n\n", milisPorChar);

		digita("No circuito apresentado, que possui tres entradas ( A, B e C ) e uma saída f (A, B, C),\n"
				+ "qual opção apresenta uma expressão lógica equivalente a função f (A, B, C)?\n\n", milisPorChar);
		visualizaImagem("excap2.png");
		if (embaralhaEEscolheQuatroAlternativas(new String[] { "(A'.B)+(B+C)", "(A.'B)+(B'.C)", "(A'+B)+(B.C)'", "(A+B)' + (B'+C)" }, 0)) {
			// acertou
			digita("\nUma 'voz-porteiro', que parecia sair da fechadura, me diz:\n"
					+ "-Você pode prosseguir desta vez, porem aqui não é seu lugar...\n"
					+ "Antes que eu pudesse entrar no estabelecimento, tropeço em um byte mal colocado e caio no chão, derrubando algumas latas e fazendo barulho.\n",
					milisPorChar);
		}
		// errou
		else {
			digita("\nUma 'voz-porteiro', que parecia sair da fechadura, me diz:\n"
					+ "- Você errou a senha. Errar mais 2 vezes irá soar o alarme.\n", milisPorChar);

			if (embaralhaEEscolheQuatroAlternativas(new String[] { "A'B+BC", "A'B+B'C", "AB+BC'", "AB'+B'C" }, 0)) {
				// acertou
				digita("\nUma 'voz-porteiro', que parecia sair da fechadura, me diz:\n"
						+ "-Você pode prosseguir desta vez, porem aqui não é seu lugar...\n"
						+ "Antes que eu pudesse entrar no estabelecimento, tropeço em um byte mal colocado e caio no chão, derrubando algumas latas e fazendo barulho.\n",
						milisPorChar);
			}
			// errou
			else {
				digita("\nUma 'voz-porteiro', que parecia sair da fechadura, me diz:\n"
						+ "- Você errou a senha. Errar mais 1 vezes irá soar o alarme.\n"
						+ "Porem ao ouvir a voz o circuito se modificou\n\n", milisPorChar);
				visualizaImagem("excap2.1.png");

				if (embaralhaEEscolheQuatroAlternativas(
						new String[] { "ABC (A+D)", "ABC+(A+D)", "ABC'(A+D)'", "'A'BC+(A+D)'" }, 0)) {
					// acertou
					digita("\nUma 'voz-porteiro', que parecia sair da fechadura, me diz:\n"
							+ "-Voce pode prosseguir desta vez, porém aqui não é seu lugar...\n"
							+ "Antes que eu pudesse entrar no estabelecimento, tropeço em um byte mal colocado e caio no chão, derrubando algumas latas e fazendo barulho.\n",
							milisPorChar);
				}
				// errou
				else {
					digita("\nA 'voz-porteiro' grita:\n" + "- Tentativas esgotadas. INTRUSO. INTRUSO. INTRUSO...\n"
							+ "Enquanto o barulho percorre o estabelecimento, o porteiro lança uma descarga de choque que me derruba no chão.\n",
							milisPorChar);
					perdeVida(1);
				}
			}
		}
		digita("Antes que eu pudesse me levantar um grupo de vírus, capangas de Trojan, vinha em minha direção.\n"
				+ "Para minha sorte eles estavam meio 'bugados' por conta das bebidas virtuais.\n"
				+ " Suas funções estavam alteradas e eu sentia que, mesmo em menor n�mero, eu e meu parceiro pod�amos ganhar deles.\n\n"
				+ "Quando eles me percebem, tentando me levantar desajeitadamente, por entre as garrafas vazias que eu acabara de derrubar.\n"
				+ "O que parecia ser o líder do bando gritou:\n"
				+ "- É o Rei Lucas, aquele que o chefe quer. PEGUEM ELEEE!!!\n\n", milisPorChar);

		// ponto decisivo na historia

		digita("\nDESAFIO: \n\n", milisPorChar);

		digita("Observe a porta logica e atraves da tabela verdade responda\n\n", milisPorChar);
		visualizaImagem("excap2.2.png");
		if (embaralhaEEscolheQuatroAlternativas(
				new String[] { "A=0|B=1|S=1", "A=1|B=0|S=0", "A=1|B=1|S=1", "A=0|B=0|S=1" }, 0)) {
			// acertou
			digita("\nO primeiro veio em minha direção, mesmo pisando em falso por ter acabado de levantar, consegui desviar de seus ataques.\n"
					+ "Por estar mais bêbado que os demais ele se desequilibrou caiu no chão e desmaiou.\n"
					+ "Vieram mais dois em nossa direção.\n"
					+ "Vendo o primeiro desmaiado fez com que ficassem com mais raiva e viessem para cima da gente.\n"
					+ "Mas por sorte com a ajuda do meu parceiro, conseguimos quebrar a cara dos capangas.\n\n",
					milisPorChar);
		}
		// errou
		else {
			digita("\nO primeiro veio em minha direção, ainda estava me levantando e mal tive tempo de me esquivar\n"
					+ "ja esperava receber o primeiro soco, mas quando olhei pra cima vi que meu parceiro derrubou o primeiro antes que eu pudesse levantar.\n"
					+ "Vieram mais dois em nossa direção.\n"
					+ "Vendo o primeiro desmaiado fez com que ficassem com mais raiva e viessem para cima da gente.\n"
					+ "Congelei na hora vendo aquela situação, porem nem eu e nem meu parceiro conseguimos imobiliza-los. Caímos no chão!\n\n",
					milisPorChar);
			// proximo desafio.

			digita("\nDESAFIO: \n\n", milisPorChar);

			digita("Observe a porta lógica e atraves da tabela verdade responda\n\n", milisPorChar);
			visualizaImagem("excap2.3.png");
			if (embaralhaEEscolheQuatroAlternativas(
					new String[] { "A=1|B=0|S=1", "A=0|B=1|S=0", "A=1|B=1|S=1", "A=0|B=0|S=0" }, 0)) {
				// acertou

				digita("\nDessa vez foi o líder do bando que veio em nossa direção, ele era mais forte e estava com uma garrafa de cerveja quebrada na mão.\n"
						+ "A luta durou alguns minutos.\n"
						+ "Eu e meu parceiro lutamos lado a lado parecendo o japon�s e o americano da Hora do Rush.\n"
						+ "Apos intensos minutos de briga, conseguimos derrota-lo mas com muita dificuldade.\n",
						milisPorChar);
			}
			// errou
			else {
				digita("\nDessa vez foi o líder do bando que veio em nossa direção, ele era mais forte e estava com uma garrafa de cerveja quebrada na mão.\n"
						+ "A luta durou alguns minutos.\n"
						+ "Não cedemos até o ultimo minuto, porem ele era mais forte e acabou com a nossa raça.\n\n"
						+ "Mesmo depois de muito esforço, não conseguimos sair dessa cilada. Nos vimos cercados de capangas que saiam de todos os lados.\n\n",
						milisPorChar);
				gameover();
			}
		}

		digita("\nMesmo depois de alguns problemas que tivemos na situação conseguimos sair por cima.\n"
				+ "O líder do bando conseguiu fugir, mas conseguimos capturar o capanga bêbado que desmaiou.\n\n"
				+ "Esperamos o capanga acordar, sua identificação era: Spyware. Ele era um criminoso que, por sorte nossa, tinha informações importantíssimas.\n"
				+ "Ele nos disse onde o chefe dele estava, mas pra isso nós deveríamos conseguir uma chave de acesso antes...\n"
				+ "A permissão do Administrador.\n\n", milisPorChar);

		capituloTres();

	}

	public static void capituloQuatro() throws Exception {

		digita("Capítulo Quatro – O Poderoso Chefão (Final)\n\n\n", milisPorChar);
		digita("Enquanto estávamos nos esgueirando por entre os prédios e casas, fiquei pensando como seria se não tivesse \n"
				+ "baixado aquele vírus. Talvez estaria tranquilo em casa comendo salgadinho e tomando refrigerante enquanto \n"
				+ "assistia algum vídeo no Youtube.\n\n", milisPorChar);
		digita("Alberto viu que meu pensamento estava longe e logo me repreendeu. Disse-me pra focar no nosso objetivo. \n"
				+ "Tínhamos que planejar a invasão na prefeitura.\n\n", milisPorChar);
		digita("Quando chegamos no prédio da prefeitura, vimos algo que me desanimou. Estava cheio de capangas. \n"
				+ "Devia ter uns oito vírus de baixo escalão fazendo ronda.\n\n", milisPorChar);

		digita("Porém o policial tinha um plano desde o inicio.\n" + "\n" + "Decidimos enfrenta-los.\n" + "\n\n",
				milisPorChar);

		digita("DESAFIO: \n", milisPorChar);

		visualizaImagem("Q1Cap4.jpg");
		digita("Qual é a equação do circuito da imagem?\n\n", milisPorChar);

		if (embaralhaEEscolheQuatroAlternativas(
				new String[] { "(A’.B.C).(A+D)’", "(A.B.C).(A+D)", "(A.B.C)’.(A+D)’", "(A’+B+C)+(A.D)’" }, 0)) {
			// acertou
			digita("\nPegamos pedaços de cano que pareciam ser de ferro e fomos de encontro aos capangas. De repente vimos policiais amigos\n"
					+ " do Alberto. Eles Vieram nos ajudar.\n\n", milisPorChar);
			digita("Estávamos agora em seis contra oito vírus. Mas mesmo em menor numero os policiais eram habilidosos. Eles sabiam lutar com seus cassetetes. \n"
					+ "Conseguimos entrar!\n\n", milisPorChar);

		} else {
			// errou
			digita("\nPegamos pedaços de cano que pareciam ser de ferro e fomos de encontro aos capangas. De repente vimos policiais amigos\n"
					+ " do Alberto. Vieram nos ajudar. Porém eles estavam feridos.\n\n", milisPorChar);
			digita("Estávamos em seis contra oito vírus. Mas mesmo os policiais sendo habilidosos, a saúde deles não estava bem. Fomos derrotando\n"
					+ " um por um dos vírus. Mas estávamos ficando cansados e feridos. Com isso vi minha vida descendo dois pontos.\n\n",
					milisPorChar);

			perdeVida(2);

		}
		digita("Estávamos dentro da prefeitura. Os policiais ficaram do lado de fora para nos proteger de possíveis reforços do inimigo. \n"
				+ "E eles também estavam esperando os reforços da delegacia. Parecia que o plano estava dando certo.\n\n",
				milisPorChar);
		digita("No hall principal percebemos algo de errado. Não tinha ninguém.\n\n", milisPorChar);
		digita("Estávamos crentes que teria vários capangas. Mas no final das contas não tinha nenhum. Abaixamos a guarda e nos separamos \n"
				+ "para procurar alguma pista. Estava eu de um lado do hall e o Alberto do outro quando de repente surgiram os capangas do\n"
				+ "trojan com cães e porretes. O medo adentrou meu corpo.\n\n", milisPorChar);

		// desafio antes do dado
		digita("DESAFIO: \n", milisPorChar);
		digita("Lucas está no meio de uma enrascada, para ajuda-lo converta a palavra LUTA para binário. \n"
				+ "Obs.: Tabela Ascii DECIMAL(L:76, U: 85, T: 84, A: 65).\n\n", milisPorChar);

		if (embaralhaEEscolheQuatroAlternativas(new String[] { "(0100 1100), (0101 0101), (0101 0100), (0100 0001)",
				"(0100 0001), (0101 0100), (0101 0101), (0100 1100)",
				"(0100 0110), (0101 0101), (0100 0111), (0100 0001)",
				"(0101 0100), (0101 0010), (0100 1111), (0100 1100), (0100 1100)" }, 0)) {
			// acertou
			digita("\nUm grupo de capangas veio em minha direção e outro na direção do Alberto. A intenção deles era nos deixar separados.\n"
					+ "Eu estava com um cassetete dos policiais que vieram nos ajudar e consegui me defender. Derrubei um dos capangas e cuidei de seu cachorro.\n"
					+ "Alberto conseguiu se defender mas estava em uma enrascada\n" + "O plano era nos juntarmos.\n\n",
					milisPorChar);

		} else {
			// errou
			digita("\nUm grupo de capangas veio em minha direção e outro na direção do Alberto. A intenção deles era nos deixar separados.\r\n"
					+ "Eu ainda estava com um cano na mão, mas isso não era o suficiente. Derrubei um dos capangas, mas o cachorro dele veio \n"
					+ "em minha direção e mordeu meu braço.\r\n", milisPorChar);
			perdeVida(2);

			digita("\n\nAlberto estava na mesma enrascada que eu.\n" + "O plano era nos juntarmos.\n", milisPorChar);

		}

		digita("Conseguimos nos juntar, e por isso ainda restavam capangas para derrotarmos. Estávamos esperando ser fácil, mas pensamos errado.\n"
				+ "Eles vieram com fúria em nossa direção querendo acabar com a nossa vida. Mas, por sorte, conseguimos dar um jeito neles. \n"
				+ "Parecia que minha força estava acabando.\n\n", milisPorChar);

		digita("## Para avançar na história você precisa jogar um dado de 20 lados ##\n", milisPorChar);
		int numeroTiradoNoDado = 0;
		// jogar os dados
		numeroTiradoNoDado += random.nextInt(20) + 1;
		digita("...\n", 1000);
		digita("você tirou: " + numeroTiradoNoDado + "!\n\n", milisPorChar);

		// destino de Alberto
		if (numeroTiradoNoDado <= 10) {
			// alberto morre
			digita("\nTínhamos conseguido nos livrar dos capangas, estávamos nos recuperando para avançar. Escutei duas pessoas conversando:\n"
					+ "- Não podemos matar ele, o chefe o quer vivo! – disse um dos capangas.\n"
					+ "- Mas o outro ele não disse nada! – disse o outro. \n"
					+ "De repente escutei um barulho muito alto e quando olhei para o Alberto ele estava no chão. Com suas linhas de código esparramadas pelo chão.\n"
					+ "Antes que pudesse gritar senti um choque percorrendo todo meu corpo e então desmaiei.\n\n",
					milisPorChar);
			furioso = true;
			digita("## Você sentiu a perda de seu amigo, e acordou em estado de fúria! ## \n"
					+ "## (O número de desafios na BossFight diminuiu!) ##\n\n", milisPorChar);

		} else {
			// alberto vive
			digita("\nTínhamos conseguido nos livrar dos capangas, estávamos nos recuperando para avançar. Escutei duas pessoas conversando:\n"
					+ "- Não podemos matar eles, o chefe os quer vivo! – disse um dos capangas.\n"
					+ "- Ah! Tá bom! – disse o outro decepcionado.\n"
					+ "Antes que pudesse virar para ver quem era senti um choque percorrendo todo meu corpo e então desmaiei.\n\n",
					milisPorChar);

			bonusDeVida(3);
			digita("## Por conseguir se juntar ao seu amigo, você se sente mais forte! ## \n"
					+ "## (Você ganhou 3 HP) ##\n\n", milisPorChar);

		}

		// BOSS FIGHT
		digita("Quando eu abri os olhos vi o Trojan na minha frente. Era um cara gordo, parecia o rei do crime dos quadrinhos. \n"
				+ "Estava fumando um charuto e bebendo alguma coisa em um copo chique.\n"
				+ "Estava falando comigo, mas não consegui entende-lo. Ainda estava meio zonzo. \n"
				+ "A única coisa que passava em minha mente é que precisava me soltar e tentar acabar com ele, custe o que custar.\n\n",
				milisPorChar);

		// primeiro desafio da bossfight
		digita("DESAFIO: \n", milisPorChar);

		digita("Por algum motivo, Lucas se lembrou de estudar sobre os postulados de Boole. Mas não consegue lembrar quais são os três principais tipos. \n"
				+ "Ele não conseguirá se concentrar na batalha enquanto não souber. Ajude o Lucas:\n\n", milisPorChar);

		if (embaralhaEEscolheQuatroAlternativas(new String[] { "Postulados: Complementação, Adição e Multiplicação",
				"Postulados: Implementação, Adição e Multiplicação", "Postulados: Adição, Subtração e Multiplicação",
				"Postulados: Divisão, Subtração e Complementação" }, 0)) {
			// acertou
			digita("\nEle veio em minha direção com seu charuto tentou apaga-lo minha mão, \n"
					+ "fui mais rápido e virei fazendo com que queimasse a corda e eu conseguisse me soltar da cadeira.\n",
					milisPorChar);

			digita("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% \n" + "%%                                      %%\n"
					+ "%%                  __                  %%\n" + "%%                 [  ]                 %%\n"
					+ "%%                 |  |                 %%\n" + "%%                 |  |                 %%\n"
					+ "%%                /    \\                %%\n" + "%%               /      \\               %%\n"
					+ "%%              |        |              %%\n" + "%%              |        |              %%\n"
					+ "%%              |        |              %%\n" + "%%              |        |              %%\n"
					+ "%%              |        |              %%\n" + "%%              |        |              %%\n"
					+ "%%              [________]              %%\n" + "%%                                      %%\n"
					+ "%%                                      %%\n" + "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n\n",
					0);

			digita("Corri na direção dele com uma garrafa de bebida, que peguei de sua mesa, e bati em sua cabeça, ele tonteou e caiu para trás.\n"
					+ "Aproveitei para procurar alguma coisa que eu pudesse me armar. A visão dele caído no chão me deu motivação.\n\n",
					milisPorChar);

		} else {
			// errou
			digita("\nEle veio em minha direção com seu charuto tentou apaga-lo minha mão, não consegui desviar. Gritei de dor. \n"
					+ "Aquele charuto estava muito quente, minha mão ficou em chamas. Com a dor que senti consegui me soltar da cadeira.\n"
					+ "Corri na direção dele, ele me segurou e me jogou para trás. Ele era muito forte. Caí por cima da mesa. Ele estava vindo em minha direção. \n"
					+ "Começou a me enforcar. Olhei para o lado e vi a garrafa de bebida que estava sobre a mesa. \n\n",
					milisPorChar);
			digita("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% \n" + "%%                                      %%\n"
					+ "%%                  __                  %%\n" + "%%                 [  ]                 %%\n"
					+ "%%                 |  |                 %%\n" + "%%                 |  |                 %%\n"
					+ "%%                /    \\                %%\n" + "%%               /      \\               %%\n"
					+ "%%              |        |              %%\n" + "%%              |        |              %%\n"
					+ "%%              |        |              %%\n" + "%%              |        |              %%\n"
					+ "%%              |        |              %%\n" + "%%              |        |              %%\n"
					+ "%%              [________]              %%\n" + "%%                                      %%\n"
					+ "%%                                      %%\r\n"
					+ "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n\n", 0);
			digita("Segurei ela firme e bati em sua cabeça, ele tonteou e caiu para trás. Aproveitei para procurar \n"
					+ "alguma coisa que eu pudesse me armar. Estava respirando forte. Mas visão dele caído no chão me deu motivação.\n\n",
					milisPorChar);
			perdeVida(2);

		}

		// segundo desafio da bossfight
		digita("DESAFIO: \n", milisPorChar);
		digita("Enquanto Lucas lutava, em sua frente viu um binário piscando na parede do Hall, parecia o Matrix.\n"
				+ "## 01000100 01000101 01010011 01010100 01001001 01001110 01001111 ##\n"
				+ "Ajude o Lucas a descobrir que mensagem está aparecendo.\n\n", milisPorChar);

		if (embaralhaEEscolheQuatroAlternativas(new String[] { "DESTINO", "BINARIO", "PROJETO", "DESEJOS" }, 0)) {
			// acertou
			digita("\nProcurei na sala e vi que tinha derrubado uma faca de caça quando peguei a garrafa de cima da mesa, antes que ele pudesse reagir \n"
					+ "corri em sua direção e fiz algo que não achei que seria capaz. Enfiei a faca em seu peito.\n",
					milisPorChar);
			digita("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n"
					+ "%%                                                      ___                                %%\n"
					+ "%%                                                    |_  |                                %%\n"
					+ "%%                                                      | |                                %%\n"
					+ "%%  __                      ____                        | |                                %%\n"
					+ "%%  \\ ````''''----....____.'\\   ````''''----------------| |--.         _____      .-.      %%\n"
					+ "%%   :.                      `-._                       | |   `---''''```   ``''|`: :|     %%\n"
					+ "%%    '::.                       `'--.._________________| |                     | : :|     %%\n"
					+ "%%      '::..       ----.....___________________________| |                     | : :|     %%\n"
					+ "%%        `'-::...______________________________________| |   .--..-'`-..--..--.|   :|     %%\n"
					+ "%%             ```'''-----------------------------------| |--'                   `'-'      %%\n"
					+ "%%                                                      | |                                %%\n"
					+ "%%                                                     _| |                                %%\n"
					+ "%%                                                    |___|                                %%\n"
					+ "%%                                                                                         %%\n"
					+ "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n"
					+ "Fonte: https://www.asciiart.eu/ \n\n", 0);

		} else {
			// errou
			digita("\nProcurei na sala e vi que tinha derrubado uma faca de caça quando peguei a garrafa de cima da mesa, fui em direção dela, mas ele me puxou pela perna. \n"
					+ "Caí de boca no chão e quase perdi a consciência. Ele estava me chutando no chão enquanto eu tentava pegar a faca. Consegui alcança-la e ele percebeu. \n"
					+ "Quando ele veio por cima de mim e tentou tirar a faca da minha mão, fiz algo que não achei que seria capaz. Enfiei a faca em seu peito.\n",
					milisPorChar);
			digita("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n"
					+ "%%                                                      ___                                %%\n"
					+ "%%                                                    |_  |                                %%\n"
					+ "%%                                                      | |                                %%\n"
					+ "%%  __                      ____                        | |                                %%\n"
					+ "%%  \\ ````''''----....____.'\\   ````''''----------------| |--.         _____      .-.      %%\n"
					+ "%%   :.                      `-._                       | |   `---''''```   ``''|`: :|     %%\n"
					+ "%%    '::.                       `'--.._________________| |                     | : :|     %%\n"
					+ "%%      '::..       ----.....___________________________| |                     | : :|     %%\n"
					+ "%%        `'-::...______________________________________| |   .--..-'`-..--..--.|   :|     %%\n"
					+ "%%             ```'''-----------------------------------| |--'                   `'-'      %%\n"
					+ "%%                                                      | |                                %%\n"
					+ "%%                                                     _| |                                %%\n"
					+ "%%                                                    |___|                                %%\n"
					+ "%%                                                                                         %%\n"
					+ "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n"
					+ "Fonte: https://www.asciiart.eu/ \n\n", 0);

			perdeVida(2);

		}

		// verifica se alberto não morreu
		if (furioso == false) {

			digita("Alberto entrou pela porta e me viu cheio de linhas de código nas mãos e o Trojan jogado no canto da sala. Ele viu que eu \n"
					+ "estava desesperado e tentou me consolar. Ele me abraçou.\n"
					+ "Sentimos algo errado, quando olhamos para tras o Trojan estava de pé.\n\n", milisPorChar);

			// terceiro desafio da bossfight
			digita("DESAFIO: \n", milisPorChar);
			digita("A palavra escrita em binário a seguir: \n" + "## 01001000 01000101 01010010 01001111 01001001 ##\n"
					+ "Pode ser facilmente convertida para hexadecimal, ajude Lucas a lembrar.\n\n", milisPorChar);

			if (embaralhaEEscolheQuatroAlternativas(
					new String[] { "48 45 52 4f 49", "54 52 4f 4c 4c", "54 52 4f 49 41", "4d 4f 52 54 45" }, 0)) {
				// acertou
				digita("\nEle veio em minha direção, me segurou em uma mão. Tentei me soltar, mas não consegui. De repente escutei um barulho alto, \n"
						+ "um barulho já conhecido. Quando olhei para frente Trojan estava com uma cara de assustado. E ele começou a me soltar. \n"
						+ "Ele caiu no chão e vi Alberto com um revolver na mão. Ele tinha conseguido na sala ao lado com os capangas do Trojan.\n\n",
						milisPorChar);

			} else {
				// errou
				digita("\nEle veio em minha direção, me segurou em uma mão e começou a me bater. Meu rosto estava doendo muito, achei que ia desmaiar naquela hora. \n"
						+ "Tentei me soltar, mas não consegui. De repente escutei um barulho alto, um barulho já conhecido. Quando olhei para frente Trojan estava \n"
						+ "com uma cara de assustado. E ele começou a me soltar. Ele caiu no chão e vi Alberto com um revolver na mão. Ele tinha conseguido na sala \n"
						+ "ao lado com os capangas do Trojan\n\n", milisPorChar);

			}

		}

		finalDoJogo();

	}

	public static void capituloTresDelegacia() throws Exception {

		digita("\nDelegacia de Polícia - Muro de Fogo\n\n", milisPorChar);
		digita("- Poderíamos ir para a delegacia, deve haver alguém informado lá.\n"
				+ "– disse eu, em tom esperançoso.\n" + "Alberto olhou pra mim\n"
				+ "– aparentando vergonha por saber da situação de sua delegacia\n" + "– e acenou com a cabeça\n"
				+ "Fomos para a delegacia e ao chegarmos lá me deparei com um enorme muro de fogo.\n"
				+ "Feito para que nenhuma pessoa, nesse caso software, sem autorização pudesse entrar.\n"
				+ "Mas claro que entrei, eu estava com o delegado!\n", milisPorChar);
		digita("Quando entrei vi uma cena lamentável, policiais sentados, alguns feridos, outros cuidando dos feridos.\n"
				+ "Parecia uma situação de guerra, mas ali estavam seguros.\n"
				+ "Alberto foi ver se seus subordinados e amigos estavam precisando de algo e me disse para procurar na sala dele,\n"
				+ "pois tinha um cofre que ele nunca tinha aberto. E Nem sabia o que podia ter dentro.\n"
				+ "Fui até lá e a senha estava escrita em decimal do lado do cofre. Porém, o cofre precisava de uma senha em hexadecimal.\n\n",
				milisPorChar);

		// DESAFIO
		int saida = 0;
		do {
			digita("A senha é TROJAN escrito em Hexadecimal\n\n"

					+ "Obs.: Tabela Ascii DECIMAL( T: 84, R: 82, O: 79 , J: 74 A: 65, N: 78)\n\n", milisPorChar);
			if (embaralhaEEscolheQuatroAlternativas(
					new String[] { "54524F4A414E", "597A4G4A6D2A1", "A1D4E533HF1", "A1D8E9A6S1F1" }, 0)) {

				// acertou

				digita("\n- Consegui! – dei um grito que todos puderam ouvir.\n"
						+ "Quando olhei para trás tinha três policiais com caras de assustados e armas em punho me olhando.\n"
						+ "E o Alberto veio logo em seguida.\n" + "E aí?! Será que está aí?!\n"
						+ "Procurei dentro do cofre, mas só encontrei papelada,\n"
						+ "algumas permissões daquelas que damos aos softwares sem nem vermos durante a instalação.\n"
						+ "Dentre algumas delas estava até a do Trojan.	Mas, nada da permissão do administrador...\n\n"
						+ "Quando eu falei sobre a permissão em voz alta, um dos policiais mais velhos disse:\n"
						+ "- Por que vocês não pedem direto para o Administrador?!\n"
						+ "Ele pode até ter sido corrompido pelo Trojan, mas ele pode te dar a permissão se gostar de você.\n"
						+ "Ele ainda vive em sua empresa.\n", milisPorChar);
				saida = 1;

			} else {
				digita("\nVocê errou !!! tente novamente:\n", milisPorChar);
			}

		} while (saida == 0);

		digita("\n- Aquela escrita “B. Rain”! – apontando para a janela.\n\n", milisPorChar);
		// ENTRAR NA B RAIN

		capituloTresBRain();

	}

	public static void capituloTresBanco() throws Exception {

		digita("\nBanco Data \n\n", milisPorChar);
		digita("- Poderíamos ir ao Banco, alguém pode ter informação sobre algo. – disse eu, em tom esperançoso.\n"
				+ "Meu companheiro aceitou, acenando com a cabeça.\n"
				+ "Chegando ao banco vimos os funcionários com medo e capangas do Trojan indo e voltando com informações.\n"
				+ "Aquele prédio parecia um banco de dados gigantesco. Guardava dados como se fosse dinheiro.\n"
				+ "Disfarçamo-nos e em uma brecha entramos no banco.\n"
				+ "Um dos funcionários, um gerente de conta, me reconheceu e entrou na onda:\n"
				+ "- Olá senhor G. Chrome tudo bem?! Veio acessar seus dados? – disse ele.\n"
				+ "- Por favor, venha comigo que irei levar ao seu cofre!\n"
				+ "– disse ele arregalando os olhos e acenando com a cabeça\n"
				+ "Entrei com ele, confesso que estava com medo, mas, ele me parecia ser confiável.\n"
				+ "Imaginei que os cidadãos que ainda tinham sobrevivido não estavam satisfeitos com aquele modo de vida.\n"
				+ "Ele me levou até meu cofre e contou sua história.\n"
				+ "Disse que os vírus estavam roubando os dados de vários aplicativos e levando ao chefe deles.\n"
				+ "Quando cheguei ao meu cofre lembrei que talvez não soubesse minha senha,\n"
				+ " tentei algumas possíveis, mas não tive sucesso.\n"
				+ "Foi ai que o gerente do banco me deu um papel com uma dica:\n"
				+ "Uma senha em decimal que eu teria que colocar em meu cofre, porém ele só aceitava hexadecimal.\n",
				milisPorChar);
		// DESAFIO
		int saida = 0;
		do {
			digita("A senha é TROJAN escrito em Hexadecimal\n\n"
					+ "Obs.: Tabela Ascii DECIMAL( T: 84, R: 82, O: 79 , J: 74 A: 65, N: 78)\n\n", milisPorChar);

			if (embaralhaEEscolheQuatroAlternativas(
					new String[] { "54524F4A414E", "597A4G4A6D2A1", "A1D4E533HF1", "A1D8E9A6S1F1" }, 0)) {
				// ACERTOU
				digita("\n- Consegui! – disse eu, já entrando naquele enorme cofre.\n"
						+ "Tinha poucos itens dentro, informações pessoais, fotos, vídeos...\n"
						+ "Coisas mais restritas que não estavam passando nos telões da cidade.\n"
						+ "Mas, nada de permissão do administrador.\n"
						+ "- Poxa Alberto, não achei a permissão do administrador. – falei decepcionado\n"
						+ "Quando eu disse isso o gerente me olhou e perguntou:\n"
						+ "Por que vocês não pedem direto para o Administrador?!\n"
						+ "Ele pode até ter sido corrompido pelo Trojan, mas ele pode te dar a permissão se gostar de você.\n"
						+ "Ele ainda vive em sua empresa.\n", milisPorChar);
				digita("- Aquela escrita “B. Rain”! – apontando para a janela\n\n", milisPorChar);

				saida = 1;

			} else {
				digita("\nVocê errou !!! tente novamente:\n", milisPorChar);
			}

		} while (saida == 0);

		// PARTE DA B.RAIN
		capituloTresBRain();

	}

	public static void capituloTresBRain() throws Exception {
		// digita("", milisPorChar);

		digita("B. RAIN\n\n", milisPorChar);

		digita("Seguimos os conselhos do nosso novo amigo.\n"
				+ "Eu e meu parceiro, o delegado A. Vast, fomos até o prédio B. Rain.\n"
				+ "Era enorme, parecia não ter fim, seus andares sumiam em meio às nuvens de bytes.\n"
				+ "Quando chegamos a frente às grandes portas do prédio ela se abriu.\n"
				+ "Entramos em uma antessala e ouvimos uma voz:\n\n"
				+ "- Olá Lucas! Ou será que devo lhe chamar de vossa Alteza?!\n"
				+ "– Disse ele gargalhando de uma forma debochada.\n\n"
				+ "Um calor começou a subir pelo meu rosto e gritei.\n"
				+ "Tentei coloca-lo em seu lugar, ora, eu era o rei não é mesmo?\n"
				+ "Como um trovão sua voz ecoou por todo prédio:\n\n"
				+ "- VOCÊ NÃO TEM PODER AQUI, Lucas o Rei! – Disse ele com um tom ameaçador.\n"
				+ "Senti que ele tinha parado e respirado. E retornou dizendo:\n" + "- Bom, vamos fazer um acordo.\n"
				+ " Se conseguir vir até minha sala darei minha permissão.\n\n"
				+ "As luzes da sala se apagaram, o medo tomou conta de mim.\n "
				+ "Como um flash a sala se acendeu, mas agora estava diferente.\n"
				+ "Possuía um painel em seu centro me perguntando se queria prosseguir,\n"
				+ "caso a resposta fosse sim eu não sairia até completar o desafio.\n"
				+ "Porém eu não tinha escolha se eu desistisse aconteceria o pior.\n" + "Então eu aceitei…\n\n",
				milisPorChar);

		// Loop que não prossegue enquanto não acertar.

		digita("As luzes se apagaram novamente, dessa vez quando voltou tudo mudou de cor,\n"
				+ "as paredes possuíam um tom de azul claro esverdeado e em uma delas estava um quadro.\n"
				+ "Quando cheguei próximo do quadro ele se acendeu e se mostrou o desafio.\n\n", milisPorChar);
		int sai = 0;
		do {
			digita("\nDESAFIO: \n\n", milisPorChar);

			digita("escolha a alternativa correto onde SPYWARE esteja escrito em octal\n"
					+ "Obs.: Tabela Ascii DECIMAL( S: 83, P: 80, Y: 89 , W: 87 A: 65, R: 82, E: 69)\n\n", milisPorChar);
			if (embaralhaEEscolheQuatroAlternativas(new String[] { "123 120 131 127 101 122 105", "123 125 135 127 231 125 105",
					"123 165 161 427 101 622 105", "123 160 185 123 141 122 105" }, 0)) {

				// acertou
				digita("\nA luz se apagou novamente. Estava nervoso para ver o administrador\n"
						+ "Eu e meu parceiro ficamos de costas um pro outro, esperando o pior.\n"
						+ "Quando a luz se acendeu estava ele lá parado na minha frente.\n"
						+ "Era EU! Ele tinha minha cara. Fiquei apavorado, mas ele me explicou.\n"
						+ "Como eu era o dono do computador, eu era o próprio administrador.\n"
						+ "Ele virou pra mim com um cartão.\n"
						+ "Algo como um cartão de acesso escrito: Administrador.\n"
						+ "- Você vai precisar de uma ajuda, o Trojan é forte. Tome isso, leve com você!\n"
						+ "– disse o Administrador me entregando uma espécie de colete resistente.\n\n", milisPorChar);
				bonusDeVida(1);
				
				digita("## Você recebeu 1 HP ##\n\n", milisPorChar);

				sai = 1;

			} else {
				digita("\nVocê errou !!! tente novamente:\n", milisPorChar);
			}

		} while (sai == 0);
		//  Fim da questão.

		digita("Agradeci e tomei meu rumo, estava nervoso.\n"
				+ "Olhei para meu parceiro ele parecia confuso. Nunca tinha visto do administrador.\n"
				+ "Mas ele entendeu o que tudo aquilo significava e ficou mais motivado.\n"
				+ "Ele sabia que a hora estava chegando. Saímos do prédio com determinação.\n"
				+ "E fomos de encontro a Prefeitura!!\n\n", milisPorChar);

		capituloQuatro();

	}

	public static void finalDoJogo() throws Exception {
		if (vida >= 5) {
			digita("Trojan estava no chão. Todas suas linhas de código estavam esparramadas pela sala. Eu não acreditava no que estava vendo.\n"
					+ "Ele realmente estava morto. \n"
					+ "Ele começou a sumir. \n"
					+ "Pouco a pouco até não restar nada.\n\n", milisPorChar);

			digita("/* Descobri tempos depois que por minha causa ele tinha sido apagado da internet de alguma forma. \n"
					+ "Era possível que ele fosse uma entidade e quando o derrotei ele desapareceu.*/\n\n",
					milisPorChar);

			digita("Não sei pra onde foi, e também não quero saber.\n"
					+ "Quando ele desapareceu completamente, foi a minha vez.\n"
					+ "Comecei a sentir um calor, não consegui me despedir de ninguém.\n"
					+ "Antes que eu sumisse eu escutei uma voz ao fundo: \n\n", milisPorChar);

			digita("######     - As definições de vírus foram atualizadas!     ######\n\n", milisPorChar);

			digita("Eu nunca me senti tão feliz em escutar a voz dele novamente. Aquilo foi a prova para mim de que ele estava bem...\n\n",
					milisPorChar);

			digita("FIM !\n\n\n", 180);

			agradecimentos();
		} else {

			digita("Trojan estava no chão. Todas suas linhas de código estavam esparramadas pela sala. Eu não acreditava no que estava vendo. Ele realmente estava morto. \n"
					+ "Ele começou a sumir. Pouco a pouco até não restar nada.\n\n", milisPorChar);

			digita("/* Descobri pouco tempo depois que ele não tinha desaparecido. Trojan era uma entidade, e parecia que ele tinha projetado apenas um clone no meu computador. \n"
					+ "Eu precisava fazer alguma coisa, mas não por hora. */\n\n", milisPorChar);

			digita("Quando ele desapareceu completamente, foi a minha vez.\n"
					+ "Comecei a sentir um calor, não consegui me despedir de ninguém.\n"
					+ "Antes que eu sumisse eu escutei uma voz ao fundo:\n\n", milisPorChar);

			digita("- As definições de vírus foram atualizadas!\n\n", milisPorChar);

			digita("Eu nunca me senti tão feliz em escutar a voz dele novamente. Aquilo foi a prova para mim de que ele estava bem...\n\n",
					milisPorChar);

			digita("FIM !\n\n\n", 180);

			agradecimentos();
		}
	}

	public static void agradecimentos() throws Exception {

		digita("Obrigado por escutar a minha história!\n", 100);

		digita("Até uma próxima e não vá baixar arquivos suspeitos !!!\n\n", 100);

		digita("... \n\n\n", 1000);

		menu();

	}

	public static void gameover() throws Exception {
		
		digita("G A M E - O V E R\n\n", milisPorChar);
		
		digita("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n" + 
				"%%                                          %%\n" + 
				"%%           @@@@@@@@@@@@@@@@@@             %%\n" + 
				"%%         @@@@@@@@@@@@@@@@@@@@@@@          %%\n" + 
				"%%       @@@@@@@@@@@@@@@@@@@@@@@@@@@        %%\n" + 
				"%%      @@@@@@@@@@@@@@@@@@@@@@@@@@@@@       %%\n" + 
				"%%     @@@@@@@@@@@@@@@/      \\@@@/   @      %%\n" + 
				"%%    @@@@@@@@@@@@@@@@\\      @@  @___@      %%\n" + 
				"%%    @@@@@@@@@@@@@ @@@@@@@@@@  | \\@@@@@    %%\n" + 
				"%%    @@@@@@@@@@@@@ @@@@@@@@@\\__@_/@@@@@    %%\n" + 
				"%%     @@@@@@@@@@@@@@@/,/,/./'/_|.\\'\\,\\     %%\n" + 
				"%%       @@@@@@@@@@@@@|  | | | | | | | |    %%\n" + 
				"%%                     \\_|_|_|_|_|_|_|_|    %%\n" + 
				"%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n" + 
				"Fonte: https://www.asciiart.eu/\n\n", 0);

		digita("Minha visão estava turva. Ela começou a se fechar.\n"
				+ "Toda a minha vida estava passando por meus olhos.\n" + "Não conseguia gritar e nem chorar.\n"
				+ "Só me lembrava de meus pais. \n" + "Foi então que morri.\n"
				+ "Eu sou apenas um resquício de alma humana. Meu corpo se transformou em um vírus e está na companhia de Trojan.\n"
				+ "Minha alma vaga pelos computadores de outras pessoas para contar minha história.\n"
				+ "Trojan está livre pela internet.\n" + "O que ele fez comigo fará com outras pessoas.\n"
				+ "Você deixará isso acontecer?\n", milisPorChar);
		digita("\n\n", 1000);

		menu();

	}
}
