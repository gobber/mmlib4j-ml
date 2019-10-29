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

LinearSVR
=========

.. java:package:: mmlib4j.models.svr
   :noindex:

.. java:type:: public class LinearSVR implements Models

Constructors
------------
LinearSVR
^^^^^^^^^

.. java:constructor:: public LinearSVR(JsonObject jsonObject)
   :outertype: LinearSVR

LinearSVR
^^^^^^^^^

.. java:constructor:: public LinearSVR(String modelData)
   :outertype: LinearSVR

Methods
-------
load
^^^^

.. java:method:: public LinearSVR load(JsonObject jsonObject)
   :outertype: LinearSVR

load
^^^^

.. java:method:: public LinearSVR load(String modelData)
   :outertype: LinearSVR

predict
^^^^^^^

.. java:method:: @Override public double predict(double[] data)
   :outertype: LinearSVR

predict
^^^^^^^

.. java:method:: @Override public Matrix predict(Matrix x)
   :outertype: LinearSVR

