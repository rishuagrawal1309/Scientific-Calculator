pipeline {
    agent any

    stages {

        stage('Clean Workspace') {
            steps {
                deleteDir()
            }
        }

        stage('Clone Repository') {
            steps {
                sh '''
                git clone https://github.com/rishuagrawal1309/Scientific-Calculator.git project
                '''
            }
        }

      stage('Build & Test') {
    steps {
        sh '''
        docker run --rm \
        -v $PWD:/app \
        -w /app \
        maven:3.9.6-eclipse-temurin-17 \
        mvn clean package
        '''
    }
}
        stage('Build Docker Image') {
            steps {
                sh '''
                cd project
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
