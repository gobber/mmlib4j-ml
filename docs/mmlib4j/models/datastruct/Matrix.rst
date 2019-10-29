.. java:import:: java.util Arrays

.. java:import:: mmlib4j.options Options

.. java:import:: mmlib4j.utils Random

Matrix
======

.. java:package:: mmlib4j.models.datastruct
   :noindex:

.. java:type:: public class Matrix

   A matrix is a rectangular array of numbers arranged by rows and columns. Formally, a matrix can be defined as :math:`A \in \mathbb{R}^{m\times n}` where :math:`m` is the number of rows and :math:`n` is the number of columns. We access a value in a matrix as :math:`A_{i, j}` where :math:`0 \leq i \leq m` and :math:`0 \leq j \leq n`. We say that :math:`A` is a row vector if :math:`m=1` and that :math:`A` is a column vector when :math:`n=1`. This is not the usual definition of a vector, but this simplifies the method definition, since internally they are defined with the Matrix class.

   The Matrix is stored in column major scheme (see \ `here <https://en.wikipedia.org/wiki/Row-_and_column-major_order>`_\ ). This is a decision project that makes possible to apply native code avoiding memory copy since we use \ `BLAS <http://www.netlib.org/blas/>`_\ .

   :author: Charles Ferreira Gobber

   **See also:** :java:ref:`Operations`, :java:ref:`NativeOperations`, :java:ref:`JavaOperations`, :java:ref:`SimpleBlas`

Constructors
------------
Matrix
^^^^^^

.. java:constructor:: public Matrix(int numRows, int numColumns)
   :outertype: Matrix

   A constructor for Matrix.class. This allocate a Matrix with numRows by numColumns size.

   :param numRows: Number of rows of the Matrix.
   :param numColumns: Number of columns of the Matrix.

Matrix
^^^^^^

.. java:constructor:: public Matrix(double[] values, int numRows, int numColumns)
   :outertype: Matrix

   Another constructor for Matrix.class. This allocate a Matrix with numRows by numColumns size. This receives a vector stored in column major scheme (see \ `here <https://en.wikipedia.org/wiki/Row-_and_column-major_order>`_\ ).

   :param values: A vector of double values.
   :param numRows: Number of rows of the Matrix.
   :param numColumns: Number of columns of the Matrix.

Matrix
^^^^^^

.. java:constructor:: public Matrix(double[] values, int numRows, int numColumns, boolean deep)
   :outertype: Matrix

   Another constructor for Matrix.class. This allocate a Matrix with numRows by numColumns size. This receives a vector stored in column major scheme (see \ `here <https://en.wikipedia.org/wiki/Row-_and_column-major_order>`_\ ).

   :param values: A vector of double values.
   :param numRows: Number of rows of the Matrix.
   :param numColumns: Number of columns of the Matrix.
   :param deep: A boolean parameter, if true the values vector is cloned, is not cloned otherwise.

Matrix
^^^^^^

.. java:constructor:: public Matrix(double[][] values)
   :outertype: Matrix

   Another constructor for Matrix.class. This method copies the Matrix values[][]. This stores a vector in column major scheme (see \ `here <https://en.wikipedia.org/wiki/Row-_and_column-major_order>`_\ ).

   :param values: A Matrix of double values.

Methods
-------
T
^

.. java:method:: public Matrix T()
   :outertype: Matrix

   This method returns the transposition of the Matrix, i.e., :math:`C=A^T`, where :math:`C` is allocated internally.

   :return: A Matrix :math:`C` that is :math:`A^T`.

T
^

.. java:method:: public Matrix T(Matrix C)
   :outertype: Matrix

   This method returns the transposition of the Matrix, i.e., :math:`C=A^T`, where :math:`C` is passed by parameter.

   :param A: Matrix :math:`C`.
   :return: A Matrix :math:`C` that is :math:`A^T`.

Tdot
^^^^

.. java:method:: public Matrix Tdot(Matrix B)
   :outertype: Matrix

Tdot
^^^^

.. java:method:: public Matrix Tdot(Matrix B, Matrix C)
   :outertype: Matrix

Tdot
^^^^

.. java:method:: public Matrix Tdot(double value, Matrix B)
   :outertype: Matrix

Tdot
^^^^

.. java:method:: public Matrix Tdot(double value, Matrix B, Matrix C)
   :outertype: Matrix

TdotT
^^^^^

.. java:method:: public Matrix TdotT(Matrix B)
   :outertype: Matrix

TdotT
^^^^^

.. java:method:: public Matrix TdotT(Matrix B, Matrix C)
   :outertype: Matrix

TdotT
^^^^^

.. java:method:: public Matrix TdotT(double value, Matrix B)
   :outertype: Matrix

TdotT
^^^^^

.. java:method:: public Matrix TdotT(double value, Matrix B, Matrix C)
   :outertype: Matrix

argmax
^^^^^^

.. java:method:: public Matrix argmax(int axis)
   :outertype: Matrix

argmin
^^^^^^

.. java:method:: public Matrix argmin(int axis)
   :outertype: Matrix

biggerthen
^^^^^^^^^^

