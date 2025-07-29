pipeline {
    agent any
    stages {
        stage('Prepare') {
            steps {
                git credentialsId: 'MHS',
                    branch: 'main',
                    url: 'https://github.com/MollangPiu/jenkins.git'
            }
        }

        stage('Trigger Approval Menu') {
            steps {
                script {
                    sshagent(['nonexistent-key']) {
                        sh 'echo hello-from-jenkins'
                    }
                }
            }
        }

        stage('Deploy to Server') {
            steps {
                script {
                    sshagent(['spring-ssh-key']) {
                        sh '''
                            scp target/myapp.jar vagrant@192.168.56.100:/home/vagrant/
                            ssh vagrant@192.168.56.100 "pkill -f java || true && nohup java -jar /home/vagrant/myapp.jar &"
                        '''
                    }
                }
            }
        }
    }
}
