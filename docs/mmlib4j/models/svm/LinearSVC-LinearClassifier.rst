.. java:import:: java.io File

.. java:import:: java.io FileNotFoundException

.. java:import:: java.util Scanner

.. java:import:: com.google.gson Gson

.. java:import:: com.google.gson JsonObject

.. java:import:: com.google.gson JsonParser

.. java:import:: mmlib4j.models Models

.. java:import:: mmlib4j.models.datastruct Matrix

.. java:import:: mmlib4j.models.postprocessing PostProcessing

.. java:import:: mmlib4j.models.postprocessing PostProcessingLinear

.. java:import:: mmlib4j.models.postprocessing PostProcessingMulticlass

.. java:import:: mmlib4j.models.preprocessing Scaler

.. java:import:: mmlib4j.models.preprocessing ScalerFactory

LinearSVC.LinearClassifier
==========================

.. java:package:: mmlib4j.models.svm
   :noindex:

.. java:type:: public class LinearClassifier
   :outertype: LinearSVC

Fields
------
coefficients
^^^^^^^^^^^^

.. java:field::  double coefficients
   :outertype: LinearSVC.LinearClassifier

intercepts
^^^^^^^^^^

.. java:field::  double intercepts
   :outertype: LinearSVC.LinearClassifier

numColumnsC
^^^^^^^^^^^

.. java:field::  int numColumnsC
   :outertype: LinearSVC.LinearClassifier

numRowsC
^^^^^^^^

.. java:field::  int numRowsC
   :outertype: LinearSVC.LinearClassifier

