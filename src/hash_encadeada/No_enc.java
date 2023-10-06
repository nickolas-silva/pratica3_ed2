package hash_encadeada;

import entity.Veiculo;

public class No_enc {
  Integer chave;
  public Veiculo valor;
  No_enc prox;

  public No_enc(Veiculo v){
    this.chave = v.renavam;
    this.prox = null;
    this.valor = v;

  }

}
