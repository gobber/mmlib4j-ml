AbstractMatrix
==============

.. java:package:: mmlib4j.models.datastruct
   :noindex:

.. java:type:: public abstract class AbstractMatrix<N>

Methods
-------
T
^

.. java:method:: public Matrix<N> T(Matrix<N> A)
   :outertype: AbstractMatrix

T
^

.. java:method:: public abstract Matrix<N> T(Matrix<N> A, Matrix<N> C)
   :outertype: AbstractMatrix

Tdot
^^^^

.. java:method:: public abstract Matrix<N> Tdot(Matrix<N> A, Matrix<N> B)
   :outertype: AbstractMatrix

Tdot
^^^^

.. java:method:: public Matrix<N> Tdot(Matrix<N> A, Matrix<N> B, Matrix<N> C)
   :outertype: AbstractMatrix

Tdot
^^^^

.. java:method:: abstract Matrix<N> Tdot(Matrix<N> A, Number value, Matrix<N> B)
   :outertype: AbstractMatrix

Tdot
^^^^

.. java:method:: abstract Matrix<N> Tdot(Matrix<N> A, Number value, Matrix<N> B, Matrix<N> C)
   :outertype: AbstractMatrix

TdotT
^^^^^

.. java:method:: public abstract Matrix<N> TdotT(Matrix<N> A, Matrix<N> B)
   :outertype: AbstractMatrix

TdotT
^^^^^

.. java:method:: public Matrix<N> TdotT(Matrix<N> A, Matrix<N> B, Matrix<N> C)
   :outertype: AbstractMatrix

TdotT
^^^^^

.. java:method:: public abstract Matrix<N> TdotT(Matrix<N> A, Number value, Matrix<N> B)
   :outertype: AbstractMatrix

TdotT
^^^^^

.. java:method:: public abstract Matrix<N> TdotT(Matrix<N> A, Number value, Matrix<N> B, Matrix<N> C)
   :outertype: AbstractMatrix

argmax
^^^^^^

.. java:method:: public abstract Matrix<N> argmax(Matrix<N> A, int axis)
   :outertype: AbstractMatrix

argmin
^^^^^^

.. java:method:: public abstract Matrix<N> argmin(Matrix<N> A, int axis)
   :outertype: AbstractMatrix

biggerthen
^^^^^^^^^^

.. java:method:: public Matrix<N> biggerthen(Matrix<N> A, Number t)
   :outertype: AbstractMatrix

biggerthen
^^^^^^^^^^

.. java:method:: public abstract Matrix<N> biggerthen(Matrix<N> A, Number t, Matrix<N> C)
   :outertype: AbstractMatrix

biggertheni
^^^^^^^^^^^

.. java:method:: public Matrix<N> biggertheni(Matrix<N> A, Number t)
   :outertype: AbstractMatrix

clone
^^^^^

.. java:method:: public abstract N clone(N A)
   :outertype: AbstractMatrix

column
^^^^^^

.. java:method:: public Matrix<N> column(Matrix<N> A, int column)
   :outertype: AbstractMatrix

column
^^^^^^

.. java:method:: public abstract Matrix<N> column(Matrix<N> A, int column, Matrix<N> C)
   :outertype: AbstractMatrix

copy
^^^^

.. java:method:: public Matrix<N> copy(Matrix<N> A)
   :outertype: AbstractMatrix

create
^^^^^^

.. java:method:: public abstract N create(int numRows, int numColumns)
   :outertype: AbstractMatrix

div
^^^

.. java:method:: public abstract Matrix<N> div(Matrix<N> A, Matrix<N> B, Matrix<N> C)
   :outertype: AbstractMatrix

div
^^^

.. java:method:: public abstract Matrix<N> div(Matrix<N> A, Matrix<N> B)
   :outertype: AbstractMatrix

div
^^^

.. java:method:: public Matrix<N> div(Matrix<N> A, Number value)
   :outertype: AbstractMatrix

div
^^^

.. java:method:: public abstract Matrix<N> div(Matrix<N> A, Number value, Matrix<N> C)
   :outertype: AbstractMatrix

