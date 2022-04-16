
public class ListaEncadeada {

	Disciplinas primeiro = null;
	Disciplinas ultimo = null;
	int tamanho = 0;

	public boolean estaVazia() {
		if (tamanho == 0) {
			return true;
		}
		return false;
	}
	
	public void inserirDisciplinaInicio(Disciplinas a) {
		Disciplinas nova = new Disciplinas();
		nova.nomeDisciplina = a.nomeDisciplina;
		nova.nota = a.nota;
		if ( estaVazia() ) {
			primeiro = ultimo = nova;
		} else {
			nova.proximo = primeiro;
			primeiro = nova;
		}
		tamanho++;
	}
	
	public void inserirDisciplinaNoFim(Disciplinas a) { 
		Disciplinas nova = new Disciplinas();
		nova.nomeDisciplina = a.nomeDisciplina;
		nova.nota = a.nota;
		if ( estaVazia() ) {
			primeiro = ultimo = nova;
		} else {
			ultimo.proximo = nova;
			ultimo = nova;
		}
		tamanho++;
	}
	
	public void exibirLista() {
		Disciplinas temp = primeiro;
		if ( estaVazia() == false ) { 
			for (int i = 0; i < tamanho; i++) {
				System.out.println("   Matéria: " + temp.getNomeDisciplina() + " -----> Nota: " + temp.getNota());
				temp = temp.proximo;
			}
		}
	}

}
