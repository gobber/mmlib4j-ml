.. java:import:: mmlib4j.representation.tree NodeLevelSets

.. java:import:: mmlib4j.representation.tree.attribute AttributeComputedIncrementally

.. java:import:: mmlib4j.representation.tree.componentTree ComponentTree

.. java:import:: mmlib4j.representation.tree.componentTree NodeCT

DietzNumbering
==============

.. java:package:: mmlib4j.utils
   :noindex:

.. java:type:: public class DietzNumbering extends AttributeComputedIncrementally

Fields
------
cnt
^^^

.. java:field::  int cnt
   :outertype: DietzNumbering

postOrder
^^^^^^^^^

.. java:field::  int postOrder
   :outertype: DietzNumbering

preOrder
^^^^^^^^

.. java:field::  int preOrder
   :outertype: DietzNumbering

tree
^^^^

.. java:field::  ComponentTree tree
   :outertype: DietzNumbering

Constructors
------------
DietzNumbering
^^^^^^^^^^^^^^

.. java:constructor:: public DietzNumbering(ComponentTree tree)
   :outertype: DietzNumbering

Methods
-------
isAncestor
^^^^^^^^^^

.. java:method:: public boolean isAncestor(NodeCT u, NodeCT v)
   :outertype: DietzNumbering

isDescendant
^^^^^^^^^^^^

.. java:method:: public boolean isDescendant(NodeCT u, NodeCT v)
   :outertype: DietzNumbering

mergeChildren
^^^^^^^^^^^^^

.. java:method:: @Override public void mergeChildren(NodeLevelSets parent, NodeLevelSets son)
   :outertype: DietzNumbering

posProcessing
^^^^^^^^^^^^^

.. java:method:: @Override public void posProcessing(NodeLevelSets parent)
   :outertype: DietzNumbering

preProcessing
^^^^^^^^^^^^^

.. java:method:: @Override public void preProcessing(NodeLevelSets v)
   :outertype: DietzNumbering

