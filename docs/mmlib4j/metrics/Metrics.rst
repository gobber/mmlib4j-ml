.. java:import:: java.util List

.. java:import:: mmlib4j.datastruct SimpleLinkedList

.. java:import:: mmlib4j.images GrayScaleImage

.. java:import:: mmlib4j.targets BoundBox

.. java:import:: mmlib4j.utils MooreNeighborTracing

Metrics
=======

.. java:package:: mmlib4j.metrics
   :noindex:

.. java:type:: public class Metrics

Methods
-------
absDic
^^^^^^

.. java:method:: public static int absDic(List<BoundBox> listGT, List<BoundBox> listEstimates)
   :outertype: Metrics

dic
^^^

.. java:method:: public static int dic(List<BoundBox> listGT, List<BoundBox> listEstimates)
   :outertype: Metrics

dsc
^^^

.. java:method:: public static double dsc(GrayScaleImage predImg, GrayScaleImage groundImg)
   :outertype: Metrics

modHausdorffDist
^^^^^^^^^^^^^^^^

.. java:method:: public static double modHausdorffDist(GrayScaleImage predImg, GrayScaleImage groundImg)
   :outertype: Metrics

sbd
^^^

.. java:method:: public static double sbd(List<BoundBox> listGT, List<BoundBox> listEstimates)
   :outertype: Metrics

