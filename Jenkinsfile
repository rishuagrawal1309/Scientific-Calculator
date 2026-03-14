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
        withCredentials([usernamePassword(credentialsId: 'dockerhub-cred', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
            sh '''
            echo $PASS | docker login -u $USER --password-stdin
            docker push rishuagrawal1309/scientific-calculator:${BUILD_NUMBER}
            '''
        }
    }
}
        stage('Deploy with Ansible') {
    steps {
        sh '''
        ansible-playbook ansible/deploy_calculator.yml \
        -i ansible/inventory \
        -e build_number=${BUILD_NUMBER}
        '''
    }
}
    }

    post {
    always {
        echo "Pipeline Completed"
    }

    success {
        mail to: 'your_email@gmail.com',
        subject: "Build Success: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
        body: "The build completed successfully."
    }

    failure {
        mail to: 'your_email@gmail.com',
        subject: "Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
        body: "The build failed. Please check Jenkins logs."
    }
}
}
