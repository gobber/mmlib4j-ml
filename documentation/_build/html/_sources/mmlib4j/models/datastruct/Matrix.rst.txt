Matrix
======

.. java:package:: mmlib4j.models.datastruct
   :noindex:

.. java:type:: public class Matrix<N>

Constructors
------------
Matrix
^^^^^^

.. java:constructor:: @SuppressWarnings public Matrix(Class<N> arrayType, int numRows, int numColumns)
   :outertype: Matrix

Matrix
^^^^^^

.. java:constructor:: @SuppressWarnings public Matrix(float[] values, int numRows, int numColumns)
   :outertype: Matrix

Matrix
^^^^^^

.. java:constructor:: @SuppressWarnings public Matrix(double[] values, int numRows, int numColumns)
   :outertype: Matrix

Matrix
^^^^^^

.. java:constructor:: @SuppressWarnings public Matrix(int numRows, int numColumns, double[] values, boolean deep)
   :outertype: Matrix

Matrix
^^^^^^

.. java:constructor:: @SuppressWarnings public Matrix(int numRows, int numColumns, float[] values, boolean deep)
   :outertype: Matrix

Matrix
^^^^^^

.. java:constructor:: @SuppressWarnings public Matrix(double[][] values)
   :outertype: Matrix

Matrix
^^^^^^

.. java:constructor:: @SuppressWarnings public Matrix(float[][] values)
   :outertype: Matrix

Matrix
^^^^^^

.. java:constructor:: @SuppressWarnings public Matrix(Class<N> arrayType, int numRows, int numColumns, N values, boolean deep)
   :outertype: Matrix

Matrix
^^^^^^

.. java:constructor:: @SuppressWarnings public Matrix(Class<N> arrayType, N values, boolean rowVector)
   :outertype: Matrix

Matrix
^^^^^^

.. java:constructor:: public Matrix(Matrix<N> A, boolean deep)
   :outertype: Matrix

Matrix
^^^^^^

.. java:constructor:: public Matrix(AbstractMatrix<N> matrix, int numRows, int numColumns)
   :outertype: Matrix

Matrix
^^^^^^

.. java:constructor:: public Matrix(AbstractMatrix<N> matrix, int numRows, int numColumns, N data)
   :outertype: Matrix

Methods
-------
T
^

.. java:method:: public Matrix<N> T()
   :outertype: Matrix

T
^

.. java:method:: public Matrix<N> T(Matrix<N> C)
   :outertype: Matrix

Tdot
^^^^

.. java:method:: public Matrix<N> Tdot(Matrix<N> B)
   :outertype: Matrix

Tdot
^^^^

.. java:method:: public Matrix<N> Tdot(Matrix<N> B, Matrix<N> C)
   :outertype: Matrix

Tdot
^^^^

.. java:method:: public Matrix<N> Tdot(Number value, Matrix<N> B)
   :outertype: Matrix

Tdot
^^^^

.. java:method:: public Matrix<N> Tdot(Number value, Matrix<N> B, Matrix<N> C)
   :outertype: Matrix

TdotT
^^^^^

.. java:method:: public Matrix<N> TdotT(Matrix<N> B)
   :outertype: Matrix

TdotT
^^^^^

.. java:method:: public Matrix<N> TdotT(Matrix<N> B, Matrix<N> C)
   :outertype: Matrix

TdotT
^^^^^

.. java:method:: public Matrix<N> TdotT(Number value, Matrix<N> B)
   :outertype: Matrix

TdotT
^^^^^

.. java:method:: public Matrix<N> TdotT(Number value, Matrix<N> B, Matrix<N> C)
   :outertype: Matrix

argmax
^^^^^^

.. java:method:: public Matrix<N> argmax(int axis)
   :outertype: Matrix

argmin
^^^^^^

.. java:method:: public Matrix<N> argmin(int axis)
   :outertype: Matrix

biggerthen
^^^^^^^^^^

.. java:method:: public Matrix<N> biggerthen(Number t)
   :outertype: Matrix

biggerthen
^^^^^^^^^^

.. java:method:: public Matrix<N> biggerthen(Number t, Matrix<N> C)
   :outertype: Matrix

biggertheni
^^^^^^^^^^^

.. java:method:: public Matrix<N> biggertheni(Number t)
   :outertype: Matrix

column
^^^^^^

.. java:method:: public Matrix<N> column(int column)
   :outertype: Matrix

column
^^^^^^

.. java:method:: public Matrix<N> column(int column, Matrix<N> C)
   :outertype: Matrix

copy
^^^^

.. java:method:: public Matrix<N> copy()
   :outertype: Matrix

