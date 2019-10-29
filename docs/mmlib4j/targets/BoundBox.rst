.. java:import:: java.util List

BoundBox
========

.. java:package:: mmlib4j.targets
   :noindex:

.. java:type:: public class BoundBox

Fields
------
x1
^^

.. java:field:: public int x1
   :outertype: BoundBox

x2
^^

.. java:field:: public int x2
   :outertype: BoundBox

Constructors
------------
BoundBox
^^^^^^^^

.. java:constructor:: public BoundBox()
   :outertype: BoundBox

BoundBox
^^^^^^^^

.. java:constructor:: public BoundBox(int x1, int y1, int x2, int y2)
   :outertype: BoundBox

Methods
-------
area
^^^^

.. java:method:: public int area()
   :outertype: BoundBox

area
^^^^

.. java:method:: public static int area(int x1, int y1, int x2, int y2)
   :outertype: BoundBox

bestMatch
^^^^^^^^^

.. java:method:: public static double bestMatch(List<BoundBox> listGT, BoundBox estimate)
   :outertype: BoundBox

main
^^^^

.. java:method:: public static void main(String[] args)
   :outertype: BoundBox

match
^^^^^

.. java:method:: public double match(BoundBox r2)
   :outertype: BoundBox

overlapArea
^^^^^^^^^^^

.. java:method:: public double overlapArea(BoundBox r2)
   :outertype: BoundBox

setBoundbox
^^^^^^^^^^^

.. java:method:: public void setBoundbox(int x1, int y1, int x2, int y2)
   :outertype: BoundBox

unionArea
^^^^^^^^^

.. java:method:: public double unionArea(BoundBox r2)
   :outertype: BoundBox

