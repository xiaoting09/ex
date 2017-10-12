/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/10/12 10:21:59                          */
/*==============================================================*/


drop table if exists ex_client;

drop table if exists ex_client_data;

drop table if exists ex_clinet_list;

drop table if exists ex_config;

drop table if exists ex_list;

/*==============================================================*/
/* Table: ex_client                                             */
/*==============================================================*/
create table ex_client
(
   id                   int not null auto_increment comment '自增ID',
   type                 tinyint(1) default 0 comment '来源:0服务端注册1客户端自己注册',
   ip                   varchar(50) comment '客户端IP地址',
   state                tinyint(1) default 1 comment '该客户端状态0禁止1启用',
   email                varchar(100) comment '通知邮箱',
   phone                varchar(100) comment '通知手机号',
   remarks              varchar(225) comment '注释',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   is_enabled           tinyint(1) default 1 comment '是否可用',
   primary key (id)
);

alter table ex_client comment '异常客户端';

/*==============================================================*/
/* Table: ex_client_data                                        */
/*==============================================================*/
create table ex_client_data
(
   id                   bigint not null auto_increment,
   client_id            int comment '客户端ID',
   parameters           text comment '请求参数集合json',
   ex_class             varchar(255) comment '错误异常类',
   ex_time              timestamp comment '异常发生时间',
   msg                  text comment '错误信息',
   type                 varchar(10) comment '请求方式GET还是POST',
   content_type         varchar(25) comment '请求格式',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   is_enabled           tinyint(1) default 1 comment '是否可用',
   primary key (id)
);

alter table ex_client_data comment '异常错误数据';

/*==============================================================*/
/* Table: ex_clinet_list                                        */
/*==============================================================*/
create table ex_clinet_list
(
   id                   int not null auto_increment,
   client_id            int not null comment '客户端ID',
   list_id              int comment '异常ID',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   is_enabled           tinyint(1) default 1 comment '是否可用',
   primary key (id)
);

alter table ex_clinet_list comment '机器对应的异常关联';

/*==============================================================*/
/* Table: ex_config                                             */
/*==============================================================*/
create table ex_config
(
   id                   int not null auto_increment,
   name                 varchar(50) comment '名称',
   value                varchar(500) comment '值',
   description          text comment '备注',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   is_enabled           tinyint(1) default 1 comment '是否可用',
   primary key (id)
);

alter table ex_config comment '配置字典表';

/*==============================================================*/
/* Table: ex_list                                               */
/*==============================================================*/
create table ex_list
(
   id                   int not null auto_increment,
   name                 varchar(60) not null comment '异常名称',
   nick_name            varchar(50) comment '中文名',
   type                 tinyint(1) default 0 comment '0是系统默认异常1自定义异常',
   remarks              varchar(255) comment '异常说明',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   is_enabled           tinyint(1) default 1 comment '是否可用',
   primary key (id)
);

alter table ex_list comment '异常集合';

