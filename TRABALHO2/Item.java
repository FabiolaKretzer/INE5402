public abstract class  Item {
    private int identificador;
    private Usuario retiradoPor;
    private int dataEmprestimo;
    private int dataDevolucao;
    private boolean estaEmprestado;
    boolean estaAtrasado;
    Item (int identificador, int dataEmprestimo, int dataDevolucao){      // Construtor.
    	this.identificador = identificador;
    	this.retiradoPor = null;
    	this.dataEmprestimo = dataEmprestimo;
    	this.dataDevolucao = dataDevolucao;
    	this.estaEmprestado = false;
    	this.estaAtrasado = false;
    }
    public int getIdentificador(){                          // Pegar o numero de identificação do item.
    	return identificador;
    }
    public Usuario getRetiradoPor(){                     // Pegar o nome do usuario que retirou o item.
        return retiradoPor;
    }
    public void setRetiradoPor(Usuario novoRetiradoPor){                    // Mudar o nome do usuario que retirou o item.
        retiradoPor = novoRetiradoPor;
    }
    public int getDataEmprestimo(){                       // Pegar a data de empréstimo do item.
         return dataEmprestimo;
    }
    public void setDataEmprestimo(int novaData){         // Mudar a data de empréstimo do item.
         dataEmprestimo = novaData;
    }     
    public int getDataDevolucao(){                       // Pegar a data de devolução do item.
         return dataDevolucao;
    }     
    public void setDataDevolucao(int novaData){         // Mudar a data de devolução do item.
        dataDevolucao = novaData;
    }  
    public boolean getEstaEmprestado(){
    	return estaEmprestado;
    }
    public void setEstaEmprestado(boolean estaEmprestado){
    	this.estaEmprestado = estaEmprestado;
    }
    public boolean getEstaAtrasado(){
    	return estaAtrasado;
    }
    public void setEstaAtrasado(boolean estaAtrasado){
    	this.estaAtrasado = estaAtrasado;
    }
    public String getTipo(){
    	return "Item";
    }
}                        