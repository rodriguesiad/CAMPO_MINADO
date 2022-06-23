import java.util.Scanner;
import java.util.Random;

class Campo{
    int numero;
    String status;
}
public class Main
{
    public static Scanner leitor;
    public static Random random;
    
    public static void criarCampo(Campo[] vetor){
        for(int i=0; i<100; i++){
            vetor[i] = new Campo();
            vetor[i].numero = random.nextInt(200);
            vetor[i].status = "?";
        }
    }
    
    public static void mostrarCampo(Campo[] vetor){
        System.out.print("\n\nCampo Minado: \n");
        for(int i=0; i<100; i++){
            if(vetor[i].status.equals("-"))
                System.out.print(" | "+vetor[i].numero+" | ");
            else
                System.out.print(" | "+vetor[i].status+" | ");
        }    
    }
    
    public static int confereCampo(Campo[] vetor, int chute, int pontos){
            if(vetor[chute].numero%2 == 0 & vetor[chute].status.equals("?")){
                vetor[chute].status = "-";
                pontos ++;
                for(int i = chute-1; i>=0; i--){
                    if( vetor[i].numero % 2 == 0){
                        vetor[i].status = "-";
                        pontos ++;
                    }
                    else{
                        break;
                    }
                }
                
                for(int i = chute+1; i< 100; i++){
                    if(  vetor[i].numero % 2 == 0){
                        vetor[i].status = "-";
                        pontos ++;
                    }
                    
                    else{
                        break;
                    }
                }
                System.out.print("\nBoa! :)");
            }
            
            else{
                vetor[chute].status = "-";
                System.out.print("\nErrou! :(");
            }
            
            return pontos;
    }
    
	public static void main(String[] args) {
	    leitor = new Scanner(System.in);
	    random = new Random();
	    Campo[] vetor = new Campo[100];
	    int chute, pontos = 0, cont = 10;
	    
	    criarCampo(vetor);
	    
	    System.out.print(" Regras do jogo:\n -Você pontua se o número da posição chutada for par.\n -Você pontua a cada número par ao redor do número de chute.\n -Os números chutados ou pontuados serão limpados.\n -Você não pontua quando o número é impar ou quando já está limpo.\n -Você terá 10 chances.\n Bom jogo! ");
	    
	    while(true){
	        if(cont > 0){
	            mostrarCampo(vetor);
        	    System.out.print("\nDigite uma posição: "); //pega chute
        	    chute = leitor.nextInt();
        	    
        	    pontos = confereCampo(vetor, chute, pontos); //confere numero e substitui
        	    System.out.print("\nPontos: "+ pontos); //mostra pontuação
        	    cont --;
        	    System.out.print("\nVidas: "+ cont);
	        }
	        else{
	            System.out.print("\n\n----------------------------------------------");
	            System.out.print("\nJogar novamente?\nDigite 1 para SIM ou 2 para NÃO: ");
	            int continuar = leitor.nextInt();
	            System.out.print("\n----------------------------------------------");
	            
	            if(continuar == 1){
	                cont = 10;
	                pontos = 0;
	                criarCampo(vetor);
	            }
	            
	            else{
	                break;
	            }
	        }
    	   
	    }   
	}
}
