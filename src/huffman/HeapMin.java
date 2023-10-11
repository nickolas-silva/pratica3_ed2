package huffman;

import java.util.ArrayList;
import java.util.List;

public class HeapMin {
  List<No_Huf> heap;

  HeapMin(){
    this.heap = new ArrayList<No_Huf>();
  }

  public int piso(double n){
    return (int) n;
  }

  public void subir(int i, List<No_Huf> h){
    int j;
    No_Huf temp;

    j = piso((i-1) / 2);

    if(j >= 0 && h.get(i).freq < h.get(j).freq){
      temp = h.get(i);
      h.set(i, h.get(j));
      h.set(j, temp);

      subir(j, h);
    }
  }

  public void descer(int i, List<No_Huf> h, int tam){
    int j;
    No_Huf temp;

    j = 2 * i + 1;

    if(j < tam){

      if(j<tam - 1){
        if(h.get(j).freq > h.get(j+1).freq){
          j++;
        }

      }

      if(h.get(j).freq < h.get(i).freq){
        temp = h.get(i);
        h.set(i, h.get(j));
        h.set(j, temp);


        descer(j, h, tam);
      }
    }
  }

  public void contruirHeap(){
    int i;
    int tam = this.heap.size();

    for(i = piso( tam/ 2) - 1; i>=0; i--){
      descer(i, this.heap, tam);
    }
  }

  public void inserir(No_Huf no){
    int tam = this.heap.size();

    if(tam == 0){
      heap.add(no);
    } else{
      heap.add(no);
      subir(tam - 1, heap);
    }

  }

  public No_Huf remover(){
    int tam = heap.size();

    No_Huf excluido;

    if(tam != 0){
      excluido = heap.get(0);
      heap.set(0, heap.get(tam-1));
      heap.remove(tam - 1);

      descer(0, heap, tam - 1);
      return excluido;
    } else{
      return null;
    }
  }

  public int tamanho(){
    return heap.size();
  }


}
