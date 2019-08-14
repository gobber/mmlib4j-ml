.. java:import:: mmlib4j.models.datastruct Matrix

.. java:import:: mmlib4j.models.transfer Transfer

Layer
=====

.. java:package:: mmlib4j.models.neural_network
   :noindex:

.. java:type:: public class Layer<N>

Constructors
------------
Layer
^^^^^

.. java:constructor:: public Layer(Transfer<N> transfer, Matrix<N> weigths, Matrix<N> bias)
   :outertype: Layer

Layer
^^^^^

.. java:constructor:: public Layer(Transfer<N> transfer)
   :outertype: Layer

Methods
-------
activate
^^^^^^^^

.. java:method:: public Matrix<N> activate(Matrix<N> matrix)
   :outertype: Layer

getBias
^^^^^^^

.. java:method:: public Matrix<N> getBias()
   :outertype: Layer

getTransfer
^^^^^^^^^^^

.. java:method:: public Transfer<N> getTransfer()
   :outertype: Layer

getWeigths
^^^^^^^^^^

.. java:method:: public Matrix<N> getWeigths()
   :outertype: Layer

setBias
^^^^^^^

.. java:method:: public void setBias(Matrix<N> bias)
   :outertype: Layer

setTransfer
^^^^^^^^^^^

.. java:method:: public void setTransfer(Transfer<N> transfer)
   :outertype: Layer

setWeigths
^^^^^^^^^^

.. java:method:: public void setWeigths(Matrix<N> weigths)
   :outertype: Layer

