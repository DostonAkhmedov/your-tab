# --- Created by Slick DDL
# To stop Slick DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table "CATEGORIES" ("ID" SERIAL NOT NULL PRIMARY KEY,"NAME" VARCHAR(254) DEFAULT '' NOT NULL);
create table "Tabs" ("ID" SERIAL NOT NULL PRIMARY KEY,"NAME" VARCHAR(254) DEFAULT '' NOT NULL,"ADDRESS" VARCHAR(254) DEFAULT '' NOT NULL,"CATEGORY_ID" INTEGER NOT NULL);
create table "Users" ("ID" SERIAL NOT NULL PRIMARY KEY,"FIRST_NAME" VARCHAR(254) DEFAULT '' NOT NULL,"LAST_NAME" VARCHAR(254) DEFAULT '' NOT NULL,"MAIL_ADDRESS" VARCHAR(254) DEFAULT '' NOT NULL,"PASSWORD" VARCHAR(254) DEFAULT '' NOT NULL);
alter table "Tabs" add constraint "CITY_FK_CATEGORY_ID" foreign key("CATEGORY_ID") references "CATEGORIES"("ID") on update NO ACTION on delete NO ACTION;

# --- !Downs

alter table "Tabs" drop constraint "CITY_FK_CATEGORY_ID";
drop table "Users";
drop table "Tabs";
drop table "CATEGORIES";

