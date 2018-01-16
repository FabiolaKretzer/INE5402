public class Verificador implements InterfaceVerificador {
	@Override
	public int getEstradasChegando(int[][] estradas, int cidade) {
 	    int estradasChegando = 0;
        if (cidade + 1 > estradas.length || 0 > cidade){ 
                estradasChegando = -1;
        }
        else {
            for (int linha = 0; linha < estradas.length; linha++){
                    if( linha != cidade && estradas[linha][cidade] == 1 ){
                          estradasChegando = estradasChegando + 1;
                        }
                    }    
                }          
	return estradasChegando ;
    }	 
	@Override
	public int getEstradasSaindo(int[][] estradas, int cidade) {
		 int estradasSaindo = 0;
        if (cidade + 1 > estradas.length || cidade < 0){
                estradasSaindo = -1;
        }	
	    else {
            for (int coluna = 0; coluna < estradas.length; coluna++){
                    if( coluna != cidade && estradas[cidade][coluna]==1){
                            estradasSaindo = estradasSaindo + 1;     
                        }
                    }    
                }          	
	return estradasSaindo;
	}
	@Override
	public int getCidadeComMaisEstradasChegando(int[][] estradas) {	
	    int cidadeComMaisEstradasChegando = -1;
	    int maior = 0;
	    int chegadas = 0;
	    for ( int linha = 0; linha < estradas.length; linha++){	 	  	 	     	    	     	 	     	    	      	 	
	    	for (int cidade = 0; cidade < estradas.length; cidade++){
	      	  chegadas = this.getEstradasChegando(estradas, cidade);
	    		if (maior < chegadas){
	    			maior = chegadas;
	    			cidadeComMaisEstradasChegando = cidade;
	    		}
	    	}
	    }
	return cidadeComMaisEstradasChegando;   
	} 
	@Override
	public boolean temTodasEstradasComMaoDupla(int[][] estradas, int cidade) {
          boolean temTodasEstradasComMaoDupla = true;
          for (int i = 0; i < estradas.length; i++){
               if (cidade + 1 > estradas.length || cidade < 0 || estradas[cidade][i] == 0 || estradas[i][cidade] == 0){
            	   temTodasEstradasComMaoDupla = false;
               }
               else{ 
            	   temTodasEstradasComMaoDupla = true;
               }
          }    
	return temTodasEstradasComMaoDupla;
	}
	@Override
	public int[] getCidadesComSaidaDiretaPara(int[][] estradas, int cidade) {
    	int []cidadesComSaidaDiretaPara = null;
	    if(cidade + 1 > estradas.length || cidade < 0){
	        cidadesComSaidaDiretaPara = new int[]{};
	    }
	    else{
	        int tamanho = this.getEstradasChegando (estradas, cidade);
    	    if( tamanho == 0 ){
    	        cidadesComSaidaDiretaPara = new int[]{};    
    	    }
    	    else{
    	           cidadesComSaidaDiretaPara = new int[tamanho];
    	           int i = 0;
	               for(int linha = 0; linha < estradas.length; linha++){	 	  	 	     	    	     	 	     	    	      	 	
	                    if(cidade != linha){
	                        if (estradas[linha][cidade] == 1){
	                            cidadesComSaidaDiretaPara[i] = linha ;
	                            i++;
	                        }
	                    }         
	               }
	          }
	      }
	return cidadesComSaidaDiretaPara;
	}	
	@Override
	public int[] getCidadesIsoladas(int[][] estradas) {
	    int [] cidadesIsoladas = null;
        int tamanho = 0;
        for (int cidade = 0; cidade < estradas.length; cidade++) {
                     if(this.getEstradasSaindo(estradas, cidade) == 0 && this.getEstradasChegando( estradas, cidade) == 0){    
                          tamanho = tamanho + 1;
                     }
        }          
                          if (tamanho == 0){
                              cidadesIsoladas = new int [] {};
                          }
                          cidadesIsoladas = new int [tamanho];
                          int i = 0;
                          for (int cidade = 0; cidade < estradas.length; cidade++) {
                              if (this.getEstradasSaindo(estradas, cidade) == 0 && this.getEstradasChegando( estradas, cidade) == 0){
                                  cidadesIsoladas[i] = cidade;
                                  i++;
                              }
        }
	return cidadesIsoladas;
	}
	@Override
	public int[] getCidadesApenasComEntradas(int[][] estradas) {
	    int [] cidadesApenasComEntradas = null;	
        int tamanho = 0;
	      for (int cidade = 0; cidade < estradas.length; cidade++) {	 	  	 	     	    	     	 	     	    	      	 	
                     if(this.getEstradasSaindo(estradas, cidade) == 0 && this.getEstradasChegando( estradas, cidade) != 0){    
                          tamanho = tamanho + 1;
                     }
        }          
                          if (tamanho == 0){
                              cidadesApenasComEntradas = new int [] {};
                          }
                          cidadesApenasComEntradas = new int [tamanho];
                          int i = 0;
                          for (int cidade = 0; cidade < estradas.length; cidade++) {
                              if (this.getEstradasSaindo(estradas, cidade) == 0 && this.getEstradasChegando( estradas, cidade) != 0){
                                  cidadesApenasComEntradas[i] = cidade;
                                  i++;
                              }
        }
	return cidadesApenasComEntradas;
	}
	@Override
	public int[] getCidadesApenasComSaidas(int[][] estradas) {
	    int [] cidadesApenasComSaidas = null;
	   int tamanho = 0;
	      for (int cidade = 0; cidade < estradas.length; cidade++) {
                     if(this.getEstradasSaindo(estradas, cidade) != 0 && this.getEstradasChegando( estradas, cidade) == 0){    
                          tamanho = tamanho + 1;
                     }
        }          
                          if (tamanho == 0){
                              cidadesApenasComSaidas = new int [] {};
                          }
                          cidadesApenasComSaidas = new int [tamanho];
                          int i = 0;
                          for (int cidade = 0; cidade < estradas.length; cidade++) {
                              if (this.getEstradasSaindo(estradas, cidade) != 0 && this.getEstradasChegando( estradas, cidade) == 0){
                                  cidadesApenasComSaidas[i] = cidade;
                                  i++;
                              }	 	  	 	     	    	     	 	     	    	      	 	
                          }      
	return cidadesApenasComSaidas;
	}
}
