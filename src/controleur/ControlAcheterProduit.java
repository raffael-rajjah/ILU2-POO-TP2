package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
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
		
		if(vendeurs == null) {
			return new String[0];
		}
		
		String[] vendeursNom = new String[vendeurs.length];
		
		for(int i = 0; i < vendeurs.length; i++) {
			vendeursNom[i] = vendeurs[i].getNom();
		}
		
		return vendeursNom;
	}
	
	public String acheterProduit(int quantite, String nomVendeur, String nomAcheteur) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		int quantiteReste = etal.getQuantite();
		if(quantiteReste == 0) {
			return nomAcheteur + " veut acheter " + quantite + " " + etal.getProduit() +", malheuresement il n'y en a plus !";
		}
		
		else if(quantiteReste < quantite) {
			etal.acheterProduit(quantite);
			return nomAcheteur + " veut acheter " + quantite + " " + etal.getProduit() +", malheuresement " + nomVendeur + " n'en a plus que " + quantiteReste + ". " + nomAcheteur + " achète tout le stock de " + nomVendeur + ".";
		}
		
		else {
			return nomAcheteur + "achète " + quantite + " " + etal.getProduit() + " à " + nomVendeur;
		}
	}
}
