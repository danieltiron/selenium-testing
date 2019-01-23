pipeline {
    agent {
        node {
          label ''
          customWorkspace "${JENKINS_HOME}/workspace/${JOB_NAME}/${BUILD_NUMBER}"
        }
    }
    
    parameters {
        string(name: 'TEST_RUN_ID', defaultValue: 'enter ID', description: 'Testrail test run id')
        choice(name: 'USE_TESTRAIL', choices: ['yes', 'no'], description: 'Use testrail')
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
                cd ${WORKSPACE}
                echo $(pwd)
                echo "${params.TEST_RUN_ID}"
                echo "${params.USE_TESTRAIL}" 
                '''
            }
        }
    }
}
