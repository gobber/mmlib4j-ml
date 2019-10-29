.. java:import:: java.io File

.. java:import:: java.util Collection

.. java:import:: java.util Map

.. java:import:: java.util TreeMap

.. java:import:: java.util.regex Matcher

.. java:import:: java.util.regex Pattern

.. java:import:: mmlib4j.options Options

DataReader
==========

.. java:package:: mmlib4j.files
   :noindex:

.. java:type:: public class DataReader

Constructors
------------
DataReader
^^^^^^^^^^

.. java:constructor:: public DataReader()
   :outertype: DataReader

Methods
-------
get
^^^

.. java:method:: public Collection<DataFile> get()
   :outertype: DataReader

group
^^^^^

.. java:method:: public DataReader group(File... files)
   :outertype: DataReader

pattern
^^^^^^^

.. java:method:: public DataReader pattern(String pattern)
   :outertype: DataReader

valid
^^^^^

.. java:method:: public boolean valid(File f)
   :outertype: DataReader

