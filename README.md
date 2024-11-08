# Documentazione
---
### Corriere: Setting
In questo gioco l'utente si trova nei panni di uno sfortunato corriere che dopo essersi avventuarato in una villa si trova rinchiuso e senza via d'uscita. Quindi il giocatore sarà portato ad esplorare la mappa risolvendo piccoli enigmi e trovando oggetti per proseguire.
### Tipologia
L'interazione utente - programma avviene principamlente tramite comandi inseriti nella barra adibita all'input utente, fornendo al giocatore una buona libertà di esplorazione e aiuti anche grazie a descrizioni o interazioni presenti nel gioco.
Oltre all'interazione puramente testuale è possibile trovare alcuni minigame/ "rompicapo" molto semplici ed intuitivi che prediligono un interazione grafica che solitamente predilige l'utilizzo del mouse con mecanismi di drag and drop.
### Struttura delle classi
Qui sotto è riportato il diagramma delle classi centrale e ala base del programma, che comprende i tasselli essenziali che compongono il programma alla radice.

![image](https://github.com/user-attachments/assets/caf67bba-38b3-48a8-a2d8-d4bb35b7d727)


### Specifica algebrica, list 
---
Tipi: int, elem, boolean, list

create() -> list
size(list) -> int
isEmpty(list) -> boolean
clear(list) -> list
contains(list, elem) -> boolean
add(list, elem) -> list
remove(list, elem) -> list

usaimo come costruttori create() e add(list, elem)

Dichiaro: i: int;  e',e: elem; l: list
size(create()) = 0
size(add(l,e)) = size(l) + 1
isEmpty(create()) = true
isEmpty(add(l,e)) = false
clear(create()) = create()
clear(add(l,e)) = create()
contains(create()) = false
contains(add(l,e),e') = if e = e' then true else false
remove(create(), e) = create()
remove(add(l, e), e') = if e' = e then l else add(l,e)




### Argomenti applicati
---
#### Thread
All'interno del progetto possiamo trovare 4 classi che implementano Runnable per permettere di istanziare tali calssi come Thread. Barriera e SpawnBlocchi sono collegate fra loro, infatti contestualizzate nel minigame "schiva blocchi", Barriera permette di avere delle entità che si muovono indipendentemente verso il blocco del giocatore quando il Thread viene fatto partire, in tal modo è possibile contemporaneamente sia generare nuovi blocchi con il Thread SpawnBlocchi che li posiziona sui "binari" sia far partire altri blocchi già posizionati e permettere al giocatore di muoversi in libertà.
Sempre collegato a "schiva blocchi" è presente un Thread per contare il tempo da usare come punteggio ma è semplicemente un contatore che part eassieme all'inizio del gioco.
L'ultimo utilizzo dei Thread è invece in ColoreSfondo dove da quando il programma è avviato avremo uno sfondo che si muove tra un colore di sfonfo all'altro mentre il player è libero di giocare.

#### Lambda Expression
Queste sono abbastanza presenti nel programma in quanto anche solo per la scelta dei comandi sulla stringa si usa un rule switch e quindi delle lambda expression. Ma esse risultano particolarmente comode quando vengono unite alle interfacce funzionali, infatti nel progetto viene spesso passata un implementazione di un interfaccia tramite lambda expression per permettere la comunicazione tra la classe che gestisce lo stato del gioco e i vari minigame che sono situati in classi separate o tra il Thread per cambiare lo sfondo e l'interfaccia principale.

#### File
Anche i file risultano molto importanti per il progetto, infatti a partire dallo statoIniziale che viene salvato su file, un intera categoria di comandi, carica e salva, è interamente improntata sull'utilizzo di file .dat per conservare lo stato del gioco nei file. Per fare ciò le classi interessate implementano Serializable che quindi permette poi di salvarle tramite ObjectOutputStrea. Questa parte di progetto è principalmente contenut ain IOFileStato che salva i file nella cartella "salvataggiGioco". (NOTA: è stato scelto di ricreare ogni volta il file stato iniziale in quanto è facilmente accessibile e modificabile).

#### Regex
Le regex all'interno del progetto sono utilizzate per due scopi diversi, nella classe GestioneComandiGioco si utilizza il metodo .match per permettere di "leggere" solo gli oggetti
che iniziano con foglio. Invece nella classe GiocoPassword vengono utilizzate le regex per vincolare l'utente a soddisfare varie condizioni nella creazione di una presunta password.

#### Classi genitore/ astratte
Per quanto riguarda l'ereditarietà delle classi all'interno del progetto è di particolare importanza in due casi; uno di questi è la relazione tra StatoGioco e GestioneComandiGioco. In tal modo lo StatoGioco è una classe che si limita a contenere tutto quelllo che caratterizza l'istanza dell gioco in quel momento senza modificarlo; è invece la classe figlia GestioneComandiGioco che può accedere alla classe genitore e modificarne lo stato seguendo i comandi ricevuti.
Questa relazione è anche usata nel pannello Pulsantiera che al suo interno istanzia varie porte logiche  che sono figlie di una classe PortaLogica (tranne la porta Not), questa accomuna tutte le porte per inserimento dell'input eil cambio di stato, lasciando poi alle singole porte da implementare la funzionalità logica per ognuna.

#### Generics
L'utilizzo di Generics compare solo una volta nel programma esattamente in GrafoOrientato che va ad usare una HashMap per permettere la creazione di un grafo contenente tipo<T> in cui ogni nodo è può avere quattro collegamentei (N,E,S,O) questo sarà poi usato per creare la mappa passando Ambiente al posto di <T>.

#### Swing
Per quanto riguarda invece le Swing come anticipato precedentemente il gioco non solo è di base istanziato su un JFrame ma va anche a spaziare su altri pannelli che permettono di cambiare l'interazione con componenti prendibili, tasti e slider.

###### Nota
Non sono stati utilizzati JDBC e socket/ rest
