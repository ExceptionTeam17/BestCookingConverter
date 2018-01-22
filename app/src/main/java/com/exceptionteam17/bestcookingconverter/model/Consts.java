package com.exceptionteam17.bestcookingconverter.model;

import java.util.HashMap;
import java.util.TreeMap;

public final class Consts {

    public static TreeMap<String, Double> GRAM_TO;
    public static TreeMap<String, Double> ML_TO;


    public static double CUP_US_IN_ML = 236.59;

    public static String KG = "kg";
    public static String GRAM = "g";
    public static String MG = "mg";
    public static String TON = "ton";
    public static String OZ = "oz";
    public static String LB = "lb";
    public static String ST = "st";

    public static String ML = "ml";
    public static String L = "l";
    public static String CU_IN = "cu in";
    public static String FL_OZ_LMP = "fl oz lmp";
    public static String PT_LMP = "pt lmp";
    public static String GAL_LMP = "gal lmp";
    public static String FL_OZ_US = "fl oz us";
    public static String GAL_US = "gal us";
    public static String CUP_US_TEA = "Cup  (us / tea cup)";
    public static String CUP_CANADA = "Cup (canadian)";
    public static String CUP_METRIC = "Cup (eu / metric)";
    public static String TBSP_UK = "tbsp uk";
    public static String TBSP_UK_2 = "tbsp uk 1/2";
    public static String TBSP_US = "tbsp us";
    public static String TBSP_US_2 = "tbsp us 1/2";
    public static String TBSP_METRIC = "tbsp metric";
    public static String TBSP_METRIC_2 = "tbsp metric 1/2";
    public static String TSP_UK = "tsp uk";
    public static String TSP_UK_2 = "tsp uk 1/2";
    public static String TSP_US = "tsp us";
    public static String TSP_US_2 = "tsp us 1/2";
    public static String TSP_METRIC = "tsp metric";
    public static String TSP_METRIC_2 = "tsp metric 1/2";
    public static String CUM_COFFEE_METRIC = "cup coffee metric";
    public static String CUP_JAPAN = "Cup (japanese)";
    public static String PINTS_US = "pints us";
    public static String PINTS_UK = "pints uk";
    public static String QUARTS_US = "quarts us";
    public static String QUARTS_UK = "quarts uk";
    public static String GILLS_US = "gills us";
    public static String GILLS_UK = "gills uk";

    static{
        GRAM_TO = new TreeMap<>();
        GRAM_TO.put(MG, 1000.0);
        GRAM_TO.put(GRAM, 1.0);
        GRAM_TO.put(KG, 0.001);
        GRAM_TO.put(TON, 0.000001);
        GRAM_TO.put(OZ, 0.03527396195);
        GRAM_TO.put(LB, 0.002204622622);
        GRAM_TO.put(ST, 0.000157473004);

        ML_TO = new TreeMap<>();
        ML_TO.put(ML, 1.0);
        ML_TO.put(L, 0.001);
        ML_TO.put(CU_IN, 0.0610237449);
        ML_TO.put(FL_OZ_LMP, 0.03519507973);
        ML_TO.put(PT_LMP, 0.001759753986);
        ML_TO.put(GAL_LMP, 0.000219969248);
        ML_TO.put(FL_OZ_US, 0.0338140227);
        ML_TO.put(GAL_US , 0.000264172052);
        ML_TO.put(CUP_US_TEA, 0.004226721332262564);
        ML_TO.put(CUP_CANADA, 0.004399472);
        ML_TO.put(CUP_METRIC, 0.004);
        ML_TO.put(TBSP_UK, 0.070390);
        ML_TO.put(TBSP_UK_2, 0.035195);
        ML_TO.put(TBSP_US, 0.067628);
        ML_TO.put(TBSP_US_2, 0.033814);
        ML_TO.put(TBSP_METRIC, 0.06666666666666667);
        ML_TO.put(TBSP_METRIC_2, 0.33333333333333333);
        ML_TO.put(TSP_UK, 0.28156);
        ML_TO.put(TSP_UK_2, 0.14078);
        ML_TO.put(TSP_US , 0.20288);
        ML_TO.put(TSP_US_2 , 0.10144);
        ML_TO.put(TSP_METRIC, 0.20000);
        ML_TO.put(TSP_METRIC_2, 0.10000);
        ML_TO.put(CUM_COFFEE_METRIC, 0.0066666666666666667);
        ML_TO.put(CUP_JAPAN, 0.005);
        ML_TO.put(PINTS_US, 0.002113376419);
        ML_TO.put(PINTS_UK,  0.0017598);
        ML_TO.put(QUARTS_US,  0.0010567);
        ML_TO.put(QUARTS_UK ,  0.00087988);
        ML_TO.put(GILLS_US,  0.0084535);
        ML_TO.put(GILLS_UK, 0.0070390);
    }
}
