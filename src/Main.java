import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main extends JFrame {
    private KreisPanel panel;

    public Main() {
        setTitle("Kreis-Animation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        panel = new KreisPanel(800, 600);
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}

class KreisPanel extends JPanel {
    private Kreis kreis;
    private int screenWidth;
    private int screenHeight;
    private Timer gameTimer;
    private int frameCount = 0;

    public KreisPanel(int width, int height) {
        this.screenWidth = width;
        this.screenHeight = height;

        // Kreis erstellen mit zufälliger Richtung
        Random random = new Random();
        double startX = width / 2.0;
        double startY = height / 2.0;
        int radius = 20;

        // Zufällige Richtung (Geschwindigkeit zwischen -3 und 3)
        double vx = (random.nextDouble() - 0.5) * 6;
        double vy = (random.nextDouble() - 0.5) * 6;

        kreis = new Kreis(startX, startY, vx, vy, radius, width, height);

        // Timer für Animation (60 FPS)
        gameTimer = new Timer(16, e -> {
            kreis.update();
            frameCount++;

            // Position alle 30 Frames (ca. 0.5 Sekunden) ausgeben
            if (frameCount % 30 == 0) {
                kreis.printPosition();
            }

            repaint();
        });
        gameTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Anti-Aliasing aktivieren
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Hintergrund
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, screenWidth, screenHeight);

        // Kreis zeichnen
        g2d.setColor(new Color(0, 100, 200));
        int x = (int) kreis.getX();
        int y = (int) kreis.getY();
        int radius = kreis.getRadius();
        g2d.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);

        // Rahmen des Kreises
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);

        // Mittelpunkt markieren
        g2d.setColor(Color.RED);
        g2d.fillOval(x - 3, y - 3, 6, 6);

        // Info-Text
        g2d.setColor(Color.BLACK);
        g2d.drawString("Position: (" + String.format("%.1f", kreis.getX()) + ", " + String.format("%.1f", kreis.getY()) + ")", 10, 20);
        g2d.drawString("Velocity: (" + String.format("%.2f", kreis.getVx()) + ", " + String.format("%.2f", kreis.getVy()) + ")", 10, 40);
    }
}
