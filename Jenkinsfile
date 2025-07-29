pipeline {
    agent any
    stages {
        stage('Check SSH') {
            steps {
                script {
                    sshagent(['dummy-key']) {
                        sh 'echo Hello SSH'
                    }
                }
            }
        }
    }
}
