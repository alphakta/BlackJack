
public class Carte {
	
public static final String[] TabCouleur = {"Coeur","Trefle","Pique","Carreau"};
public static final String[] TabVal = {"2","3","4","5","6","7","8","9","10","Valet","Dame","Roi","As"};
	
public String valeur;
public String couleur;

public Carte(String valeur, String couleur) 
{
	for(int i=0; i < TabVal.length; i++)
	{
		if (TabVal[i] == valeur)
		{
			this.valeur = valeur;
		}
	}
	
	for(int i=0; i < TabCouleur.length; i++)
	{
		if (TabCouleur[i] == couleur)
		{
			this.couleur = couleur;
		}
	}
}

public String getValeur() {
	return valeur;
}

public String getCouleur() {
	return couleur;
}

@Override
public boolean equals(Object o) {
	if(!(o instanceof Carte)) {
		return false;
	}
	Carte that = (Carte)o;
	return this.valeur == that.valeur && this.couleur == that.couleur;
}

@Override
public String toString() {
	return this.valeur + " de " + this.couleur ;
}

public static void main (String[] args){ 
	Carte c1 = new Carte ("5","coeur");
	Carte c2 = new Carte ("5","Coeur");
	Carte c3 = new Carte ("1","Roi");
	Carte c4 = new Carte ("1","Roi");

	
	System.out.println(c2);
	System.out.println(c1);
	System.out.println(c2.equals(c1));
	System.out.println(c3.equals(c4));
}
}
