.. java:import:: java.io File

.. java:import:: java.io FileNotFoundException

.. java:import:: java.util LinkedList

.. java:import:: java.util Scanner

.. java:import:: com.google.gson Gson

.. java:import:: com.google.gson JsonObject

.. java:import:: com.google.gson JsonParser

.. java:import:: mmlib4j.models Models

.. java:import:: mmlib4j.models.datastruct Matrix

.. java:import:: mmlib4j.models.neural_network Layer

.. java:import:: mmlib4j.models.postprocessing PostProcessing

.. java:import:: mmlib4j.models.postprocessing PostProcessingBinary

.. java:import:: mmlib4j.models.postprocessing PostProcessingIdentity

.. java:import:: mmlib4j.models.postprocessing PostProcessingMulticlass

.. java:import:: mmlib4j.models.preprocessing Scaler

.. java:import:: mmlib4j.models.preprocessing ScalerFactory

.. java:import:: mmlib4j.models.transfer TransferFactory

MLP
===

.. java:package:: mmlib4j.models.neural_network
   :noindex:

.. java:type:: public class MLP implements Models

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

Methods
-------
load
^^^^

.. java:method:: public MLP load(String modelData)
   :outertype: MLP

load
^^^^

.. java:method:: public MLP load(JsonObject jsonObject)
   :outertype: MLP

predict
^^^^^^^

.. java:method:: public double predict(double[] data)
   :outertype: MLP

predict
^^^^^^^

.. java:method:: @Override public Matrix predict(Matrix x)
   :outertype: MLP

