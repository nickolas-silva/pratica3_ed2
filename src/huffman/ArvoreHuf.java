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

  public void buildTree(int n, char[] charArray, int[] freqArray){
    HeapMin heap = new HeapMin();
    No_Huf no;

    for(int i = 0; i<n; i++){
      no = new No_Huf();

      no.caracter = charArray[i];
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
    buildCodeArray(raiz, "");

  }

  public void imprimir(No_Huf no, String s){
    if(no.esq == null && no.dir == null && raiz.caracter == '-'){
      System.out.println(no.caracter + ":" + s);
      return;
    }

    imprimir(no.esq, s.concat("0"));
    imprimir(no.dir, s.concat("1"));
  }

  public String comprimir(String input) {
        char[] charArray = getCharacters(input);
        Arrays.sort(charArray);
        int[] charFrequencies = getFrequencies(input);

        buildTree(charArray.length, charArray, charFrequencies);

         // Um array para os caracteres ASCII

        buildCodeArray(raiz, "");

        String compressed = "";
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            compressed += codes[character];
        }

        return compressed;
    }

    public String decompress(String compressed) {
        String decompressed = "";
        No_Huf current = raiz;
        int currentIndex = 0;
        

        while (currentIndex < compressed.length()) {
            char bit = compressed.charAt(currentIndex);

            if (bit == '0') {
                current = current.esq;
            } else if (bit == '1') {
                current = current.dir;
            }
            

            if (current.esq == null && current.dir == null) {
                decompressed += current.caracter;
                current = raiz;
            }

            currentIndex++;
        }

        return decompressed;
    }

    
    private void buildCodeArray(No_Huf node, String currentCode) {
        if (node == null) {
            return;
        }

        if (node.esq == null && node.dir == null) {
            codes[node.caracter] = currentCode;
        }

        buildCodeArray(node.esq, currentCode + "0");
        buildCodeArray(node.dir, currentCode + "1");
    }

    // Calcular frequência
    public int[] getFrequencies(String input){
        int[] charFrequencies = new int[128]; 

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar >= 0 && currentChar <= 127) {
                if (Character.isLetterOrDigit(currentChar) || Character.isWhitespace(currentChar)) {
                    charFrequencies[currentChar]++;
                }
                else if(currentChar == '/' || currentChar == '.' || currentChar == '-' || currentChar == '@'){
                    charFrequencies[currentChar]++;
                }
            }
        }

        int coutZero = 0;
        for (int value : charFrequencies) {
            if (value != 0) {
                coutZero++;
            }
        }

        int[] newArray = new int[coutZero];
        int index = 0;
        for (int value : charFrequencies) {
            if (value != 0) {
                newArray[index++] = value;
            }
        }
        return newArray;
    }

    // Separa Caracteres
    public char[] getCharacters(String input){
        boolean[] charExists = new boolean[128]; 

        StringBuilder uniqueCharsBuilder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (!charExists[currentChar]) {
                charExists[currentChar] = true;
                uniqueCharsBuilder.append(currentChar);
            }
        }

        char[] uniqueChars = new char[uniqueCharsBuilder.length()];
        uniqueCharsBuilder.getChars(0, uniqueCharsBuilder.length(), uniqueChars, 0);

        return uniqueChars;
    }

}
