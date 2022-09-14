# Övningsuppgift - Definiera egna klasser

1. Skapa en klass *Rectangle* med attributen *length* och *width*. Attributen length och width har värdet 1 om de inte explicit anges. Klassen har metoder som beräknar omkrets (circumference) och area. Den har också set- och get-metoder för båda attributen. Set-metoderna ska säkerställa att attributen är större än 0 och mindre än 20. Skriv ett program som testar klassen.

2. Skapa en klass SavingsAccount. Använd en klassvariabel rate för att lagra årsräntesatsen. Denna är gemensam för alla kontohavare. Varje instans innehåller en privat variabel balance som anger saldot på kontot. Skapa en metod calculateMonthlyInterest som beräknar räntan för en månad genom att multiplicera saldot med årsräntesatsen dividerat med 12. Detta belopp ska läggas till balance. Skapa en klassmetod changeRate som tilldelar rate ett nytt värde. Skriv ett program som testar klassen där två objekt, saving1 och saving2, skapas. Kontona har till en början 2.000 SEK resp. 3.000 SEK i saldo. Sätt rate till 1%, beräkna nästa månads ränta och skriv ut saldot för båda kontona.

3. Skriv ett program i Java som hanterar ett medlemsregister. Inför en klass Medlem med attribut för medlemsnummer, namn, gatuadress, postnummer, ort och telefonnummer. Lagra objekten i en ArrayList. Låt användaren via en enkel meny välja mellan att lägga till, ta bort och söka medlemmar. Inför också ett menyval som skriver ut alla medlemmar på skärmen.

4. Skapa klassen SetOfIntegers som representerar en mängd. Mängden består av heltal i intervallet 0-100 och vilka tal som ingår i mängden hålls reda på av ett boolean-fält (eng. array) där a[i] är sant om heltalet i ingår i mängden respektive falskt om heltalet i inte ingår i mängden. Klassen har en konstruktor utan argument som initierar fältet till tomma mängden, dvs. en mängd vars fältrepresentation har alla värden satta till false.

    Skapa följande metoder:

    - union skapar ett nytt objekt av typen SetOfIntegers där elementen tilldelas värdet true om detta element är true i någon eller båda av de befintliga objekten. Annars tilldelas värdet false.
    - intersection (skärning) som skapar ett nytt objekt av typen SetOfIntegers där elementen tilldelas värdet false om detta element är false i någon eller båda av de befintliga objekten. Annars tilldelas värdet true.
    - addElement som lägger till ett nytt heltal k till mängden genom att sätta a[k] till true
    - removeElement som tar bort ett heltal m från mängden genom att sätta a[m] till false
    - print som skriver ut en sorterad lista av de element som ingår i mängden på skärmen med mellanslag emellan talen. Låt metoden skriva ut ’-’ för att beteckna tomma mängden.
    - equals som avgör om två objekt är lika.

    Skriv ett program som testar klassen genom att instansiera några objekt och testa alla metoder.

5. Vad skiljer instansvariabler från klassvariabler?
6. Vilka variabler och konstanter har klassmetoder resp. instansmetoder åtkomst till?
7. Vilka metoder har klassmetoder resp. instansmetoder åtkomst till?
8. Skapa ett klassbibliotek (package) test där klassen SetOfIntegers som du skapat tidigare ingår. Skriv ett (från klassbiblioteket test) fristående program som skapar objekt av typen SetOfIntegers och testar metoderna i denna.
