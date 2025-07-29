pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                script {
                    sshagent(['your-credential-id']) {
                        sh 'echo Hello'
                    }
                }
            }
        }
    }
}
