CPATH='.;../lib/hamcrest-core-1.3.jar;../lib/junit-4.13.2.jar'

rm -rf student-submission
git clone $1 student-submission
echo 'Finished cloning'
cd student-submission

if [[ -e ListExamples.java ]]
then
    echo 'File ListExamples.java found'
else
    echo 'Missing file ListExamples.java'
    exit
fi

cp ../TestListExamples.java ./

javac -cp $CPATH *.java
if [[ $? -ne 0 ]]
then
    echo 'Compiler failed'
    exit
else
    echo 'Compiler passed'
fi

java -cp $CPATH org.junit.runner.JUnitCore TestListExamples #> results.txt
#cat results.txt
#grep "failure:" results.txt
#grep "test" results.txt