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
import weka.core.converters.ConverterUtils;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;
import weka.gui.treevisualizer.PlaceNode2;
import weka.gui.treevisualizer.TreeVisualizer;

import javax.swing.*;
import java.util.Random;

public class Infos {
    private ConverterUtils.DataSource arquivo;
    private Instances dados;
    private double[] vals;

    public Infos() throws Exception {
        arquivo = new ConverterUtils.DataSource("./data/zoo.arff");
        dados = arquivo.getDataSet();

        String[] parametros = new String[] {"-R", "1"};
        Remove filtro = new Remove();
        filtro.setOptions(parametros);
        filtro.setInputFormat(dados);
        dados = Filter.useFilter(dados, filtro);

        AttributeSelection selAtributo = new AttributeSelection();
        InfoGainAttributeEval avaliador = new InfoGainAttributeEval();
        Ranker busca = new Ranker();
        selAtributo.setEvaluator(avaliador);
        selAtributo.setSearch(busca);
        selAtributo.SelectAttributes(dados);

        vals = new double[dados.numAttributes()];
    }

    public void setInfos(Double[] infos) {
        vals[0] = infos[0]; //hair
        vals[1] = infos[1]; //feathers
        vals[2] = infos[2]; //eggs
        vals[3] = infos[3]; //milk
        vals[4] = infos[4]; //airbone
        vals[5] = infos[5]; //aquatic
        vals[6] = infos[6]; //predator
        vals[7] = infos[7]; //toothed
        vals[8] = infos[8]; //backbone
        vals[9] = infos[9]; //breathes
        vals[10] = infos[10]; //venomous
        vals[11] = infos[11]; //fins
        vals[12] = infos[12]; //legs
        vals[13] = infos[13]; //tail
        vals[14] = infos[14]; //domestic
        vals[15] = infos[15]; //catsize
    }

    public double[] getInfos() {
        return vals;
    }

    public Instances getDados() {
        return dados;
    }
}
