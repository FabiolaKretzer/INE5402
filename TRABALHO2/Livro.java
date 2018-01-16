public class Livro extends Item {
    private String titulo;
    private String autor;
    private int edicao;
    public Livro (int identificador, int dataEmprestimo,int dataDevolucao, String titulo, String autor, int edicao){        // Construtor.
    	super (identificador, dataEmprestimo, dataDevolucao);
        this.titulo = titulo;
        this.autor = autor;
        this.edicao = edicao;
    }
    public String getTitulo() {                              // Pegar titulo do livro.
        return titulo; 
    }
    public String getAutor() {                              // Pegar autor do livro.
        return autor; 
    }
    public int getEdicao() {                               // Pegar o numero da edição do livro.
        return edicao; 
    }
    public String getTipo(){
    	return "Livro";
    }
} 
