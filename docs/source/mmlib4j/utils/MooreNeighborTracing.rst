.. java:import:: mmlib4j.datastruct SimpleLinkedList

.. java:import:: mmlib4j.images GrayScaleImage

.. java:import:: mmlib4j.images.impl ImageFactory

MooreNeighborTracing
====================

.. java:package:: mmlib4j.utils
   :noindex:

.. java:type:: public class MooreNeighborTracing

Fields
------
BACKGROUND
^^^^^^^^^^

.. java:field:: public static int BACKGROUND
   :outertype: MooreNeighborTracing

FOREGROUND
^^^^^^^^^^

.. java:field:: public static int FOREGROUND
   :outertype: MooreNeighborTracing

Methods
-------
boundaries
^^^^^^^^^^

.. java:method:: public static SimpleLinkedList<Integer> boundaries(GrayScaleImage image)
   :outertype: MooreNeighborTracing

padImage
^^^^^^^^

.. java:method:: public static GrayScaleImage padImage(GrayScaleImage image, int paddingColor)
   :outertype: MooreNeighborTracing

