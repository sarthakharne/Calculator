pipeline{
    environment{
        docker_image = ""
    }
    agent any
    stages{
        stage('Stage 1: Git Clone'){
            steps{
                git branch: 'master',
                url: 'https://github.com/sarthakharne/Calculator.git'
            }
        }
        stage('Stage 2: Maven Build'){
            steps{
                sh 'mvn clean install'
            }
        }
        stage('Stage 3: Build Docker Image'){
            steps{
                script{
                    docker_image = docker.build "sarthakharne2262/calculator:latest"
                }
            }
        }
        stage('Stage 4: Push docker image to hub'){
            steps{
                script{
                    docker.withRegistry('', 'DockerHubCred'){
                        docker_image.push()
                    }
                }
            }
        }
        stage('Stage 5: Clean Docker Images'){
            steps{
                script{
                    sh 'docker container prune -f'
                    sh 'docker image prune -f'
                }
            }
        }
        stage('Stage 6: Ansible Deployment'){
            steps{
                ansiblePlaybook becomeUser: null,
                colorized: true,
                credentialsId: 'localhost',
                disableHostKeyChecking: true,
                installation: 'Ansible',
                inventory: 'Deployment/inventory',
                playbook: 'Deployment/deploy.yaml',
                sudoUser: null
            }
        }
    }
}