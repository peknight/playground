pipeline {
    agent any
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