sequenceDiagram

participant User
participant Nginx Ingress
participant Auth Service
participant Gateway
participant Message Broker
participant User Service
participant Order Service
participant Billing Service
participant Notification Service

User->>Nginx Ingress: POST /order/create
activate Nginx Ingress
Nginx Ingress->>Auth Service: POST forward auth request
activate Auth Service
Auth Service-->>Nginx Ingress: 200 forward auth
deactivate Auth Service
Nginx Ingress->>Gateway: POST /order/create
activate Gateway
Gateway->>Message Broker: publish
activate Message Broker
Note left of Message Broker: OrderCreateRequested
Message Broker-->>Order Service: consume
deactivate Message Broker
activate Order Service
Order Service->>Message Broker: publish
activate Message Broker
Note right of Message Broker: UserInfoRequested
Message Broker-->>User Service: consume
deactivate Message Broker
activate User Service
User Service->>Message Broker: publish
activate Message Broker
deactivate User Service
Note right of Message Broker: UserInfo
Message Broker-->>Order Service: consume
deactivate Message Broker
Order Service->>Message Broker: publish
activate Message Broker
Note right of Message Broker: BillingRequested
Message Broker-->>Billing Service: consume
deactivate Message Broker
activate Billing Service
Billing Service->>Message Broker: publish
activate Message Broker
deactivate Billing Service
Note right of Message Broker: PaymentProcessed
Message Broker-->>Order Service: consume
deactivate Message Broker
Order Service->>Message Broker: publish
activate Message Broker
deactivate Order Service
Note right of Message Broker: OrderCompleted
Message Broker-->>Gateway: consume
Gateway-->>Nginx Ingress: response
deactivate Gateway
Nginx Ingress-->>User: response
deactivate Nginx Ingress
Message Broker-->>Notification Service: consume
deactivate Message Broker
activate Notification Service
Notification Service->>Notification Service: sending email
deactivate Notification Service
