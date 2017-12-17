# kafka-mp-sample

Two simple Java microservices, talking via Apache Kafka:
* Sender service, powered by WildFly Swarm's Microprofile implementation, [here](/producer)
* Service receiving data, powered by WildFly Swarm's Microprofile implementation, [here](/consumer)

For installation it's recommended to use Openshift Origin, like:
```shell
# Start the Openshift Origin cluster (make sure binaries are installed)
oc cluster up

# by default we are logged in as the 'developer'
# Let's create a project:
oc new-project someproject

# In that project we use the EnMasse template to spin up Apache Zookeeper and Apache Kafka, in the above namespace
oc new-app -f https://raw.githubusercontent.com/EnMasseProject/barnabas/0.1.0-rc1/kafka-statefulsets/resources/openshift-template.yaml -n someproject
```

in each service deploy it, like:

```shell
mvn clean fabric8:deploy -DskipTests -Popenshift
```

