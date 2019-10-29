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

LinearSVC
=========

.. java:package:: mmlib4j.models.svm
   :noindex:

.. java:type:: public class LinearSVC implements Models

Constructors
------------
LinearSVC
^^^^^^^^^

.. java:constructor:: public LinearSVC(JsonObject jsonObject)
   :outertype: LinearSVC

LinearSVC
^^^^^^^^^

.. java:constructor:: public LinearSVC(String modelData)
   :outertype: LinearSVC

Methods
-------
load
^^^^

.. java:method:: public LinearSVC load(JsonObject jsonObject)
   :outertype: LinearSVC

load
^^^^

.. java:method:: public LinearSVC load(String modelData)
   :outertype: LinearSVC

predict
^^^^^^^

.. java:method:: public double predict(double[] data)
   :outertype: LinearSVC

predict
^^^^^^^

.. java:method:: @Override public Matrix predict(Matrix x)
   :outertype: LinearSVC

