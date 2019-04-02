import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testPolinoame {

	@Test
	void test() 
	{
    	Polinom p1 = new Polinom();
    	p1.citirePolinom("1x^2+1x^0");
    	Polinom p2 = new Polinom();
    	p2.citirePolinom("3x^2-1x^1");

    	Polinom p3 = new Polinom();
    	
    	p3 = p1.polinomAdunare(p2);
		assertEquals("+4.0x^2-1.0x^1+1.0x^0", p3.afisarePolinom());
		p3 = p1.polinomScadere(p2);
		assertEquals("-2.0x^2+1.0x^1+1.0x^0", p3.afisarePolinom());
		p3 = p1.polinomDerivata();
		assertEquals("+2.0x^1", p3.afisarePolinom());
		p3 = p1.polinomIntegrala();
		assertEquals("+0.33333334x^3+1.0x^1", p3.afisarePolinom());
    	p3 = p1.polinomInmultire(p2);
    	assertEquals("+3.0x^4-1.0x^3+3.0x^2-1.0x^1", p3.afisarePolinom());
	}

}
