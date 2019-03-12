# kubernetes-microservices

## application
b-amzng is just another online shop, but it is high scalable & resilient as hell.

### services
web-frontend / gui
shopping card / warenkorb
order / bestellung
billing / rechnung
payment / bezahl
shipment / versandt

## deployment szenarios
mehrere versionen einer applikation:
- web-frontend:v1; web-frontend:v2 (verspricht 10% mehr umsatz durch bessere usability)
	- web-frontend:v1 nur html; ohne css; ganz rudimentär
	- web-frontend:v2 responsive weboberfläche mit stylesheets (bootstrap)
- billing:v1; billing:black-friday (15% auf den kompletten einkauf am black-friday
- order:v1; order:v2 (bugfix: 10% des traffics sollen testhalber auf den neuen 'bugfreien' order-process geroutet werden
	- order:v1 order objekt wird nicht gespeichert.
	- order:v2 order objekt wird gespeichert.
- https://istio.io/docs/tasks/traffic-management/fault-injection/ Injecting an HTTP abort fault
	- order ruft billing auf, billing antwortet aber nur mit latenzen (evlt. abort fault 20%)


## istio service mesh

### visualize service graph with kiali 

## testing via watch curl
