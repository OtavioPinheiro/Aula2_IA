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
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;
import weka.gui.treevisualizer.PlaceNode2;
import weka.gui.treevisualizer.TreeVisualizer;

import javax.swing.*;
import java.util.Arrays;
import java.util.Random;

public class Infos {
    DataSource arquivo = new DataSource("./data/zoo.arff");
    Instances dados = arquivo.getDataSet();
    double[] vals;

    String[] parametros = new String[] {"-R", "1"};
    Remove filtro = new Remove();

    AttributeSelection selAtributo = new AttributeSelection();
    InfoGainAttributeEval avaliador = new InfoGainAttributeEval();
    Ranker busca = new Ranker();

    public Infos() throws Exception {
        vals = new double[dados.numAttributes()];

        filtro.setOptions(parametros);
        filtro.setInputFormat(dados);
        dados = Filter.useFilter(dados, filtro);

        selAtributo.setEvaluator(avaliador);
        selAtributo.setSearch(busca);
        selAtributo.SelectAttributes(dados);

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
    }

    public void setInfos(double[] infos) {
//        this.vals = infos;
        this.vals[0] = infos[0]; //hair
        this.vals[1] = infos[1]; //feathers
        this.vals[2] = infos[2]; //eggs
        this.vals[3] = infos[3]; //milk
        this.vals[4] = infos[4]; //airbone
        this.vals[5] = infos[5]; //aquatic
        this.vals[6] = infos[6]; //predator
        this.vals[7] = infos[7]; //toothed
        this.vals[8] = infos[8]; //backbone
        this.vals[9] = infos[9]; //breathes
        this.vals[10] = infos[10]; //venomous
        this.vals[11] = infos[11]; //fins
        this.vals[12] = infos[12]; //legs
        this.vals[13] = infos[13]; //tail
        this.vals[14] = infos[14]; //domestic
        this.vals[15] = infos[15]; //catsize
        System.out.println(Arrays.toString(vals));
    }

    public double[] getInfos() {
        System.out.println(Arrays.toString(vals));
        return vals;
    }

    public Instances getDados() {
        return dados;
    }
}
