# Zarządzanie Paletami

Zarządzanie Paletami to prosta aplikacja napisana w języku Java, służąca do kalkulacji ilości palet, jaka zmieści się do odpowiednich naczep. Aplikacja jest skierowana do osób oraz firm związanych z branżą logistyczną, transportową i magazynową, które potrzebują prostego narzędzia do optymalizacji załadunku naczep oraz kalkulacji ilości palet.

## Funkcjonalność
### 1. Dodawanie palet
Użytkownik wprowadza wymiary (długość, szerokość, wysokość), wagę oraz ilość palet, a następnie zatwierdza przyciskiem **"Dodaj"**. Dane zostają dodane do tabeli, a pola formularza są czyszczone. W przypadku błędnych danych pojawia się komunikat o błędzie.

### 2. Wyświetlanie palet w tabeli
Tabela dynamicznie aktualizuje się po dodaniu nowych palet. Kolumny tabeli są powiązane z właściwościami obiektu `Pallet`, dzięki czemu dane są automatycznie wyświetlane.

### 3. Analiza załadunku palet
Po dodaniu palet użytkownik może kliknąć **"Oblicz"**, aby sprawdzić, czy naczepy pomieszczą ładunek.

Aplikacja:
- Pobiera listę dostępnych naczep,
- Oblicza łączną wagę palet,
- Sprawdza, czy palety zmieszczą się w danej naczepie i czy nie przekroczono maksymalnej ładowności,
- Wyświetla wynik w oknie.

### 4. Algorytm 3D Bin Packing
Aplikacja implementuje algorytm optymalnego rozmieszczenia palet:
- Palety są sortowane malejąco według objętości,
- Tworzone są warstwy (`Layer`), w których układane są palety,
- Nowe warstwy są dodawane, jeśli pozwala na to wysokość naczepy,
- W przypadku braku miejsca funkcja zwraca `false`, oznaczając, że naczepa nie pomieści wszystkich palet.

Dzięki temu użytkownik może szybko sprawdzić, które naczepy są odpowiednie dla danego ładunku.

## Komponenty
- `Pallet` - Zawiera implementację palet o własnościach długość, szerokość, wysokość, waga, ilość oraz funkcję odpowiadającą za poziomą rotację danej palety,
- `Trailer` - Zawiera implementację naczep o własnościach nazwa, długość, szerokość, wysokość, maksymalna ładowność,
- `TrailerManager` - Tworzy listę podstawowych naczep: Furgon, Standard, Mega,
- `MainController` - Odpowiada za połączenie elementów graficznych z ich funkcjonalnościami, implementuje przyciski dodawania palet oraz kalkulacji, zawiera obsługę błędów wprowadzanych danych oraz obliczeń,
- `BinPacking3D` - Zawiera funkcję odpowiadającą za obliczenia,
- `Layer` - Implementuje warstwy o własnościach długość, szerokość, wysokość, zawiera funkcję odpowiadającą za umieszczanie palety w odpowiednim ustawieniu,
- `MainApplication` - Tworzy instancje głównego okna programu,
- `style.css` - Odpowiada za wygląd aplikacji.

## Instrukcja użytkownika
- Po uruchomieniu aplikacji wprowadź wymiary oraz wagę palet, a następnie zatwierdź, klikając przycisk **"Dodaj"**.
- Jeśli dane zostały poprawnie wprowadzone, paleta pojawi się w tabeli.
- Po zarejestrowaniu wszystkich palet należy kliknąć przycisk **"Oblicz"**, aby wyświetlić wynik analizy optymalnego rozmieszczenia ładunku.

## Interfejs
![image](https://github.com/user-attachments/assets/5609667e-44c6-4be6-aadb-c6bc2435dc98)
