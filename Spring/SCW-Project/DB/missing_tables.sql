create table t_project_images
(
  id int auto_increment,
  projectid int,
  imgurl varchar(255),
  imgtype tinyint(4) comment '0 - 头部图片  1 - 详情图片',
  primary key (id)
);

create table t_project_initiator
(
  id int auto_increment,
  selfintroduction varchar(255),
  detailselfintroduction varchar(255),
  telphone varchar(13),
  hotline varchar(13),
  projectid int,
  primary key (id)
);

create table t_project_legal
(
  id int auto_increment,
  account varchar(20),
  cardnum varchar(255),
  projectid int,
  primary key (id)
);


insert into t_type(name, remark) values("科技","");
insert into t_type(name, remark) values("设计","");
insert into t_type(name, remark) values("公益","");
insert into t_type(name, remark) values("农业","");

insert into t_tag(pid,name) values("","手机");
insert into t_tag(pid,name) values("","数码");
insert into t_tag(pid,name) values("","电脑");
insert into t_tag(pid,name) values("1","手机");
insert into t_tag(pid,name) values("1","快充");
insert into t_tag(pid,name) values("2","照相机");
insert into t_tag(pid,name) values("2","平板");
insert into t_tag(pid,name) values("3","笔记本");
insert into t_tag(pid,name) values("3","台式机");

insert into t_menu(id,pid,name,url) values(1,0,'控制面板','/admin/index');
insert into t_menu(id,pid,name,url) values(2,0,'权限管理',null);
insert into t_menu(id,pid,name,url) values(3,2,'用户维护','/admin/user');
insert into t_menu(id,pid,name,url) values(4,2,'角色维护','/admin/role');
insert into t_menu(id,pid,name,url) values(5,2,'权限维护','/admin/permission');
insert into t_menu(id,pid,name,url) values(6,2,'菜单维护','/admin/menu');
