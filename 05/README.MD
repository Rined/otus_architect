## Run
```
helm install app ./crud-app-chart
helm install auth ./auth-chart
```

## Tests
```
newman run postman/otus_arch_auth.postman_collection.json
```

## Sequence diagram
![pods_metrics](img/otus_auth_schema.png)