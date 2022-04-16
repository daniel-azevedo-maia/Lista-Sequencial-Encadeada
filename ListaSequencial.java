import java.util.Arrays;

public class ListaSequencial {

	public Aluno[] aluno = new Aluno[60];
	public int tamanho = 0;

	public ListaSequencial(Aluno[] aluno) {
		this.aluno = aluno;
	}

	public ListaSequencial() {
		this.tamanho = 0;
	}

	public Aluno[] getAluno() {
		return aluno;
	}

	public void setAluno(Aluno[] aluno) {
		this.aluno = aluno;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public boolean estaVazia() {
		return (tamanho == 0);
	}

	public boolean estaCheia() {
		return (tamanho == aluno.length);
	}

	public int tamanhoLista() {
		return tamanho;
	}

	public Aluno buscar(int pos) {

		if ((pos >= tamanho) || (pos < 0)) {
			return null;
		}
		return aluno[pos];
	}

	public void deslocaDireita(int pos) {
		for (int i = tamanho; i > pos; i--) { // N�o vai acontecer na inclus�o do 1� elemento. Esse for vai do TAMANHO
												// DA LISTA at� esse tamanho ficar MAIOR do que a posi��o indicada
			aluno[i] = aluno[i - 1];
		}
	}

	public boolean inserirAluno(int pos, Aluno a) {
		if (estaCheia() || (pos > tamanho) || (pos < 0))
			return false;
		deslocaDireita(pos);
		aluno[pos] = a;
		tamanho++;
		return true;
	}

	public void deslocaEsquerda(int pos) {
		for (int i = pos; i < (tamanho - 1); i++) {
			aluno[i] = aluno[i + 1];
		}
	}

	public void removerAluno(int mat) {
		
		boolean encontrou = false;
		
		for (int i = 0; i < tamanho; i++) {

			if (aluno[i].rgm == mat) {
				for (i = 0; i < tamanho; i++) {
					if (aluno[i].rgm == mat) {
						aluno[i] = aluno[i + 1];
					}
				}
				tamanho--;
				System.out.println("Aluno removido com sucesso!\n");
				return;
				
			} else {
				encontrou = false;
			}
		}
		
		if (encontrou == false) {
			System.out.println("Aluno n�o encontrado! RGM inv�lido.");
		}
		
	}

	public void revelaAluno(int mat) {
		
		boolean encontrou = false;

		for (int i = 0; i < tamanho; i++) {

			if (aluno[i].rgm == mat) {
				System.out.printf("\nNotas do aluno RGM %d: \n", aluno[i].rgm);
				System.out.println();
				aluno[i].disciplinas.exibirLista();
				System.out.println();
				encontrou = true;
				return;
				
	
			} else {
				encontrou = false;
			}
		}
		
		if (encontrou == false) {
			System.out.println("Aluno n�o encontrado! RGM inv�lido.");
		}

	} // Fim do m�todo revelaAluno()

} // Fim da lista sequencial
