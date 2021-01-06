package tema3;

import java.util.ArrayList;
import java.util.Collections;

import tema1.Monom;
import tema1.Polinom;


public class OperatiiPolinoame {

	public Polinom adunare(Polinom pol1, Polinom pol2) {//modif
		ArrayList<Monom> rez = pol1.getPol();
		ArrayList<Monom> op = pol2.getPol();
		int n = rez.size();
		int n1 = op.size();
		if(n >= n1) {
			for(int i = 0;i < n;i++) {
				if(i < n1) {
					rez.get(i).suma(op.get(i).getNumar());
				}
			}
			return new Polinom(rez);
		}
		else {
			for(int i = 0; i < n1; i++) {
				if(i < n) {
					op.get(i).suma(rez.get(i).getNumar());
				}
			}
			return new Polinom(op);
		}
	}

	
	public Polinom scadere(Polinom pol1, Polinom pol2) {
		ArrayList<Monom> rez = pol1.getPol();
		ArrayList<Monom> op = pol2.getPol();
		
		int n = rez.size();
		int n1 = op.size();
		
		//adunare coef
		for(int i = 0; i < n1 && i < n; i++) {
			rez.get(i).suma(-op.get(i).getNumar());
		}
		
		//daca gradul celui de al doilea polinom e mai amre decat primul se adauga el
		while(n < n1) {
			rez.add(op.get(n));
			rez.get(n).setNumar(-op.get(n).getNumar());
			n++;
		}
		return new Polinom(rez);
	}
	
	public Polinom derivare(Polinom pol) {//modif
		ArrayList<Monom> rez = pol.getPol();
	
		int c = rez.size();
		for(int i = 0; i < c; i++) {
			rez.get(i).setNumar(rez.get(i).getNumar() * rez.get(i).getPutere());
			rez.get(i).setPutere(rez.get(i).getPutere() - 1);
		}
		/*for(Monom mon:rez) {
			float a=mon.getCoeficient();
			int b=mon.getPutere();
			mon.setCoeficient(a*b);
			mon.setPutere(b-1);
		}	*/
		
		return new Polinom(rez);
		
	}
	
	public Polinom integrare(Polinom pol) {
		ArrayList<Monom> rez = pol.getPol();
		
		for(Monom mon: rez) {
			float a = mon.getNumar();
			int b = mon.getPutere();
			mon.setNumar(a / (b + 1));
			mon.setPutere(b + 1);
		}
		
		return new Polinom(rez);
	}
	
	public Polinom inmultire(Polinom a, Polinom b) {
		ArrayList<Monom> rez = new ArrayList<Monom>();
		for(int i = 0; i < a.getRank() + b.getRank() - 1; i++)
			rez.add(new Monom(i, 0));
		ArrayList<Monom> pol1 = a.getPol();
		ArrayList<Monom> pol2 = b.getPol();
		
		for(Monom monoma: pol1) {
			//inmultest fiecare el cu fiecare el si adaug coef
			for(Monom monomb: pol2) {
				int p = monoma.getPutere() + monomb.getPutere();
				float c = monoma.getNumar() * monomb.getNumar();
				rez.get(p).suma(c);
				//rez.get(i) -> monomul de pe poz i
				
			}
		}
		return new Polinom(rez);
	}
	
	public Polinom[] impartire(Polinom a, Polinom b) {
		ArrayList<Monom> rez = new ArrayList<Monom>();
		ArrayList<Monom> pol1 = a.getPol();
		ArrayList<Monom> pol2 = b.getPol();
		//det puetre si coef impartitor
		int putere = pol2.size() - 1;
		float coeficient = pol2.get(putere).getNumar();
		while(pol1.size() >= putere + 1) {
			//det putere si coef deimpartit
			int n = pol1.size() - 1;
			int p = n - putere; //putere cat
			float coef = pol1.get(n).getNumar() / coeficient; //coef cat
			
			//adunare sol in rez final
			rez.add(new Monom(p, coef)); 
			
			for(Monom mon: pol2) {
				//actualizare deimaprtit
				int p1 = mon.getPutere() + p;
				float coef1 = mon.getNumar() * coef;
				
				pol1.get(p1).suma(- coef1);
			}
			//eliminare element cu puterea cea mai mare din deimpartit pt a nu mai efectua scaderi din el
			pol1.remove(n);
		}
		
		//inverseaza rez - in ordice cresc dupa puteri
		Collections.reverse(rez);
		
		//catul si restul
		
		Polinom[] rezultat = {new Polinom(rez) , new Polinom(pol1)};
		return rezultat;
	}
	
}
