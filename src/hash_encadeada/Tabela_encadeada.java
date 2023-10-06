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
	
	public No_enc buscar(int k) {
		
		// Integer c = this.hash(k);
		// No_enc no = this.tabela[c];
		
		// while(no != null) {
			
		// 	if(no.chave == k)
		// 		return no;
			
		// 	no = no.prox;
		// }
		// return null;
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
		No_enc aux[];
		No_enc ex;
		aux = tabela;
    for(int i = 0; i < aux.length; i++){
      qnt++;
			while(aux[i].prox != null){
				ex = aux[i].prox;
				qnt++;
				System.out.println(ex);
			}
     

    }
    return qnt;

  }

  public void remover(int k) {
    int h = this.hash(k);

		if(tabela[h] == null){
			System.out.println("Veiculo nao encontrado!");
			return;
		}

    while(tabela[h] != null){
      if(tabela[h].valor.renavam == k){
        if(tabela[h].prox == null){
          tabela[h] = null;
          break;
        }
        else{
          while(tabela[h].prox != null){
            //No_enc aux = tabela[h];
            tabela[h] = tabela[h].prox;
            tabela[h].prox = null;
            //tabela[h] = tabela[h].prox;
            
          }
          break;
        }
        
        
      }
      else{
        tabela[h] = tabela[h].prox;
      }

    }
    System.out.println("Veiculo removido!");
  }




}