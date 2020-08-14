create table system_dict
(
	kv_id int not null comment '主键'
		primary key,
	`key` varchar(16) not null comment '字典键',
	key_desc varchar(64) null comment '键描述',
	value_no int null comment '字典值编号',
	value_desc varchar(64) null comment '字典值描述',
	dependency_on_id int default 0 not null comment '该键值对向上依赖的另一对键值对'
);

create index `key`
	on system_dict (`key`, value_no);