divi
^^^^

.. java:method:: public Matrix<N> divi(Matrix<N> A, Number value)
   :outertype: AbstractMatrix

divi
^^^^

.. java:method:: public abstract Matrix<N> divi(Matrix<N> A, Matrix<N> B)
   :outertype: AbstractMatrix

dot
^^^

.. java:method:: public abstract Matrix<N> dot(Matrix<N> A, Matrix<N> B)
   :outertype: AbstractMatrix

dot
^^^

.. java:method:: public Matrix<N> dot(Matrix<N> A, Matrix<N> B, Matrix<N> C)
   :outertype: AbstractMatrix

dot
^^^

.. java:method:: public abstract Matrix<N> dot(Matrix<N> A, Number value, Matrix<N> B)
   :outertype: AbstractMatrix

dot
^^^

.. java:method:: public abstract Matrix<N> dot(Matrix<N> A, Number value, Matrix<N> B, Matrix<N> C)
   :outertype: AbstractMatrix

dotT
^^^^

.. java:method:: abstract Matrix<N> dotT(Matrix<N> A, Matrix<N> B)
   :outertype: AbstractMatrix

dotT
^^^^

.. java:method:: public Matrix<N> dotT(Matrix<N> A, Matrix<N> B, Matrix<N> C)
   :outertype: AbstractMatrix

dotT
^^^^

.. java:method:: public abstract Matrix<N> dotT(Matrix<N> A, Number value, Matrix<N> B)
   :outertype: AbstractMatrix

dotT
^^^^

.. java:method:: public abstract Matrix<N> dotT(Matrix<N> A, Number value, Matrix<N> B, Matrix<N> C)
   :outertype: AbstractMatrix

exp
^^^

.. java:method:: public Matrix<N> exp(Matrix<N> A)
   :outertype: AbstractMatrix

exp
^^^

.. java:method:: public abstract Matrix<N> exp(Matrix<N> A, Matrix<N> C)
   :outertype: AbstractMatrix

expi
^^^^

.. java:method:: public Matrix<N> expi(Matrix<N> A)
   :outertype: AbstractMatrix

fill
^^^^

.. java:method:: public abstract Matrix<N> fill(Matrix<N> A, Number value)
   :outertype: AbstractMatrix

getIndex
^^^^^^^^

.. java:method::  int getIndex(int row, int col, int numRows)
   :outertype: AbstractMatrix

head
^^^^

.. java:method:: public abstract void head(Matrix<N> A, int numRows, int numColumns, String format)
   :outertype: AbstractMatrix

head
^^^^

.. java:method:: public void head(Matrix<N> A, int numRows, int numColumns)
   :outertype: AbstractMatrix

head
^^^^

.. java:method:: public void head(Matrix<N> A)
   :outertype: AbstractMatrix

length
^^^^^^

.. java:method:: public abstract int length(N values)
   :outertype: AbstractMatrix

lessthen
^^^^^^^^

.. java:method:: public Matrix<N> lessthen(Matrix<N> A, Number t)
   :outertype: AbstractMatrix

lessthen
^^^^^^^^

.. java:method:: public abstract Matrix<N> lessthen(Matrix<N> A, Number t, Matrix<N> C)
   :outertype: AbstractMatrix

lesstheni
^^^^^^^^^

.. java:method:: public Matrix<N> lesstheni(Matrix<N> A, Number t)
   :outertype: AbstractMatrix

max
^^^

.. java:method:: public abstract Matrix<N> max(Matrix<N> A)
   :outertype: AbstractMatrix

max
^^^

.. java:method:: public abstract Matrix<N> max(Matrix<N> A, int axis)
   :outertype: AbstractMatrix

max
^^^

.. java:method:: public abstract Matrix<N> max(Matrix<N> A, Number value, Matrix<N> C)
   :outertype: AbstractMatrix

maxi
^^^^

.. java:method:: public Matrix<N> maxi(Matrix<N> A, Number value)
   :outertype: AbstractMatrix

mean
^^^^

.. java:method:: public Matrix<N> mean(Matrix<N> A)
   :outertype: AbstractMatrix

