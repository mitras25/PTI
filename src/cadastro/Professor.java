package cadastro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Professor {
  public static void cadastroProfessor(String nome, Integer cpf, FileWriter arqProf) throws IOException {

    try {
      BufferedWriter cadProfessor = new BufferedWriter(arqProf);
      String dados = "nome: "+nome+", CPF: "+cpf+"\n";
      cadProfessor.write(dados);
      cadProfessor.flush();
      System.out.printf("Gravado com sucesso\n\n");
    }catch (IOException e) {
      System.err.printf("Erro na gravação.\n",
          e.getMessage());
    }
  }


  public static void listarProfessor() {
    String arquivo = "d:/professor.txt";
    System.out.printf("\nLista de Professor:\n");
    try {
      FileReader arqProf = new FileReader(arquivo);
      BufferedReader lerArq = new BufferedReader(arqProf);
      
      String linha = lerArq.readLine();
      // le a primeira linha
      // a variavel "linha" recebe o valor "null" quando o processo
      // de repetiçao atingir o final do arquivo texto
      while (linha != null) {
        System.out.printf("%s\n", linha);

        linha = lerArq.readLine();
        // lê da segunda até a última linha
      }

      arqProf.close();
    } catch (IOException e) {
      System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
    }

    System.out.println();

  }

}

