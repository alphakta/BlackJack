import java.util.Scanner;

public abstract class Joueur {

	public SimpleMain main;
	
	public Joueur(SimpleMain main) {
			this.main = main;
	}
	
	
	public boolean prendCarte()
	{
		if(this instanceof JoueurHumain) // si la classe est un JoueurHumain
		{
		System.out.println("Voulez-vous une autre carte ? 'Carte' (si oui) || 'Je reste' (si non)");
	     @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
	    String s = sc.nextLine();

	    
		     if (s.equals("Carte")) // si s est égal à Carte
		     {
		 		return true;
		     }
		     
		     else if (s.equals("Je reste")) // si s est égal à Je reste
		     {
		 		return false;
		     }

		     else
		    	 return false;



		}
		
		if (this instanceof JoueurOrdinateur) // si la classe est un JoueurOrdinateur
		{
			if(main.valeur() <= 16)
			{
				return true;
			}
			else
				return false;
		}
		throw new Error("Erreur"); // on retourne une erreur

	}
}

