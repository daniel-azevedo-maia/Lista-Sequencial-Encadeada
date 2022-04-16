

import java.util.Locale;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		String respNovaDisciplina = "s";
		String respContinuarCadastro = "s";
		
		int total_disciplinas = 0;
		int j = 0;
		int pos = 0;
	
		ListaSequencial listaSeq = new ListaSequencial();

		while (respContinuarCadastro.equalsIgnoreCase("s")) {
			
		//CRIANDO ALUNOS:
			
			Aluno aln = new Aluno();
			ListaEncadeada listaEnc = new ListaEncadeada();
			Disciplinas disc = new Disciplinas();
			
			System.out.printf(" ---- CADASTRANDO O %dº ALUNO ---- \n", j + 1);
						
			System.out.print(" - Informe o RGM: ");
			int matricula = sc.nextInt();
					
					aln.rgm = matricula;				
								
			System.out.print(" - Informe a disciplina: ");
			String disciplina = sc.next();
			
			System.out.print(" - Informe a nota: ");
			double nota = sc.nextDouble();
				
					disc.nomeDisciplina = disciplina;
					disc.nota = nota;
					listaEnc.inserirDisciplinaInicio(disc);
					
					aln.setDisciplinas(listaEnc);
					
					listaEnc.exibirLista();
					
			
			System.out.print(" - Deseja cadastrar nova disciplina [S/N]? ");
			respNovaDisciplina = sc.next();
			
			while (respNovaDisciplina.equalsIgnoreCase("s")) {
								
				System.out.print(" - Informe a disciplina: ");
				disciplina = sc.next();
				
				System.out.print(" - Informe a nota: ");
				nota = sc.nextDouble();
					
						disc.nomeDisciplina = disciplina;
						disc.nota = nota;
						listaEnc.inserirDisciplinaNoFim(disc);
						
						aln.setDisciplinas(listaEnc);
						
						listaEnc.exibirLista();
	
				System.out.print(" - Deseja cadastrar nova disciplina [S/N]? ");
				respNovaDisciplina = sc.next();
			}
			
			listaSeq.inserirAluno(pos, aln);
			pos++;
			j++;
			System.out.println();
			
			System.out.print(" - Deseja cadastrar novo aluno [S/N]? ");
			respContinuarCadastro = sc.next();
			System.out.println();
		}
		
		String continuar = "s";
		
		while(continuar.equalsIgnoreCase("s")) {
			

		System.out.println("---- ESCOLHA UMA OPÇÃO: ----\n");
		
		System.out.println("[  1  ] Mostrar alunos e notas");
		System.out.println("[  2  ] Procurar aluno pelo RGM");
		System.out.println("[  3  ] Remover aluno pelo RGM");
		System.out.println("[  4  ] Sair");
		
		System.out.print("Opção: ");
		int opcao = sc.nextInt();
		
		switch(opcao) {
		
			case 1:
				//Mostrar todos
				System.out.println("\n ---- ALUNOS CADASTRADOS: ----\n");
				for(int i = 0; i < listaSeq.tamanho; i++) {
					System.out.println("Aluno de RGM " + listaSeq.aluno[i].getRgm() + ":\n");
					listaSeq.aluno[i].disciplinas.exibirLista();
					System.out.println();
				}
				
				break;
			
			case 2:
				//Procurar pelo RGM
				System.out.print("\nInforme o RGM do aluno: ");
				int mat = sc.nextInt();
				listaSeq.revelaAluno(mat);
				
				break;
			
			case 3:
				//Remover pelo RGM
				System.out.print("\nInforme o RGM do aluno: ");
				mat = sc.nextInt();
				listaSeq.removerAluno(mat);
				
				if (listaSeq.tamanho > 0) {
					System.out.println("Estado atual dos alunos: \n");
					for(int i = 0; i < listaSeq.tamanho; i++) {
						System.out.println("Aluno de RGM " + listaSeq.aluno[i].getRgm() + ":\n");
						listaSeq.aluno[i].disciplinas.exibirLista();
						System.out.println();
					}
				} else {
					System.out.println("Todos os alunos foram removidos. Não há mais alunos cadastrados!");
				}
				
				break;
			
			case 4:
				break;
				
			default:
				System.out.println("Opção inválida.");
						
		}
		
		System.out.print("Deseja continuar [S/N]? ");
		continuar = sc.next();	
		System.out.println();
		}
		
		System.out.println("Muito obrigado!");
		
	}

}

