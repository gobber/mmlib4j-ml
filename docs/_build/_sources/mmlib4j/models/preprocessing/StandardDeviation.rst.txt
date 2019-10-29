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

.. java:type:: public final class StandardDeviation implements Scaler

Constructors
------------
StandardDeviation
^^^^^^^^^^^^^^^^^

.. java:constructor:: public StandardDeviation()
   :outertype: StandardDeviation

StandardDeviation
^^^^^^^^^^^^^^^^^

.. java:constructor:: public StandardDeviation(String modelData)
   :outertype: StandardDeviation

StandardDeviation
^^^^^^^^^^^^^^^^^

.. java:constructor:: public StandardDeviation(JsonObject jsonObject)
   :outertype: StandardDeviation

StandardDeviation
^^^^^^^^^^^^^^^^^

.. java:constructor:: public StandardDeviation(Matrix std)
   :outertype: StandardDeviation

Methods
-------
load
^^^^

.. java:method:: public StandardDeviation load(String modelData)
   :outertype: StandardDeviation

load
^^^^

.. java:method:: public StandardDeviation load(JsonObject jsonObject)
   :outertype: StandardDeviation

normalize
^^^^^^^^^

.. java:method:: @Override public Matrix normalize(Matrix x)
   :outertype: StandardDeviation

