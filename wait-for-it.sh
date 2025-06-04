#!/usr/bin/env bash
# wait-for-it.sh

host="$1"
shift
cmd="$@"

until nc -z $host; do
  echo "Aguardando $host..."
  sleep 2
done

echo "$host está pronto. Iniciando aplicação..."
exec $cmd
