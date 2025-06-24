pipeline {
    agent any
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
        stage('Publish Local') {
            steps {
                sh 'sbt publishLocal'
            }
        }
        stage('Publish') {
            steps {
                sh 'sbt publish'
            }
        }
        stage('Docker Publish Local') {
            steps {
                sh "sbt 'project playgroundCoreJVM' Docker/publishLocal"
            }
        }
    }
}
