.. java:import:: java.io File

.. java:import:: java.io FileNotFoundException

.. java:import:: java.util Scanner

.. java:import:: com.google.gson Gson

.. java:import:: com.google.gson JsonObject

.. java:import:: com.google.gson JsonParser

.. java:import:: mmlib4j.models.datastruct Matrix

MinMax
======

.. java:package:: mmlib4j.models.preprocessing
   :noindex:

.. java:type:: public class MinMax implements Scaler

   This class implements the min max normalization for the \ :java:ref:`Matrix`\  datastruct.

   :author: Charles Ferreira Gobber

   **See also:** :java:ref:`Scaler`, :java:ref:`Zscore`, :java:ref:`Matrix`

Constructors
------------
MinMax
^^^^^^

.. java:constructor:: public MinMax(Matrix min, Matrix max)
   :outertype: MinMax

MinMax
^^^^^^

.. java:constructor:: public MinMax()
   :outertype: MinMax

MinMax
^^^^^^

.. java:constructor:: public MinMax(String modelData)
   :outertype: MinMax

MinMax
^^^^^^

.. java:constructor:: public MinMax(JsonObject jsonObject)
   :outertype: MinMax

Methods
-------
load
^^^^

.. java:method:: public MinMax load(String modelData)
   :outertype: MinMax

load
^^^^

.. java:method:: public MinMax load(JsonObject jsonObject)
   :outertype: MinMax

normalize
^^^^^^^^^

.. java:method:: @Override public Matrix normalize(Matrix x)
   :outertype: MinMax

