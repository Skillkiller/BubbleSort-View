import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main extends JFrame {

    private static Integer[] values;
    private static Random r = new Random();
    private static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    private static int i2;


    private Main(int width, int height) {
        setContentPane(new DrawPane());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(width, height));
        setContentPane(new JPanel() {
            public void paintComponent(Graphics g){
                for (int i = 0; i < values.length; i++) {
                    if (values.length - i2 > i) {
                        g.setColor(Color.BLACK);
                    } else {
                        g.setColor(Color.GREEN);
                    }
                    g.drawLine(i, getHeight(), i, getHeight()- values[i]);
                }
            }
        });

        setVisible(true);
        pack();
    }

    public static void main(String[] args) throws InterruptedException {
        int width = device.getDisplayMode().getWidth();
        int height = device.getDisplayMode().getHeight();
        values = new Integer[width];
        for (int i = 0; i < values.length; i++) {
            values[i] = r.nextInt(height);
        }
        JFrame myFrame = new Main(width, height);
        device.setFullScreenWindow(myFrame);
        Thread.sleep(1000);
        int temp;
        for(i2=1; i2<values.length; i2++) {
            for(int j=0; j<values.length-i2; j++) {
                if(values[j]>values[j+1]) {
                    temp=values[j];
                    values[j]=values[j+1];
                    values[j+1]=temp;
                }
                myFrame.repaint();
            }
            Thread.sleep(10);
        }

    }
}
