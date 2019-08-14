.. java:import:: java.io File

.. java:import:: java.io FileNotFoundException

.. java:import:: java.security InvalidParameterException

.. java:import:: java.util Scanner

.. java:import:: com.google.gson JsonObject

.. java:import:: com.google.gson JsonParser

.. java:import:: mmlib4j.models.datastruct Matrix

.. java:import:: mmlib4j.models.linear LinearRegression

.. java:import:: mmlib4j.models.linear LogisticRegression

.. java:import:: mmlib4j.models.neural_network MLP

.. java:import:: mmlib4j.models.svm LinearSVC

.. java:import:: mmlib4j.models.svm SVC

.. java:import:: mmlib4j.models.svr LinearSVR

Models
======

.. java:package:: mmlib4j.models
   :noindex:

.. java:type:: public class Models<N>

Constructors
------------
Models
^^^^^^

.. java:constructor:: protected Models()
   :outertype: Models

Models
^^^^^^

.. java:constructor:: public Models(JsonObject jsonObject)
   :outertype: Models

Models
^^^^^^

.. java:constructor:: public Models(String modelData)
   :outertype: Models

Models
^^^^^^

.. java:constructor:: public Models(Class<N> modelType)
   :outertype: Models

Models
^^^^^^

.. java:constructor:: public Models(Class<N> modelType, JsonObject jsonObject)
   :outertype: Models

Models
^^^^^^

.. java:constructor:: public Models(Class<N> modelType, String modelData)
   :outertype: Models

Methods
-------
load
^^^^

.. java:method:: public Models<N> load(JsonObject jsonObject)
   :outertype: Models

load
^^^^

.. java:method:: public Models<N> load(String modelData)
   :outertype: Models

predict
^^^^^^^

.. java:method:: public N predict(N data)
   :outertype: Models

predict
^^^^^^^

.. java:method:: public Matrix<N> predict(Matrix<N> x)
   :outertype: Models

