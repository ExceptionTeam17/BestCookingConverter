package com.exceptionteam17.bestcookingconverter.model

import java.util.*

object Consts {
    const val CUP_US_IN_ML = 236.59
    const val KG = "kg"
    const val GRAM = "g"
    const val MG = "mg"
    const val TON = "ton"
    const val OZ = "oz"
    const val LB = "lb"
    const val ST = "st"
    const val ML = "ml"
    const val L = "l"
    const val CU_IN = "cu in"
    const val FL_OZ_LMP = "fl oz lmp"
    const val PT_LMP = "pt lmp"
    const val GAL_LMP = "gal lmp"
    const val FL_OZ_US = "fl oz us"
    const val GAL_US = "gal us"
    const val CUP_US_TEA = "Cup  (us / tea cup)"
    const val CUP_CANADA = "Cup (canadian)"
    const val CUP_METRIC = "Cup (eu / metric)"
    const val TBSP_UK = "tbsp uk"
    const val TBSP_UK_2 = "tbsp uk 1/2"
    const val TBSP_US = "tbsp us"
    const val TBSP_US_2 = "tbsp us 1/2"
    const val TBSP_METRIC = "tbsp metric"
    const val TBSP_METRIC_2 = "tbsp metric 1/2"
    const val TSP_UK = "tsp uk"
    const val TSP_UK_2 = "tsp uk 1/2"
    const val TSP_US = "tsp us"
    const val TSP_US_2 = "tsp us 1/2"
    const val TSP_METRIC = "tsp metric"
    const val TSP_METRIC_2 = "tsp metric 1/2"
    const val CUM_COFFEE_METRIC = "cup coffee metric"
    const val CUP_JAPAN = "Cup (japanese)"
    const val PINTS_US = "pints us"
    const val PINTS_UK = "pints uk"
    const val QUARTS_US = "quarts us"
    const val QUARTS_UK = "quarts uk"
    const val GILLS_US = "gills us"
    const val GILLS_UK = "gills uk"

    val GRAM_TO: SortedMap<String, Double> = sortedMapOf(
        MG to 1000.0,
        GRAM to 1.0,
        KG to 0.001,
        TON to 0.000001,
        OZ to 0.03527396195,
        LB to 0.002204622622,
        ST to 0.000157473004
    )

    val ML_TO: SortedMap<String, Double> = sortedMapOf(
        ML to 1.0,
        L to 0.001,
        CU_IN to 0.0610237449,
        FL_OZ_LMP to 0.03519507973,
        PT_LMP to 0.001759753986,
        GAL_LMP to 0.000219969248,
        FL_OZ_US to 0.0338140227,
        GAL_US to 0.000264172052,
        CUP_US_TEA to 0.004226721332262564,
        CUP_CANADA to 0.004399472,
        CUP_METRIC to 0.004,
        TBSP_UK to 0.070390,
        TBSP_UK_2 to 0.035195,
        TBSP_US to 0.067628,
        TBSP_US_2 to 0.033814,
        TBSP_METRIC to 0.06666666666666667,
        TBSP_METRIC_2 to 0.33333333333333333,
        TSP_UK to 0.28156,
        TSP_UK_2 to 0.14078,
        TSP_US to 0.20288,
        TSP_US_2 to 0.10144,
        TSP_METRIC to 0.20000,
        TSP_METRIC_2 to 0.10000,
        CUM_COFFEE_METRIC to 0.0066666666666666667,
        CUP_JAPAN to 0.005,
        PINTS_US to 0.002113376419,
        PINTS_UK to 0.0017598,
        QUARTS_US to 0.0010567,
        QUARTS_UK to 0.00087988,
        GILLS_US to 0.0084535,
        GILLS_UK to 0.0070390
    )
}