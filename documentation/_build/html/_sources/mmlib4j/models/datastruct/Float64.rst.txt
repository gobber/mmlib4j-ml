.. java:import:: java.util Arrays

.. java:import:: mmlib4j.utils Random

Float64
=======

.. java:package:: mmlib4j.models.datastruct
   :noindex:

.. java:type:: public class Float64 extends AbstractMatrix<double[]>

Fields
------
instance
^^^^^^^^

.. java:field:: public static final Float64 instance
   :outertype: Float64

Methods
-------
T
^

.. java:method:: @Override public Matrix<double[]> T(Matrix<double[]> A, Matrix<double[]> C)
   :outertype: Float64

Tdot
^^^^

.. java:method:: @Override public Matrix<double[]> Tdot(Matrix<double[]> A, Matrix<double[]> B)
   :outertype: Float64

Tdot
^^^^

.. java:method:: @Override  Matrix<double[]> Tdot(Matrix<double[]> A, Number value, Matrix<double[]> B)
   :outertype: Float64

Tdot
^^^^

.. java:method:: @Override  Matrix<double[]> Tdot(Matrix<double[]> A, Number value, Matrix<double[]> B, Matrix<double[]> C)
   :outertype: Float64

TdotT
^^^^^

.. java:method:: @Override public Matrix<double[]> TdotT(Matrix<double[]> A, Matrix<double[]> B)
   :outertype: Float64

TdotT
^^^^^

.. java:method:: @Override public Matrix<double[]> TdotT(Matrix<double[]> A, Number value, Matrix<double[]> B)
   :outertype: Float64

TdotT
^^^^^

.. java:method:: @Override public Matrix<double[]> TdotT(Matrix<double[]> A, Number value, Matrix<double[]> B, Matrix<double[]> C)
   :outertype: Float64

argmax
^^^^^^

.. java:method:: @Override public Matrix<double[]> argmax(Matrix<double[]> A, int axis)
   :outertype: Float64

argmin
^^^^^^

.. java:method:: @Override public Matrix<double[]> argmin(Matrix<double[]> A, int axis)
   :outertype: Float64

biggerthen
^^^^^^^^^^

.. java:method:: @Override public Matrix<double[]> biggerthen(Matrix<double[]> A, Number t, Matrix<double[]> C)
   :outertype: Float64

clone
^^^^^

.. java:method:: @Override public double[] clone(double[] A)
   :outertype: Float64

colargmax
^^^^^^^^^

.. java:method::  Matrix<double[]> colargmax(Matrix<double[]> A, int r, int c, Matrix<double[]> C)
   :outertype: Float64

colargmin
^^^^^^^^^

.. java:method::  Matrix<double[]> colargmin(Matrix<double[]> A, int r, int c, Matrix<double[]> C)
   :outertype: Float64

column
^^^^^^

.. java:method:: @Override public Matrix<double[]> column(Matrix<double[]> A, int column, Matrix<double[]> C)
   :outertype: Float64

create
^^^^^^

.. java:method:: @Override public double[] create(int numRows, int numColumns)
   :outertype: Float64

div
^^^

.. java:method:: @Override public Matrix<double[]> div(Matrix<double[]> A, Matrix<double[]> B, Matrix<double[]> C)
   :outertype: Float64

div
^^^

.. java:method:: @Override public Matrix<double[]> div(Matrix<double[]> A, Matrix<double[]> B)
   :outertype: Float64

div
^^^

.. java:method:: @Override public Matrix<double[]> div(Matrix<double[]> A, Number value, Matrix<double[]> C)
   :outertype: Float64

divi
^^^^

.. java:method:: @Override public Matrix<double[]> divi(Matrix<double[]> A, Matrix<double[]> B)
   :outertype: Float64

dot
^^^

.. java:method:: @Override public Matrix<double[]> dot(Matrix<double[]> A, Matrix<double[]> B)
   :outertype: Float64

dot
^^^

.. java:method:: @Override public Matrix<double[]> dot(Matrix<double[]> A, Number value, Matrix<double[]> B)
   :outertype: Float64

dot
^^^

.. java:method:: @Override public Matrix<double[]> dot(Matrix<double[]> A, Number value, Matrix<double[]> B, Matrix<double[]> C)
   :outertype: Float64

dotT
^^^^

