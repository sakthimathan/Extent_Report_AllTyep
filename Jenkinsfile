pipeline {
    agent any

    environment {
        JAVA_HOME = 'C:\\Program Files\\JDK17'  // Use double backslashes for escaping
        PATH = "${JAVA_HOME}\\bin;${env.PATH}" // Update PATH for Windows agents
    }

    tools {
        maven 'Maven' // Ensure 'Maven' matches the name configured in Jenkins global tools
    }

    stages {
        stage('CheckOut The Repo') {
            steps {
                echo "Cloning the repository..."
                git url: 'https://github.com/sakthimathan/Extent_Report_AllTyep.git' 

            }
        }
        
        stage('Build') {
            steps {
                echo "Building the project using Maven..."
                bat "mvn clean"
            }
        }
        
        stage('Test') {
            steps {
                echo "Testing the project using Maven..."
                bat "mvn test"
            }
        }
        
        stage('Generate Cucumber Report') {
            steps {
                echo "Generating Cucumber Reports..."
               testNG reportFilenamePattern: '**/test-output/testng-results.xml'
            }
        }
    }

    post {
        always {
            echo "Pipeline execution completed."
        }
        failure {
            echo "Pipeline failed. Check logs for errors."
        }
        success {
            echo "Pipeline executed successfully."
        }
    }
}
