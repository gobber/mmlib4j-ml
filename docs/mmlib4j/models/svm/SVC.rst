.. java:import:: java.io File

.. java:import:: java.io FileNotFoundException

.. java:import:: java.util Scanner

.. java:import:: com.google.gson JsonObject

.. java:import:: com.google.gson JsonParser

.. java:import:: mmlib4j.models Models

.. java:import:: mmlib4j.models.datastruct Matrix

SVC
===

.. java:package:: mmlib4j.models.svm
   :noindex:

.. java:type:: public class SVC implements Models

Constructors
------------
SVC
^^^

.. java:constructor::  SVC()
   :outertype: SVC

SVC
^^^

.. java:constructor:: public SVC(JsonObject jsonObject)
   :outertype: SVC

SVC
^^^

.. java:constructor:: public SVC(String modelData)
   :outertype: SVC

Methods
-------
load
^^^^

.. java:method:: public SVC load(String modelData)
   :outertype: SVC

load
^^^^

.. java:method:: public SVC load(JsonObject jsonObject)
   :outertype: SVC

predict
^^^^^^^

.. java:method:: public double predict(double[] data)
   :outertype: SVC

predict
^^^^^^^

.. java:method:: @Override public Matrix predict(Matrix x)
   :outertype: SVC

