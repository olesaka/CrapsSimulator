import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/***************************************************************
 * GUI front end to a game of Craps
 * 
 * @author Scott Grissom 
 * @version September 14, 2015
 ***************************************************************/
public class CrapsGUI extends JFrame implements ActionListener{

    /** visual representation of the dice */
    private GVDie d1, d2;

    /** buttons */
    private JButton comeOutButton, rollButton;

    /** labels for message and credits */
    private JLabel message, credits;

    /** the game of craps object */
    private Craps game;    

    /****************************************************************
    Create all elements and display within the GUI
     ****************************************************************/        
    public static void main(String arg[]){
        CrapsGUI gui = new CrapsGUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("Andrew Olesak's game of Craps!");
        gui.pack();
        gui.setVisible(true);
    }

    /****************************************************************
    Create all elements and display within the GUI
     ****************************************************************/    
    public CrapsGUI(){ 

        // create the game object as well as the GUI Frame   
        this.game = new Craps();
        getContentPane().setBackground(Color.lightGray);

        // set the layout to GridBag
        setLayout(new GridBagLayout());
        GridBagConstraints position = new GridBagConstraints();

        // create and place the this.message label
        this.message = new JLabel();
        this.message.setText(this.game.getMessage());
        position.gridx = 0;
        position.gridy = 0;
        position.gridwidth = 2;
        position.insets = new Insets(0, 0, 5, 30);
        add(this.message, position);

        // get Die #1 from this.game and place on frame
        this.d1 = this.game.getDie(1);
        this.d1.setForeground(Color.WHITE);
        this.d1.setBackground(Color.RED);
        position.gridx = 0;
        position.gridy = 1;
        position.gridwidth = 1;
        add(this.d1, position);

        // get Die #2 from game and place on frame
        this.d2 = this.game.getDie(2);
        this.d2.setForeground(Color.WHITE);
        this.d2.setBackground(Color.RED);
        position.gridx = 1;
        position.gridy = 1;
        position.gridwidth = 1;
        add(this.d2, position);

        // create and place the Come Out button
        this.comeOutButton = new JButton("Come Out");
        this.comeOutButton.setBackground(Color.GREEN);
        position.gridx = 0;
        position.gridy = 3;
        position.gridwidth = 1;
        add(this.comeOutButton, position);

        // create and place the Roll button
        this.rollButton = new JButton("Roll");
        this.rollButton.setBackground(Color.GREEN);
        this.rollButton.setEnabled(false);
        position.gridx = 1;
        position.gridy = 3;
        position.gridwidth = 1;
        add(this.rollButton, position);

        // create and position the Credits label
        this.credits = new JLabel();
        this.credits.setText("Credits: " + this.game.getCredits());
        position.gridx = 0;
        position.gridy = 2;
        position.gridwidth = 2;
        position.insets = new Insets(20, 0, 5, 30);
        add(this.credits, position);

        // register the listeners
        comeOutButton.addActionListener(this);
        rollButton.addActionListener(this);

    }

    /****************************************************************
    Inner class to repond to the user action

    @param e - the JComponent just selected
     ****************************************************************/
    public void actionPerformed(ActionEvent event){

        // test for roll and then game.roll()
        if(event.getSource() == rollButton){
            game.roll();
        }

        // test for come out and then game.comeOut()
        if(event.getSource() == comeOutButton){
            game.comeOut();
        }

        //update the labels
        credits.setText("Credits: " + game.getCredits());
        message.setText(game.getMessage());

        // enable/disable each button based on status of game
        if(game.okToRoll()){
            comeOutButton.setEnabled(false);
        } else{
            comeOutButton.setEnabled(true);   
        }

        if(!game.okToRoll()){
            rollButton.setEnabled(false);
        }else{
            rollButton.setEnabled(true);
        }

        if(game.okToRoll() && game.getCredits() == 0){
            comeOutButton.setEnabled(false);
            rollButton.setEnabled(false);
        } 
    }
}

