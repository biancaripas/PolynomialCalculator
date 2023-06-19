package org.example;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestOperatii {
    @Test
    public void AdunareTest()    {
        Polynomial polynomial1=new Polynomial();
        Polynomial polynomial2=new Polynomial();
        polynomial1.addMonomial(3,2.0);
        polynomial1.addMonomial(2,3.0);
        polynomial2.addMonomial(3,4.0);
        polynomial2.addMonomial(2,3.0);
        Polynomial rezultat=new Polynomial();
        rezultat=polynomial1.add(polynomial2);
        assertEquals("6.0x^3 + 6.0x^2",rezultat.toString());    }

    @Test
    public void ScadereTest()    {
        Polynomial polynomial1=new Polynomial();
        Polynomial polynomial2=new Polynomial();
        polynomial1.addMonomial(3,2.0);
        polynomial1.addMonomial(2,3.0);
        polynomial2.addMonomial(3,4.0);
        polynomial2.addMonomial(2,3.0);
        Polynomial rezultat=new Polynomial();
        rezultat=polynomial1.subtract(polynomial2);
        assertEquals("-2.0x^3",rezultat.toString());
    }
    @Test
    public void InmultireTest()    {
        Polynomial polynomial1=new Polynomial();
        Polynomial polynomial2=new Polynomial();
        polynomial1.addMonomial(3,2.0);
        polynomial1.addMonomial(2,3.0);
        polynomial2.addMonomial(3,4.0);
        polynomial2.addMonomial(2,3.0);
        Polynomial rezultat=new Polynomial();
        rezultat=polynomial1.multiply(polynomial2);
        assertEquals("8.0x^6 + 18.0x^5 + 9.0x^4",rezultat.toString());
    }
    @Test
    public void DerivareTest()    {
        Polynomial polynomial1=new Polynomial();
        Polynomial polynomial2=new Polynomial();
        polynomial1.addMonomial(3,2.0);
        polynomial1.addMonomial(2,3.0);
        polynomial2.addMonomial(3,4.0);
        polynomial2.addMonomial(2,3.0);
        Polynomial rezultat=new Polynomial();
        rezultat=polynomial1.differentiate();
        assertEquals("6.0x^2 + 6.0x",rezultat.toString());
    }
    @Test
    public void IntegrareTest()    {
        Polynomial polynomial1=new Polynomial();
        Polynomial polynomial2=new Polynomial();
        polynomial1.addMonomial(3,4.0);
        polynomial1.addMonomial(4,6.0);
        polynomial2.addMonomial(3,4.0);
        polynomial2.addMonomial(2,3.0);
        Polynomial rezultat=new Polynomial();
        rezultat=polynomial1.integrate();
       // assertEquals("-2.0x^3",rezultat.toString());
        assertEquals("1.2x^5 + x^4",rezultat.toString());
    }
}
