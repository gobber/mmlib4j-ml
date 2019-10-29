.. java:import:: java.io File

.. java:import:: java.io FileNotFoundException

.. java:import:: java.util Scanner

.. java:import:: com.google.gson Gson

.. java:import:: com.google.gson JsonObject

.. java:import:: com.google.gson JsonParser

.. java:import:: mmlib4j.models Models

.. java:import:: mmlib4j.models.datastruct Matrix

.. java:import:: mmlib4j.models.preprocessing Scaler

.. java:import:: mmlib4j.models.preprocessing ScalerFactory

LinearRegression
================

.. java:package:: mmlib4j.models.linear
   :noindex:

.. java:type:: public class LinearRegression implements Models

Constructors
------------
LinearRegression
^^^^^^^^^^^^^^^^

.. java:constructor:: public LinearRegression(JsonObject jsonObject)
   :outertype: LinearRegression

LinearRegression
^^^^^^^^^^^^^^^^

.. java:constructor:: public LinearRegression(String modelData)
   :outertype: LinearRegression

Methods
-------
load
^^^^

.. java:method:: public LinearRegression load(String modelData)
   :outertype: LinearRegression

load
^^^^

.. java:method:: public LinearRegression load(JsonObject jsonObject)
   :outertype: LinearRegression

predict
^^^^^^^

.. java:method:: @Override public double predict(double[] data)
   :outertype: LinearRegression

predict
^^^^^^^

.. java:method:: @Override public Matrix predict(Matrix x)
   :outertype: LinearRegression

