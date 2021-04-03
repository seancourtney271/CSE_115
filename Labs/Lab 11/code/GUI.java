package code;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI{

    private static final int HISTORY_SIZE = 500;
    private JTextArea chatArea;
    private JTextField usernameTextField;
    private JTextField messageTextField;


    public GUI(){
        // int values determine the size of each element
        this.chatArea = new JTextArea(20, 60);
        this.chatArea.setLineWrap(true);
        this.usernameTextField = new JTextField(8);
        this.messageTextField = new JTextField(22);
        updateChat();
    }


    private void updateChat(){
        this.chatArea.setText(ChatLab.getChatString(GUI.HISTORY_SIZE));
    }


    public JPanel getChatPanel(){
        JPanel panel = new JPanel();
        panel.add(new JScrollPane(this.chatArea));
        return panel;
    }


    public void sendMessage(){
        ChatLab.sendMessage(this.usernameTextField.getText(), this.messageTextField.getText());
        this.messageTextField.setText("");
        updateChat();
    }


    public JPanel getControlPanel(){
        JPanel panel = new JPanel();

        panel.add(new JLabel("Username:"));
        panel.add(this.usernameTextField);

        panel.add(new JLabel("Message:"));
        panel.add(this.messageTextField);

        this.messageTextField.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e){
            }

            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    sendMessage();
                }
            }

            @Override
            public void keyReleased(KeyEvent e){
            }
        });


        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                sendMessage();
            }
        });
        panel.add(sendButton);


        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                updateChat();
            }
        });
        panel.add(refreshButton);

        return panel;
    }

}
