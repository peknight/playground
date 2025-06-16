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
                sh 'sbt test'
            }
        }
        stage('Package') {
            steps {
                sh 'sbt package'
            }
        }
        stage('Publish') {
            steps {
                sh """
                    sbt "set credentials += Credentials(\\"Sonatype Nexus Repository Manager\\", \\"nexus.local.peknight.com\\", \\"${env.NEXUS_USR}\\", \\"${env.NEXUS_PASSWORD}\\")" publish
                """
            }
        }
    }
}