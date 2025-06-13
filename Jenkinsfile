pipeline {
    agent any
    environment {
        PATH="${env.SBT_HOME}/bin:${env.PATH}"
    }
    stages {
        stage('Compile') {
            steps {
                sh 'sbt clean compile'
            }
        }
    }
}