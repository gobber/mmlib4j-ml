.. java:import:: java.io File

.. java:import:: java.io FileNotFoundException

.. java:import:: java.security InvalidParameterException

.. java:import:: java.util Scanner

.. java:import:: com.google.gson JsonObject

.. java:import:: com.google.gson JsonParser

.. java:import:: mmlib4j.models.linear LinearRegression

.. java:import:: mmlib4j.models.linear LogisticRegression

.. java:import:: mmlib4j.models.neural_network MLP

.. java:import:: mmlib4j.models.svm LinearSVC

.. java:import:: mmlib4j.models.svm SVC

.. java:import:: mmlib4j.models.svr LinearSVR

ModelsFactory
=============

.. java:package:: mmlib4j.models
   :noindex:

.. java:type:: public class ModelsFactory

Methods
-------
create
^^^^^^

.. java:method:: public static Models create(String modelData)
   :outertype: ModelsFactory

create
^^^^^^

.. java:method:: public static Models create(JsonObject jsonObject)
   :outertype: ModelsFactory

