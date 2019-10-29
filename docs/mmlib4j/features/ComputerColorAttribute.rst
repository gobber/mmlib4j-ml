.. java:import:: java.util HashSet

.. java:import:: mmlib4j.images ColorImage

.. java:import:: mmlib4j.images RealImage

.. java:import:: mmlib4j.representation.tree NodeLevelSets

.. java:import:: mmlib4j.representation.tree.attribute Attribute

.. java:import:: mmlib4j.representation.tree.attribute AttributeComputedIncrementally

.. java:import:: mmlib4j.representation.tree.componentTree NodeCT

.. java:import:: mmlib4j.representation.tree.tos NodeToS

.. java:import:: mmlib4j.utils Utils

ComputerColorAttribute
======================

.. java:package:: mmlib4j.features
   :noindex:

.. java:type:: public class ComputerColorAttribute extends AttributeComputedIncrementally

Fields
------
DIST_FALSE_AB
^^^^^^^^^^^^^

.. java:field:: public static final int DIST_FALSE_AB
   :outertype: ComputerColorAttribute

DIST_TRUE_AB
^^^^^^^^^^^^

.. java:field:: public static final int DIST_TRUE_AB
   :outertype: ComputerColorAttribute

MEAN_VOL_A
^^^^^^^^^^

.. java:field:: public static final int MEAN_VOL_A
   :outertype: ComputerColorAttribute

MEAN_VOL_B
^^^^^^^^^^

.. java:field:: public static final int MEAN_VOL_B
   :outertype: ComputerColorAttribute

aRefTrue
^^^^^^^^

.. java:field:: final double[][] aRefTrue
   :outertype: ComputerColorAttribute

bRefFalse
^^^^^^^^^

.. java:field:: final double[][] bRefFalse
   :outertype: ComputerColorAttribute

distAB
^^^^^^

.. java:field:: final double distAB
   :outertype: ComputerColorAttribute

distRGB
^^^^^^^

.. java:field:: final double distRGB
   :outertype: ComputerColorAttribute

imgLab
^^^^^^

.. java:field::  RealImage[] imgLab
   :outertype: ComputerColorAttribute

imgRGB
^^^^^^

.. java:field::  ColorImage imgRGB
   :outertype: ComputerColorAttribute

numNode
^^^^^^^

.. java:field::  int numNode
   :outertype: ComputerColorAttribute

rgbRefFalse
^^^^^^^^^^^

.. java:field:: final int[][] rgbRefFalse
   :outertype: ComputerColorAttribute

rgbRefTrue
^^^^^^^^^^

.. java:field:: final int[][] rgbRefTrue
   :outertype: ComputerColorAttribute

somaAB
^^^^^^

.. java:field:: final double somaAB
   :outertype: ComputerColorAttribute

somaRGB
^^^^^^^

.. java:field::  double somaRGB
   :outertype: ComputerColorAttribute

Constructors
------------
ComputerColorAttribute
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ComputerColorAttribute(int numNode, NodeLevelSets root, ColorImage imgRGB, RealImage[] imgLab)
   :outertype: ComputerColorAttribute

ComputerColorAttribute
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ComputerColorAttribute(int numNode, NodeLevelSets root, ColorImage imgRGB)
   :outertype: ComputerColorAttribute

Methods
-------
addAttributeInNodes
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void addAttributeInNodes(NodeLevelSets node)
   :outertype: ComputerColorAttribute

addAttributeInNodesCT
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void addAttributeInNodesCT(HashSet<NodeCT> hashSet)
   :outertype: ComputerColorAttribute

addAttributeInNodesToS
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void addAttributeInNodesToS(HashSet<NodeToS> hashSet)
   :outertype: ComputerColorAttribute

mergeChildren
^^^^^^^^^^^^^

.. java:method:: @Override public void mergeChildren(NodeLevelSets parent, NodeLevelSets son)
   :outertype: ComputerColorAttribute

posProcessing
^^^^^^^^^^^^^

.. java:method:: @Override public void posProcessing(NodeLevelSets parent)
   :outertype: ComputerColorAttribute

preProcessing
^^^^^^^^^^^^^

.. java:method:: @Override public void preProcessing(NodeLevelSets v)
   :outertype: ComputerColorAttribute

