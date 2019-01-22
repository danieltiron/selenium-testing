pipeline {
    node {
        label 'my-defined-label'
        customWorkspace '${WORKSPACE}/${BUILD_NUMBER}'
    }
    
    stages {
        stage('Connect to VPN') {
            steps {
                echo 'Connect to VPN..'
            }
        }

        stage('Run selenium tests') {
            steps {
                sh '''
                cd ${WORKSPACE}/${BUILD_NUMBER}
                echo $(pwd)
                '''
            }
        }
    }
}
