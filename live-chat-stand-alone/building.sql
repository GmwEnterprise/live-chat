create table live_chat.livechat_dict
(
	kv_id int auto_increment comment '主键'
		primary key,
	`key` varchar(16) not null comment '键，最大长度16',
	key_desc varchar(64) null comment '键描述，最大长度64',
	val int null comment '键对应的int型值',
	val_desc varchar(64) null comment '键值描述，最大长度64',
	dependency_on_id int default 0 not null comment '该键值对向上依赖的另一对键值对',
	can_modify tinyint default 1 not null comment '是否允许修改该条记录，允许[1]禁止[2]，默认[1]',
	constraint key_value_unique
		unique (`key`, val)
)
comment '系统字典';

create table live_chat.livechat_message
(
	id bigint not null comment '消息主键，外部赋值'
		primary key,
	sender_id bigint not null comment '消息发送者',
	send_time timestamp default CURRENT_TIMESTAMP not null comment '发送时间',
	receiver_id bigint not null comment '消息接收者',
	receiver_type tinyint not null comment '消息接收者类型，用户[1],群[2]',
	received tinyint(1) default 0 not null comment '是否已接收，未接收的消息为离线消息',
	receive_time timestamp null comment '消息接收时间',
	message_type tinyint default 1 not null comment '消息类型，文本[1],图片[2],文件[3],表情[4]',
	message varchar(256) default '' not null comment '消息主体，处理方式取决于 message_type',
	read_state tinyint(1) default 0 not null comment '是否已读'
)
comment '消息存储表';

create table live_chat.livechat_user
(
	id bigint not null comment '主键，64位Long型，JSON传输请使用String'
		primary key,
	username varchar(16) not null comment '用户名称，支持中文，支持空字符串，最大长度为16',
	avatar_id varchar(64) null comment '用户头像对应的图片名称，图片地址前缀保存为常量，图片格式统一为png格式，大小处理为200*200',
	gender tinyint default 3 not null comment '性别，枚举数值，男[1]女[2]保密[3]，默认为[3]',
	birthday timestamp null comment '出生日期，必须为过去的日期，格式[yyyy-MM-dd HH:mm:ss]',
	signature varchar(128) null comment '个性签名，最大长度128',
	company varchar(64) null comment '公司名称，最大长度64',
	personal_description varchar(255) null comment '个人说明，最大长度255',
	user_password varchar(128) not null comment '加盐密码',
	salt varchar(32) default '' not null comment '密码盐',
	phone_number varchar(32) not null comment '手机号',
	email varchar(64) null comment '邮箱',
	blood_group tinyint null comment '血型，枚举数值，A型血[1]B型血[2]O型血[3]AB型血[4]',
	occupation int null comment '字典-从事行业',
	location int null comment '字典-现居地',
	hometown int null comment '字典-故居',
	account_status tinyint default 1 not null comment '账户使用状态，枚举数值，使用中[1]禁用[2]已注销[3]，默认为[1]',
	constraint email_unique
		unique (email),
	constraint phone_number_unique
		unique (phone_number)
)
comment '用户信息';

create table live_chat.livechat_user_relation
(
	my_id bigint not null comment '我方的主键',
	others_id bigint not null comment '对方的主键',
	relation_state tinyint default 1 not null comment '用户关系类型，好友[1]拉黑[2]屏蔽消息[3]关心[4]',
	backup_name varchar(32) null comment '为对方设置的备注',
	relation_create_datetime timestamp default CURRENT_TIMESTAMP not null comment '用户关系首次创建时间',
	relation_last_update_datetime timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '用户关系最近一次更新时间',
	primary key (my_id, others_id)
)
comment '用户与用户之间的关系';

