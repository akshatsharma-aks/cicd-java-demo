pipeline {
    agent any

    environment {
        IMAGE_NAME = "cicd-java-demo"
        CONTAINER_NAME = "java-staging"
    }

    stages {

        stage('Checkout Code') {
            steps {
                git 'https://github.com/your-username/cicd-java-demo.git'
            }
        }

        stage('Build JAR') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${IMAGE_NAME}:latest")
                }
            }
        }

        stage('Stop Old Container') {
            steps {
                sh "docker stop ${CONTAINER_NAME} || true"
                sh "docker rm ${CONTAINER_NAME} || true"
            }
        }

        stage('Deploy Container') {
            steps {
                sh """
                docker run -d \
                --name ${CONTAINER_NAME} \
                -p 8080:8080 \
                ${IMAGE_NAME}:latest
                """
            }
        }

        stage('Test App') {
            steps {
                sh "curl http://localhost:8080 || true"
            }
        }
    }
}