.. java:import:: com.github.fommil.netlib BLAS

SimpleBlas
==========

.. java:package:: mmlib4j.models.datastruct
   :noindex:

.. java:type:: public class SimpleBlas

   This class is a wrapper to some netlib BLAS methods.

   :author: Charles Ferreira Gobber

   **See also:** :java:ref:`BLAS`

Methods
-------
minus
^^^^^

.. java:method:: public static Matrix minus(Matrix A, Matrix B)
   :outertype: SimpleBlas

   This method perform summation between two matrix for double type. Let :math:`A` and :math:`B` two matrix. Thus, this operation performs:

   .. math:: A = A - B.

   Observation: This operation overwrites the matrix :math:`A`.

   :param A: A matrix of type double[].
   :param B: A matrix of type double[].
   :return: A matrix :math:`A = A - B`.

multAdd
^^^^^^^

.. java:method:: public static Matrix multAdd(double alpha, Matrix A, Matrix B, Matrix C)
   :outertype: SimpleBlas

   This method perform multiplication between two matrix for double type. Let :math:`A` and :math:`B` two matrix. Thus, this operation performs:

   .. math:: C=\alpha A * B + C

   where :math:`\alpha` is a scalar and :math:`C` the result matrix. Note that, if :math:`C` is a zero matrix and we set :math:`\alpha=1` then the we have :math:`C=A * B`.

   :param alpha: A float scalar.
   :param A: A matrix of type double[].
   :param B: A matrix of type double[].
   :param C: A matrix of type double[].
   :return: A matrix :math:`C=\alpha A * B + C`.

plus
^^^^

.. java:method:: public static Matrix plus(Matrix A, Matrix B)
   :outertype: SimpleBlas

   This method perform summation between two matrix for double type. Let :math:`A` and :math:`B` two matrix. Thus, this operation performs:

   .. math:: A = A + B

   Observation: This operation overwrites the matrix :math:`A`.

   :param A: A matrix of type double[].
   :param B: A matrix of type double[].
   :return: A matrix :math:`A = A + B`.

transABmultAdd
^^^^^^^^^^^^^^

.. java:method:: public static Matrix transABmultAdd(double alpha, Matrix A, Matrix B, Matrix C)
   :outertype: SimpleBlas

   This method perform multiplication between two matrix for double type. Let :math:`A` and :math:`B` two matrix. Thus, this operation performs:

   .. math:: C=\alpha A^T * B^T + C

   where :math:`\alpha` is a scalar and :math:`C` the result matrix. Note that, if :math:`C` is a zero matrix and we set :math:`\alpha=1` then the we have :math:`C=A^T * B^T`.

   :param alpha: A float scalar.
   :param A: A matrix of type double[].
   :param B: A matrix of type double[].
   :param C: A matrix of type double[].
   :return: A matrix :math:`C=\alpha A^T * B^T + C`.

transAmultAdd
^^^^^^^^^^^^^

.. java:method:: public static Matrix transAmultAdd(double alpha, Matrix A, Matrix B, Matrix C)
   :outertype: SimpleBlas

   This method perform multiplication between two matrix for double type. Let :math:`A` and :math:`B` two matrix. Thus, this operation performs:

   .. math:: C=\alpha A^T * B + C

   where :math:`\alpha` is a scalar and :math:`C` the result matrix. Note that, if :math:`C` is a zero matrix and we set :math:`\alpha=1` then the we have :math:`C=A^T * B`.

   :param alpha: A float scalar.
   :param A: A matrix of type double[].
   :param B: A matrix of type double[].
   :param C: A matrix of type double[].
   :return: A matrix :math:`C=\alpha A^T * B + C`.

transBmultAdd
^^^^^^^^^^^^^

.. java:method:: public static Matrix transBmultAdd(double alpha, Matrix A, Matrix B, Matrix C)
   :outertype: SimpleBlas

   This method perform multiplication between two matrix for double type. Let :math:`A` and :math:`B` two matrix. Thus, this operation performs:

   .. math:: C=\alpha A * B^T + C

   where :math:`\alpha` is a scalar and :math:`C` the result matrix. Note that, if :math:`C` is a zero matrix and we set :math:`\alpha=1` then the we have :math:`C=A * B^T`.

   :param alpha: A float scalar.
   :param A: A matrix of type double[].
   :param B: A matrix of type double[].
   :param C: A matrix of type double[].
   :return: A matrix :math:`C=\alpha A * B^T + C`.

