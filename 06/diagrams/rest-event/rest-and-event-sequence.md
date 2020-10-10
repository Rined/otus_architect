sequenceDiagram

participant User
participant Nginx Ingress
participant Auth Service
participant User Service
participant Order Service
participant Billing Service
participant Message Broker
participant Notification Service

User->>Nginx Ingress: POST /order/create
activate Nginx Ingress
Nginx Ingress->>Auth Service: POST forward auth request
activate Auth Service
Auth Service-->>Nginx Ingress: 200 forward auth
deactivate Auth Service
Nginx Ingress->>Order Service: POST /order/create
activate Order Service
Order Service->>User Service: GET /user/me
activate User Service
User Service-->>Order Service: 200
deactivate User Service
Order Service->>Billing Service: POST /account/withdraw
activate Billing Service
Billing Service-->>Order Service: 200
deactivate Billing Service
Order Service->>Message Broker: publish
activate Message Broker
Note left of Message Broker: SendEmail
Order Service-->>Nginx Ingress: 200
deactivate Order Service
Message Broker-->>Notification Service: consume
deactivate Message Broker
activate Notification Service
Nginx Ingress-->>User: 200
deactivate Nginx Ingress
Notification Service->>Notification Service: sending email
deactivate Notification Service