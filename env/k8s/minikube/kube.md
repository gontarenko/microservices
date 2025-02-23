`kubectl run hello-world --image=amigoscode/kubernetes:hello-world --port=80`

`kubectl get pods`

`kubectl port-forward pod/hello-world 8080:80`

`kubectl delete pod hello-world`

`kubectl delete all --all` - удалить все поды и сервисы

### Postgres Pod (находиться в терминале в env/k8s/minikube)

- `kubectl apply -f bootstrap/postgres`
- `kubectl describe pod postgres-0`
- `kubectl logs postgres-0`
- `kubectl exec -it postgres-0 -- psql -U postgres`

`\l` - список бд
`\c databasename` - коннект к бд
`\dt` - список таблиц
`\q` - выйти

`kubectl port-forward pod/postgres-0 5432:5432`

### rabbitmq
`kubectl apply -f bootstrap/rabbitmq`

### zipkin
`kubectl apply -f bootstrap/zipkin`

## всякие комманды

Получить всю инфу о подах, сервисах и тд:
- `kubectl get all`
- `kubectl get svc` - получить все запущенные сервисы
- `kubectl logs pods-name`

Получить доступ к сервису в кубере:
- `minikube service --url rabbitmq `
- `minikube tunnel` (можно обратиться по порту указаному в kubectl get services)


## Старт сервисов

`kubectl apply -f env/k8s/minikube/services/cutomer/`
`kubectl apply -f env/k8s/minikube/services/fraud/`
`kubectl apply -f env/k8s/minikube/services/notification/`

