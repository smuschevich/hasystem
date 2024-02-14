# build stage
FROM consul:1.15

# create working directory
WORKDIR /home/consul

COPY consul-client-startup.sh startup.sh

ENTRYPOINT ["/home/consul/startup.sh"]
