pipeline {
    agent any
    tools {
        sbt 'sbt-1.11.2'
    }
    stages {
        stage('Compile') {
            steps {
                sh 'sbt clean compile'
            }
        }
    }
}