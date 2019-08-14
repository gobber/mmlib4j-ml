.. java:import:: java.io File

.. java:import:: java.io FileNotFoundException

.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: java.util Scanner

.. java:import:: mmlib4j.representation.tree NodeLevelSets

BoundingBoxMatching
===================

.. java:package:: mmlib4j.targets
   :noindex:

.. java:type:: public class BoundingBoxMatching implements Target

Constructors
------------
BoundingBoxMatching
^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public BoundingBoxMatching(File ground)
   :outertype: BoundingBoxMatching

Methods
-------
getListGT
^^^^^^^^^

.. java:method:: public List<BoundBox> getListGT()
   :outertype: BoundingBoxMatching

load
^^^^

.. java:method:: public void load(File ground)
   :outertype: BoundingBoxMatching

match
^^^^^

.. java:method:: @Override public double match(NodeLevelSets node)
   :outertype: BoundingBoxMatching

setListGT
^^^^^^^^^

.. java:method:: public void setListGT(List<BoundBox> listGT)
   :outertype: BoundingBoxMatching

