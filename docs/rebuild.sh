javasphinx-apidoc -f -o /Users/gobber/Desktop/docs/ /Users/gobber/eclipse-workspace/mmlib4j-ml/src/mmlib4j/
rm -rf _build/*
sphinx-build -b html . _build