package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if(!controlAcheterProduit.isHabitant(nomAcheteur)) {
			System.out.println("Je suis désolée " + nomAcheteur + " mais il faut être un habitant de notre village pour commercer ici.");
		}
		
		else {
			
			String[] vendeursNom;
			
			do {
				String nomProduit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
				vendeursNom = controlAcheterProduit.trouverVendeurs(nomProduit);
				
				if(vendeursNom.length <= 0) {
					System.out.println("Désolé, personne ne vend ce produit au marché.");
				}
			}
			while(vendeursNom.length <= 0);
			
			System.out.println("Chez quel commerçant voulez-vous acheter des fleurs ?");
			for(int i = 0; i < vendeursNom.length; i ++) {
				System.out.println((i+1) + " - " + vendeursNom[i]);
			}
			
			int vendeurChoix;
			
			do {
				vendeurChoix = Clavier.entrerEntier("");
				
				if(vendeurChoix > vendeursNom.length) {
					System.out.println("Choix non valide");
				}
				
				
			} while (vendeurChoix > vendeursNom.length);
				
		
			
			System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + vendeursNom[vendeurChoix - 1]);
			int quantite = Clavier.entrerEntier("Bonjour " + nomAcheteur + "\nCombien de fleurs voulez-vous acheter ?");
			
			String message = controlAcheterProduit.acheterProduit(quantite, vendeursNom[vendeurChoix - 1], nomAcheteur);
			
			System.out.println(message);
		
		}
		
	}
}
