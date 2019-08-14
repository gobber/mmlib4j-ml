.. java:import:: java.io File

.. java:import:: java.io FileNotFoundException

.. java:import:: java.util Scanner

.. java:import:: com.google.gson Gson

.. java:import:: com.google.gson JsonObject

.. java:import:: com.google.gson JsonParser

.. java:import:: mmlib4j.models.datastruct Matrix

StandardDeviation
=================

.. java:package:: mmlib4j.models.preprocessing
   :noindex:

.. java:type:: public final class StandardDeviation<N> extends Scaler<N>

Constructors
------------
StandardDeviation
^^^^^^^^^^^^^^^^^

.. java:constructor:: public StandardDeviation()
   :outertype: StandardDeviation

StandardDeviation
^^^^^^^^^^^^^^^^^

.. java:constructor:: public StandardDeviation(Class<N> scalerType, String modelData)
   :outertype: StandardDeviation

StandardDeviation
^^^^^^^^^^^^^^^^^

.. java:constructor:: public StandardDeviation(Class<N> scalerType, JsonObject jsonObject)
   :outertype: StandardDeviation

StandardDeviation
^^^^^^^^^^^^^^^^^

.. java:constructor:: public StandardDeviation(Matrix<N> std)
   :outertype: StandardDeviation

Methods
-------
load
^^^^

.. java:method:: public StandardDeviation<N> load(String modelData)
   :outertype: StandardDeviation

load
^^^^

.. java:method:: @SuppressWarnings public StandardDeviation<N> load(JsonObject jsonObject)
   :outertype: StandardDeviation

normalize
^^^^^^^^^

.. java:method:: public Matrix<N> normalize(Matrix<N> x)
   :outertype: StandardDeviation

