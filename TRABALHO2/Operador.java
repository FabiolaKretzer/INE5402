public class Operador extends Usuario{
	public Operador(String umNome, String umaSenha) {         // Construtor.
		super(umNome, umaSenha);
	} 
	public String getTipo(){
    	return "Operador";
    }
	public int locarItem(Item item){
		System.out.println("Operador não pode alocar");
		return -1;
	}
	public int devolverItem(Item item){
		System.out.println("Operador não pode devolver");
		return -1;
	}
}