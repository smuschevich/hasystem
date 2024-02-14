#!/bin/sh

ip=$(hostname -i)

/usr/local/bin/docker-entrypoint.sh agent -config-dir=/consul/config/ -dev -bind "$ip" "$@"
