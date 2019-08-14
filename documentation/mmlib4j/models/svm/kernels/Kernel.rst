.. java:import:: mmlib4j.models.datastruct Matrix

Kernel
======

.. java:package:: mmlib4j.models.svm.kernels
   :noindex:

.. java:type:: public class Kernel<N>

Constructors
------------
Kernel
^^^^^^

.. java:constructor:: public Kernel()
   :outertype: Kernel

Kernel
^^^^^^

.. java:constructor:: public Kernel(String KernelType, Number gamma, Number degree, Number coef0)
   :outertype: Kernel

Methods
-------
trick
^^^^^

.. java:method:: public Matrix<N> trick(Matrix<N> x, Matrix<N> vectors)
   :outertype: Kernel

