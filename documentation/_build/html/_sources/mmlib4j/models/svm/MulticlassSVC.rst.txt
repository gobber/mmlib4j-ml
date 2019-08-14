.. java:import:: java.io File

.. java:import:: java.io FileNotFoundException

.. java:import:: java.util Scanner

.. java:import:: com.google.gson Gson

.. java:import:: com.google.gson JsonObject

.. java:import:: com.google.gson JsonParser

.. java:import:: mmlib4j.models.datastruct Matrix

.. java:import:: mmlib4j.models.preprocessing Scaler

.. java:import:: mmlib4j.models.svm.kernels Kernel

MulticlassSVC
=============

.. java:package:: mmlib4j.models.svm
   :noindex:

.. java:type:: public class MulticlassSVC<N> extends SVC<N>

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

MulticlassSVC
^^^^^^^^^^^^^

.. java:constructor:: public MulticlassSVC(Class<N> modelType)
   :outertype: MulticlassSVC

MulticlassSVC
^^^^^^^^^^^^^

.. java:constructor:: public MulticlassSVC(Class<N> modelType, JsonObject jsonObject)
   :outertype: MulticlassSVC

MulticlassSVC
^^^^^^^^^^^^^

.. java:constructor:: public MulticlassSVC(Class<N> modelType, String modelData)
   :outertype: MulticlassSVC

Methods
-------
load
^^^^

.. java:method:: @SuppressWarnings public MulticlassSVC<N> load(JsonObject jsonObject)
   :outertype: MulticlassSVC

load
^^^^

.. java:method:: public MulticlassSVC<N> load(String modelData)
   :outertype: MulticlassSVC

predict
^^^^^^^

.. java:method:: @Override public N predict(N data)
   :outertype: MulticlassSVC

predict
^^^^^^^

.. java:method:: @Override public Matrix<N> predict(Matrix<N> x)
   :outertype: MulticlassSVC

