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
                sh 'node -v'
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