.. java:import:: mmlib4j.representation.tree.attribute Attribute

.. java:import:: mmlib4j.representation.tree.attribute ComputerMserComponentTree

.. java:import:: mmlib4j.representation.tree.componentTree ConnectedFilteringByComponentTree

.. java:import:: mmlib4j.representation.tree.componentTree NodeCT

MserFeature
===========

.. java:package:: mmlib4j.features
   :noindex:

.. java:type:: public class MserFeature extends FeatureBody implements Feature

Constructors
------------
MserFeature
^^^^^^^^^^^

.. java:constructor:: public MserFeature(int delta, String featureName, int featureId)
   :outertype: MserFeature

MserFeature
^^^^^^^^^^^

.. java:constructor:: public MserFeature(int delta, double maxVariation, int minArea, int maxArea, boolean estimateDelta, int attribute, String featureName, int featureId)
   :outertype: MserFeature

Methods
-------
loadFeature
^^^^^^^^^^^

.. java:method:: @Override public void loadFeature(ConnectedFilteringByComponentTree tree)
   :outertype: MserFeature

