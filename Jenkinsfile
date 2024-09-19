pipeline {
    agent any

    tools {
            maven 'maven'
        }

    stages {
        stage('Checkout Code') {
                steps {
                    git url: 'https://github.com/amir-mugisha/jenkins.git', branch: 'main'
                }
        }

        stage('Build Maven Project') {
            steps {
                script {
                    bat 'mvn clean install'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    bat "docker build -t jenkins-sample:v1 ."
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'docker', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                        bat "docker login -u %DOCKER_USER% -p %DOCKER_PASS%"
                        bat "docker push jenkins-sample:v1"
                    }

                }
            }
        }

        stage('Deploy WAR to Tomcat') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'tomcat', usernameVariable: 'TOMCAT_USER', passwordVariable: 'TOMCAT_PASS')]) {
                        bat """
                        curl --upload-file target/jenkins-0.0.1-SNAPSHOT.war "http://%TOMCAT_USER%:%TOMCAT_PASS%@localhost:7070/manager/text/deploy?path=/jenkins&update=true"
                        """
                    }
                }
            }
        }
    }

    post {

        always {
            echo 'Cleaning workspace...'
            cleanWs()
        }

        success {
            echo 'Application deployed successfully!'
        }

        failure {
            echo 'Application deployment failed.'
        }
    }
}