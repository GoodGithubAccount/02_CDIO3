package Game;

import javax.swing.*;

public class Popupbox {
    JFrame frame = new JFrame();
    JButton button = new JButton();

    public Popupbox(String inpt) {
        this.button.setText(inpt);
        this.frame.add(button);
        this.frame.setSize(200, 200);
        this.frame.setVisible(true);
        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String name = JOptionPane.showInputDialog(frame,
                        "What is your name?", null);
            }
        });

    }


}