.. java:method:: public Matrix biggerthen(double t)
   :outertype: Matrix

   This method returns a binary Matrix of the following comparison:

   .. math:: \forall (r, c), C_{r, c} = \begin{cases} 1,& \text{ if } A_{r, c} > t,\\ 0,& \text{ otherwise }\\ \end{cases}

   where :math:`t \in \mathbb{R}` is a threshold and :math:`C` is a Matrix allocated inside the method.

   :param t: The value of threshold.
   :return: The Matrix :math:`C` with the binary comparison.

biggerthen
^^^^^^^^^^

.. java:method:: public Matrix biggerthen(double t, Matrix C)
   :outertype: Matrix

   This method returns a binary Matrix of the following comparison:

   .. math:: \forall (r, c), C_{r, c} = \begin{cases} 1,& \text{ if } A_{r, c} > t,\\ 0,& \text{ otherwise }\\ \end{cases}

   where :math:`t \in \mathbb{R}` is a threshold and :math:`C` is a Matrix passed by parameter.

   :param t: The value of threshold.
   :return: The Matrix :math:`C` with the binary comparison.

biggertheni
^^^^^^^^^^^

.. java:method:: public Matrix biggertheni(double t)
   :outertype: Matrix

   This method returns a in place binary Matrix of the following comparison:

   .. math:: \forall (r, c), A_{r, c} = \begin{cases} 1,& \text{ if } A_{r, c} > t,\\ 0,& \text{ otherwise }\\ \end{cases}

   where :math:`t \in \mathbb{R}` is a threshold.

   :param t: The value of threshold.
   :return: The Matrix :math:`C` with the binary comparison.

column
^^^^^^

.. java:method:: public Matrix column(int column)
   :outertype: Matrix

   This method returns a given column of the Matrix. This method implements the following operation:

   .. math:: \forall r=1,\ldots,m,~ C_{r,c}=A_{r,c},

   where :math:`1\leq c\leq n` is the column and :math:`C` is a Matrix allocated inside the method.

   :param column: A column of :math:`A`
   :return: A column Matrix (or a vector) of a given column.

column
^^^^^^

.. java:method:: public Matrix column(int column, Matrix C)
   :outertype: Matrix

   This method returns a given column of the Matrix, but it writes the values in the Matrix :math:`C`. This method implements the following operation:

   .. math:: \forall r=1,\ldots,m,~ C_{r,c}=A_{r,c},

   where :math:`1\leq c\leq n` is the column and :math:`C` is a Matrix passed by parameter.

   :param column: A column of :math:`A`
   :param C: A Matrix to store the column of :math:`A`
   :return: The Matrix :math:`C` filled by the given column of :math:`A`

copy
^^^^

.. java:method:: public Matrix copy()
   :outertype: Matrix

   This method copies the Matrix.

   :return: Returns a copy of the instantiated Matrix.

div
^^^

.. java:method:: public void div(int row, int col, double value)
   :outertype: Matrix

   This method divides the value stored in Matrix position (row, col) by a value passed for parameter. This method implements the following operation:

   .. math:: A_{r,c}=\frac{A_{r, c}}{v},

   where :math:`r` is the number of rows, :math:`c` is the number of columns and :math:`v` is the value.

   :param row: A valid row of the Matrix.
   :param col: A valid col of the Matrix.
   :param value: A value to divides the value stored in (row, col).

div
^^^

.. java:method:: public void div(int pos, double value)
   :outertype: Matrix

   This method divides the value stored in Matrix position (row, col) by a value passed for parameter. This method implements the following operation:

   .. math:: A_{r,c}=\frac{A_{r, c}}{v},

   where :math:`r=\lfloor \frac{pos}{m} \rfloor` is the number of rows and :math:`c=(pos\equiv m)` is the number of columns.

   :param pos: A valid position of the Matrix.
   :param value: A value to divides the value stored in (row, col).

div
^^^

.. java:method:: public Matrix div(Matrix B, Matrix C)
   :outertype: Matrix

   This method returns the point wise division between two Matrix. This supports broadcasting operations. This method implements the following operation:

   .. math:: C = \frac{A}{B}

   where :math:`C` (passed by parameter) is the point wise division between :math:`A` and :math:`B`.

   :param B: A Matrix :math:`B` to divide with :math:`A`.
   :param C: A Matrix :math:`C` to store the point wise division between :math:`A` and :math:`B`.
   :return: The Matrix :math:`C` that is the point wise division between :math:`A` and :math:`B`.

div
^^^

.. java:method:: public Matrix div(Matrix B)
   :outertype: Matrix

   This method returns the point wise division between two Matrix. This supports broadcasting operations. This method implements the following operation:

   .. math:: C = \frac{A}{B}

   where :math:`C` (allocated internally) is the point wise division between :math:`A` and :math:`B`.

   :param B: A Matrix :math:`B` to divide with :math:`A`.
   :return: The Matrix :math:`C` that is the point wise division between :math:`A` and :math:`B`.

div
^^^

.. java:method:: public Matrix div(double value)
   :outertype: Matrix

   This method returns the scalar division between a Matrix and a value. This method implements the following operation:

   .. math:: C = \frac{A}{v}

   where :math:`C` (allocated internally) is the scalar division between :math:`A` and :math:`v`.

   :param value: A scalar to divide with :math:`A`.
   :return: The Matrix :math:`C` that is the scalar division between :math:`A` and :math:`v`.

