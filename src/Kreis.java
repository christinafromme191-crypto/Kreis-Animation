public class Kreis {
    private double x;           // X-Position des Mittelpunkts
    private double y;           // Y-Position des Mittelpunkts
    private double vx;          // Geschwindigkeit in X-Richtung
    private double vy;          // Geschwindigkeit in Y-Richtung
    private int radius;         // Radius des Kreises
    private int screenWidth;    // Bildschirmbreite
    private int screenHeight;   // Bildschirmhöhe

    /**
     * Konstruktor für die Kreis-Klasse
     * @param x Startposition X
     * @param y Startposition Y
     * @param vx Geschwindigkeit X
     * @param vy Geschwindigkeit Y
     * @param radius Radius des Kreises
     * @param screenWidth Breite des Fensters
     * @param screenHeight Höhe des Fensters
     */
    public Kreis(double x, double y, double vx, double vy, int radius, int screenWidth, int screenHeight) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.radius = radius;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }

    /**
     * Aktualisiert die Position des Kreises
     */
    public void update() {
        x += vx;
        y += vy;

        // Kollision mit den Rändern (Einfallswinkel = Ausfallswinkel)
        if (x - radius <= 0 || x + radius >= screenWidth) {
            vx = -vx;  // Richtung in X umkehren
            x = Math.max(radius, Math.min(screenWidth - radius, x));  // Position korrigieren
        }

        if (y - radius <= 0 || y + radius >= screenHeight) {
            vy = -vy;  // Richtung in Y umkehren
            y = Math.max(radius, Math.min(screenHeight - radius, y));  // Position korrigieren
        }
    }

    /**
     * Gibt die aktuelle Position in der Konsole aus
     */
    public void printPosition() {
        System.out.printf("Position: x=%.2f, y=%.2f%n", x, y);
    }

    // Getter und Setter
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public void setVelocity(double vx, double vy) {
        this.vx = vx;
        this.vy = vy;
    }

    public double getVx() {
        return vx;
    }

    public double getVy() {
        return vy;
    }
}
