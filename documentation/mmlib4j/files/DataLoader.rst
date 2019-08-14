.. java:import:: java.io File

.. java:import:: java.io FileNotFoundException

.. java:import:: java.util ArrayList

.. java:import:: java.util Arrays

.. java:import:: java.util List

.. java:import:: java.util Scanner

DataLoader
==========

.. java:package:: mmlib4j.files
   :noindex:

.. java:type:: public class DataLoader

Constructors
------------
DataLoader
^^^^^^^^^^

.. java:constructor:: public DataLoader(String[] filesets)
   :outertype: DataLoader

DataLoader
^^^^^^^^^^

.. java:constructor:: public DataLoader(String inputPath, String[] filesets)
   :outertype: DataLoader

DataLoader
^^^^^^^^^^

.. java:constructor:: public DataLoader(String inputPath, String outputPath, String[] filesets)
   :outertype: DataLoader

Methods
-------
dir
^^^

.. java:method:: public DataLoader dir()
   :outertype: DataLoader

getListOfFiles
^^^^^^^^^^^^^^

.. java:method:: public List<DataFile> getListOfFiles()
   :outertype: DataLoader

isValidExtension
^^^^^^^^^^^^^^^^

.. java:method:: public boolean isValidExtension(String fileName)
   :outertype: DataLoader

load
^^^^

.. java:method:: public static ArrayList<String> load(File file)
   :outertype: DataLoader

setListOfFiles
^^^^^^^^^^^^^^

.. java:method:: public void setListOfFiles(List<DataFile> datasetsFiles)
   :outertype: DataLoader

