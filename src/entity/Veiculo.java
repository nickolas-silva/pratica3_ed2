package entity;

public class Veiculo {
  public String placa;
  public Integer renavam;
  public String nome_condutor;
  public String cpf_condutor;
  public String modelo;
  public String ano_fabri;

  public Veiculo(String placa, String modelo, String ano_fabri, String cpf_condutor, String nome_condutor, Integer renavam) {
    this.placa = placa;
    this.renavam = renavam;
    this.nome_condutor = nome_condutor;
    this.cpf_condutor = cpf_condutor;
    this.modelo = modelo;
    this.ano_fabri = ano_fabri;
  }

  @Override
  public String toString() {
    //  return "Veiculo [placa=" + placa + ", renavam=" + renavam + ", nome_condutor=" + nome_condutor + ", cpf_condutor="
    //      + cpf_condutor + ", modelo=" + modelo + ", data_fabri=" + ano_fabri + "]";
    return placa + "/" + modelo + "/" + ano_fabri + "/" + cpf_condutor + "/" + nome_condutor + "/" + renavam;
  }

  public Veiculo(){
    
  }
}
