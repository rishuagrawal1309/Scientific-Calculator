pipeline {
    agent any

    stages {

        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
    steps {
        sh '''
        mvn clean package
        '''
    }
}

        stage('Build Docker Image') {
            steps {
                sh '''
                docker build -t rishuagrawal13/scientific-calculator:latest .
                '''
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                    sh '''
                    echo $PASS | docker login -u $USER --password-stdin
                    docker push rishuagrawal13/scientific-calculator:latest
                    '''
                }
            }
        }

    }

    post {
        always {
            echo "Pipeline Completed"
        }
    }
}
