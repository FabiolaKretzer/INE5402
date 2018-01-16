public class Revista extends Item{
    private String nomeDaRevista;
    private String editora;
    public Revista(int identificador, int dataEmprestimo, int dataDevolucao, String nomeDaRevista, String editora){         // Construtor  
       super(identificador, dataEmprestimo, dataDevolucao);
       this.nomeDaRevista = nomeDaRevista;
       this.editora = editora;
    } 
    public String getNomeDaRevista() {                     // Pegar nome da revista.
        return nomeDaRevista; 
    }
    public String getEditora() {                           // Pegar nome da editora.
        return editora; 
    }
    public String getTipo(){
    	return "Revista";
    }
}
