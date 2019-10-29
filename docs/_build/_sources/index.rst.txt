Mmlib4j-ml Documentation
============================

This documentation is about the mmlib4j-ml a Java library 
to make predictions of trained Machine learning models. 
Our library was designed to be simple, efficient and minimal
dependent. We also made use of Method Chaining, 
an useful Design Pattern to make the code more readable.
Currently, the mmlib4j-ml only supports models stored in JSON format. 
The configuration of the JSON depends on the model. Because this, 
we developed a transpiler for scikit-learn models that can
be found `here <https://github.com/gobber/sklearn-export>`_. 
In the future, we intend to extend the library for other 
file formats and Machine Learning libraries.

Instaling
---------

The library can be cloned from the github by the following command:

.. code-block:: console
	:linenos:
	
	$ git clone https://github.com/gobber/mmlib4j-ml
	
Dependencies
------------

The mmlib4j-ml has only two Java external dependencies:

.. code-block:: console
	:linenos:
	
	com.github.fommil.netlib version: 2.1
	com.google.code.gson version: 2.8.5

Examples
--------

Some usage examples are available here:

.. toctree::
   :titlesonly:
	
   examples
   
Future improvements
-------------------

Currently, the mmlib4j-ml does not support advanced cash.
However, we intend to implement it as soon as possible, because
for a large application the memory re-allocation can be an issue.

Javadoc
-------

Here we have all the Javadoc of mmlib4j-ml.

.. toctree::
   :titlesonly:
   
   mmlib4j/debug/package-index
   mmlib4j/files/package-index
   mmlib4j/models/package-index
   mmlib4j/models/datastruct/package-index
   mmlib4j/models/linear/package-index
   mmlib4j/models/neural_network/package-index
   mmlib4j/models/postprocessing/package-index
   mmlib4j/models/preprocessing/package-index
   mmlib4j/models/svm/package-index
   mmlib4j/models/svm/kernels/package-index
   mmlib4j/models/svr/package-index
   mmlib4j/models/transfer/package-index
   mmlib4j/options/package-index
   mmlib4j/utils/package-index   

