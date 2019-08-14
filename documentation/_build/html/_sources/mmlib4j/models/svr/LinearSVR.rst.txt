.. java:import:: java.io File

.. java:import:: java.io FileNotFoundException

.. java:import:: java.util Scanner

.. java:import:: com.google.gson Gson

.. java:import:: com.google.gson JsonObject

.. java:import:: com.google.gson JsonParser

.. java:import:: mmlib4j.models Models

.. java:import:: mmlib4j.models.datastruct Matrix

.. java:import:: mmlib4j.models.preprocessing Scaler

LinearSVR
=========

.. java:package:: mmlib4j.models.svr
   :noindex:

.. java:type:: public class LinearSVR<N> extends Models<N>

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

LinearSVR
^^^^^^^^^

.. java:constructor:: public LinearSVR(Class<N> modelType)
   :outertype: LinearSVR

LinearSVR
^^^^^^^^^

.. java:constructor:: public LinearSVR(Class<N> modelType, String modelData)
   :outertype: LinearSVR

LinearSVR
^^^^^^^^^

.. java:constructor:: public LinearSVR(Class<N> modelType, JsonObject jsonObject)
   :outertype: LinearSVR

Methods
-------
load
^^^^

.. java:method:: @SuppressWarnings public LinearSVR<N> load(JsonObject jsonObject)
   :outertype: LinearSVR

load
^^^^

.. java:method:: public LinearSVR<N> load(String modelData)
   :outertype: LinearSVR

predict
^^^^^^^

.. java:method:: public N predict(N data)
   :outertype: LinearSVR

predict
^^^^^^^

.. java:method:: @Override public Matrix<N> predict(Matrix<N> x)
   :outertype: LinearSVR

