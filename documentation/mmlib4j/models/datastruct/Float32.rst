.. java:import:: java.util Arrays

.. java:import:: mmlib4j.utils Random

Float32
=======

.. java:package:: mmlib4j.models.datastruct
   :noindex:

.. java:type:: public class Float32 extends AbstractMatrix<float[]>

Fields
------
instance
^^^^^^^^

.. java:field:: public static final Float32 instance
   :outertype: Float32

Methods
-------
T
^

.. java:method:: @Override public Matrix<float[]> T(Matrix<float[]> A, Matrix<float[]> C)
   :outertype: Float32

Tdot
^^^^

.. java:method:: @Override public Matrix<float[]> Tdot(Matrix<float[]> A, Matrix<float[]> B)
   :outertype: Float32

Tdot
^^^^

.. java:method:: @Override  Matrix<float[]> Tdot(Matrix<float[]> A, Number value, Matrix<float[]> B)
   :outertype: Float32

Tdot
^^^^

.. java:method:: @Override  Matrix<float[]> Tdot(Matrix<float[]> A, Number value, Matrix<float[]> B, Matrix<float[]> C)
   :outertype: Float32

TdotT
^^^^^

.. java:method:: @Override public Matrix<float[]> TdotT(Matrix<float[]> A, Matrix<float[]> B)
   :outertype: Float32

TdotT
^^^^^

.. java:method:: @Override public Matrix<float[]> TdotT(Matrix<float[]> A, Number value, Matrix<float[]> B)
   :outertype: Float32

TdotT
^^^^^

.. java:method:: @Override public Matrix<float[]> TdotT(Matrix<float[]> A, Number value, Matrix<float[]> B, Matrix<float[]> C)
   :outertype: Float32

argmax
^^^^^^

.. java:method:: @Override public Matrix<float[]> argmax(Matrix<float[]> A, int axis)
   :outertype: Float32

argmin
^^^^^^

.. java:method:: @Override public Matrix<float[]> argmin(Matrix<float[]> A, int axis)
   :outertype: Float32

biggerthen
^^^^^^^^^^

.. java:method:: @Override public Matrix<float[]> biggerthen(Matrix<float[]> A, Number t, Matrix<float[]> C)
   :outertype: Float32

clone
^^^^^

.. java:method:: @Override public float[] clone(float[] A)
   :outertype: Float32

colargmax
^^^^^^^^^

.. java:method::  Matrix<float[]> colargmax(Matrix<float[]> A, int r, int c, Matrix<float[]> C)
   :outertype: Float32

colargmin
^^^^^^^^^

.. java:method::  Matrix<float[]> colargmin(Matrix<float[]> A, int r, int c, Matrix<float[]> C)
   :outertype: Float32

column
^^^^^^

.. java:method:: @Override public Matrix<float[]> column(Matrix<float[]> A, int column, Matrix<float[]> C)
   :outertype: Float32

create
^^^^^^

.. java:method:: @Override public float[] create(int numRows, int numColumns)
   :outertype: Float32

div
^^^

.. java:method:: @Override public Matrix<float[]> div(Matrix<float[]> A, Matrix<float[]> B, Matrix<float[]> C)
   :outertype: Float32

div
^^^

.. java:method:: @Override public Matrix<float[]> div(Matrix<float[]> A, Matrix<float[]> B)
   :outertype: Float32

div
^^^

.. java:method:: @Override public Matrix<float[]> div(Matrix<float[]> A, Number value, Matrix<float[]> C)
   :outertype: Float32

divi
^^^^

.. java:method:: @Override public Matrix<float[]> divi(Matrix<float[]> A, Matrix<float[]> B)
   :outertype: Float32

dot
^^^

.. java:method:: @Override public Matrix<float[]> dot(Matrix<float[]> A, Matrix<float[]> B)
   :outertype: Float32

dot
^^^

.. java:method:: @Override public Matrix<float[]> dot(Matrix<float[]> A, Number value, Matrix<float[]> B)
   :outertype: Float32

dot
^^^

.. java:method:: @Override public Matrix<float[]> dot(Matrix<float[]> A, Number value, Matrix<float[]> B, Matrix<float[]> C)
   :outertype: Float32

dotT
^^^^

