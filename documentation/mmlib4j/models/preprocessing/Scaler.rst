.. java:import:: java.io File

.. java:import:: java.io FileNotFoundException

.. java:import:: java.util Scanner

.. java:import:: com.google.gson JsonObject

.. java:import:: com.google.gson JsonParser

.. java:import:: mmlib4j.models.datastruct Matrix

Scaler
======

.. java:package:: mmlib4j.models.preprocessing
   :noindex:

.. java:type:: public class Scaler<N>

   This class is a model to normalization classes for the \ :java:ref:`Matrix`\  datastruct.

   :author: Charles Ferreira Gobber

   **See also:** :java:ref:`MinMax`, :java:ref:`Zscore`, :java:ref:`Matrix`

Constructors
------------
Scaler
^^^^^^

.. java:constructor::  Scaler()
   :outertype: Scaler

Scaler
^^^^^^

.. java:constructor:: public Scaler(Class<N> scalerType, String modelData)
   :outertype: Scaler

Scaler
^^^^^^

.. java:constructor:: public Scaler(Class<N> scalerType, JsonObject jsonObject)
   :outertype: Scaler

Methods
-------
load
^^^^

.. java:method:: public Scaler<N> load(String modelData)
   :outertype: Scaler

load
^^^^

.. java:method:: public Scaler<N> load(JsonObject jsonObject)
   :outertype: Scaler

normalize
^^^^^^^^^

.. java:method:: public Matrix<N> normalize(Matrix<N> A)
   :outertype: Scaler

