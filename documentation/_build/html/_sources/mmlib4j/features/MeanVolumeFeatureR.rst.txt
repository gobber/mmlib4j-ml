.. java:import:: java.util HashSet

.. java:import:: mmlib4j.representation.tree NodeLevelSets

.. java:import:: mmlib4j.representation.tree.attribute Attribute

.. java:import:: mmlib4j.representation.tree.attribute AttributeComputedIncrementally

.. java:import:: mmlib4j.representation.tree.componentTree ConnectedFilteringByComponentTree

.. java:import:: mmlib4j.representation.tree.componentTree NodeCT

MeanVolumeFeatureR
==================

.. java:package:: mmlib4j.features
   :noindex:

.. java:type:: public class MeanVolumeFeatureR extends FeatureBody implements Feature

Constructors
------------
MeanVolumeFeatureR
^^^^^^^^^^^^^^^^^^

.. java:constructor:: public MeanVolumeFeatureR(String featureName, int featureId)
   :outertype: MeanVolumeFeatureR

Methods
-------
addAttributeInNodes
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void addAttributeInNodes(NodeLevelSets node)
   :outertype: MeanVolumeFeatureR

addAttributeInNodesCT
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void addAttributeInNodesCT(HashSet<NodeCT> list)
   :outertype: MeanVolumeFeatureR

loadFeature
^^^^^^^^^^^

.. java:method:: @Override public void loadFeature(ConnectedFilteringByComponentTree tree)
   :outertype: MeanVolumeFeatureR

