kubectl run hello-world --image=amigoscode/kubernetes:hello-world --port=80

kubectl get pods

kubectl port-forward pod/hello-world 8080:80

kubectl delete pod hello-world



### Postgres Pod (находиться в терминале в env/k8s/minikube)

- kubectl apply -f bootstrap/postgres
- kubectl describe pod postgres-0
- kubectl logs postgres-0
- kubectl exec -it postgres-0 -- psql -U postgres

### rabbitmq
kubectl apply -f bootstrap/rabbitmq

### zipkin
kubectl apply -f bootstrap/zipkin

## всякие комманды

Получить всю инфу о подах, сервисах и тд:
- kubectl get all


Получить доступ к сервису в кубере:
- minikube service --url rabbitmq 
- minikube tunnel (можно обратиться по порту указаному в kubectl get services)