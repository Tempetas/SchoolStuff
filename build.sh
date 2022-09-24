(
cd `dirname $0`

if [[ -z $1 ]]; then echo 'Please, enter the project name: ./build.sh ProjectName' && exit 1; fi

mkdir -p $1/build && javac -d $1/build -cp sum-libs/\* $1/src/*.java && java -cp sum-libs/\*:$1/build/ $1.Main
)