.. java:method:: @Override  Matrix<float[]> dotT(Matrix<float[]> A, Matrix<float[]> B)
   :outertype: Float32

dotT
^^^^

.. java:method:: @Override public Matrix<float[]> dotT(Matrix<float[]> A, Number value, Matrix<float[]> B)
   :outertype: Float32

dotT
^^^^

.. java:method:: @Override public Matrix<float[]> dotT(Matrix<float[]> A, Number value, Matrix<float[]> B, Matrix<float[]> C)
   :outertype: Float32

exp
^^^

.. java:method:: @Override public Matrix<float[]> exp(Matrix<float[]> A, Matrix<float[]> C)
   :outertype: Float32

fill
^^^^

.. java:method:: @Override public Matrix<float[]> fill(Matrix<float[]> source, Number value)
   :outertype: Float32

head
^^^^

.. java:method:: @Override public void head(Matrix<float[]> source, int numRows, int numColumns, String format)
   :outertype: Float32

length
^^^^^^

.. java:method:: @Override public int length(float[] values)
   :outertype: Float32

lessthen
^^^^^^^^

.. java:method:: @Override public Matrix<float[]> lessthen(Matrix<float[]> A, Number t, Matrix<float[]> C)
   :outertype: Float32

max
^^^

.. java:method::  Matrix<float[]> max(Matrix<float[]> A, int r, int c, Matrix<float[]> C)
   :outertype: Float32

max
^^^

.. java:method:: @Override public Matrix<float[]> max(Matrix<float[]> A)
   :outertype: Float32

max
^^^

.. java:method:: @Override public Matrix<float[]> max(Matrix<float[]> A, int axis)
   :outertype: Float32

max
^^^

.. java:method:: @Override public Matrix<float[]> max(Matrix<float[]> A, Number value, Matrix<float[]> C)
   :outertype: Float32

meann
^^^^^

.. java:method:: @Override public Matrix<float[]> meann(Matrix<float[]> A)
   :outertype: Float32

min
^^^

.. java:method::  Matrix<float[]> min(Matrix<float[]> A, int r, int c, Matrix<float[]> C)
   :outertype: Float32

min
^^^

.. java:method:: @Override public Matrix<float[]> min(Matrix<float[]> A)
   :outertype: Float32

min
^^^

.. java:method:: @Override public Matrix<float[]> min(Matrix<float[]> A, int axis)
   :outertype: Float32

min
^^^

.. java:method:: @Override public Matrix<float[]> min(Matrix<float[]> A, Number value, Matrix<float[]> C)
   :outertype: Float32

minus
^^^^^

.. java:method:: @Override public Matrix<float[]> minus(Matrix<float[]> A, Matrix<float[]> B, Matrix<float[]> C)
   :outertype: Float32

minus
^^^^^

.. java:method:: @Override public Matrix<float[]> minus(Matrix<float[]> A, Matrix<float[]> B)
   :outertype: Float32

minus
^^^^^

.. java:method:: @Override public Matrix<float[]> minus(Matrix<float[]> A, Number value, Matrix<float[]> C)
   :outertype: Float32

minusi
^^^^^^

.. java:method:: @Override public Matrix<float[]> minusi(Matrix<float[]> A, Matrix<float[]> B)
   :outertype: Float32

minusn
^^^^^^

.. java:method:: @Override public Matrix<float[]> minusn(Matrix<float[]> A, Matrix<float[]> B)
   :outertype: Float32

minusni
^^^^^^^

.. java:method:: @Override public Matrix<float[]> minusni(Matrix<float[]> A, Matrix<float[]> B)
   :outertype: Float32

mul
^^^

.. java:method:: @Override public Matrix<float[]> mul(Matrix<float[]> A, Matrix<float[]> B, Matrix<float[]> C)
   :outertype: Float32

mul
^^^

.. java:method:: @Override public Matrix<float[]> mul(Matrix<float[]> A, Matrix<float[]> B)
   :outertype: Float32

mul
^^^

.. java:method:: @Override public Matrix<float[]> mul(Matrix<float[]> A, Number value, Matrix<float[]> C)
   :outertype: Float32

muli
^^^^

.. java:method:: @Override public Matrix<float[]> muli(Matrix<float[]> A, Matrix<float[]> B)
   :outertype: Float32

neg
^^^

