mkdir -p build && javac -d build -cp ../sum-libs/\* Ships/*.java && java -cp ../sum-libs/\*:build/ Ships.Main
