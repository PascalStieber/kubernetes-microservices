#cheatsheet

kubectl exec -ti [podname] -- bash

# persistentvolumes:
# ist der typ 'hostpath', werden die directories nicht automatisch auf dem host-system, sondern erst einmal nur in minikube angelegt.
# anmelden in minikube mit: minikube ssh 
# dann in das unter 'hostpath' angegebene verzeichnis wechseln. dort sind die dateien abgelegt.
# will man das verzeichnis auf dem hostsystem (bare metal) angelegt bekommen, muss das verzeichnis in minikube gemountet werden:
# minikube mount HOST_MOUNT_DIRECTORY:VM_MOUNT_DIRECTORY(ex:"/host-home:/vm-home")
