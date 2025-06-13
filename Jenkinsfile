pipeline {
    agent any
    environment {
        PATH="${env.SBT_HOME}/bin:${env.PATH}"
    }
    stages {
        stage('Compile') {
            steps {
                echo "${env.PATH}"
                echo "${env.SBT_HOME}"
                sh 'sbt clean compile'
            }
        }
    }
}