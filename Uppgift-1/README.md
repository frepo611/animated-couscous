# Världsbanken

## Funktionalitet

I banken ska man kunna:

- hämta information om bankens kunder
- lägga till en ny kund med ett unikt personnummer
- ändra en kunds namn (personnummer ska inte kunna ändras)
- ta bort en befintlig kund, eventuellt befintliga konton avslutas
- skapa sparkonton till en befintlig kund, ett unikt kontonummer genereras (första kontot får nummer 1001, nästa 1002 och så vidare)

För en viss kund ska man kunna utföra följande:

- se information om vald kund inklusive alla konton
- sätta in pengar på ett konto
- ta ut pengar från kontot (men bara om saldot täcker uttagsbeloppet)
- avsluta konto

## Klassdesign

### Account

Börja med att implementera klassen `Account` som ska hantera följande information:

- saldo
- räntesats
- kontonummer
- kontotyp

Notera att man i ett verkligt banksystem aldrig får lagra belopp eller räntesats som ett flyttal då man förr eller senare kommer att få avrundningsfel beroende på att man inte kan lagra alla decimaltal i datatyperna float eller double. Man kan istället använda en klass som heter BigDecimal. För betyget G kommer det att vara tillåtet att använda float eller double i uppgifterna medan man om man eftersträvar VG ska använda BigDecimal (eller alternativ lösning där flyttal sparas exakt). Läs gärna [mer](https://javarevisited.blogspot.com/2012/02/java-mistake-1-using-float-and-double.html).

Kontonummer ska vara unika för hela banken, inte bara för en enskild kund (se Big Java Late Objects på s. 400 för tips på lösning). Det första kontot som skapas får kontonummer 1001, nästa får kontonummer 1002 och så vidare. Kontonummer återanvänds inte, om ett konto tas bort så kommer inget nytt konto att få dess kontonummer.

Man ska till exempel kunna utföra transaktioner (insättning/uttag), hämta kontonummer, beräkna ränta (saldo * räntesats/100) samt hämta presentationsinformation om kontot: (kontonummer saldo kontotyp räntesats).

### Customer

Klassen `Customer` ska hantera följande information:

- kundens för- och efternamn
- personnummer.
- Kunden kan också hantera sina konton.

Man ska kunna ändra kundens namn (personnummer ska inte kunna ändras) samt hämta information om kunden (personnummer förnamn efternamn).

Hur du hanterar kopplingen mellan kund och konto är upp till dig. Det finns flera alternativ, alternativ 1 är det som rekommenderas och beskrivs nedan men man får använda sig av alternativ 2 eller något tredje alternativ om man anser sig ha kunskap att genomföra det alternativet på ett korrekt sätt. För VG på uppgiften krävs att man har funderat lite extra på denna del och motiverar sitt val i rapporten.

1. Man lägger in lista med konton i klassen `Customer`. `Customer`-klassen håller själv reda på sina konton och är den som ska utföra operationer på sina konton.  
2. Man har listan med konton i klassen `BankLogic`. Du måste då på något sätt koppla ihop ett konto med en kund.

### BankLogic

Klassen `BankLogic` ska innehålla en lista med alla inlagda kunder. Klassen ska innehålla ett antal publika metoder som hanterar kunder och konton. Du kommer troligtvis att skapa ett antal hjälpmetoder (privata metoder) men de publika metoderna finns definierade nedan.

    public ArrayList<String> getAllCustomers()

Returnerar en `ArrayList<String>` som innehåller en presentation av bankens alla kunder på följande sätt:

    [8505221898 Karl Karlsson, 6911258876 Pelle Persson, 7505121231 Lotta Larsson]

Finns inga kunder returneras en `ArrayList<String>` som är tom:

    []

Testklassen förutsätter att ordningen på kunder är samma som den ordning som kunderna lades in i, så tänk på det när du väljer hur du vill spara kunder.

Om vi tittar på vad den `ArrayList<String>` som ska returnerar innehåller är det:

| index 0                     | index 1                   | index 2                   |
|-----------------------------|---------------------------|---------------------------|
| "8505221898 Kalle Karlsson" |"6911258876 Pelle Persson" | "7505121231 Lotta Larsson"|

Notera att hakparenteser och komma mellan objekten skrivs ut automatiskt när vi skriver ut en `ArrayList`.

    public boolean createCustomer(String name, String surname, String pNo)

Skapar upp en ny kund utifrån de argument som skickas in till metoden.
Personnummer måste vara unikt, så om en kund redan finns med det personnumret så ska en ny kund inte skapas.
Returnerar `true` om kund skapades annars returneras `false`.

    public ArrayList<String> getCustomer(String pNo)

Returnerar en `ArrayList<String>` som innehåller informationen om kunden inklusive dennes konton.
Returnerar null om kunden inte fanns.
Första platsen i listan är reserverad för kundens personnummer och namn sedan följer informationen om kundens konton (kontonummer saldo kr kontotyp räntesats %)
Exempel på hur det som returneras ska se ut:

    [7505121231 Lotta Larsson, 1004 0,00 kr Sparkonto 1,2 %, 1005 0,00 kr Sparkonto 1,2 %]

| index 0                    | index 1                        | index 2                        |
|----------------------------|--------------------------------|--------------------------------|
| "7505121231 Lotta Larsson" | "1004 0,00 kr Sparkonto 1,2 %" | "1005 0,00 kr Sparkonto 1,2 %" |

För att testprogrammet ska fungera så behöver du formatera saldo och procenten när man hämtar information om kontot, notera att nedan kod även lägger till valutan "kr". För att formatera belopp kan vi använda:

    String balanceStr = NumberFormat.getCurrencyInstance().format(balance);

Notera att formateringen är beroende av vilket språk som används av JVM, jag förväntar mig svensk formatering så om du använder ett annat språk så kan du i koden byta till svenska:

    String balanceStr = NumberFormat.getCurrencyInstance(new Locale("sv","SE")).format(balance);

På liknande sätt formaterar vi räntan, men med `getPercentInstance` istället för `getCurrencyInstance`. För att få med decimalen så får vi göra på följande sätt:

    NumberFormat percentFormat = NumberFormat.getPercentInstance(new Locale("sv","SE"));
    percentFormat.setMaximumFractionDigits(1); // Anger att vi vill ha max 1 decimal
    String percentStr = percentFormat.format(interest/100);
Den multiplicerar värdet som ska formateras med 100 och lägger till enheten "%".

    public boolean changeCustomerName(String name, String surname, String pNo)

Byter namn på vald kund, argumentet `pNo` identifierar den kund som ska få nytt namn.
Returnerar true om namnet ändrades annars returnerar false (alltså om kunden inte fanns eller om båda namn attributen är tomma).
Skickas en tom sträng som name ska gamla förnamnet behållas och om en tom sträng skickas in som surname ska efternamnet behållas.

    public int createSavingsAccount(String pNo)

Skapar ett konto till kund med personnummer `pNo`
Kontonummer ska vara unika för hela banken, inte bara för en enskild kund (se Big Java Late Objects på s. 400 för tips på lösning).
Returnerar kontonumret som det skapade kontot fick
Alternativt returneras –1 om inget konto skapades (kunden fanns inte)

    public String getAccount(String pNo, int accountId)

Returnerar en String som innehåller presentation av kontot med kontonummer accountId som tillhör kunden med personnummer `pNo`.
Det som returneras ska vara: kontonummer saldo kr kontotyp räntesats %
Returnerar null om konto inte finns eller om kontot inte tillhör kunden

    public boolean deposit(String pNo, int accountId, int amount)

Gör en insättning på konto med kontonummer `accountId` som tillhör kunden med personnummer `pNo`.
Insättning av belopp som är 0 eller mindre utförs inte.
Notera att vi begränsar oss i detta läge att sätta in belopp i hela kronor
Returnerar true om det gick bra annars false

    public boolean withdraw(String pNo, int accountId, int amount)

Gör ett uttag på konto med kontonummer `accountId` som tillhör kunden med personnummer `pNo`.
Uttaget genomförs endast om saldot täcker uttaget (saldot får inte bli mindre än 0)
Uttag av belopp som är 0 eller mindre utförs inte.
Notera att vi begränsar oss i detta läge att sätta in belopp i hela kronor
Returnerar true om det gick bra annars false

    public String closeAccount(String pNo, int accountId)

Avslutar ett konto med kontonummer accountId som tillhör kunden med personnummer pNo. När man avslutar ett konto skall räntan beräknas som saldo*räntesats/100.
OBS! Enda gången ränta läggs på är när kontot tas bort eftersom årsskiften inte behöver hanteras i denna version av systemet.
Presentation av kontot ska returneras men med räntan i kronor istället för räntesatsen (kontonummer saldo kr kontotyp ränta kr)
Returnerar null om inget konto togs bort.
Det som returneras ska se ut som följer:

     1001 1 000,00 kr Sparkonto 12,00 kr

    public ArrayList<String> deleteCustomer(String pNo)

Tar bort en kund med personnummer pNo ur banken, alla kundens eventuella konton tas också bort och resultatet returneras.
Returnerar null om ingen kund togs bort.

Listan som returneras ska innehålla information om kund på första platsen i ArrayList (personnummer förnamn efternamn) sedan följer de konton som togs bort (kontonummer saldo kr kontotyp ränta kr). Notera att ränta i kronor presenteras istället för räntesatsen när ett konto tas bort. Ränta i kronor beräknas som saldo*räntesats/100 (ränta behöver enbart beräknas vid borttagning av konton då banken i denna version inte stödjer årsskiften).
Det som returneras ska se ut som följer:

    [7505121231 Lotta Larsson, 1004 0,00 kr Sparkonto 0,00 kr, 1005 700,00 kr Sparkonto 8,40 kr]

| index 0                    | index 1                          | index 2                            |
|----------------------------|----------------------------------|------------------------------------|
| "7505121231 Lotta Larsson" | "1004 0,00 kr Sparkonto 0,00 kr" | "1005 700,00 kr Sparkonto 8,40 kr" |
## Betyg

För godkänt (G) på denna inlämningsuppgift krävs att:

Alla tester får PASS när man kör programmet TestBank.java.
Alla medlemsvariabler i klasserna är satta som private.
Inga onödiga medlemsvariabler finns i klasserna.
Lösningen följer de objektorienterade principerna.
Källkodsfiler är kommenterade för att underlätta för handledaren som ska sätta sig in i din lösning.
Alla filer innehåller ditt förnamn, efternamn och ditt användarnamn.

För väl godkänt (VG) på denna uppgift krävs dessutom att:
Lösningen är genomtänkt och väl objektorienterad.
Du har bland annat tänkt igenom inkapsling, ansvarsområden och relationer mellan klasserna.
Inga listor med objekt returneras eftersom den som hämtar listan kan förändra innehållet i den vilket förlorar inkapsling.
Du använder lämpliga hjälpmetoder (privata metoder) för att återanvända kod.
Flyttal ska lagras exakt, använd förslagsvis BigDecimal.
Du skriver en utförlig rapport där du motiverar dina val och reflekterar över din lösning så det framgår att du har en god förståelse av det du har gjort.
Din källkoden följer kodningsregler och standard för dokumentation och kommentering.

## Inlämning

Vi vill som tidigare nämnts i denna kurs att du lägger de klasser du skapat i ett paket (package) som heter qwerty0 (byt ut qwerty0 till ditt unika ltu-användarnamn). Läs mer på sidan: Package.

Innan inlämning så kontrollerar du att din kod är kommenterad och är lätt att läsa. Kontrollera även att dina klasser fungerar med TestBank.java.

Glöm inte att både namn och ltu-id måste finnas med i ALLA filer som lämnas in, lägg dem längst upp i en klasskommentar. Läs mer på sidan: Kodningsregler.

Viktigt att tänka på är att du aldrig ska använda å, ä eller ö i filnamn/klassnamn/metodnamn/variabelnamn och du ska använda teckenkodning UTF-8.

När du är klar med uppgiften så packar du ihop din src-mapp till en zip-fil. I Windows högerklicka på mappen och välj Send to/Compressed (zipped) folder. Döp din zip-fil till lab1_qwerty0 (där qwerty0 byts ut till ditt unika ltu-användarnamn).

Denna zip-fil är den som du lämnar in genom att klicka på knappen "Skicka uppgift" (här uppe till höger).

För VG krävs att du lämnar in en rapport, denna rapport ska lämnas in i Canvas tillsammans med zip-filen, du ska alltså lämna in både en zip-fil och en pdf-fil för att uppgiften ska ha chans att bedömas som VG. Notera att en rapport för VG måste vara väl genomarbetad för att den ska bedömas. Rapporten ska vara minst 5000 tecken utan blanksteg och exklusive försättssida, innehållsförteckning och referenser. Se följande exempel på hur rapporten kan utformas.

OBS! Du ska aldrig ha din brödtext i kursiv stil, att jag använder kursiv stil är för att du lätt ska kunna se vad som ska tas bort ur rapporten innan du lämnar in:

OBS, något klassdiagram behöver du inte bifoga i inlämningsuppgift 1.
