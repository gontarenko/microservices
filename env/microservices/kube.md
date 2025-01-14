kubectl run hello-world --image=amigoscode/kubernetes:hello-world --port=80

kubectl get pods

kubectl port-forward pod/hello-world 8080:80

kubectl delete pod hello-world
