# Feedback filoverførsel med TCP i Java

## Introduktion

I denne case skal I implementere en simpel filoverførselsapplikation ved hjælp af TCP sockets i Java. I arbejder i grupper og har til opgave at udvikle både en server og en klient, der kan kommunikere og overføre en fil fra serveren til klienten. Målet er at forstå grundlæggende socket programmering og filhåndtering over netværk.
Applikationens anvendelse
Forestil jer, at I arbejder for et softwarefirma ved navn "TechFile Solutions", som udvikler forskellige løsninger til filhåndtering og dataoverførsel for virksomheder. En af jeres kunder, en stor advokatvirksomhed, har behov for en pålidelig måde at overføre store dokumentfiler mellem deres kontorer, som er placeret i forskellige byer. Firmaet ønsker at sikre, at disse filer overføres hurtigt og sikkert mellem deres servere.

Anvendelse af applikationen:
Advokatvirksomheden ønsker at bruge en filoverførselsapplikation, som de kan integrere i deres eksisterende system. Applikationen skal kunne:
Serveren: afvikles på en central server i hovedkontoret, hvor alle filer, der skal overføres, er gemt.
Klienten: afvikles på fjernkontorer, der skal modtage filer fra hovedkontoret. Klienten skal kunne anmode om en specifik fil, modtage den og gemme den lokalt.
Pålidelighed: Anvendelsen af TCP sikrer, at filerne overføres pålideligt og uden fejl, hvilket er kritisk for advokatfirmaets følsomme data. (i virkeligheden kryptering)
Automatisering: Applikationen skal kunne integreres med deres eksisterende dokumenthåndteringssystem for at automatisere filoverførselsprocessen.

Lidt teori
TCP Protokollen
TCP (Transmission Control Protocol) er en forbindelse-orienteret protokol, der sikrer pålidelig og ordnet levering af data mellem en klient og en server. TCP etablerer en forbindelse, håndterer pakkelevering, og sikrer, at data ankommer i korrekt rækkefølge og uden fejl.
Nøglebegreber:
Forbindelse-orienteret: Før data kan sendes, skal en forbindelse oprettes mellem klient og server.
Pålidelighed: TCP sikrer, at alle data når frem til modtageren korrekt og i den rigtige rækkefølge.
Fejlkontrol: TCP bruger checksums og kvitteringer for at opdage og rette fejl i dataoverførslen.

Sockets i Java
Sockets er endepunkter for kommunikation mellem to maskiner. I Java bruger vi ServerSocket til at oprette en server, der kan lytte efter klientforbindelser, og Socket til at oprette en klient, der kan forbinde til en server.

Vigtige klasser:
ServerSocket: Bruges til at oprette en server, der lytter på en specifik port.
Socket: Bruges til at oprette en klient, der forbinder til en server.
InputStream og OutputStream: Bruges til at læse fra og skrive til sockets.

Filhåndtering i Java
Filhåndtering i Java involverer læsning fra og skrivning til filer ved hjælp af forskellige strømme (Streams). Når vi overfører filer over netværket, læser vi filen som en byte-strøm, sender den over en socket, og skriver den til en fil på modtagerens side.

Vigtige klasser:
FileInputStream og FileOutputStream: Bruges til at læse fra og skrive til filer som byte-strømme.
BufferedInputStream og BufferedOutputStream: Bruges til at forbedre ydeevnen ved at buffere dataene.

Jeres opgave  
I skal arbejde i grupper og implementere en filoverførselsapplikation bestående af en server og en klient. Serveren skal kunne sende en fil til klienten, og klienten skal modtage og gemme filen lokalt.

Krav:
Serveren skal lytte på en specifik port og vente på klientforbindelser.
Når en klient forbinder, skal serveren sende en fil til klienten.
Klienten skal modtage filen fra serveren og gemme den lokalt.
Forbindelsen skal lukkes, når filoverførslen er fuldført.

Implementering  
Serveren skal lytte på en specifik port og sende en fil til klienten, når denne forbinder.
Klienten skal forbinde til serveren og modtage filen, som derefter gemmes lokalt.
Tips og tricks

Sørg for at inkludere passende fejlhåndtering for at håndtere I/O fejl og netværksproblemer.
Brug en passende bufferstørrelse til at læse og skrive data. En buffer på 1024 bytes (1 KB) er et godt udgangspunkt.
Test med forskellige filstørrelser for at sikre, at løsningen fungerer korrekt under forskellige betingelser.
Arbejd sammen som en gruppe og del opgaverne for at sikre, at alle bidrager til løsningen.
Overvej at implementere grundlæggende sikkerhedsforanstaltninger, såsom at validere filstier for at forhindre uautoriseret adgang til filsystemet.
