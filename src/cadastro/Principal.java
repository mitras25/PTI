package cadastro;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws IOException {
		try {
			File aluno = new File("d:/aluno.txt");
			// Se não existir será criado.
			if (!aluno.exists()) {
				aluno.createNewFile();
			}
			File professor = new File("d:/professor.txt");
			// Se não existir será criado.
			if (!professor.exists()) {
				professor.createNewFile();
			}

			FileWriter arqAluno = new FileWriter(aluno, true);
			FileWriter arqProf = new FileWriter(professor, true);

			Integer opCadastro = 1;
			Integer opListar = 1;
			Integer option = 9;

			Scanner ler = new Scanner(System.in);
			while (option != 0) {
				do {
					System.out.printf("Digite oque deseja:\n(1) para cadastrar\n(2) para listar\n(0) para SAIR\n");
					while (!ler.hasNextInt()) {
						System.out.println("Opção inválida!!!!!!!\n\n");
						ler.next();
					}
					option = ler.nextInt();
				} while (option != 1 && option != 2 && option != 0);

				if (option == 1) {
					while (opCadastro != 0) {
						do {
							System.out
									.printf("Digite oque deseja cadastrar:\n(1) para Aluno\n(2) para Professores\n(0) para Voltar\n");
							while (!ler.hasNextInt()) {
								System.out.println("Opção inválida!!!!!!!\n\n");
								ler.next();
							}
							opCadastro = ler.nextInt();
						} while (opCadastro != 1 && opCadastro != 2 && opCadastro != 0);

						String name = "entrar";
						if (opCadastro == 1) {
							while (!name.equalsIgnoreCase("SAIR")) {
								System.out.printf("Digite o nome do aluno ou digite SAIR:\n");

								name = ler.next().toUpperCase();
								if (!name.equalsIgnoreCase("SAIR")) {
									System.out.printf("Digite o cpf:\n");
									Integer cpf = ler.nextInt();

									Aluno.cadastroAluno(name, cpf, arqAluno);
								}
							}
						}
						if (opCadastro == 2) {
							while (!name.equalsIgnoreCase("SAIR")) {
								System.out.printf("Digite o nome do professor ou SAIR:\n");
								name = ler.next();
								if (!name.equalsIgnoreCase("SAIR")) {
									System.out.printf("Digite o cpf:\n");
									Integer cpf = ler.nextInt();

									Professor.cadastroProfessor(name, cpf, arqProf);
								}
							}
						}
					}
					opCadastro = 9;
				}

				if (option == 2) {
					while (opListar != 0) {
						do {
							System.out.printf("Digite oque deseja Listar:\n(1) para Aluno\n(2) para Professores\n(0) para Voltar\n");
							while (!ler.hasNextInt()) {
								System.out.println("Opção inválida!!!!!!!\n\n");
								ler.next();
							}
							opListar = ler.nextInt();
						} while (opListar != 1 && opListar != 2 && opListar != 0);
						if (opListar == 1) {
							Aluno.listarAluno();
						}
						if (opListar == 2) {
							Professor.listarProfessor();
						}
					}
					opListar = 9;
				}
			}
			System.exit(0);
			ler.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
