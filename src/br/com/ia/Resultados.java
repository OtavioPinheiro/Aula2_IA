package br.com.ia;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.gui.treevisualizer.PlaceNode2;
import weka.gui.treevisualizer.TreeVisualizer;

import javax.swing.*;
import java.util.Random;

public class Resultados {
    private Instances dados;
    private double[] vals;

    public Resultados() throws Exception {
        Infos infos = new Infos();
        vals = infos.getInfos();
        dados = infos.getDados();
    }

    public String getResultados() throws Exception {
        // Definindo o tipo de classificador
        String[] opcoes = new String[1];
        opcoes[0] = "-U";
        J48 arvore = new J48();
        arvore.setOptions(opcoes);
        arvore.buildClassifier(dados);

        // Criar uma instância baseada nestes atributos
        Instance animal = new DenseInstance(1.0, vals);

        // Adicionar a instância nos dados
        animal.setDataset(dados);

        // Classificar esta nova instância
        double label = arvore.classifyInstance(animal);

        // Retorna o resultado da classificação
        return dados.classAttribute().value((int)label);
    }

    public void displayArvore() throws Exception {
        String[] opcoes = new String[1];
        opcoes[0] = "-U";
        J48 arvore = new J48();
        arvore.setOptions(opcoes);
        arvore.buildClassifier(dados);

        TreeVisualizer tv = new TreeVisualizer(null, arvore.graph(), new PlaceNode2());
        JFrame frame = new javax.swing.JFrame("Árvore de conhecimento");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(tv);
        frame.setVisible(true);
        tv.fitToScreen();
    }

    public String displayAvaliacaoDaClassificacao() throws Exception {
        // Classificação
        Classifier cl = new J48();
        Evaluation eval_roc = new Evaluation(dados);
        eval_roc.crossValidateModel(cl, dados, 10, new Random(1), new Object[] {});
        System.out.println(eval_roc.toSummaryString());
        return eval_roc.toSummaryString();
    }

    public String displayMatrizConfusao() throws Exception {
        Classifier cl = new J48();
        Evaluation eval_roc = new Evaluation(dados);
        eval_roc.crossValidateModel(cl, dados, 10, new Random(1), new Object[] {});

        // Matriz de confusão
        double[][] confusionMatrix = eval_roc.confusionMatrix();
        System.out.println(eval_roc.toMatrixString());
        return eval_roc.toMatrixString();
    }
}