div
^^^

.. java:method:: public Matrix<N> div(Matrix<N> B, Matrix<N> C)
   :outertype: Matrix

div
^^^

.. java:method:: public Matrix<N> div(Matrix<N> B)
   :outertype: Matrix

div
^^^

.. java:method:: public Matrix<N> div(Number value)
   :outertype: Matrix

div
^^^

.. java:method:: public Matrix<N> div(Number value, Matrix<N> C)
   :outertype: Matrix

divi
^^^^

.. java:method:: public Matrix<N> divi(Number value)
   :outertype: Matrix

divi
^^^^

.. java:method:: public Matrix<N> divi(Matrix<N> B)
   :outertype: Matrix

dot
^^^

.. java:method:: public Matrix<N> dot(Matrix<N> B)
   :outertype: Matrix

dot
^^^

.. java:method:: public Matrix<N> dot(Matrix<N> B, Matrix<N> C)
   :outertype: Matrix

dot
^^^

.. java:method:: public Matrix<N> dot(Number value, Matrix<N> B)
   :outertype: Matrix

dot
^^^

.. java:method:: public Matrix<N> dot(Number value, Matrix<N> B, Matrix<N> C)
   :outertype: Matrix

dotT
^^^^

.. java:method:: public Matrix<N> dotT(Matrix<N> B)
   :outertype: Matrix

dotT
^^^^

.. java:method:: public Matrix<N> dotT(Matrix<N> B, Matrix<N> C)
   :outertype: Matrix

dotT
^^^^

.. java:method:: public Matrix<N> dotT(Number value, Matrix<N> B)
   :outertype: Matrix

dotT
^^^^

.. java:method:: public Matrix<N> dotT(Number value, Matrix<N> B, Matrix<N> C)
   :outertype: Matrix

exp
^^^

.. java:method:: public Matrix<N> exp()
   :outertype: Matrix

exp
^^^

.. java:method:: public Matrix<N> exp(Matrix<N> C)
   :outertype: Matrix

expi
^^^^

.. java:method:: public Matrix<N> expi()
   :outertype: Matrix

fill
^^^^

.. java:method:: public Matrix<N> fill(Number value)
   :outertype: Matrix

getData
^^^^^^^

.. java:method:: public N getData()
   :outertype: Matrix

getSeparator
^^^^^^^^^^^^

.. java:method:: public String getSeparator()
   :outertype: Matrix

head
^^^^

.. java:method:: public void head(int numRows, int numColumns, String format)
   :outertype: Matrix

head
^^^^

.. java:method:: public void head(int numRows, int numColumns)
   :outertype: Matrix

head
^^^^

.. java:method:: public void head(Matrix<N> A)
   :outertype: Matrix

isScalar
^^^^^^^^

.. java:method:: public boolean isScalar()
   :outertype: Matrix

length
^^^^^^

.. java:method:: public int length()
   :outertype: Matrix

lessthen
^^^^^^^^

.. java:method:: public Matrix<N> lessthen(Number t)
   :outertype: Matrix

lessthen
^^^^^^^^

.. java:method:: public Matrix<N> lessthen(Number t, Matrix<N> C)
   :outertype: Matrix

lesstheni
^^^^^^^^^

.. java:method:: public Matrix<N> lesstheni(Number t)
   :outertype: Matrix

matrix
^^^^^^

.. java:method:: public AbstractMatrix<N> matrix()
   :outertype: Matrix

max
^^^

.. java:method:: public Matrix<N> max()
   :outertype: Matrix

max
^^^

.. java:method:: public Matrix<N> max(int axis)
   :outertype: Matrix

max
^^^

.. java:method:: public Matrix<N> max(Number value, Matrix<N> C)
   :outertype: Matrix

maxi
^^^^

.. java:method:: public Matrix<N> maxi(Number value)
   :outertype: Matrix

mean
^^^^

.. java:method:: public Matrix<N> mean()
   :outertype: Matrix

mean
^^^^

.. java:method:: public Matrix<N> mean(int axis, Matrix<N> C)
   :outertype: Matrix

mean
^^^^

.. java:method:: public Matrix<N> mean(int axis)
   :outertype: Matrix

meann
^^^^^

.. java:method:: public Matrix<N> meann()
   :outertype: Matrix

meann
^^^^^

.. java:method:: public Matrix<N> meann(int axis)
   :outertype: Matrix

min
^^^

.. java:method:: public Matrix<N> min()
   :outertype: Matrix

min
^^^

.. java:method:: public Matrix<N> min(int axis)
   :outertype: Matrix

min
^^^

