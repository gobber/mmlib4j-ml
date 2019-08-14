.. java:import:: mmlib4j.models.datastruct Matrix

Sigmoid
=======

.. java:package:: mmlib4j.models.svm.kernels
   :noindex:

.. java:type:: public class Sigmoid<N> extends Kernel<N>

Constructors
------------
Sigmoid
^^^^^^^

.. java:constructor:: public Sigmoid(Number gamma, Number coef0)
   :outertype: Sigmoid

Methods
-------
trick
^^^^^

.. java:method:: @Override public Matrix<N> trick(Matrix<N> x, Matrix<N> vectors)
   :outertype: Sigmoid

