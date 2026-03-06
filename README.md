🚀 DevOps CI/CD Pipeline for Scientific Calculator

A complete DevOps automation pipeline built around a Java Scientific Calculator application.
This project demonstrates how modern DevOps tools can automate the build, containerization, and deployment process using CI/CD pipelines.
The goal of this project is to simulate a real-world DevOps workflow where code changes automatically trigger build, container creation, and deployment.


📌 Project Overview
This project implements a DevOps CI/CD pipeline for a Java-based Scientific Calculator application.
The pipeline performs the following automated steps:
Developer pushes code to GitHub
Jenkins CI/CD Pipeline is triggered
Maven builds the Java application
Docker creates a container image
Image is pushed to Docker Hub
Ansible deploys the container automatically
This ensures continuous integration and automated deployment of the application.


🏗 DevOps Architecture

Developer
   │
   ▼
GitHub Repository
   │
   ▼
Jenkins CI/CD Pipeline
   │
   ├── Maven Build
   ├── Docker Image Build
   ├── Push to Docker Hub
   │
   ▼
Ansible Deployment
   │
   ▼
Running Scientific Calculator Container


🛠 Tools & Technologies Used

Tool	Purpose
Java	Application development
Maven	Build automation
GitHub	Source code management
Jenkins	CI/CD pipeline automation
Docker	Containerization
Docker Hub	Container image registry
Ansible	Deployment automation


📂 Project Structure

Scientific-Calculator
│
├── src/                    # Java source code
├── target/                 # Maven build output
├── ansible/
│   ├── deploy_calculator.yml
│   └── inventory
│
├── Dockerfile              # Docker container configuration
├── Jenkinsfile             # Jenkins CI/CD pipeline
├── pom.xml                 # Maven configuration
└── README.md


⚙️ CI/CD Pipeline Workflow

1️⃣ Code Push
Developers push code changes to GitHub.
git add .
git commit -m "Update calculator logic"
git push origin main

2️⃣ Jenkins Pipeline Trigger
Jenkins automatically triggers the pipeline and performs:
Code checkout
Maven build
Docker image build
Docker image push
Deployment via Ansible

3️⃣ Build Application (Maven)
mvn clean package
This generates the application JAR file.

4️⃣ Build Docker Image
docker build -t rishuagrawal1309/scientific-calculator .

5️⃣ Push Image to Docker Hub
docker push rishuagrawal1309/scientific-calculator
Docker Hub repository:
👉 https://hub.docker.com/r/rishuagrawal1309/scientific-calculator

6️⃣ Deploy using Ansible
ansible-playbook ansible/deploy_calculator.yml -i ansible/inventory
Ansible automatically:
pulls the latest image
starts the container
deploys the application


🐳 Dockerfile

FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/scientific-calculator-1.0.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]


📊 Sample Output

The application runs inside a Docker container and performs scientific calculations.
Example operations:
Addition
Subtraction
Multiplication
Division


📷 Project Screenshots

GitHub Repository
Jenkins Pipeline
Docker Hub Repository
Ansible Deployment


🎯 Key DevOps Concepts Demonstrated

✔ Continuous Integration
✔ Continuous Deployment
✔ Infrastructure Automation
✔ Containerization
✔ Version Control
✔ Automated Deployment


📚 Learning Outcomes

This project helped understand:
End-to-end DevOps pipeline design
CI/CD automation using Jenkins
Docker containerization
Infrastructure automation using Ansible
Integration of multiple DevOps tools


🔗 Project Links

GitHub Repository
👉 https://github.com/rishuagrawal1309/Scientific-Calculator
Docker Hub Repository
👉 https://hub.docker.com/r/rishuagrawal1309/scientific-calculator


👩‍💻 Author

Rishu Agrawal
M.Tech CSE
Roll No: MT2025104
