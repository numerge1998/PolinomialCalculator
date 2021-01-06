package tema1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import tema3.OperatiiPolinoame;

public class Test1 {
	OperatiiPolinoame oper = new OperatiiPolinoame();
	private Polinom pol3=new Polinom("4x^3");
	private Polinom pol4=new Polinom("12x^2");
	private Polinom pol5=new Polinom("x^4");
	private Polinom pol6=new Polinom("4x^3+12x^2");
	private Polinom pol7=new Polinom("4x^3-12x^2");
	private Polinom pol1=new Polinom("2x^3");
	private Polinom pol2=new Polinom("x^2");
	private Polinom pol8=new Polinom("2x^5");
	private Polinom pol9=new Polinom("x^2+2x^1+1");
	private Polinom pol10=new Polinom("x^1+1");
	private Polinom pol11=new Polinom("0");

	@Test
	public void test1() {
	//System.out.println("test adunare:" + OperatiiPolinoame.derivare(pol3) + "=" + pol4);
	assertEquals(oper.derivare(pol3).toString(),pol4.toString());

	}
	
	@Test
	public void test2() {
	//System.out.println("test integrare:" + OperatiiPolinoame.integrare(pol3) + "=" + pol5);
	assertEquals(oper.integrare(pol3).toString(),pol5.toString());

	}
	@Test
	public void test3() {
	//System.out.println("test adunare:" + OperatiiPolinoame.adunare(pol3,pol4) + "=" + pol6);
	assertEquals(oper.adunare(pol3,pol4).toString(),pol6.toString());

	}
	@Test
	public void test4() {
	//System.out.println("test scadere:" + OperatiiPolinoame.scadere(pol3,pol4) + "=" + pol7);
	assertEquals(oper.scadere(pol3,pol4).toString(),pol7.toString());

	}
	@Test
	public void test5() {
	//System.out.println("test inmultire:" + OperatiiPolinoame.inmultire(pol1,pol2) + "=" + pol8);
	assertEquals(oper.inmultire(pol1,pol2).toString(),pol8.toString());

	}
	@Test
	public void test6() {
		//System.out.println("test inmultire:" + OperatiiPolinoame.inmultire(pol1,pol2) + "=" + pol8);
		assertEquals(oper.impartire(pol9,pol10)[0].toString(),pol10.toString());
		assertEquals(oper.impartire(pol9,pol10)[1].toString(),pol11.toString());
		}

}
