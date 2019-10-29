.. java:import:: mmlib4j.models.datastruct Matrix

Scaler
======

.. java:package:: mmlib4j.models.preprocessing
   :noindex:

.. java:type:: public interface Scaler

   This interface is a model to normalization classes for the \ :java:ref:`Matrix`\  datastruct.

   :author: Charles Ferreira Gobber

   **See also:** :java:ref:`MinMax`, :java:ref:`Zscore`, :java:ref:`Matrix`

Methods
-------
normalize
^^^^^^^^^

.. java:method:: public Matrix normalize(Matrix A)
   :outertype: Scaler

   :param matrix: A Matrix
   :return: A matrix :math:`C` normalized.

