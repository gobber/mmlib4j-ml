Examples
========

Introduction
------------

This part of documentation contains some usage examples. 
Currently, the mmlib4j-ml only supports models stored
in JSON format. This JSON format needs to follow a
configuration. Thus, we developed a simple Python module
to store scikit-learn models in correct JSON format. This library is 
based on `sklearn-porter <https://github.com/nok/sklearn-porter>`_
a Python module to export scikit-learn models and can be found
`here <https://github.com/gobber/sklearn-export>`_.

Loading a model
---------------

Thanks to the high powerful of the Object Oriented 
programming paradigm it is possible to create a high
level abstraction using its concepts. At this sense, our models are all
based on an interface called :java:ref:`Models`. Then, any stored JSON model
in correct format can be loaded with the same class. For example,
consider the following model in scikit-learn:

.. code-block:: python
	:linenos:
	
	# Basic imports
	from sklearn.datasets import load_iris
	from sklearn_export import Export
	from sklearn.preprocessing import StandardScaler
	from sklearn.neural_network import MLPRegressor

	# Load data
	samples = load_iris()
	X, y = samples.data, samples.target

	# Normalize data
	scaler = StandardScaler()
	Xz = scaler.fit_transform(X)

	# Train model with normalized data
	clf = MLPRegressor()
	clf.fit(Xz, y)

	# Save model and scaler using sklearn_export
	export = Export([scaler, clf])
	export.to_json()

Thus, considering that the model is stored in a file called 
data.json, we can load the model in mmlib4j-ml with the
following lines of code:

.. code-block:: java
   :linenos:
   
   // Name of the file model
   String modelData = "data.json";
   
   // Create the model
   Models model = ModelsFactory.create(modelData); 		
   
   // Make a new prediction and print the result   
   model.predict(/* pass new data */).print();
   
Now we can make new predictions calling the method
prediction of :java:ref:`Models`. The great notice is that
we do not need to specify the kind of model, or the
normalization method that was applied (see that at the example 
above we applied z-score).
