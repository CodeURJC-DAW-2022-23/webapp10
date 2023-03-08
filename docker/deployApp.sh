#!/bin/bash
# $1 = adroius/codeurjc-daw-2022-23-webapp10
# $2 = codeurjc-daw-2022-23-webapp10

docker pull $1

docker tag $1 registry.heroku.com/$2/web

docker push registry.heroku.com/$2/web

heroku container:release web -a $2

heroku logs --tail -a $2