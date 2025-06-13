pipeline {
    agent any
    environment {

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