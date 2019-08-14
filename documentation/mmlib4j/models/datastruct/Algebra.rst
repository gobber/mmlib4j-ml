.. java:import:: com.github.fommil.netlib BLAS

Algebra
=======

.. java:package:: mmlib4j.models.datastruct
   :noindex:

.. java:type:: public class Algebra

   This class is a wrapper to some netlib BLAS methods.

   :author: Charles Ferreira Gobber

   **See also:** :java:ref:`AbstractMatrix`, :java:ref:`Float32`, :java:ref:`Float64`, :java:ref:`BLAS`

Methods
-------
dminus
^^^^^^

.. java:method:: public static Matrix<double[]> dminus(int size, Matrix<double[]> A, Matrix<double[]> B)
   :outertype: Algebra

   This method perform summation between two matrix for double type. Let :math:`A` and :math:`B` two matrix. Thus, this operation performs:

   .. math:: A = A - B.

   Observation: This operation overwrites the matrix :math:`A`.

   :param size: Size matrix (rows x columns).
   :param A: A matrix of type double[].
   :param B: A matrix of type double[].
   :return: A matrix :math:`A = A - B`.

dplus
^^^^^

.. java:method:: public static Matrix<double[]> dplus(int size, Matrix<double[]> A, Matrix<double[]> B)
   :outertype: Algebra

   This method perform summation between two matrix for double type. Let :math:`A` and :math:`B` two matrix. Thus, this operation performs:

   .. math:: A = A + B

   Observation: This operation overwrites the matrix :math:`A`.

   :param size: Size matrix (rows x columns).
   :param A: A matrix of type double[].
   :param B: A matrix of type double[].
   :return: A matrix :math:`A = A + B`.

fminus
^^^^^^

.. java:method:: public static Matrix<float[]> fminus(int size, Matrix<float[]> A, Matrix<float[]> B)
   :outertype: Algebra

   This method perform summation between two matrix for float type. Let :math:`A` and :math:`B` two matrix. Thus, this operation performs:

   .. math:: A = A - B.

   Observation: This operation overwrites the matrix :math:`A`.

   :param size: Size matrix (rows x columns).
   :param A: A matrix of type float[].
   :param B: A matrix of type float[].
   :return: A matrix :math:`A = A - B`.

fplus
^^^^^

.. java:method:: public static Matrix<float[]> fplus(int size, Matrix<float[]> A, Matrix<float[]> B)
   :outertype: Algebra

   This method perform summation between two matrix for float type. Let :math:`A` and :math:`B` two matrix. Thus, this operation performs:

   .. math:: A = A + B

   Observation: This operation overwrites the matrix :math:`A`.

   :param size: Size matrix (rows x columns).
   :param A: A matrix of type float[].
   :param B: A matrix of type float[].
   :return: A matrix :math:`A = A + B`.

multAdd
^^^^^^^

.. java:method:: public static Matrix<float[]> multAdd(float alpha, Matrix<float[]> A, Matrix<float[]> B, Matrix<float[]> C)
   :outertype: Algebra

   This method perform multiplication between two matrix for float type. Let :math:`A` and :math:`B` two matrix. Thus, this operation performs:

   .. math:: C=\alpha A * B + C

   where :math:`\alpha` is a scalar and `C` the result matrix. Note that, if :math:`C` is a zero matrix and we set :math:`\alpha=1` then the we have :math:`C=A * B`.

   :param alpha: A float scalar.
   :param A: A matrix of type float[].
   :param B: A matrix of type float[].
   :param C: A matrix of type float[].
   :return: A matrix :math:`C=\alpha A * B + C`.

multAdd
^^^^^^^

.. java:method:: public static Matrix<double[]> multAdd(double alpha, Matrix<double[]> A, Matrix<double[]> B, Matrix<double[]> C)
   :outertype: Algebra

   This method perform multiplication between two matrix for double type. Let :math:`A` and :math:`B` two matrix. Thus, this operation performs:

   .. math:: C=\alpha A * B + C

   where :math:`\alpha` is a scalar and `C` the result matrix. Note that, if :math:`C` is a zero matrix and we set :math:`\alpha=1` then the we have :math:`C=A * B`.

   :param alpha: A float scalar.
   :param A: A matrix of type double[].
   :param B: A matrix of type double[].
   :param C: A matrix of type double[].
   :return: A matrix :math:`C=\alpha A * B + C`.

transABmultAdd
^^^^^^^^^^^^^^

