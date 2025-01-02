pipeline {
    agent any

    environment {
        // Define JAVA_HOME if necessary
        JAVA_HOME = '/path/to/your/jdk-17' // Adjust this path
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from GitHub repository
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Run Maven to clean and test the project
                script {
                    sh 'mvn clean install'
                }
            }
        }

        stage('Run Cucumber Tests') {
            steps {
                // Run the Cucumber tests using Maven
                script {
                    sh 'mvn test'
                }
            }
        }

        stage('Publish Cucumber Reports') {
            steps {
                // Publish Cucumber test results (adjust the path as needed)
                cucumber 'target/cucumber-reports/*.json'
            }
        }
    }

    post {
        always {
            // Clean up or perform post-build actions
            echo 'Build completed'
        }
    }
}
