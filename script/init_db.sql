CREATE DATABASE product_management_db;

CREATE USER product_manager_user WITH
    LOGIN
    NOSUPERUSER
    NOCREATEDB
    NOCREATEROLE
    INHERIT
    PASSWORD '123456';

GRANT ALL PRIVILEGES ON DATABASE product_management_db TO product_manager_user;

GRANT ALL ON SCHEMA public TO product_manager_user;

ALTER DEFAULT PRIVILEGES IN SCHEMA public
    GRANT ALL ON TABLES TO product_manager_user;