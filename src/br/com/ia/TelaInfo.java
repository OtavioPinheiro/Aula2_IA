package br.com.ia;

import javax.swing.*;
import java.util.Objects;

public class TelaInfo {
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

    public TelaInfo() {
        //Instanciar a classe de informações

        String pelo = Objects.requireNonNull(comboPelo.getSelectedItem()).toString();
        Double paramPelo = converterResultado(pelo);
        String penas = Objects.requireNonNull(comboPenas.getSelectedItem()).toString();
        Double paramPenas = converterResultado(penas);
        String ovos = Objects.requireNonNull(comboOvos.getSelectedItem()).toString();
        Double paramOvos = converterResultado(ovos);
        String leite = Objects.requireNonNull(comboLeite.getSelectedItem()).toString();
        Double paramLeite = converterResultado(leite);
        String voador = Objects.requireNonNull(comboVoador.getSelectedItem()).toString();
        Double paramVoador = converterResultado(voador);
        String aquatico = Objects.requireNonNull(comboAquatico.getSelectedItem()).toString();
        Double paramAquatico = converterResultado(aquatico);
        String predador = Objects.requireNonNull(comboPredador.getSelectedItem()).toString();
        Double paramPredador = converterResultado(predador);
        String dentes = Objects.requireNonNull(comboDentes.getSelectedItem()).toString();
        Double paramDentes = converterResultado(dentes);
        String vertebras = Objects.requireNonNull(comboVertebra.getSelectedItem()).toString();
        Double paramVertebras = converterResultado(vertebras);
        String ar = Objects.requireNonNull(comboAr.getSelectedItem()).toString();
        Double paramAr = converterResultado(ar);
        String venenoso = Objects.requireNonNull(comboVenenoso.getSelectedItem()).toString();
        Double paramVenenoso = converterResultado(venenoso);
        String barbatanas = Objects.requireNonNull(comboBarbatanas.getSelectedItem()).toString();
        Double paramBarbatanas = converterResultado(barbatanas);
        String pernas = Objects.requireNonNull(comboPernas.getSelectedItem()).toString();
        Double paramPernas = converterResultado(pernas);
        String rabo = Objects.requireNonNull(comboRabo.getSelectedItem()).toString();
        Double paramRabo = converterResultado(rabo);
        String domestico = Objects.requireNonNull(comboDomestico.getSelectedItem()).toString();
        Double paramDomestico = converterResultado(domestico);
        String agil = Objects.requireNonNull(comboAgil.getSelectedItem()).toString();
        Double paramAgil = converterResultado(agil);
    }

    private Double converterResultado(String valor) {
        Double resultado = 0.0;
        if (valor == "Sim") {
            resultado = 1.0;
        }
        return resultado;
    }
}
