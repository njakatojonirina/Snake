import javax.swing.JFrame;

public class Fenetre extends JFrame{
    Emplacement emplacement = new Emplacement();
    public Fenetre()
    {        
        this.setTitle("Snake");
        this.setSize(700, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(emplacement);
        this.setVisible(true);
    }
    
}
