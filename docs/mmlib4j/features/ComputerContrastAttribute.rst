.. java:import:: java.util ArrayList

.. java:import:: java.util HashMap

.. java:import:: java.util HashSet

.. java:import:: java.util Iterator

.. java:import:: mmlib4j.datastruct Queue

.. java:import:: mmlib4j.datastruct SimpleLinkedList

.. java:import:: mmlib4j.images GrayScaleImage

.. java:import:: mmlib4j.images.impl ImageFactory

.. java:import:: mmlib4j.models Models

.. java:import:: mmlib4j.representation.tree NodeLevelSets

.. java:import:: mmlib4j.representation.tree.attribute Attribute

.. java:import:: mmlib4j.representation.tree.attribute AttributeComputedIncrementally

.. java:import:: mmlib4j.representation.tree.componentTree ComponentTree

.. java:import:: mmlib4j.representation.tree.componentTree NodeCT

.. java:import:: mmlib4j.representation.tree.tos NodeToS

.. java:import:: mmlib4j.utils Utils

ComputerContrastAttribute
=========================

.. java:package:: mmlib4j.features
   :noindex:

.. java:type:: public class ComputerContrastAttribute extends AttributeComputedIncrementally

   MMLib4J - Mathematical Morphology Library for Java

   :author: Wonder Alexandre Luz Alves

Fields
------
ascendantsPaths
^^^^^^^^^^^^^^^

.. java:field:: public ArrayList<NodeLevelSets>[] ascendantsPaths
   :outertype: ComputerContrastAttribute

attr
^^^^

.. java:field::  ContrastAttribute attr
   :outertype: ComputerContrastAttribute

bestNodes
^^^^^^^^^

.. java:field:: public SimpleLinkedList<NodeCT> bestNodes
   :outertype: ComputerContrastAttribute

delta
^^^^^

.. java:field::  int delta
   :outertype: ComputerContrastAttribute

descendantsPaths
^^^^^^^^^^^^^^^^

.. java:field:: public ArrayList<NodeLevelSets>[] descendantsPaths
   :outertype: ComputerContrastAttribute

extract
^^^^^^^

.. java:field:: public ExtractFeatures extract
   :outertype: ComputerContrastAttribute

img
^^^

.. java:field::  GrayScaleImage img
   :outertype: ComputerContrastAttribute

mapPruning
^^^^^^^^^^

.. java:field::  boolean mapPruning
   :outertype: ComputerContrastAttribute

model
^^^^^

.. java:field:: public Models model
   :outertype: ComputerContrastAttribute

nodesMatching
^^^^^^^^^^^^^

.. java:field:: public double nodesMatching
   :outertype: ComputerContrastAttribute

numNode
^^^^^^^

.. java:field::  int numNode
   :outertype: ComputerContrastAttribute

predictions
^^^^^^^^^^^

.. java:field::  double predictions
   :outertype: ComputerContrastAttribute

root
^^^^

.. java:field::  NodeLevelSets root
   :outertype: ComputerContrastAttribute

sumAttributeOfDescPath
^^^^^^^^^^^^^^^^^^^^^^

.. java:field::  double[] sumAttributeOfDescPath
   :outertype: ComputerContrastAttribute

threshold
^^^^^^^^^

.. java:field::  double threshold
   :outertype: ComputerContrastAttribute

tree
^^^^

.. java:field::  ComponentTree tree
   :outertype: ComputerContrastAttribute

Constructors
------------
ComputerContrastAttribute
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ComputerContrastAttribute(int numNode, NodeLevelSets root, GrayScaleImage img, boolean[] mapPruning, int delta, Models model, ComponentTree tree, double threshold)
   :outertype: ComputerContrastAttribute

Methods
-------
addAttributeInNodes
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void addAttributeInNodes(NodeLevelSets node)
   :outertype: ComputerContrastAttribute

addAttributeInNodesCT
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void addAttributeInNodesCT(HashSet<NodeCT> hashSet)
   :outertype: ComputerContrastAttribute

addAttributeInNodesToS
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void addAttributeInNodesToS(HashSet<NodeToS> hashSet)
   :outertype: ComputerContrastAttribute

getAttribute
^^^^^^^^^^^^

.. java:method:: public ContrastAttribute[] getAttribute()
   :outertype: ComputerContrastAttribute

getNodesAscendantsPath
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public ArrayList<NodeLevelSets> getNodesAscendantsPath(NodeLevelSets node)
   :outertype: ComputerContrastAttribute

getUltimateLevelingAssociatedIndex
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public GrayScaleImage getUltimateLevelingAssociatedIndex()
   :outertype: ComputerContrastAttribute

maxAttributeDescendantsPath
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void maxAttributeDescendantsPath(NodeLevelSets nodeAsc, NodeLevelSets nodeDes)
   :outertype: ComputerContrastAttribute

mergeChildren
^^^^^^^^^^^^^

.. java:method:: public void mergeChildren(NodeLevelSets node, NodeLevelSets son)
   :outertype: ComputerContrastAttribute

posProcessing
^^^^^^^^^^^^^

.. java:method:: public void posProcessing(NodeLevelSets root)
   :outertype: ComputerContrastAttribute

preProcessing
^^^^^^^^^^^^^

.. java:method:: public void preProcessing(NodeLevelSets node)
   :outertype: ComputerContrastAttribute

