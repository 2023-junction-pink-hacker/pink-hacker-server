#!/bin/bash

DOCKER_APP_NAME="junction-server"
NGINX_APP_NAME="junction-nginx"
# Blue 를 기준으로 현재 떠있는 컨테이너를 체크한다.
EXIST_BLUE=$(docker-compose -p ${DOCKER_APP_NAME}-blue -f docker-compose.blue.yml ps | grep Up)
EXIST_NGINX=$(docker-compose -p ${NGINX_APP_NAME} -f docker-compose.nginx.yml ps | grep Up)

# 컨테이너 스위칭
if [ -z "$EXIST_BLUE" ]; then
    echo "blue up"
    docker-compose -p ${DOCKER_APP_NAME}-blue -f docker-compose.blue.yml up -d
    BEFORE_COMPOSE_COLOR="green"
    AFTER_COMPOSE_COLOR="blue"
else
    echo "green up"
    docker-compose -p ${DOCKER_APP_NAME}-green -f docker-compose.green.yml up -d
    BEFORE_COMPOSE_COLOR="blue"
    AFTER_COMPOSE_COLOR="green"
fi

if [ -z "$EXIST_NGINX" ]; then
    echo "nginx up"
    docker-compose -p ${NGINX_APP_NAME} -f docker-compose.nginx.yml up -d
fi

sleep 60

# 새로운 컨테이너가 제대로 떴는지 확인
EXIST_AFTER=$(docker-compose -p ${DOCKER_APP_NAME}-${AFTER_COMPOSE_COLOR} -f docker-compose.${AFTER_COMPOSE_COLOR}.yml ps | grep Up)
if [ -n "$EXIST_AFTER" ]; then
    # nginx.config를 컨테이너에 맞게 변경해주고 reload 한다
    sudo cp ~/nginx.${AFTER_COMPOSE_COLOR}.conf ~/nginx.conf
    sudo docker cp ~/nginx.conf junction-nginx:/etc/nginx/nginx-temp.conf
    sudo docker exec junction-nginx cp /etc/nginx/nginx-temp.conf /etc/nginx/nginx.conf
    sudo docker exec junction-nginx nginx -s reload

    # 이전 컨테이너 종료
    docker-compose -p ${DOCKER_APP_NAME}-${BEFORE_COMPOSE_COLOR} -f docker-compose.${BEFORE_COMPOSE_COLOR}.yml down
    echo "$BEFORE_COMPOSE_COLOR down"
fi