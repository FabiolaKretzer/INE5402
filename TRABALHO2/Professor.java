public class Professor extends Usuario {
	Item []itensDoProfessor;
	public Professor(String nome, String senha) {            // Construtor.
		super(nome, senha);
		itensDoProfessor = new Item [3];
	}
	public String getTipo(){
    	return "Professor";
    }
	public int locarItem(Item item){
    	 for (int i = 0; i < itensDoProfessor.length; i++){
    		 if(itensDoProfessor[i] == null){
    			 itensDoProfessor[i] = item;
    		    	return 0;
    		 }
    	 }
    	return -1;
    }
    public int devolverItem(Item item){
    	for (int i = 0; i < itensDoProfessor.length; i++){
   		 if(itensDoProfessor[i] == null){
   		    	return 0;
   		 }
   	 }
   	return -1;
    }
}