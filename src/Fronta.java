
/**
 * Implementace fronty uchovajici 
 * String
 * 
 * @author Jokertwo
 *
 */

public class Fronta {


	
	private String[] f;
	private int zac,kon;
	int n;
	
	//konstruktor
	Fronta(int max) {
		n = max+1;
		f = new String[n];
		zac = 0;
		kon = 0;
		// TODO Auto-generated constructor stub
	}
	/**
	 * test jestli je fronta prazdna
	 * @return pokud je prazdna vraci TRUE jinak FALSE
	 */
	boolean jePrazdna(){
		if(zac == kon){
			return true;
		}
		return false;
	}
	
	/**
	 * vlozeni do fronty
	 * @param klic String
	 */
	void vloz(String klic){
		kon++;
		f[kon] = klic;
		kon = kon%n;
		
	}
		
	/**
	 * vyber z fronty
	 * 	
	 * @return vraci String ulozeny ve fronte
	 */
	String vyber(){
		zac++;
		String a  = f[zac];
		zac = zac%n;
		return a;
	}
	
		
		
		

}
