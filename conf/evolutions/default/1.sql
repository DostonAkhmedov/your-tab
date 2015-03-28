# --- Created by Slick DDL
# To stop Slick DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table "Tabs" ("ID" SERIAL NOT NULL PRIMARY KEY,"NAME" VARCHAR(254) DEFAULT '' NOT NULL,"ADDRESS" VARCHAR(254) DEFAULT '' NOT NULL,"IMG_NAME" VARCHAR(254) DEFAULT '' NOT NULL);

# --- !Downs

drop table "Tabs";

