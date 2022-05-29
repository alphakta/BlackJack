import java.util.ArrayList;
import java.util.Random;

public class SimpleTalon extends CardSet {
	

	public SimpleTalon() 
	{		
		super();
	}
	
	public boolean estComplet() 
	{
		if (CardSet.size() == 52) 
		{
			return true;
		}	
			return false;
	}
	
	public ArrayList<Carte> melanger() {
		ArrayList<Carte> packet1 , packet2, packetFinal;
		packet1 = new ArrayList<Carte>();
		packet2 = new ArrayList<Carte>();
		packetFinal = new ArrayList<Carte>(52);
		
		int n = CardSet.size();
		
		Random random = new Random();
		  
		int k = 0;
		
		for(int i=0; i<n; i++ ) // on fait une boucle de i jusqu'� n => taille du talon
		{
			int nb;
			nb = 1 + random.nextInt(3-1); // on initialise un nombre al�atoire entre 1 et 2
			// on regard si le nombre al�atoire est 1 ou 2
			   if(nb == 1)  // si le nombre al�atoire est 1, alors on suit une p = 0.5
			   {
				   k = k + 1;  // on incr�mente k
			   }
		}
		
			
			for(int j=0; j<k; j++) // boucle de 0 � k
			{
				packet1.add(CardSet.get(j)); // on ajoute les valeurs du cardset au packet1, � partir de 0 jusqu'� k
			}
			
			for(int x=k; x<CardSet.size(); x++) // boucle de k � la fin du tableau du cardset
			{
				packet2.add(CardSet.get(x)); // on ajoute les valeurs du cardset au packet2, � partir de k jusqu'� la fin du tableau
			}
			
			int a, b;

			int nbAlea = 0;
			
			while(packetFinal.size() != n) // tant que mon packet n'est pas complet donc 52
			{
				a = packet1.size();
				b = packet2.size();
				nbAlea = 1 + random.nextInt(53-1);		// on cr�e un nombre aleatoire compris entre 1 et 53 (53 est exclu) donc [1-52]
				
				if(nbAlea >= 1 && nbAlea <= a)  // si mon nombre aleatoire est compris entre 1 et la taille du packet1 alors on suit la probabilit� qui est �quivalente � (a/(a+b))
				{
					if(packet1.size() - 1 != -1) // si la taille de mon packet est diff�rent de -1 
					{
						packetFinal.add(packet1.get(packet1.size() - 1)); // alors on ajoute � mon packetFinal, la derniere valeur de mon packet 1
						packet1.remove(packet1.size() - 1); // et on la retire
					}
					else
						if (packet1.size() == 0) // si mon packet 1 est vide
						{
							for(int i=0; i<packet2.size(); i++) // 
							{
								packetFinal.add(packet2.get(i)); // alors on ajoute toutes les valeurs restantes du packet2 au packet final
								packet2.remove(i); // et on la retire du packet
							}
						}

				}
				
				if(nbAlea >= a+1 && nbAlea <= 52)  // si mon nombre aleatoire est compris entre a+1 et la taille du packet2 alors on suit la probabilit� qui est �quivalente � (b/(a+b))
				{
					// puis on fait les m�me �tape que pr�c�demment
					if(packet2.size() - 1 != -1)
					{
						packetFinal.add(packet2.get(packet2.size() - 1));
						packet2.remove(packet2.size() - 1);
					}
					else
						if (packet2.size() == 0) // si mon packet 2 est vide
						{
							for(int i=0; i<packet1.size(); i++)
							{
								packetFinal.add(packet1.get(i));
								packet1.remove(i);
							}
						}
				}
			}
		
		return packetFinal; // on retourne l'arraylist
		
	}
	

	
	public static void main (String[] args){ 
		SimpleTalon s = new SimpleTalon();
		//SimpleTalon s1 = new SimpleTalon();
			//System.out.println(s);
			//System.out.println(s1);
			//System.out.println(s.estValide());
			System.out.println(s.melanger());
	}

	

}
