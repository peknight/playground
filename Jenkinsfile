pipeline {
    agent any
    environment {
        PATH="${env.SBT_HOME}/bin:${env.NODE_HOME}/bin:${env.PATH}"
    }
    stages {
        stage('Compile') {
            steps {
                sh 'sbt clean compile'
            }
        }
        stage('Test') {
            steps {
                echo "${env.NODE_HOME}"
                sh 'npm install'
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