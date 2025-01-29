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

### 4. Algorytm pakowania 3D
Aplikacja implementuje algorytm optymalnego rozmieszczenia palet:
- Palety są sortowane malejąco według objętości,
- Tworzone są warstwy (`Layer`), w których układane są palety,
- Nowe warstwy są dodawane, jeśli pozwala na to wysokość naczepy,
- W przypadku braku miejsca funkcja zwraca `false`, oznaczając, że naczepa nie pomieści wszystkich palet.

Dzięki temu użytkownik może szybko sprawdzić, które naczepy są odpowiednie dla danego ładunku.

## Wymagania oprogramowania
- **Java Development Kit (JDK)** - wersja 8 lub nowsza (zalecana 17 lub nowsza),
- **Git** - do pobrania kodu z repozytorium.

## Instalacja i konfiguracja
-

## Instrukcja użytkownika
- Po uruchomieniu aplikacji wprowadź wymiary oraz wagę palet, a następnie zatwierdź, klikając przycisk **"Dodaj"**.
- Jeśli dane zostały poprawnie wprowadzone, paleta pojawi się w tabeli.
- Po zarejestrowaniu wszystkich palet należy kliknąć przycisk **"Oblicz"**, aby wyświetlić wynik analizy optymalnego rozmieszczenia ładunku.

## Interfejs
![image](https://github.com/user-attachments/assets/5609667e-44c6-4be6-aadb-c6bc2435dc98)
