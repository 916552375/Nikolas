package javasrc;

import javasrc.extentsTest.LittleSun;
import javasrc.interfaceTest.EatFruit;
import javasrc.interfaceTest.IFruit;

@Deprecated
public class TestDemo{
	public static void main(String args[]) throws Exception{
	    LittleSun lSun =(LittleSun) Class.forName("javasrc.extentsTest.LittleSun").newInstance();
	    lSun.hobby();
	    IFruit iFruit= (EatFruit) Class.forName("javasrc.interfaceTest.EatFruit").newInstance();
	    iFruit.eat();
    }
}