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

.. java:import:: mmlib4j.models.svm.kernels Kernel

.. java:import:: mmlib4j.models.svm.kernels KernelFactory

SVR
===

.. java:package:: mmlib4j.models.svr
   :noindex:

.. java:type:: public class SVR implements Models

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

Methods
-------
load
^^^^

.. java:method:: public SVR load(String modelData)
   :outertype: SVR

load
^^^^

.. java:method:: public SVR load(JsonObject jsonObject)
   :outertype: SVR

predict
^^^^^^^

.. java:method:: public double predict(double[] data)
   :outertype: SVR

predict
^^^^^^^

.. java:method:: @Override public Matrix predict(Matrix x)
   :outertype: SVR

