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
        sh 'mvn clean package'
    }
}
     stage('Build Docker Image') {
    steps {
        sh '''
        docker build -t rishuagrawal1309/scientific-calculator:${BUILD_NUMBER} .
        '''
    }
}

stage('Push Docker Image') {
    steps {
        withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
            sh '''
            echo $PASS | docker login -u $USER --password-stdin
            docker push rishuagrawal1309/scientific-calculator:${BUILD_NUMBER}
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
