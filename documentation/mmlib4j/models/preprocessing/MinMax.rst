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

.. java:type:: public class MinMax<N> extends Scaler<N>

   This class implements the min max normalization for the \ :java:ref:`Matrix`\  datastruct.

   :author: Charles Ferreira Gobber

   **See also:** :java:ref:`Scaler`, :java:ref:`Zscore`, :java:ref:`Matrix`

Constructors
------------
MinMax
^^^^^^

.. java:constructor:: public MinMax(Matrix<N> min, Matrix<N> max)
   :outertype: MinMax

MinMax
^^^^^^

.. java:constructor:: public MinMax()
   :outertype: MinMax

MinMax
^^^^^^

.. java:constructor:: public MinMax(Class<N> scalerType, String modelData)
   :outertype: MinMax

MinMax
^^^^^^

.. java:constructor:: public MinMax(Class<N> scalerType, JsonObject jsonObject)
   :outertype: MinMax

Methods
-------
load
^^^^

.. java:method:: public MinMax<N> load(String modelData)
   :outertype: MinMax

load
^^^^

.. java:method:: @SuppressWarnings public MinMax<N> load(JsonObject jsonObject)
   :outertype: MinMax

normalize
^^^^^^^^^

.. java:method:: public Matrix<N> normalize(Matrix<N> x)
   :outertype: MinMax

