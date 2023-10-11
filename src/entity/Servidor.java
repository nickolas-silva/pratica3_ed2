package entity;

import hash_encadeada.No_enc;
import hash_encadeada.Tabela_encadeada;

public class Servidor {
  
  public Tabela_encadeada dadosT = new Tabela_encadeada(7);
  
  public Servidor(){
    System.out.println("Servidor Inicializado!");
    
    
  }

  public void addVeiculoComprimido(String v){
    
    System.out.println("String comprimida: " + v);
    String descomp = Protocolo.compressor.decompress(v);
    System.out.println("String descomprimida: " + descomp);


    //FUNCIONA
    String[] datas = descomp.split("/");
    //Veiculo newV = new Veiculo(datas[0], datas[1], Integer.parseInt(datas[2]), datas[3], datas[4], Integer.parseInt(datas[5]));
    System.out.println("AQUIIIII" + datas[0] + datas[1] + datas[2] + datas[3] + datas[4] + datas[5]);
    //addVeiculo(newV);
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
