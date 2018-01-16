public abstract class Usuario {
    private String nome;
    private String senha;
    public Usuario (String nome, String senha){   // Construtor.
        this.nome = nome;
        this.senha = senha;
    }  
    public String getNome() {                     // Pegar nome.
        return nome; 
    }
    public String getSenha() {                    // Pegar senha.
        return senha;
    }  
    public void setSenha(String novaSenha) {      // Mudar senha.
        senha = novaSenha;
    }
    public String getTipo(){
    	return "Usuario";
    }
    public int locarItem(Item item){
    	//se retorna -1 deu erro
    	return -1;
    }
    public int devolverItem(Item item){
    	//se retorna -1 deu erro
    	return -1;
    }
} 