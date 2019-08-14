.. java:import:: java.io File

.. java:import:: java.io FileNotFoundException

.. java:import:: java.util Scanner

.. java:import:: com.google.gson Gson

.. java:import:: com.google.gson JsonObject

.. java:import:: com.google.gson JsonParser

.. java:import:: mmlib4j.models Models

.. java:import:: mmlib4j.models.datastruct Matrix

.. java:import:: mmlib4j.models.preprocessing Scaler

LinearRegression
================

.. java:package:: mmlib4j.models.linear
   :noindex:

.. java:type:: public class LinearRegression<N> extends Models<N>

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

LinearRegression
^^^^^^^^^^^^^^^^

.. java:constructor:: public LinearRegression(Class<N> modelType)
   :outertype: LinearRegression

LinearRegression
^^^^^^^^^^^^^^^^

.. java:constructor:: public LinearRegression(Class<N> modelType, JsonObject jsonObject)
   :outertype: LinearRegression

LinearRegression
^^^^^^^^^^^^^^^^

.. java:constructor:: public LinearRegression(Class<N> modelType, String modelData)
   :outertype: LinearRegression

Methods
-------
load
^^^^

.. java:method:: public LinearRegression<N> load(String modelData)
   :outertype: LinearRegression

load
^^^^

.. java:method:: @SuppressWarnings public LinearRegression<N> load(JsonObject jsonObject)
   :outertype: LinearRegression

predict
^^^^^^^

.. java:method:: public N predict(N data)
   :outertype: LinearRegression

predict
^^^^^^^

.. java:method:: public Matrix<N> predict(Matrix<N> x)
   :outertype: LinearRegression

