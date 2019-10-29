.. java:import:: mmlib4j.options Options

JavaOperations
==============

.. java:package:: mmlib4j.models.datastruct
   :noindex:

.. java:type:: public class JavaOperations implements Operations

Fields
------
instance
^^^^^^^^

.. java:field:: public static final JavaOperations instance
   :outertype: JavaOperations

Methods
-------
Tdot
^^^^

.. java:method:: @Override public Matrix Tdot(Matrix A, Matrix B)
   :outertype: JavaOperations

Tdot
^^^^

.. java:method:: @Override public Matrix Tdot(Matrix A, Matrix B, Matrix C)
   :outertype: JavaOperations

Tdot
^^^^

.. java:method:: @Override public Matrix Tdot(double alpha, Matrix A, Matrix B)
   :outertype: JavaOperations

Tdot
^^^^

.. java:method:: @Override public Matrix Tdot(double alpha, Matrix A, Matrix B, Matrix C)
   :outertype: JavaOperations

TdotT
^^^^^

.. java:method:: @Override public Matrix TdotT(Matrix A, Matrix B)
   :outertype: JavaOperations

TdotT
^^^^^

.. java:method:: @Override public Matrix TdotT(Matrix A, Matrix B, Matrix C)
   :outertype: JavaOperations

TdotT
^^^^^

.. java:method:: @Override public Matrix TdotT(double alpha, Matrix A, Matrix B)
   :outertype: JavaOperations

TdotT
^^^^^

.. java:method:: @Override public Matrix TdotT(double alpha, Matrix A, Matrix B, Matrix C)
   :outertype: JavaOperations

Tdot_vec_small
^^^^^^^^^^^^^^

.. java:method:: public Matrix Tdot_vec_small(double alpha, Matrix A, Matrix B, Matrix C)
   :outertype: JavaOperations

Tdot_vec_small
^^^^^^^^^^^^^^

.. java:method:: public Matrix Tdot_vec_small(Matrix A, Matrix B, Matrix C)
   :outertype: JavaOperations

dot
^^^

.. java:method:: @Override public Matrix dot(Matrix A, Matrix B)
   :outertype: JavaOperations

dot
^^^

.. java:method:: @Override public Matrix dot(Matrix A, Matrix B, Matrix C)
   :outertype: JavaOperations

dot
^^^

.. java:method:: @Override public Matrix dot(double alpha, Matrix A, Matrix B)
   :outertype: JavaOperations

dot
^^^

.. java:method:: @Override public Matrix dot(double alpha, Matrix A, Matrix B, Matrix C)
   :outertype: JavaOperations

dotT
^^^^

.. java:method:: @Override public Matrix dotT(Matrix A, Matrix B)
   :outertype: JavaOperations

dotT
^^^^

.. java:method:: @Override public Matrix dotT(Matrix A, Matrix B, Matrix C)
   :outertype: JavaOperations

dotT
^^^^

.. java:method:: @Override public Matrix dotT(double alpha, Matrix A, Matrix B)
   :outertype: JavaOperations

dotT
^^^^

.. java:method:: @Override public Matrix dotT(double alpha, Matrix A, Matrix B, Matrix C)
   :outertype: JavaOperations

dot_reorder
^^^^^^^^^^^

.. java:method:: public Matrix dot_reorder(double alpha, Matrix A, Matrix B, Matrix C)
   :outertype: JavaOperations

dot_reorder
^^^^^^^^^^^

.. java:method:: public Matrix dot_reorder(Matrix A, Matrix B, Matrix C)
   :outertype: JavaOperations

dot_small
^^^^^^^^^

.. java:method:: public Matrix dot_small(Matrix A, Matrix B, Matrix C)
   :outertype: JavaOperations

dot_small
^^^^^^^^^

.. java:method:: public Matrix dot_small(double alpha, Matrix A, Matrix B, Matrix C)
   :outertype: JavaOperations

dot_vec_reorder
^^^^^^^^^^^^^^^

.. java:method:: public Matrix dot_vec_reorder(double alpha, Matrix A, Matrix B, Matrix C)
   :outertype: JavaOperations

dot_vec_reorder
^^^^^^^^^^^^^^^

.. java:method:: public Matrix dot_vec_reorder(Matrix A, Matrix B, Matrix C)
   :outertype: JavaOperations

getIndex
^^^^^^^^

.. java:method:: @Override public int getIndex(int row, int col, int numRows, int numColumns)
   :outertype: JavaOperations

mean
^^^^

.. java:method:: @Override public Matrix mean(Matrix A)
   :outertype: JavaOperations

mean
^^^^

.. java:method:: @Override public Matrix mean(int axis, Matrix A, Matrix C)
   :outertype: JavaOperations

mean
^^^^

.. java:method:: @Override public Matrix mean(Matrix A, int axis)
   :outertype: JavaOperations

minus
^^^^^

.. java:method:: @Override public Matrix minus(Matrix A, Matrix B)
   :outertype: JavaOperations

minusi
^^^^^^

.. java:method:: @Override public Matrix minusi(Matrix A, Matrix B)
   :outertype: JavaOperations

plus
^^^^

.. java:method:: @Override public Matrix plus(Matrix A, Matrix B)
   :outertype: JavaOperations

plusi
^^^^^

.. java:method:: @Override public Matrix plusi(Matrix A, Matrix B)
   :outertype: JavaOperations

sum
^^^

.. java:method:: @Override public Matrix sum(Matrix A)
   :outertype: JavaOperations

sum
^^^

.. java:method:: @Override public Matrix sum(Matrix A, int axis)
   :outertype: JavaOperations

sum
^^^

.. java:method:: @Override public Matrix sum(Matrix A, int axis, Matrix C)
   :outertype: JavaOperations

