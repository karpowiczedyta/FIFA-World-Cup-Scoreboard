# FIFA-World-Cup-Scoreboard
Aplikacja Java do śledzenia meczów piłkarskich z sortowaniem według wyniku i czasu dodania.

Projekt przedstawia implementację tablicy wyników Mistrzostw Świata w Piłce Nożnej działającej w pamięci aplikacji.

System umożliwia zarządzanie meczami poprzez ich rozpoczynanie, aktualizację wyników i zakończenie. 

Dodatkowo można wydrukować raport trwających meczów.

Rozwiązanie zostało zaimplementowane w języku Java zgodnie z podejściem Test-Driven Development (TDD).

Funkcjonalności:

Rozpoczęcie meczu
Dodaje nowy mecz do tablicy wyników z początkowym wynikiem 0-0.

Przykład:
Meksyk - Kanada: 0 - 0

Aktualizacja wyniku
Pozwala zaktualizować wynik istniejącego meczu.

Przykład:
Meksyk - Kanada: 2 - 1

Zakończenie meczu
Usuwa mecz z tablicy wyników.

Pobranie podsumowania

Zwraca listę aktywnych meczów posortowaną według:
1.Łącznej liczby zdobytych bramek (malejąco)
2,Czasu rozpoczęcia meczu (od najnowszego), gdy suma bramek jest taka sama

Przykład
Dla następujących aktywnych meczów:

Meksyk - Kanada: 0 - 5
Hiszpania - Brazylia: 10 - 2
Niemcy - Francja: 2 - 2
Urugwaj - Włochy: 6 - 6
Argentyna - Australia: 3 - 1

Podsumowanie powinno zwrócić:

Urugwaj 6 - Włochy 6
Hiszpania 10 - Brazylia 2
Meksyk 0 - Kanada 5
Argentyna 3 - Australia 1
Niemcy 2 - Francja 2

Walidacja
W projekcie zaimplementowano podstawowe mechanizmy walidacji:

-nazwy drużyn nie mogą być puste ani null,
-gospodarz i gość muszą być różnymi drużynami,
-nie można rozpocząć tego samego meczu więcej niż raz,
-wynik nie może być ujemny,
-nie można aktualizować lub zakończyć nieistniejącego meczu.
- nazwy drużyn są normalizowane (trim() i toLowerCase()), dzięki czemu wartości takie jak:
    - Mexico
    - mexico
    - MEXICO

  są traktowane jako ta sama drużyna i nie powodują duplikacji danych.

Testy
Projekt został przygotowany zgodnie z podejściem TDD (Test-Driven Development).
Testy jednostkowe obejmują:
-rozpoczęcie nowego meczu z początkowym wynikiem 0–0
-zakończenie meczu i usunięcie go z tablicy wyników
-aktualizację wyniku aktywnego meczu
-odrzucenie nazw drużyn o wartości null
-odrzucenie pustych nazw drużyn oraz nazw zawierających wyłącznie białe znaki
-uniemożliwienie rozpoczęcia meczu pomiędzy tą samą drużyną
-odrzucenie ujemnych wartości wyników
-próba rozpoczęcia meczu, który już istnieje
-próba zakończenia nieistniejącego meczu
-próba aktualizacji nieistniejącego meczu
-próba aktualizacji meczu po jego zakończeniu
-sortowanie według łącznej liczby zdobytych bramek (malejąco)
-poprawne rozstrzyganie remisów poprzez priorytet dla najpóźniej rozpoczętego meczu
-zgodność wyniku końcowego z przykładem przedstawionym w treści zadania

Do implementacji testów wykorzystano framework JUnit 5.

Technologie:
Java
JUnit 6

Możliwe usprawnienia:
wykorzystanie własnych wyjątków,
udostępnienie funkcjonalności poprzez REST API,
integracja z bazą danych.
