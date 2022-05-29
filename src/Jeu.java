
public class Jeu {
	public SimpleTalon talon;
	
	public Jeu(SimpleTalon t) {
		this.talon = t;
	}

	public void transferCards(Joueur j, int x) 
	{
			for (int i=0; i<x; i++) // en fonction du nombre de carte � transf�rer
			{
		        j.main.CardSet.add(talon.CardSet.get(0)); // on ajoute � la main la carte avec index 0
		        talon.CardSet.remove(0); // on retire du talon la carte ajout�
			}	
	}
	
	public static void main (String[] args)
	{ 
		SimpleTalon t1 = new SimpleTalon(); // Initialisation du talon
		SimpleMain m1 = new SimpleMain(); // Initialisation des 2 mains, celui du joueur et l'ordinateur
		SimpleMain m2 = new SimpleMain();
		
		for(int i=0; i<7; i++) // on fait 7 r�p�titions du m�lange am�ricain
			t1.CardSet = t1.melanger();
		
		

		Jeu BlackJack = new Jeu(t1); // On initialise le jeu avec en param�tre le joueur
		JoueurHumain jo1 = new JoueurHumain(m1); // On initialise le joueurHumain avec une "main"
		JoueurOrdinateur jo2 = new JoueurOrdinateur(m2);// On initialise le joueurOrdinateur avec une "main"
		
		// On transf�re 2 cartes � chacun des joueurs
		BlackJack.transferCards(jo1, 1);
		BlackJack.transferCards(jo2, 1);
		BlackJack.transferCards(jo1, 1);
		BlackJack.transferCards(jo2, 1);
		
		System.out.println("..............BLACKJACK..............");
		System.out.println(".....................................");
		System.out.println("");
		System.out.println("Le but est de battre le croupier sans d�passer 21.");
		System.out.println("D�s qu'un joueur fait plus que 21, on dit qu'il � Br�le � ou qu'il � cr�ve � et il perd sa mise initiale.");
		System.out.println("");
		
		
		System.out.println("La Main du joueur est �gal � " + jo1.main);
		System.out.println("Valeur totale de la main : " + jo1.main.valeur());
		System.out.println("");

			
		while (jo1.prendCarte()) //tant que prendCarte retourne vrai
		{
			BlackJack.transferCards(jo1, 1);// on transf�re 1 seule carte 
			// On lui montre sa main
			System.out.println("La Main du joueur est �gal � " + jo1.main);
			System.out.println("Valeur totale de la main : " + jo1.main.valeur());
			
			if(jo1.main.valeur() >= 21 ) // si la valeur de la main est plus grand ou �gal � 21, on arrete le while et on sort de la boucle
			{
				break;
			}
		}

		while (jo2.prendCarte()) 
		{
			BlackJack.transferCards(jo2, 1); 
			
			if(jo2.main.valeur() >= 21) 
			{
				break;
			}
		}
		
		System.out.println("");
		System.out.println("///////////////////////////////////////////////////////////");
		System.out.println("                       SCORE                               ");
		System.out.println("///////////////////////////////////////////////////////////");
		System.out.println("La Main du joueur est �gal � " + jo1.main);
		System.out.println("Valeur totale de la main : " + jo1.main.valeur());
		System.out.println("");
		System.out.println("Main de l'ordinateur est �gal � " + jo2.main);
		System.out.println("Valeur totale de la main : " + jo2.main.valeur());
		System.out.println("");
		
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		if(jo1.main.compareTo(jo2.main) == 0 )
		{
			System.out.println("		Il y a �galit� !		");
		}
		
		if(jo1.main.compareTo(jo2.main) == 1 && jo1.main.valeur() <= 21)
		{
			System.out.println("		F�licitations! Vous avez gagn�!		");
		}
		
		else if(jo1.main.compareTo(jo2.main) == 1 && jo1.main.valeur() > 21 && jo2.main.valeur() <= 21)
		{
			System.out.println("		Perdu! L'ordinateur � gagn�		");
		}
		
		else if(jo1.main.compareTo(jo2.main) == -1 && jo2.main.valeur() <= 21)
		{
			System.out.println("		Perdu! L'ordinateur � gagn�		");
		}
		
		else if(jo1.main.compareTo(jo2.main) == -1 && jo2.main.valeur() > 21 && jo1.main.valeur() <= 21)
		{
			System.out.println("		F�licitations! Vous avez gagn�!		");
		}
		
		else if(jo1.main.compareTo(jo2.main) == 1 && jo2.main.valeur() > 21)
		{
			System.out.println("		Malheureusement! Personne � gagn�!		");
		}
		else if(jo2.main.compareTo(jo1.main) == 1 && jo1.main.valeur() > 21)
		{
			System.out.println("		Malheureusement! Personne � gagn�!		");
		}
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

	}
}


        

