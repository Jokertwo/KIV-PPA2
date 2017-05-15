import java.util.ArrayList;
/**
 * reprezentace grafu pomoci seznamu sousednoti
 * @author Jokertwo
 *
 */


public class Seznam_Sousednosti {
	Vrchol[] vrchP;
	ArrayList<String> pole = new ArrayList<String>();
	Soused dalsi;
	
	int pocet = 0;
	int casObjeveni = 0;
	int vrcholuCelkem;
	
	
	//kontruktor
	public Seznam_Sousednosti(int vrcholuCelkem) {
		this.vrcholuCelkem = vrcholuCelkem;
		this.vrchP = new Vrchol[vrcholuCelkem];
	}
	
	/**
	 * vraci index vrcholu ulozeneho v poli
	 * @param klic String
	 * @return integer reprezentujici index v poli
	 */
	int index(String klic){
		int pom = -1;
		for(int i = 0;i< vrcholuCelkem;i++){
			if(vrchP[i].klic.equals(klic))
			pom  = i;
		}
		return pom;
	}
	
	
	int indexS(Vrchol vrch,int k){
		int index = -1;
		Soused s  = vrch.soused;
		int pom = 1;
		while(pom<k){
			if(vrch.soused==null){
				return -1;
			}
			s = s.dalsi;
			pom++;
			
		}
		index = index(s.klic);
		return index;
	}
	
	/**
	 * vlozi novy vrchol
	 * @param vrchol
	 */
	void vlozVrchol(String vrchol){
		Vrchol pom = new Vrchol(vrchol,'B');
		vrchP[pocet++] = pom;
	}

	/**
	 * prida neorientovanou hranu
	 * @param start String odkud hrana zacina
	 * @param cil	String kde hrana konci
	 */
	void neoriHrana(String start,String cil){
		int i = 0;
		   Soused s = null;
		   
		   i = index(cil);
		   if(i == -1){
			   return;
		   }
		   s = new Soused(start);
		   s.dalsi = vrchP[i].soused;
		   vrchP[i].soused = s;
		   vrchP[i].pocetSousedu = vrchP[i].pocetSousedu + 1;
		   
		   i = index(start);
		   if(i == -1){
			   return;
		   }
		   s = new Soused(cil);
		   s.dalsi = vrchP[i].soused;
		   vrchP[i].soused = s;
		   vrchP[i].pocetSousedu = vrchP[i].pocetSousedu + 1;
	}
	
	/**
	 * prida orientovanou hranu
	 * @param start String kde hrana zacina
	 * @param cil	String kde hrana konci
	 */
	void orientHrana(String start,String cil){
		int i;
		  Soused s = null;
		   
		   i = index(start);
		   if(i == -1){
			   return;
		   }
		   s = new Soused(cil);
		   s.dalsi = vrchP[i].soused;
		   vrchP[i].soused = s;
		   vrchP[i].pocetSousedu = vrchP[i].pocetSousedu + 1;
	}
	/**
	 * prohledavani do sirky
	 * @param start String odkud se ma zacit prohledavat
	 */
	void BFS(String start){
		Fronta f = new Fronta(vrcholuCelkem);
		int indexA  = index(start);
		
		vrchP[indexA].barva = 'S';
		vrchP[indexA].vzdalenost = 0;
		
		f.vloz(start);
		
		
		while(!f.jePrazdna()){
			String b = f.vyber();
			int indexB = index(b);
			for(int i = 1; i <= vrchP[indexB].pocetSousedu;i++){
				int j = indexS(vrchP[indexB], i);
				if(vrchP[j].barva == 'B'){
					vrchP[j].barva = 'S';
					vrchP[j].vzdalenost = vrchP[indexB].vzdalenost + 1;
					vrchP[j].predchudce = b;
					f.vloz(vrchP[j].klic);
				}
			}
			vrchP[indexB].barva = 'C';
			pole.add(vrchP[indexB].klic);
			
		}
	}
	/**
	 * prohledavani do hloubky
	 * @param start String odkud se ma zacit prohledavat
	 */
	void DFS(String start){
		casObjeveni = 0;
		DFSR(index(start));
		
	}
	void DFSR(int s){
		vrchP[s].barva = 'S';
		casObjeveni = casObjeveni +1;;
		vrchP[s].objeven = casObjeveni;
		
		for(int i = 1;i<= vrchP[s].pocetSousedu;i++){
			int j = indexS(vrchP[s],i);
			if(vrchP[j].barva == 'B'){
				vrchP[j].predchudce = vrchP[s].klic;
				DFSR(j);
			}
			
		}
		vrchP[s].barva = 'C';
		vrchP[s].dokoncen = casObjeveni = casObjeveni++;
		pole.add(vrchP[s].klic);
		
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
