package cadastro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Aluno {
  public static void cadastroAluno(String nome, Integer cpf, FileWriter arqAluno) throws IOException {

    try {
      BufferedWriter cadAluno = new BufferedWriter(arqAluno);
      String dados = "nome: "+nome+", CPF: "+cpf+"\n";
      cadAluno.write(dados);
      cadAluno.flush();
      System.out.printf("Gravado com sucesso\n\n");
    }catch (IOException e) {
      System.err.printf("Erro na gravação.\n",
          e.getMessage());
    }
  }

  public static void listarAluno() {
    String arquivo = "d:/aluno.txt";
    System.out.printf("\nLista de Alunos:\n");
    try {
      FileReader arq = new FileReader(arquivo);
      BufferedReader lerArq = new BufferedReader(arq);
      
      String linha = lerArq.readLine();
      // le a primeira linha
      // a variavel "linha" recebe o valor "null" quando o processo
      // de repetiçao atingir o final do arquivo texto
      while (linha != null) {
        System.out.printf("%s\n", linha);

        linha = lerArq.readLine();
        // lê da segunda até a última linha
      }

      arq.close();
    } catch (IOException e) {
      System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
    }

    System.out.println();

  }

}
