package br.com.ia;

import weka.attributeSelection.AttributeSelection;
import weka.attributeSelection.InfoGainAttributeEval;
import weka.attributeSelection.Ranker;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ConverterUtils;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;
import weka.gui.treevisualizer.PlaceNode2;
import weka.gui.treevisualizer.TreeVisualizer;

import javax.swing.*;
import java.util.Arrays;
import java.util.Random;

public class Resultados {
    private final Instances dados;
    private final double[] vals;

    public Resultados(Infos infos) throws Exception {
        vals = infos.getInfos();
        dados = infos.getDados();
    }

    public String getResultados() throws Exception {
//        ConverterUtils.DataSource arquivo = new ConverterUtils.DataSource("./data/zoo.arff");
//        Instances dados = arquivo.getDataSet();
//
//        String[] parametros = new String[] {"-R", "1"};
//        Remove filtro = new Remove();
//        filtro.setOptions(parametros);
//        filtro.setInputFormat(dados);
//        dados = Filter.useFilter(dados, filtro);
//
//        AttributeSelection selAtributo = new AttributeSelection();
//        InfoGainAttributeEval avaliador = new InfoGainAttributeEval();
//        Ranker busca = new Ranker();
//        selAtributo.setEvaluator(avaliador);
//        selAtributo.setSearch(busca);
//        selAtributo.SelectAttributes(dados);
//
//        String[] opcoes = new String[1];
//        opcoes[0] = "-U";
//        J48 arvore = new J48();
//        arvore.setOptions(opcoes);
//        arvore.buildClassifier(dados);
//
//        double[] vals = new double[dados.numAttributes()];
//        vals[0] = 1.0; //hair
//        vals[1] = 1.0; //feathers
//        vals[2] = 1.0; //eggs
//        vals[3] = 1.0; //milk
//        vals[4] = 1.0; //airbone
//        vals[5] = 1.0; //aquatic
//        vals[6] = 1.0; //predator
//        vals[7] = 1.0; //toothed
//        vals[8] = 1.0; //backbone
//        vals[9] = 1.0; //breathes
//        vals[10] = 1.0; //venomous
//        vals[11] = 1.0; //fins
//        vals[12] = 0.0; //legs
//        vals[13] = 1.0; //tail
//        vals[14] = 1.0; //domestic
//        vals[15] = 1.0; //catsize
//
//        // Criar uma instância baseada nestes atributos
//        Instance animal = new DenseInstance(1.0, vals);
//
//        // Adicionar a instância nos dados
//        animal.setDataset(dados);
//
//        // Classificar esta nova instância
//        double label = arvore.classifyInstance(animal);
//
//        // Imprimir o resultado da classificação
//        System.out.println(dados.classAttribute().value((int)label));
//        return dados.classAttribute().value((int)label);

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
        System.out.println(dados.classAttribute().value((int)label));
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
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(tv);
        frame.setVisible(true);
        tv.fitToScreen();
    }

    public String displayAvaliacaoDaClassificacao() throws Exception {
        // Classificação
        Classifier cl = new J48();
        Evaluation eval_roc = new Evaluation(dados);
        eval_roc.crossValidateModel(cl, dados, 10, new Random(1), new Object[] {});
        return eval_roc.toSummaryString();
    }

    public String displayMatrizConfusao() throws Exception {
        Classifier cl = new J48();
        Evaluation eval_roc = new Evaluation(dados);
        eval_roc.crossValidateModel(cl, dados, 10, new Random(1), new Object[] {});

        // Matriz de confusão
        double[][] confusionMatrix = eval_roc.confusionMatrix();
        return eval_roc.toMatrixString();
    }
}
