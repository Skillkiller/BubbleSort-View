import javax.swing.*;

public class MyFrame extends JFrame {

    public MyFrame(){
        super("My Frame");

        //you can set the content pane of the frame
        //to your custom class.

        setContentPane(new DrawPane());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(400, 400);

        setVisible(true);
    }

}
