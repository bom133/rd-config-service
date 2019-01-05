pipeline {
    agent any
    environment {
                NEXUS_CREDS = credentials('nexustoon-credential')
                DOCKER_PROXY_HOST = "nexustoon.com:8082"
                DOCKER_PRIVATE_HOST = "nexustoon.com:8083"
                REPLICACOUNT = "1"
                //Use Pipeline Utility Steps plugin to read information from pom.xml into env variables
                PROJECT_VERSION = readMavenPom().getVersion()
                PROJECT_NAME = readMavenPom().getArtifactId()            
    }
    stages {
        stage("Docker push") {
            steps {
                sh "docker login -u admin  -p admin nexustoon.com:8083"
                sh "docker push nexustoon.com:8083/rd-epayment-service:0.1.1-SNAPSHOT"
                //sh "docker login -u $NEXUS_CREDS_USR  -p $NEXUS_CREDS_PSW $DOCKER_PRIVATE_HOST"
                //sh "docker push ${DOCKER_PRIVATE_HOST}/${PROJECT_NAME}:${PROJECT_VERSION}"
            }
        }
        
        stage("Deploy to kubernetes") {
            steps {
                echo " Deploy "
                //script must be approved
                //new java.io.File java.lang.String
                //staticMethod org.codehaus.groovy.runtime.DefaultGroovyMethods getText java.io.File
                //staticMethod org.codehaus.groovy.runtime.DefaultGroovyMethods write java.io.File java.lang.String
                //before using this script
                //script{
                //    def chartFile = new File("${WORKSPACE}/deployment/Chart.yaml")
                //    def chartText = chartFile.text
                //    appVersionReplaceStr = "appVersion: ${PROJECT_VERSION}"
                //    nameReplaceStr = "name: ${PROJECT_NAME}"
                //    versionReplaceStr = "version: ${PROJECT_VERSION}"
                //    chartText = chartText.replace("appVersion: dummy",appVersionReplaceStr)
                //    chartText = chartText.replace("name: dummy",nameReplaceStr)
                //    chartText = chartText.replace("version: dummy",versionReplaceStr)
                //    chartFile.write(chartText)
                //}
            }   
        }
    }
}