mean
^^^^

.. java:method:: public Matrix<N> mean(Matrix<N> A, int axis, Matrix<N> C)
   :outertype: AbstractMatrix

mean
^^^^

.. java:method:: public Matrix<N> mean(Matrix<N> A, int axis)
   :outertype: AbstractMatrix

mean
^^^^

.. java:method::  Matrix<N> mean(Matrix<N> A, int r, int c, Number div, Matrix<N> C)
   :outertype: AbstractMatrix

meann
^^^^^

.. java:method:: public abstract Matrix<N> meann(Matrix<N> A)
   :outertype: AbstractMatrix

meann
^^^^^

.. java:method:: public Matrix<N> meann(Matrix<N> A, int axis)
   :outertype: AbstractMatrix

min
^^^

.. java:method:: public abstract Matrix<N> min(Matrix<N> A)
   :outertype: AbstractMatrix

min
^^^

.. java:method:: public abstract Matrix<N> min(Matrix<N> A, int axis)
   :outertype: AbstractMatrix

min
^^^

.. java:method:: public abstract Matrix<N> min(Matrix<N> A, Number value, Matrix<N> C)
   :outertype: AbstractMatrix

minus
^^^^^

.. java:method:: public abstract Matrix<N> minus(Matrix<N> A, Matrix<N> B, Matrix<N> C)
   :outertype: AbstractMatrix

minus
^^^^^

.. java:method:: public abstract Matrix<N> minus(Matrix<N> A, Matrix<N> B)
   :outertype: AbstractMatrix

minus
^^^^^

.. java:method:: public Matrix<N> minus(Matrix<N> A, Number value)
   :outertype: AbstractMatrix

minus
^^^^^

.. java:method:: public abstract Matrix<N> minus(Matrix<N> A, Number value, Matrix<N> C)
   :outertype: AbstractMatrix

minusi
^^^^^^

.. java:method:: public abstract Matrix<N> minusi(Matrix<N> A, Matrix<N> B)
   :outertype: AbstractMatrix

minusi
^^^^^^

.. java:method:: public Matrix<N> minusi(Matrix<N> A, Number value)
   :outertype: AbstractMatrix

minusn
^^^^^^

.. java:method:: public abstract Matrix<N> minusn(Matrix<N> A, Matrix<N> B)
   :outertype: AbstractMatrix

minusni
^^^^^^^

.. java:method:: public abstract Matrix<N> minusni(Matrix<N> A, Matrix<N> B)
   :outertype: AbstractMatrix

mul
^^^

.. java:method:: public abstract Matrix<N> mul(Matrix<N> A, Matrix<N> B, Matrix<N> C)
   :outertype: AbstractMatrix

mul
^^^

.. java:method:: public abstract Matrix<N> mul(Matrix<N> A, Matrix<N> B)
   :outertype: AbstractMatrix

mul
^^^

.. java:method:: public Matrix<N> mul(Matrix<N> A, Number value)
   :outertype: AbstractMatrix

mul
^^^

.. java:method:: public abstract Matrix<N> mul(Matrix<N> A, Number value, Matrix<N> C)
   :outertype: AbstractMatrix

muli
^^^^

.. java:method:: public abstract Matrix<N> muli(Matrix<N> A, Matrix<N> B)
   :outertype: AbstractMatrix

muli
^^^^

.. java:method:: public Matrix<N> muli(Matrix<N> A, Number value)
   :outertype: AbstractMatrix

neg
^^^

.. java:method:: public Matrix<N> neg(Matrix<N> A)
   :outertype: AbstractMatrix

neg
^^^

.. java:method:: public abstract Matrix<N> neg(Matrix<N> A, Matrix<N> C)
   :outertype: AbstractMatrix

negi
^^^^

.. java:method:: public Matrix<N> negi(Matrix<N> A)
   :outertype: AbstractMatrix

one
^^^

.. java:method:: public Matrix<N> one(Matrix<N> A)
   :outertype: AbstractMatrix

plus
^^^^

.. java:method:: public abstract Matrix<N> plus(Matrix<N> A, Matrix<N> B, Matrix<N> C)
   :outertype: AbstractMatrix

