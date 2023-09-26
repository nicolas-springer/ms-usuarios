pipeline{
agent any
    stages{
        stage('clean'){
            steps{
                bat"java -version"
                bat"./mvnw clean"
            }
        }
        stage('backendtests'){
            steps{
                //bat"./mvnw test"
                bat"echo'configurar para ejecutar los tests'"
            }
        }
        stage('Install'){
            steps{
                bat"./mvnw clean install site-DskipTests"
                //bat"./mvnw pmd:pmd"
                archiveArtifacts artifacts:'**/target/*.jar',fingerprint:true
                archiveArtifacts artifacts:'**/target/site/**'
            }
        }
        stage('reportes'){
            publishHTML([allowMissing:false,
            alwaysLinkToLastBuild:true,
            keepAll:true,
            reportDir:'target/site',
            reportFiles:'index.html',
            reportName:'Site'
            ])
        }
    }
    options{
        buildDiscarder(logRotator(numToKeepStr:'5',artifactNumToKeepStr:'5'))
    }
}
