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
        stage('Test') {
            steps {
                sh 'sbt test'
            }
        }
        stage('Package') {
            steps {
                sh 'sbt package'
            }
        }
    }
}