# Zarządzanie Paletami

Zarządzanie Paletami to prosta aplikacja napisana w języku Java, służąca do kalkulacji ilości palet, jaka zmieści się do odpowiednich naczep. Aplikacja jest skierowana do osób oraz firm związanych z branżą logistyczną, transportową i magazynową, które potrzebują prostego narzędzia do optymalizacji załadunku naczep oraz kalkulacji ilości palet.

## Funkcjonalność
### 1. Dodawanie palet
Użytkownik wprowadza wymiary (długość, szerokość, wysokość), wagę oraz ilość palet, a następnie zatwierdza przyciskiem **"dodaj"**. Dane zostają dodane do tabeli, a pola formularza są czyszczone. W przypadku błędnych danych pojawia się komunikat o błędzie.

### 2. Wyświetlanie palet w tabeli
Tabela dynamicznie aktualizuje się po dodaniu nowych palet. Kolumny tabeli są powiązane z właściwościami obiektu `Pallet`, dzięki czemu dane są automatycznie wyświetlane.

### 3. Analiza załadunku palet
Po dodaniu palet użytkownik może kliknąć **"Oblicz"**, aby sprawdzić, czy naczepy pomieszczą ładunek.

### 4. Usuwanie palet z tabeli
Jeśli użytkownik niepoprawnie wprowadzi dane, ma możliwość wybrania konkretnego wiersza w tabeli oraz usunięcia go, za pomocą przycisku **"usuń"**.

### 4. Algorytm 3D Bin Packing
Aplikacja implementuje algorytm optymalnego rozmieszczenia palet: 
- **Grupuje palety** według wymiarów.  
- **Sprawdza**, czy palety nie są za duże.  
- **Sortuje grupy** według głębokości.  
- **Układa palety** w dwóch rzędach, sprawdzając długość i wysokość.  
- **Zwraca `true`**, jeśli wszystkie palety zmieszczą się, inaczej `false`.

Dzięki temu użytkownik może szybko sprawdzić, które naczepy są odpowiednie dla danego ładunku.

## Komponenty
- `Pallet` - Zawiera implementację palet o własnościach długość, szerokość, wysokość, waga, ilość oraz funkcję odpowiadającą za poziomą rotację danej palety,
- `Trailer` - Zawiera implementację naczep o własnościach nazwa, długość, szerokość, wysokość, maksymalna ładowność,
- `TrailerManager` - Tworzy listę podstawowych naczep: Furgon, Standard, Mega,
- `MainController` - Odpowiada za połączenie elementów graficznych z ich funkcjonalnościami, implementuje przyciski dodawania palet oraz kalkulacji, zawiera obsługę błędów wprowadzanych danych oraz obliczeń,
- `BinPacking3D` - Zawiera funkcję odpowiadającą za obliczenia,
- `MainApplication` - Tworzy instancje głównego okna programu,
- `style.css` - Odpowiada za wygląd aplikacji.

## Instrukcja użytkownika
- Po uruchomieniu aplikacji wprowadź wymiary oraz wagę palet, a następnie zatwierdź, klikając przycisk **"dodaj"**.
- Jeśli dane zostały poprawnie wprowadzone, paleta pojawi się w tabeli.
- Po zarejestrowaniu wszystkich palet należy kliknąć przycisk **"oblicz"**, aby wyświetlić wynik analizy optymalnego rozmieszczenia ładunku.

## Interfejs
<div align="center">

![{D683EFCA-668B-474C-9D38-8DEA7487311D}](https://github.com/user-attachments/assets/d583b1bc-4db7-4379-8556-020880b3dcde)

Widok dodawania oraz wyświetlania palet.
<br><br>

![{4AD9CCF1-3EC5-43F6-9F64-15466CBE84B3}](https://github.com/user-attachments/assets/aa86d3d6-8566-4a37-bf62-6b48879e62b4)

Okno z wynikiem obliczeń.

</div>


