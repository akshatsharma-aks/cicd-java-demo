pipeline {
    agent any

    environment {
        IMAGE_NAME = "cicd-java-demo"
        CONTAINER_NAME = "java-staging"
    }

    stages {

        stage('Build JAR') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t %IMAGE_NAME% .'
            }
        }

        stage('Stop Old Container') {
            steps {
                bat 'docker stop %CONTAINER_NAME% || exit 0'
                bat 'docker rm %CONTAINER_NAME% || exit 0'
            }
        }

        stage('Deploy Container') {
            steps {
                bat 'docker run -d -p 8081:8081 --name %CONTAINER_NAME% %IMAGE_NAME%'
            }
        }

        stage('Test App') {
            steps {
                bat 'ping 127.0.0.1 -n 10 > nul'
                bat 'curl http://localhost:8081'
            }
        }
    }
}