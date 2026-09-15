# Kreis-Animation

Ein Java-Projekt, das einen animierten Kreis mit Physik und Bildschirmrand-Kollision zeigt.

## Implementierte Funktionen

✅ **01: Ein Kreis wird auf einen Bildschirm gezeichnet**
- Der Kreis wird als blaues Oval mit schwarzem Rahmen gezeichnet
- Der Mittelpunkt ist mit einem roten Punkt markiert

✅ **02: Der Kreis bewegt sich über einen Bildschirm**
- Der Kreis bewegt sich kontinuierlich mit konstanter Geschwindigkeit

✅ **03: Der Kreis prallt am Bildschirmrand zurück**
- Kollisionserkennung an allen vier Bildschirmrändern
- Der Kreis bleibt innerhalb des sichtbaren Bereichs

✅ **04: Der Kreis startet mit zufälliger Richtung und prallt mit Einfallswinkel = Ausfallswinkel ab**
- Zufällige Startgeschwindigkeit in X- und Y-Richtung
- Korrekte Reflexion an den Rändern (vx und vy werden invertiert)

✅ **05: Die Position des Kreises wird in der Java-Konsole ausgegeben**
- Die Koordinaten (x, y) werden alle ~0.5 Sekunden in der Konsole ausgegeben
- Format: `Position: x=400.50, y=300.75`

## Klassen

### `Kreis`
Repräsentiert einen Kreis mit:
- Position (x, y)
- Geschwindigkeit (vx, vy)
- Radius
- Methoden zur Aktualisierung und Ausgabe

### `Main` und `KreisPanel`
- `Main`: Erstellt das Fenster
- `KreisPanel`: JPanel mit Zeichnen und Animation (60 FPS)

## Ausführung

```bash
javac src/*.java
java -cp src Main
```

## Fenster-Eigenschaften

- Größe: 800x600 Pixel
- Refresh Rate: 60 FPS
- Kreis Radius: 20 Pixel
- Zufällige Startgeschwindigkeit: -3 bis +3 Pixel pro Frame