div
^^^

.. java:method:: public Matrix div(double value, Matrix C)
   :outertype: Matrix

   This method returns the scalar division between a Matrix and a value. This method implements the following operation:

   .. math:: C = \frac{A}{v}

   where :math:`C` (passed by parameter) is the scalar division between :math:`A` and :math:`v`.

   :param value: A scalar to divide with :math:`A`.
   :param C: A Matrix :math:`C` to store the scalar division between :math:`A` and :math:`v`.
   :return: The Matrix :math:`C` that is the scalar division between :math:`A` and :math:`v`.

divi
^^^^

.. java:method:: public Matrix divi(double value)
   :outertype: Matrix

   This method returns the in place scalar division between a Matrix and a value. This method implements the following operation:

   .. math:: A = A - v

   where :math:`A` is the in place scalar division between :math:`A` and :math:`v`.

   :param value: A scalar to divide with :math:`A`.
   :return: The Matrix :math:`A` that is the in place scalar division between :math:`A` and :math:`v`.

divi
^^^^

.. java:method:: public Matrix divi(Matrix B)
   :outertype: Matrix

   This method returns the in place point wise division between two Matrix. This supports broadcasting operations. This method implements the following operation:

   .. math:: A = \frac{A}{B}

   where :math:`A` is the in place point wise division between :math:`A` and :math:`B`.

   :param B: A Matrix :math:`B` to divide with :math:`A`.
   :return: The Matrix :math:`A` that is the in place point wise division between :math:`A` and :math:`B`.

dot
^^^

.. java:method:: public Matrix dot(Matrix B)
   :outertype: Matrix

dot
^^^

.. java:method:: public Matrix dot(Matrix B, Matrix C)
   :outertype: Matrix

dot
^^^

.. java:method:: public Matrix dot(double value, Matrix B)
   :outertype: Matrix

dot
^^^

.. java:method:: public Matrix dot(double value, Matrix B, Matrix C)
   :outertype: Matrix

dotT
^^^^

.. java:method:: public Matrix dotT(Matrix B)
   :outertype: Matrix

dotT
^^^^

.. java:method:: public Matrix dotT(Matrix B, Matrix C)
   :outertype: Matrix

dotT
^^^^

.. java:method:: public Matrix dotT(double value, Matrix B)
   :outertype: Matrix

dotT
^^^^

.. java:method:: public Matrix dotT(double value, Matrix B, Matrix C)
   :outertype: Matrix

exp
^^^

.. java:method:: public Matrix exp()
   :outertype: Matrix

exp
^^^

.. java:method:: public Matrix exp(Matrix C)
   :outertype: Matrix

expi
^^^^

.. java:method:: public Matrix expi()
   :outertype: Matrix

fill
^^^^

.. java:method:: public Matrix fill(double value)
   :outertype: Matrix

   This method fills the Matrix by value. This method implements the following operation:

   .. math:: \forall (r, c), A_{r,c}=v,

   where :math:`v` is a value to fill :math:`A`.

   :param value: The value to fill the Matrix.

get
^^^

.. java:method:: public double get(int pos)
   :outertype: Matrix

   This method return a value of the Matrix from pos.

   :param pos: A valid position of the Matrix.
   :return: Value of the position pos.

get
^^^

.. java:method:: public double get(int row, int col)
   :outertype: Matrix

   This method return a value of the Matrix from a position (row, col).

   :param row: A valid row of the Matrix.
   :param col: A valid col of the Matrix.
   :return: Value of the position (row, col).

getData
^^^^^^^

.. java:method:: public double[] getData()
   :outertype: Matrix

   This method returns the data that represents the Matrix.

   :return: The vector of Matrix values.

getSeparator
^^^^^^^^^^^^

.. java:method:: public String getSeparator()
   :outertype: Matrix

   This method returns the separator of the Matrix.

   :return: Returns the separator. Default is ";"

head
^^^^

.. java:method:: public void head(int numRows, int numColumns, String format)
   :outertype: Matrix

   This method prints the Matrix given a maximum number of (numRows, numColumns) and a given format.

   :param numRows: The maximum number of rows.
   :param numColumns: The maximum number of columns.
   :param format: The format to print the Matrix.

head
^^^^

.. java:method:: public void head(int numRows, int numColumns)
   :outertype: Matrix

   This method prints the Matrix given a maximum number of (numRows, numColumns) and the format "[%e]".

   :param numRows: The maximum number of rows.
   :param numColumns: The maximum number of columns.

head
^^^^

.. java:method:: public void head()
   :outertype: Matrix

   This method prints the first 6 lines of the Matrix, or numRows if 6 > numRows.

head
^^^^

.. java:method:: public void head(int numRows)
   :outertype: Matrix

   This method prints the first numRows lines of the Matrix, or this.numRows if numRows > this.numRows.

   :param numRows: Number of rows to be printed.

isColVector
^^^^^^^^^^^

.. java:method:: public boolean isColVector()
   :outertype: Matrix

   This method tests if a Matrix is a column vector or not.

   :return: Returns true if the Matrix is a column vector and false otherwise.

isMatrix
^^^^^^^^

