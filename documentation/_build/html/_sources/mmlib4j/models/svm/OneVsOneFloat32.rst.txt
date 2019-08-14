.. java:import:: mmlib4j.models.datastruct Matrix

.. java:import:: mmlib4j.models.preprocessing Scaler

.. java:import:: mmlib4j.models.svm.kernels Kernel

OneVsOneFloat32
===============

.. java:package:: mmlib4j.models.svm
   :noindex:

.. java:type:: public class OneVsOneFloat32 implements MulticlassStrategy<float[]>

Constructors
------------
OneVsOneFloat32
^^^^^^^^^^^^^^^

.. java:constructor:: public OneVsOneFloat32()
   :outertype: OneVsOneFloat32

Methods
-------
load
^^^^

.. java:method:: @Override public MulticlassStrategy<float[]> load(ClassifierSVC<float[]> clf, Matrix<float[]> vectors, Matrix<float[]> coefficients, Scaler<float[]> scaler, Kernel<float[]> K, Matrix<float[]> intercepts, int[] classes)
   :outertype: OneVsOneFloat32

predict
^^^^^^^

.. java:method:: @Override public Matrix<float[]> predict(Matrix<float[]> x)
   :outertype: OneVsOneFloat32

