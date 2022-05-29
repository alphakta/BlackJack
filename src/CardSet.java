import java.util.ArrayList;
//import java.util.Collections;

public abstract class  CardSet {
	
	public ArrayList<Carte> CardSet;
	
	public CardSet() 
	{
		if(this instanceof SimpleTalon) 
		{
			String[] TabCouleur = {"Coeur","Trefle","Pique","Carreau"};
			String[] TabVal = {"2","3","4","5","6","7","8","9","10","Valet","Dame","Roi","As"};
			CardSet = new ArrayList<Carte>(52);
			
			for(int i=0;i < TabVal.length;i++)
			{
				for(int j = 0;j < TabCouleur.length ;j++)
				{
					CardSet.add(new Carte(TabVal[i],TabCouleur[j]));
				}
			}
			//Collections.shuffle(CardSet);	
		}
		
		else if (this instanceof SimpleMain) {
			CardSet = new ArrayList<Carte>();
		}

	}

	public boolean estValide() 
	{
		int cpt = 0;
		
			for (int j = 0; j<CardSet.size(); j++)
			{
				for(int i = j+1; i <CardSet.size(); i++)
				{
					if (CardSet.get(j).equals(CardSet.get(i))) 
					// On va les comparer avec 2 boucles
					// la premiere boucle se charge de boucle l'arraylist avc indice [i] et l'autre boucle qui va boucler toutes les valeurs à partir de l'indice [i+1]
					// par ex: {1,2,3,6} 
					// il va comparer 1 à 2,3 et 6, puis 2 à 3 et 6 et ainsi de suite
					{
						cpt++; // on incrémente le compteur si une carte est égale à une autre sinon on fait rien
					}
				}
			}
		
		
		if (cpt == 0) 
		// si la CardSet est égal au nombre de carte et le compteur est égal à 0 alors toutes les cartes sont différentes, on retourne true
		{ 			
			return true;
		}
		
		return false;
	}

	@Override
	public String toString() {
		return  "" + CardSet;
	}
}
