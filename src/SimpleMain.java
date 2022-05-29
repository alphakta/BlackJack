

public class SimpleMain extends CardSet implements Comparable<Object>{
	
	
	public SimpleMain()
	{
		super();
	}

	public int valeur()
	{
		String[] tabInt = {"2","3","4","5","6","7","8","9","10"};
		String[] tabString = {"Valet","Dame","Roi","As"};

		int val = 0;
		for(int i=0; i<CardSet.size(); i++) 
		{
			for(int j=0; j<tabInt.length ; j++) 
			{
				if(CardSet.get(i).getValeur() == tabInt[j]) 
				{
					val = val + Integer.parseInt(CardSet.get(i).getValeur()); //Integer.parseInt : fonction qui converti un string de nombre en int
				}
			}
			
			for(int j=0; j<tabString.length; j++) 
			{
				if(CardSet.get(i).getValeur() == tabString[j])  // Si la valeur de la carte fait partie des valeurs de mon tableau de string alors on ajoute 10 à val
				{
					val = val + 10;
				}
			}

			

		}
		return val;
	}
	
	@Override
	public int compareTo(Object o) {
		if(!(o instanceof SimpleMain)) {
			throw new Error("");
		}
		SimpleMain that = (SimpleMain)o;
		
		int val;
		
		if(this.valeur() > that.valeur())
		{
			val = 1;
		}
		else if(this.valeur() < that.valeur())
		{
			val = -1;
		}
		else
			val = 0;

			return val;
	}
	
	
	public static void main (String[] args){ 
		SimpleMain m = new SimpleMain();
		Carte c1 = new Carte ("5","coeur");
		Carte c2 = new Carte ("4","Coeur");
		m.CardSet.add(c1);
		m.CardSet.add(c2);

 
        System.out.println(m.estValide());

	}


	
	

}
