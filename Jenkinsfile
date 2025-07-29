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
        stage('Deploy to Server') {
            steps {
                bat '''
                    scp -i /var/jenkins_home/.ssh/id_rsa -o StrictHostKeyChecking=no target/myapp.jar vagrant@192.168.56.100:/home/vagrant/
                    ssh -i /var/jenkins_home/.ssh/id_rsa -o StrictHostKeyChecking=no vagrant@192.168.56.100 "pkill -f java || true && nohup java -jar /home/vagrant/myapp.jar &"
                '''
            }
        }
    }
}
