.. java:import:: java.io File

.. java:import:: java.io FileNotFoundException

.. java:import:: java.util Scanner

.. java:import:: com.google.gson Gson

.. java:import:: com.google.gson JsonObject

.. java:import:: com.google.gson JsonParser

.. java:import:: mmlib4j.models Models

.. java:import:: mmlib4j.models.datastruct Matrix

.. java:import:: mmlib4j.models.preprocessing Scaler

.. java:import:: mmlib4j.models.svm.kernels Kernel

SVR
===

.. java:package:: mmlib4j.models.svr
   :noindex:

.. java:type:: public class SVR<N> extends Models<N>

Constructors
------------
SVR
^^^

.. java:constructor:: public SVR(JsonObject jsonObject)
   :outertype: SVR

SVR
^^^

.. java:constructor:: public SVR(String modelData)
   :outertype: SVR

SVR
^^^

.. java:constructor:: public SVR(Class<N> modelType)
   :outertype: SVR

SVR
^^^

.. java:constructor:: public SVR(Class<N> modelType, JsonObject jsonObject)
   :outertype: SVR

SVR
^^^

.. java:constructor:: public SVR(Class<N> modelType, String modelData)
   :outertype: SVR

Methods
-------
load
^^^^

.. java:method:: public SVR<N> load(String modelData)
   :outertype: SVR

load
^^^^

.. java:method:: @SuppressWarnings public SVR<N> load(JsonObject jsonObject)
   :outertype: SVR

predict
^^^^^^^

.. java:method:: public N predict(N data)
   :outertype: SVR

predict
^^^^^^^

.. java:method:: @Override public Matrix<N> predict(Matrix<N> x)
   :outertype: SVR