.. java:method:: public Matrix<N> min(Number value, Matrix<N> C)
   :outertype: Matrix

minus
^^^^^

.. java:method:: public Matrix<N> minus(Matrix<N> B, Matrix<N> C)
   :outertype: Matrix

minus
^^^^^

.. java:method:: public Matrix<N> minus(Matrix<N> B)
   :outertype: Matrix

minus
^^^^^

.. java:method:: public Matrix<N> minus(Number value)
   :outertype: Matrix

minus
^^^^^

.. java:method:: public Matrix<N> minus(Number value, Matrix<N> C)
   :outertype: Matrix

minusi
^^^^^^

.. java:method:: public Matrix<N> minusi(Matrix<N> B)
   :outertype: Matrix

minusi
^^^^^^

.. java:method:: public Matrix<N> minusi(Number value)
   :outertype: Matrix

minusn
^^^^^^

.. java:method:: public Matrix<N> minusn(Matrix<N> B)
   :outertype: Matrix

minusni
^^^^^^^

.. java:method:: public Matrix<N> minusni(Matrix<N> B)
   :outertype: Matrix

mul
^^^

.. java:method:: public Matrix<N> mul(Matrix<N> B, Matrix<N> C)
   :outertype: Matrix

mul
^^^

.. java:method:: public Matrix<N> mul(Matrix<N> B)
   :outertype: Matrix

mul
^^^

.. java:method:: public Matrix<N> mul(Number value)
   :outertype: Matrix

mul
^^^

.. java:method:: public Matrix<N> mul(Number value, Matrix<N> C)
   :outertype: Matrix

muli
^^^^

.. java:method:: public Matrix<N> muli(Matrix<N> B)
   :outertype: Matrix

muli
^^^^

.. java:method:: public Matrix<N> muli(Number value)
   :outertype: Matrix

neg
^^^

.. java:method:: public Matrix<N> neg()
   :outertype: Matrix

neg
^^^

.. java:method:: public Matrix<N> neg(Matrix<N> C)
   :outertype: Matrix

negi
^^^^

.. java:method:: public Matrix<N> negi()
   :outertype: Matrix

numColumns
^^^^^^^^^^

.. java:method:: public int numColumns()
   :outertype: Matrix

numColumns
^^^^^^^^^^

.. java:method:: public void numColumns(int numColumns)
   :outertype: Matrix

numRows
^^^^^^^

.. java:method:: public int numRows()
   :outertype: Matrix

numRows
^^^^^^^

.. java:method:: public void numRows(int numRows)
   :outertype: Matrix

one
^^^

.. java:method:: public Matrix<N> one()
   :outertype: Matrix

ones
^^^^

.. java:method:: public static <N> Matrix<N> ones(Class<N> type, int numRows, int numColumns)
   :outertype: Matrix

plus
^^^^

.. java:method:: public Matrix<N> plus(Matrix<N> B, Matrix<N> C)
   :outertype: Matrix

plus
^^^^

.. java:method:: public Matrix<N> plus(Matrix<N> B)
   :outertype: Matrix

plus
^^^^

.. java:method:: public Matrix<N> plus(Number value)
   :outertype: Matrix

plus
^^^^

.. java:method:: public Matrix<N> plus(Number value, Matrix<N> C)
   :outertype: Matrix

plusi
^^^^^

.. java:method:: public Matrix<N> plusi(Matrix<N> B)
   :outertype: Matrix

plusi
^^^^^

.. java:method:: public Matrix<N> plusi(Number value)
   :outertype: Matrix

plusn
^^^^^

.. java:method:: public Matrix<N> plusn(Matrix<N> B)
   :outertype: Matrix

plusni
^^^^^^

.. java:method:: public Matrix<N> plusni(Matrix<N> B)
   :outertype: Matrix

pow
^^^

.. java:method:: public Matrix<N> pow(Number exponent)
   :outertype: Matrix

pow
^^^

.. java:method:: public Matrix<N> pow(Number exponent, Matrix<N> C)
   :outertype: Matrix

pow2
^^^^

.. java:method:: public Matrix<N> pow2()
   :outertype: Matrix

pow2
^^^^

.. java:method:: public Matrix<N> pow2(Matrix<N> C)
   :outertype: Matrix

pow2i
^^^^^

.. java:method:: public Matrix<N> pow2i()
   :outertype: Matrix

powi
^^^^

.. java:method:: public Matrix<N> powi(Number exponent)
   :outertype: Matrix

print
^^^^^

.. java:method:: public void print()
   :outertype: Matrix

rand
^^^^

.. java:method:: public Matrix<N> rand()
   :outertype: Matrix

