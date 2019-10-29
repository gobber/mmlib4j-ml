.. java:import:: com.google.gson JsonObject

.. java:import:: mmlib4j.models.datastruct Matrix

Models
======

.. java:package:: mmlib4j.models
   :noindex:

.. java:type:: public interface Models

Methods
-------
load
^^^^

.. java:method:: public Models load(String modelData)
   :outertype: Models

load
^^^^

.. java:method:: public Models load(JsonObject jsonObject)
   :outertype: Models

predict
^^^^^^^

.. java:method:: public double predict(double[] data)
   :outertype: Models

predict
^^^^^^^

.. java:method:: public Matrix predict(Matrix x)
   :outertype: Models