.. java:method:: @Override  Matrix<double[]> dotT(Matrix<double[]> A, Matrix<double[]> B)
   :outertype: Float64

dotT
^^^^

.. java:method:: @Override public Matrix<double[]> dotT(Matrix<double[]> A, Number value, Matrix<double[]> B)
   :outertype: Float64

dotT
^^^^

.. java:method:: @Override public Matrix<double[]> dotT(Matrix<double[]> A, Number value, Matrix<double[]> B, Matrix<double[]> C)
   :outertype: Float64

exp
^^^

.. java:method:: @Override public Matrix<double[]> exp(Matrix<double[]> A, Matrix<double[]> C)
   :outertype: Float64

fill
^^^^

.. java:method:: @Override public Matrix<double[]> fill(Matrix<double[]> source, Number value)
   :outertype: Float64

head
^^^^

.. java:method:: @Override public void head(Matrix<double[]> source, int numRows, int numColumns, String format)
   :outertype: Float64

length
^^^^^^

.. java:method:: @Override public int length(double[] values)
   :outertype: Float64

lessthen
^^^^^^^^

.. java:method:: @Override public Matrix<double[]> lessthen(Matrix<double[]> A, Number t, Matrix<double[]> C)
   :outertype: Float64

max
^^^

.. java:method::  Matrix<double[]> max(Matrix<double[]> A, int r, int c, Matrix<double[]> C)
   :outertype: Float64

max
^^^

.. java:method:: @Override public Matrix<double[]> max(Matrix<double[]> A)
   :outertype: Float64

max
^^^

.. java:method:: @Override public Matrix<double[]> max(Matrix<double[]> A, int axis)
   :outertype: Float64

max
^^^

.. java:method:: @Override public Matrix<double[]> max(Matrix<double[]> A, Number value, Matrix<double[]> C)
   :outertype: Float64

meann
^^^^^

.. java:method:: @Override public Matrix<double[]> meann(Matrix<double[]> A)
   :outertype: Float64

min
^^^

.. java:method::  Matrix<double[]> min(Matrix<double[]> A, int r, int c, Matrix<double[]> C)
   :outertype: Float64

min
^^^

.. java:method:: @Override public Matrix<double[]> min(Matrix<double[]> A)
   :outertype: Float64

min
^^^

.. java:method:: @Override public Matrix<double[]> min(Matrix<double[]> A, int axis)
   :outertype: Float64

min
^^^

.. java:method:: @Override public Matrix<double[]> min(Matrix<double[]> A, Number value, Matrix<double[]> C)
   :outertype: Float64

minus
^^^^^

.. java:method:: @Override public Matrix<double[]> minus(Matrix<double[]> A, Matrix<double[]> B, Matrix<double[]> C)
   :outertype: Float64

minus
^^^^^

.. java:method:: @Override public Matrix<double[]> minus(Matrix<double[]> A, Matrix<double[]> B)
   :outertype: Float64

minus
^^^^^

.. java:method:: @Override public Matrix<double[]> minus(Matrix<double[]> A, Number value, Matrix<double[]> C)
   :outertype: Float64

minusi
^^^^^^

.. java:method:: @Override public Matrix<double[]> minusi(Matrix<double[]> A, Matrix<double[]> B)
   :outertype: Float64

minusn
^^^^^^

.. java:method:: @Override public Matrix<double[]> minusn(Matrix<double[]> A, Matrix<double[]> B)
   :outertype: Float64

minusni
^^^^^^^

.. java:method:: @Override public Matrix<double[]> minusni(Matrix<double[]> A, Matrix<double[]> B)
   :outertype: Float64

mul
^^^

.. java:method:: @Override public Matrix<double[]> mul(Matrix<double[]> A, Matrix<double[]> B, Matrix<double[]> C)
   :outertype: Float64

mul
^^^

.. java:method:: @Override public Matrix<double[]> mul(Matrix<double[]> A, Matrix<double[]> B)
   :outertype: Float64

mul
^^^

.. java:method:: @Override public Matrix<double[]> mul(Matrix<double[]> A, Number value, Matrix<double[]> C)
   :outertype: Float64

muli
^^^^

.. java:method:: @Override public Matrix<double[]> muli(Matrix<double[]> A, Matrix<double[]> B)
   :outertype: Float64

neg
^^^

