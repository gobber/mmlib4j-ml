.. java:import:: java.io File

.. java:import:: java.io FileNotFoundException

.. java:import:: java.io FileOutputStream

.. java:import:: java.io PrintWriter

.. java:import:: mmlib4j.models.datastruct Matrix

DataWriter
==========

.. java:package:: mmlib4j.files
   :noindex:

.. java:type:: public class DataWriter

Methods
-------
close
^^^^^

.. java:method:: public void close()
   :outertype: DataWriter

create
^^^^^^

.. java:method:: public void create(String fileName)
   :outertype: DataWriter

getExtension
^^^^^^^^^^^^

.. java:method:: public String getExtension()
   :outertype: DataWriter

getSeparator
^^^^^^^^^^^^

.. java:method:: public String getSeparator()
   :outertype: DataWriter

setExtension
^^^^^^^^^^^^

.. java:method:: public void setExtension(String extension)
   :outertype: DataWriter

setSeparator
^^^^^^^^^^^^

.. java:method:: public void setSeparator(String separator)
   :outertype: DataWriter

write
^^^^^

.. java:method:: public void write(Matrix sample)
   :outertype: DataWriter

write
^^^^^

.. java:method:: public void write(String line)
   :outertype: DataWriter

