package tp4;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import tp4_1.utilisateur;

public class serverImpl extends UnicastRemoteObject implements server {
	public  serverImpl() throws RemoteException {}
static ArrayList<utilisateur> User = new ArrayList<utilisateur>(); 

	
	
	public int[][] addMatrices(int[][] A, int[][] B)throws RemoteException{
		
		int[][] Somme = new int[A.length][A[0].length];
		for(int i=0;i<A.length;i++) {
    		for(int j=0;j<A[i].length;j++) {
    			Somme[i][j] = A[i][j] + B[i][j];
	    	}	
	    }
		return Somme;	
	}
	public int[][] multiplyMatrices(int[][] A, int[][] B)throws RemoteException{
		
		int[][] produit = new int[A.length][B[0].length];
		for(int i=0;i<A.length;i++) {
    		for(int j=0;j<B[0].length;j++) {
    			for(int k=0;k<A[0].length;k++)
    			produit[i][j] += A[i][k] * B[k][j];
    		}	
    	}
		return produit;
		
	}
	
	public int[][] transposeMatrix(int[][] A)throws RemoteException{
		
		int[][] tmatrice = new int[A[0].length][A.length];
		for(int i=0;i<A[0].length;i++) {
    		for(int j=0;j<A.length;j++) {
    			tmatrice[j][i] = A[i][j];
    		}	
    	}
		return tmatrice;
				
	}
	
	public  int trouverUtilisateur(ArrayList<utilisateur> User,utilisateur client) throws RemoteException{
		for(int i=0; i < User.size(); i++) {
			if (client.getId().equals(User.get(i).getId())) return i;
		}
		return -1;
	}
	
	public int auth(utilisateur client) throws RemoteException{
		if (trouverUtilisateur( User, client) != -1) {
			
			if(User.get(trouverUtilisateur(User,client)).getPass().equals(client.getPass())) {
				System.out.println("Le client: "+client.getId()+" est authentifié!");
				return 1;
				}
			else {
				System.out.println("Mot de pass incorrect pour le client: "+client.getId());
				return 0;
			}
			}
		else {
			User.add(client);
			System.out.println("Le client: "+client.getId()+" est ajouté!");
			return 1;
		}
	}
	
	
	
	
	
	
}


