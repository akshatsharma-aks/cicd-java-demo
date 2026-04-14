// pipeline {
//     agent any

//     stages {

//         stage('Build & Deploy') {
//             steps {
//                 bat 'docker-compose down || exit 0'
//                 bat 'docker-compose up --build -d'
//             }
//         }

//         stage('Test Backend') {
//             steps {
//                 bat 'ping 127.0.0.1 -n 10 > nul'
//                 bat 'curl http://localhost:8081/api/hello'
//             }
//         }

//         stage('Test Frontend') {
//             steps {
//                 bat 'curl http://localhost:3000'
//             }
//         }
//     }
// }