pipeline {
  agent any

  stages {
    stage('SCM') {
      steps {
        checkout scm
      }
    }

    stage('SonarQube Analysis') {
      environment {
        MVN_HOME = tool 'Maven_Home'
      }
      steps {
        withSonarQubeEnv('SonarQube') {
          sh "./mvn clean verify sonar:sonar -Dsonar.projectKey=TestProject -Dsonar.projectName='TestProject'"
        }
      }
    }
  }
}
