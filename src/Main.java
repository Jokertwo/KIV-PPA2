import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;




public class Main {
	static Seznam_Sousednosti g1;
	static Seznam_Sousednosti g2;
	static Matice_Sousednosti g3;
	static Matice_Sousednosti g4;
	static int pocetVrcholu;
	static int pocetHran;
	
	
	
	static String a,b = null;
	static String pom;
	
	static String[] pole;
	
	static int rozhodni(String a){
		if(a.contains("SBFS"))
			return 1;
		
		if(a.contains("SDFS"))
			return 2;
		
		if(a.contains("MBFS"))
			return 3;
		if(a.contains("MDFS"))
			return 4;
		
		return -1;
	}
	
	
	
	/**
	 * zadani hodnot do grafu(vrcholu a hran)
	 * reprezentace grafu pomoci seznamu sousednosti
	 * prohledavani grafu pomoci metody BFS
	 * @param g1
	 * @throws IOException
	 */
	static void sbfs(Seznam_Sousednosti g1,BufferedReader cti) throws IOException{
		
		for(int i = 0; i < pocetVrcholu;i++){
			g1.vlozVrchol(cti.readLine());
		}
		
		pocetHran = (new Integer(cti.readLine())).intValue();
		
		
		for(int i = 0; i < pocetHran; i++){
			pom = cti.readLine();
			
			if(pom.contains("-")){
				pole = pom.split("-");
				a = pole[0];
				b = pole[1];
				
				g1.neoriHrana(a, b);
			}
			
			if(pom.contains(">")){
				pole = pom.split(">");
				a = pole[0];
				b = pole[1];
				
				g1.orientHrana(a,b);
			}
			
			if(pom.contains("<")){
				pole = pom.split("<");
				a = pole[0];
				b = pole[1];
				
				g1.orientHrana(b, a);
			}
			
		}
		String start = cti.readLine();
		g1.BFS(start);
	}
	/**
	 * zadani hodnot a vytvoreni grafu pomoci seynamu sousednosti
	 * prohledavani pomoci metody DFS
	 * @param g2
	 * @throws IOException
	 */
	static void sdfs(Seznam_Sousednosti g2,BufferedReader cti) throws IOException{
		for(int i = 0;i < pocetVrcholu;i++){
			pom = cti.readLine();
			g2.vlozVrchol(pom);
		}
		
		pocetHran = (new Integer(cti.readLine())).intValue();
		
		for(int i = 0; i < pocetHran; i++){
			pom = cti.readLine();
			
			if(pom.contains("-")){
				pole = pom.split("-");
				g2.neoriHrana(pole[0], pole[1]);
			}
			if(pom.contains(">")){
				pole = pom.split(">");
				g2.orientHrana(pole[0], pole[1]);
			}
			if(pom.contains("<")){
				pole = pom.split("<");
				g2.orientHrana(pole[1], pole[0]);
			}
		}
		String start = cti.readLine();
		g2.DFS(start);
	}
	/**
	 * zadani hodnot do grafu 
	 * repreyentacce grafu pomoci matice sousednosti
	 * prohledani grafu pomoci metody BFS
	 * @param g3
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	static void mbfs(Matice_Sousednosti g3,BufferedReader cti) throws NumberFormatException, IOException{
		
		for(int i = 1;i <= pocetVrcholu;i++){
			g3.novyVrchol(cti.readLine());
		}
		
		pocetHran = (new Integer(cti.readLine())).intValue();
		
		
		
		for(int i = 0; i < pocetHran; i++){
			pom = cti.readLine();
			
			
			if(pom.contains("-")){
				pole = pom.split("-");
				g3.neoHrana(pole[0], pole[1]);
			}
			
			if(pom.contains(">")){
				pole = pom.split(">");
				g3.orHrana(pole[0], pole[1]);
			}
			
			if(pom.contains("<")){
				pole = pom.split("<");
				g3.orHrana(pole[1], pole[0]);
			}
			
			
		}
		String start = cti.readLine();
		g3.BFS(start);
	}
	/**
	 * zadani hodnot do grafu(hran a vrcholu)
	 * reprezentacce grafu pomoci matice sousednosti
	 * prohledani grafu pomoci metody DFS
	 * @param g4
	 * @throws IOException
	 */
	static void mdfs(Matice_Sousednosti g4,BufferedReader cti) throws IOException{
		for(int i = 1;i <= pocetVrcholu;i++){
			g4.novyVrchol(cti.readLine());
		}
		pocetHran = (new Integer(cti.readLine())).intValue();
		
		
		for(int i = 1; i <= pocetHran; i++){
			pom = cti.readLine();
			
			if(pom.contains("-")){
				pole = pom.split("-");
				g4.neoHrana(pole[0], pole[1]);
			}
			
			if(pom.contains(">")){
				pole = pom.split(">");
				g4.orHrana(pole[0], pole[1]);
			}
			
			if(pom.contains("<")){
				pole = pom.split("<");
				g4.orHrana(pole[1], pole[0]);
			}
		}
		String start = cti.readLine();
		g4.DFS(start);
	}
	static void tisk(String string){
		System.out.print(string);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
	String volba;
	
	//pokud je soubor spusten s argumentem
		if(args.length > 0){
		
		//otevre soubor ktery je zadan jako parametr
		BufferedReader buf = new BufferedReader(
						new FileReader(args[0]));
		
		PrintWriter pri = new PrintWriter	
						 (new BufferedWriter
						 (new FileWriter("vysledky.txt")));
		//precte prvni radku souboru
		volba = buf.readLine();
		
		//rozhodne ktery algoritmus se ma použít
		int roz = rozhodni(volba);
		
		//precte dalsi radku souboru kde je ulozena informace o poctu vrcholu
		pocetVrcholu = (new Integer(buf.readLine())).intValue();
		
		
		
		if(roz == 1){		
			g1 = new Seznam_Sousednosti(pocetVrcholu);
				sbfs(g1,buf);
				pri.print(g1.vytiskniBFS());
				
		}
		if(roz == 2){
				
			g2 = new Seznam_Sousednosti(pocetVrcholu);
					sdfs(g2,buf);
					pri.println(g2.vytiskniDFS());
					
						
		}
		if(roz == 3){
			
			g3 = new Matice_Sousednosti(pocetVrcholu);
				mbfs(g3,buf);
				pri.print(g3.vytiskniBFS());
				
				
				
		}
		if(roz == 4){
			g4 = new Matice_Sousednosti(pocetVrcholu);
				mdfs(g4,buf);
				pri.print(g4.vytiskniDFS());
				}
			
		//uzavre soubor pro zapis
		pri.close();
	}
		else{
			BufferedReader cti = new BufferedReader(new InputStreamReader(System.in));
			volba = cti.readLine();
			
			//PROMENA  ktere urcuje ktera metoda se pouzije
			int roz = rozhodni(volba);
			
			pocetVrcholu = (new Integer(cti.readLine())).intValue();
			
			
			
			if(roz == 1){		
				g1 = new Seznam_Sousednosti(pocetVrcholu);
					sbfs(g1,cti);
					tisk(g1.vytiskniBFS());
					
			}
			if(roz == 2){
					
				g2 = new  Seznam_Sousednosti(pocetVrcholu);
						sdfs(g2,cti);
						tisk(g2.vytiskniDFS());
						
							
			}
			if(roz == 3){
				
				g3 = new Matice_Sousednosti(pocetVrcholu);
					mbfs(g3,cti);
					tisk(g3.vytiskniBFS());
					
					
					
			}
			if(roz == 4){
				g4 = new Matice_Sousednosti(pocetVrcholu);
					mdfs(g4,cti);
					tisk(g4.vytiskniDFS());
					}
				
		}
	}
}