plus
^^^^

.. java:method:: public abstract Matrix<N> plus(Matrix<N> A, Matrix<N> B)
   :outertype: AbstractMatrix

plus
^^^^

.. java:method:: public Matrix<N> plus(Matrix<N> A, Number value)
   :outertype: AbstractMatrix

plus
^^^^

.. java:method:: public abstract Matrix<N> plus(Matrix<N> A, Number value, Matrix<N> C)
   :outertype: AbstractMatrix

plusi
^^^^^

.. java:method:: public abstract Matrix<N> plusi(Matrix<N> A, Matrix<N> B)
   :outertype: AbstractMatrix

plusi
^^^^^

.. java:method:: public Matrix<N> plusi(Matrix<N> A, Number value)
   :outertype: AbstractMatrix

plusn
^^^^^

.. java:method:: public abstract Matrix<N> plusn(Matrix<N> A, Matrix<N> B)
   :outertype: AbstractMatrix

plusni
^^^^^^

.. java:method:: public abstract Matrix<N> plusni(Matrix<N> A, Matrix<N> B)
   :outertype: AbstractMatrix

pow
^^^

.. java:method:: public Matrix<N> pow(Matrix<N> A, Number exponent)
   :outertype: AbstractMatrix

pow
^^^

.. java:method:: public abstract Matrix<N> pow(Matrix<N> A, Number exponent, Matrix<N> C)
   :outertype: AbstractMatrix

pow2
^^^^

.. java:method:: public Matrix<N> pow2(Matrix<N> A)
   :outertype: AbstractMatrix

pow2
^^^^

.. java:method:: public abstract Matrix<N> pow2(Matrix<N> A, Matrix<N> C)
   :outertype: AbstractMatrix

pow2i
^^^^^

.. java:method:: public Matrix<N> pow2i(Matrix<N> A)
   :outertype: AbstractMatrix

powi
^^^^

.. java:method:: public Matrix<N> powi(Matrix<N> A, Number exponent)
   :outertype: AbstractMatrix

print
^^^^^

.. java:method:: public abstract void print(Matrix<N> A)
   :outertype: AbstractMatrix

rand
^^^^

.. java:method:: public abstract Matrix<N> rand(Matrix<N> A)
   :outertype: AbstractMatrix

randn
^^^^^

.. java:method:: public abstract Matrix<N> randn(Matrix<N> A)
   :outertype: AbstractMatrix

rdiv
^^^^

.. java:method:: public Matrix<N> rdiv(Matrix<N> A, Number value)
   :outertype: AbstractMatrix

rdiv
^^^^

.. java:method:: public abstract Matrix<N> rdiv(Matrix<N> A, Number value, Matrix<N> C)
   :outertype: AbstractMatrix

rdivi
^^^^^

.. java:method:: public Matrix<N> rdivi(Matrix<N> A, Number value)
   :outertype: AbstractMatrix

row
^^^

.. java:method:: public Matrix<N> row(Matrix<N> A, int row)
   :outertype: AbstractMatrix

row
^^^

.. java:method:: public abstract Matrix<N> row(Matrix<N> A, int row, Matrix<N> C)
   :outertype: AbstractMatrix

set
^^^

.. java:method:: public abstract void set(Matrix<N> source, int row, int col, Number value)
   :outertype: AbstractMatrix

sigmoid
^^^^^^^

.. java:method:: public abstract Matrix<N> sigmoid(Matrix<N> A, Matrix<N> C)
   :outertype: AbstractMatrix

sigmoidi
^^^^^^^^

.. java:method:: public Matrix<N> sigmoidi(Matrix<N> A)
   :outertype: AbstractMatrix

sqrt
^^^^

.. java:method:: public Matrix<N> sqrt(Matrix<N> A)
   :outertype: AbstractMatrix

sqrt
^^^^

.. java:method:: public abstract Matrix<N> sqrt(Matrix<N> A, Matrix<N> C)
   :outertype: AbstractMatrix

sqrti
^^^^^

