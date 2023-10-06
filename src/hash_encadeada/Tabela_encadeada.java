package hash_encadeada;

import entity.Veiculo;

public class Tabela_encadeada {
	
	Integer m;
	No_enc tabela[];
	
	public Tabela_encadeada(int tam) {
		this.m = tam;
		this.tabela = new No_enc[this.m];
	}
	
	public int hash(int k) {
		return k % m;
	}
	
	public void inserir(Veiculo v) {
		
		Integer c = this.hash(v.renavam);
		No_enc no = this.tabela[c];
		
		while(no != null) {
			
			if(no.chave == v.renavam) {
				break;
			}
			
			no = no.prox;
			
		}
		
		if(no == null) {
			
			no = new No_enc(v);
			no.prox = this.tabela[c];
			this.tabela[c] = no;
		}

	}
	
	public No_enc buscarMF(int k){
		int temp = hash(k);
		return this.buscarMF(tabela[temp], k);
	}

	public No_enc buscarMF(No_enc l, int k) {

		No_enc atual, anterior = null;
		for(atual = l; atual != null; atual = atual.prox){
			if(atual.chave == k){
				if(atual != tabela[hash(k)]){
					anterior.prox = atual.prox;
					atual.prox = tabela[hash(k)];
					tabela[hash(k)] = atual;

					return atual;
				}
				return atual;
			}
			anterior = atual;
		}
		return null;
	
	}
	
	public void imprimir() {
		
		No_enc no;
		
		for (int i = 0; i < this.m; i++) {
			
			no = this.tabela[i];
			System.out.print(i);
			
			while(no != null) {
				System.out.println(" --> " + no.valor.toString());
				no = no.prox;
			}
			
			System.out.println();
		}

	}

  public int contVeiculos(){
    int qnt = 0;
		for(int i = 0; i< tabela.length; i++){
			if(tabela[i] != null){
				qnt++;
				No_enc temp = tabela[i].prox;
				while(temp != null){
					qnt++;
					temp = temp.prox;
				}

			}
		}
		return qnt;

  }

  public void remover(int k) {

		int h = hash(k);

		No_enc atual, anterior = null;
		for(atual = tabela[h]; atual != null; atual = atual.prox){
			if(atual.chave == k){
				if(atual != tabela[h]){
					anterior.prox = atual.prox;
					
					atual = null;
					break;
					
				}
				else{
					tabela[hash(k)] = atual.prox;
					
					atual = null;

				}
			}
			anterior = atual;
		}


		
  //   int h = this.hash(k);
	// 	No_enc cabeca = tabela[h];

	// 	if(tabela[h] == null){
	// 		System.out.println("Veiculo nao encontrado!");
	// 		return;
	// 	}

  //   while(tabela[h] != null){
  //     if(tabela[h].valor.renavam == k){
  //       if(tabela[h].prox == null){
  //         tabela[h] = null;
  //         break;
  //       }
  //       else{
          
  //       }
        
        
  //     }
  //     else{
  //       tabela[h] = tabela[h].prox;
  //     }

  //   }
  //   System.out.println("Veiculo removido!");
		
  }




}