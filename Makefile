init: build

build:
	mvn clean package

run:
	java -jar target/huntr-core-1.0-SNAPSHOT.jar server config.yml

#docker:
#	mvn clean grails:war
#	docker build -t store-admin .
#	docker run -d -p 5740:5740 -e RC_HOSTNAME=`docker-machine ip default` store-admin
#
#docker-build:
#	docker build -t store-admin .
#docker run -d -p 5740:5740 -e RC_HOSTNAME=`docker-machine ip default` store-admin