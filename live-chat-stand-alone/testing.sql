create table if not exists livechat_user_relation
(
    my_id                         bigint    not null comment '我方的主键',
    others_id                     bigint    not null comment '对方的主键',
    relation_state                tinyint   not null default 1 comment '用户关系类型，好友[1]拉黑[2]屏蔽消息[3]关心[4]',
    relation_create_datetime      timestamp not null default now() comment '用户关系首次创建时间',
    relation_last_update_datetime timestamp not null default now() on update now() comment '用户关系最近一次更新时间',
    constraint union_primary_key primary key (my_id, others_id)
) comment '用户与用户之间的关系';