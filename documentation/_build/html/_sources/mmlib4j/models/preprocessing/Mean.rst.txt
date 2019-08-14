.. java:import:: java.io File

.. java:import:: java.io FileNotFoundException

.. java:import:: java.util Scanner

.. java:import:: com.google.gson Gson

.. java:import:: com.google.gson JsonObject

.. java:import:: com.google.gson JsonParser

.. java:import:: mmlib4j.models.datastruct Matrix

Mean
====

.. java:package:: mmlib4j.models.preprocessing
   :noindex:

.. java:type:: public class Mean<N> extends Scaler<N>

Constructors
------------
Mean
^^^^

.. java:constructor:: public Mean()
   :outertype: Mean

Mean
^^^^

.. java:constructor:: public Mean(Class<N> scalerType, String modelData)
   :outertype: Mean

Mean
^^^^

.. java:constructor:: public Mean(Class<N> scalerType, JsonObject jsonObject)
   :outertype: Mean

Mean
^^^^

.. java:constructor:: public Mean(Matrix<N> mean)
   :outertype: Mean

Methods
-------
load
^^^^

.. java:method:: public Mean<N> load(String modelData)
   :outertype: Mean

load
^^^^

.. java:method:: @SuppressWarnings public Mean<N> load(JsonObject jsonObject)
   :outertype: Mean

normalize
^^^^^^^^^

.. java:method:: @Override public Matrix<N> normalize(Matrix<N> x)
   :outertype: Mean

