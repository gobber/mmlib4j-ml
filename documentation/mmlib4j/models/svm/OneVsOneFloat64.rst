.. java:import:: mmlib4j.models.datastruct Matrix

.. java:import:: mmlib4j.models.preprocessing Scaler

.. java:import:: mmlib4j.models.svm.kernels Kernel

OneVsOneFloat64
===============

.. java:package:: mmlib4j.models.svm
   :noindex:

.. java:type:: public class OneVsOneFloat64 implements MulticlassStrategy<double[]>

Constructors
------------
OneVsOneFloat64
^^^^^^^^^^^^^^^

.. java:constructor:: public OneVsOneFloat64()
   :outertype: OneVsOneFloat64

Methods
-------
load
^^^^

.. java:method:: @Override public MulticlassStrategy<double[]> load(ClassifierSVC<double[]> clf, Matrix<double[]> vectors, Matrix<double[]> coefficients, Scaler<double[]> scaler, Kernel<double[]> K, Matrix<double[]> intercepts, int[] classes)
   :outertype: OneVsOneFloat64

predict
^^^^^^^

.. java:method:: @Override public Matrix<double[]> predict(Matrix<double[]> x)
   :outertype: OneVsOneFloat64

