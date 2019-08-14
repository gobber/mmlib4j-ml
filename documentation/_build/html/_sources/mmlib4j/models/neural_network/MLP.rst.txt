.. java:import:: java.io File

.. java:import:: java.io FileNotFoundException

.. java:import:: java.util ArrayList

.. java:import:: java.util Scanner

.. java:import:: com.google.gson Gson

.. java:import:: com.google.gson JsonObject

.. java:import:: com.google.gson JsonParser

.. java:import:: mmlib4j.models Models

.. java:import:: mmlib4j.models.datastruct Matrix

.. java:import:: mmlib4j.models.neural_network Layer

.. java:import:: mmlib4j.models.neural_network Network

.. java:import:: mmlib4j.models.neural_network NetworkFloat32

.. java:import:: mmlib4j.models.neural_network NetworkFloat64

.. java:import:: mmlib4j.models.postprocessing PostProcessing

.. java:import:: mmlib4j.models.postprocessing PostProcessingBinary

.. java:import:: mmlib4j.models.postprocessing PostProcessingIdentity

.. java:import:: mmlib4j.models.postprocessing PostProcessingMulticlass

.. java:import:: mmlib4j.models.preprocessing Scaler

.. java:import:: mmlib4j.models.transfer Transfer

MLP
===

.. java:package:: mmlib4j.models.neural_network
   :noindex:

.. java:type:: public class MLP<N> extends Models<N>

Constructors
------------
MLP
^^^

.. java:constructor:: public MLP(JsonObject jsonObject)
   :outertype: MLP

MLP
^^^

.. java:constructor:: public MLP(String modelData)
   :outertype: MLP

MLP
^^^

.. java:constructor:: public MLP(Class<N> modelType)
   :outertype: MLP

MLP
^^^

.. java:constructor:: public MLP(Class<N> modelType, String modelData)
   :outertype: MLP

MLP
^^^

.. java:constructor:: public MLP(Class<N> modelType, JsonObject jsonObject)
   :outertype: MLP

Methods
-------
load
^^^^

.. java:method:: public MLP<N> load(String modelData)
   :outertype: MLP

load
^^^^

.. java:method:: @SuppressWarnings public MLP<N> load(JsonObject jsonObject)
   :outertype: MLP

predict
^^^^^^^

.. java:method:: public N predict(N data)
   :outertype: MLP

predict
^^^^^^^

.. java:method:: @Override public Matrix<N> predict(Matrix<N> x)
   :outertype: MLP

