package tp4;
import java.rmi.RemoteException;
import java.util.ArrayList;

import tp4_1.utilisateur;

public interface server {
	
	int[][] addMatrices(int[][] matrix1, int[][] matrix2) throws RemoteException;
    int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) throws RemoteException;
    int[][] transposeMatrix(int[][] matrix) throws RemoteException;
    public  int trouverUtilisateur(ArrayList<utilisateur> users,utilisateur client) throws RemoteException;
    public  int auth(utilisateur user) throws RemoteException;
	
	

}