.. java:method:: @Override public Matrix<float[]> neg(Matrix<float[]> A, Matrix<float[]> C)
   :outertype: Float32

plus
^^^^

.. java:method:: @Override public Matrix<float[]> plus(Matrix<float[]> A, Matrix<float[]> B, Matrix<float[]> C)
   :outertype: Float32

plus
^^^^

.. java:method:: @Override public Matrix<float[]> plus(Matrix<float[]> A, Matrix<float[]> B)
   :outertype: Float32

plus
^^^^

.. java:method:: @Override public Matrix<float[]> plus(Matrix<float[]> A, Number value, Matrix<float[]> C)
   :outertype: Float32

plusi
^^^^^

.. java:method:: @Override public Matrix<float[]> plusi(Matrix<float[]> A, Matrix<float[]> B)
   :outertype: Float32

plusn
^^^^^

.. java:method:: @Override public Matrix<float[]> plusn(Matrix<float[]> A, Matrix<float[]> B)
   :outertype: Float32

plusni
^^^^^^

.. java:method:: @Override public Matrix<float[]> plusni(Matrix<float[]> A, Matrix<float[]> B)
   :outertype: Float32

pow
^^^

.. java:method:: @Override public Matrix<float[]> pow(Matrix<float[]> A, Number exponent, Matrix<float[]> C)
   :outertype: Float32

pow2
^^^^

.. java:method:: @Override public Matrix<float[]> pow2(Matrix<float[]> A, Matrix<float[]> C)
   :outertype: Float32

print
^^^^^

.. java:method:: @Override public void print(Matrix<float[]> source)
   :outertype: Float32

rand
^^^^

.. java:method:: @Override public Matrix<float[]> rand(Matrix<float[]> A)
   :outertype: Float32

randn
^^^^^

.. java:method:: @Override public Matrix<float[]> randn(Matrix<float[]> A)
   :outertype: Float32

rdiv
^^^^

.. java:method:: @Override public Matrix<float[]> rdiv(Matrix<float[]> A, Number value, Matrix<float[]> C)
   :outertype: Float32

row
^^^

.. java:method:: @Override public Matrix<float[]> row(Matrix<float[]> A, int row, Matrix<float[]> C)
   :outertype: Float32

rowargmax
^^^^^^^^^

.. java:method::  Matrix<float[]> rowargmax(Matrix<float[]> A, int r, int c, Matrix<float[]> C)
   :outertype: Float32

rowargmin
^^^^^^^^^

.. java:method::  Matrix<float[]> rowargmin(Matrix<float[]> A, int r, int c, Matrix<float[]> C)
   :outertype: Float32

set
^^^

.. java:method:: @Override public void set(Matrix<float[]> source, int row, int col, Number value)
   :outertype: Float32

sigmoid
^^^^^^^

.. java:method:: @Override public Matrix<float[]> sigmoid(Matrix<float[]> A, Matrix<float[]> C)
   :outertype: Float32

sqrt
^^^^

.. java:method:: @Override public Matrix<float[]> sqrt(Matrix<float[]> A, Matrix<float[]> C)
   :outertype: Float32

sum
^^^

.. java:method:: public Matrix<float[]> sum(Matrix<float[]> A, int r, int c, Matrix<float[]> C)
   :outertype: Float32

sumn
^^^^

.. java:method:: @Override public Matrix<float[]> sumn(Matrix<float[]> A)
   :outertype: Float32

sumn
^^^^

.. java:method:: @Override public Matrix<float[]> sumn(Matrix<float[]> A, int axis)
   :outertype: Float32

sumn
^^^^

.. java:method:: @Override public Matrix<float[]> sumn(Matrix<float[]> A, int axis, Matrix<float[]> C)
   :outertype: Float32

sumn
^^^^

.. java:method:: @Override public Matrix<float[]> sumn(Matrix<float[]> A, int axis, Matrix<float[]> B, Matrix<float[]> C)
   :outertype: Float32

tanh
^^^^

.. java:method:: @Override public Matrix<float[]> tanh(Matrix<float[]> A, Matrix<float[]> C)
   :outertype: Float32

toString
^^^^^^^^

.. java:method:: @Override public String toString(Matrix<float[]> source, String separator)
   :outertype: Float32

type
^^^^

.. java:method:: @Override  Class<float[]> type()
   :outertype: Float32

