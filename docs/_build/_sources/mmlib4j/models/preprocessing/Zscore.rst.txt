.. java:import:: java.io File

.. java:import:: java.io FileNotFoundException

.. java:import:: java.util Scanner

.. java:import:: com.google.gson Gson

.. java:import:: com.google.gson JsonObject

.. java:import:: com.google.gson JsonParser

.. java:import:: mmlib4j.models.datastruct Matrix

Zscore
======

.. java:package:: mmlib4j.models.preprocessing
   :noindex:

.. java:type:: public class Zscore implements Scaler

   This class implements the zscore normalization for the \ :java:ref:`MatrixOld`\  datastruct.

   :author: Charles Ferreira Gobber

   **See also:** :java:ref:`Scaler`, :java:ref:`Zscore`, :java:ref:`MatrixOld`

Constructors
------------
Zscore
^^^^^^

.. java:constructor:: public Zscore()
   :outertype: Zscore

Zscore
^^^^^^

.. java:constructor:: public Zscore(String modelData)
   :outertype: Zscore

Zscore
^^^^^^

.. java:constructor:: public Zscore(JsonObject jsonObject)
   :outertype: Zscore

Zscore
^^^^^^

.. java:constructor:: public Zscore(Matrix mean, Matrix std)
   :outertype: Zscore

Methods
-------
load
^^^^

.. java:method:: public Zscore load(String modelData)
   :outertype: Zscore

load
^^^^

.. java:method:: public Zscore load(JsonObject jsonObject)
   :outertype: Zscore

normalize
^^^^^^^^^

.. java:method:: @Override public Matrix normalize(Matrix x)
   :outertype: Zscore

