import java.awt.*;

public class UlamSpiral extends Frame {
    public UlamSpiral(){
        setSize(640, 480);
        setVisible(true);
    }

    enum direction {
        TOP, BOTTOM, LEFT, RIGHT
    }

    int primeNumber;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Dimension dim = this.getSize();
        getNextPrimeNumber(primeNumber);
        int x = (int) dim.getWidth() / 2, y = (int) dim.getHeight() / 2, repeats = 1, counter = 1;
        this.drawSpiral(g, x, y, direction.RIGHT, repeats, counter);
    }


    public void drawSpiral(Graphics g, int x, int y, direction dir, int repeats, int counter) {
        Dimension dim = this.getSize();
        if (x >= dim.getWidth() || y >= dim.getHeight()) return;

        switch (dir) {
            case TOP -> drawPixel(g, x, y, repeats, 0, 1, counter, direction.LEFT);
            case BOTTOM -> drawPixel(g, x, y, repeats, 0, -1, counter, direction.RIGHT);
            case LEFT -> drawPixel(g, x, y, repeats, -1, 0, counter, direction.BOTTOM);
            case RIGHT -> drawPixel(g, x, y, repeats, 1, 0, counter, direction.TOP);
        }
    }

    private void drawPixel(Graphics g, int x, int y, int repeats, int incrementX, int incrementY, int counter, direction nextDir) {
        for (int i = 0; i < repeats; i++) {
            if (counter == primeNumber) {
                g.fillRect(x, y, 1, 1);
                getNextPrimeNumber(primeNumber);

            }
            ++counter;
            x += incrementX;
            y += incrementY;
        }
        this.drawSpiral(g, x, y, nextDir, ++repeats, counter);
    }

    private void getNextPrimeNumber(int primeNumber) {

    }

    public static void main(String[] args){
        new UlamSpiral();
    }
}
