.. java:import:: java.io File

.. java:import:: java.io FileNotFoundException

.. java:import:: java.util Scanner

.. java:import:: com.google.gson Gson

.. java:import:: com.google.gson JsonObject

.. java:import:: com.google.gson JsonParser

.. java:import:: mmlib4j.models Models

.. java:import:: mmlib4j.models.datastruct Matrix

.. java:import:: mmlib4j.models.postprocessing PostProcessing

.. java:import:: mmlib4j.models.postprocessing PostProcessingBinary

.. java:import:: mmlib4j.models.postprocessing PostProcessingMulticlass

.. java:import:: mmlib4j.models.preprocessing Scaler

.. java:import:: mmlib4j.models.transfer Logistic

.. java:import:: mmlib4j.models.transfer Softmax

.. java:import:: mmlib4j.models.transfer Transfer

LogisticRegression
==================

.. java:package:: mmlib4j.models.linear
   :noindex:

.. java:type:: public class LogisticRegression<N> extends Models<N>

Constructors
------------
LogisticRegression
^^^^^^^^^^^^^^^^^^

.. java:constructor:: public LogisticRegression(JsonObject jsonObject)
   :outertype: LogisticRegression

LogisticRegression
^^^^^^^^^^^^^^^^^^

.. java:constructor:: public LogisticRegression(String modelData)
   :outertype: LogisticRegression

LogisticRegression
^^^^^^^^^^^^^^^^^^

.. java:constructor:: public LogisticRegression(Class<N> modelType)
   :outertype: LogisticRegression

LogisticRegression
^^^^^^^^^^^^^^^^^^

.. java:constructor:: public LogisticRegression(Class<N> modelType, String modelData)
   :outertype: LogisticRegression

LogisticRegression
^^^^^^^^^^^^^^^^^^

.. java:constructor:: public LogisticRegression(Class<N> modelType, JsonObject jsonObject)
   :outertype: LogisticRegression

Methods
-------
load
^^^^

.. java:method:: public LogisticRegression<N> load(String modelData)
   :outertype: LogisticRegression

load
^^^^

.. java:method:: @SuppressWarnings public LogisticRegression<N> load(JsonObject jsonObject)
   :outertype: LogisticRegression

predict
^^^^^^^

.. java:method:: public N predict(N data)
   :outertype: LogisticRegression

predict
^^^^^^^

.. java:method:: @Override public Matrix<N> predict(Matrix<N> x)
   :outertype: LogisticRegression

probability
^^^^^^^^^^^

.. java:method:: public Matrix<N> probability(Matrix<N> x)
   :outertype: LogisticRegression