.. java:method:: public boolean isMatrix()
   :outertype: Matrix

   This method tests if a Matrix is a matrix.

   :return: Returns true if the Matrix is a matrix and false otherwise.

isRowVector
^^^^^^^^^^^

.. java:method:: public boolean isRowVector()
   :outertype: Matrix

   This method tests if a Matrix is a row vector or not.

   :return: Returns true if the Matrix is a row vector and false otherwise.

isScalar
^^^^^^^^

.. java:method:: public boolean isScalar()
   :outertype: Matrix

   This method tests if a Matrix is a scalar or not.

   :return: Returns true if the Matrix is a scalar and false otherwise.

length
^^^^^^

.. java:method:: public int length()
   :outertype: Matrix

   This method returns the length of the Matrix.

   :return: The length of the Matrix (numRows x numColumns).

lessthen
^^^^^^^^

.. java:method:: public Matrix lessthen(double t)
   :outertype: Matrix

   This method returns a binary Matrix of the following comparison:

   .. math:: \forall (r, c), C_{r, c} = \begin{cases} 1,& \text{ if } A_{r, c} < t,\\ 0,& \text{ otherwise }\\ \end{cases}

   where :math:`t \in \mathbb{R}` is a threshold and :math:`C` is a Matrix passed by parameter.

   :param t: The value of threshold.
   :return: The Matrix :math:`C` with the binary comparison.

lessthen
^^^^^^^^

.. java:method:: public Matrix lessthen(double t, Matrix C)
   :outertype: Matrix

   This method returns a binary Matrix of the following comparison:

   .. math:: \forall (r, c), C_{r, c} = \begin{cases} 1,& \text{ if } A_{r, c} < t,\\ 0,& \text{ otherwise }\\ \end{cases}

   where :math:`t \in \mathbb{R}` is a threshold and :math:`C` is a Matrix allocated inside the method.

   :param t: The value of threshold.
   :return: The Matrix :math:`C` with the binary comparison.

lesstheni
^^^^^^^^^

.. java:method:: public Matrix lesstheni(double t)
   :outertype: Matrix

   This method returns a in place binary Matrix of the following comparison:

   .. math:: \forall (r, c), A_{r, c} = \begin{cases} 1,& \text{ if } A_{r, c} < t,\\ 0,& \text{ otherwise }\\ \end{cases}

   where :math:`t \in \mathbb{R}` is a threshold.

   :param t: The value of threshold.
   :return: The in place Matrix :math:`A` with the binary comparison.

max
^^^

.. java:method:: public Matrix max()
   :outertype: Matrix

max
^^^

.. java:method:: public Matrix max(int axis)
   :outertype: Matrix

max
^^^

.. java:method:: public Matrix max(double value, Matrix C)
   :outertype: Matrix

maxi
^^^^

.. java:method:: public Matrix maxi(double value)
   :outertype: Matrix

mean
^^^^

.. java:method:: public Matrix mean()
   :outertype: Matrix

mean
^^^^

.. java:method:: public Matrix mean(int axis, Matrix C)
   :outertype: Matrix

mean
^^^^

.. java:method:: public Matrix mean(int axis)
   :outertype: Matrix

min
^^^

.. java:method:: public Matrix min()
   :outertype: Matrix

min
^^^

.. java:method:: public Matrix min(int axis)
   :outertype: Matrix

min
^^^

.. java:method:: public Matrix min(double value, Matrix C)
   :outertype: Matrix

minus
^^^^^

.. java:method:: public void minus(int row, int col, double value)
   :outertype: Matrix

   This method subtracts the value stored in Matrix position (row, col) by a value passed for parameter. This method implements the following operation:

   .. math:: A_{r,c}=A_{r, c}-v,

   where :math:`r` is the number of rows, :math:`c` is the number of columns and :math:`v` is the value.

   :param row: A valid row of the Matrix.
   :param col: A valid col of the Matrix.
   :param value: A value to subtracts the value stored in (row, col).

minus
^^^^^

.. java:method:: public void minus(int pos, double value)
   :outertype: Matrix

   This method subtracts the value stored in Matrix position (row, col) by a value passed for parameter. This method implements the following operation:

   .. math:: A_{r,c}=A_{r, c}-v,

   where :math:`r=\lfloor \frac{pos}{m} \rfloor` is the number of rows and :math:`c=(pos\equiv m)` is the number of columns.

   :param pos: A valid position of the Matrix.
   :param value: A value to subtracts the value stored in (row, col).

minus
^^^^^

.. java:method:: public Matrix minus(Matrix B)
   :outertype: Matrix

   This method returns the point wise subtraction between two Matrix. It is computed natively if Options.operations = Operations.NATIVE and :math:`B` is not a scalar, and no native otherwise. This supports broadcasting operations. This method implements the following operation:

   .. math:: C = A - B

   where :math:`C` (allocated internally) is the point wise subtraction between :math:`A` and :math:`B`.

   :param B: A Matrix :math:`B` to subtract with :math:`A`.
   :return: The Matrix :math:`C` that is the point wise subtraction between :math:`A` and :math:`B`.

minus
^^^^^

