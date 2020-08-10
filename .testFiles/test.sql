create table user
(
	id bigint not null comment '用户主键ID'
		primary key,
	chat_no varchar(32) not null comment '微信号，8-20位，限字母与数字',
	username varchar(64) not null comment '用户名，2-12位，支持中文',
	gender tinyint default 1 not null comment '1-男，2-女',
	birthday timestamp null comment '出生日期',
	signature varchar(128) null comment '个性签名',
	company varchar(64) null comment '公司名称',
	personal_description varchar(255) null comment '个人说明',
	user_password varchar(128) not null comment '加盐密码',
	salt varchar(32) not null comment '密码盐',
	phone_number varchar(32) not null comment '手机号',
	email varchar(64) null comment '邮箱',
	blood_group int null comment '字典-血型',
	occupation int null comment '字典-从事行业',
	location int null comment '字典-现居地',
	hometown int null comment '字典-故居',
	account_status tinyint default 1 not null comment '1-可用，2-禁止登陆，3-已注销',
	constraint chat_no
		unique (chat_no),
	constraint email
		unique (email),
	constraint phone_number
		unique (phone_number)
);

