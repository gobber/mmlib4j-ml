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

MulticlassSVC
=============

.. java:package:: mmlib4j.models.svm
   :noindex:

.. java:type:: public class MulticlassSVC extends SVC

Constructors
------------
MulticlassSVC
^^^^^^^^^^^^^

.. java:constructor:: public MulticlassSVC(JsonObject jsonObject)
   :outertype: MulticlassSVC

MulticlassSVC
^^^^^^^^^^^^^

.. java:constructor:: public MulticlassSVC(String modelData)
   :outertype: MulticlassSVC

Methods
-------
load
^^^^

.. java:method:: public MulticlassSVC load(JsonObject jsonObject)
   :outertype: MulticlassSVC

load
^^^^

.. java:method:: public MulticlassSVC load(String modelData)
   :outertype: MulticlassSVC

predict
^^^^^^^

.. java:method:: @Override public double predict(double[] data)
   :outertype: MulticlassSVC

predict
^^^^^^^

.. java:method:: @Override public Matrix predict(Matrix x)
   :outertype: MulticlassSVC

