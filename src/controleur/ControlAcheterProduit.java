package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean isHabitant(String nomGaulois) {
		return village.trouverHabitant(nomGaulois) != null;
	}
	
	public String[] trouverVendeurs(String nomProduit) {
		Gaulois[] vendeurs = village.rechercherVendeursProduit(nomProduit);
		String[] vendeursNom = new String[vendeurs.length];
		
		for(int i = 0; i < vendeurs.length; i++) {
			vendeursNom[i] = vendeurs[i].getNom();
		}
		
		return vendeursNom;
	}
	
	public void acheterProduit(int quantite, String nomVendeur) {
		controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).acheterProduit(quantite);
		
	}
}
