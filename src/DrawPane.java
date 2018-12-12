import javax.swing.*;
import java.awt.*;

public class DrawPane extends JPanel {
    public void paintComponent(Graphics g){
        //draw on g here e.g.
        //g.fillRect(20, 20, 100, 200);
        System.out.println(getSize());

    }
}
