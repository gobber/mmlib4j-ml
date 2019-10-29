.. java:import:: mmlib4j.models.datastruct Matrix

.. java:import:: mmlib4j.models.transfer Transfer

Layer
=====

.. java:package:: mmlib4j.models.neural_network
   :noindex:

.. java:type:: public class Layer

Constructors
------------
Layer
^^^^^

.. java:constructor:: public Layer(Transfer transfer, Matrix weigths, Matrix bias)
   :outertype: Layer

Layer
^^^^^

.. java:constructor:: public Layer(Transfer transfer)
   :outertype: Layer

Methods
-------
activate
^^^^^^^^

.. java:method:: public Matrix activate(Matrix matrix)
   :outertype: Layer

getBias
^^^^^^^

.. java:method:: public Matrix getBias()
   :outertype: Layer

getTransfer
^^^^^^^^^^^

.. java:method:: public Transfer getTransfer()
   :outertype: Layer

getWeigths
^^^^^^^^^^

.. java:method:: public Matrix getWeigths()
   :outertype: Layer

setBias
^^^^^^^

.. java:method:: public void setBias(Matrix bias)
   :outertype: Layer

setTransfer
^^^^^^^^^^^

.. java:method:: public void setTransfer(Transfer transfer)
   :outertype: Layer

setWeigths
^^^^^^^^^^

.. java:method:: public void setWeigths(Matrix weigths)
   :outertype: Layer

