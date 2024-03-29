--liquibase formatted sql

--changeset rakovets:database-1 dbms:postgresql
-- precondition
CREATE SCHEMA IF NOT EXISTS "spring_framework_orm";
CREATE SCHEMA IF NOT EXISTS "spring_data";
CREATE SCHEMA IF NOT EXISTS "spring_security";
--rollback DROP SCHEMA "spring_framework_orm" CASCADE;
--rollback DROP SCHEMA "spring_data" CASCADE;
--rollback DROP SCHEMA "spring_security" CASCADE;

--changeset rakovets:database-1 dbms:mariadb
-- precondition
CREATE SCHEMA IF NOT EXISTS spring_framework_orm;
CREATE SCHEMA IF NOT EXISTS spring_data;
CREATE SCHEMA IF NOT EXISTS spring_security;
--rollback DROP SCHEMA spring_framework_orm;
--rollback DROP SCHEMA spring_data;
--rollback DROP SCHEMA spring_security;

--changeset rakovets:database-2 dbms:mariadb
GRANT ALL PRIVILEGES ON spring_framework_orm.* TO 'mariadb'@'%';
GRANT ALL PRIVILEGES ON spring_data.* TO 'mariadb'@'%';
GRANT ALL PRIVILEGES ON spring_security.* TO 'mariadb'@'%';
--rollback REVOKE ALL PRIVILEGES ON spring_framework_orm.* FROM 'mariadb'@'%';
--rollback REVOKE ALL PRIVILEGES ON spring_data.* FROM 'mariadb'@'%';
--rollback REVOKE ALL PRIVILEGES ON spring_security.* FROM 'mariadb'@'%';
