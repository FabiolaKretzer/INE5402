import java.util.Scanner;

public class Controlador {
	
      public static void main (String args[]){
    	  
    	  Scanner scanner = new Scanner (System.in);
    	  Biblioteca b = new Biblioteca(scanner,20,10);
    	  while (true){
      		  System.out.println("Bem vindo a biblioteca!");
      		  System.out.println("Cadastrar ou Excluir ou Imprimir ou Locar item ou Devolver item ou Verificar");
      		  String escolha1 = scanner.nextLine();
      		if(escolha1.equals("Cadastrar")){
      			System.out.println("Item ou Usuário");
      			String escolha2 = scanner.nextLine();
      			if(escolha2.equals("Item")){
      				System.out.println("Livro ou Revista");
      				String escolha3 = scanner.nextLine();
      				if ( escolha3.equals("Livro")){
      					System.out.println("Digite o identificador!");
      					int identificador = Integer.parseInt(scanner.nextLine());
      					b.cadastrarItem("Livro", identificador);
      					System.out.println("Livro cadastrado com sucesso");
      				}
      				else{
      					if(escolha3.equals("Revista")){
      					System.out.println("Digite o identificador!");
      					int identificador = Integer.parseInt(scanner.nextLine());
      					b.cadastrarItem("Revista",identificador);
      					System.out.println("Revista cadastrada com sucesso");
      					}
      				}
      			}
      			else{
      				if(escolha2.equals("Usuário")){
      					System.out.println("Aluno ou Professor ou Operador!");
      					String escolha4 = scanner.nextLine();
      					if(escolha4.equals("Aluno")){
      					    System.out.println("Digite o seu nome!");
      					    String nome = scanner.nextLine();
      					    System.out.println("Digite o sua senha!");
      					    String senha = scanner.nextLine();
      					    b.cadastrarUsuario("Aluno",nome,senha);
      					    System.out.println("Aluno cadastrado com sucesso");
      					}
      					else{
      						if(escolha4.equals("Professor")){
      	  					    System.out.println("Digite o seu nome!");
      	  					    String nome = scanner.nextLine();
      	  					    System.out.println("Digite o sua senha!");
      	  					    String senha = scanner.nextLine();
      	  					    b.cadastrarUsuario("Professor",nome,senha);
      	  					    System.out.println("Professor cadastrado com sucesso");
      	  					}
      					else {
      						if(escolha4.equals("Operador")){
      	  					    System.out.println("Digite o seu nome!");
      	  					    String nome = scanner.nextLine();
      	  					    System.out.println("Digite o sua senha!");
      	  					    String senha = scanner.nextLine();
      	  					    b.cadastrarUsuario("Operador",nome,senha);
      	  					    System.out.println("Operador cadastrado com sucesso");
      					    }
      					}
      				}
      			}
      	     }    
           }
      		else{
      			if(escolha1.equals("Excluir")){
      				System.out.println("Item ou Usuário");
      				String escolha5 = scanner.nextLine();
      				if(escolha5.equals("Item")){
      					System.out.println("Digite o identificador!");
      	  			    int identificador = Integer.parseInt(scanner.nextLine());
      	  		        b.excluirItem(identificador);
      	  		        System.out.println("Item excluido com sucesso");
      				} 
      				else{
      					if(escolha5.equals("Usuário")){
      						System.out.println("Digite o nome!!");
          	  			    String nome = scanner.nextLine();
          	  		        b.excluirUsuario(nome);
          	  		        System.out.println("Usuário excluido com sucesso");
      				 }
      			  }
      		   }
             
      		else{
      			if(escolha1.equals("Imprimir")){
      				System.out.println("Item ou Usuário");
      				String escolha6 = scanner.nextLine();
      				if(escolha6.equals("Item")){
      					b.ImprimirItensCadastrados();
      				}
      				if(escolha6.equals("Usuário")){
      					b.ImprimirUsuariosCadastrados();
      				}
      			}
      		else{
      			if(escolha1.equals("Locar item")){
      				System.out.println("Digite o usuário");
      				String nome = scanner.nextLine();
      				Usuario usuario = b.encontrarUsuario(nome);
      				if(usuario != null){
      					b.locarItem(usuario);
      				} 
      				else {
      					System.out.println("Usuário não encontrado");
      				}
      			}	
      		else{
      			if(escolha1.equals("Devolver item")){
      				System.out.println("Digite o usuário");
      				String nome = scanner.nextLine();
      				Usuario usuario = b.encontrarUsuario(nome);
      				System.out.println("Digite o identificador do livro");
      				int id = Integer.parseInt(scanner.nextLine());
      				if(usuario != null){
      				    b.devolverItem(usuario,id);
      				    System.out.println("Item devolvido com sucesso");
      				}
      				else{
      				    System.out.println("Usuário não encontrado");
      				}
      		}
      		else{
      			if(escolha1.equals("Verificar")){
      				System.out.println("Atrasado ou Emprestado");
      				String escolha7 = scanner.nextLine();
      				if(escolha7.equals("Atrasado")){
      					System.out.println("Digite o identificador");
      					int identificador = Integer.parseInt(scanner.nextLine());
      					System.out.println("Digite a data de hoje");
      					int dataDeHoje = Integer.parseInt(scanner.nextLine());
      					if(b.estaAtrasado(identificador, dataDeHoje)){
      						System.out.println("Esta atrasado");
      					}
      				}
      				else{
      					if(escolha7.equals("Emprestado")){
          					System.out.println("Digite o identificador");
          					int identificador = Integer.parseInt(scanner.nextLine());
          					if(b.estaEmprestado(identificador)){
          						System.out.println("Esta Emprestado para " + b.encontrarItem(identificador).getRetiradoPor().getNome());
          					}
          					else{
          						System.out.println("Não esta empretado");
          					}
          				}
      				}
      			}
      		}
      	}
}
}
}
    	  }
      }
}
