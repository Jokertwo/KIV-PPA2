# KIV-PPA2
<h1>Semestrální práce z předmětu PPA2 (2016)</h1>
 
<h3>Zadání samostatné práce z PPA2</h3>
Naprogramujte v Javě prohledávání grafu (tj. orientovaného i neorientovaného) 
do hloubky (DFS) a do šířky (BFS) pro jeho reprezentace seznamem sousednosti (S) a maticí sousednosti (M).
Úkolem je pouze průchod grafu ze zadaného vrcholu s výpisem objevených vrcholů. Prohledávání tedy nepokračuje,
i když nebyly ze zadaného vrcholu objeveny všechny vrcholy grafu!  Doporučená struktura programu Vytvořte jediného
klienta (obsahujícího metodu main()) a čtyři samostatné soubory (*.java) pro: 

▪ reprezentaci grafu seznamem sousednosti a prohledáváním do šířky (SBFS)<br>
▪ reprezentaci grafu seznamem sousednosti a prohledáváním do hloubky (SDFS) <br>
▪ reprezentaci grafu maticí sousednosti a prohledáváním do šířky (MBFS)<br>
▪ reprezentaci grafu maticí sousednosti a prohledáváním do hloubky (MDFS) <br>

Každý soubor by měl obsahovat třídu Vrchol (reprezentace vrcholu), třídu Graf (reprezentace grafu), 
metody pro vytvoření grafu a průchod grafem. Dále je nutno implementovat metody umožňující volitelný 
vstup dat z klávesnice nebo z textového souboru a volitelný výstup dat na obrazovku či do textového souboru.
Přepokládejte vstup zadání grafu v následující závazné struktuře (zcela shodné pro vstup z klávesnice i vstup ze souboru).
Nejprve bude na samostatné řádce zadána varianta implementace (SBFS, SDFS, MBFS, MDFS), na další řádce pak hodnota v(0<v<20),
reprezentující počet vrcholů grafu. Následovat bude v řádek s názvy vrcholů (názvem může být nezáporné číslo,
písmeno anglické abecedy, řetězec tvořený znaky anglické abecedy - včetně mezer). Na další řádce je zadána hodnota h(0≤h),
která reprezentuje počet hran. Na dalších h řádkách budou zadány jednotlivé hrany (každá na samostatné řádce).
Pro neorientovanou hranu použijte znak '-', pro orientovanou hranu znak  '>' (směr orientace). 
Na poslední řádce bude zadán název vrcholu, ze kterého se bude graf prohledávat. 

Např.: SBFS<br>
       4<br>
       A<br>
       B<br>
       C<br>
       D<br>
       5<br>
       A-B<br>
       C-A<br>
       D>A<br>
       B-C<br>
       D>C<br>
       B <br>

Tvar výstupu je rovněž závazný. První tři velká písmena udávají zkratku způsobu prohledávání,
následovanou v kulatých závorkách označením zadaného vrcholu, ze kterého se graf prochází, odděleným 
znakem dvojtečka ':' po němž následuje výpis postupně objevených vrcholů, ve tvaru "mezera" a označení
vrcholu oddělené od následujících vrcholů znakem čárka ','. Za posledním vrcholem čárka nesmí být!  

Např.:    BFS(B): B, C, A   či     DFS(D): D, C, B, A

 
Výstup výsledků bude v zadaném tvaru výstupu proveden buď na obrazovku, nebo do textového souboru 
(viz dále - Ovládání programu). Ovládání programu  Program bude možné spouštět se zadáním parametru, 
nebo bez zadání parametru programu.  Bude-li zadán parametr, bude představovat název vstupního textového souboru, 
který obsahuje vstupní data v závazné struktuře. V tomto případě bude proveden výstup požadovaných výsledků pouze
do textového souboru, který bude mít závazný název vysledky.txt (podmínka úspěšné validace).  Nebude-li zadán parametr,
budou všechna vstupní data v závazné struktuře načtena z klávesnice a výstup výsledků proveden pouze na obrazovku.
Další pokyny Program vytvářejte strukturovaně s použitím metod. Všechny metody i jednotlivé třídy důsledně okomentujte
Javadoc komentáři, ve kterých bude uveden @author. Nebude vyžadována žádná další dokumentace. 

Odevzdání a validace Samostatnou práci odevzdejte na portál do bloku Samostatná práce vložením pouze jediného zdrojového souboru,
jelikož validátor nedokáže zpracovat více než jeden soubor. To znamená, že soubory všech tříd je nutno spojit do jednoho 
souboru s názvem Ppa2_SP.java, který je závazný z důvodu automatické kontroly (validace). V tomto souboru, který tak obsahuje 
více tříd, může být označena specifikátorem public pouze třída obsahující metodu main(), tj. soubor s klientem,
který je pojmenován dle stanovených pravidel (Ppa2_SP.java). V případě použití Eclipsu nezapomeňte též před odevzdáním
odstranit package. Můžete předpokládat, že vstupní soubor s daty bude zadán na validátoru správně. Obhájení 
Samostatná práce bude ohodnocena cvičícím (přidělení bodů) po jejím předvedení v době cvičení. Předpokladem
pro předvedení je její předchozí úspěšná validace na portálu. Student musí zapsaným algoritmům rozumět.
Způsob hodnocení SP naleznete na portálu (viz zadání na předposlední cvičení).  
Poznámka:  Příklad datového vstupu a výstupu je uveden pro snazší pochopení zadání, další zkušební
data a informace naleznete na portálu na stránce Samostatná práce/Materiály ke stažení. Validátor 
však používá ještě jiná vstupní data a kontroluje všechny možné (tj., je-li jich víc) varianty řešení.  
Upozornění: Výstupem algoritmů bude pouze průchod grafu ze zadaného vrcholu s výpisem objevených vrcholů 
a žádné jiné další průchody, cesty odněkud někam, minimální cesty, … atd. Toto bude náplní online testu.
V případě zjištěného nerespektování tohoto požadavku bude takovéto jednání považováno za pokus o podvod,
a tudíž nebudou v případě úspěšného splnění zadání online testu body přiznány! 