.. java:method:: public Matrix minus(Matrix B, Matrix C)
   :outertype: Matrix

   This method returns the point wise subtraction between two Matrix. This supports broadcasting operations. This method implements the following operation:

   .. math:: C = A - B

   where :math:`C` (passed by parameter) is the point wise subtraction between :math:`A` and :math:`B`.

   :param B: A Matrix :math:`B` to subtract with :math:`A`.
   :param C: A Matrix :math:`C` to store the point wise subtraction between :math:`A` and :math:`B`.
   :return: The Matrix :math:`C` that is the point wise subtraction between :math:`A` and :math:`B`.

minus
^^^^^

.. java:method:: public Matrix minus(double value)
   :outertype: Matrix

   This method returns the scalar subtraction between a Matrix and a value. This method implements the following operation:

   .. math:: C = A - v

   where :math:`C` (allocated internally) is the scalar subtraction between :math:`A` and :math:`v`.

   :param value: A scalar to subtract with :math:`A`.
   :return: The Matrix :math:`C` that is the scalar subtraction between :math:`A` and :math:`v`.

minus
^^^^^

.. java:method:: public Matrix minus(double value, Matrix C)
   :outertype: Matrix

   This method returns the scalar subtraction between a Matrix and a value. This method implements the following operation:

   .. math:: C = A - v

   where :math:`C` (passed by parameter) is the scalar subtraction between :math:`A` and :math:`v`.

   :param value: A scalar to subtract with :math:`A`.
   :param C: A Matrix :math:`C` to store the scalar subtraction between :math:`A` and :math:`v`.
   :return: The Matrix :math:`C` that is the scalar subtraction between :math:`A` and :math:`v`.

minusi
^^^^^^

.. java:method:: public Matrix minusi(Matrix B)
   :outertype: Matrix

   This method returns the in place point wise subtraction between two Matrix. It is computed natively if Options.operations = Operations.NATIVE and :math:`B` is not a scalar, and no native otherwise. This supports broadcasting operations. This method implements the following operation:

   .. math:: A = A - B

   where :math:`A` is the in place point wise subtraction between :math:`A` and :math:`B`.

   :param B: A Matrix :math:`B` to subtract with :math:`A`.
   :return: The Matrix :math:`A` that is the in place point wise subtraction between :math:`A` and :math:`B`.

minusi
^^^^^^

.. java:method:: public Matrix minusi(double value)
   :outertype: Matrix

   This method returns the in place scalar subtraction between a Matrix and a value. This method implements the following operation:

   .. math:: A = A - v

   where :math:`A` is the in place scalar subtraction between :math:`A` and :math:`v`.

   :param value: A scalar to subtract with :math:`A`.
   :return: The Matrix :math:`A` that is the in place scalar subtraction between :math:`A` and :math:`v`.

mul
^^^

.. java:method:: public void mul(int row, int col, double value)
   :outertype: Matrix

   This method multiplies the value stored in Matrix position (row, col) by a value passed for parameter. This method implements the following operation:

   .. math:: A_{r,c}=A_{r, c}*v,

   where :math:`r` is the number of rows, :math:`c` is the number of columns and :math:`v` is the value.

   :param row: A valid row of the Matrix.
   :param col: A valid col of the Matrix.
   :param value: A value to multiplies the value stored in (row, col).

mul
^^^

.. java:method:: public void mul(int pos, double value)
   :outertype: Matrix

   This method multiplies the value stored in Matrix position (row, col) by a value passed for parameter. This method implements the following operation:

   .. math:: A_{r,c}=A_{r, c}*v,

   where :math:`r=\lfloor \frac{pos}{m} \rfloor` is the number of rows and :math:`c=(pos\equiv m)` is the number of columns.

   :param pos: A valid position of the Matrix.
   :param value: A value to multiplies the value stored in (row, col).

mul
^^^

.. java:method:: public Matrix mul(Matrix B, Matrix C)
   :outertype: Matrix

   This method returns the point wise multiplication between two Matrix. This supports broadcasting operations. This method implements the following operation:

   .. math:: C = A * B

   where :math:`C` (passes by parameter) is the point wise multiplication between :math:`A` and :math:`B`.

   :param B: A Matrix :math:`B` to multiplies with :math:`A`.
   :param C: A Matrix :math:`C` to store :math:`A*B`.
   :return: The Matrix :math:`C` that is the point wise multiplication between :math:`A` and :math:`B`.

mul
^^^

.. java:method:: public Matrix mul(Matrix B)
   :outertype: Matrix

   This method returns the point wise multiplication between two Matrix. This supports broadcasting operations. This method implements the following operation:

   .. math:: C = A * B

   where :math:`C` (allocated internally) is the point wise multiplication between :math:`A` and :math:`B`.

   :param B: A Matrix :math:`B` to multiplies with :math:`A`.
   :param C: A Matrix :math:`C` to store :math:`A*B`.
   :return: The Matrix :math:`C` that is the point wise multiplication between :math:`A` and :math:`B`.

mul
^^^

.. java:method:: public Matrix mul(double value)
   :outertype: Matrix

   This method returns the scalar multiplication between two :math:`A` and :math:`v`. This supports broadcasting operations. This method implements the following operation:

   .. math:: C = A * v

   where :math:`v` is a value and :math:`C` (allocated internally) is the scalar multiplication between :math:`A` and :math:`v`.

   :param value: A value to multiplies with :math:`A`.
   :return: The Matrix :math:`C` that is the scalar multiplication between :math:`A` and :math:`v`.

