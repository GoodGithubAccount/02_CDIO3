package GUI;

import javax.swing.JOptionPane;

public class PopupBox {

    private String textMessage;
    private String title;
    private String[] buttonNames;

    public PopupBox(String textMessage, String title){
        this.textMessage = textMessage;
        this.title = title;
    }

    public String popup(){
        return JOptionPane.showInputDialog(null, textMessage, title, JOptionPane.INFORMATION_MESSAGE);
    }

}
