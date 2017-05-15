import java.util.ArrayList;

/**
 * reprezentace grafu pomoci matice sousednoti
 * @author Jokertwo
 *
 */

public class Matice_Sousednosti {
	ArrayList<String> pole = new ArrayList<String>();
	Vrchol[] vrchP;
	int[][] matice;
	int pocet =0;
	int pocetVrcholu;
	int casObjeveni = 0;

	
	
	//konstruktor
	public Matice_Sousednosti(int pocetVrcholu) {
			this.pocetVrcholu = pocetVrcholu;
			this.matice = new int [pocetVrcholu][pocetVrcholu];
			this.vrchP = new Vrchol[pocetVrcholu];
			
			for(int i = 0;i< vrchP.length;i++){
				vrchP[i] = null;
				}
	}
	
	
	
	/**
	 * vraci index vrcholu ulozeneho v poli
	 * @param klic String
	 * @return integer reprezentujici index v poli
	 */
	int index(String klic){
		int pom = -1;
		for(int i = 0;i< pocet;i++){
			if(vrchP[i].klic.equals(klic)){
				pom = i;
			}
		}	
	return pom;
	}
	
	/**
	 * metoda pro pridani noveho vrcholu
	 * @param klic string
	 */
	void novyVrchol(String klic){
		Vrchol pom = new Vrchol(klic,'B');
		
		vrchP[pocet] = pom;
		pocet++;
	
	}
	/**
	 * metoda pro vlozeni neorientovane hrany do grafu
	 * @param start string vrchol kde hrana zacina	
	 * @param cil	string vrchol kde hrana konci
	 */
	void neoHrana(String start,String cil){
		int iStart = index(start);
		int iCil = index(cil);
		
		if(iStart == -1)
			return;
		if(iCil == -1)
			return;
		
		matice[iCil][iStart] = 1;
		matice[iStart][iCil] = 1;
		vrchP[iStart].pocetSousedu = vrchP[iStart].pocetSousedu +1;
		vrchP[iCil].pocetSousedu = vrchP[iCil].pocetSousedu +1;	
	}
	
	/**
	 * metoda pro vlozeni orientovane hrany do grafu
	 * @param start String vrchol odkud hrana zacina
	 * @param cil	String vrchol kde hrana konci
	 */
	void orHrana(String start,String cil){
		int iStart = index(start);
		int iCil = index(cil);
		
		if(iStart == -1)
			return;
		if(iCil == -1)
			return;
		
		matice[iStart][iCil] = 1;
		vrchP[iStart].pocetSousedu = vrchP[iStart].pocetSousedu + 1;
	}
	
	
	
	
	
	
	/**
	 * prohledavani do hloubky
	 * @param start
	 */
	void DFS(String start){
		int s  = index(start);
		DFSR(s);
	}
	void DFSR(int start){
		vrchP[start].barva = 'S';
		casObjeveni++;
		vrchP[start].objeven = casObjeveni;
		
		int pom = matice.length-1;
		
		for(int i = 1;i<= vrchP[start].pocetSousedu;i++){
			while(matice[start][pom] ==0){
				pom--;
				}
			int v = pom--;
			if(vrchP[v].barva =='B'){
				vrchP[v].predchudce = vrchP[start].klic;
				DFSR(v);
			}
		}
		vrchP[start].barva = 'C';
		vrchP[start].dokoncen = casObjeveni = casObjeveni+ 1;
		pole.add(vrchP[start].klic);
	}
	/**
	 * metoda pro vypsani matice sousednosti
	 */
	void matice(){
		for(int i = 0;i<matice.length;i++){
			for(int j =0; j< matice[i].length;j++){
				System.out.print(matice[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	
	/**
	 * metoda pro prohledavani do sirky
	 * @param start
	 */
	void BFS(String start){
		int iStart = index(start);
		Fronta f = new Fronta(pocetVrcholu*2);
		
		vrchP[iStart].barva = 'S';
		vrchP[iStart].vzdalenost = 0;
		
		f.vloz(start);
		
		while(!f.jePrazdna()){
			String u = f.vyber();
			int indexU = index(u);
			int pom = 0;
			
			for(int i = 1;i<= vrchP[indexU].pocetSousedu;i++){
				while(matice[indexU][pom] == 0){
					pom++;
					
				}
				int a = pom++;
				
				
				if(vrchP[a].barva =='B'){
					vrchP[a].barva = 'S';
					vrchP[a].vzdalenost = vrchP[indexU].vzdalenost + 1;
					vrchP[a].predchudce = u;
					f.vloz(vrchP[a].klic);
				}
			}
			vrchP[indexU].barva = 'C';
			pole.add(vrchP[indexU].klic);
		}
		
		
	}
	
	String vytiskniBFS(){
		
		int min = 0;
		String vypis  = "BFS(" + pole.get(min)+ "): " + pole.get(min);
		
		for(int i = 1;i<pole.size();i++){
			vypis +=", " + pole.get(i);
			
		}
		return vypis;
	}
	
	String vytiskniDFS(){
	
		int max = pole.size()-1;
		String vypis = "DFS(" + pole.get(max)+"): " + pole.get(max);
		
		for(int i = max-1;i>=0;i--){
			vypis += ", " + pole.get(i) ;
			
		}
		return vypis;
	}
	

}