mul
^^^

.. java:method:: public Matrix mul(double value, Matrix C)
   :outertype: Matrix

   This method returns the scalar multiplication between two :math:`A` and :math:`v`. This supports broadcasting operations. This method implements the following operation:

   .. math:: C = A * v

   where :math:`v` is a value and :math:`C` (passed by parameter) is the scalar multiplication between :math:`A` and :math:`v`.

   :param value: A value to multiplies with :math:`A`.
   :param C: A Matrix :math:`C` to store :math:`A*v`.
   :return: The Matrix :math:`C` that is scalar multiplication between :math:`A` and :math:`v`.

muli
^^^^

.. java:method:: public Matrix muli(Matrix B)
   :outertype: Matrix

   This method returns the in place point wise multiplication between two Matrix. This supports broadcasting operations. This method implements the following operation:

   .. math:: A = A * B

   :param B: A Matrix :math:`B` to multiplies with :math:`A`.
   :return: The Matrix :math:`A` that is the in place point wise multiplication between :math:`A` and :math:`B`.

muli
^^^^

.. java:method:: public Matrix muli(double value)
   :outertype: Matrix

   This method returns the in place scalar multiplication between two :math:`A` and :math:`v`. This supports broadcasting operations. This method implements the following operation:

   .. math:: A = A * v

   where :math:`v` is a value.

   :param value: A value to multiplies with :math:`A`.
   :return: The Matrix :math:`A` that is the in place scalar multiplication between :math:`A` and :math:`v`.

neg
^^^

.. java:method:: public void neg(int row, int col)
   :outertype: Matrix

   This method negates the value stored in Matrix position (row, col). This method implements the following operation:

   .. math:: A_{r,c}=A_{r, c}*-1,

   where :math:`r` is the number of rows and :math:`c` is the number of columns.

   :param row: A valid row of the Matrix.
   :param col: A valid col of the Matrix.

neg
^^^

.. java:method:: public void neg(int pos)
   :outertype: Matrix

   This method negates the value stored in Matrix position (row, col). This method implements the following operation:

   .. math:: A_{r,c}=A_{r, c}*-1,

   where :math:`r=\lfloor \frac{pos}{m} \rfloor` is the number of rows and :math:`c=(pos\equiv m)` is the number of columns.

   :param pos: A valid position of the Matrix.

neg
^^^

.. java:method:: public Matrix neg()
   :outertype: Matrix

neg
^^^

.. java:method:: public Matrix neg(Matrix C)
   :outertype: Matrix

negi
^^^^

.. java:method:: public Matrix negi()
   :outertype: Matrix

numColumns
^^^^^^^^^^

.. java:method:: public int numColumns()
   :outertype: Matrix

   This method returns the number of columns of the Matrix.

   :return: The number of columns of the Matrix.

numColumns
^^^^^^^^^^

.. java:method:: public void numColumns(int numColumns)
   :outertype: Matrix

   This method sets the number of columns of the Matrix.

   :param numColumns: The number of columns of the Matrix.

numRows
^^^^^^^

.. java:method:: public int numRows()
   :outertype: Matrix

   This method returns the number of rows of the Matrix.

   :return: The number of rows of the Matrix.

numRows
^^^^^^^

.. java:method:: public void numRows(int numRows)
   :outertype: Matrix

   This method sets the number of rows of the Matrix.

   :param numRows: The number of rows of the Matrix.

one
^^^

.. java:method:: public Matrix one()
   :outertype: Matrix

   This method fills the Matrix with 1s. This method implements the following operation: :math:`\forall (r, c), A_{r,c}=1`

ones
^^^^

.. java:method:: public static Matrix ones(int numRows, int numColumns)
   :outertype: Matrix

plus
^^^^

.. java:method:: public void plus(int row, int col, double value)
   :outertype: Matrix

   This method adds the value stored in Matrix position (row, col) by a value passed for parameter. This method implements the following operation:

   .. math:: A_{r,c}=A_{r, c}+v,

   where :math:`r` is the number of rows, :math:`c` is the number of columns and :math:`v` is the value.

   :param row: A valid row of the Matrix.
   :param col: A valid col of the Matrix.
   :param value: A value to adds the value stored in (row, col).

plus
^^^^

.. java:method:: public void plus(int pos, double value)
   :outertype: Matrix

   This method adds the value stored in Matrix position (row, col) by a value passed for parameter. This method implements the following operation:

   .. math:: A_{r,c}=A_{r, c}+v,

   where :math:`r=\lfloor \frac{pos}{m} \rfloor` is the number of rows and :math:`c=(pos\equiv m)` is the number of columns.

   :param pos: A valid position of the Matrix.
   :param value: A value to adds the value stored in (row, col).

plus
^^^^

.. java:method:: public Matrix plus(Matrix B)
   :outertype: Matrix

   This method returns the point wise summation between two Matrix. It is computed natively if Options.operations = Operations.NATIVE and :math:`B` is not a scalar, and no native otherwise. This supports broadcasting operations. This method implements the following operation:

   .. math:: C = A + B

   where :math:`C` (allocated internally) is the point wise summation between :math:`A` and :math:`B`.

   :param B: A Matrix :math:`B` to sum with :math:`A`.
   :return: The Matrix :math:`C` that is the point wise summation between :math:`A` and :math:`B`.

