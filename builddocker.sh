docker build -t pascalstieber/kubernetes_microservices:webui-v1 ./demo-app/webui
docker push pascalstieber/kubernetes_microservices:webui-v1

docker build -t pascalstieber/kubernetes_microservices:datawarehouse-v1 ./demo-app/datawarehouse
docker push pascalstieber/kubernetes_microservices:datawarehouse-v1

docker build -t pascalstieber/kubernetes_microservices:billing-v1 ./demo-app/billing
docker push pascalstieber/kubernetes_microservices:billing-v1

docker build -t pascalstieber/kubernetes_microservices:shoppingcart-v1 ./demo-app/shoppingcart
docker push pascalstieber/kubernetes_microservices:shoppingcart-v1
