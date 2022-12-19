#For this script to work, the project structure has to be similar to mine
#Additionaly, you need a "sum-jars" dir containing all the dependency jars
(
cd `dirname $0`

if [[ -z $1 ]]; then echo 'Please, enter a project name, e.g. ./build.sh ProjectName' && exit 1; fi
if ! [[ -d ${1%/}/src ]]; then echo 'Directory doesn`t exist, must look like `ProjectName/src/`' && exit 1; fi

mkdir -p ${1%/}/build && javac -d ${1%/}/build -cp sum-jars/\* `find ${1%/}/src/ -name \*.java` && java -cp sum-jars/\*:${1%/}/build/ Main
)

