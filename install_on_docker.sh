# Install istio
curl -L https://github.com/knative/serving/releases/download/v0.5.0/istio.yaml \
  | sed 's/LoadBalancer/NodePort/' \
  | kubectl apply --filename -

# Label the default namespace with istio-injection=enabled.
kubectl label namespace default istio-injection=enabled

# Install knative
curl -L https://github.com/knative/serving/releases/download/v0.5.0/serving.yaml \
  #| sed 's/LoadBalancer/NodePort/' \
  | kubectl apply --filename -