package tema1;

import java.util.ArrayList;

public class Polinom {
	private ArrayList<Monom> pol = new ArrayList<Monom>();
	private int rank;
	
	public Polinom(String p) {
		ArrayList<String> in = input(p);
		
		int n = in.size();
		for(int i = 0 ; i < n; i += 2) {
			//determinat coeficientul si puterea monomului
			int coef = Integer.parseInt(in.get(i));
			//System.out.print(coef);
			int put = Integer.parseInt(in.get(i + 1));
			//formeaza polinoamele cu puterea cea mai mica
			int pow;
			if(i - 2 < 0)
				pow = 0;
			else {
				pow = Integer.parseInt(in.get(i - 1));
				pow++;
			}
				
			//adaug elementele goale
			while(put >= pol.size()) {
				pol.add(new Monom(pow, 0));
				pow++;
			}
			
			//actualizez elementele
			pol.get(put).setNumar(coef);
			pol.get(put).setPutere(put);
			
			//System.out.println(pol.get(put)+" ");
		}
		rank = pol.size();
	}
	
	public Polinom(ArrayList<Monom> pol) {
		this.pol = pol;
		rank = pol.size();
	}
	

	private ArrayList<String> input(String p) {
		ArrayList<String> in = new ArrayList<String>();
		String[] comp = p.split("x\\^|x|(?=-)|(?=\\+)");
		
		for(int i = 0; i < comp.length;  i++) {
			//System.out.print(comp[i]+" ");
			if(comp[i].length() == 0)
				in.add("1");
			else {
				if(comp[i].equals("-") || comp[i].equals("+"))
					comp[i] += "1";
				//System.out.print(comp[i]+" ");
				in.add(comp[i]);
			}
		}
		if(in.size() % 2 != 0)
			in.add("0");
		
		for(int i=0;i<in.size();i++)
			System.out.print(" "+in.get(i)+"\n");
		
		for(int i=1;i<in.size();i+=2) {
			//System.out.print(in.get(i)+" ");
			int a=Integer.parseInt(in.get(i-1));
			int c=Integer.parseInt(in.get(i));
			for(int j=i+2;j<in.size();j+=2) {
				
				int b=Integer.parseInt(in.get(j-1));
				
				int d=Integer.parseInt(in.get(j));
				if(c==d) {
					//System.out.print(" gasit");
					
					a=a+b;
					in.set(i-1,""+a);

					in.remove(j);
					in.remove(j-1);
				}
				
			}
			}

		return in;
	}
	
	public ArrayList<Monom> getPol() {
		return pol;
	}

	public void setPol(ArrayList<Monom> pol) {
		this.pol = pol;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String toString() {
		if (rank == 0 || (rank == 1 && pol.get(0).getNumar() == 0.0)) {
			return "0";
		}
		else {
			String ret=pol.get(rank - 1).toString();
			
			for(int i = rank - 2; i >= 0; i--) {
				float c = pol.get(i).getNumar();
				if(c != 0) {
					if(c > 0)
						ret += "+";
				
					ret += pol.get(i);
				}
			}
		return ret;
		}
	}
}
