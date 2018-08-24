# user-management
Create user and database:
sudo -u postgres -i psql
CREATE USER userm with password 'userm';
CREATE DATABASE user_management with owner userm;