.. java:import:: mmlib4j.representation.tree.attribute Attribute

.. java:import:: mmlib4j.representation.tree MorphologicalTreeFiltering

.. java:import:: mmlib4j.representation.tree NodeLevelSets

.. java:import:: mmlib4j.representation.tree.componentTree ComponentTree

.. java:import:: mmlib4j.representation.tree.componentTree NodeCT

.. java:import:: mmlib4j.representation.tree.tos NodeToS

.. java:import:: mmlib4j.representation.tree.tos TreeOfShape

ShapeMatching
=============

.. java:package:: mmlib4j.targets
   :noindex:

.. java:type:: public class ShapeMatching implements Target

Fields
------
bestNode
^^^^^^^^

.. java:field::  NodeLevelSets bestNode
   :outertype: ShapeMatching

Constructors
------------
ShapeMatching
^^^^^^^^^^^^^

.. java:constructor:: public ShapeMatching()
   :outertype: ShapeMatching

ShapeMatching
^^^^^^^^^^^^^

.. java:constructor:: public ShapeMatching(MorphologicalTreeFiltering binaryTree)
   :outertype: ShapeMatching

Methods
-------
match
^^^^^

.. java:method:: public double match(NodeLevelSets node, NodeLevelSets ground)
   :outertype: ShapeMatching

match
^^^^^

.. java:method:: @Override public double match(NodeLevelSets node)
   :outertype: ShapeMatching

