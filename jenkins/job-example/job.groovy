job('Customer Service job') {
    scm {
        git('git://github.com/giova333/jenkins-example.git') { node ->
            node / gitConfigName('giova333')
            node / gitConfigEmail('gladun.aleksander@mail.ru')
        }
    }
    steps {
        maven('clean install')
        dockerBuildAndPublish {
            repositoryName('giova333/customer-service')
            tag('release')
            registryCredentials('docker-hub')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
            forceTag(false)
        }
    }
}