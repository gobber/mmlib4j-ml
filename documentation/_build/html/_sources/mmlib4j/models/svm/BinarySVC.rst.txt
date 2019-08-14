.. java:import:: java.io File

.. java:import:: java.io FileNotFoundException

.. java:import:: java.util Scanner

.. java:import:: com.google.gson Gson

.. java:import:: com.google.gson JsonObject

.. java:import:: com.google.gson JsonParser

.. java:import:: mmlib4j.models.datastruct Matrix

.. java:import:: mmlib4j.models.preprocessing Scaler

.. java:import:: mmlib4j.models.svm.kernels Kernel

BinarySVC
=========

.. java:package:: mmlib4j.models.svm
   :noindex:

.. java:type:: public final class BinarySVC<N> extends SVC<N>

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

BinarySVC
^^^^^^^^^

.. java:constructor:: public BinarySVC(Class<N> modelType)
   :outertype: BinarySVC

BinarySVC
^^^^^^^^^

.. java:constructor:: public BinarySVC(Class<N> modelType, JsonObject jsonObject)
   :outertype: BinarySVC

BinarySVC
^^^^^^^^^

.. java:constructor:: public BinarySVC(Class<N> modelType, String modelData)
   :outertype: BinarySVC

Methods
-------
load
^^^^

.. java:method:: public BinarySVC<N> load(String modelData)
   :outertype: BinarySVC

load
^^^^

.. java:method:: @SuppressWarnings public BinarySVC<N> load(JsonObject jsonObject)
   :outertype: BinarySVC

predict
^^^^^^^

.. java:method:: public N predict(N data)
   :outertype: BinarySVC

predict
^^^^^^^

.. java:method:: @Override public Matrix<N> predict(Matrix<N> x)
   :outertype: BinarySVC

