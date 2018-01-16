public class Aluno extends Usuario {
	Item [] itensDoAluno;
	public Aluno( String nome, String senha) {          // Construtor
		super(nome, senha);
		itensDoAluno = new Item [2];
	} 
	public String getTipo(){
    	return "Aluno";
    }
	public int locarItem(Item item){
   	 for (int i = 0; i < itensDoAluno.length; i++){
   		 if(itensDoAluno[i] == null){
   			 itensDoAluno[i] = item;
   		    	return 0;
   		 }
   	 }
   	return -1;
   }
   public int devolverItem(Item item){
   	for (int i = 0; i < itensDoAluno.length; i++){
  		 if(itensDoAluno[i] != null){
  			 itensDoAluno[i] = null;
  			 return 0;
  		 }
  	 }
  	return -1;
   }
}