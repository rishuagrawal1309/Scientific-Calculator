pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "rishuagrawal1309/scientific-calculator"
    }

    stages {

        stage('Build & Test') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE:latest .'
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-cred',
                                                 usernameVariable: 'DOCKER_USER',
                                                 passwordVariable: 'DOCKER_PASS')]) {
                    sh """
                    echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin
                    docker push $DOCKER_IMAGE:latest
                    """
                }
            }
        }
    }

    post {
        success {
            mail to: 'rishuagrawal1309@gmail.com',
                 subject: 'Build Success',
                 body: 'Scientific Calculator build successful.'
        }
        failure {
            mail to: 'rishuagrawal1309@gmail.com',
                 subject: 'Build Failed',
                 body: 'Scientific Calculator build failed.'
        }
    }
}
