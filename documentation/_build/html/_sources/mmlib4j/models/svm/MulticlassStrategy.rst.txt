.. java:import:: mmlib4j.models.datastruct Matrix

.. java:import:: mmlib4j.models.preprocessing Scaler

.. java:import:: mmlib4j.models.svm.kernels Kernel

MulticlassStrategy
==================

.. java:package:: mmlib4j.models.svm
   :noindex:

.. java:type:: public interface MulticlassStrategy<N>

Methods
-------
load
^^^^

.. java:method:: public MulticlassStrategy<N> load(ClassifierSVC<N> clf, Matrix<N> vectors, Matrix<N> coefficients, Scaler<N> scaler, Kernel<N> K, Matrix<N> intercepts, int[] classes)
   :outertype: MulticlassStrategy

predict
^^^^^^^

.. java:method:: public Matrix<N> predict(Matrix<N> x)
   :outertype: MulticlassStrategy

