package tp4_2;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
import java.rmi.*;
import tp4.server;
import tp4_1.utilisateur;

public class Client {

	public static void main (String argv[] ) {
		
		try {
			String adresse="localhost";
			//Registry registry = LocateRegistry.getRegistry(adresse, 1099);
			server obj = (server) Naming.lookup("//:1099/obj");
			
			
			Scanner scanner = new Scanner(System.in);
		    System.out.println("Entrez id : ");
		    String id = scanner.nextLine();
		    System.out.println("Entrez pass : ");
		    String pass = scanner.nextLine();
			utilisateur utili = new utilisateur(id,pass);
			
			String op = scanner.nextLine();
		    System.out.println(op);
		    
		    

			int auth = obj.auth(utili);
			while (auth == 0) {
				System.out.println("Mot de pass incorrect!");
				System.out.print("Nom: ");
			    id = scanner.nextLine();
			    System.out.print("mot de passe: ");
			    pass = scanner.nextLine();
			    auth = obj.auth(utili);
			}
		    
		    
		    switch(op) {
		    case "+":
		    	int[][] matrice1= new int[4][4];
		    	int[][] matrice2= new int[4][4];
		    	for(int i=0;i<4;i++) {
		    		for(int j=0;j<4;j++) {
		    			Random rand = new Random();
						matrice1[i][j]=rand.nextInt(10);
		    		}
		    	}
		    	for(int i=0;i<4;i++) {
		    		for(int j=0;j<4;j++) {
		    			Random rand = new Random();
						matrice2[i][j]=rand.nextInt(10);
		    		}
		    	}
		    	System.out.println("La  matrice 1 :");
			    for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++)
		             System.out.print(matrice1[i][j] + " ");
					System.out.println("");
				 }
			    System.out.println("La  matrice 2 :");
			    for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++)
		             System.out.print(matrice2[i][j] + " ");
					System.out.println("");
				 }
		    	
		    	int[][] result = obj.addMatrices(matrice1,matrice2);
			    System.out.println("Le resultat :");
			    for (int i = 0; i < result.length; i++) {
					for (int j = 0; j < result[i].length; j++)
		             System.out.print(result[i][j] + " ");
					System.out.println("");
				}
		    	
		    	
		    	break;
		    case "*":
		    	int[][] matrice3= new int[4][3];
		    	int[][] matrice4= new int[3][4];
		    	for(int i=0;i<4;i++) {
		    		for(int j=0;j<4;j++) {
		    			Random rand = new Random();
						matrice3[i][j]=rand.nextInt(10);
		    		}
		    	}
		    	for(int i=0;i<4;i++) {
		    		for(int j=0;j<4;j++) {
		    			Random rand = new Random();
						matrice4[i][j]=rand.nextInt(10);
		    		}
		    	}
		    	
		    	System.out.println("La  matrice 1 :");
			    for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 3; j++)
		             System.out.print(matrice3[i][j] + " ");
					System.out.println("");
				 }
			    System.out.println("La  matrice 2 :");
			    for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 4; j++)
		             System.out.print(matrice4[i][j] + " ");
					System.out.println("");
				 }
		    	
		    	
		    	int[][] resultmultiplication = obj.multiplyMatrices(matrice3, matrice4);
			    System.out.println("Le resultat :");
			    for (int i = 0; i < resultmultiplication.length; i++) {
					for (int j = 0; j < resultmultiplication[i].length; j++)
		             System.out.print(resultmultiplication[i][j] + " ");
					System.out.println("");
				}
		    	
		    	
		    	
		    	break;
		    	
		    case "t":
		    	int[][] matrice5= new int[4][3];
		    	for(int i=0;i<4;i++) {
		    		for(int j=0;j<4;j++) {
		    			Random rand = new Random();
						matrice5[i][j]=rand.nextInt(10);
		    		}
		    	}
		    	
		    	System.out.println("La  matrice  :");
			    for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 3; j++)
		             System.out.print(matrice5[i][j] + " ");
					System.out.println("");
				 }
		    	
		    	 int[][] resultTranspose =  obj.transposeMatrix(matrice5);
				    System.out.println("Le resultat :");
				    for (int i = 0; i < resultTranspose.length; i++) {
						for (int j = 0; j < resultTranspose[i].length; j++)
			             System.out.print(resultTranspose[i][j] + " ");
						System.out.println("");
					}
			break;
			default:break;
			
		} 
		    }catch (Exception e) {
		    	e.printStackTrace();
		}
		

		}
	
}
