pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git credentialsId: 'MHS',
                    branch: 'main',
                    url: 'https://github.com/MollangPiu/jenkins.git'
            }
        }

        stage('Build') {
            steps {
                sh '''
                    chmod +x ./gradlew
                    ./gradlew clean build
                '''
            }
        }

        stage('Deploy to Server') {
            steps {
                sh '''
                    # 기존 프로세스 종료
                    ssh -i ~/.ssh/id_rsa -o StrictHostKeyChecking=no vagrant@192.168.56.100 "pkill -f 'java -jar' || true"

                    # 새 파일 복사
                    scp -i ~/.ssh/id_rsa -o StrictHostKeyChecking=no build/libs/study-0.0.1-SNAPSHOT.jar vagrant@192.168.56.100:/home/vagrant/

                    # 재실행
                    ssh -i ~/.ssh/id_rsa -o StrictHostKeyChecking=no vagrant@192.168.56.100 "nohup java -jar /home/vagrant/study-0.0.1-SNAPSHOT.jar > /home/vagrant/nohup.out 2>&1 &"
                '''
            }
        }
    }
}
