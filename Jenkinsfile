pipeline {
    agent any
    tools {
        sbt 'sbt-1.11.2'
    }
    stages {
        stage('Compile') {
            steps {
                echo "${tool 'sbt-1.11.2'}"
                sh 'sbt clean compile'
            }
        }
    }
}