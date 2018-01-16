import java.util.Scanner;

public class Biblioteca {
    Item [] itens;
    Usuario [] usuarios;
    Scanner scanner;
    public Biblioteca (Scanner scanner,int numeroMaximoDeItens, int numeroMaximoDeUsuarios ){
    	this.scanner = scanner;
        this.itens = new Item [numeroMaximoDeItens];
        this.usuarios = new Usuario [numeroMaximoDeUsuarios];
    }
    
    public void ImprimirUsuariosCadastrados(){
    	 for(int i = 0; i < usuarios.length; i++){                                    //Este metodo tem que imprimir todos os usuarios cadastrados na tela, no formato:
    		 if(usuarios[i] != null) 
    		 System.out.println(usuarios[i].getNome() + " " + usuarios[i].getTipo());                                       //<nome> : <Tipo>
    	 }
    }
    
    public void ImprimirItensCadastrados(){
    	for(int i = 0; i < itens.length; i++){                                           //Este metodo tem que imprimir todos os itens cadastrados na tela, no formato:
    		if(itens[i] != null)
    		System.out.println(itens[i].getIdentificador() + " " + itens[i].getTipo() );
    	}
    }
    
    public void cadastrarUsuario(String tipo, String nome, String senha){    // Cadastrar um objeto usuário no array.
    	for(int i = 0; i < usuarios.length; i++){
            if ( usuarios[i] == null){
                if ( tipo.equals("Aluno")){
                    usuarios[i] = new Aluno (nome, senha); 
                }else
                    if ( tipo.equals("Professor")){	
                        usuarios[i] = new Professor (nome, senha);
                    } else
                        if ( tipo.equals("Operador")){ 
                        usuarios[i] = new Operador (nome, senha);
                    }
                return;
            }
        }
    	System.out.println("Não existe mais vagas para Usuários!");    //imprime resposta sem lugar
    }
    public void excluirUsuario(String nome){     // Excluir um objeto usuário do array e colocar null no lugar.
    	for(int i = 0; i < usuarios.length; i++){
            if(usuarios[i].getNome().equals(nome) ){
                usuarios[i] = null;
                return;
            }
        }
    	System.out.println("Usuário não encontrado!"); //imprimir caso nao encontre usuario     
    }
    public void cadastrarItem (String tipo, int identificador){      // Cadastrar um objeto item no array de itens da bibliteca.
    	for(int i = 0; i < itens.length; i++){
            if ( itens[i] == null){
                if ( tipo.equals("Revista")){
                	System.out.println("Digite o nome da revista!");
                	String nomeDaRevista = scanner.nextLine();
                	System.out.println("Digite a editora da revista!");
                	String editora = scanner.nextLine();
                    itens[i] = new Revista (identificador, 0, 0, nomeDaRevista, editora); 
                }else
                    if ( tipo.equals("Livro")){
                    	System.out.println("Digite o titulo do livro!");
                    	String titulo = scanner.nextLine();
                    	System.out.println("Digite o autor do livro");
                    	String autor = scanner.nextLine();
                    	System.out.println("Digite o número da edição do livro!");
                    	int edicao = Integer.parseInt(scanner.nextLine());
                        itens[i] = new Livro (identificador, 0, 0, titulo, autor, edicao);
                    } 
                return;
            }
        }
    	System.out.println("Não existe mais vagas para Itens!");
    }
    public void excluirItem( int identificador){        // Excluir um objeto item e colocar null em seu lugar.
    	for(int i = 0; i < itens.length; i++){
            if(itens[i].getIdentificador() == identificador ){
                itens[i] = null;
                return;
            }
        }
    	System.out.println("Item não encontrado!");//imprimir caso nao encontre item
    }
    public boolean estaEmprestado(int identificador){    // Verificar se um objeto item está emprestado.
    	for(int i = 0; i < itens.length; i++){
            if(itens[i].getIdentificador() == identificador ){
                return itens[i].getEstaEmprestado();
            }
        }
    	System.out.println("Item não encontrado!");//imprimir caso nao encontre item
        return true;
    }
    public void locarItem(Usuario usuario){          // Enviar o objeto item desejado dentro do array de itens do usuario. 
    	for(int i = 0; i < itens.length; i++){
    		if(itens[i] != null){
    			if (itens[i].getEstaEmprestado() == false){
            		if ( itens[i].getRetiradoPor() == null){
            			if(usuario.locarItem(itens[i]) == 0){
            				itens[i].setRetiradoPor(usuario);
            				itens[i].setEstaEmprestado(true);
            				System.out.println("Item alocado com sucesso!");
            				return;
            			}
            		}	
    			}
    		}
    	}
    }
    public boolean estaAtrasado(int identificador, int dataDeHoje){     // Verificar se o item emprestado esta atrasado.
    	for (int i = 0; i < itens.length; i++){
    		if (itens[i].getIdentificador() == identificador){
    			if (itens[i].getEstaEmprestado() == true){
    				if(itens[i].getDataDevolucao() > dataDeHoje){
    					return itens[i].getEstaAtrasado();
    				}
    			}
    		}
    	}
		return true;
    }
    public void devolverItem(Usuario usuario,int identificador){     // Modificar a variável estaEmprestado de true para false.
    	for(int i = 0; i < itens.length; i++){
    		if(itens[i] != null){
    			if (itens[i].getIdentificador() == identificador && itens[i].getEstaEmprestado()){
            		if ( itens[i].getRetiradoPor().getNome().equals( usuarios[i].getNome())){
            			if(usuario.devolverItem(itens[i]) == 0){
            				itens[i].setRetiradoPor(null);
            	      		itens[i].setEstaEmprestado(false);
            	      		return;
           				} 			
            		}
            	}	
    		}
    	}
    	System.out.println("Livro nao emprestado para este usuário");
    }
    public Usuario encontrarUsuario (String nome){
    	for( int i = 0; i < usuarios.length; i++){
    		if(usuarios[i] != null){
    		    if(usuarios[i].getNome().equals(nome)){
    			return usuarios[i];
    		   }
    		}
    	}
		return null;
    }
    
    public Item encontrarItem (int identificador){
    	for( int i = 0; i < itens.length; i++){
    		if(itens[i] != null){
    		    if(itens[i].getIdentificador() == identificador){
    			return itens[i];
    		   }
    		}
    	}
		return null;
    }
    
}