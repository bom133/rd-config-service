#Health Check
http://localhost:8760/rd-config-service/actuator/health

SETUP GitLocal

- Window
1. create folder gitrepo
2. >cd gitrepo
3. >git init (For Initial empty Git)
Initialized empty Git repository in D:/gitrepo/.git/

- Unix
1. >cd /home/wasadmin
2. >mkdir gitrepo
3. >cd gitrepo
4. >git init
Initialized empty Git repository in /home/wasadmin/gitrepo/.git/

5. Move file configure
6. >git config --global user.email 'owner@wisesoft.co.th'
	git config --global user.name 'WISESOFT Development'

7. >git add .
8. >git commit -m 'Initial Local configure'
/home/wasadmin/gitrepo/config


#Check URL
#ENV DEV
http://localhost:8760/rd-discovery-service/default
#ENV SIT
http://10.11.2.21:8760/rd-discovery-service/default


