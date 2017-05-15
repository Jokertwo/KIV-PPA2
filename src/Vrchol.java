/**
 * trida reprezentujici jeden vrchol grafu
 * 
 * @author Jokertwo
 *
 */

public class Vrchol {
 
	
	
	String klic;
	String predchudce;
	
	char barva;
	
	int predek;
	int vzdalenost;
	int objeven;
	int dokoncen;
	int pocetSousedu;
	
	Soused soused;
	
	
	Vrchol(String klic, char barva){
		this.klic = klic;
		this.barva = barva;
		pocetSousedu = 0;
		vzdalenost = Integer.MAX_VALUE;
		predchudce = null;
		soused = null;
	}

	void tiskVrcholu(){
		System.out.print(klic+ " ");
	}
}