.. java:method:: @Override public Matrix<double[]> neg(Matrix<double[]> A, Matrix<double[]> C)
   :outertype: Float64

plus
^^^^

.. java:method:: @Override public Matrix<double[]> plus(Matrix<double[]> A, Matrix<double[]> B, Matrix<double[]> C)
   :outertype: Float64

plus
^^^^

.. java:method:: @Override public Matrix<double[]> plus(Matrix<double[]> A, Matrix<double[]> B)
   :outertype: Float64

plus
^^^^

.. java:method:: @Override public Matrix<double[]> plus(Matrix<double[]> A, Number value, Matrix<double[]> C)
   :outertype: Float64

plusi
^^^^^

.. java:method:: @Override public Matrix<double[]> plusi(Matrix<double[]> A, Matrix<double[]> B)
   :outertype: Float64

plusn
^^^^^

.. java:method:: @Override public Matrix<double[]> plusn(Matrix<double[]> A, Matrix<double[]> B)
   :outertype: Float64

plusni
^^^^^^

.. java:method:: @Override public Matrix<double[]> plusni(Matrix<double[]> A, Matrix<double[]> B)
   :outertype: Float64

pow
^^^

.. java:method:: @Override public Matrix<double[]> pow(Matrix<double[]> A, Number exponent, Matrix<double[]> C)
   :outertype: Float64

pow2
^^^^

.. java:method:: @Override public Matrix<double[]> pow2(Matrix<double[]> A, Matrix<double[]> C)
   :outertype: Float64

print
^^^^^

.. java:method:: @Override public void print(Matrix<double[]> source)
   :outertype: Float64

rand
^^^^

.. java:method:: @Override public Matrix<double[]> rand(Matrix<double[]> A)
   :outertype: Float64

randn
^^^^^

.. java:method:: @Override public Matrix<double[]> randn(Matrix<double[]> A)
   :outertype: Float64

rdiv
^^^^

.. java:method:: @Override public Matrix<double[]> rdiv(Matrix<double[]> A, Number value, Matrix<double[]> C)
   :outertype: Float64

row
^^^

.. java:method:: @Override public Matrix<double[]> row(Matrix<double[]> A, int row, Matrix<double[]> C)
   :outertype: Float64

rowargmax
^^^^^^^^^

.. java:method::  Matrix<double[]> rowargmax(Matrix<double[]> A, int r, int c, Matrix<double[]> C)
   :outertype: Float64

rowargmin
^^^^^^^^^

.. java:method::  Matrix<double[]> rowargmin(Matrix<double[]> A, int r, int c, Matrix<double[]> C)
   :outertype: Float64

set
^^^

.. java:method:: @Override public void set(Matrix<double[]> source, int row, int col, Number value)
   :outertype: Float64

sigmoid
^^^^^^^

.. java:method:: @Override public Matrix<double[]> sigmoid(Matrix<double[]> A, Matrix<double[]> C)
   :outertype: Float64

sqrt
^^^^

.. java:method:: @Override public Matrix<double[]> sqrt(Matrix<double[]> A, Matrix<double[]> C)
   :outertype: Float64

sum
^^^

.. java:method:: public Matrix<double[]> sum(Matrix<double[]> A, int r, int c, Matrix<double[]> C)
   :outertype: Float64

sumn
^^^^

.. java:method:: @Override public Matrix<double[]> sumn(Matrix<double[]> A)
   :outertype: Float64

sumn
^^^^

.. java:method:: @Override public Matrix<double[]> sumn(Matrix<double[]> A, int axis)
   :outertype: Float64

sumn
^^^^

.. java:method:: @Override public Matrix<double[]> sumn(Matrix<double[]> A, int axis, Matrix<double[]> C)
   :outertype: Float64

sumn
^^^^

.. java:method:: @Override public Matrix<double[]> sumn(Matrix<double[]> A, int axis, Matrix<double[]> B, Matrix<double[]> C)
   :outertype: Float64

tanh
^^^^

.. java:method:: @Override public Matrix<double[]> tanh(Matrix<double[]> A, Matrix<double[]> C)
   :outertype: Float64

toString
^^^^^^^^

.. java:method:: @Override public String toString(Matrix<double[]> source, String separator)
   :outertype: Float64

type
^^^^

.. java:method:: @Override  Class<double[]> type()
   :outertype: Float64

