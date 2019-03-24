create database if not exists uerax;
use uerax;

create table t_user (
	`id` int(11) not null auto_increment,
	`nickname` varchar(50) not null default '' comment '昵称',
	`username` varchar(50) not null default '' comment '用户名',
	`password` varchar(30) not null default '' comment '用户密码',
	`gender` tinyint(1) not null default '0' comment '性别：0为女，1为男',
	`avatar` varchar(128) not null default '' comment '头像',
	`birthday` date not null default '1970-01-01' comment '生日',
	`sign` varchar(512) not null default '' comment '签名',
	`wechat` varchar(20) not null default '' comment '微信',
	`create` TIMESTAMP not null default CURRENT_TIMESTAMP comment '创建日期',
	primary key(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

alter table t_user alter column `create` set default NOW();

alter table t_user add unique(username);

create table t_cource_classify (
	`id` int(11) not null auto_increment,
	`cource_name` varchar(50) not null default '' comment '课程名',
	`cource_code` varchar(50) not null default '' comment '分级编号',
	`parent_code` varchar(50) not null default '0' comment '父级分类编号,为0则表示顶级分类',
	primary key(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程类别表';

insert into t_cource_classify (cource_name, cource_code) values ('前端开发', 'fe');
insert into t_cource_classify (cource_name, cource_code) values ('后端开发', 'be');
insert into t_cource_classify (cource_name, cource_code) values ('移动开发', 'mb');
insert into t_cource_classify (cource_name, cource_code) values ('数据库', 'db');

insert into t_cource_classify (cource_name, cource_code, parent_code) values ('HTML', 'html', 'fe');
insert into t_cource_classify (cource_name, cource_code, parent_code) values ('Node.js', 'node', 'fe');
insert into t_cource_classify (cource_name, cource_code, parent_code) values ('Java', 'java', 'be');
insert into t_cource_classify (cource_name, cource_code, parent_code) values ('C', 'c', 'be');
insert into t_cource_classify (cource_name, cource_code, parent_code) values ('PHP', 'php', 'be');
insert into t_cource_classify (cource_name, cource_code, parent_code) values ('Android', 'android', 'mb');
insert into t_cource_classify (cource_name, cource_code, parent_code) values ('IOS', 'ios', 'mb');
insert into t_cource_classify (cource_name, cource_code, parent_code) values ('MySQL', 'mysql', 'db');
insert into t_cource_classify (cource_name, cource_code, parent_code) values ('Oracle', 'oracle', 'db');


create table t_cource (
	`id` int(11) not null auto_increment,
	`name` varchar(50) not null default '' COMMENT '课程名',
	`classify` varchar(50) not null default '' comment '课程类别',
	`sub_classify` varchar(50) not null default '' comment '二级课程',
	`creater` varchar(50) not null default '' comment '创建用户',
	`free` tinyint(1) not null default '1' comment '是否收费 0收费 1免费',
	`price` int not null default 0 comment '价格',
	`introduce` varchar(255) not null default '' comment '课程描述',
	`create_day` TIMESTAMP not null default CURRENT_TIMESTAMP comment '创建日期',
	primary key(`id`)
) engine=INNODB default charset=utf8 comment='课程表';

create table t_user_cource (
	`id` int(11) not null auto_increment,
	`user_id` int(11) not null default '0' comment '用户id',
	`classify` varchar(50) not null default '' comment '课程类别',
	`cource_id` int(11) not null default '0' comment '课程id',
	`cource_name` varchar(50) not null default '' comment '课程名',
	primary key(`id`)
) engine=INNODB default charset=utf8 comment='用户选课表';

CREATE TABLE `t_course_section` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) NOT NULL DEFAULT '0' COMMENT '归属课程id',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父章节id',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '章节名称',
	`sort` int(11) NOT NULL default '1' comment '排序',
  `url` varchar(255) NOT NULL DEFAULT '' comment '视频地址',
  `create_day` TIMESTAMP not null default CURRENT_TIMESTAMP comment '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程章节表';

CREATE TABLE `t_carousel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '名称',
  `picture` varchar(100) NOT NULL DEFAULT '' COMMENT '图片',
  `url` varchar(200) NOT NULL DEFAULT '' COMMENT '链接',
  `enable` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否播放',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='首页轮播表';