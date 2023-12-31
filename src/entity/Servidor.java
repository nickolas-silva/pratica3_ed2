package entity;

import hash_encadeada.Tabela_encadeada;

public class Servidor {
  
  public Tabela_encadeada dadosT = new Tabela_encadeada(29);
  
  public Servidor(){
    System.out.println("Servidor Inicializado!");
    
    
  }

  public void addVeiculoComprimido(String v){
    
    System.out.println("String comprimida: " + v);
    String descomp = Protocolo.huffman.descomprimir(v);
    System.out.println("String descomprimida: " + descomp);


    //FUNCIONA
    String[] dadosV = descomp.split("/");
    Veiculo newV = new Veiculo(dadosV[0], dadosV[1], dadosV[2], dadosV[3], dadosV[4], Integer.parseInt(dadosV[5]));
    
    addVeiculo(newV);
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
  
  public String editar(String v){

    //DESCOMPRIMINDO
    String descomp = Protocolo.huffman.descomprimir(v);
    String[] dadosEditado = descomp.split("/");

    Veiculo vEditado = new Veiculo(dadosEditado[0], dadosEditado[1], dadosEditado[2], dadosEditado[3], dadosEditado[4], Integer.parseInt(dadosEditado[5]));
    dadosT.remover(vEditado.renavam);
    dadosT.inserir(vEditado);

    return "Veiculo atualizado!";

    
  }

  public int contarVeiculos(){
    return dadosT.contVeiculos();
    
  }

  public String buscarVeiculo(String renavam){
    Integer kDescomp;
     kDescomp = Integer.parseInt(Protocolo.huffman.descomprimir(renavam)) ;
          
    return Protocolo.huffman.comprimir(dadosT.buscarMF(kDescomp).valor.toString());
  }
}
