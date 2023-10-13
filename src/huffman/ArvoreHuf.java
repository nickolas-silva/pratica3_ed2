package huffman;

import java.util.Arrays;

class No_Huf{
  int freq;
  No_Huf esq;
  No_Huf dir;
  char caracter;

}

public class ArvoreHuf {
  public No_Huf raiz;
  public String[] codes;

  public void buildTree(int n, char[] caracteres, int[] freqArray){
    HeapMin heap = new HeapMin();
    No_Huf no;

    for(int i = 0; i<n; i++){
      no = new No_Huf();

      no.caracter = caracteres[i];
      no.freq = freqArray[i];

      no.esq = null;
      no.dir = null;

      heap.inserir(no);

    }

    raiz = null;

    while(heap.tamanho() > 1){
      No_Huf x = heap.remover();
      No_Huf y = heap.remover();

      No_Huf z = new No_Huf();

      z.freq = x.freq + y.freq;
      z.caracter= '-';
      z.esq = x;
      z.dir = y;
      raiz = z;

      heap.inserir(z);
    }

    codes = new String[128];
    construirArray(raiz, "");

  }

  public void imprimir(No_Huf no, String s){
    if(no.esq == null && no.dir == null && raiz.caracter == '-'){
      System.out.println(no.caracter + ":" + s);
      return;
    }

    imprimir(no.esq, s.concat("0"));
    imprimir(no.dir, s.concat("1"));
  }

  public String comprimir(String veiculo) {
        char[] caracteres = getCharacters(veiculo);

        //ORDENAR O ARRAY
        Arrays.sort(caracteres);
        int[] frequencias = getFrequencia(veiculo);

        buildTree(caracteres.length, caracteres, frequencias);

         

        construirArray(raiz, "");

        String saida = "";
        for (int i = 0; i < veiculo.length(); i++) {
            char character = veiculo.charAt(i);
            saida += codes[character];
        }

        return saida;
    }

    public String descomprimir(String comprimido) {
        String saida = "";
        No_Huf atual = raiz;
        int atualIndex = 0;
        

        while (atualIndex < comprimido.length()) {
            char bit = comprimido.charAt(atualIndex);

            if (bit == '0') {
                atual = atual.esq;
            }
            else if (bit == '1') {
                atual = atual.dir;
            }
            

            if (atual.esq == null && atual.dir == null) {
                saida += atual.caracter;
                atual = raiz;
            }

            atualIndex++;
        }

        return saida;
    }

    
    private void construirArray(No_Huf no, String atualCode) {
        if (no == null) {
            return;
        }

        if (no.esq == null && no.dir == null) {
            codes[no.caracter] = atualCode;
        }

        construirArray(no.esq, atualCode + "0");
        construirArray(no.dir, atualCode + "1");
    }

    // Calcular frequência
    public int[] getFrequencia(String veiculo){
        int[] frequencias = new int[128]; 

        for (int i = 0; i < veiculo.length(); i++) {
            char atualChar = veiculo.charAt(i);
            if (atualChar >= 0 && atualChar <= 127) {
                if (Character.isLetterOrDigit(atualChar) || Character.isWhitespace(atualChar)) {
                    frequencias[atualChar]++;
                }
                else if(atualChar == '/' || atualChar == '.' || atualChar == '-' || atualChar == '@'){
                    frequencias[atualChar]++;
                }
            }
        }

        int coutZero = 0;
        for (int value : frequencias) {
            if (value != 0) {
                coutZero++;
            }
        }

        int[] newArray = new int[coutZero];
        int index = 0;
        for (int value : frequencias) {
            if (value != 0) {
                newArray[index++] = value;
            }
        }
        return newArray;
    }

    // Separa Caracteres
    public char[] getCharacters(String veiculo){
        StringBuilder charsUnicos = new StringBuilder();
        boolean[] existentes = new boolean[128]; 


        for (int i = 0; i < veiculo.length(); i++) {
            char atualChar = veiculo.charAt(i);
            if (!existentes[atualChar]) {
                existentes[atualChar] = true;
                charsUnicos.append(atualChar);
            }
        }

        char[] uniqueChars = new char[charsUnicos.length()];
        charsUnicos.getChars(0, charsUnicos.length(), uniqueChars, 0);

        return uniqueChars;
    }

}
