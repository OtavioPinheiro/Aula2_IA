package br.com.ia;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Principal {
    public static void main(String[] args) throws Exception {
        displayTelaInfos();
    }

    public static void displayTelaInfos() throws Exception {
        Object[] opcoes = {"Sim", "Não"};
        JFrame tela = new JFrame();
        tela.setContentPane(new TelaInfos().getTelaInfos());
        tela.setSize(750, 450);
        tela.setResizable(true);
        tela.setLocation(900, 500);
        tela.setTitle("Classificação de animais");
        tela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        tela.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int respostaJanela = JOptionPane.showOptionDialog(
                        null,
                        "Tem certeza que deseja sair?",
                        "Encerrando",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opcoes,
                        opcoes[0]
                );
                if (respostaJanela == 0) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Encerrando aplicação...\n\nObrigado!",
                            "Encerrando",
                            JOptionPane.PLAIN_MESSAGE
                    );
                    System.exit(0);
                }
                else {
                    try {
                        displayTelaInfos();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        tela.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowLostFocus(WindowEvent e) {
                tela.dispose();
            }
        });

        tela.setVisible(true);
    }
}
