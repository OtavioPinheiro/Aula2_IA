package br.com.ia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.Objects;

public class TelaInfos {
    private JLabel Titulo;
    private JComboBox comboVoador;
    private JLabel labelPelo;
    private JLabel labelPenas;
    private JLabel labelOvos;
    private JLabel labelLeite;
    private JLabel labelVoador;
    private JLabel labelAquatico;
    private JLabel labelPredador;
    private JLabel labelDentes;
    private JLabel labelVertebra;
    private JLabel labelAr;
    private JLabel labelVeneno;
    private JLabel labelPernas;
    private JLabel labelRabo;
    private JLabel labelDomestico;
    private JLabel labelAgil;
    private JLabel labelBarbatanas;
    private JComboBox comboPelo;
    private JComboBox comboPenas;
    private JComboBox comboOvos;
    private JComboBox comboLeite;
    private JComboBox comboAquatico;
    private JComboBox comboPredador;
    private JComboBox comboDentes;
    private JComboBox comboVertebra;
    private JComboBox comboAr;
    private JComboBox comboVenenoso;
    private JComboBox comboBarbatanas;
    private JComboBox comboPernas;
    private JComboBox comboRabo;
    private JComboBox comboDomestico;
    private JComboBox comboAgil;
    private JButton confirmarButton;
    private JPanel telaInfos;

    public JPanel getTelaInfos() {
        return telaInfos;
    }

    Infos infos;

    public TelaInfos() throws Exception {
        infos = new Infos();

        confirmarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    confirmarParam();

                    // Chamar a tela de resultados
                    Object[] opcoes = {"Sim", "Não"};

                    Dimension tamanhoDaTela = Toolkit.getDefaultToolkit().getScreenSize();
                    double larguraDaTela = tamanhoDaTela.getWidth();
                    double alturaDaTela = tamanhoDaTela.getHeight();

                    JFrame telaResutados = new JFrame();
                    telaResutados.setContentPane(new TelaResultados(infos).getTelaResultados());
                    telaResutados.setSize((int)(0.4 * larguraDaTela), (int)(0.8 * alturaDaTela));
                    telaResutados.setResizable(true);
                    telaResutados.setLocation((int)(0.3 * larguraDaTela), (int)(0.1 * alturaDaTela));
                    telaResutados.setTitle("Resultado da classificação");
                    telaResutados.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    telaResutados.setVisible(true);
                    telaResutados.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            int respostaJanela = JOptionPane.showOptionDialog(
                                    null,
                                    "Deseja classificar outro animal?",
                                    "Encerrando",
                                    JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    opcoes,
                                    opcoes[0]
                            );
                            if (respostaJanela == 0) {
                                try {
                                    Principal.displayTelaInfos();
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            }
                            else {
                                JOptionPane.showMessageDialog(
                                        null,
                                        "Encerrando aplicação...\n\nObrigado!",
                                        "Encerrando",
                                        JOptionPane.PLAIN_MESSAGE
                                );
                                System.exit(0);
                            }
                        }
                    });
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void confirmarParam() throws Exception {
        double[] infosAnimal = new double[16];

        String pelo = Objects.requireNonNull(comboPelo.getSelectedItem()).toString();
        double paramPelo = converterResultado(pelo);
        infosAnimal[0] = paramPelo;

        String penas = Objects.requireNonNull(comboPenas.getSelectedItem()).toString();
        double paramPenas = converterResultado(penas);
        infosAnimal[1] = paramPenas;

        String ovos = Objects.requireNonNull(comboOvos.getSelectedItem()).toString();
        double paramOvos = converterResultado(ovos);
        infosAnimal[2] = paramOvos;

        String leite = Objects.requireNonNull(comboLeite.getSelectedItem()).toString();
        double paramLeite = converterResultado(leite);
        infosAnimal[3] = paramLeite;

        String voador = Objects.requireNonNull(comboVoador.getSelectedItem()).toString();
        double paramVoador = converterResultado(voador);
        infosAnimal[4] = paramVoador;

        String aquatico = Objects.requireNonNull(comboAquatico.getSelectedItem()).toString();
        double paramAquatico = converterResultado(aquatico);
        infosAnimal[5] = paramAquatico;

        String predador = Objects.requireNonNull(comboPredador.getSelectedItem()).toString();
        double paramPredador = converterResultado(predador);
        infosAnimal[6] = paramPredador;

        String dentes = Objects.requireNonNull(comboDentes.getSelectedItem()).toString();
        double paramDentes = converterResultado(dentes);
        infosAnimal[7] = paramDentes;

        String vertebras = Objects.requireNonNull(comboVertebra.getSelectedItem()).toString();
        double paramVertebras = converterResultado(vertebras);
        infosAnimal[8] = paramVertebras;

        String ar = Objects.requireNonNull(comboAr.getSelectedItem()).toString();
        double paramAr = converterResultado(ar);
        infosAnimal[9] = paramAr;

        String venenoso = Objects.requireNonNull(comboVenenoso.getSelectedItem()).toString();
        double paramVenenoso = converterResultado(venenoso);
        infosAnimal[10] = paramVenenoso;

        String barbatanas = Objects.requireNonNull(comboBarbatanas.getSelectedItem()).toString();
        double paramBarbatanas = converterResultado(barbatanas);
        infosAnimal[11] = paramBarbatanas;

        String pernas = Objects.requireNonNull(comboPernas.getSelectedItem()).toString();
        double paramPernas = Double.parseDouble(pernas);
        infosAnimal[12] = paramPernas;

        String rabo = Objects.requireNonNull(comboRabo.getSelectedItem()).toString();
        double paramRabo = converterResultado(rabo);
        infosAnimal[13] = paramRabo;

        String domestico = Objects.requireNonNull(comboDomestico.getSelectedItem()).toString();
        double paramDomestico = converterResultado(domestico);
        infosAnimal[14] = paramDomestico;

        String agil = Objects.requireNonNull(comboAgil.getSelectedItem()).toString();
        double paramAgil = converterResultado(agil);
        infosAnimal[15] = paramAgil;

        infos.setInfos(infosAnimal);
    }

    private double converterResultado(String valor) {
        double resultado = 0.0;
        if (Objects.equals(valor, "Sim")) {
            resultado = 1.0;
        }
        return resultado;
    }
}
