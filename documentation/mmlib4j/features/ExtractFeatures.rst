.. java:import:: java.io File

.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: mmlib4j.debug Debug

.. java:import:: mmlib4j.files DataWriter

.. java:import:: mmlib4j.models.datastruct Matrix

.. java:import:: mmlib4j.representation.tree NodeLevelSets

.. java:import:: mmlib4j.representation.tree.attribute Attribute

.. java:import:: mmlib4j.representation.tree.attribute ComputerContrastAttribute.ContrastAttribute

.. java:import:: mmlib4j.representation.tree.componentTree ConnectedFilteringByComponentTree

.. java:import:: mmlib4j.targets Target

ExtractFeatures
===============

.. java:package:: mmlib4j.features
   :noindex:

.. java:type:: public class ExtractFeatures

Fields
------
attr
^^^^

.. java:field:: public ContrastAttribute attr
   :outertype: ExtractFeatures

nodesNr
^^^^^^^

.. java:field:: public List<NodeLevelSets> nodesNr
   :outertype: ExtractFeatures

Constructors
------------
ExtractFeatures
^^^^^^^^^^^^^^^

.. java:constructor:: public ExtractFeatures(ConnectedFilteringByComponentTree tree, Target target)
   :outertype: ExtractFeatures

Methods
-------
X
^

.. java:method:: public Matrix<double[]> X()
   :outertype: ExtractFeatures

Y
^

.. java:method:: public Matrix<double[]> Y()
   :outertype: ExtractFeatures

featureExtractionOfAscendant
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void featureExtractionOfAscendant(NodeLevelSets node, Matrix<double[]> matrix, int row)
   :outertype: ExtractFeatures

featureExtractionOfDescendant
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void featureExtractionOfDescendant(NodeLevelSets node, Matrix<double[]> matrix, int row)
   :outertype: ExtractFeatures

find
^^^^

.. java:method:: @SuppressWarnings public ExtractFeatures find(int delta)
   :outertype: ExtractFeatures

getAccumulatedAttributeInPath
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public int getAccumulatedAttributeInPath()
   :outertype: ExtractFeatures

getAscendantsPaths
^^^^^^^^^^^^^^^^^^

.. java:method:: public ArrayList<NodeLevelSets>[] getAscendantsPaths()
   :outertype: ExtractFeatures

getDescendantsPaths
^^^^^^^^^^^^^^^^^^^

.. java:method:: public ArrayList<NodeLevelSets>[] getDescendantsPaths()
   :outertype: ExtractFeatures

getNodesAscendantsPath
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public ArrayList<NodeLevelSets> getNodesAscendantsPath(NodeLevelSets node)
   :outertype: ExtractFeatures

getTarget
^^^^^^^^^

.. java:method:: public Target getTarget()
   :outertype: ExtractFeatures

getTree
^^^^^^^

.. java:method:: public ConnectedFilteringByComponentTree getTree()
   :outertype: ExtractFeatures

header
^^^^^^

.. java:method:: public String header(String separator)
   :outertype: ExtractFeatures

load
^^^^

.. java:method:: public ExtractFeatures load()
   :outertype: ExtractFeatures

maxAttributeDescendantsPath
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void maxAttributeDescendantsPath(NodeLevelSets nodeAsc, NodeLevelSets nodeDes)
   :outertype: ExtractFeatures

sample
^^^^^^

.. java:method:: public Matrix<double[]> sample(NodeLevelSets node)
   :outertype: ExtractFeatures

samples
^^^^^^^

.. java:method:: public Matrix<double[]> samples()
   :outertype: ExtractFeatures

save
^^^^

.. java:method:: public void save(String outputDir, String fileName)
   :outertype: ExtractFeatures

setAccumulatedAttributeInPath
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setAccumulatedAttributeInPath(int accumulatedAttributeInPath)
   :outertype: ExtractFeatures

setAscendantsPaths
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setAscendantsPaths(ArrayList<NodeLevelSets>[] ascendantsPaths)
   :outertype: ExtractFeatures

setDescendantsPaths
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setDescendantsPaths(ArrayList<NodeLevelSets>[] descendantsPaths)
   :outertype: ExtractFeatures

setTarget
^^^^^^^^^

.. java:method:: public void setTarget(Target target)
   :outertype: ExtractFeatures

setTree
^^^^^^^

.. java:method:: public void setTree(ConnectedFilteringByComponentTree tree)
   :outertype: ExtractFeatures

write
^^^^^

.. java:method:: public void write(DataWriter dataWriter, boolean printHeader)
   :outertype: ExtractFeatures

x
^

.. java:method:: public double[] x(NodeLevelSets node)
   :outertype: ExtractFeatures

y
^

.. java:method:: public Matrix<double[]> y(NodeLevelSets node)
   :outertype: ExtractFeatures