plus
^^^^

.. java:method:: public Matrix plus(Matrix B, Matrix C)
   :outertype: Matrix

   This method returns the in place point wise summation between two Matrix. This supports broadcasting operations. This method implements the following operation:

   .. math:: C = A + B

   where :math:`C` is the point wise summation between :math:`A` and :math:`B`.

   :param B: A Matrix :math:`B` to sum with :math:`A`.
   :param C: A Matrix :math:`C` to store the point wise summation between :math:`A` and :math:`B`.
   :return: The Matrix :math:`C` that is the point wise summation between :math:`A` and :math:`B`.

plus
^^^^

.. java:method:: public Matrix plus(double value)
   :outertype: Matrix

   This method returns the scalar summation between a Matrix and a value. This method implements the following operation:

   .. math:: C = A + v

   where :math:`C` (allocated internally) is the scalar summation between :math:`A` and :math:`v`.

   :param value: A scalar to sum with :math:`A`.
   :return: The Matrix :math:`C` that is the scalar summation between :math:`A` and :math:`v`.

plus
^^^^

.. java:method:: public Matrix plus(double value, Matrix C)
   :outertype: Matrix

   This method returns the scalar summation between a Matrix and a value. This method implements the following operation:

   .. math:: C = A + v

   where :math:`C` (passed by parameter) is the scalar summation between :math:`A` and :math:`v`.

   :param value: A scalar to sum with :math:`A`.
   :param C: A Matrix :math:`C` to store the scalar summation between :math:`A` and :math:`v`.
   :return: The Matrix :math:`C` that is the scalar summation between :math:`A` and :math:`v`.

plusi
^^^^^

.. java:method:: public Matrix plusi(Matrix B)
   :outertype: Matrix

   This method returns the in place point wise summation between two Matrix. It is computed natively if Options.operations = Operations.NATIVE, and no native otherwise. This supports broadcasting operations. This method implements the following operation:

   .. math:: A = A + B

   where :math:`A` is the in place point wise summation between :math:`A` and :math:`B`.

   :param B: A Matrix :math:`B` to sum with :math:`A`.
   :return: The Matrix :math:`A` that is the in place point wise summation between :math:`A` and :math:`B`.

plusi
^^^^^

.. java:method:: public Matrix plusi(double value)
   :outertype: Matrix

   This method returns the in place scalar summation between a Matrix and a value. This method implements the following operation:

   .. math:: A = A + v

   where :math:`A` is the in place scalar summation between :math:`A` and :math:`v`.

   :param value: A scalar to sum with :math:`A`.
   :return: The Matrix :math:`A` that is the in place scalar summation between :math:`A` and :math:`v`.

pow
^^^

.. java:method:: public Matrix pow(double exponent)
   :outertype: Matrix

pow
^^^

.. java:method:: public Matrix pow(double exponent, Matrix C)
   :outertype: Matrix

pow2
^^^^

.. java:method:: public void pow2(int row, int col)
   :outertype: Matrix

   This method squares the value stored in Matrix position (row, col). This method implements the following operation:

   .. math:: A_{r,c}=A_{r, c}^2,

   where :math:`r` is the number of rows and :math:`c` is the number of columns.

   :param row: A valid row of the Matrix.
   :param col: A valid col of the Matrix.

pow2
^^^^

.. java:method:: public void pow2(int pos)
   :outertype: Matrix

   This method squares the value stored in Matrix position (row, col). This method implements the following operation:

   .. math:: A_{r,c}=A_{r, c}^2,

   where :math:`r=\lfloor \frac{pos}{m} \rfloor` is the number of rows and :math:`c=(pos\equiv m)` is the number of columns.

   :param pos: A valid position of the Matrix.

pow2
^^^^

.. java:method:: public Matrix pow2()
   :outertype: Matrix

pow2
^^^^

.. java:method:: public Matrix pow2(Matrix C)
   :outertype: Matrix

pow2i
^^^^^

.. java:method:: public Matrix pow2i()
   :outertype: Matrix

powi
^^^^

.. java:method:: public Matrix powi(double exponent)
   :outertype: Matrix

print
^^^^^

.. java:method:: public void print()
   :outertype: Matrix

   This method prints the Matrix.

rand
^^^^

.. java:method:: public Matrix rand()
   :outertype: Matrix

rand
^^^^

.. java:method:: public static Matrix rand(int numRows, int numColumns)
   :outertype: Matrix

randn
^^^^^

.. java:method:: public static Matrix randn(int numRows, int numColumns)
   :outertype: Matrix

randnorm
^^^^^^^^

.. java:method:: public Matrix randnorm()
   :outertype: Matrix

row
^^^

.. java:method:: public Matrix row(int row)
   :outertype: Matrix

   This method returns a given row of the Matrix. This method implements the following operation:

   .. math:: \forall c=1,\ldots,n,~ C_{1,c}=A_{r,c},

   where :math:`r` is the row and :math:`C` is a Matrix allocated inside the method.

   :param row: A row of :math:`A`
   :return: A row Matrix (or a vector) of a given row.

row
^^^

