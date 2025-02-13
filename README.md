# Online Survey System

## Rövid leírás
Az Online Survey System egy Java alapú alkalmazás, amely lehetővé teszi különböző típusú kérdőívek létrehozását, szerkesztését és kitöltését. A rendszer támogatja az egy- és többválasztós kérdéseket, valamint skálázott és igen/nem típusú kérdéseket is. Cél, hogy a 
program mindenfajta kérdés és választípusokat kezelni tudjon. Cél továbbá, hogy ezek egyszerűen bővíthetők legyenek amennyiben új típus kerül a képbe.

## Fő funkciók
- Kérdések és válaszok kezelése (Yes/No, Scale, PickMore típusokkal).
- Felhasználói válaszok feldolgozása, kiértékelése és visszaadása.
- Dinamikus kérdőív-szerkesztési lehetőség.
- Feltételes logika (pl. egy kérdés csak bizonyos válasz után jelenik meg).

## Fájlstruktúra
- `src/org/example`: Az összes osztály és kód.
- `SurveySystem.java`: A fő programfájl.
- `QuestionAnswerManager.java`: A válaszok feldolgozásáért felelős osztály.
- Main osztály: felel a programm futtatásáért, a felhasználói inputért.
- Question osztály: Ősosztály, legikább azért felel, hogy egy kérdés jellemző paramétereit tartalmazza.
- Question alosztályok: feladatuk a kérdések különböző típusainak csoportosítása, és azok tipusonként való kezelése.
- Answer osztály: Ősosztály, a válaszok alapvető keretrendszerét határozza meg.
- Answer alosztályok: A különböző tipusú válaszokat hivatott csoportosítani, és azok tartalmát, alapvető keretrendszerét meghatározni.
- Survey ősosztály: feladata a kérdőívek alapvető kerendrendszerének meghatározása
- Survey alosztályok: az eggyes kérdőívek tartalmi és fromai kereteinek meghatározása
- SurveyCreator: Ez az osztály felelős az új kerdőívek létrehozásáért
- ErrorHandling: egyenlőre üres osztály, szükség esetén a felmerülő hibák kezelésére létrehozott osztály
- 

## Használat
1. Klónozd a repót:  
   ```bash
   git clone https://github.com/GentelFatih/OnlineSurveySystem.git
