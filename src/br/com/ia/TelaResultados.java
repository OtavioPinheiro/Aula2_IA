package br.com.ia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaResultados {
    private JLabel labelResultado;
    private JLabel labelClassificacao;
    private JLabel labelAvaliacao;
    private JButton exibirButton;
    private JPanel telaResultados;
    private JLabel labelConfusao;
    private JTextPane tpAvaliacao;
    private JTextPane tpConfusao;

    public JPanel getTelaResultados() {
        return telaResultados;
    }

    public TelaResultados() throws Exception {
        Resultados resultados = new Resultados();

        ajustarTamanhoDaFonte();

        labelClassificacao.setForeground(new Color(30, 210, 20));
        labelClassificacao.setText(resultados.getResultados());

//        labelAvaliacao.setForeground(new Color(30, 210, 20));
        tpAvaliacao.setText(resultados.displayAvaliacaoDaClassificacao());
        tpAvaliacao.setBackground(telaResultados.getBackground());
        tpAvaliacao.setDisabledTextColor(new Color(0, 0, 0));

//        labelConfusao.setForeground(new Color(30, 210, 20));
        tpConfusao.setText(resultados.displayMatrizConfusao());
        tpConfusao.setBackground(telaResultados.getBackground());
        tpConfusao.setDisabledTextColor(new Color(0, 0, 0));

        exibirButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    resultados.displayArvore();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void ajustarTamanhoDaFonte() {
        Dimension tamanhoDaTela = Toolkit.getDefaultToolkit().getScreenSize();
        double larguraDaTela = tamanhoDaTela.getWidth();
        double alturaDaTela = tamanhoDaTela.getHeight();

        if (larguraDaTela < 2560 && alturaDaTela < 1440) {
            Font font = new Font("Arial", Font.BOLD, 16);
            labelResultado.setFont(font);
            labelClassificacao.setFont(font);
            labelAvaliacao.setFont(font);
            labelConfusao.setFont(font);
            tpAvaliacao.setFont(font);
            tpConfusao.setFont(font);
            exibirButton.setFont(font);
        }
    }
}