.. java:method:: public static Matrix<float[]> transABmultAdd(float alpha, Matrix<float[]> A, Matrix<float[]> B, Matrix<float[]> C)
   :outertype: Algebra

   This method perform multiplication between two matrix for float type. Let :math:`A` and :math:`B` two matrix. Thus, this operation performs:

   .. math:: C=\alpha A^T * B^T + C

   where :math:`\alpha` is a scalar and `C` the result matrix. Note that, if :math:`C` is a zero matrix and we set :math:`\alpha=1` then the we have :math:`C=A^T * B^T`.

   :param alpha: A float scalar.
   :param A: A matrix of type float[].
   :param B: A matrix of type float[].
   :param C: A matrix of type float[].
   :return: A matrix :math:`C=\alpha A^T * B^T + C`.

transABmultAdd
^^^^^^^^^^^^^^

.. java:method:: public static Matrix<double[]> transABmultAdd(double alpha, Matrix<double[]> A, Matrix<double[]> B, Matrix<double[]> C)
   :outertype: Algebra

   This method perform multiplication between two matrix for double type. Let :math:`A` and :math:`B` two matrix. Thus, this operation performs:

   .. math:: C=\alpha A^T * B^T + C

   where :math:`\alpha` is a scalar and `C` the result matrix. Note that, if :math:`C` is a zero matrix and we set :math:`\alpha=1` then the we have :math:`C=A^T * B^T`.

   :param alpha: A float scalar.
   :param A: A matrix of type double[].
   :param B: A matrix of type double[].
   :param C: A matrix of type double[].
   :return: A matrix :math:`C=\alpha A^T * B^T + C`.

transAmultAdd
^^^^^^^^^^^^^

.. java:method:: public static Matrix<float[]> transAmultAdd(float alpha, Matrix<float[]> A, Matrix<float[]> B, Matrix<float[]> C)
   :outertype: Algebra

   This method perform multiplication between two matrix for float type. Let :math:`A` and :math:`B` two matrix. Thus, this operation performs:

   .. math:: C=\alpha A^T * B + C

   where :math:`\alpha` is a scalar and `C` the result matrix. Note that, if :math:`C` is a zero matrix and we set :math:`\alpha=1` then the we have :math:`C=A^T * B`.

   :param alpha: A float scalar.
   :param A: A matrix of type float[].
   :param B: A matrix of type float[].
   :param C: A matrix of type float[].
   :return: A matrix :math:`C=\alpha A^T * B + C`.

transAmultAdd
^^^^^^^^^^^^^

.. java:method:: public static Matrix<double[]> transAmultAdd(double alpha, Matrix<double[]> A, Matrix<double[]> B, Matrix<double[]> C)
   :outertype: Algebra

   This method perform multiplication between two matrix for double type. Let :math:`A` and :math:`B` two matrix. Thus, this operation performs:

   .. math:: C=\alpha A^T * B + C

   where :math:`\alpha` is a scalar and `C` the result matrix. Note that, if :math:`C` is a zero matrix and we set :math:`\alpha=1` then the we have :math:`C=A^T * B`.

   :param alpha: A float scalar.
   :param A: A matrix of type double[].
   :param B: A matrix of type double[].
   :param C: A matrix of type double[].
   :return: A matrix :math:`C=\alpha A^T * B + C`.

transBmultAdd
^^^^^^^^^^^^^

.. java:method:: public static Matrix<float[]> transBmultAdd(float alpha, Matrix<float[]> A, Matrix<float[]> B, Matrix<float[]> C)
   :outertype: Algebra

   This method perform multiplication between two matrix for float type. Let :math:`A` and :math:`B` two matrix. Thus, this operation performs:

   .. math:: C=\alpha A * B^T + C

   where :math:`\alpha` is a scalar and `C` the result matrix. Note that, if :math:`C` is a zero matrix and we set :math:`\alpha=1` then the we have :math:`C=A * B^T`.

   :param alpha: A float scalar.
   :param A: A matrix of type float[].
   :param B: A matrix of type float[].
   :param C: A matrix of type float[].
   :return: A matrix :math:`C=\alpha A * B^T + C`.

transBmultAdd
^^^^^^^^^^^^^

.. java:method:: public static Matrix<double[]> transBmultAdd(double alpha, Matrix<double[]> A, Matrix<double[]> B, Matrix<double[]> C)
   :outertype: Algebra

   This method perform multiplication between two matrix for double type. Let :math:`A` and :math:`B` two matrix. Thus, this operation performs:

   .. math:: C=\alpha A * B^T + C

   where :math:`\alpha` is a scalar and `C` the result matrix. Note that, if :math:`C` is a zero matrix and we set :math:`\alpha=1` then the we have :math:`C=A * B^T`.

   :param alpha: A float scalar.
   :param A: A matrix of type double[].
   :param B: A matrix of type double[].
   :param C: A matrix of type double[].
   :return: A matrix :math:`C=\alpha A * B^T + C`.

