pipeline {
    agent any
    tools {
        sbt 'Default'
    }
    stages {
        stage('Compile') {
            steps {
                sh 'sbt clean compile'
            }
        }
    }
}