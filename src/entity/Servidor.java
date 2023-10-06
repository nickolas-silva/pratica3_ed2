package entity;

import hash_encadeada.No_enc;
import hash_encadeada.Tabela_encadeada;

public class Servidor {
  
  //public Tabela dadosT = new Tabela(57);
  public Tabela_encadeada dadosT = new Tabela_encadeada(7);
  
  public Servidor(){
    System.out.println("Servidor Inicializado!");
    
    
  }

  public void addVeiculo(Veiculo v){
    dadosT.inserir(v);
  }

  public void exibirVeiculos(){
    dadosT.imprimir();
  }

  public void removerVeiculo(Integer renavam){
    dadosT.remover(renavam);
  }
  
  public String editar(Integer renavam, Veiculo v){

    dadosT.remover(renavam);
    dadosT.inserir(v);

    return "Veiculo atualizado!";

    
  }

  public int contarVeiculos(){
    return dadosT.contVeiculos();
    
  }

  public No_enc buscarVeiculo(Integer renavam){
    return dadosT.buscarMF(renavam);
  }
}
