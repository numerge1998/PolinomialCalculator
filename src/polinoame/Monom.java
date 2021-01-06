package tema1;

public class Monom {
	private int putere;
	private float numar;
	
	public Monom(int putere, float f) {
		this.putere = putere;
		this.numar = f;
	}
	
	public Monom() {
		this.putere = 0;
		this.numar = 0;
	}
	
	public void suma(float nr) {
		numar += nr;
	}
	
	public int getPutere() {
		return putere;
	}

	public void setPutere(int putere) {
		this.putere = putere;
	}

	public float getNumar() {
		return numar;
	}

	public void setNumar(float nr) {
		this.numar = nr;
	}
	
	public String toString() {
		//return  "coeficient " + coeficient + "\nputere " + putere + "\n";
		if(putere == 1) 
			return " " + numar + "x\n";
		if(putere == 0)
			return  " " + numar  +  " \n";
		else 
			if(numar == 1)
				return  " " + "x" + "^" + putere + " \n";
			else
				return  " " + numar + "x" + "^" + putere + " \n";
	}
}

