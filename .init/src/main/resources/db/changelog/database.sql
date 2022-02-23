--liquibase formatted sql

--changeset rakovets:database-1 dbms:postgresql
-- precondition
CREATE SCHEMA IF NOT EXISTS "spring_framework_orm";
--rollback DROP SCHEMA "spring_framework_orm" CASCADE;

--changeset rakovets:database-1 dbms:mariadb
-- precondition
CREATE SCHEMA IF NOT EXISTS spring_framework_orm;
--rollback DROP SCHEMA spring_framework_orm;

--changeset rakovets:database-2 dbms:mariadb
GRANT ALL PRIVILEGES ON spring_framework_orm.* TO 'mariadb'@'%';
--rollback REVOKE ALL PRIVILEGES ON spring_framework_orm.* FROM 'mariadb'@'%';