.. java:method:: public Matrix row(int row, Matrix C)
   :outertype: Matrix

   This method returns a given row of the Matrix, but it writes the values in the Matrix :math:`C`. This method implements the following operation:

   .. math:: \forall c=1,\ldots,n,~ C_{r,c}=A_{r,c},

   where :math:`1\leq r\leq m` is the row and :math:`C` is a Matrix passed by parameter.

   :param row: A row of :math:`A`
   :param C: A Matrix to store the row of :math:`A`
   :return: The Matrix :math:`C` filled by the given row of :math:`A`

set
^^^

.. java:method:: public void set(int pos, double value)
   :outertype: Matrix

   This method sets a value of the Matrix from a position pos.

   :param pos: A valid position of the Matrix.
   :param value: A value to be stored in pos.

set
^^^

.. java:method:: public void set(int row, int col, double value)
   :outertype: Matrix

   This method sets a value of the Matrix from a position (row, col).

   :param row: A valid row of the Matrix.
   :param col: A valid col of the Matrix.
   :param value: A value to be stored in (row, col).

setData
^^^^^^^

.. java:method:: public void setData(double[] data)
   :outertype: Matrix

   This method sets the data that represents the Matrix.

   :param data: A vector of doubles.

setSeparator
^^^^^^^^^^^^

.. java:method:: public void setSeparator(String separator)
   :outertype: Matrix

   This method sets the separator of the Matrix.

   :param separator: A String separator useful to save store a Matrix as a file.

shape
^^^^^

.. java:method:: public String shape()
   :outertype: Matrix

   This method returns a string with the shape of the Matrix.

   :return: Returns (numRows, numColumns)

sigmoid
^^^^^^^

.. java:method:: public Matrix sigmoid(Matrix C)
   :outertype: Matrix

sigmoidi
^^^^^^^^

.. java:method:: public Matrix sigmoidi()
   :outertype: Matrix

sqrt
^^^^

.. java:method:: public Matrix sqrt()
   :outertype: Matrix

sqrt
^^^^

.. java:method:: public Matrix sqrt(Matrix C)
   :outertype: Matrix

sqrti
^^^^^

.. java:method:: public Matrix sqrti()
   :outertype: Matrix

std
^^^

.. java:method:: public Matrix std(int axis, int d)
   :outertype: Matrix

sum
^^^

.. java:method:: public Matrix sum()
   :outertype: Matrix

   This method returns the sum of all elements of the Matrix. It is computed natively if Options.operations = Operations.NATIVE, and no native otherwise. This method implements the following operation:

   .. math:: s = \sum_{r=1}^m\sum_{c=1}^nA_{r, c}

   where :math:`s` is the sum of :math:`A`.

   :return: The Matrix :math:`C` of the sum of all elements of :math:`A`

sum
^^^

.. java:method:: public Matrix sum(int axis)
   :outertype: Matrix

   This method returns the sum of all elements of the Matrix of a given axis. It is computed natively if Options.operations = Operations.NATIVE, and no native otherwise. This method implements the following operation:

   .. math:: \begin{align} C_{1, c} &= \sum_{r=1}^mA_{r, c}, 1\leq c \leq n, \text{ if } axis=0\\ C_{r, 1} &= \sum_{c=1}^nA_{r, c}, 1\leq r \leq m, \text{ if } axis=1 \end{align}

   where :math:`C` (allocated internally) is the sum of a given axis of :math:`A`.

   :param axis: A valid axis, 0 or 1.
   :return: The Matrix :math:`C` the sum of a given axis of :math:`A`

sum
^^^

.. java:method:: public Matrix sum(int axis, Matrix C)
   :outertype: Matrix

   This method returns the sum of all elements of the Matrix of a given axis. It is computed natively if Options.operations = Operations.NATIVE, and no native otherwise. This method implements the following operation:

   .. math:: \begin{align} C_{1, c} &= \sum_{r=1}^mA_{r, c}, 1\leq c \leq n, \text{ if } axis=0\\ C_{r, 1} &= \sum_{c=1}^nA_{r, c}, 1\leq r \leq m, \text{ if } axis=1 \end{align}

   where :math:`C` (passed by parameter) is the sum of a given axis of :math:`A`.

   :param axis: A valid axis, 0 or 1.
   :param A: Matrix :math:`C` to store the sum.
   :return: The Matrix :math:`C` the sum of a given axis of :math:`A`.

tanh
^^^^

.. java:method:: public Matrix tanh()
   :outertype: Matrix

tanh
^^^^

.. java:method:: public Matrix tanh(Matrix C)
   :outertype: Matrix

tanhi
^^^^^

.. java:method:: public Matrix tanhi()
   :outertype: Matrix

toString
^^^^^^^^

.. java:method:: public String toString()
   :outertype: Matrix

   This method converts the Matrix to a String.

   :return: A String that represents the Matrix.

var
^^^

.. java:method:: public Matrix var(int axis, int d)
   :outertype: Matrix

zero
^^^^

.. java:method:: public Matrix zero()
   :outertype: Matrix

   This method fills the Matrix with 0s. This method implements the following operation: :math:`\forall (r, c), A_{r,c}=0`

zeros
^^^^^

.. java:method:: public static Matrix zeros(int numRows, int numColumns)
   :outertype: Matrix

