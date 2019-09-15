import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class SnakeFrame extends JFrame{

	public SnakeFrame() {

		SnakePanel panel=new SnakePanel();
		add(panel);
        pack();
        setTitle("Ai Snake");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        //addKeyListener does not work without it stack (286727)
        setFocusable(true);
        
        addKeyListener(panel);
        
        


	}
}
