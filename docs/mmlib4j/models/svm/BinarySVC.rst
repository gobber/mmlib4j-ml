.. java:import:: java.io File

.. java:import:: java.io FileNotFoundException

.. java:import:: java.util Scanner

.. java:import:: com.google.gson Gson

.. java:import:: com.google.gson JsonObject

.. java:import:: com.google.gson JsonParser

.. java:import:: mmlib4j.models.datastruct Matrix

.. java:import:: mmlib4j.models.preprocessing Scaler

.. java:import:: mmlib4j.models.preprocessing ScalerFactory

.. java:import:: mmlib4j.models.svm.kernels Kernel

.. java:import:: mmlib4j.models.svm.kernels KernelFactory

BinarySVC
=========

.. java:package:: mmlib4j.models.svm
   :noindex:

.. java:type:: public final class BinarySVC extends SVC

Constructors
------------
BinarySVC
^^^^^^^^^

.. java:constructor:: public BinarySVC(JsonObject jsonObject)
   :outertype: BinarySVC

BinarySVC
^^^^^^^^^

.. java:constructor:: public BinarySVC(String modelData)
   :outertype: BinarySVC

Methods
-------
load
^^^^

.. java:method:: public BinarySVC load(String modelData)
   :outertype: BinarySVC

load
^^^^

.. java:method:: public BinarySVC load(JsonObject jsonObject)
   :outertype: BinarySVC

predict
^^^^^^^

.. java:method:: public double predict(double[] data)
   :outertype: BinarySVC

predict
^^^^^^^

.. java:method:: @Override public Matrix predict(Matrix x)
   :outertype: BinarySVC

