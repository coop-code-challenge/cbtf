-- noinspection SqlNoDataSourceInspectionForFile

insert into diagnosis(diagnosis_id, description) values(1, 'work');
insert into diagnosis(description) values('Will I work?');
insert into users(id, admin, active) values('work@pls', false, false);
insert into users(id, admin, active) values('work@gmail.com', true, null);

insert into category(description, active) values('Medical', true);
insert into subcategory(description, active, category_Id) values('Medical Detail', true, 1);
insert into subcategory(description, active, category_Id) values('Medical Detail 2', false, 1);