.. java:method:: public Matrix<N> sqrti(Matrix<N> A)
   :outertype: AbstractMatrix

std
^^^

.. java:method:: public Matrix<N> std(Matrix<N> A, int axis, int div, int d, Matrix<N> C)
   :outertype: AbstractMatrix

std
^^^

.. java:method:: public Matrix<N> std(Matrix<N> A, int axis, int d, Matrix<N> C)
   :outertype: AbstractMatrix

std
^^^

.. java:method:: public Matrix<N> std(Matrix<N> A, int axis, int d)
   :outertype: AbstractMatrix

stdn
^^^^

.. java:method:: public Matrix<N> stdn(Matrix<N> A, int axis, int div, int d, Matrix<N> C)
   :outertype: AbstractMatrix

stdn
^^^^

.. java:method:: public Matrix<N> stdn(Matrix<N> A, int axis, int d)
   :outertype: AbstractMatrix

sum
^^^

.. java:method:: public Matrix<N> sum(Matrix<N> A)
   :outertype: AbstractMatrix

sum
^^^

.. java:method:: public Matrix<N> sum(Matrix<N> A, int axis)
   :outertype: AbstractMatrix

sum
^^^

.. java:method:: public abstract Matrix<N> sum(Matrix<N> A, int r, int c, Matrix<N> C)
   :outertype: AbstractMatrix

sum
^^^

.. java:method:: public Matrix<N> sum(Matrix<N> A, int axis, Matrix<N> C)
   :outertype: AbstractMatrix

sumn
^^^^

.. java:method:: public abstract Matrix<N> sumn(Matrix<N> A)
   :outertype: AbstractMatrix

sumn
^^^^

.. java:method:: public abstract Matrix<N> sumn(Matrix<N> A, int axis)
   :outertype: AbstractMatrix

sumn
^^^^

.. java:method:: public abstract Matrix<N> sumn(Matrix<N> A, int axis, Matrix<N> C)
   :outertype: AbstractMatrix

sumn
^^^^

.. java:method:: public abstract Matrix<N> sumn(Matrix<N> A, int axis, Matrix<N> B, Matrix<N> C)
   :outertype: AbstractMatrix

tanh
^^^^

.. java:method:: public Matrix<N> tanh(Matrix<N> A)
   :outertype: AbstractMatrix

tanh
^^^^

.. java:method:: public abstract Matrix<N> tanh(Matrix<N> A, Matrix<N> C)
   :outertype: AbstractMatrix

tanhi
^^^^^

.. java:method:: public Matrix<N> tanhi(Matrix<N> A)
   :outertype: AbstractMatrix

threshold
^^^^^^^^^

.. java:method:: public Matrix<N> threshold(Matrix<N> A, Number t)
   :outertype: AbstractMatrix

threshold
^^^^^^^^^

.. java:method:: public Matrix<N> threshold(Matrix<N> A, Number t, Matrix<N> C)
   :outertype: AbstractMatrix

thresholdi
^^^^^^^^^^

.. java:method:: public Matrix<N> thresholdi(Matrix<N> A, Number t)
   :outertype: AbstractMatrix

toString
^^^^^^^^

.. java:method:: public abstract String toString(Matrix<N> A, String separator)
   :outertype: AbstractMatrix

type
^^^^

.. java:method:: abstract Class<N> type()
   :outertype: AbstractMatrix

var
^^^

.. java:method:: public Matrix<N> var(Matrix<N> A, int axis, int d)
   :outertype: AbstractMatrix

var
^^^

.. java:method:: public Matrix<N> var(Matrix<N> A, int axis, int div, int d, Matrix<N> C)
   :outertype: AbstractMatrix

varn
^^^^

.. java:method:: public Matrix<N> varn(Matrix<N> A, int axis, int d)
   :outertype: AbstractMatrix

varn
^^^^

.. java:method:: public Matrix<N> varn(Matrix<N> A, int axis, int div, int d, Matrix<N> C)
   :outertype: AbstractMatrix

zero
^^^^

.. java:method:: public Matrix<N> zero(Matrix<N> A)
   :outertype: AbstractMatrix

