create table questionnaire.questionnaire_info
(
    id                   varchar(50) charset utf8 not null comment '问卷表主键'
        primary key,
    project_id           varchar(50)              null comment '项目id',
    question_name        varchar(100)             null comment '问卷名称',
    question_content     text                     null comment '问卷说明',
    data_id              varchar(50)              null comment '数据id',
    question_end_content text                     null comment '问卷结束说明',
    question_stop        varchar(255)             null comment '问卷结束',
    release_time         datetime                 null comment '发布时间',
    start_time           datetime                 null comment '开始时间',
    end_time             datetime                 null comment '结束时间',
    answer_total         varchar(100)             null comment '回答总数',
    created_by           varchar(32)              null comment '创建人',
    creation_date        datetime                 null comment '创建时间',
    last_updated_by      varchar(32)              null comment '最后修改人',
    last_update_date     datetime                 null comment '最后修改时间',
    question             varchar(100)             null comment '问卷（不是很懂，后面可以改）',
    question_title       varchar(100)             null comment '问卷题目',
    context              text                     null comment '问卷内容'
);