rand
^^^^

.. java:method:: public static <N> Matrix<N> rand(Class<N> type, int numRows, int numColumns)
   :outertype: Matrix

randn
^^^^^

.. java:method:: public Matrix<N> randn()
   :outertype: Matrix

randn
^^^^^

.. java:method:: public static <N> Matrix<N> randn(Class<N> type, int numRows, int numColumns)
   :outertype: Matrix

rdiv
^^^^

.. java:method:: public Matrix<N> rdiv(Number value)
   :outertype: Matrix

rdiv
^^^^

.. java:method:: public Matrix<N> rdiv(Number value, Matrix<N> C)
   :outertype: Matrix

rdivi
^^^^^

.. java:method:: public Matrix<N> rdivi(Number value)
   :outertype: Matrix

row
^^^

.. java:method:: public Matrix<N> row(int row)
   :outertype: Matrix

row
^^^

.. java:method:: public Matrix<N> row(int row, Matrix<N> C)
   :outertype: Matrix

set
^^^

.. java:method:: public void set(int row, int col, Number value)
   :outertype: Matrix

setData
^^^^^^^

.. java:method:: public void setData(N data)
   :outertype: Matrix

setSeparator
^^^^^^^^^^^^

.. java:method:: public void setSeparator(String separator)
   :outertype: Matrix

shape
^^^^^

.. java:method:: public String shape()
   :outertype: Matrix

sigmoid
^^^^^^^

.. java:method:: public Matrix<N> sigmoid(Matrix<N> C)
   :outertype: Matrix

sigmoidi
^^^^^^^^

.. java:method:: public Matrix<N> sigmoidi()
   :outertype: Matrix

sqrt
^^^^

.. java:method:: public Matrix<N> sqrt()
   :outertype: Matrix

sqrt
^^^^

.. java:method:: public Matrix<N> sqrt(Matrix<N> C)
   :outertype: Matrix

sqrti
^^^^^

.. java:method:: public Matrix<N> sqrti()
   :outertype: Matrix

std
^^^

.. java:method:: public Matrix<N> std(int axis, int d, Matrix<N> C)
   :outertype: Matrix

std
^^^

.. java:method:: public Matrix<N> std(int axis, int d)
   :outertype: Matrix

stdn
^^^^

.. java:method:: public Matrix<N> stdn(int axis, int d)
   :outertype: Matrix

sum
^^^

.. java:method:: public Matrix<N> sum()
   :outertype: Matrix

sum
^^^

.. java:method:: public Matrix<N> sum(int axis)
   :outertype: Matrix

sum
^^^

.. java:method:: public Matrix<N> sum(int axis, Matrix<N> C)
   :outertype: Matrix

sumn
^^^^

.. java:method:: public Matrix<N> sumn()
   :outertype: Matrix

sumn
^^^^

.. java:method:: public Matrix<N> sumn(int axis)
   :outertype: Matrix

sumn
^^^^

.. java:method:: public Matrix<N> sumn(int axis, Matrix<N> C)
   :outertype: Matrix

sumn
^^^^

.. java:method:: public Matrix<N> sumn(int axis, Matrix<N> B, Matrix<N> C)
   :outertype: Matrix

tanh
^^^^

.. java:method:: public Matrix<N> tanh()
   :outertype: Matrix

tanh
^^^^

.. java:method:: public Matrix<N> tanh(Matrix<N> C)
   :outertype: Matrix

tanhi
^^^^^

.. java:method:: public Matrix<N> tanhi()
   :outertype: Matrix

threshold
^^^^^^^^^

.. java:method:: public Matrix<N> threshold(Number t)
   :outertype: Matrix

threshold
^^^^^^^^^

.. java:method:: public Matrix<N> threshold(Number t, Matrix<N> C)
   :outertype: Matrix

thresholdi
^^^^^^^^^^

.. java:method:: public Matrix<N> thresholdi(Number t)
   :outertype: Matrix

toString
^^^^^^^^

.. java:method:: public String toString()
   :outertype: Matrix

type
^^^^

.. java:method:: public Class<N> type()
   :outertype: Matrix

var
^^^

.. java:method:: public Matrix<N> var(int axis, int d)
   :outertype: Matrix

varn
^^^^

.. java:method:: public Matrix<N> varn(int axis, int d)
   :outertype: Matrix

zero
^^^^

.. java:method:: public Matrix<N> zero()
   :outertype: Matrix

zeros
^^^^^

.. java:method:: public static <N> Matrix<N> zeros(Class<N> type, int numRows, int numColumns)
   :outertype: Matrix

