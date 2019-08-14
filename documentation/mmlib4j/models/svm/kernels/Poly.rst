.. java:import:: mmlib4j.models.datastruct Matrix

Poly
====

.. java:package:: mmlib4j.models.svm.kernels
   :noindex:

.. java:type:: public class Poly<N> extends Kernel<N>

Constructors
------------
Poly
^^^^

.. java:constructor:: public Poly(Number gamma, Number degree, Number coef0)
   :outertype: Poly

Methods
-------
trick
^^^^^

.. java:method:: @Override public Matrix<N> trick(Matrix<N> x, Matrix<N> vectors)
   :outertype: Poly

